package buttondevteam.alipresents.components.hotfix.hotfixes;

import java.math.BigDecimal;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import com.earth2me.essentials.Essentials;
import com.earth2me.essentials.User;

import net.ess3.api.MaxMoneyException;

public class MobKillListener implements Listener {
	private Essentials essentials;

	public MobKillListener(Essentials essentials) {
		this.essentials = essentials;
	}

	@EventHandler
	public void onMobKill(EntityDeathEvent event){
		Player killer;
		if ((killer = event.getEntity().getKiller()) == null){
			return;
		}
		User user = essentials.getUser(killer);
		switch(event.getEntity().getType()){
		case ZOMBIE:
			try {
				user.giveMoney(BigDecimal.ONE);
			} catch (MaxMoneyException e) {
				return;
			}
		default:
			return;
		}
		
	}
}
