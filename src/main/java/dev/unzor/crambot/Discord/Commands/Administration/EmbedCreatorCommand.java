package dev.unzor.crambot.Discord.Commands.Administration;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import dev.unzor.crambot.Discord.Constants;
import dev.unzor.crambot.Utils.RandomColorUtil;
import net.dv8tion.jda.api.EmbedBuilder;

import java.util.Date;

public class EmbedCreatorCommand extends Command {
    public EmbedCreatorCommand() {
        this.name = "embed";
        this.requiredRole = String.valueOf(Constants.CramBotPermsRole);
    }

    @Override
    protected void execute(CommandEvent event) {
        String[] args = event.getArgs().split(";");
        Date date = new Date();
        int color = 0;

        if (args[0].isEmpty()) {
            EmbedBuilder embed2 = new EmbedBuilder();
            embed2.setTitle("Información");
            embed2.addField("Pasos para crear tu propio embed: ", "", false);
            embed2.addField("$embed <titulo>;<contenido>;<color>(opcional)", "", false);
            embed2.setColor(RandomColorUtil.getRandomColor());
            event.getChannel().sendMessage(embed2.build()).queue();
        }

        if (args[0].equals("help")) {

            EmbedBuilder embed2 = new EmbedBuilder();
            embed2.setTitle("Información");
            embed2.addField("Pasos para crear tu propio embed: ", "", false);
            embed2.addField("$embed <titulo>;<contenido>;<color>(opcional)", "", false);
            embed2.addField("Colores: ", "red, green, yellow, purple, black, aqua, dark_aqua, blue, dark_blue,\n dark_purple, vivid_pink, gold, dark_gold, orange, dark_orange, dark_red, grey, dark_grey, navy", false);
            embed2.setColor(RandomColorUtil.getRandomColor());
            event.getChannel().sendMessage(embed2.build()).queue();
        }
        
        switch (args[2]) {
            case "red":
                color = 15158332;
                break;
            case "green":
                color = 3066993;
                break;
            case "yellow":
                color = 16776960;
                break;
            case "purple":
                color = 10181046;
                break;
            case "black":
                color = 2303786;
                break;
            case "aqua":
                color = 1752220;
                break;
            case "dark_aqua":
                color = 1146986;
                break;
            case "blue":
                color = 3447003;
                break;
            case "dark_blue":
                color = 2123412;
                break;
            case "dark_purple":
                color = 7419530;
                break;
            case "vivid_pink":
                color = 11342935;
                break;
            case "gold":
                color = 15844367;
                break;
            case "dark_gold":
                color = 12745742;
                break;
            case "orange":
                color = 15105570;
                break;
            case "dark_orange":
                color = 11027200;
                break;
            case "dark_red":
                color = 10038562;
                break;
            case "grey":
                color = 9807270;
                break;
            case "dark_grey":
                color = 9807270;
                break;
            case "navy":
                color = 3426654;
                break;
            case "random":
                color = getRandomNumberInRange(0, 9999999);
                break;
        }


        EmbedBuilder embed2 = new EmbedBuilder();
        embed2.setTitle(args[0]);
        embed2.setDescription(args[1]);
        embed2.setColor(color);
        embed2.setFooter(String.valueOf(date));
        event.getChannel().sendMessage(embed2.build()).queue();
        color = 0;
    }
    
    public static int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
