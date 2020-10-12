package design;

public class FirstNameProcessor implements NameProcessor {


    private NameProcessor nameProcessor;
    public double  process(Name n1,Name n2){

        if(n1.getFirstName().equals(n2.getFirstName()) || aliasMatch(n1,n2) ){
            return  nameProcessor != null ?nameProcessor.process(n1,n2):1;
        }
        else {
            return  new FuzzyMatchProcessor().process(n1, n2);
        }

    }

    private boolean aliasMatch(Name n1, Name n2) {
        if( (n1.getFirstName().equals("KRIS") && n2.getFirstName().equals("KRISTINA"))||
                (n1.getFirstName().equals("KRISTINA") && n2.getFirstName().equals("KRIS"))){
            return true;
        }
        return false;
    }

    @Override
    public NameProcessor setNextProcessor(NameProcessor nameProcessor) {
        this.nameProcessor = nameProcessor;
        return nameProcessor;
    }
}
