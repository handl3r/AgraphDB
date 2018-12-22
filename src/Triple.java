public class Triple {
    String subject;
    String predicate;
    String object;
    public Triple(String subject,String predicate, String object){
        this.subject = subject;
        this.predicate = predicate;
        this.object = object;
    }
    public void showInfor(){
        System.out.println("subject :"+ subject);
        System.out.println("predicate :"+ predicate);
        System.out.println("object :"+ object);
    }
}
