package alisolarflare.magic.tricks;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class AliArrowDeathListener implements Listener{
	@EventHandler
	public void onBoomBowDeath(PlayerDeathEvent event){
		Player player = event.getEntity();
		if (player.getKiller() != player)
			return;
		player.sendMessage(player.getLastDamageCause().toString());
		player.sendMessage(event.getEventName());
	}
}
