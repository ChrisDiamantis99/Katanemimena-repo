public class Brokers implements Broker{

    private static int port;

    // H main tha einai stous brokers tha trexeis tous brokers(3 brokers - 3 KSEXWRISTA RUN)

    public static void main (String[] args){
        port = Integer.parseInt(args[0]); // 8ira pou akouei
        Brokers broker = new Brokers();
    }



    @Override
    public void acceptConnection(Consumer cons) {

    }

    @Override
    public void acceptConnection(Publisher pub) {

    }

    @Override
    public void calculateKeys() {

    }

    @Override
    public void filterConsumers(String n) {

    }

    @Override
    public void notifyBrokersOnChanges() {

    }

    @Override
    public void notifyPublisher(String m) {

    }

    @Override
    public void pull(String n) {

    }

    @Override
    public void connect() {

    }

    @Override
    public void disconnect() {

    }

    @Override
    public void init(int a) {

    }

    @Override
    public void updateNodes() {

    }
}
