import org.apache.jena.base.Sys;

public class Person extends ParentObject{
    private int age = -1; // id age = -1 , it's nothing
    private String nationality;

    public Person(int id, String label, String description, Source source, String type) {
        super(id, label, description, source, type);
    }

    public Person(int id, String label, String description, Source source, String type, int age, String nationality) {
        super(id, label, description, source, type);
        this.age = age;
        this.nationality = nationality;
    }

    public Person(int id, String label, String description, Source source, String type, int age) {
        super(id, label, description, source, type);
        this.age = age;
    }

    public Person(int id, String label, String description, Source source, String type, String nationality) {
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
        if(age != -1 )
            System.out.println("age : " + age);
        if (nationality != null)
            System.out.println("nationnality : " + nationality );
        System.out.println("----");
    }
}
