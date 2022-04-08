package dev.unzor.crambot.Discord.Commands.Administration;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import dev.unzor.crambot.Discord.Constants;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;

public class ReactionRoleEmbedCommand extends Command {
    public ReactionRoleEmbedCommand() {
        this.name = "reactionrole";
        this.requiredRole = Constants.CramBotPermsRole;
    }

    @Override
    protected void execute(CommandEvent event) {

        //if (event.getGuild().getId().equals(Constants.discordcramid)) {

            EmbedBuilder banner = new EmbedBuilder();
            banner.setTitle("Reaction Roles");
            banner.setImage("https://media.discordapp.net/attachments/864229711966109717/913558659890548776/reactionroles.png");
            banner.setColor(7279795);

            EmbedBuilder edad = new EmbedBuilder();
            edad.setTitle("Edad");
            edad.addField("\uD83D\uDEBC 0-13", "", true);
            edad.addField("\uD83D\uDEB9 14-20", "", true);
            edad.addField("\uD83D\uDD22 20-35", "", true);
            edad.addField("#️⃣ 35-50", "", true);
            edad.addField("*️⃣ 50+", "", true);
            edad.setColor(7279795);

            EmbedBuilder juegos = new EmbedBuilder();
            juegos.setTitle("Juegos");
            juegos.addField("<a:minecraftxd:913532834784870451> Minecraft", "", true);
            juegos.addField("<:roblocs:913526662447116298> Roblox", "", true);
            juegos.addField("<:csgo:913532868880400395> CS-GO", "", true);
            juegos.addField("<:valorant:913557007993303050> Valorant", "", true);
            juegos.addField("<:Wynncraft:913527136197967872> Wynncraft", "", true);
            juegos.addField("<:Hypixel:913527096662433864> Hypixel Skyblock", "", true);
            juegos.setColor(7279795);

            EmbedBuilder verify = new EmbedBuilder();
            verify.setTitle("Verificate para comprobar que no eres un robot");
            verify.setDescription("Al reaccionar, aceptas que has leido <#856891561844146177> y estas de acuerdo con ellas. Si reaccionas y no ocurre nada, " +
                    "por favor contacta con algun administrador");
            verify.setColor(7279795);

            EmbedBuilder pronouns = new EmbedBuilder();
            pronouns.setTitle("Pronombres");
            pronouns.addField("\uD83D\uDC4D He/Him", "", true);
            pronouns.addField("\uD83D\uDC4A She/Her", "", true);
            pronouns.addField("\uD83E\uDD1C They/Them", "", true);
            pronouns.addField("\uD83D\uDC49 Any", "", true);
            pronouns.addField("\uD83D\uDCAA Ask me", "", true);
            pronouns.setColor(7279795);
        final String[] id = {""};
        event.getChannel().sendMessage("Creating the necessary roles, this can took a little time").queue(message -> {
            id[0] = message.getId();
        });


            /**
             *
             * ROLE CREATION MODULE, WARNING: SUPER EZ RATE LIMIT, BE CAREFUL WITH THIS
             *
             */

            if (event.getGuild().getRolesByName("0-13", false).isEmpty())
                event.getGuild().createRole().setName("0-13").setPermissions().setColor(Color.blue).complete();

            if (event.getGuild().getRolesByName("14-20", false).isEmpty())
                event.getGuild().createRole().setName("14-20").setPermissions().setColor(Color.blue).complete();

            if (event.getGuild().getRolesByName("21-35", false).isEmpty())
                event.getGuild().createRole().setName("20-35").setPermissions().setColor(Color.blue).complete();

            if (event.getGuild().getRolesByName("36-50", false).isEmpty())
                event.getGuild().createRole().setName("35-50").setPermissions().setColor(Color.blue).complete();

            if (event.getGuild().getRolesByName("50+", false).isEmpty())
                event.getGuild().createRole().setName("50+").setPermissions().setColor(Color.blue).complete();

            if (event.getGuild().getRolesByName("Minecraft", false).isEmpty())
                event.getGuild().createRole().setName("Minecraft").setPermissions().setColor(Color.green).complete();

            if (event.getGuild().getRolesByName("Roblox", false).isEmpty())
                event.getGuild().createRole().setName("Roblox").setPermissions().setColor(Color.green).complete();

            if (event.getGuild().getRolesByName("CS-GO", false).isEmpty())
                event.getGuild().createRole().setName("CS-GO").setPermissions().setColor(Color.green).complete();

            if (event.getGuild().getRolesByName("Wynncraft", false).isEmpty())
                event.getGuild().createRole().setName("Wynncraft").setPermissions().setColor(Color.green).complete();

            if (event.getGuild().getRolesByName("Hypixel Skyblock", false).isEmpty())
                event.getGuild().createRole().setName("Hypixel Skyblock").setPermissions().setColor(Color.green).complete();

            if (event.getGuild().getRolesByName("Verificado✅", false).isEmpty())
                event.getGuild().createRole().setName("Verificado✅").setPermissions().complete();

            if (event.getGuild().getRolesByName("He/Him", false).isEmpty())
                event.getGuild().createRole().setName("He/Him").setPermissions().setColor(Color.ORANGE).complete();

            if (event.getGuild().getRolesByName("She/Her", false).isEmpty())
                event.getGuild().createRole().setName("She/Her").setPermissions().setColor(Color.ORANGE).complete();

            if (event.getGuild().getRolesByName("They/Them", false).isEmpty())
                event.getGuild().createRole().setName("They/Them").setPermissions().setColor(Color.ORANGE).complete();

            if (event.getGuild().getRolesByName("Any pronoun", false).isEmpty())
                event.getGuild().createRole().setName("Any pronoun").setPermissions().setColor(Color.ORANGE).complete();

            if (event.getGuild().getRolesByName("Ask my pronoun", false).isEmpty())
                event.getGuild().createRole().setName("Ask my pronoun").setPermissions().setColor(Color.ORANGE).complete();

            event.getChannel().deleteMessageById(String.valueOf(id[0])).queue();
            event.getChannel().sendMessage(banner.build()).queue();

            event.getChannel().sendMessage(edad.build()).queue(msg -> {
                msg.addReaction("\uD83D\uDEBC").queue();
                msg.addReaction("\uD83D\uDEB9").queue();
                msg.addReaction("\uD83D\uDD22").queue();
                msg.addReaction("#️⃣").queue();
                msg.addReaction("*️⃣ ").queue();
            });

            event.getChannel().sendMessage(juegos.build()).queue(msg -> {
                msg.addReaction("minecraftxd:913532834784870451").queue();
                msg.addReaction("roblocs:913526662447116298").queue();
                msg.addReaction("csgo:913532868880400395").queue();
                msg.addReaction("valorant:913557007993303050").queue();
                msg.addReaction("Wynncraft:913527136197967872").queue();
                msg.addReaction("Hypixel:913527096662433864").queue();
            });

            event.getChannel().sendMessage(pronouns.build()).queue(msg -> {
                msg.addReaction("\uD83D\uDC4D").queue();
                msg.addReaction("\uD83D\uDC4A").queue();
                msg.addReaction("\uD83E\uDD1C").queue();
                msg.addReaction("\uD83D\uDC49").queue();
                msg.addReaction("\uD83D\uDCAA").queue();
            });

            event.getChannel().sendMessage(verify.build()).queue(msg -> msg.addReaction("suggestionyes:895748040336486481").queue());

        //}
    }
}
