package dev.unzor.crambot.Discord.Commands.Administration;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import dev.unzor.crambot.Discord.Constants;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;

import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class VerifyCommand extends Command {
    public VerifyCommand() {
        this.name = "verify";
        this.requiredRole = Constants.CramBotPermsRole;
    }
    @Override
    protected void execute(CommandEvent event) {
        String[] args = event.getArgs().split(" ");
        boolean hasmention = !event.getMessage().getMentionedMembers().isEmpty();
        Role verifiedrole = Objects.requireNonNull(event.getJDA().getGuildById(Constants.discordcramid)).getRoleById(Constants.verifiedroleid);
        ArrayList<Role> roles = new ArrayList<>(event.getMessage().getMentionedMembers().get(0).getRoles());



        if (event.getGuild().getId().equals(Constants.discordcramid)) {
            if (hasmention) {
                if (!roles.contains(verifiedrole)) {
                    Member member = event.getMessage().getMentionedMembers().get(0);
                    member.getRoles().add(verifiedrole);
                    EmbedBuilder embed = new EmbedBuilder();
                    embed.setTitle("Verifier");
                    embed.setDescription("Added the role to " + member.getAsMention());
                    embed.setColor(Color.GREEN);
                }
            } else {
                if (!roles.contains(verifiedrole)) {
                    Member memberByID = Objects.requireNonNull(event.getJDA().getGuildById(Constants.discordcramid)).getMemberById(args[1]);
                    memberByID.getRoles().add(verifiedrole);
                    EmbedBuilder embed = new EmbedBuilder();
                    embed.setTitle("Verifier");
                    embed.setDescription("Added the role to " + memberByID.getAsMention());
                    embed.setColor(Color.GREEN);
                }
            }
        }
        hasmention = false;
        roles.clear();
    }
}
