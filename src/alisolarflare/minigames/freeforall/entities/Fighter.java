package alisolarflare.minigames.freeforall.entities;

import org.bukkit.entity.Player;

public class Fighter {
	public Player player;
	public String colour;
	public Fighter(Player player){
		this.player = player;
	}
	public Fighter(Player player, String colour){
		this.colour = colour;
	}
	public String ToString(){
		return player.toString() +": " + colour.toString();
	}
}
