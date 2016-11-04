package alisolarflare.creativeboundaries;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.palmergames.bukkit.towny.event.PlayerChangePlotEvent;
import com.palmergames.bukkit.towny.exceptions.NotRegisteredException;
import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.object.Town;
import com.palmergames.bukkit.towny.object.TownBlock;

public class PlotChangeListener implements Listener{
	public boolean isInTown;
	public CreativeBoundariesModule plugin;
	public PlotChangeListener(CreativeBoundariesModule plugin){
		this.plugin = plugin;
	}
	@EventHandler
	public void onPlayerPlotChange(PlayerChangePlotEvent plotEvent){
		if (plugin.dickmode == false){
			return;
		}
		try{
			Resident currentResident = new Resident(plotEvent.getPlayer().getName().toLowerCase());
			TownBlock plot = plotEvent.getTo().getTownBlock();
				
			if(plot.hasTown()){
				Town plotTown = plot.getTown();
			
				if(!(plotTown.hasResident(currentResident))){
					plotEvent.getPlayer().setGameMode(GameMode.SURVIVAL);

				}
			
			} else {
				plotEvent.getPlayer().setGameMode(GameMode.SURVIVAL);
			}
			
		}catch(NotRegisteredException e){
			//thrown by plotEvent.getTo().getTownBlock()
			//thrown by plotEvent.getTo().getTownBlock().getTown();
			plotEvent.getPlayer().setGameMode(GameMode.SURVIVAL);
			
		}
	}
}
