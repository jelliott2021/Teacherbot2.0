import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.entities.Member;

public class Resources extends ListenerAdapter {
    //Create Schedule Direct Messages from Server
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        Member member = e.getMember();
        if (e.getMessage().getContentRaw().equalsIgnoreCase("&resources")) {
            member.getUser().openPrivateChannel().queue(channel -> {
                channel.sendMessage(" 2021-2022 Program of Studies:\n https://docs.google.com/document/d/1nczXBWTyee06z8OHg9P4Xkc2lLYUiz_TeRjMw2zUDjM/edit?usp=sharing " +
                        "\n NHS Virtual Tutor Center: \n \n https://drive.google.com/file/d/1w-AihH4C2M9M-xX-phgJ9cUNkB7EopJY/view?usp=sharing" +
                        "\n Clubs and Activities : \n \nhttps://docs.google.com/presentation/d/1ij20fkIDkZUqzp904mgrilDD12EM2VusTiLrVsnyGeA/edit?usp=sharing" +
                        "\n MHS Library Website: \n \nhttps://jtro41.wixsite.com/mhslibrary" +
                        "\n Adjustment Appointment Request: \n \nhttps://forms.gle/pKEYm766fSXko7D16" +
                        "\n MHS Meals To-To Orders: \n \nhttps://forms.gle/nYHa2q37YyDgK8dz9" +
                        "\n Learning Schedules: \n \nhttps://drive.google.com/file/d/1ve_TF32my83BsswtqWUplvnZhufnYDzW/view?usp=sharing" +
                        "\n Covid-19 Handbook: \n \nhttps://drive.google.com/file/d/1O8wO_gfdzVEhBQYNHzFxHWafsW3xiSTM/view?usp=sharing" +
                        "\n 2020-2021 Student / Family Handbook: \n \n https://drive.google.com/file/d/1X0GFGX7-FQuKrfY0LWhrry41F879bC81/view?usp=sharing").queue();
            });
        }

    }
}
