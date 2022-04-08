package dev.unzor.crambot.Discord.Commands.Administration;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import dev.unzor.crambot.Discord.Constants;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;

import java.awt.*;

public class PurgeCommand extends Command {
    public PurgeCommand() {
        this.name = "purge";

    }
    @Override
    protected void execute(CommandEvent event) {
        String[] args = event.getArgs().split(" ");
        String replace1 = args[0].replace("[", "");
        String numbers = replace1.replace("]", "");
        int number = Integer.parseInt(numbers);
        if (!numbers.matches("\\d+(d+)?")) {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle("No Apropiate Args provided");
            embed.setColor(Color.red);
            embed.addField("Error", "You didnt provide correct arguments to this command try using a number", false);
            embed.addField("Correct Usage", "!purge {number} , has to be less than 100", false);
            embed.setFooter("Looks like we had a error!");
            event.getChannel().sendMessage(embed.build()).queue(message -> message.addReaction("🗑️").queue());
        } else {

            if (number <= 100) {

                java.util.List<Message> messages = event.getChannel().getHistory().retrievePast(number).complete();
                messages.forEach(m -> System.out.println("Deleting:" + m));
                for (int i=0; i > number; i++) {
                    String id = event.getChannel().getLatestMessageId();
                    event.getChannel().deleteMessageById(id).complete();
                    id = "";
                }

            } else {
                EmbedBuilder embed2 = new EmbedBuilder();
                embed2.setTitle("Looks like we had a error");
                embed2.setColor(Color.RED);
                embed2.setDescription("Looks like you tried to purge more than 100 messages... try with less than 100 next time");
                embed2.setFooter("Looks like you forced a error bad boy...");
                event.getChannel().sendMessage(embed2.build()).queue(message -> message.addReaction("🗑️").queue());
            }
        }
    }

}
