package main.entity;

import main.entity.ParentObject;
import main.entity.Source;

public class Time extends ParentObject {
    public Time(String id, String label, String description, Source source, String type) {
        super(id, label, description, source, type);
    }
}
