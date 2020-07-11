import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        getString();
    }
    public static void getString() {
        String pageName = "Objective";
        ArrayList<String[]> vars = new ArrayList<>();
        addTo("String", "event", "req", "no", vars);
        addTo("String", "team", "req", "text", vars);
        addTo("String", "match", "req", "text", vars);
        addTo("String", "initials", "req", "text", vars);
        addTo("String", "autoCross", "req", "no", vars);
        addTo("String", "autoPreload", "req", "text", vars);
        addTo("String", "autoLow", "req", "text", vars);
        addTo("String", "autoOuter", "req", "text", vars);
        addTo("String", "autoInner", "req", "text", vars);
        addTo("String", "rotationControl", "req", "no", vars);
        addTo("String", "positionControl", "req", "no", vars);
        addTo("int", "cellLow", "no", "no", vars);
        addTo("int", "cellOuter", "no", "no", vars);
        addTo("int", "cellInner", "no", "no", vars);
        addTo("int", "cellDroppedLow", "no", "no", vars);
        addTo("int", "cellDroppedHigh", "no", "no", vars);
        addTo("String", "endgameClimb", "req", "no", vars);
        addTo("String", "endgameLevel", "req", "no", vars);
        addTo("String", "notes", "req", "text", vars);
        FlutterPage fp = new FlutterPage(pageName, vars);
        System.out.println(fp.assembleString());
    }
    public static void addTo(String type, String value, String req, String field, ArrayList<String[]> list) {
        String[] toAdd = {type, value, req, field};
        list.add(toAdd);
    }
}
