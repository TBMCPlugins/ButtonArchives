package buttondevteam.alipresents.components.flaircolour;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import com.earth2me.essentials.Essentials;

import buttondevteam.alipresents.architecture.Component;
import buttondevteam.alipresents.components.flaircolour.letterdyes.GetLetterDye;
import buttondevteam.alipresents.components.flaircolour.letterdyes.LetterDye;
import buttondevteam.alipresents.components.flaircolour.letterdyes.LetterDyeListener;
import buttondevteam.alipresents.components.flaircolour.portals.FlairMe;
import buttondevteam.alipresents.components.flaircolour.portals.PlayerProximityLoop;
import buttondevteam.alipresents.components.flaircolour.portals.PortalListener;
import buttondevteam.alipresents.components.flaircolour.portals.SetProximityLocation;

public class FlairColourComponent extends Component {
	public List<Player> playersToBeFlaired = new ArrayList<Player>();
	@Override
	public void register(JavaPlugin plugin) {
		registerCommand(plugin, new FlairMe(this));
		registerCommand(plugin, new SetProximityLocation());
		registerCommand(plugin, new GetLetterDye());
		
		registerListener(plugin, new PortalListener(plugin, this));
		registerListener(plugin, new PlayerProximityLoop(plugin, this));
		registerListener(plugin, new LetterDyeListener((Essentials) Bukkit.getPluginManager().getPlugin("Essentials")));
		
		registerRecipies(plugin);
	}
	
	public void registerRecipies(JavaPlugin plugin){
		ItemStack testItem = LetterDye.getLetterDye();
		ShapedRecipe testRecipie = new ShapedRecipe(testItem);
		testRecipie.shape("***","*C*","***");
		
		testRecipie.setIngredient('*', Material.INK_SACK);
		
	}
}
