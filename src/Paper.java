import org.apache.jena.base.Sys;

public class Paper {
    private ParentObject[] parentObjects;
    private Relationship[] relationships;

    public Paper(ParentObject[] parentObjects, Relationship[] relationships) {
        this.parentObjects = parentObjects;
        this.relationships = relationships;
    }
    public void showInfor(){
        System.out.println("OBJECT0 :");
        parentObjects[0].displayInfor();
        System.out.println("HAVE RELATIONSHIP :");
        System.out.println(relationships[0].getType());
        System.out.println("WITH :");
        parentObjects[1].displayInfor();
        System.out.println("HAVE RELATIONSHIP :");
        System.out.println(relationships[1].getType());
        System.out.println("WITH :");
        parentObjects[2].displayInfor();


    }
}
