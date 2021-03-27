import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;

public class Schedule extends AddSchedule{
    //Display Schedule Server from Server
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        if (e.getMessage().getContentRaw().equalsIgnoreCase("&schedule")) {
            e.getChannel().sendMessage(printSchedule(schedule)).queue();
        }
    }

    //Display Schedule Direct Messages from Direct Messages
    public void onPrivateMessageReceived(PrivateMessageReceivedEvent m) {
        if (m.getMessage().getContentRaw().equalsIgnoreCase("&schedule")) {
                m.getChannel().sendMessage(printSchedule(schedule)).queue();
        }
    }

    public String printSchedule(classObject[] input){
        String temp = "";
        for (classObject o: input){
            if (o == null) {
                temp += "______________\n";
            }
            else{
                temp += "Period: " + o.getPeriod() +
                        "   Class: " + o.getClassName() +
                        "   Link: " + o.getClassLink() + "\n";
            }
        }
        return temp;
    }
    //private String myUser;
    //private String myPeriod;
    //private String myTime;
    //private String myLink;
    //public Schedule(String period, String time, String link){
        //myPeriod=period;
        //myTime=time;
        //myLink=link;
    //}
}
