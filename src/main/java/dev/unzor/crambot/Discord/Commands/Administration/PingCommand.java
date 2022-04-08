package dev.unzor.crambot.Discord.Commands.Administration;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import dev.unzor.crambot.Discord.Constants;
import net.dv8tion.jda.api.entities.User;

public class PingCommand extends Command {
    public PingCommand() {
        this.name = "ping";
        this.requiredRole = Constants.CramBotPermsRole;
    }

    @Override
    protected void execute(CommandEvent event) {

        String[] args = event.getArgs().split("\\s+");

        User target = event.getMessage().getMentionedUsers().get(0);
        event.getChannel().sendMessage(target.getAsMention()).queue(message -> {
            message.delete().queue();
        });
        event.getMessage().delete().queue();

    }
}
