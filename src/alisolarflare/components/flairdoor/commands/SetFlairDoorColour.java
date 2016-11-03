package alisolarflare.components.flairdoor.commands;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.CommandSender;

import buttondevteam.lib.chat.TBMCCommandBase;

/**
 * @deprecated
 * @author Alisolarflare
 *
 */
public class SetFlairDoorColour extends TBMCCommandBase {
	public static String FlairDoorColorMode = "null";
	public static final List<String> COLOURMODES = Arrays.asList("red", "orange", "yellow", "green", "blue", "purple",
			"gray");

	@Override
	public boolean OnCommand(CommandSender sender, String label, String[] args) {
		if (args.length > 1) {
			sender.sendMessage("You must specify and argument, Red-Purple or Null.HHAHHAHAHAHHAHAHAHHA");
		}

		String firstCommand = args[0];
		firstCommand = firstCommand.toLowerCase();
		if (firstCommand.startsWith("e") || firstCommand.startsWith("gra") || firstCommand.startsWith("grey")) {
			sender.sendMessage("Flair Door Colour Mode set to gray");
			FlairDoorColorMode = "gray";
		} else if (firstCommand.startsWith("r")) {
			sender.sendMessage("Flair Door Colour Mode set to Red");
			FlairDoorColorMode = "red";
		} else if (firstCommand.startsWith("o")) {
			sender.sendMessage("Flair Door Colour Mode set to Orange");
			FlairDoorColorMode = "orange";
		} else if (firstCommand.startsWith("y")) {
			sender.sendMessage("Flair Door Colour Mode set to Yellow");
			FlairDoorColorMode = "yellow";
		} else if (firstCommand.startsWith("g")) {
			sender.sendMessage("Flair Door Colour Mode set to Green (use E for grey)");
			FlairDoorColorMode = "green";
		} else if (firstCommand.startsWith("b") || firstCommand.startsWith("i")) {
			sender.sendMessage("Flair Door Colour Mode set to Blue");
			FlairDoorColorMode = "blue";
		} else if (firstCommand.startsWith("v") || firstCommand.startsWith("p")) {
			sender.sendMessage("Flair Door Colour Mode set to Purple");
			FlairDoorColorMode = "purple";
		} else if (firstCommand.startsWith("n")) {
			sender.sendMessage("Flair Door Colour Mode set to Null");
			FlairDoorColorMode = "null";
		}
		return false;
	}

	@Override
	public String[] GetHelpText(String alias) { // TODO
		return new String[] { "" };
	}

	@Override
	public String GetCommandPath() {
		return "setflairdoorcolour";
	}

	@Override
	public boolean GetPlayerOnly() {
		return true;
	}

	@Override
	public boolean GetModOnly() {
		return false;
	}
}
