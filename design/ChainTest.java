package design;

public class ChainTest {


    public static void main(String[] args) {
        FirstNameProcessor f1 = new FirstNameProcessor();
        LastNameProcesor  l1 = new LastNameProcesor();
        MiddleNameProcessor m1 = new MiddleNameProcessor();
        SuffixProcessor s1 = new SuffixProcessor();

        //f1.setNextProcessor(l1).setNextProcessor(m1).setNextProcessor(s1);

        f1.setNextProcessor(m1).setNextProcessor(l1).setNextProcessor(s1);

        //f1.setNextProcessor(s1);

        Name n1 = new Name("Lydia","Mendez " ,null,null);
        Name n2 = new Name("Lydia","Mendez " ,null,null);
        double score = f1.process(n1,n2);
        System.out.println("score : "+score);


         n1 = new Name("Lydia","Mendez " ,"Ann",null);
         n2 = new Name("Lydia","Mendez " ,null,null);
         score = f1.process(n1,n2);
        System.out.println("score : "+score);

        n1 = new Name("Lydia","Mendez " ,"Ann",null);
        n2 = new Name("Lydia","Mendez " ,"Marie",null);
        score = f1.process(n1,n2);
        System.out.println("score : "+score);


        n1 = new Name("Lydia","Mendez " ,"Ann",null);
        n2 = new Name("Lydia","Mendez " ,null,"Marie");
        score = f1.process(n1,n2);
        System.out.println("score : "+score);


        n1 = new Name("KRIS","Mendez " ,"Ann",null);
        n2 = new Name("KRISTINA","Mendez " ,null,"Marie");
        score = f1.process(n1,n2);
        System.out.println("score : "+score);


        n1 = new Name("KRISTINA","Mendez " ,"Ann",null);
        n2 = new Name("KRIS","Mendez " ,null,"Marie");
        score = f1.process(n1,n2);
        System.out.println("score : "+score);


        n1 = new Name("KRISTINA","Mendez " ,"Ann",null);
        n2 = new Name("KRIS","Mendez " ,"Marie",null);
        score = f1.process(n1,n2);
        System.out.println("score : "+score);


        n1 = new Name("KRISTINA","Mendez " ,null,null);
        n2 = new Name("KRIS","Mendez " ,null,null);
        score = f1.process(n1,n2);
        System.out.println("score : "+score);


        n1 = new Name("Lydia","Mendez" ,null,null);
        n2 = new Name("Lydia","Byrnes " ,null,null);
        score = f1.process(n1,n2);
        System.out.println("score : "+score);


        n1 = new Name("Lydia","Mendez" ,null,null);
        n2 = new Name("Lids ","Mendez " ,null,null);
        score = f1.process(n1,n2);
        System.out.println("score : "+score);


    }
}
