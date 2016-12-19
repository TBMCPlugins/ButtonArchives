package buttondevteam.alipresents.components.hotfix;

import org.bukkit.plugin.java.JavaPlugin;

import buttondevteam.alipresents.architecture.Component;

public class HotfixComponent extends Component {

	@Override
	public void register(JavaPlugin plugin) {
		registerListener(plugin, new NetherDisableListener());

	}

}
