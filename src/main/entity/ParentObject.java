package main.entity;

import main.database.Triple;

import java.util.ArrayList;

public class ParentObject {
    private String id;
    private String label;
    private String description;
    private Source source;
    private String type;

    public ParentObject(String id, String label, String description, Source source, String type) {
        this.id = id;
        this.label = label;
        this.description = description;
        this.source = source;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public String getDescription() {
        return description;
    }

    public Source getSource() {
        return source;
    }

    public String getType() {
        return type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void displayInfor() {
        System.out.println("---");
        System.out.println("id : " + id);
        System.out.println("label : " + label);
        System.out.println("description : " + description);
        System.out.println("source : " + source.getLink() + source.getTime());
        System.out.println("type : " + type);
    }

    public ArrayList toTriple() {
        ArrayList<Triple> triples = new ArrayList<Triple>();
        String id = getId();
        String source = this.source.getLink()+"|"+this.source.getTime();
        Triple triple1 = new Triple(id,"hasProperty",label);
        Triple triple2 = new Triple(id ,"hasProperty",description);
        Triple triple3 = new Triple(id, "hasProperty", source);
        triples.add(triple1);
        triples.add(triple2);
        triples.add(triple3);
        return triples;
    }
    public String getIDString(){
        return label+id;
    }
}
