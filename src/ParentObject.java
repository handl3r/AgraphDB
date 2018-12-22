public class ParentObject {
    private int id;
    private String label;
    private String description;
    private Source source;
    private String type;

    public ParentObject(int id, String label, String description, Source source, String type) {
        this.id = id;
        this.label = label;
        this.description = description;
        this.source = source;
        this.type = type;
    }

    public int getId() {
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

    public void setId(int id) {
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

    public Triple[] toTriple() {
        /// de sau
        System.out.println("To Triple");
        Triple[] triples = null;
        return triples;
    }
}
