package network.starplum.placeholder;

import org.bukkit.OfflinePlayer;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import network.starplum.Modules;

public class PlaceholderAPIHook extends PlaceholderExpansion {

	@Override
	public boolean canRegister(){
		return true;
	}

	@Override
	public String getAuthor(){
		return "iMPDevMC";
	}

	@Override
	public String getIdentifier(){
		return "modules";
	}

	@Override
	public String getVersion(){
		return "0.1";
	}

	@Override
	public String onRequest(OfflinePlayer player, String identifier) {

		if(identifier.equals("flying")) {
			return player.getPlayer().isFlying() ? "§atrue" : "§cfalse";
		}

		if(identifier.equals("modules")) {
			return Modules.getPlayersInStaffMode().contains(player.getUniqueId()) ? "§atrue" : "§cfalse";
		}

		if(identifier.equals("gamemode")) {
			return player.getPlayer().getGameMode().name();
		}

		if(identifier.equals("vanish")) {
			return Modules.getPlayersInVanish().contains(player.getUniqueId()) ? "§atrue" : "§cfalse";
		}
		
		if(identifier.equals("location")) {
			return "§7" + player.getPlayer().getLocation().getX() + "§8, §7" + player.getPlayer().getLocation().getY() + "§8, §7" + player.getPlayer().getLocation().getZ();
		}
		
		if(identifier.equals("world")) {
			return player.getPlayer().getWorld().getName();
		}

		/** nothing under this */
		return null;

	}

}
