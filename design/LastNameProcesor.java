package design;

public class LastNameProcesor implements NameProcessor {

    private NameProcessor nameProcessor;
    @Override
    public double  process(Name n1, Name n2) {

        if(n1.getLastName().equals(n2.getLastName())){
            return  nameProcessor != null ?nameProcessor.process(n1,n2):1;
        }
        else{
            return new FuzzyMatchProcessor().process(n1, n2);
        }
       // return 0;

    }

    @Override
    public NameProcessor setNextProcessor(NameProcessor nameProcessor) {
        this.nameProcessor = nameProcessor;
        return nameProcessor;
    }
}
