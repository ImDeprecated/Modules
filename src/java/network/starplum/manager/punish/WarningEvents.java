package network.starplum.manager.punish;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

import network.starplum.Modules;
import network.starplum.manager.Environment;

public class WarningEvents implements Listener {

	@EventHandler
	public void punishement(PlayerInteractEntityEvent a) {

		final Player player = a.getPlayer();
		final boolean isStaff = player.hasPermission("pedestria.modules");
		final boolean StaffMode = Modules.getPlayersInStaffMode().contains(player.getUniqueId());

		final ItemStack item = player.getInventory().getItemInMainHand();

		if(a.getRightClicked() instanceof Player) {
			
			final Player target = (Player) a.getRightClicked();

			if(isStaff && StaffMode) {
				if(item != null && item.getItemMeta() != null) {
					String name = item.getItemMeta().getDisplayName();
					if(name.contentEquals(Environment.WARN_ADVETISEMENT)) {
						player.performCommand("warn " + target + " Advetisement");
					} else if(name.contentEquals(Environment.WARN_DISRESPECT)) {
						player.performCommand("warn " + target + " Disrespect");
					} else if(name.contentEquals(Environment.WARN_HELPOP)) {
						player.performCommand("warn " + target + " HelpOP Misusage");
					} else if(name.contentEquals(Environment.WARN_SIGN)) {
						player.performCommand("warn " + target + " Inapropriate Sign(s)");
					} else if(name.contentEquals(Environment.WARN_SPAM)) {
						player.performCommand("warn " + target + " Spam");
					} else if(name.contentEquals(Environment.WARN_SWEARING)) {
						player.performCommand("warn " + target + " Swearing");
					} else if(name.contentEquals(Environment.WARN_TOPIC)) {
						player.performCommand("warn " + target + " Inapropriate Topic(s)");
					} else return;
				}
			}
		} else {
			
			if(!(a.getRightClicked() instanceof Player)) {
				if(isStaff & StaffMode) {
					if(item != null && item.getItemMeta() != null) {
						if(item != null && item.getItemMeta() != null) {
							String name = item.getItemMeta().getDisplayName();
							if(name.contentEquals(Environment.WARN_ADVETISEMENT)) {
								player.sendMessage("§8§l* §fThis may only works on players !");
							} else if(name.contentEquals(Environment.WARN_DISRESPECT)) {
								player.sendMessage("§8§l* §fThis may only works on players !");
							} else if(name.contentEquals(Environment.WARN_HELPOP)) {
								player.sendMessage("§8§l* §fThis may only works on players !");
							} else if(name.contentEquals(Environment.WARN_SIGN)) {
								player.sendMessage("§8§l* §fThis may only works on players !");
							} else if(name.contentEquals(Environment.WARN_SPAM)) {
								player.sendMessage("§8§l* §fThis may only works on players !");
							} else if(name.contentEquals(Environment.WARN_SWEARING)) {
								player.sendMessage("§8§l* §fThis may only works on players !");
							} else if(name.contentEquals(Environment.WARN_TOPIC)) {
								player.sendMessage("§8§l* §fThis may only works on players !");
							} else return;
						}
					}
				}
			}
			
		}
	}
	
}