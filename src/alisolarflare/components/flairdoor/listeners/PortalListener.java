package alisolarflare.components.flairdoor.listeners;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.material.MaterialData;
import org.bukkit.material.Wool;
import org.bukkit.plugin.java.JavaPlugin;

import com.earth2me.essentials.Essentials;
import com.earth2me.essentials.User;

public class PortalListener implements Listener{
	public static List<String> playersToBeFlaired = new ArrayList<String>();
	public JavaPlugin plugin;

	Essentials essentials;
	
	public PortalListener(JavaPlugin plugin) {
		this.plugin = plugin;
		this.essentials = ((Essentials) Bukkit.getPluginManager().getPlugin("Essentials"));
	}
	@EventHandler
	public void onPortalEnter(PlayerPortalEvent event){
		//SANITATION - Player
		if(!(event.getPlayer() instanceof Player)){
			return;
		}
		
		//INIT - Player
		Player player = event.getPlayer();
		
		//SANITATION - PlayersToBeFlaired
		if(!(playersToBeFlaired.contains(player.getName()))){
			return;
		}
		player.sendMessage("-MAY THE FLAIRING COMMENCE-");
		event.setTo(player.getLocation());
		
		//INIT - x,y,z
		int x = player.getLocation().getBlockX();
		int y = player.getLocation().getBlockY();
		int z = player.getLocation().getBlockZ();
		
		//INIT - Blocks Under Portal
		Block HigherBlock = player.getWorld().getBlockAt(x,y-2,z);
		Block MiddleBlock = player.getWorld().getBlockAt(x,y-3,z);
		Block BottomBlock = player.getWorld().getBlockAt(x,y-4,z);
		
		//RECOLOUR PLAYER
		if(HigherBlock.getType() == Material.STONE){
			recolourPlayer(player, DyeColor.GRAY);
			
		//TOP BLOCK IS WOOL?
		}else if(HigherBlock.getType() == Material.WOOL){
			Wool wool = (Wool) HigherBlock.getState().getData();
			recolourPlayer(player, wool.getColor());
		
		//MIDDLE BLOCK IS WOOL?
		}else if(MiddleBlock.getType() == Material.WOOL){
			MaterialData mData = MiddleBlock.getState().getData();
			Wool wool = (Wool) mData;

			recolourPlayer(player, wool.getColor());
		
		//BOTTOM BLOCK IS WOOL?
		}else if (BottomBlock.getType() == Material.WOOL){
			Wool wool = (Wool) BottomBlock.getState().getData();
			recolourPlayer(player, wool.getColor());
		}
		
	}
	public void recolourPlayer(Player player, DyeColor dyecolour){
		User user = essentials.getUser(player);
		
		String name = user._getNickname();
		String tempName = "";
		for(int i = 0; i < name.length(); i++){
			if (name.charAt(i) != '§'){
				tempName += name.charAt(i);
			}else{
				i++;
			}
		}
		name = tempName;
		
		switch(dyecolour){
		case GRAY:
			player.sendMessage("Adding §7GRAY!§f");
			name = "§7" + name;
			break;
		case RED:
			player.sendMessage("Adding §4RED!§f");
			name = "§4" + name;
			break;
		case ORANGE:
			player.sendMessage("Adding §6ORANGE!§f");
			name = "§6" + name;
			break;
		case YELLOW:
			player.sendMessage("Adding §eYELLOW!§f");
			name = "§e" + name;
			break;
		case LIME:
		case GREEN:
			player.sendMessage("Adding §aGREEN!§f");
			name = "§a" + name;
			break;
		case CYAN:
		case LIGHT_BLUE:
		case BLUE:
			player.sendMessage("Adding §9BLUE!§f");
			name = "§9" + name;
			break;
		case PURPLE:
			player.sendMessage("Adding §5PURPLE!§f");
			name = "§5" + name;
			break;
		case WHITE:
			player.sendMessage("Adding §fWHITE!§f");
			name = "§f" + name;
		default:
			player.sendMessage("ERROR, PORTAL HAS INVALID UNDER-BLOCK");
			break;
		}
		user.setNickname(name);
		player.sendMessage("Your name is now: " + user.getNickname() +"!");
		playersToBeFlaired.remove(player.getName());
	}
}
