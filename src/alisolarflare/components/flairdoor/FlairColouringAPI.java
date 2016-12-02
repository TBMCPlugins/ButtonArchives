package alisolarflare.components.flairdoor;

import org.bukkit.DyeColor;

import com.earth2me.essentials.User;

public class FlairColouringAPI {

	public static void recolourPlayer(User user, DyeColor dyecolour){
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
		case WHITE:
			colourChanger = "§f";
			break;
		case SILVER:
			colourChanger = "§7";
			break;
		case GRAY:        
			colourChanger = "§8"; 
			break;
		case BLACK:
			colourChanger = "§0";
			break;
		case PINK:
			colourChanger = "§d";
			break;
		case RED:
			colourChanger = "§c"; 
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
			colourChanger = "§2"; 
			break;
		case LIGHT_BLUE:
			colourChanger = "&b"; 
			break;
		case CYAN:
			colourChanger = "§3"; 
			break;	
		case BLUE: 
			colourChanger = "§9"; 
			break;
		case PURPLE:
			colourChanger = "§5"; 
			break;
		case MAGENTA:
			colourChanger = "§d";
			break;
		case BROWN:
			colourChanger = "§4"; //Technically a dark red
			break;
		default:
			colourChanger = "§m";
			break;
		}
		
		String newName = colourChanger + sanitizedName;
		user.setNickname(newName);
		
		user.sendMessage("Adding the colour " + colourChanger + dyecolour.name() + "§f!");
		user.sendMessage("Your name is now: " + user.getNickname() +"!");
	}
}
