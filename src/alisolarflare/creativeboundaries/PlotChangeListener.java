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

public class PlotChangeListener implements Listener{
	private boolean dickmode;
	private List<Player> cbCreatives = new ArrayList<Player>();
	public CreativeBoundariesModule plugin;
	public PlotChangeListener(CreativeBoundariesModule plugin){
		this.plugin = plugin;
		this.dickmode = plugin.dickmode;
		this.cbCreatives = plugin.cbCreatives;
	}
	@EventHandler
	public void onPlayerPlotChange(PlayerChangePlotEvent plotEvent){
		Player player = plotEvent.getPlayer();
		player.sendMessage("PING");
		if (dickmode == false){
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
		Resident currentResident = new Resident(player.getName());
		Town town;
		try {
			player.sendMessage("PYONG");
			debug(player, "1"+plotEvent.toString());
			debug(player, "2"+plotEvent.getTo().toString());
			debug(player, "3"+plotEvent.getTo().getTownBlock().toString());
			debug(player, "4"+Boolean.toString(plotEvent.getTo().getTownBlock().hasTown()));
			debug(player, "5"+plotEvent.getTo().getTownBlock().getTown().toString());
			player.sendMessage("-");
			if (plotEvent.getTo().getTownBlock().hasTown()){
				player.sendMessage("YANG");
				town = plotEvent.getTo().getTownBlock().getTown();
			}else{
				player.setGameMode(GameMode.SURVIVAL);
				return;
			}
		} catch (NotRegisteredException e) {
			e.printStackTrace();
			debug(player, "6"+e.toString());
			return;
		}
		debug(player, "7"+currentResident.toString());
		if(!(town.hasResident(currentResident)))
			player.setGameMode(GameMode.SURVIVAL);
	}
	private void debug(Player player, String string){
		if (player.getName().equalsIgnoreCase("alisolarflare"))
			player.sendMessage(string);
	}
}
