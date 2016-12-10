package alisolarflare.components.fruit;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class GrassBreakListener implements Listener {
	@EventHandler
	public void onGrassBreak(BlockBreakEvent event){

		
		if (event.getBlock().getType().equals(Material.LONG_GRASS)){

			Location location = event.getBlock().getLocation();
			World world = event.getBlock().getWorld();
			
			switch((int) (Math.random()* 50)){
			case 1: // 2% chance
				world.dropItem(location, new ItemStack(Material.CARROT));
				break;
			case 2: // 2% chance
				world.dropItem(location, new ItemStack(Material.BEETROOT_SEEDS));
				break;
			case 3: // 2% chance
				world.dropItem(location, new ItemStack(Material.POTATO));
				break;
			case 4: // 2% chance
				world.dropItem(location, new ItemStack(Material.FEATHER));
				break;
			case 5: // 2% chance
				world.dropItem(location, new ItemStack(Material.YELLOW_FLOWER));
				break;
			default:
				break;
			}
		}
	}
}
