package buttondevteam.alipresents.components.hotfix.hotfixes;

import org.bukkit.FireworkEffect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class ElytraFireworks implements Listener {
	JavaPlugin plugin;
	public ElytraFireworks(JavaPlugin plugin) {
		this.plugin = plugin;
	}
	public void onRightClick(PlayerInteractEvent event){
		//ACTION SANITATION
		if(!(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
		if(!(event.getPlayer().isGliding())) return;
		if(!(event.getMaterial() == Material.FIREWORK)) return;

		//BOW SANITATION
		ItemStack firework = event.getItem();
		FireworkMeta fireworkMeta= (FireworkMeta) firework.getItemMeta();
		for (FireworkEffect effect : fireworkMeta.getEffects()){
			event.getPlayer().sendMessage(effect.toString());
		}

		//PLAYER SANITATION
		Player player = event.getPlayer();
		if(player.getGameMode().equals(GameMode.SPECTATOR))return;
	}
}
