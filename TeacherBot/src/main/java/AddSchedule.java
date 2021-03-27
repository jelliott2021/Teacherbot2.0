import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import java.util.ArrayList;

public class AddSchedule extends CreateSchedule{
    public void onGuildMessageReceived(GuildMessageReceivedEvent e){
        ArrayList<String> singleClass = new ArrayList<>();
        int indexOfSpace; int indexOfSpace2;
        if(e.getMessage().getContentRaw().toLowerCase().substring(0,14).contains(("&addschedule"))) {
            indexOfSpace = e.getMessage().getContentRaw().indexOf(" ");
            indexOfSpace2 = e.getMessage().getContentRaw().indexOf(" ", indexOfSpace + 1);
            while (singleClass.size() < 3) {
                //e.getChannel().sendMessage(String.valueOf(e.getMessage().getContentRaw().indexOf(" "))).queue();
                if (indexOfSpace2 != -1 && singleClass.size() == 0) {
                    singleClass.add(e.getMessage().getContentRaw().substring(indexOfSpace + 1, indexOfSpace + 2));
                }
                else if (indexOfSpace2 != -1) {
                    singleClass.add(e.getMessage().getContentRaw().substring(indexOfSpace + 1, indexOfSpace2));
                }
                else if (singleClass.size() < 2){
                    singleClass.set(1, "Error");
                } else {
                    singleClass.add(e.getMessage().getContentRaw().substring(indexOfSpace));
                }
                indexOfSpace = indexOfSpace2;
                indexOfSpace2 = e.getMessage().getContentRaw().indexOf(" ", indexOfSpace + 1);
            }
            if (singleClass.get(2) == null) {
                classObject addIt = new classObject(singleClass.get(0).substring(0, 1), singleClass.get(1));
                //If there's a bad period
                if (charToPeriodIndex(addIt.getPeriod()) == -1) {
                    e.getChannel().sendMessage("Error inputting period").queue();
                }
                //Replacing existing period
                else if (schedule[charToPeriodIndex(addIt.getPeriod())] != null) {
                    e.getChannel().sendMessage("Overriding period " + schedule[charToPeriodIndex(addIt.getPeriod())].getPeriod() + " " +
                            schedule[charToPeriodIndex(addIt.getPeriod())].getClassName()).queue();
                    schedule[charToPeriodIndex(addIt.getPeriod())] = addIt;
                } else {
                    schedule[charToPeriodIndex(addIt.getPeriod())] = addIt;
                    printConfirmation(schedule[charToPeriodIndex(addIt.getPeriod())], e);
                }
            } else if (singleClass.size() == 3) {
                classObject addIt = new classObject(singleClass.get(0).substring(0, 1), singleClass.get(1), singleClass.get(2));
                //If there's a bad period
                if (charToPeriodIndex(addIt.getPeriod()) == -1) {
                    e.getChannel().sendMessage("Error inputting period").queue();
                }
                //Replacing existing period
                else if (schedule[charToPeriodIndex(addIt.getPeriod())] != null) {
                    e.getChannel().sendMessage("Overriding period " + schedule[charToPeriodIndex(addIt.getPeriod())].getPeriod() + " " +
                            schedule[charToPeriodIndex(addIt.getPeriod())].getClassName() + " " +
                            schedule[charToPeriodIndex(addIt.getPeriod())].getClassLink()).queue();
                    schedule[charToPeriodIndex(addIt.getPeriod())] = addIt;
                } else {

                    schedule[charToPeriodIndex(addIt.getPeriod())] = addIt;
                    printConfirmation(schedule[charToPeriodIndex(addIt.getPeriod())], e);
                }
            } else {
                e.getChannel().sendMessage("Invalid parameters! Try it with &addschedule [period] (class_name) (class_link) \n" +
                        "or with &addschedule [period] (class_name)").queue();
            }
        }
    }

    public int charToPeriodIndex(String c){
        if (c.equals("A") || c.equals("a")){return 0;}
        else if (c.equals("B") || c.equals("b")){return 1;}
        else if (c.equals("C") || c.equals("c")){return 2;}
        else if (c.equals("D") || c.equals("d")){return 3;}
        else if (c.equals("E") || c.equals("e")){return 4;}
        else if (c.equals("F") || c.equals("f")){return 5;}
        else if (c.equals("G") || c.equals("g")){return 6;}
        else if (c.equals("H") || c.equals("h")){return 7;}
        else if (c.equals("I") || c.equals("i")){return 8;}
        else if (c.equals("1")){return 0;}
        else if (c.equals("2")){return 1;}
        else if (c.equals("3")){return 2;}
        else if (c.equals("4")){return 3;}
        else if (c.equals("5")){return 4;}
        else if (c.equals("6")){return 5;}
        else if (c.equals("7")){return 6;}
        else if (c.equals("8")){return 7;}
        else if (c.equals("9")){return 8;}
        else { return -1; }
    }
    public void printConfirmation(classObject object, GuildMessageReceivedEvent e){
        e.getChannel().sendMessage("Saving period " + schedule[charToPeriodIndex(object.getPeriod())].getPeriod() + " " +
                schedule[charToPeriodIndex(object.getPeriod())].getClassName() + " " +
                schedule[charToPeriodIndex(object.getPeriod())].getClassLink() ).queue();
    }
}
