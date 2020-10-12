package java1.designs;

public class Email {

    private String from;

    public ToOption setFrom(String from) {
        this.from = from;
        return new ToOption();
    }
}
