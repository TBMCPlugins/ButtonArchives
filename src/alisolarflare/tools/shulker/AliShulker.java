package alisolarflare.tools.shulker;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Shulker;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
/**
 * @author Alisolarflare
 * This class is responsible for the command /aliShulker, which in-game spawns
 * a shulker that:
 * Has a health of 10
 * Has a wither and invisibility effect present
 * Has noAI
 * And is Glowing
 */
public class AliShulker implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)){
			sender.sendMessage("You must be a player to use this command!");
			return false;
		}
		Player player = (Player) sender;
		if(!(player.getName().equals("iie") || player.getName().equals("alisolarflare"))){
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

}
