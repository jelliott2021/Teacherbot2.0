import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.beans.ExceptionListener;
import java.util.*;

import javax.security.auth.login.LoginException;

public class Main {

    public static void main(String[] args) {

        List<GatewayIntent> gatewayIntents = new ArrayList<>();
        gatewayIntents.add(GatewayIntent.GUILD_MEMBERS);

        JDABuilder jdaBuilder = JDABuilder.createDefault("ODI1MTY3Mjc5MzgwNDk2NDI0.YF5-6g.o1MyDQdCxfzz_YxnldRgdr_5V3Q");
        JDA jda;

        gossip whisper = new gossip();
        jdaBuilder.addEventListeners(whisper);

        Thankyou thanks = new Thankyou();
        jdaBuilder.addEventListeners(thanks);

        Resources resource = new Resources();
        jdaBuilder.addEventListeners(resource);

        AddPeriod addPeriod = new AddPeriod();
        jdaBuilder.addEventListeners(addPeriod);

        AddSchedule addSchedule = new AddSchedule();
        jdaBuilder.addEventListeners(addSchedule);

        GradeChecker gradeChecker = new GradeChecker();
        jdaBuilder.addEventListeners(gradeChecker);

        CreateSchedule createSchedule= new CreateSchedule();
        jdaBuilder.addEventListeners(createSchedule);

        Schedule schedule = new Schedule();
        jdaBuilder.addEventListeners(schedule);

        Help help = new Help();
        jdaBuilder.addEventListeners(help);

        PackupThings packup = new PackupThings();
        jdaBuilder.addEventListeners(packup);

        try {
            jda = jdaBuilder.build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

}
