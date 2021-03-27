public class classObject {
    private String period;
    private String className;
    private String classLink;
    public classObject (String p, String cN){
        period = p; className = cN; classLink = "N/A";
    }
    public classObject (String p, String cN, String cL){
        period = p; className = cN; classLink = cL;
    }
    public String getClassName(){
        return className;
    }
    public String getClassLink(){
        return classLink;
    }
    public String getPeriod(){
        return period;
    }
    public void changePeriod(String p){period = p;}
    public void changeClassName(String cN){className = cN;}
    public void changeClassLink(String cL){classLink = cL;}
}
