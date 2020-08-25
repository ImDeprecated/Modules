package network.starplum.manager;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import me.neznamy.tab.api.TABAPI;
import network.starplum.Modules;

public class ModuleManager implements Listener {
	
	protected static final boolean usingTAB = Modules.getTab();
	
	public static final void toggle(Player player) {

		final ItemStack default_book = new ItemStack(Material.BOOK);
		final ItemStack default_netherStar = new ItemStack(Material.NETHER_STAR);
		final ItemStack default_punish     = new ItemStack(Material.ENCHANTED_BOOK);

		final ItemMeta d_book = default_book.getItemMeta();
		final ItemMeta d_nether = default_netherStar.getItemMeta(); 
		final ItemMeta d_punish = default_punish.getItemMeta();

		d_book.setDisplayName("§8・ §fInspect Inventory");
		default_book.setItemMeta(d_book);

		d_nether.setDisplayName("§8・ §fPlayer Manager");
		default_netherStar.setItemMeta(d_nether);

		d_punish.setDisplayName(Environment.PUNISH_TOGGLE);
		default_punish.setItemMeta(d_punish);

		final boolean hasInventory      = (player.getInventory().getContents() != null);
		final boolean hasCloudInventory = (Modules.getStaffModeInventories().containsKey(player.getUniqueId()));

		final PlayerInventory inv       = (player.getInventory());

		if(!Modules.getPlayersInStaffMode().contains(player.getUniqueId())) {

			Modules.getPlayersInStaffMode().add(player.getUniqueId());

			if(hasInventory) {
				Modules.getStaffModeInventories().put(player.getUniqueId(), player.getInventory().getContents());
			}
			
			if(TABAPI.hasHiddenNametag(player.getUniqueId())) {
				TABAPI.showNametag(player.getUniqueId());
				TABAPI.hideNametag(player.getUniqueId());
			} else TABAPI.hideNametag(player.getUniqueId());

			inv.clear();
			
			inv.setItem(2, default_book);
			inv.setItem(4, default_netherStar);
			inv.setItem(6, default_punish);

			player.sendMessage("§c§lPedestriaMC §8» §fModules has been enabled.");
			

		} else {

			Modules.getPlayersInStaffMode().remove(player.getUniqueId());
			
			if(usingTAB) {
				if(!TABAPI.hasHiddenNametag(player.getUniqueId())) {
					TABAPI.hideNametag(player.getUniqueId());
					TABAPI.showNametag(player.getUniqueId());
				} else TABAPI.showNametag(player.getUniqueId());
			} else {}

			if(hasCloudInventory) {
				player.getInventory().clear();
				player.getInventory().setContents(Modules.getStaffModeInventories().get(player.getUniqueId()));
				player.sendMessage("§c§lPedestriaMC §8» §fModules has been disabled.");
				clearCloudInventory(player);
			} else {
				player.getInventory().clear();
				player.sendMessage("§c§lPedestriaMC §8» §fModules has been disabled.");
			}
		}
	}
	
	public static final void rawToggle(Player player) {
		
		final PlayerInventory inv = player.getInventory();
		
		final ItemStack default_book = new ItemStack(Material.BOOK);
		final ItemStack default_netherStar = new ItemStack(Material.NETHER_STAR);
		final ItemStack default_punish     = new ItemStack(Material.ENCHANTED_BOOK);

		final ItemMeta d_book = default_book.getItemMeta();
		final ItemMeta d_nether = default_netherStar.getItemMeta(); 
		final ItemMeta d_punish = default_punish.getItemMeta();

		d_book.setDisplayName("§8・ §fInspect Inventory");
		default_book.setItemMeta(d_book);

		d_nether.setDisplayName("§8・ §fPlayer Manager");
		default_netherStar.setItemMeta(d_nether);

		d_punish.setDisplayName(Environment.PUNISH_TOGGLE);
		default_punish.setItemMeta(d_punish);
		
		inv.clear();
		
		inv.setItem(2, default_book);
		inv.setItem(4, default_netherStar);
		inv.setItem(6, default_punish);
	}

	static void clearCloudInventory(Player player) {
		Modules.getStaffModeInventories().remove(player.getUniqueId());
	}
	
	@EventHandler
	public void click(PlayerInteractEvent a) {
		final Player player = a.getPlayer();
		boolean isStaff = Modules.getPlayersInStaffMode().contains(player.getUniqueId());
		
		if(isStaff) {
			a.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void drop(PlayerDropItemEvent a) {
		final Player player = a.getPlayer();
		boolean isStaff = Modules.getPlayersInStaffMode().contains(player.getUniqueId());
		
		if(isStaff) {
			a.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void invclick(InventoryClickEvent a) {
		final Player player = (Player) a.getWhoClicked();
		boolean isStaff = Modules.getPlayersInStaffMode().contains(player.getUniqueId());
		
		if(isStaff) {
			a.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void invdrag(InventoryDragEvent a) {
		final Player player = (Player) a.getWhoClicked();
		boolean isStaff = Modules.getPlayersInStaffMode().contains(player.getUniqueId());
		
		if(isStaff) {
			a.setCancelled(true);
		}
		
	}
	
}
