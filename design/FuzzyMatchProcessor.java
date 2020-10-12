package design;

public class FuzzyMatchProcessor implements NameProcessor {
    @Override
    public double process(Name n1, Name n2) {
        return 0.65;
    }

    @Override
    public NameProcessor setNextProcessor(NameProcessor nameProcessor) {
        return null;
    }
}
