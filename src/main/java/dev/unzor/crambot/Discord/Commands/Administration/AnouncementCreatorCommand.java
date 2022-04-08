package dev.unzor.crambot.Discord.Commands.Administration;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import dev.unzor.crambot.Discord.Constants;
import dev.unzor.crambot.Utils.RandomColorUtil;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.Date;

public class AnouncementCreatorCommand extends Command {
    public AnouncementCreatorCommand() {
        this.name = "announcement";
        this.aliases = new String[]{"anuncio"};
        this.requiredRole = Constants.CramBotPermsRole;
    }

    @Override
    protected void execute(CommandEvent event) {
        String[] args = event.getArgs().split(";");
        Date date = new Date();
        int color = 0;

        if (args[0].isEmpty()) {
            EmbedBuilder embed2 = new EmbedBuilder();
            embed2.setTitle("Información");
            embed2.addField("Pasos para crear un announcement: ", "", false);
            embed2.addField("$anuncio <titulo>;<contenido>;<color>(opcional)", "", false);
            embed2.setColor(RandomColorUtil.getRandomColor());
            event.getChannel().sendMessage(embed2.build()).queue();
        }

        if (args[0].equals("help")) {

            EmbedBuilder embed2 = new EmbedBuilder();
            embed2.setTitle("Información");
            embed2.addField("Pasos para crear tu propio embed: ", "", false);
            embed2.addField("$anuncio <titulo>;<contenido>;<color>(opcional)", "", false);
            embed2.addField("Colores: ", "red, green, yellow, purple, black, aqua, dark_aqua, blue, dark_blue,\n dark_purple, vivid_pink, gold, dark_gold, orange, dark_orange, dark_red, grey, dark_grey, navy", false);
            embed2.setColor(RandomColorUtil.getRandomColor());
            event.getChannel().sendMessage(embed2.build()).queue();
        }
        if (args[2].equals("red")) {
            color = 15158332;
        }
        if (args[2].equals("green")) {
            color = 3066993;
        }
        if (args[2].equals("yellow")) {
            color = 16776960;
        }
        if (args[2].equals("purple")) {
            color = 10181046;
        }
        if (args[2].equals("black")) {
            color = 2303786;
        }
        if (args[2].equals("aqua")) {
            color = 1752220;
        }
        if (args[2].equals("dark_aqua")) {
            color = 1146986;
        }
        if (args[2].equals("blue")) {
            color = 3447003;
        }
        if (args[2].equals("dark_blue")) {
            color = 2123412;
        }
        if (args[2].equals("dark_purple")) {
            color = 7419530;
        }
        if (args[2].equals("vivid_pink")) {
            color = 11342935;
        }
        if (args[2].equals("gold")) {
            color = 15844367;
        }
        if (args[2].equals("dark_gold")) {
            color = 12745742;
        }
        if (args[2].equals("orange")) {
            color = 15105570;
        }
        if (args[2].equals("dark_orange")) {
            color = 11027200;
        }
        if (args[2].equals("dark_red")) {
            color = 10038562;
        }
        if (args[2].equals("grey")) {
            color = 9807270;
        }
        if (args[2].equals("dark_grey")) {
            color = 9807270;
        }
        if (args[2].equals("navy")) {
            color = 3426654;
        }


        TextChannel textChannel = event.getGuild().getTextChannelsByName("\uD83D\uDCDA》noticias《\uD83D\uDCDA",true).get(0);
        EmbedBuilder embed2 = new EmbedBuilder();
        embed2.setTitle(args[0]);
        embed2.setDescription(args[1]);
        embed2.setColor(color);
        embed2.setFooter("Anuncio realizado por: " + event.getAuthor().getName(), event.getAuthor().getAvatarUrl());
        textChannel.sendMessage("<@&802954427702968352>").queue();
        textChannel.sendMessage(embed2.build()).queue();
        color = 0;
    }
}
