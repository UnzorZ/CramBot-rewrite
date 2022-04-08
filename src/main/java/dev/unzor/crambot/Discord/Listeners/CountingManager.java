package dev.unzor.crambot.Discord.Listeners;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Invite;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class CountingManager extends ListenerAdapter {
    JDA jda;

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        TextChannel channel = event.getTextChannel();
        Message lastmessage = channel.getHistory().getRetrievedHistory().get(0);



        if (isStringNumeric(event.getMessage().getContentRaw())) {
            if (isStringNumeric(String.valueOf(lastmessage))) {
                if (channel.getName().contains("counting")) {
                    try {
                        int lastmessageint = Integer.parseInt(lastmessage.getContentRaw());
                        System.out.println(lastmessageint);
                    } catch (Exception exception) {
                        System.out.println(exception.getMessage());
                    }

                }
            }
        }
    }


    public static boolean isStringNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
