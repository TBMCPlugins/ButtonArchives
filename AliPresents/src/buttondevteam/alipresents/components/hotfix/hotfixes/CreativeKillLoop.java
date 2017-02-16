package buttondevteam.alipresents.components.hotfix.hotfixes;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class CreativeKillLoop extends BukkitRunnable implements Listener {
	private JavaPlugin plugin;

	public CreativeKillLoop(JavaPlugin plugin){
		this.plugin = plugin;
		this.runTaskTimer(plugin, 40, 40);
	}

	@Override
	public void run() {
		Location location;
		for (Player player : plugin.getServer().getOnlinePlayers()){
			if (player.getGameMode() == GameMode.SURVIVAL) continue;
			if (!player.getWorld().getName().equalsIgnoreCase("world")) continue;
			if (player.isOp()) continue;

			player.sendMessage("[Hotfix] Every Gamemode other than survival is disabled in the new world");
			player.setGameMode(GameMode.SURVIVAL);
			
			location = player.getLocation();
			if (location.getBlockX() < 250 && location.getBlockX() > -250) continue;
			if (location.getBlockZ() < 250 && location.getBlockZ() > -250) continue;
			
			player.sendMessage("[Hotfix] Unless you are in Spawn Island!");
			player.setGameMode(GameMode.SURVIVAL);
			
		}
		
	}

}
