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
import network.starplum.manager.ModuleManager;
import network.starplum.utils.Utils;

public class WarningManager implements Listener {
	
	private final String LEFT_ARROW = "§8・ §fPrevious Page §7§o(Warns)";
	private final String RIGHT_ARROW = "§8・ §fNext Page §7§o(Warns)";
	
	@EventHandler
	public void toggle(PlayerInteractEvent a) {
		final Player player = a.getPlayer();		
		final ItemStack item = player.getInventory().getItemInMainHand();
		boolean isStaff = Modules.getPlayersInStaffMode().contains(player.getUniqueId());
		
		if(isStaff) {
			if(item != null && item.getItemMeta() != null) {
				if(item.getItemMeta().getDisplayName().contentEquals(Environment.WARN_TOGGLE)) {
					toggleWarning(player);
				}
			}
		}
	}
	
	void toggleWarning(Player player) {
		
		final PlayerInventory inv = player.getInventory();
		final ItemStack next     = Utils.getCustomTextureHead(RIGHT_ARROW, Environment.ARROW_RIGHT);
		final ItemStack swearing = new ItemStack(Material.BLACK_DYE);
		final ItemStack inatopic = new ItemStack(Material.BLUE_DYE);
		final ItemStack disrecpe = new ItemStack(Material.BROWN_DYE);
		final ItemStack spam     = new ItemStack(Material.CYAN_DYE);
		final ItemStack advetisi = new ItemStack(Material.GRAY_DYE);
		
		final ItemMeta mswear = swearing.getItemMeta();
		final ItemMeta mtopic = inatopic.getItemMeta();
		final ItemMeta respect = disrecpe.getItemMeta();
		final ItemMeta mspam = spam.getItemMeta();
		final ItemMeta ads   = advetisi.getItemMeta();
		
		mswear.setDisplayName(Environment.WARN_SWEARING);
		mtopic.setDisplayName(Environment.WARN_TOPIC);
		respect.setDisplayName(Environment.WARN_DISRESPECT);
		mspam.setDisplayName(Environment.WARN_SPAM);
		ads.setDisplayName(Environment.WARN_ADVETISEMENT);
		
		swearing.setItemMeta(mswear);
		inatopic.setItemMeta(mtopic);
		disrecpe.setItemMeta(respect);
		spam.setItemMeta(mspam);
		advetisi.setItemMeta(ads);
		
		PunishManager.clearHotbar(player);
		
		inv.setItem(2, swearing);
		inv.setItem(3, inatopic);
		inv.setItem(4, disrecpe);
		inv.setItem(5, spam);
		inv.setItem(6, advetisi);
		
		inv.setItem(8, next);
		
	}
	
	void toggleWarning2(Player player) {
		
		final PlayerInventory inv = player.getInventory();
		final ItemStack back = Utils.getCustomTextureHead(LEFT_ARROW, Environment.ARROW_LEFT);
		final ItemStack helpop = new ItemStack(Material.LIGHT_BLUE_DYE);
		final ItemStack sign   = new ItemStack(Material.LIME_DYE);
		final ItemStack mods = new ItemStack(Material.RED_DYE);
		
		final ItemMeta op = helpop.getItemMeta();
		final ItemMeta signs = sign.getItemMeta();
		final ItemMeta mod = mods.getItemMeta();
		
		op.setDisplayName(Environment.WARN_HELPOP);
		signs.setDisplayName(Environment.WARN_SIGN);
		mod.setDisplayName(Environment.RETURN_MODULES);
		
		helpop.setItemMeta(op);
		sign.setItemMeta(signs);
		mods.setItemMeta(mod);
		
		PunishManager.clearHotbar(player);
		
		inv.setItem(0, back);
		
		inv.setItem(3, helpop);
		inv.setItem(5, sign);
		
		inv.setItem(8, mods);
		
	}
	
	@EventHandler
	public void arrow(PlayerInteractEvent a) {
		final Player player = a.getPlayer();
		final ItemStack item = player.getInventory().getItemInMainHand();
		boolean isStaff = Modules.getPlayersInStaffMode().contains(player.getUniqueId());
		
		if(isStaff && item != null && item.getItemMeta() != null) {
			if(item.getItemMeta().getDisplayName().contentEquals(LEFT_ARROW)) {
				toggleWarning(player);
			} else if(item.getItemMeta().getDisplayName().contentEquals(RIGHT_ARROW)) {
				toggleWarning2(player);
			} else if(item.getItemMeta().getDisplayName().contentEquals(Environment.RETURN_MODULES)) {
				PunishManager.togglePunish(player);
			} else if(item.getItemMeta().getDisplayName().contentEquals(Environment.RETURN_MAINMENU)) {
				ModuleManager.rawToggle(player);
			}
		}
	}

}
