package network.starplum.command;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import network.starplum.manager.ModuleManager;


public class ModuleCommand implements CommandExecutor {
	
	static final List<String> messages = new ArrayList<String>();
	
	public ModuleCommand() {
		messages.add("§c§lPedestriaMC §8» §fOh no!, you're missing a permission!");
		messages.add("§c§lPedestriaMC §8» §fYou hit a blockroad!");
		messages.add("§c§lPedestriaMC §8» §fYou're not allowed, please stop");
		messages.add("§c§lPedestriaMC §8» §fOh no!, you're still not allowed!");
		messages.add("§c§lPedestriaMC §8» §fPlease stop, the console is getting mad.");
		messages.add("§c§lPedestriaMC §8» §fI hope you know that we can see your command input, right?");
	}
	
	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		
		final CommandSender sender = arg0;
		final Player player = (Player) sender;
		
		final boolean isPlayer = sender instanceof Player;
		final boolean hasPermission = player.hasPermission("pedestria.modules");
		
		if(!isPlayer) {
			return false;
		} else {
			if(hasPermission) {
				toggle(player);
			} else randomMessage(player);
		} return true;
	}
	
	void randomMessage(Player player) {
		final Random random = new Random();
		final String number = messages.get(random.nextInt(messages.size()));
		player.sendMessage(number);
	}
	
	void toggle(Player player) {
		ModuleManager.toggle(player);
	}

}
