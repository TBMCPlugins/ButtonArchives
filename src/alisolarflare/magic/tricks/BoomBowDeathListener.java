package alisolarflare.magic.tricks;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class BoomBowDeathListener implements Listener{
	@EventHandler
	public void onBoomBowDeath(PlayerDeathEvent event){
		Player player = event.getEntity();
		if (player.getLastDamage() == 7.000042){
			player.sendMessage("42!");
			event.setDeathMessage(player.getName() + "got trigger happy with the Boom Bow");
		}
		if (player.getLastDamage() < 7.000041 || player.getLastDamage() > 7.000043){
			player.sendMessage("meaning of lyyyyyyfffe");
		}
	}
}
