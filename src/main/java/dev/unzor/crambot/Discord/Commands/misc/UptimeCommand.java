package dev.unzor.crambot.Discord.Commands.misc;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import dev.unzor.crambot.Utils.RandomColorUtil;
import net.dv8tion.jda.api.EmbedBuilder;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.concurrent.TimeUnit;

public class UptimeCommand extends Command {

    public UptimeCommand() {
        this.name = "uptime";
        this.help = "shows bot's uptime";
    }

    @Override
    protected void execute(CommandEvent ctx) {

        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        long uptime = runtimeMXBean.getUptime();
        long uptimeInSeconds = uptime / 1000;
        final String uptimeString = formatTime(uptimeInSeconds);

        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("¿Cuanto llevo online?")
                .setColor(RandomColorUtil.getRandomColor())
                .setDescription("```" + uptimeString + "```");

        ctx.reply(embed.build());

    }
    public static String formatTime(long seconds) {
        int day = (int) TimeUnit.SECONDS.toDays(seconds);
        long hours = TimeUnit.SECONDS.toHours(seconds) - (day * 24L);
        long minute = TimeUnit.SECONDS.toMinutes(seconds) - (TimeUnit.SECONDS.toHours(seconds) * 60);
        long second = TimeUnit.SECONDS.toSeconds(seconds) - (TimeUnit.SECONDS.toMinutes(seconds) * 60);

        String dayStr = day > 1 ? " Days " : " Day ";
        String hourStr = hours > 1 ? " Hours " : " Hour ";
        String minStr = minute > 1 ? " Minutes " : " Minute ";
        String secStr = minute > 1 ? " Seconds" : " Second";

        String str = "";

        if (day > 0)
            str += day + dayStr;
        if (hours > 0)
            str += hours + hourStr;
        if (minute > 0)
            str += minute + minStr;
        if (second > 0)
            str += second + secStr;

        return str;
    }

    }
