package alisolarflare.components.magic.tricks;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class BoomBowDeathListener implements Listener{
	@EventHandler
	public void onBoomBowDeath(PlayerDeathEvent event){
		Player player = event.getEntity();
		if (player.getLastDamage() > 7.42420 && player.getLastDamage() < 7.42429){
			event.setDeathMessage(player.getName() + " got trigger happy with the [Boom Bow]");
		}
	}
}
