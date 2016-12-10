package alisolarflare.components.fruit;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
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
			case 1:
				world.dropItem(location, new ItemStack(Material.CARROT_ITEM));
				break;
			case 2: 
				world.dropItem(location, new ItemStack(Material.BEETROOT_SEEDS));
				break;
			case 3:
				world.dropItem(location, new ItemStack(Material.POTATO_ITEM));
				break;
			case 4: 
				world.dropItem(location, new ItemStack(Material.FEATHER));
				break;
			case 5: 
				world.dropItem(location, new ItemStack(Material.YELLOW_FLOWER));
				break;
			default:
				break;
			}
		}
	}
}
