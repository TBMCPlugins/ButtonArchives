package buttondevteam.alipresents.components.alilinks.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import buttondevteam.alipresents.architecture.commands.BaseCommand;
import buttondevteam.alipresents.components.alilinks.AliLinkAPI;

public class AliLink extends BaseCommand{
	private JavaPlugin plugin;

	public AliLink(JavaPlugin plugin) {
		this.plugin = plugin;
	}
	@Override
	public boolean OnCommand(CommandSender player, String alias, String[] inputFrequencies) {
		if(inputFrequencies.length < 1)
			return false;
		
		switch (inputFrequencies[0].toLowerCase()){
		case "press": 
			return AliLinkAPI.sendPressEvent(player, inputFrequencies, plugin);
		case "set":   
			return AliLinkAPI.createAliLink((Player) player, inputFrequencies);
		default:
			return false;
		}
		
	}
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public String[] GetHelpText(String alias) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean GetPlayerOnly() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean GetModOnly() {
		// TODO Auto-generated method stub
		return false;
	}
	

	
	
}
