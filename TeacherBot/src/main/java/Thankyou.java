import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Thankyou extends ListenerAdapter {
    protected static classObject[] schedule = new classObject[10];
    //Create Schedule Direct Messages from Server
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        Member member =e.getMember();
        if(e.getMessage().getContentRaw().equalsIgnoreCase("thank you")){
            member.getUser().openPrivateChannel().queue(channel -> {
                e.getChannel().sendMessage("You're welcome.").queue();
            });
        }

    }
    //Create Schedule Direct Messages from Direct Messages
    public void onPrivateMessageReceived(PrivateMessageReceivedEvent m) {
        if (m.getMessage().getContentRaw().equalsIgnoreCase("thank you")) {
            m.getChannel().sendMessage("You're welcome.").queue();
        }
    }
}
