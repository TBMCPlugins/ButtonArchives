package alisolarflare.components.flairdoor;

import org.bukkit.DyeColor;

import com.earth2me.essentials.User;

public class FlairColouringAPI {
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
	public static String shiftColoursRight(String input){
		String output = "";
		for(int ptr = 0; ptr < input.length(); ptr++){
			if (input.charAt(ptr) == '§'){
				System.out.println(input);
				for (int i = ptr + 2; i < input.length(); i++){
					if (i < input.length() - 2){
						if (input.charAt(i - 1) == '§' || input.charAt(i) == '§'){
							continue;
						}else{//SecondPtr points to a legal character
							System.out.println("Found legal character! "+input.charAt(i));
							System.out.println("Changing String!"+ output + "<" +input.substring(ptr, i)+ "|" +input.charAt(i) + ">" + input.substring(i+1, input.length()));
							output += input.charAt(i) + input.substring(ptr, i);
							System.out.println("Changed String: " + output);

							ptr = i;
							break;
						}
					}else{
						if (i < input.length() - 1){
							output += input.charAt(i) + input.substring(ptr, i);
							System.out.println(output);
							ptr = i++;
						}else{
							output += input.charAt(i) + input.substring(ptr, i);
							ptr = i;
						}
					}

				}
			}else{
				output += input.charAt(ptr); //copy over
			}
		}

		return output;
	}
	public static void main(String[] args){
		String yo = "§3A§4lisolarflare";
		for(int i = 0; i < 20; i++){
			yo = shiftColoursRight(yo);
			System.out.println(yo);
			System.out.println("--------------------");
		}
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
		return colourChanger;
	}
}
