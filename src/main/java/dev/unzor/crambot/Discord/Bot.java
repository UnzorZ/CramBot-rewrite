package dev.unzor.crambot.Discord;

import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import dev.unzor.crambot.Discord.Commands.Administration.*;
import dev.unzor.crambot.Discord.Commands.misc.AvatarCommand;
import dev.unzor.crambot.Discord.Commands.misc.BotInfoCommand;
import dev.unzor.crambot.Discord.Commands.misc.HelpCommand;
import dev.unzor.crambot.Discord.Commands.misc.UptimeCommand;
import dev.unzor.crambot.Discord.Listeners.Listener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class Bot extends ListenerAdapter {
    public static JDA init() throws LoginException {
        CommandClientBuilder cmdClientBuilder = new CommandClientBuilder();
        cmdClientBuilder.setOwnerId(Constants.OwnerID);
        cmdClientBuilder.setHelpWord("\u0000");
        cmdClientBuilder.setActivity(Activity.watching(Constants.Activity));
        cmdClientBuilder.setPrefix(Constants.Prefix);
        CommandClient cmdClient = cmdClientBuilder.build();
        cmdClient.addCommand(new HelpCommand());
        cmdClient.addCommand(new BanCommand());
        cmdClient.addCommand(new EmbedCreatorCommand());
        cmdClient.addCommand(new AnouncementCreatorCommand());
        cmdClient.addCommand(new MuteCommand());
        cmdClient.addCommand(new AvatarCommand());
        cmdClient.addCommand(new UptimeCommand());
        cmdClient.addCommand(new BotInfoCommand());
        cmdClient.addCommand(new ReactionRoleEmbedCommand());
        cmdClient.addCommand(new PurgeCommand());
        cmdClient.addCommand(new VerifyCommand());
        cmdClient.addCommand(new AddRoleCommand());
        cmdClient.addCommand(new DeleteRoleCommand());
        return JDABuilder
                .createLight(Constants.token)
                .addEventListeners(cmdClient, new Listener())
                .build();
    }
}
