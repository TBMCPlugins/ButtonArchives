package alisolarflare.modules.minigames.data;

import org.bukkit.Location;

public class SpawnSet {
	private Location RSpawn;
	private Location OSpawn;
	private Location YSpawn;
	private Location GSpawn;
	private Location BSpawn;
	private Location PSpawn;
	
	public Location getRSpawn(){return RSpawn;}
	public Location getOSpawn(){return OSpawn;}
	public Location getYSpawn(){return YSpawn;}
	public Location getGSpawn(){return GSpawn;}
	public Location getBSpawn(){return BSpawn;}
	public Location getPSpawn(){return PSpawn;}
	
	public void setRSpawn(Location RSpawn){this.RSpawn = RSpawn; return;}
	public void setOSpawn(Location OSpawn){this.OSpawn = OSpawn; return;}
	public void setYSpawn(Location YSpawn){this.YSpawn = YSpawn; return;}
	public void setGSpawn(Location GSpawn){this.GSpawn = GSpawn; return;}
	public void setBSpawn(Location BSpawn){this.BSpawn = BSpawn; return;}
	public void setPSpawn(Location PSpawn){this.PSpawn = PSpawn; return;}
	
}
