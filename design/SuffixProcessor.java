package design;

public class SuffixProcessor implements NameProcessor {
    private NameProcessor nameProcessor;


    @Override
    public double  process(Name n1, Name n2) {
        if( (n1.getSuffix() == null && n2.getSuffix() == null)||
                (n1.getSuffix() == null && n2.getSuffix() != null)||
                (n1.getSuffix() != null && n2.getSuffix() == null)){
            return  nameProcessor != null ?nameProcessor.process(n1,n2):1;
        }
        return 0;
    }

    @Override
    public NameProcessor setNextProcessor(NameProcessor nameProcessor) {
        this.nameProcessor = nameProcessor;
        return nameProcessor;
    }
}
