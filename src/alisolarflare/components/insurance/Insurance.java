package alisolarflare.components.insurance;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import alisolarflare.components.BaseCommand;

public abstract class Insurance {
	public static enum InsuranceType{
		Nugget, Ingot, Block
	};
	public static ItemStack getInsurance(InsuranceType insuranceType){
		ItemStack insuranceItem;
		List<String> lore;
		switch(insuranceType){
		case Nugget:
			insuranceItem = new ItemStack(Material.GOLD_NUGGET);
			lore = Arrays.asList(
				"This insurance nugget will protect one inventory slot from death! Be careful"
				+ "though, insurance is removed whenever you die, with each itemslot costing"
				+ "one nugget."
			);
			break;
		case Ingot:
			insuranceItem = new ItemStack(Material.GOLD_INGOT);
			lore = Arrays.asList(
					"This insurance ingot will protect nine inventory slots from death! Be "
					+ "careful though, insurance is removed whenever you die, with each "
					+ "inventory row costing one ingot."
			);
			break;
		case Block:
			insuranceItem = new ItemStack(Material.GOLD_BLOCK);
			lore = Arrays.asList(
					"This insurance block will give your inventory full protection against death! "
					+ "Be careful though, this block will split into ingots, and you'll lose 3"
					+ "upon death."
			);
			break;
		default:
			
			lore = Arrays.asList(
				"The InsuranceType " + insuranceType.toString() + " is not handled by the " +
				"Insurance Class in" + Insurance.class.getPackage().getName() + ". Contact a "+
				"developer with a screenshot of this message"
			);
			insuranceItem = BaseCommand.CreateDebugPotato(lore);
		}
		insuranceItem.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		ItemMeta meta = insuranceItem.getItemMeta();
		meta.setLore(lore);
		meta.setDisplayName("Insurance " + insuranceType.toString());
		insuranceItem.setItemMeta(meta);
		return insuranceItem;
	}
	public static ItemStack getInsurance(InsuranceType insuranceType, int amount){
		ItemStack insurance = Insurance.getInsurance(insuranceType);
		insurance.setAmount(amount);
		return insurance;
	}
	public static boolean isInsuranceType(String string){
		for (InsuranceType insuranceType : Insurance.InsuranceType.values()){
			if (string.equalsIgnoreCase(insuranceType.toString())){
				return true;
			}
		}
		return false;
	}
}
