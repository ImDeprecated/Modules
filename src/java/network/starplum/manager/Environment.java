package network.starplum.manager;

/**
 * Database of all item displayname, gui titles, and variables.
 * All displayname must be changed from here; It's easier this way than searching the whole code 
 * and replace all variable by Strings. All comparisons are made with the variables, so good luck
 * replacing all Strings (without using the replace all feature, huh)
 * @author imDeprecated <br>
 * @see https://github.com/imDeprecated/Modules <br>
 * @version 1.0
 */

public class Environment {
	
	/** Skulls */
	public static final String ARROW_LEFT  = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzQxMzNmNmFjM2JlMmUyNDk5YTc4NGVmYWRjZmZmZWI5YWNlMDI1YzM2NDZhZGE2N2YzNDE0ZTVlZjMzOTQifX19";
	public static final String ARROW_RIGHT = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTAyZmEzYjJkY2IxMWM2NjM5Y2M5YjkxNDZiZWE1NGZiYzY2NDZkODU1YmRkZTFkYzY0MzUxMjRhMTEyMTVkIn19fQ==";

	/** Global */
	public static final String RETURN_MAINMENU = "§8・ §7Back to §fInterface";
	public static final String RETURN_MODULES = "§8・ §7Back to §fModules";
	public static final String RETURN_WARNING = "§8・ §7Back to §fWarning";
	public static final String RETURN_MUTE    = "§8・ §7Back to §fMute";
	public static final String RETURN_BAN     = "§8・ §7Back to §fBan";
	
	/** Main Interface */
	public static final String PUNISH_TOGGLE = "§8・ §fPunish Player";
	
	/** Punish Interface */
	public static final String WARN_TOGGLE = "§8・ §fWarn Player";
	public static final String MUTE_TOGGLE = "§8・ §fMute Player";
	public static final String BAN_TOGGLE  = "§8・ §fBan Player";
	public static final String INFORMATION_TOGGLE = "§8・ §fInformations";
	public static final String OPTION_TOGGLE = "§8・ §fOptions";
	
	/** Warning Interface */
	public static final String WARN_SWEARING = "§8・ §fSwearing";
	public static final String WARN_TOPIC = "§8・ §fInapropriate Topic";
	public static final String WARN_DISRESPECT = "§8・ §fDisrespect";
	public static final String WARN_SPAM = "§8・ §fSpam";
	public static final String WARN_ADVETISEMENT = "§8・ §fAdvetisement";
	public static final String WARN_HELPOP = "§8・ §fHelpOP Misuage";
	public static final String WARN_SIGN = "§8・ §fInaporpriate Sign";
	
}
