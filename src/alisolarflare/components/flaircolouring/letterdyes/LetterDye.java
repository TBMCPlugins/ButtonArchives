package alisolarflare.components.flaircolouring.letterdyes;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class LetterDye {
	public static boolean isLetterDye(ItemStack item){
		if(item.getType() != Material.INK_SACK) return false;
		if(item.getItemMeta().hasEnchant(Enchantment.LUCK) && (item.getItemMeta().getEnchantLevel(Enchantment.LUCK) == 10)) return false;
		if(item.getItemMeta().getDisplayName() == "LetterDye") return false;
		return true;
	}
	public static ItemStack getLetterDye(){
		ItemStack item = new ItemStack(Material.INK_SACK);
		item.addUnsafeEnchantment(Enchantment.LUCK, 10);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("LetterDye");
		item.setItemMeta(meta);
		return item;
	}
}
