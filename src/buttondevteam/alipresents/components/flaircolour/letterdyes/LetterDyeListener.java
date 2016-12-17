package buttondevteam.alipresents.components.flaircolour.letterdyes;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Dye;

import com.earth2me.essentials.Essentials;
import com.earth2me.essentials.User;

import buttondevteam.alipresents.components.flaircolour.FlairColourAPI;

public class LetterDyeListener implements Listener{
	private Essentials essentials;
	public LetterDyeListener(Essentials essentials) {
		this.essentials = essentials;
	}
	@EventHandler
	public void onLetterDye(PlayerInteractEvent event){
		try{
			if((event.getAction() != Action.RIGHT_CLICK_AIR)) return;
			ItemStack item = event.getItem();
			
			if(item.getType() != Material.INK_SACK) return;
			if(item.getItemMeta().hasEnchant(Enchantment.LUCK)) return;
			if(item.getItemMeta().getEnchantLevel(Enchantment.LUCK) == 10) return;
			if(item.getItemMeta().getDisplayName() == "LetterDye") return;
			
			Dye dye = (Dye) event.getItem().getData();
			User user = essentials.getUser(event.getPlayer());
			user.setNickname(FlairColourAPI.colourShiftRight(user._getNickname(), dye.getColor()));
		}catch(Exception e){
			event.getPlayer().sendMessage(e.getStackTrace().toString());
		}
		
	}
}
