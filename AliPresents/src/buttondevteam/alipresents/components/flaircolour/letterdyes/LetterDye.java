package buttondevteam.alipresents.components.flaircolour.letterdyes;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class LetterDye {
	public static ItemStack getLetterDye(){
		ItemStack item = new ItemStack(Material.INK_SACK);
		item.addUnsafeEnchantment(Enchantment.LUCK, 10);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("LetterDye");
		item.setItemMeta(meta);
		return item;
	}
}
