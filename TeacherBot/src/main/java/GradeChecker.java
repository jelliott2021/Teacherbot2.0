
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


//


public class GradeChecker extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        if (e.getMessage().getContentRaw().equalsIgnoreCase("&grades")) {
            e.getChannel().sendMessage("https://plusportals.com/miltonhigh").queue();
        }
    }

    //Create Schedule Direct Messages from Direct Messages
    public void onPrivateMessageReceived(PrivateMessageReceivedEvent m) {
        if (m.getMessage().getContentRaw().equalsIgnoreCase("&grades")) {
            m.getChannel().sendMessage("https://plusportals.com/miltonhigh").queue();
        }
    }

}