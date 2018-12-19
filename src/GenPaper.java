import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.lang.Object;
import java.util.Date;
import java.util.Random;
import java.util.logging.SimpleFormatter;

import org.eclipse.rdf4j.query.algebra.Str;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import org.apache.jena.atlas.json.JSON;
import org.json.simple.parser.ParseException;

public class GenPaper {
    static int CURRENT_PAPER_ID = 0;
    public static Paper genTypeA(){
        int paper_id = ++CURRENT_PAPER_ID;
        String link = "http://ex/";
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date1 = new Date();

        Source source = new Source(link+ paper_id,format.format(date1));
        Person person1 = GenPaper.genPerson(paper_id,source);
        Event event1 = GenPaper.genEvent();
        Location location1 = GenPaper.genLocation();
        Relationship rel1 = new Relationship(person1,event1,"tham gia");
        Relationship rel2 = new Relationship(event1,location1,"tai");
        Relationship[] relationships = {rel1, rel2};
        ParentObject[] parentObjects = {person1, event1, location1};
        Paper paper = new Paper(parentObjects,relationships);
        return  paper;

    }

    public static Person genPerson(int paper_id,Source source){
        Person person = null;
        String id = "Person" + String.valueOf(paper_id);
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("data/MOCK_DATA.json");
            Object object = new Object();
            object = parser.parse(fileReader);
            JSONArray jsonArray = (JSONArray) object;
            JSONObject jsonObject = (JSONObject) jsonArray.get(1);
            String label = (String) jsonObject.get("label")+ paper_id;
            String description = (String) jsonObject.get("description");
//            int age = (int) jsonObject.get("age");
            String nationality = (String) jsonObject.get("nationality");
            person = new Person(paper_id,label,description,source,"person");


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("xx");
        return person;
    }
    public static Event genEvent(){
        return null;
    }
    public static Location genLocation(){
        return null;
    }

    public static void main(String[] args) {
        String link = "http://ex/";
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date1 = new Date();

        Source source = new Source(link+ CURRENT_PAPER_ID,format.format(date1));
        Person person = genPerson(CURRENT_PAPER_ID,source);
        person.displayInfor();
    }

}
