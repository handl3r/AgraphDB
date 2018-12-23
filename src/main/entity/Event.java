package main.entity;

import main.database.Triple;

import java.util.ArrayList;

public class Event extends ParentObject {
    public Event(String id, String label, String description, Source source, String type) {
        super(id, label, description, source, type);
    }


}
