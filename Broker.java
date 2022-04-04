public interface Broker extends Node {
    void acceptConnection(Consumer cons); //consumer
    void acceptConnection(Publisher pub); //Publisher
    void calculateKeys();
    void filterConsumers(String n);
    void notifyBrokersOnChanges();
    void notifyPublisher(String m);
    void pull(String n);

}
