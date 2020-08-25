package network.starplum.manager.punish;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import network.starplum.Modules;
import network.starplum.manager.Environment;

public class PunishManager implements Listener {
	
	protected static void clearHotbar(Player player) {
		final PlayerInventory inv = player.getInventory();
		final ItemStack air = new ItemStack(Material.AIR);
		for(int a = 0; a < 9; a++) {
			inv.setItem(a, air);
		}
	}
	
	@EventHandler
	public void toggle(PlayerInteractEvent a) {
		
		final Player player = a.getPlayer();		
		final ItemStack item = player.getInventory().getItemInMainHand();
		boolean isStaff = Modules.getPlayersInStaffMode().contains(player.getUniqueId());
		
		if(isStaff) {
			if(item != null && item.getItemMeta() != null) {
				if(item.getItemMeta().getDisplayName().contentEquals(Environment.PUNISH_TOGGLE)) {
					togglePunish(player);
				}
			}
		}
		
	}
	
	protected static void togglePunish(Player player) {
		
		final PlayerInventory inv = player.getInventory();
		
		final ItemStack warnToggle = new ItemStack(Material.BLACK_DYE); // -> WarningManager
		final ItemStack muteToggle = new ItemStack(Material.BLUE_DYE);
		final ItemStack banToggle  = new ItemStack(Material.CYAN_DYE);
		final ItemStack infoToggle = new ItemStack(Material.GRAY_DYE);
		final ItemStack optionToggle = new ItemStack(Material.GREEN_DYE);
		final ItemStack backToggle = new ItemStack(Material.RED_DYE);
		
		final ItemMeta wtoggle = warnToggle.getItemMeta();
		final ItemMeta mtoggle = muteToggle.getItemMeta();
		final ItemMeta btoggle = banToggle.getItemMeta();
		final ItemMeta itoggle = infoToggle.getItemMeta();
		final ItemMeta otoggle = optionToggle.getItemMeta();
		final ItemMeta etoggle = backToggle.getItemMeta();
		
		wtoggle.setDisplayName(Environment.WARN_TOGGLE);
		mtoggle.setDisplayName(Environment.MUTE_TOGGLE);
		btoggle.setDisplayName(Environment.BAN_TOGGLE);
		itoggle.setDisplayName(Environment.INFORMATION_TOGGLE);
		otoggle.setDisplayName(Environment.OPTION_TOGGLE);
		etoggle.setDisplayName(Environment.RETURN_MAINMENU);
		
		warnToggle.setItemMeta(wtoggle);
		muteToggle.setItemMeta(mtoggle);
		banToggle.setItemMeta(btoggle);
		infoToggle.setItemMeta(itoggle);
		optionToggle.setItemMeta(otoggle);
		backToggle.setItemMeta(etoggle);
		
		clearHotbar(player);
		
		inv.setItem(1, warnToggle);
		inv.setItem(2, muteToggle);
		inv.setItem(3, banToggle);
		
		inv.setItem(5, infoToggle);
		inv.setItem(6, optionToggle);
		
		inv.setItem(8, backToggle);
		
	}

}
