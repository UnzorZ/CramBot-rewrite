package dev.unzor.crambot.Discord.Commands.Administration;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import dev.unzor.crambot.Discord.Constants;
import dev.unzor.crambot.Utils.RandomColorUtil;
import net.dv8tion.jda.api.EmbedBuilder;

public class PreguntaDelDiaEmbedCommand extends Command {
    @Override
    protected void execute(CommandEvent event) {
        String msg = event.getMessage().getContentRaw().replace(Constants.Prefix + "preguntadeldia ", "").replace("¿", "").replace("?", "");

        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("✨》Pregunta del dia《✨");
        embed.setDescription("¿" + msg + "?");
        embed.setColor(RandomColorUtil.getRandomColor());
        event.getChannel().sendMessage(embed.build()).queue();
    }
}
