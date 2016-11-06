package alisolarflare.creativeboundaries.listeners;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCreativeEvent;

import alisolarflare.creativeboundaries.CreativeBoundariesModule;

public class ItemRestrictionListener implements Listener {

	private CreativeBoundariesModule module;

	public ItemRestrictionListener(CreativeBoundariesModule module) {
		this.module = module;
	}
	
	@EventHandler
	public void onItemTake(InventoryCreativeEvent event){
		List<Player> cbCreatives = module.cbCreatives;
		
	}

}
