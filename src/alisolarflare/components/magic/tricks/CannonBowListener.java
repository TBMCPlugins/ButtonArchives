package alisolarflare.components.magic.tricks;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class CannonBowListener implements Listener {
	public final static String launchedTNTName = "CANNON BOW TNT:42170";
	JavaPlugin plugin;
	public CannonBowListener(JavaPlugin plugin){
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onProjectileLaunch(ProjectileLaunchEvent event){
		//ENTITY SANITATION
		if(event.getEntity().getType() != EntityType.ARROW)return;
		
		//ARROW SANITATION
		Arrow arrow = (Arrow) event.getEntity();
		if (!(arrow.isCritical()) || !(arrow.getShooter() instanceof Player))return;
		
		//PLAYER SANITATION
		Player player = (Player) arrow.getShooter();
		if (!player.getInventory().contains(Material.TNT))return;
		
		//BOW SANITATION
		ItemStack bow;
		if (!((bow = player.getInventory().getItemInMainHand()).getType() == Material.BOW))return;
		if (!(bow.containsEnchantment(Enchantment.PROTECTION_EXPLOSIONS)))return;
		if (!(bow.getEnchantmentLevel(Enchantment.PROTECTION_EXPLOSIONS) == 10))return;
		if (!(bow.getItemMeta().getDisplayName().toUpperCase().contains("CANNON BOW")))return;
			
		TNTPrimed tnt = (TNTPrimed) arrow.getWorld().spawnEntity(arrow.getLocation(), EntityType.PRIMED_TNT);
		tnt.setVelocity(player.getEyeLocation().getDirection().normalize().multiply(1.0));
		tnt.setCustomName(launchedTNTName);
		tnt.setFuseTicks(40);
		
		player.setVelocity(player.getEyeLocation().getDirection().normalize().multiply(-1));
		player.getWorld().playSound(player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 2.0F, 0);
		player.getWorld().spawnParticle(Particle.EXPLOSION_HUGE, player.getLocation(), 2);
		
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