import org.apache.jena.base.Sys;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Simulator {
    public static void start() {
        Paper paper = GenPaper.genTypeA();


        System.out.println("Simulator call done");
    }
}
