package buttondevteam.alipresents.components.alilinks.commands;

import org.bukkit.entity.Player;

import buttondevteam.alipresents.architecture.commands.PlayerCommand;
import buttondevteam.alipresents.components.alilinks.AliLinkAPI;
import buttondevteam.alipresents.components.alilinks.entities.Link;

public class ListLinks extends PlayerCommand {
	@Override
	public boolean OnCommand(Player player, String alias, String[] args) {
		for (Link link : AliLinkAPI.linkList){
			player.sendMessage(link.toString());
		}
		return false;
	}
	@Override
	public String GetCommandPath() {
		return "alilink listlinks";
	}

}
