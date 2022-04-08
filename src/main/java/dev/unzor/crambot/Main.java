package dev.unzor.crambot;

import dev.unzor.crambot.Discord.Bot;
import net.dv8tion.jda.api.JDA;

import javax.security.auth.login.LoginException;

public class Main {

    public static JDA jda;

    public static void main(String[] args) {
            startBot();
    }

    public static void startBot() {
        if (jda == null) {
            try {
                jda = Bot.init();
            } catch (LoginException e) {
                e.printStackTrace();
            }
        }
    }

    public static void stopBot() {
        if (jda != null) {
            jda.shutdown();
        }

    }
}
