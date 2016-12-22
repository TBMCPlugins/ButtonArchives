package buttondevteam.alipresents.components.magic.tricks;

import java.lang.reflect.Field;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftLivingEntity;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftTNTPrimed;
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

import net.minecraft.server.v1_11_R1.EntityLiving;
import net.minecraft.server.v1_11_R1.EntityTNTPrimed;

public class CannonBowListener implements Listener {
	public static double SpeedMultiplier = 1.5;
	public static double minforce = 0.2;
	public static int fuseticks = 40;
	public final static String launchedTNTName = "CANNON BOW TNT:42170";
	public CannonBowListener(JavaPlugin plugin){
		FileConfiguration config = plugin.getConfig();
		
		if (config.isDouble("magic.cannonbow.speedmultiplier"))
			SpeedMultiplier = config.getDouble("magic.cannonbow.speedmultiplier");
		
		if (config.isDouble("magic.cannonbow.minforce"))
			minforce = config.getDouble("magic.cannonbow.minforce");
		
		if (config.isInt("magic.cannonbow.fuseticks"))
			fuseticks = config.getInt("magic.cannonbow.fuseticks");
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
		if (event.getForce() < minforce){
			
			arrow.getWorld().spawnParticle(Particle.SMOKE_NORMAL, player.getLocation(), 30);
			arrow.getWorld().playSound(player.getLocation(), Sound.BLOCK_LADDER_BREAK, 1.0F, -14);
			
		}else{
			TNTPrimed tnt = (TNTPrimed) arrow.getWorld().spawnEntity(arrow.getLocation(), EntityType.PRIMED_TNT);

			// Change via NMS the source of the TNT by the player
			EntityLiving nmsPlayer = (EntityLiving) (((CraftLivingEntity) player).getHandle());
			EntityTNTPrimed nmsTNT = (EntityTNTPrimed) (((CraftTNTPrimed) tnt).getHandle());
			try {
			    Field sourceField = EntityTNTPrimed.class.getDeclaredField("source");
			    sourceField.setAccessible(true);
			    sourceField.set(nmsTNT, nmsPlayer);
			} catch (Exception ex) {
			    ex.printStackTrace();
			}
			
			
			tnt.setVelocity(playerVector.multiply(SpeedMultiplier).multiply(event.getForce()));
			tnt.setCustomName(launchedTNTName);
			tnt.setFuseTicks(fuseticks);
			
			//Player Recoil
			player.setVelocity(player.getEyeLocation().getDirection().normalize().multiply(-1));
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
}