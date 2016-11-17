package alisolarflare.components.insurance;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.components.Component;

public class InsuranceComponent extends Component {

	@Override
	public void register(JavaPlugin plugin) {
		registerCommand(plugin, new getInsurance());
		registerCommand(plugin, new getInsuranceNugget());
		registerCommand(plugin, new getInsuranceBar());
		registerCommand(plugin, new getInsuranceBlock());
	}

}
