package dev.unzor.crambot.Discord.Commands.Administration;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import dev.unzor.crambot.Discord.Constants;
import dev.unzor.crambot.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.*;

import java.awt.*;
import java.util.List;

public class MuteCommand extends Command {
    public MuteCommand() {
        this.name = "mute";
        this.requiredRole = Constants.CramBotPermsRole;
    }


    protected void execute(CommandEvent event) {
        Role role = event.getGuild().getRoleById("493531280915431445");
        String[] args = event.getArgs().split("\\s+");
        Member target = event.getMessage().getMentionedMembers().get(0);
        User target2 = event.getMessage().getMentionedUsers().get(0);
        String memberId = target.getId();
        final String[] msg = {event.getMessage().getContentRaw().replace(Constants.Prefix + "mute " + args[0] + " ", "")};
        TextChannel logs = event.getGuild().getTextChannelsByName("dyno-logs", true).get(0);


        if (msg[0].startsWith(Constants.Prefix)) {
            msg[0] = "No se ha especificado una razón";
        }
        EmbedBuilder log = new EmbedBuilder();
        log.setTitle("Usuario muteado");
        log.setColor(Color.RED);
        log.setDescription("Usuario muteado: " + args[0] + "\nRazón: " + msg[0]);

        EmbedBuilder privatemessage = new EmbedBuilder();
        privatemessage.setTitle("Has sido muteado");
        privatemessage.setColor(Color.RED);
        privatemessage.setDescription("Razón del muteo: " + msg[0]);

        Guild guild = Main.jda.getGuildById(Constants.GUID);
        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("Usuario muteado");
        embed.setDescription("Mención: " + args[0] + "\nRazón: " + msg[0]);
        embed.setImage(target2.getAvatarUrl());
        embed.setColor(Color.BLACK);
        event.getChannel().sendMessage(embed.build()).queue();
        logs.sendMessage(log.build()).queue();
        event.getGuild().addRoleToMember(memberId, role).queue();
        msg[0] = "";

        assert guild != null;
        guild.retrieveMemberById(target2.getId()).queue(member ->{
                member.getUser().openPrivateChannel().queue(privateChannel -> {
                        event.getPrivateChannel().sendMessage(privatemessage.build()).queue();

                    });
                });

    }}

