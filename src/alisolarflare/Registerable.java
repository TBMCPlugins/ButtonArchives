package alisolarflare;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Allows the project to be registered by any Main JavaPlugin class, by calling //modulename.register(this)
 * in any JavaPlugin class.
 */
public interface Registerable {
	public void register(JavaPlugin plugin);
}
