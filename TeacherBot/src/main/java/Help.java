import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Help extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        if(e.getMessage().getContentRaw().equalsIgnoreCase("&help")){
            e.getChannel().sendMessage("Here is a list of the commands: \n   &Schedule (displays created Schedule) \n   &AddSchedule (Input: Period, Class, Link)\n   &Grades (Calculate your gpa)\n   &Resources (Milton High Resources)").queue();
        }
    }
    public void onPrivateMessageReceived(PrivateMessageReceivedEvent m) {
        if (m.getMessage().getContentRaw().equalsIgnoreCase("&help")) {
            m.getChannel().sendMessage("Here is a list of the commands: \n   &Schedule (displays created Schedule) \n   &AddSchedule (Input: Period, Class, Link)\n   &Grades (Brings you to plusportals)\n   &Resources (Milton High Resources)").queue();
        }
    }
}
