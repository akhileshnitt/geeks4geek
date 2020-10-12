package design;

public interface NameProcessor {
    double process(Name n1,Name n2);
    NameProcessor setNextProcessor(NameProcessor nameProcessor);
}
