package alisolarflare.creativeboundaries;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.palmergames.bukkit.towny.event.PlayerChangePlotEvent;
import com.palmergames.bukkit.towny.exceptions.NotRegisteredException;
import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.object.Town;
import com.palmergames.bukkit.towny.object.TownBlock;
import com.palmergames.bukkit.towny.object.TownyUniverse;

public class PlotChangeListener implements Listener{
	private List<Player> cbCreatives = new ArrayList<Player>();
	public CreativeBoundariesModule plugin;
	public PlotChangeListener(CreativeBoundariesModule plugin){
		this.plugin = plugin;
		this.cbCreatives = plugin.cbCreatives;
	}
	@EventHandler
	public void onPlayerPlotChange(PlayerChangePlotEvent plotEvent){
		Player player = plotEvent.getPlayer();
		player.sendMessage("PING");
		if (plugin.dickmode == false){
			debug(player, "dickies");
			return;
		}
		if (plotEvent.getPlayer().getGameMode() != GameMode.CREATIVE){
			debug(player, "cray cray");
			return;
		}
		if (!(cbCreatives.contains(plotEvent.getPlayer()))){
			debug(player, "racism");
			return;
		}
		player.sendMessage("PONG");
		TownBlock tb = TownyUniverse.getTownBlock(player.getLocation());
		if (tb == null) {
			player.sendMessage("You aren't standing in a town or some other error occured.");
			player.sendMessage("TownBlock is null.");
			return;
		}
		Town town;
		try {
			town = tb.getTown();
		} catch (NotRegisteredException e) {
			player.sendMessage("You aren't standing in a town or some other error occured.");
			player.sendMessage("TownBlock's town is not registered.");
			return;
		}
		if (town == null) {
			player.sendMessage("ERROR: The town you're standing in is Null.");
			return;
		}
		
		boolean townHasRes = false;
		for(Resident res : town.getResidents()){
			if (res.getName().toString().equals(player.getName().toString())){
				player.sendMessage("DINGDINGDING");
				townHasRes = true;			
			}
		}
		if (!townHasRes){
			player.setGameMode(GameMode.SURVIVAL);
		}
	}
	private void debug(Player player, String string){
		if (player.getName().equalsIgnoreCase("alisolarflare"))
			player.sendMessage(string);
	}
}
