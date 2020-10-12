package java1.designs;

public class ToSubject {
    private String subject;

    public ToBody setSubject(String subject){
        this.subject = subject;
        return new ToBody();
    }
}
