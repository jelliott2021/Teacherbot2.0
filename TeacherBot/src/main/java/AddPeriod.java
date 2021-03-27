import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class AddPeriod extends ListenerAdapter {
    private String myUsername;
    private String myClass;
    private String myTime;
    private String myLink;

    //public AddPeriod(String username, String schoolClass, String time, String link) {
        //myUsername = username;
        //myClass = schoolClass;
        //myTime = time;
        //myLink = link;
    //}

    public String getUsername(){
        return myUsername;
    }
    public String getMyClass(){
        return myClass;
    }
    public String getTime(){
        return myTime;
    }
    public String getLink(){
        return myLink;
    }


    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        Member member = e.getMember();
        if (e.getMessage().getContentRaw().equalsIgnoreCase("&addperiod")) {
            member.getUser().openPrivateChannel().queue(channel -> {
                channel.sendMessage("What's the name of the class? (use prefix &class)").queue();
            });
        }
    }
        public void onPrivateMessageReceived(PrivateMessageReceivedEvent m) {
            String temp = "";
            if (m.getMessage().getContentRaw().equalsIgnoreCase("&")) {
                temp = m.getMessage().getContentRaw();
                myClass = temp.substring(temp.indexOf(" "), temp.length() - 1);
                m.getChannel().sendMessage("What time does this class begin? (ex:12:30) (use prefix &time)").queue();
            }
            //if (m.getMessage().getContentRaw().equalsIgnoreCase("&")) {
               // temp = m.getMessage().getContentRaw();
                //myTime = temp.substring(temp.indexOf(" "), temp.length() - 1);
               // m.getChannel().sendMessage("What is the class meet link? (use prefix &link)").queue();
            //}
            if (m.getMessage().getContentRaw().equalsIgnoreCase("&")) {
                temp = m.getMessage().getContentRaw();
                myLink=temp.substring(temp.indexOf(" "),temp.length()-1);
            }
        }
}
