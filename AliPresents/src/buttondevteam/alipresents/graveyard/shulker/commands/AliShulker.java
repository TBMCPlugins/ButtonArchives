package buttondevteam.alipresents.graveyard.shulker.commands;

import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Shulker;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import buttondevteam.lib.chat.TBMCCommandBase;

/**
 * @author Alisolarflare This class is responsible for the command /aliShulker, which in-game spawns a shulker that: Has a health of 10 Has a wither and invisibility effect present Has noAI And is
 *         Glowing
 *@deprecated*/
public class AliShulker extends TBMCCommandBase {

	@Override
	public boolean OnCommand(CommandSender sender, String label, String[] args) {
		Player player = (Player) sender;
		if (!(player.getName().equals("iie") || player.getName().equals("alisolarflare"))) {
			return false;
		}
		Location location = player.getLocation();
		Entity entity = player.getWorld().spawnEntity(location, EntityType.SHULKER);
		Shulker shulker = (Shulker) entity;
		shulker.setHealth(10);

		shulker.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 1728000, 5, false));
		shulker.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 1728000, 5, false));
		shulker.setAI(false);
		shulker.setGlowing(true);

		return false;
	}

	@Override
	public String[] GetHelpText(String alias) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String GetCommandPath() {
		return "alishulker";
	}

	@Override
	public boolean GetPlayerOnly() {
		return true;
	}

	@Override
	public boolean GetModOnly() {
		// TODO Auto-generated method stub
		return false;
	}

}
