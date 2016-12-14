package buttondevteam.alipresents.components.fruit;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class GrassBreakListener implements Listener {
	/*public enum fruit {	
		Material.POTATO_ITEM,
		Material.MELON_SEEDS,
		Material.PUMPKIN_SEEDS,
		Material.COCOA,
		Material.BEETROOT_SEEDS,
		Material.NETHER_WARTS,
		Material.SEEDS
	};*/
	@EventHandler
	public void onGrassBreak(BlockBreakEvent event){

		
		if (event.getBlock().getType().equals(Material.LONG_GRASS)){

			Location location = event.getBlock().getLocation();
			World world = event.getBlock().getWorld();
			/*
			switch(world.getBiome(location.getBlockX(), location.getBlockZ())){



			//JUNGLES
			case JUNGLE:
			case JUNGLE_EDGE:
			case JUNGLE_HILLS:
			case MUTATED_JUNGLE:
			case MUTATED_JUNGLE_EDGE:
				world.dropItem(location, new ItemStack(Material.COCOA));
				break;
				
				
			//ROOFED FOREST
			case ROOFED_FOREST:
			case MUTATED_ROOFED_FOREST:
				world.dropItem(location, new ItemStack(Material.CARROT_ITEM));
				break;


			//GENERAL FOREST
			case FOREST:
			case FOREST_HILLS:
			case MUTATED_FOREST:
			case BIRCH_FOREST:
			case BIRCH_FOREST_HILLS:
			case MUTATED_BIRCH_FOREST:
			case MUTATED_BIRCH_FOREST_HILLS:
				world.dropItem(location, new ItemStack(Material.SEEDS));
				break;
			case PLAINS:
			case MUTATED_PLAINS:
				world.dropItem(location, new ItemStack(Material.SEEDS));
				//DROP GRASS
				break;


			//SWAMPS
			case SWAMPLAND:
			case MUTATED_SWAMPLAND:
				world.dropItem(location, new ItemStack(Material.POTATO));
				break;


			//DESERT, DRY SHIT
			case DESERT:
			case DESERT_HILLS:
			case MUTATED_DESERT:
			case MESA:
			case MESA_CLEAR_ROCK:
			case MESA_ROCK:
			case MUTATED_MESA:
			case MUTATED_MESA_CLEAR_ROCK:
			case MUTATED_MESA_ROCK:
			case SAVANNA:
			case SAVANNA_ROCK:
			case MUTATED_SAVANNA:
			case MUTATED_SAVANNA_ROCK:
				world.dropItem(location, new ItemStack(Material.DEAD_BUSH));
				//DROP... dead shrub
				break;


			//Mountain Shit
			case EXTREME_HILLS:
			case EXTREME_HILLS_WITH_TREES:
			case MUTATED_EXTREME_HILLS:
			case MUTATED_EXTREME_HILLS_WITH_TREES:
			case SMALLER_EXTREME_HILLS:
			case STONE_BEACH:
				//What the fuck grows in mountains? Rocks?
				break;


			//COLLLLLLLD FUCKERS
			case TAIGA:
			case TAIGA_COLD:
			case TAIGA_COLD_HILLS:
			case TAIGA_HILLS:
			case COLD_BEACH:
			case ICE_FLATS:
			case ICE_MOUNTAINS:
			case MUTATED_ICE_FLATS:
			case FROZEN_OCEAN:
			case FROZEN_RIVER:
			case MUTATED_TAIGA:
			case MUTATED_TAIGA_COLD:
			case REDWOOD_TAIGA:
			case REDWOOD_TAIGA_HILLS:
			case MUTATED_REDWOOD_TAIGA:
			case MUTATED_REDWOOD_TAIGA_HILLS:
				world.dropItem(location, new ItemStack(Material.DIRT));
				break;


			//OCEAN
			case DEEP_OCEAN:
			case OCEAN:
				//DROP... why the fuck is there grass in deep ocean?
				break;


			//BEACHES
			case BEACHES:
			case RIVER:
				//DROP A SEASHELL
				break;


			//MUSHROOM ISLANDS
			case MUSHROOM_ISLAND:
			case MUSHROOM_ISLAND_SHORE:
				world.dropItem(location, new ItemStack(Material.BROWN_MUSHROOM));
				break;

			//WEIRD SHIT
			case HELL:
			case SKY:
			case VOID:
				break;


			default:
				break;

			}*/

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
