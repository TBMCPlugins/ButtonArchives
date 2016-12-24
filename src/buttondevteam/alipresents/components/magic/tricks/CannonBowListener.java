package buttondevteam.alipresents.components.magic.tricks;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public class CannonBowListener implements Listener {
	private static String savePath = "magic.cannonbow";
	
	private static double maxSpeedMultiplier = 4;
	private static double minSpeedMultiplier = 0;
	private static double defaultSpeedMultiplier = 1;
	private static String speedMultiplierPath = savePath + ".speedmultiplier";

	private static int maxFuseTicks = 400;
	private static int minFuseTicks = 0;
	private static int defaultFuseTicks = 30;
	private static String fuseTicksPath = savePath + ".fuseticks";

	private static double maxMinForce = 1;
	private static double minMinForce = 0;
	private static double defaultMinForce = 0.2;
	private static String minForcePath = savePath + ".minforce";

	private static double maxRecoil = 20;
	private static double minRecoil = -5;
	private static double defaultRecoil = 1;
	private static String recoilPath = savePath + ".recoil";

	private static boolean defaultIsDestructive = false;
	private static String isDestructivePath = savePath + ".isdestructive";

	private static double speedMultiplier = defaultSpeedMultiplier;
	private static double minForce = defaultMinForce;
	private static int fuseTicks = defaultFuseTicks;
	private static double recoil = defaultRecoil;
	private static boolean isDestructive = defaultIsDestructive;

	public final static String launchedTNTName = "CANNON BOW TNT:42170";

	static FileConfiguration config;
	public CannonBowListener(JavaPlugin plugin){
		config = plugin.getConfig();

		if (config.isDouble(speedMultiplierPath))
			setSpeedMultiplier(config.getDouble(speedMultiplierPath));

		if (config.isDouble(minForcePath))
			setMinforce(config.getDouble(minForcePath));

		if (config.isInt(fuseTicksPath))
			setFuseticks(config.getInt(fuseTicksPath));

		if (config.isDouble(recoilPath))
			setRecoil(config.getDouble(recoilPath));

		if (config.isBoolean(isDestructivePath))
			setIsDestructive(config.getBoolean(isDestructivePath));
	}

	@EventHandler
	public void onProjectileLaunch(EntityShootBowEvent event){
		//Entity Sanitation
		if(event.getProjectile().getType() != EntityType.ARROW)return;

		//Arrow Sanitation
		Arrow arrow = (Arrow) event.getProjectile();
		if (!(arrow.getShooter() instanceof Player))return;

		//Player Sanitation
		Player player = (Player) arrow.getShooter();
		if (!player.getInventory().contains(Material.TNT))return;

		//Bow Sanitation
		ItemStack bow;
		if (!((bow = player.getInventory().getItemInMainHand()).getType() == Material.BOW))return;
		if (!(bow.containsEnchantment(Enchantment.PROTECTION_EXPLOSIONS)))return;
		if (!(bow.getEnchantmentLevel(Enchantment.PROTECTION_EXPLOSIONS) == 10))return;
		if (!(bow.getItemMeta().getDisplayName().toUpperCase().contains("CANNON BOW")))return;

		//TNT Spawning
		Vector playerVector = player.getEyeLocation().getDirection().normalize();
		Location playerLocation = player.getLocation();
		if (event.getForce() < getMinforce()){

			//Smoke cloud if draw is too low
			arrow.getWorld().spawnParticle(Particle.SMOKE_NORMAL, playerLocation, 30);
			arrow.getWorld().playSound(playerLocation, Sound.BLOCK_LADDER_BREAK, 1.0F, -7);

		}else{
			//Spawn TNT
			TNTPrimed tnt = (TNTPrimed) arrow.getWorld().spawnEntity(arrow.getLocation(), EntityType.PRIMED_TNT);
			/*
			// Change via NMS the source of the TNT by the player
			EntityLiving nmsPlayer = (EntityLiving) (((CraftLivingEntity) player).getHandle());
			EntityTNTPrimed nmsTNT = (EntityTNTPrimed) (((CraftTNTPrimed) tnt).getHandle());
			try {
			    Field sourceField = EntityTNTPrimed.class.getDeclaredField("source");
			    sourceField.setAccessible(true);
			    sourceField.set(nmsTNT, nmsPlayer);
			} catch (Exception ex) {
			    ex.printStackTrace();
			}*/

			//
			tnt.setVelocity(playerVector.multiply(getSpeedMultiplier()).multiply(event.getForce()));
			tnt.setCustomName(launchedTNTName);
			tnt.setFuseTicks(getFuseticks());

			//Player Recoil
			player.setVelocity(playerVector.multiply(-1).multiply(getRecoil()));
			player.getWorld().playSound(playerLocation, Sound.ENTITY_GENERIC_EXPLODE, 1.0F, 0);
			player.getWorld().spawnParticle(Particle.EXPLOSION_NORMAL, playerLocation, 2);

		}
		arrow.remove();


		return;

	}

	@EventHandler
	public void onTnTExplode(EntityExplodeEvent event) {
		if (event.getEntityType() != EntityType.PRIMED_TNT) return;
		if (event.getEntity().getCustomName() != "CANNON BOW TNT:42170") return;

		if (isDestructive == true){
			Location loc = event.getEntity().getLocation();
			event.getEntity().getWorld().createExplosion(loc.getX(), loc.getY(), loc.getZ(), 3, false, false);
			event.setCancelled(true);
		}


	}


	public static double getSpeedMultiplier() {
		return speedMultiplier;
	}

	public static void setSpeedMultiplier(double multiplier, CommandSender sender){

		if (multiplier > maxSpeedMultiplier) sender.sendMessage("SpeedMultiplier is too Large! Setting multiplier to "+ maxSpeedMultiplier);
		if (multiplier < maxSpeedMultiplier) sender.sendMessage("SpeedMultiplier is too Small! Setting multiplier to "+ minSpeedMultiplier);

		setSpeedMultiplier(multiplier, sender);
		sender.sendMessage("SpeedMultiplier set to " + getSpeedMultiplier());
	}

	public static void setSpeedMultiplier(double multiplier) {

		if (multiplier > maxSpeedMultiplier) multiplier = maxSpeedMultiplier;
		if (multiplier < minSpeedMultiplier) multiplier = minSpeedMultiplier;
		config.set(speedMultiplierPath, multiplier);
		speedMultiplier = multiplier;

	}


	public static double getMinforce() {
		return minForce;
	}
	public static void setMinForce(double minforce, CommandSender sender){

		if (minforce > maxMinForce) sender.sendMessage("MinForce is too large! Setting it to " + maxMinForce);
		if (minforce < minMinForce) sender.sendMessage("MinForce is too small! Setting it to " + minMinForce);
		setMinforce(minforce);
		sender.sendMessage("MinForce set to " + getMinforce());

	}
	public static void setMinforce(double minforce) {

		if (minforce > maxMinForce) minforce = maxMinForce;
		if (minforce < minMinForce) minforce = minMinForce;
		config.set(minForcePath, minforce);
		CannonBowListener.minForce = minforce;
	}


	public static int getFuseticks() {
		return fuseTicks;
	}
	public static void setFuseticks(int fuseticks, CommandSender sender){

		if (fuseticks > maxFuseTicks) sender.sendMessage("Fuseticks is too large! Setting it to " + maxFuseTicks);
		if (fuseticks < minFuseTicks) sender.sendMessage("Fuseticks is too small! Setting it to " + minFuseTicks);
		setFuseticks(fuseticks);
		sender.sendMessage("FuseTicks set to " + getFuseticks());

	}
	public static void setFuseticks(int fuseticks) {

		if (fuseticks > maxFuseTicks) fuseticks = maxFuseTicks;
		if (fuseticks < minFuseTicks) fuseticks = minFuseTicks;
		config.set(fuseTicksPath, fuseticks);
		CannonBowListener.fuseTicks = fuseticks;

	}


	public static double getRecoil() {
		return recoil;
	}
	public static void setRecoil(double recoil, CommandSender sender){

		if (recoil > maxRecoil) sender.sendMessage("Recoil is too large! Setting it to " + maxRecoil);
		if (recoil < maxRecoil) sender.sendMessage("Recoil is too small! Setting it to " + minRecoil);
		setRecoil(recoil);
		sender.sendMessage("Recoil set to " + getRecoil());

	}
	public static void setRecoil(double recoil) {

		if (recoil > maxRecoil) recoil = maxRecoil;
		if (recoil < minRecoil) recoil = minRecoil;
		config.set(recoilPath, recoil);
		CannonBowListener.recoil = recoil;

	}


	public static boolean getIsDestructive(){
		return isDestructive;
	}
	public static void setIsDestructive(String input){
		if(input.startsWith("T") || input.startsWith("t")) setIsDestructive(true);
		if(input.startsWith("F") || input.startsWith("f")) setIsDestructive(false);

	}
	public static void setIsDestructive(boolean isDestructive){
		CannonBowListener.isDestructive = isDestructive;
		config.set(speedMultiplierPath, isDestructive);
	}
}