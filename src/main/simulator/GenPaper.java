package main.simulator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.lang.Object;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;

import main.database.Triple;
import main.entity.*;
import org.apache.jena.atlas.test.Gen;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import org.json.simple.parser.ParseException;


public class GenPaper {
    static int CURRENT_PAPER_ID = 0;
    public static JSONArray jsonArrayLink;
    public static JSONArray jsonArrayCountry;
    public static JSONArray jsonArrayEvent;
    public static JSONArray jsonArrayLocation;
    public static JSONArray jsonArrayOrganization;
    public static JSONArray jsonArrayPerson;
    public static JSONArray jsonArrayTime;

    public static void initJSON() {
        JSONParser parser = new JSONParser();
        FileReader fileReader = null;
        Object object = null;
        try {
            fileReader = new FileReader("data/LINK.json");
            object = parser.parse(fileReader);
            GenPaper.jsonArrayLink = (JSONArray) object;

            fileReader = new FileReader("data/PERSON.json");
            object = parser.parse(fileReader);
            GenPaper.jsonArrayPerson = (JSONArray) object;

            fileReader = new FileReader("data/COUNTRY.json");
            object = parser.parse(fileReader);
            GenPaper.jsonArrayCountry = (JSONArray) object;

            fileReader = new FileReader("data/EVENT.json");
            object = parser.parse(fileReader);
            GenPaper.jsonArrayEvent = (JSONArray) object;

            fileReader = new FileReader("data/LOCATION.json");
            object = parser.parse(fileReader);
            GenPaper.jsonArrayLocation = (JSONArray) object;

            fileReader = new FileReader("data/ORGANIZATION.json");
            object = parser.parse(fileReader);
            GenPaper.jsonArrayOrganization = (JSONArray) object;

            fileReader = new FileReader("data/TIME.json");
            object = parser.parse(fileReader);
            GenPaper.jsonArrayTime = (JSONArray) object;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Paper genTypeA() {
        int paper_id = ++CURRENT_PAPER_ID;

        Source source = genSource(paper_id);
        Person person1 = GenPaper.genPerson(paper_id, source);
        Event event1 = GenPaper.genEvent(paper_id, source);
        Location location1 = GenPaper.genLocation(paper_id, source);
        Relationship rel1 = new Relationship(person1, event1, "attend");
        Relationship rel2 = new Relationship(event1, location1, "at");
        Relationship[] relationships = {rel1, rel2};
        ParentObject[] parentObjects = {person1, event1, location1};
        Paper paper = new Paper(parentObjects, relationships);
        return paper;

    }

    public static Paper genTypeB() {
        int paper_id = ++CURRENT_PAPER_ID;

        Source source = genSource(paper_id);
        Person person1 = GenPaper.genPerson(paper_id, source);
        Country country = GenPaper.genCountry(paper_id, source);
        Time time = GenPaper.genTime(paper_id, source);
        Relationship rel1 = new Relationship(person1, country, "visit");
        Relationship rel2 = new Relationship(country, time, "on");
        Relationship[] relationships = {rel1, rel2};
        ParentObject[] parentObjects = {person1, country, time};
        Paper paper = new Paper(parentObjects, relationships);
        return paper;

    }

    public static Paper genTypeC() {
        int paper_id = ++CURRENT_PAPER_ID;

        Source source = genSource(paper_id);
        Organization organization = GenPaper.genOrganization(paper_id, source);
        Event event = GenPaper.genEvent(paper_id, source);
        Time time = GenPaper.genTime(paper_id, source);
        Location location = GenPaper.genLocation(paper_id, source);

        Relationship rel1 = new Relationship(organization, event, "organize");
        Relationship rel2 = new Relationship(event, location, "in");
        Relationship rel3 = new Relationship(event, time, "on");
        Relationship[] relationships = {rel1, rel2, rel3};
        ParentObject[] parentObjects = {organization, event, location, time};
        Paper paper = new Paper(parentObjects, relationships);
        return paper;

    }


    public static Source genSource(int paper_id) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        Random random = new Random();
        JSONObject jsonObject = (JSONObject) GenPaper.jsonArrayLink.get(random.nextInt(1000));
        String link = (String) jsonObject.get("link") + paper_id;


        return new Source(link, format.format(date));
    }

    public static Person genPerson(int paper_id, Source source) {
        Person person = null;
        JSONParser parser = new JSONParser();
        try {
            Random random = new Random();

            JSONObject jsonObject = (JSONObject) GenPaper.jsonArrayPerson.get(random.nextInt(1000));
            String label = (String) jsonObject.get("label");
            String description = (String) jsonObject.get("description");
            Long age = (Long) jsonObject.get("age");
            Integer ageInt = age.intValue();
            String id = label.replaceAll("\\s+", "") + paper_id;

            String nationality = (String) jsonObject.get("nationality");
            person = new Person(id, label, description, source, "person", ageInt, nationality);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return person;
    }

    public static Event genEvent(int paper_id, Source source) {
        Event event = null;
        JSONParser parser = new JSONParser();
        try {
            Random random = new Random();

            JSONObject jsonObject = (JSONObject) GenPaper.jsonArrayEvent.get(random.nextInt(1000));
            String label1 = (String) jsonObject.get("label1");
            String label2 = String.valueOf(jsonObject.get("label2"));
            String label = "Launches new product: " + label1 + label2;
            String description = (String) jsonObject.get("description");
            String id = label.replaceAll("\\s+", "") + paper_id;

            event = new Event(id, label, description, source, "event");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return event;
    }

    public static Location genLocation(int paper_id, Source source) {
        Location location = null;
        try {
            Random random = new Random();

            JSONObject jsonObject = (JSONObject) GenPaper.jsonArrayLocation.get(random.nextInt(1000));
            String label = (String) jsonObject.get("label");
            String country = (String) jsonObject.get("country");
            String description = (String) jsonObject.get("description");
            String id = label.replaceAll("\\s+", "") + paper_id;
            location = new Location(id, label, description, source, "location", country);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return location;
    }

    public static Country genCountry(int paper_id, Source source) {
        Country country = null;
        try {
            Random random = new Random();

            JSONObject jsonObject = (JSONObject) GenPaper.jsonArrayCountry.get(random.nextInt(1000));
            String description = (String) jsonObject.get("description");
            String label = (String) jsonObject.get("label");
            Double population = (Double) jsonObject.get("population");
            Integer populationInt = population.intValue();
            String id = label.replaceAll("\\s+", "") + paper_id;
            country = new Country(id, label, description, source, "country", populationInt);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return country;
    }

    public static Time genTime(int paper_id, Source source) {
        Time time = null;
        try {
            Random random = new Random();

            JSONObject jsonObject = (JSONObject) GenPaper.jsonArrayTime.get(random.nextInt(1000));

            String description = (String) jsonObject.get("hour");
            String label = (String) jsonObject.get("label");
            String id = label.replaceAll("\\s+", "") + paper_id;

            time = new Time(id, label, description, source, "time");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return time;
    }

    public static Organization genOrganization(int paper_id, Source source) {
        Organization organization = null;
        try {
            Random random = new Random();

            JSONObject jsonObject = (JSONObject) GenPaper.jsonArrayOrganization.get(random.nextInt(1000));
            String label = (String) jsonObject.get("label");
            String description = (String) jsonObject.get("description");
            String headquater = (String) jsonObject.get("headquater");
            String since = String.valueOf(jsonObject.get("since"));
            int sinceInt = Integer.parseInt(since);
            String id = label.replaceAll("\\s+", "") + paper_id;
            organization = new Organization(id, label, description, source, "organization", headquater, sinceInt);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return organization;
    }

    public static void main(String[] args) {

        Paper paper = genTypeC();
        paper.showInfor();
        ArrayList arrayList = paper.toTriple();
        Iterator<Triple> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            iterator.next().showInfor();
        }

    }

}
