package dev.unzor.crambot.Discord.Commands.Administration;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import dev.unzor.crambot.Discord.Constants;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;

public class DeleteRoleCommand extends Command {
    public DeleteRoleCommand() {
        this.name = "deleterole";
        this.requiredRole = Constants.CramBotPermsRole;
    }
    @Override
    protected void execute(CommandEvent event) {
        String[] args = event.getArgs().split(" ");
        Member userid = event.getMessage().getMentionedMembers().get(0);
        Role role = event.getGuild().getRoleById(args[1]);

        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("Role removed");
        embed.setDescription("I removed the role " + role.getAsMention() + " from " + userid.getAsMention());
        event.getGuild().removeRoleFromMember(userid.getId(), role).queue(v -> event.getChannel().sendMessage(embed.build()).queue());
    }
}
