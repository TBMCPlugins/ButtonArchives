package buttondevteam.alipresents.components.hotfix;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.earth2me.essentials.Essentials;

import buttondevteam.alipresents.architecture.Component;
import buttondevteam.alipresents.components.hotfix.hotfixes.CowSpawnLoop;
import buttondevteam.alipresents.components.hotfix.hotfixes.GrassBreakListener;
import buttondevteam.alipresents.components.hotfix.hotfixes.MobKillListener;
import buttondevteam.alipresents.components.hotfix.hotfixes.NetherDisableListener;

public class HotfixComponent extends Component {

	@Override
	public void register(JavaPlugin plugin) {
		registerListener(plugin, new NetherDisableListener());
		registerListener(plugin, new CowSpawnLoop(plugin));
		registerListener(plugin, new MobKillListener((Essentials) Bukkit.getPluginManager().getPlugin("Essentials")));
		registerListener(plugin, new GrassBreakListener());
		//registerListener(plugin, new CreativeKillLoop(plugin));

	}

}
