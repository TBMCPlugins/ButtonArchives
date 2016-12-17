package buttondevteam.alipresents.components.flaircolour.portals;

import org.bukkit.entity.Player;

import buttondevteam.alipresents.architecture.commands.PlayerCommand;
import buttondevteam.alipresents.components.flaircolour.FlairColourComponent;

public class FlairMe extends PlayerCommand {
	@Override
	public String GetCommandPath() {
		return "flaircolour flairme";
	}

	private FlairColourComponent component;
	public FlairMe(FlairColourComponent flairDoorComponent) {
		this.component = flairDoorComponent;
	}
	@Override
	public boolean OnCommand(Player player, String label, String[] args) {
		component.playersToBeFlaired.add(player);
		player.sendMessage("Setup Successful! Walk through a portal to get your flair");
		return true;
	}
	@Override
	public String[] GetHelpText(String alias){
		return new String[]{
			"Usage: Type /flairme and enter a portal with coloured",
			"wool underneath to change your flair"
		};
	}
}
