package buttondevteam.alipresents.components.hotfix;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;

public class NetherDisableListener implements Listener{
	@EventHandler
	public void onPortalEnter(PlayerPortalEvent event){
		event.setCancelled(true);
	}
}
