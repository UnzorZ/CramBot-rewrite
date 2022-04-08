package dev.unzor.crambot.Discord.Commands.Administration;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import dev.unzor.crambot.Discord.Constants;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;

import java.awt.*;

public class BanCommand extends Command {
    public BanCommand() {
        this.name = "ban";
    }

    @Override
    protected void execute(CommandEvent event) {
        String[] args = event.getArgs().split("\\s+");
        User target2 = event.getMessage().getMentionedUsers().get(0);
        Member target = event.getMessage().getMentionedMembers().get(0);
        String msg = event.getMessage().getContentRaw().replace(Constants.Prefix + "ban " + args[0] + " ", "");

        if (target.getRoles().toString().contains(Constants.CramBotPermsRole))


        if (msg.startsWith(Constants.Prefix)) {
            msg = "No reason";
        }
        EmbedBuilder log = new EmbedBuilder();
        log.setTitle("Usuario baneado");
        log.setColor(Color.RED);
        log.setDescription("Usuario baneado: " + args[0] + "\nRazón: " + msg);
        // logs no longer work due to the new discord api

        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("Usuario baneado");
        embed.setDescription("Mención: " + args[0] + "\nRazón: " + msg);
        embed.setImage(target2.getAvatarUrl());
        embed.setColor(Color.RED);
        event.getChannel().sendMessage(embed.build()).queue();
        target.ban(0, msg).queue();
        msg = "";
    }
}

