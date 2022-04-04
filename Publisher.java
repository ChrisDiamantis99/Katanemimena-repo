import com.sun.jdi.Value;

public interface Publisher extends Node {
    void generateChunks(MultimediaFile multimediaFile); // Multimedia
    void getBrokerList();
    void hashTopic(String n); // Broker
    void notifyBrokerNewMessage(String n);
    void notifyFailure(); //Broker
    void push(String n, Value m);

}
