package dev.unzor.crambot.Discord.Commands.Administration;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import dev.unzor.crambot.Discord.Constants;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;

public class AddRoleCommand extends Command {
    public AddRoleCommand() {
        this.name = "addrole";
        this.requiredRole = Constants.CramBotPermsRole;
    }
    @Override
    protected void execute(CommandEvent event) {
        String[] args = event.getArgs().split(" ");
        Member userid = event.getMessage().getMentionedMembers().get(0);
        Role role = event.getGuild().getRoleById(args[1]);


        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("Role added");
        embed.setDescription("I added the role " + role.getAsMention() + " to " + userid.getAsMention());
        event.getChannel().sendMessage(embed.build()).queue(v -> event.getGuild().addRoleToMember(userid.getId(), role).queue());
    }
}
