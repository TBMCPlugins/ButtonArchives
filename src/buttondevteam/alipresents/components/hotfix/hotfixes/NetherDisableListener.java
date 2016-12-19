package buttondevteam.alipresents.components.hotfix.hotfixes;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;

public class NetherDisableListener implements Listener{
	@EventHandler
	public void onPortalEnter(PlayerPortalEvent event){
		event.getPlayer().sendMessage("[HOTFIX] This portal is disabled!");
		event.getPlayer().sendMessage("[HOTFIX] Going to the Nether is disabled on the server");
		event.setCancelled(true);
	}
}
