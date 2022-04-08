package dev.unzor.crambot.Discord.Util;

import net.dv8tion.jda.api.entities.Role;

import java.util.List;

public class Utils {

    private String getRolesAsString (List rolesList){
        String roles = "";
        if (!rolesList.isEmpty()) {
            Role tempRole = (Role) rolesList.get(0);
            roles = "<@&" + tempRole.getId() + ">";
            for (int i = 1; i < rolesList.size(); i++) {
                tempRole = (Role) rolesList.get(i);
                roles = roles + ", <@&" + tempRole.getId() + ">";
            }
        } else {
            roles = "Sin roles";
        }
        return roles;
    }
}
