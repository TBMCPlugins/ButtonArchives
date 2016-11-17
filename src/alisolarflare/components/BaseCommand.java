package alisolarflare.components;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import buttondevteam.lib.chat.TBMCCommandBase;

public abstract class BaseCommand extends TBMCCommandBase{
	public static ItemStack CreateDebugPotato(List<String> debugMessage){
		ItemStack debugPotato = new ItemStack(Material.BAKED_POTATO);
		debugPotato.getItemMeta().setDisplayName("Spicy Debug Potato");
		debugPotato.getItemMeta().setLore(debugMessage);
		debugPotato.addEnchantment(Enchantment.ARROW_FIRE, 10);
		return debugPotato;
	}
	public static ItemStack CreateDebugPotato(String debugMessage){
		return CreateDebugPotato(Arrays.asList(debugMessage));
	}
	public static void SendDebugPotato(Player player, List<String> debugMessage){
		player.getInventory().addItem(CreateDebugPotato(debugMessage));
		player.getWorld().playSound(player.getLocation(), Sound.ENTITY_SLIME_SQUISH, 0, 0);
		return;
	}
	public static void SendDebugPotato(Player player, String debugMessage){
		SendDebugPotato(player, Arrays.asList(debugMessage));
	}
	
}
