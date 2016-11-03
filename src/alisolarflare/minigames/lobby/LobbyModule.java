package alisolarflare.minigames.lobby;

import java.util.List;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.Module;
import alisolarflare.minigames.lobby.commands.ButtonFight;
import alisolarflare.minigames.lobby.commands.ButtonLeave;
import alisolarflare.minigames.lobby.commands.ListFighters;

public class LobbyModule extends Module{
	public List<String> fighters;

	public void register(JavaPlugin plugin){
		registerCommand(plugin, new ButtonFight(this));
		registerCommand(plugin, new ButtonLeave(this));
		registerCommand(plugin, new ListFighters(this));
	}
}
