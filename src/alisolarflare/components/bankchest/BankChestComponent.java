package alisolarflare.components.bankchest;

import org.bukkit.plugin.java.JavaPlugin;

import alisolarflare.components.Component;

public class BankChestComponent extends Component {

	@Override
	public void register(JavaPlugin plugin) {
		registerCommand(plugin, new CreateBankChest());
		registerListener(plugin, new BankChestListener());
	}

}
