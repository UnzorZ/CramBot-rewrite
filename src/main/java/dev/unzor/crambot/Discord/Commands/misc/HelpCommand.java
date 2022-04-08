package dev.unzor.crambot.Discord.Commands.misc;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import dev.unzor.crambot.Utils.RandomColorUtil;
import net.dv8tion.jda.api.EmbedBuilder;

public class HelpCommand extends Command {
    public HelpCommand(){
        this.name = "test";
    }

    @Override
    protected void execute(CommandEvent event) {
            EmbedBuilder embedBuilder = new EmbedBuilder();
            embedBuilder.setTitle("This is a test");
            embedBuilder.setColor(RandomColorUtil.getRandomColor());
            embedBuilder.setFooter("Asked by: " + event.getAuthor().getName());
            event.getChannel().sendMessage(embedBuilder.build()).queue();
    }
}
