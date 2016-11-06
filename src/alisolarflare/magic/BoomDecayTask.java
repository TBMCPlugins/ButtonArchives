package alisolarflare.magic;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class BoomDecayTask extends BukkitRunnable{
	Player player;
	private int ticksSinceStart = 0;
	private final int effectLength = 20;
	public BoomDecayTask(Player player){
		this.player = player;
	}
	//runs every tick
	@Override
	public void run() {
		if (ticksSinceStart > effectLength){
			this.cancel();
		}
		player.sendMessage(player.getVelocity().toString());
		
		ticksSinceStart++;
		
	}

}
