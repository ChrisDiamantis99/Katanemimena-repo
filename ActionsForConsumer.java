import com.sun.jdi.Type;
import com.sun.jdi.Value;
import com.sun.jdi.VirtualMachine;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ActionsForConsumer extends Thread implements Consumer {
    ObjectInputStream in;
    ObjectOutputStream out;

    public ActionsForConsumer(Socket connection) {
        try {
            out = new ObjectOutputStream(connection.getOutputStream());
            in = new ObjectInputStream(connection.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            int a = in.readInt();
            int b = in.readInt();

            out.writeInt(a + b);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    @Override
    public void disconnect(String v) {

    }

    @Override
    public void register(String v) {

    }

    @Override
    public void showConversationData(String a, Value b) {

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

    @Override
    public Type type() {
        return null;
    }

    @Override
    public VirtualMachine virtualMachine() {
        return null;
    }

    public static class Client extends Thread {
        int a, b;
        Client(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public void run() {
            Socket requestSocket = null;
            ObjectOutputStream out = null;
            ObjectInputStream in = null;
            try {
                requestSocket = new Socket("127.0.0.1", 4321);
                out = new ObjectOutputStream(requestSocket.getOutputStream());
                in = new ObjectInputStream(requestSocket.getInputStream());

                out.writeInt(a);
                out.flush();

                out.writeInt(b);
                out.flush();

                System.out.println("Server>" + in.readInt());

            } catch (UnknownHostException unknownHost) {
                System.err.println("You are trying to connect to an unknown host!");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } finally {
                try {
                    in.close();	out.close();
                    requestSocket.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }

//        public static void main(String args[]) {
//            new Client(10, 5).start();
//            new Client(20, 5).start();
//            new Client(30, 5).start();
//            new Client(40, 5).start();
//            new Client(50, 5).start();
//            new Client(60, 5).start();
//            new Client(70, 5).start();
//            new Client(80, 5).start();
//            new Client(90, 5).start();
//            new Client(100, 5).start();
//        }
    }


}