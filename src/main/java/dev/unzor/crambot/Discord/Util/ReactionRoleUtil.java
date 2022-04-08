package dev.unzor.crambot.Discord.Util;

import dev.unzor.crambot.Discord.Constants;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class ReactionRoleUtil extends ListenerAdapter {

    @Override
    public void onMessageReactionAdd(@NotNull MessageReactionAddEvent event) {
        if (event.getGuild().getId().equals(Constants.discordcramid)) {
            if (!event.getUser().isBot()) {
                    if (event.getReaction().getReactionEmote().getEmote().getId().equals("913532834784870451")) {

                        event.getChannel().sendMessage("test").queue();


                    }
                }
            }
        }

    }
