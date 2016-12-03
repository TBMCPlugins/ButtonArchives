package alisolarflare.components.flaircolouring.letterdyes;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.material.Dye;

import com.earth2me.essentials.Essentials;
import com.earth2me.essentials.User;

import alisolarflare.components.flaircolouring.FlairColouringAPI;

public class LetterDyeListener implements Listener{
	private Essentials essentials;
	public LetterDyeListener(Essentials essentials) {
		this.essentials = essentials;
	}
	@EventHandler
	public void onLetterDye(PlayerInteractEvent event){
		if((event.getAction() == Action.PHYSICAL)) return;
		if (LetterDye.isLetterDye(event.getItem())) return;
		
		Dye dye = (Dye) event.getItem().getData();
		User user = essentials.getUser(event.getPlayer());
		user.setNickname(FlairColouringAPI.colourShiftRight(user._getNickname(), dye.getColor()));
		
	}
}
