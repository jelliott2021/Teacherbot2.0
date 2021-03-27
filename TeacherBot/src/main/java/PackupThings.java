import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class PackupThings extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent e){
        if(e.getMessage().getContentRaw().equalsIgnoreCase("&packupthings")){
            e.getChannel().sendMessage("THE BELL DOESN'T DISMISS YOU, I DO!").queue();
        }
    }
}
