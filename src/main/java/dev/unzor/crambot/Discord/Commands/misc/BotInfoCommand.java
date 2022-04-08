package dev.unzor.crambot.Discord.Commands.misc;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import dev.unzor.crambot.Discord.Constants;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDAInfo;
import net.dv8tion.jda.api.entities.Guild;

import javax.management.Attribute;
import javax.management.AttributeList;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.RuntimeMXBean;
import java.util.concurrent.TimeUnit;

public class BotInfoCommand extends Command {

    public BotInfoCommand() {
        this.name = "botinfo";
    }

    @Override
    protected void execute(CommandEvent ctx) {

        final JDA jda = ctx.getJDA();

        // GUILD STATS
        final String guilds = jda.getGuildCache().size() + "";
        final String tc = jda.getTextChannelCache().size() + "";
        final String vc = jda.getVoiceChannelCache().size() + "";
        final String roles = jda.getRoleCache().size() + "";
        final String responses = jda.getResponseTotal() + "";
        final String gatewayPing = jda.getGatewayPing() + " ms";
        final String inviteUrl = "https://discord.com/api/oauth2/authorize?client_id=812711414212722719&permissions=8&scope=bot";

        int members = 0;
        for (Guild g : jda.getGuilds()) {
            members += g.getMemberCount();
        }

        // RAM STATS
        long maxMemory = Runtime.getRuntime().maxMemory() / (1024 * 1024);
        long totalMemory = Runtime.getRuntime().totalMemory() / (1024 * 1024);
        long freeMemory = Runtime.getRuntime().freeMemory() / (1024 * 1024);
        long usedMemory = totalMemory - freeMemory;

        // CPU STATS
        int cores = ManagementFactory.getOperatingSystemMXBean().getAvailableProcessors();
        String OS = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class).getName();
        String cpuUsage = getProcessCpuLoad() + "%";

        // UPTIME STATS
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        long uptime = runtimeMXBean.getUptime();
        long uptimeInSeconds = uptime / 1000;

        // BUILD EMBED
        String str = "";
        str = str + Constants.CUBE_BULLET + " Total guilds: " + guilds + "\n";
        str = str + Constants.CUBE_BULLET + " Total users: " + members + "\n";
        str = str + Constants.CUBE_BULLET + " Total text channels: " + tc + "\n";
        str = str + Constants.CUBE_BULLET + " Total voice channels: " + vc + "\n";
        str = str + Constants.CUBE_BULLET + " Total roles: " + roles + "\n\n";
        str = str + Constants.ARROW_BULLET + " Responses Served: " + responses + "\n";
        str = str + Constants.ARROW_BULLET + " Websocket Ping: " + gatewayPing + "\n";
        str = str + "\n";

        EmbedBuilder eb = new EmbedBuilder()
                .setTitle("About " + jda.getSelfUser().getName())
                .setThumbnail(jda.getSelfUser().getEffectiveAvatarUrl())
                .setDescription(str)
                .addField("CPU:",
                        Constants.ARROW + " **OS:** " + OS + "\n"
                                + Constants.ARROW + " **Cores:** " + cores + "\n"
                                + Constants.ARROW + " **Threads:** " + Thread.activeCount() + "\n"
                                + Constants.ARROW + " **Usage:** " + cpuUsage + "\n"
                        , true)
                .addField("MEMORY:",
                        Constants.ARROW + " **Max:** " + maxMemory + " MB\n"
                                + Constants.ARROW + " **Total:** " + totalMemory + " MB\n"
                                + Constants.ARROW + " **Free:** " + freeMemory + " MB\n"
                                + Constants.ARROW + " **Used:** " + usedMemory + " MB\n"
                        , true)
                .addField("UPTIME:", "```" + formatTime(uptimeInSeconds) + "```", false)
                .addField("LIBRARY:", "[JDA " + JDAInfo.VERSION + "](http://home.dv8tion.net:8080/job/JDA/" + JDAInfo.VERSION_BUILD + "/)", true)
                .addField("INVITE:", "[Add Me here!](" + inviteUrl + ")", true)
                .addField("SUPPORT:", "[Discord](https://discord.gg/R2unbmy2)", true);

        ctx.reply(eb.build());

    }

    private String getProcessCpuLoad() {
        AttributeList list = null;

        assert list != null;
        if (list.isEmpty())
            return "NaN";

        Attribute att = (Attribute) list.get(0);
        Double value = (Double) att.getValue();

        // usually takes a couple of seconds before we get real values
        if (value == -1.0)
            return "NaN";

        // returns a percentage value with 1 decimal point precision
        return "0%"; //df.format((value * 1000) / 10.0);
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
