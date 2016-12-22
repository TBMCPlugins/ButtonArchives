package buttondevteam.alipresents.components.magic.tricks;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
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
	private static double SpeedMultiplier = 1.5;
	private static double minforce = 0.2;
	private static int fuseticks = 40;
	private static double recoil = 1;
	public final static String launchedTNTName = "CANNON BOW TNT:42170";
	public CannonBowListener(JavaPlugin plugin){
		FileConfiguration config = plugin.getConfig();
		
		if (config.isDouble("magic.cannonbow.speedmultiplier"))
			setSpeedMultiplier(config.getDouble("magic.cannonbow.speedmultiplier"));
		
		if (config.isDouble("magic.cannonbow.minforce"))
			setMinforce(config.getDouble("magic.cannonbow.minforce"));
		
		if (config.isInt("magic.cannonbow.fuseticks"))
			setFuseticks(config.getInt("magic.cannonbow.fuseticks"));
		
		if (config.isDouble("magic.cannonbow.recoil"))
			setRecoil(config.getDouble("magic.cannonbow.recoil"));
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
		if (event.getForce() < getMinforce()){
			
			//Smoke cloud if draw is too low
			arrow.getWorld().spawnParticle(Particle.SMOKE_NORMAL, player.getLocation(), 30);
			arrow.getWorld().playSound(player.getLocation(), Sound.BLOCK_LADDER_BREAK, 1.0F, -7);
			
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
			player.setVelocity(player.getEyeLocation().getDirection().normalize().multiply(-1).multiply(getRecoil()));
			player.getWorld().playSound(player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1.0F, 0);
			player.getWorld().spawnParticle(Particle.EXPLOSION_NORMAL, player.getLocation(), 2);
			
		}
		arrow.remove();
		
		
		return;
		
	}

	@EventHandler
	public void onTnTExplode(EntityExplodeEvent event) {
		if (event.getEntityType() != EntityType.PRIMED_TNT) return;
		if (event.getEntity().getCustomName() != "CANNON BOW TNT:42170") return;
		
		Location loc = event.getEntity().getLocation();
		event.getEntity().getWorld().createExplosion(loc.getX(), loc.getY(), loc.getZ(), 3, false, false);
		event.setCancelled(true);
			
		
	}

	public static double getSpeedMultiplier() {
		return SpeedMultiplier;
	}

	public static void setSpeedMultiplier(double speedMultiplier) {
		if (speedMultiplier > 4) speedMultiplier = 4;
		if (speedMultiplier < 0) speedMultiplier = 0;
		SpeedMultiplier = speedMultiplier;
	}

	public static double getMinforce() {
		return minforce;
	}

	public static void setMinforce(double minforce) {
		if (minforce > 1) minforce = 1;
		if (minforce < 0) minforce = 0;
		CannonBowListener.minforce = minforce;
	}

	public static int getFuseticks() {
		return fuseticks;
	}

	public static void setFuseticks(int fuseticks) {
		if (fuseticks > 400) fuseticks = 400;
		if (fuseticks < 0) fuseticks = 0;
		CannonBowListener.fuseticks = fuseticks;
	}

	public static double getRecoil() {
		return recoil;
	}

	public static void setRecoil(double recoil) {
		if (recoil > 20) recoil = 20;
		if (recoil < 0) recoil = 0;
		CannonBowListener.recoil = recoil;
	}
}