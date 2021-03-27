import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.entities.Member;


public class CreateSchedule extends ListenerAdapter {
    protected static classObject[] schedule = new classObject[10];
    //Create Schedule Direct Messages from Server
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        Member member =e.getMember();
        if(e.getMessage().getContentRaw().equalsIgnoreCase("&createschedule")){
            member.getUser().openPrivateChannel().queue(channel -> {
                channel.sendMessage("Create Schedule Command").queue();
            });
        }

    }

    //Create Schedule Direct Messages from Direct Messages
    public void onPrivateMessageReceived(PrivateMessageReceivedEvent m) {
        if (m.getMessage().getContentRaw().equalsIgnoreCase("&createschedule")) {
            m.getChannel().sendMessage("Create Schedule Command").queue();
        }
    }
}
