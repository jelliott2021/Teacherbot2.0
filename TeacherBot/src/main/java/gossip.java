import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class gossip extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent e){
        Member member = e.getMember();
        String name = member.getUser().getName();
        if (e.getMessage().getContentRaw().equalsIgnoreCase("*whisper")){
            e.getChannel().sendMessage("Hey " + name + "! Do you have something you would like say to the class?!").queue();
        }
    }
}
