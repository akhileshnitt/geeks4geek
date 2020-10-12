package java1.designs;

public class ToOption implements Option {

     private  String to;

     public ToSubject setTo(String to) {
        this.to = to;
        return new ToSubject();

    }
}
