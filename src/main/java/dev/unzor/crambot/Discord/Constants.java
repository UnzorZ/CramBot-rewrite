package dev.unzor.crambot.Discord;

import net.dv8tion.jda.api.Permission;

public class Constants {
    //Discord
    public static String token = "";
    public static String GUID = "";
    public static String Prefix = "";
    public static String Activity = "";

    //IDS
    public static String discordcramid = "432645641441640448";
    public static String unzorid = "758441764121608202";
    public static String verifiedroleid = "802954427702968352";

    //Permissions
    public static String OwnerID = "";
    public static String CramBotPermsRole = "[CRAMBOT PERMS]";

    //Emogis
    public final static String CUBE_BULLET = "\u2752";                  //❒
    public final static String CIRCLE_BULLET = "\u2022";                //•
    public final static String ARROW_BULLET = "\u00BB";                 //»
    public final static String ARROW = "\u276F";                        //❯
    public final static String TICK = "\u2713";                        //✓
    public final static String X_MARK = "\u2715";                      //✕
    public final static String CURRENCY = "\u20AA";                    //₪
    public final static String LOCK = "\uD83D\uDD12";                  //🔒
    public final static String ENVELOPE_WITH_ARROW = "\uD83D\uDCE9";   //:envelope_with_arrow:
    public final static String WHITE_SMALL_SQUARE = "\u25AB";           //:white_small_square:

    //Permissions
    public static Permission[] KICK_MEMBERS;
    public static Permission[] BAN_MEMBERS;
    public static Permission[] MANAGE_CHANNELS;
    public static Permission[] ADD_REACTIONS;
    public static Permission[] MENTION_EVERYONE;
    public static Permission[] MANAGE_NICKNAMES;
    public static Permission[] MANAGE_ROLES;
}
