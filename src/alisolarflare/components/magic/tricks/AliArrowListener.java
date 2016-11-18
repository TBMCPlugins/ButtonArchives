package alisolarflare.components.magic.tricks;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.components.BaseCommand;

public class AliArrowListener implements Listener {
	private final JavaPlugin plugin;
	
	public AliArrowListener(JavaPlugin plugin){
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onProjectileLaunch(ProjectileLaunchEvent event){
		if(event.getEntity().getType() != EntityType.ARROW){
			return;
		}
		Arrow arrow = (Arrow) event.getEntity();
		if (!(arrow.isCritical()) || !(arrow.getShooter() instanceof Player)){
			return;
		}
		Player player = (Player) arrow.getShooter();
		String username = player.getName();
		
		for (String permittedUsername : AliArrowTask.permittedUsers){
			if(permittedUsername.equalsIgnoreCase(username)){
				BaseCommand.SendDebugPotato(player, "HAHAHAHHAHA NICE");
				new AliArrowTask(arrow,username).runTaskTimer(plugin, 2, 1);
			    break;
			}
		}
		return;
		
	}
}