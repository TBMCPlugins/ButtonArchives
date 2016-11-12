package alisolarflare.components.creativeboundaries.listeners;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCreativeEvent;

import alisolarflare.components.creativeboundaries.CreativeBoundariesComponent;

public class ItemRestrictionListener implements Listener {

	private CreativeBoundariesComponent module;

	public ItemRestrictionListener(CreativeBoundariesComponent module) {
		this.module = module;
	}
	
	@EventHandler
	public void onItemTake(InventoryCreativeEvent event){
		List<Player> cbCreatives = module.cbCreatives;
		
	}

}
