package buttondevteam.alipresents.components.insurance;

import org.bukkit.plugin.java.JavaPlugin;

import buttondevteam.alipresents.architecture.Component;

public class InsuranceComponent extends Component {

	@Override
	public void register(JavaPlugin plugin) {
		registerCommand(plugin, new getInsurance());
		registerCommand(plugin, new getInsuranceNugget());
		registerCommand(plugin, new getInsuranceBar());
		registerCommand(plugin, new getInsuranceBlock());
	}

}
