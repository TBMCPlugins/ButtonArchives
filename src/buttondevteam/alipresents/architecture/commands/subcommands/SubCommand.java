package buttondevteam.alipresents.architecture.commands.subcommands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class SubCommand {
	public boolean run(CommandSender sender, String label, String[] args){
		if (getPlayerOnly() && (sender instanceof Player))
			return false;
			
		if (getModOnly() && (sender.hasPermission("Moderator")))
			return false;
		
		return onCommand((Player) sender, label, args);
	}
	protected abstract boolean onCommand(Player player, String label, String[] args);
	public abstract boolean getPlayerOnly();
	public abstract boolean getModOnly();
	public abstract String[] GetHelpText(String alias);
}
