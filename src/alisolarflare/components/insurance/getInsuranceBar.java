package alisolarflare.components.insurance;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import alisolarflare.components.ModCommand;

public class getInsuranceBar extends ModCommand {

	@Override
	public boolean OnCommand(CommandSender sender, String alias, String[] args) {
		Player player = (Player) sender;
		if (args.length > 0 && StringUtils.isNumeric(args[0])){
			//player.getInventory().addItem(Insurance.getInsurance(InsuranceType.Ingot, Integer.parseInt(args[0])));
		}else{
			//player.getInventory().addItem(Insurance.getInsurance(InsuranceType.Ingot));

			ItemStack potato = new ItemStack(Material.BAKED_POTATO);
			potato.getItemMeta().setDisplayName("Spicy Debug Potato");
			potato.getItemMeta().setLore(Arrays.asList("Hwat the fuck"));
			potato.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 10);
			player.getInventory().addItem(potato);
		}
		return false;
	}

}
