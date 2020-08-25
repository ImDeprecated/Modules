package network.starplum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import network.starplum.command.ModuleCommand;
import network.starplum.manager.ModuleManager;
import network.starplum.manager.punish.PunishManager;
import network.starplum.manager.punish.WarningEvents;
import network.starplum.manager.punish.WarningManager;
import network.starplum.placeholder.PlaceholderAPIHook;

public class Modules extends JavaPlugin {
	
	private static volatile boolean TAB = false;
	
	private static Modules modules;
	final JavaPlugin arg1 = this;
	final PluginManager a = Bukkit.getPluginManager();
	final Logger logger = Bukkit.getLogger();
	
	private static List<UUID> playersInStaffMode = new ArrayList<UUID>();
	private static List<UUID> playersInVanish    = new ArrayList<UUID>();
	
	private static HashMap<UUID, ItemStack[]> staffModeInventories = new HashMap<UUID, ItemStack[]>();
	
	@Override
	public void onEnable() {
		modules = this;
		
		registerPlaceholders();
		usingTAB();
		
		this.getCommand("modules").setExecutor(new ModuleCommand());
		
		/** Punishment Managers */
		a.registerEvents(new PunishManager(), arg1);
		a.registerEvents(new ModuleManager(), arg1);
		a.registerEvents(new WarningManager(), arg1);
		a.registerEvents(new WarningEvents(), arg1);
		
	}
	
	void registerPlaceholders() {
		if(a.getPlugin("PlaceholderAPI") != null) {
			logger.info("(Modules) Successfully registered placeholders !");
			new PlaceholderAPIHook().register();
		} else { logger.info("(Modules) Failed to register placeholders !"); }
	}
	
	void usingTAB() {
		if(a.getPlugin("TAB") != null) {
			logger.info("(Modules) Now using TAB to hide nametags !");
			TAB = true;
		} else { TAB = false; }
	}
	
	public static Modules getModules() {
		return modules;
	}
	
	public static List<UUID> getPlayersInStaffMode() {
		return playersInStaffMode;
	}
	
	public static List<UUID> getPlayersInVanish() {
		return playersInVanish;
	}
	
	public static HashMap<UUID, ItemStack[]> getStaffModeInventories() {
		return staffModeInventories;
	}
	
	public static boolean getTab() {
		return TAB;
	}

}