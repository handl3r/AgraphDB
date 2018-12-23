package main.entity;

import main.database.Triple;
import main.entity.ParentObject;

public class Relationship {
    private String type;
    private ParentObject subject;
    private ParentObject object;

    public Relationship(String type) {
        this.type = type;
    }

    public Relationship(ParentObject subject, ParentObject object, String type) {
        this.type = type;
        this.subject = subject;
        this.object = object;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ParentObject getSubject() {
        return subject;
    }

    public void setSubject(ParentObject subject) {
        this.subject = subject;
    }

    public ParentObject getObject() {
        return object;
    }

    public void setObject(ParentObject object) {
        this.object = object;
    }

    public Triple toTriple() {
        String IDString1 = subject.getIDString();
        String IDString2 = object.getIDString();
        Triple triple = new Triple(IDString1,type,IDString2);
        return triple;
    }
}
