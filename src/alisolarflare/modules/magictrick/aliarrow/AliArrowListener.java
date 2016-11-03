package alisolarflare.modules.magictrick.aliarrow;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class AliArrowListener implements Listener {
	private final JavaPlugin plugin;
	
	public AliArrowListener(JavaPlugin plugin){
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onProjectileLaunch(ProjectileLaunchEvent event){
		try{
			if(!(event.getEntity().getType() == EntityType.ARROW)){
				return;
			}
			Projectile projectile = event.getEntity();
			Arrow arrow = (Arrow) projectile;
			if (!(arrow.isCritical())){
				return;
			}
			if (projectile.getShooter().equals(plugin.getServer().getPlayer("alisolarflare"))){
				AliArrowTask aliArrowTask = new AliArrowTask(plugin,arrow,"alisolarflare");
				aliArrowTask.runTaskTimer(plugin, 2, 1);
				return;
			}else if (projectile.getShooter().equals(plugin.getServer().getPlayer("Zanthr"))){
				AliArrowTask aliArrowTask = new AliArrowTask(plugin,arrow,"zanthr");
				aliArrowTask.runTaskTimer(plugin, 2, 1);
				return;
			}
			return;
			
		}catch(Exception e){
			return;
		}
	}
}