package dev.unzor.crambot.Discord.Listeners;

import dev.unzor.crambot.Discord.Constants;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Listener extends ListenerAdapter {

    JDA jda;

    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event) {

    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {

        if (event.getMessage().getContentRaw().equals(":transgender_flag:")) {
            return;
        }
        if (event.getMessage().getContentRaw().equals(":rainbow_flag:")) {
            return;
        }
        if (event.getMessage().getContentRaw().contains("\u200C")) {
            event.getChannel().deleteMessageById(event.getMessageIdLong()).queue();
            if (event.getMessage().getContentRaw().equals("\u200C")) {
                event.getChannel().deleteMessageById(event.getMessageIdLong()).queue();
            }
        }
        if (event.getMessage().getContentRaw().contains("\u200D")) {
            event.getChannel().deleteMessageById(event.getMessageIdLong()).queue();
        }
        String msg = event.getMessage().getContentRaw();
        if (msg.contains("$faq")) {
            EmbedBuilder embed5 = new EmbedBuilder();
            embed5.setTitle("¿Habrán nether y end?");
            embed5.setDescription("El nether si, el end no lo tenemos claro, pero seguramente no, las primeras semanas el nether estara desactivado");
            embed5.setColor(Color.GREEN);
            EmbedBuilder embed2 = new EmbedBuilder();
            embed2.setTitle("¿Van a haber encantamientos?");
            embed2.setTitle("Si, y mas que los vanilla de minecraft");
            embed2.setColor(Color.GREEN);
            EmbedBuilder embed3 = new EmbedBuilder();
            embed3.setTitle("¿Será vanilla o tendrá varios plugins?");
            embed3.setDescription("Tiene tanto datapacks como plugins y algunos de ellos personalizados");
            embed3.setColor(Color.GREEN);
            EmbedBuilder embed4 = new EmbedBuilder();
            embed4.setTitle("¿Habrán biomas custom?");
            embed4.setDescription("El mapa entero son biomas personalizados del datapack terralith");
            embed4.setColor(Color.GREEN);

            event.getChannel().sendMessage(embed5.build()).queue();
            event.getChannel().sendMessage(embed2.build()).queue();
            event.getChannel().sendMessage(embed3.build()).queue();
            event.getChannel().sendMessage(embed4.build()).queue();

        }

        Member target = event.getMember();
        User target2 = event.getMessage().getAuthor();

        ArrayList<String> blacklist = new ArrayList<>();
        blacklist.add("ζ");


        User author = event.getAuthor();
        Member member = event.getGuild().getMemberById(author.getId());
        String permissions = Objects.requireNonNull(event.getGuild().getMemberById(author.getId())).getPermissions().stream().toString();
        System.out.println(permissions);

    }

    public String getIlegalCharacter(String nickname, ArrayList<String> blacklist) {
        String illegalCharacter = null;
        ArrayList<String> nicknameseparated = new ArrayList<>();
        ArrayList<String> blacklistseparatedword = new ArrayList<>();
        
        for (int i = 0; i < nickname.length(); i++)
            nicknameseparated.add(String.valueOf(nickname.charAt(i)));

        for (int i=0; i<blacklist.size(); i++) {
            for (int j = 0; j < blacklist.get(i).length(); j++)
                blacklistseparatedword.add(String.valueOf(blacklist.get(i)));

            for (int j=0; j<blacklistseparatedword.size(); j++) {
                if (!nicknameseparated.get(j).equals(blacklistseparatedword.get(j)))
                    illegalCharacter=nicknameseparated.get(j);
            }
        }

        nicknameseparated.clear();
        blacklistseparatedword.clear();

      return illegalCharacter;
    }






}
