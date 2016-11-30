package alisolarflare.components.gpowers;

import java.util.UUID;

public class PoweredPlayer{
	public UUID uuid;
	public String colour;
	public Boolean isPowersActive;

	public PoweredPlayer(UUID uuid, String colour, Boolean activated){
		this.uuid = (uuid);
		this.colour = (colour);
		this.isPowersActive = (activated);
	}
	public String toString(){
		return "[UUID: "+ uuid.toString() + ", Colour: "+ colour+", IsActivated: "+isPowersActive + "]";
	}
}
