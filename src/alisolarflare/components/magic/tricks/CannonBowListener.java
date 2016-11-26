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
	JavaPlugin plugin;
	public CannonBowListener(JavaPlugin plugin){
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onProjectileLaunch(ProjectileLaunchEvent event){
		if(event.getEntity().getType() != EntityType.ARROW)
			return;
		Arrow arrow = (Arrow) event.getEntity();
		if (!(arrow.isCritical()) || !(arrow.getShooter() instanceof Player))
			return;
		Player player = (Player) arrow.getShooter();
		ItemStack bow;
		if ((bow = player.getInventory().getItemInMainHand()).getType() != Material.BOW)
			return;
		if (!bow.containsEnchantment(Enchantment.PROTECTION_EXPLOSIONS))
			return;
		if(!(bow.getEnchantmentLevel(Enchantment.PROTECTION_EXPLOSIONS) == 10))
			return;
		if (!bow.getItemMeta().getDisplayName().toUpperCase().contains("CANNON BOW"))
			return;
		if (!player.getInventory().contains(Material.TNT))
			return;
			
		TNTPrimed tnt = (TNTPrimed) arrow.getWorld().spawnEntity(arrow.getLocation(), EntityType.PRIMED_TNT);
		tnt.setVelocity(player.getEyeLocation().getDirection().normalize().multiply(2.0));
		tnt.setCustomName("CANNON BOW TNT");
		tnt.setFuseTicks(20);
		
		player.setVelocity(player.getEyeLocation().getDirection().normalize().multiply(-1));
		player.getWorld().playSound(player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 2.0F, 0);
		player.getWorld().spawnParticle(Particle.EXPLOSION_NORMAL, player.getLocation(), 1);
		arrow.remove();
		return;
		
	}

	@EventHandler
	public void onTnTExplode(EntityExplodeEvent event) {
		if (event.getEntityType() != EntityType.PRIMED_TNT)
			return;
		if (!event.getEntity().getCustomName().equals("CANNON BOW TNT"))
			return;
		Location loc = event.getEntity().getLocation();
		event.getEntity().getWorld().createExplosion(loc.getX(), loc.getY(), loc.getZ(), 3, false, false);
		event.setCancelled(true);
			
		
	}
}