package network.starplum.utils;

import java.lang.reflect.Field;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

@SuppressWarnings("deprecation")
public class Utils {
	
	public static final ItemStack getCustomTextureHead(String displayName, String value) {
		ItemStack head = new ItemStack(Material.PLAYER_HEAD, 1, (byte) 3);
		SkullMeta meta = (SkullMeta) head.getItemMeta();
		GameProfile profile = new GameProfile(UUID.randomUUID(), "");
		profile.getProperties().put("textures", new Property("textures", value));
		Field profileField = null;
		try {
			profileField = meta.getClass().getDeclaredField("profile");
			profileField.setAccessible(true);
			profileField.set(meta, profile);
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		meta.setDisplayName(displayName);
		head.setItemMeta(meta);
		return head;
	}
	
	public static boolean isInteger(String integer) {
        try { Integer.parseInt(integer); } 
        	catch (NumberFormatException nfe) { return false; } 
        		return true;
    }

}
