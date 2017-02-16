package buttondevteam.alipresents.components.alilinks.commands;

import org.bukkit.command.CommandSender;

import buttondevteam.alipresents.architecture.commands.CommandBlockCommand;
import buttondevteam.alipresents.components.alilinks.AliLinkAPI;
import buttondevteam.alipresents.components.alilinks.AliLinkComponent;

public class Press extends CommandBlockCommand {
	@Override
	public String GetCommandPath() {
		return "alilink press";
	}

	@Override
	public String[] GetHelpText(String alias){
		return new String[] {
			"Usage:  type /"+this.GetCommandPath()+" <frequency> activate a wireless redstone block listening",
			"to your frequency of choice"
		};
	}

	@Override
	public boolean OnCommand(CommandSender sender, String alias, String[] args) {
		if (args.length < 1)
			return false;
		return AliLinkAPI.sendPressEvent(sender, args, AliLinkComponent.getPlugin());
	}

	
}
