package alisolarflare.components.magic.tricks;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;

public class CannonBowListener implements Listener {
	
	public CannonBowListener(){
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
			
		Entity tnt = arrow.getWorld().spawnEntity(arrow.getLocation(), EntityType.PRIMED_TNT);
		tnt.setVelocity(arrow.getVelocity());
		arrow.remove();
		
		
		return;
		
	}
}