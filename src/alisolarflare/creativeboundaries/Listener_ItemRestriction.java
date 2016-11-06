package alisolarflare.creativeboundaries;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCreativeEvent;

public class Listener_ItemRestriction implements Listener {

	private Module_CreativeBoundaries module;

	public Listener_ItemRestriction(Module_CreativeBoundaries module) {
		this.module = module;
	}
	
	@EventHandler
	public void onItemTake(InventoryCreativeEvent event){
		List<Player> cbCreatives = module.cbCreatives;
		
	}

}
