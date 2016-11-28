package alisolarflare.components.magic.tricks;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BoomBowListener implements Listener {
	JavaPlugin plugin;
	public BoomBowListener(JavaPlugin plugin){
		this.plugin = plugin;
	}
	@EventHandler
	public void ClickEvent(PlayerInteractEvent event){
		FlyBowBoost(event);

	}
	public void FlyBowBoost(PlayerInteractEvent event){

		//ACTION SANITATION
		if(!(event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK)) return;
		if(!(event.getPlayer().isGliding())) return;
		if(!(event.getMaterial() == Material.BOW)) return;

		//BOW SANITATION
		ItemStack bow = event.getItem();
		if(!(bow.containsEnchantment(Enchantment.ARROW_KNOCKBACK))) return;
		if(!(bow.getEnchantmentLevel(Enchantment.ARROW_KNOCKBACK) == 3)) return;
		if(!(bow.getItemMeta().getDisplayName().contains("BOOM BOW"))) return;

		//PLAYER SANITATION
		Player player = event.getPlayer();
		PlayerInventory inventory = player.getInventory();
		if(player.getGameMode().equals(GameMode.SPECTATOR))return;

		if(bow.containsEnchantment(Enchantment.ARROW_INFINITE)){
			//HAS INIFINITY			
			Activate(event);

		}else if((inventory.contains(Material.TNT))){
			//HAS TNT
			Activate(event);

			//Reduce TNT
			ItemStack tnt = inventory.getItem(inventory.first(Material.TNT));
			
			if(tnt.getAmount() > 3){
				tnt.setAmount(tnt.getAmount()-3);
			}else{
				inventory.remove(tnt);
			}
			if (bow.getDurability() < 0){
				inventory.clear(inventory.getHeldItemSlot());
			}

		}else{
			return;
		}
	}


	
	public void Activate(PlayerInteractEvent event){
		//INIT - Player variables
		Player player = event.getPlayer();
		Location playerLocation = player.getLocation();
		ItemStack boomBow = player.getInventory().getItemInMainHand();

		//TODO: NERF - boomDecay		
		//TODO: NERF - endCrystal
		//TODO: NERF - healthReduction
		//TODO: NERF - localized
		
		if(BoomBowRule.boomDecay)
			new BoomDecayTask(player).runTaskTimer(plugin, 1, 1);
		if(BoomBowRule.endCrystal){
			//BoomBowCyrstalSpawn
		}
		if(BoomBowRule.healthReduction){
			player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 400, -1));
		}
		if(BoomBowRule.localized);
		

		//SET - Player Velocity
		player.setVelocity(playerLocation.getDirection().normalize().multiply(3.0));

		//CREATE - Explosion + damage
		player.getWorld().playSound(playerLocation, Sound.ENTITY_GENERIC_EXPLODE, 10, -20);
		player.getWorld().spawnParticle(Particle.EXPLOSION_HUGE, playerLocation, 2);
		player.damage(7.42425, player);
		boomBow.setDurability((short) (boomBow.getDurability() + 3));
		if(boomBow.getDurability() > 385){
			player.getInventory().setItemInMainHand(null);
			player.getWorld().playSound(playerLocation, Sound.ENTITY_ITEM_BREAK, 0, 0);
		}

	}
}
