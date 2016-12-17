package buttondevteam.alipresents.components.flaircolour;

import org.bukkit.DyeColor;

import com.earth2me.essentials.User;

public class FlairColourAPI {
	public static void recolourPlayer(User user, DyeColor dyecolour){
		String name = user._getNickname();
		String sanitizedName = "";
		for(int i = 0; i < name.length(); i++){
			if (name.charAt(i) == '§'){
				i++;//Skips the data value, the 4 in "§4Alisolarflare"
			}else{
				sanitizedName += name.charAt(i);
			}
		}

		String colourCode = dyeToColourCode(dyecolour);
		String newName = colourCode + sanitizedName;

		user.setNickname(newName);
		user.sendMessage("Adding the colour " + colourCode + dyecolour.name() + "§f!");
		user.sendMessage("Your name is now: " + user.getNickname() +"!");
	}
	public static String colourShiftRight(String input, DyeColor newDye){
		return dyeToColourCode(newDye) + shiftColoursRight(input);
	}
	private static String shiftColoursRight(String input){
		String output = "";
		if (input.length() <= 2){
			return input;
		}
		for(int ptr = 0; ptr < input.length(); ptr++){
			if (input.charAt(ptr) == '§'){
				boolean foundLegalCharacter = false;
				for (int i = ptr + 2; i < input.length(); i++){
					if (input.charAt(i - 1) == '§' || input.charAt(i) == '§'){
						continue;
					}else{//SecondPtr points to a legal character
						foundLegalCharacter = true;
						output += input.charAt(i) + input.substring(ptr, i);
						ptr = i;
						break;
					}
				}
				if (foundLegalCharacter == false){
					break;
				}
			}else{
				output += input.charAt(ptr); //copy over
			}
		}

		return output;
	}
	public static String dyeToColourCode(DyeColor dyeColour){
		String colourChanger;
		switch(dyeColour){
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
			colourChanger = "§b"; 
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
		return colourChanger;
	}
}
