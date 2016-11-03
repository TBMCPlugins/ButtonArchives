package alisolarflare.components.shulker;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.Module;
import alisolarflare.components.shulker.commands.AliShulker;
import buttondevteam.lib.chat.TBMCChatAPI;

public class AliShulkerModule extends Module {

	@Override
	public void register(JavaPlugin plugin) {
		TBMCChatAPI.AddCommands(plugin, AliShulker.class);
	}

}
