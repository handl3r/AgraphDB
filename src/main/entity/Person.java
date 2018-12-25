package main.entity;

import main.database.Triple;
import main.simulator.GenPaper;

import java.util.ArrayList;
import java.util.Iterator;

public class Person extends ParentObject {
    private int age = -1; // id age = -1 , it's nothing
    private String nationality;

    public Person(String id, String label, String description, Source source, String type) {
        super(id, label, description, source, type);
    }

    public Person(String id, String label, String description, Source source, String type, int age, String nationality) {
        super(id, label, description, source, type);
        this.age = age;
        this.nationality = nationality;
    }

    public Person(String id, String label, String description, Source source, String type, int age) {
        super(id, label, description, source, type);
        this.age = age;
    }

    public Person(String id, String label, String description, Source source, String type, String nationality) {
        super(id, label, description, source, type);
        this.nationality = nationality;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public void displayInfor() {
        super.displayInfor();
        if (age != -1)
            System.out.println("age : " + age);
        if (nationality != null)
            System.out.println("nationnality : " + nationality);
        System.out.println("----");
    }
    @Override
    public ArrayList toTriple(){
        ArrayList triples = super.toTriple();
        String IDString = getIDString();
        if (age != -1){
            Triple triple1 = new Triple(IDString, "age", String.valueOf(age));
            triples.add(triple1);
        }
        if(nationality != null){
            Triple triple2 = new Triple(IDString,"nationality",nationality);
            triples.add(triple2);
        }

        return triples;
    }

    public static void main(String[] args) {
        Source source = GenPaper.genSource(1);
        Person person = new Person("1","thai","abc",source,"human",20,"VietNam");
        ArrayList arrayList = person.toTriple();
        Iterator<Triple> iterator = arrayList.iterator();
        while(iterator.hasNext()){
            iterator.next().showInfor();
        }
    }
}
