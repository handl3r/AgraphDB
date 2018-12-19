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

    public void initDate(String type) {
        switch (type) {
            case "a":
                int numberObject = 1000;
                for (int i = 1; i <= numberObject; i++) {
                    //take data from file

                    Person person = null;

                    Event event = null;

                    Relationship relationship = new Relationship(person,event,type);
                    
                    SaveToDB saveToDB = new SaveToDB();// put triple to DB
                    saveToDB.putTripleToDB(relationship);
                }
                break;
            case "b":
                //...
                break;
            case "c":
                //...
                break;
        }

    }
    public Triple[] toTriple(){
        /// de sau
        return null;
    }
}
