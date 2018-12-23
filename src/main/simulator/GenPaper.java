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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import org.json.simple.parser.ParseException;


public class GenPaper {
    static int CURRENT_PAPER_ID = 0;

    public static Paper genTypeA() {
        int paper_id = ++CURRENT_PAPER_ID;
//        String link = "http://ex/";
//        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//        Date date1 = new Date();
//
//        main.entity.Source source = new main.entity.Source(link+ paper_id,format.format(date1));
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

    public static Source genSource(int paper_id) {
        JSONParser parser = new JSONParser();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("data/LINK.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Object object = null;
        try {
            object = parser.parse(fileReader);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONArray jsonArray = (JSONArray) object;
        Random random = new Random();
        JSONObject jsonObject = (JSONObject) jsonArray.get(random.nextInt(1000));
        String link = (String) jsonObject.get("link") + paper_id;


        return new Source(link, format.format(date));
    }
    /// thiết kế lại  để chỉ đọc file 1 lần trả về 1 mảng JSONOBject. sau đó mỗi lần gen thì lấy random trong mảng đó.
    /// chứ nếu mỗi lần gen 1 bài báo lại đọc mấy fiile json 1 lần thì vài lần là tràn .
    /// sửa lại phần lặp code nữa

    public static Person genPerson(int paper_id, Source source) {
        Person person = null;
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("data/PERSON.json");
            Object object = new Object();
            object = parser.parse(fileReader);
            JSONArray jsonArray = (JSONArray) object;
            Random random = new Random();

            JSONObject jsonObject = (JSONObject) jsonArray.get(random.nextInt(1000));
            String label = (String) jsonObject.get("label");
            String description = (String) jsonObject.get("description");
            Long age = (Long) jsonObject.get("age");
            Integer ageInt = age.intValue();
            String id = label.replaceAll("\\s+", "") + paper_id;

            String nationality = (String) jsonObject.get("nationality");
            person = new Person(id, label, description, source, "person", ageInt, nationality);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return person;
    }

    public static Event genEvent(int paper_id, Source source) {
        Event event = null;
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("data/EVENT.json");
            Object object = parser.parse(fileReader);
            JSONArray jsonArray = (JSONArray) object;
            Random random = new Random();

            JSONObject jsonObject = (JSONObject) jsonArray.get(random.nextInt(1000));
            String label1 = (String) jsonObject.get("label1");
            String label2 = String.valueOf(jsonObject.get("label2"));
            String label = "Launches new product: " + label1 + label2;
            String description = (String) jsonObject.get("description");
            String id = label.replaceAll("\\s+", "") + paper_id;

            event = new Event(id, label, description, source, "event");


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return event;
    }

    public static Location genLocation(int paper_id, Source source) {
        Location location = null;
        JSONParser parser = new JSONParser();
        try {
            FileReader fileReader = new FileReader("data/LOCATION.json");
            Object object = parser.parse(fileReader);
            JSONArray jsonArray = (JSONArray) object;
            Random random = new Random();

            JSONObject jsonObject = (JSONObject) jsonArray.get(random.nextInt(1000));
            String label = (String) jsonObject.get("label");
            String country = (String) jsonObject.get("country");
            String description = (String) jsonObject.get("description");
            String id = label.replaceAll("\\s+", "") + paper_id;
            location = new Location(id, label, description, source, "location", country);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return location;
    }

    public static void main(String[] args) {

        Paper paper = genTypeA();
        paper.showInfor();
        ArrayList arrayList = paper.toTriple();
        Iterator<Triple> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            iterator.next().showInfor();
        }

    }

}
