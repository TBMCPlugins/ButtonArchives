package alisolarflare.components.flairdoor.listeners;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.material.Wool;
import org.bukkit.plugin.java.JavaPlugin;

import com.earth2me.essentials.Essentials;
import com.earth2me.essentials.User;

import alisolarflare.components.flairdoor.FlairDoorComponent;

public class PortalListener implements Listener{
	public JavaPlugin plugin;

	Essentials essentials;

	private FlairDoorComponent component;
	
	public PortalListener(JavaPlugin plugin, FlairDoorComponent component) {
		this.plugin = plugin;
		this.component = component;
		this.essentials = ((Essentials) Bukkit.getPluginManager().getPlugin("Essentials"));
	}
	@EventHandler
	public void onPortalEnter(PlayerPortalEvent event){
		if(!(event.getPlayer() instanceof Player)){
			return;
		}
		
		Player player = event.getPlayer();
		
		if(!(component.playersToBeFlaired.contains(player))){
			return;
		}
		
		event.setTo(player.getLocation());
		
		int x = player.getLocation().getBlockX();
		int y = player.getLocation().getBlockY();
		int z = player.getLocation().getBlockZ();
		
		Block HigherBlock = player.getWorld().getBlockAt(x,y-2,z); //Block under obsidian
		Block MiddleBlock = player.getWorld().getBlockAt(x,y-3,z); //Block under higher block
		Block BottomBlock = player.getWorld().getBlockAt(x,y-4,z); //Block under middle block
		
		if(HigherBlock.getType() == Material.STONE){
			recolourPlayer(player, DyeColor.GRAY);
			return;
		}
		
		DyeColor woolColour = DyeColor.PINK; //Illegal value
		if(HigherBlock.getType() == Material.WOOL){
			woolColour = ((Wool) HigherBlock.getState().getData()).getColor();
		}else if(MiddleBlock.getType() == Material.WOOL){
			woolColour = ((Wool) MiddleBlock.getState().getData()).getColor();
		}else if (BottomBlock.getType() == Material.WOOL){
			woolColour = ((Wool) BottomBlock.getState().getData()).getColor();
		}else{
			return;
		}
		
		recolourPlayer(player, woolColour);
		
	}
	public void recolourPlayer(Player player, DyeColor dyecolour){
		User user = essentials.getUser(player);
		
		String name = user._getNickname();
		String sanitizedName = "";
		for(int i = 0; i < name.length(); i++){
			if (name.charAt(i) != '§'){
				sanitizedName += name.charAt(i);
			}else{
				i++;
			}
		}
		
		String colourChanger = "";
		
		switch(dyecolour){
		case GRAY:        
			colourChanger = "§7"; 
			break;
		case RED:
			colourChanger = "§4"; 
			break;
		case ORANGE:      
			colourChanger = "§6"; 
			break;
		case YELLOW:
			colourChanger = "§e"; 
			break;
		case LIME:
			colourChanger = "§a"; 
			break;
		case GREEN:
			colourChanger = "§a"; 
			break;
		case CYAN:
			colourChanger = "§9"; 
			break;
		case LIGHT_BLUE:
			colourChanger = "§9"; 
			break;
		case BLUE: 
			colourChanger = "§9"; 
			break;
		case PURPLE:
			colourChanger = "§5"; 
			break;
		case WHITE:
			colourChanger = "§f"; 
			break;
		default:
			player.sendMessage("ERROR, PORTAL HAS INVALID UNDER-BLOCK");
			break;
		}
		
		String newName = colourChanger + sanitizedName;
		user.setNickname(newName);
		
		player.sendMessage("Adding the colour " + colourChanger + dyecolour.name() + "§f!");
		player.sendMessage("Your name is now: " + user.getNickname() +"!");
		
		component.playersToBeFlaired.remove(player.getName());
	}
}
