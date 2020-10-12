package java1.designs;

public class Mailer {

    private String from;
    private String to;
    private String subject;
    private String body;

    public Mailer(String from, String to, String subject, String body) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.body = body;
    }


    static class MailBuilder{
        private String from;
        private String to;
        private String subject;
        private String body;

        public MailBuilder setFrom(String from) {
            this.from = from;
            return this;
        }

        public MailBuilder setTo(String to) {
            this.to = to;
            return this;
        }

        public MailBuilder setSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public MailBuilder setBody(String body) {
            this.body = body;
            return this;
        }

        public Mailer build(){
            return new Mailer(from,to,subject,body);
        }
    }


}
