import com.sun.jdi.Value;

public interface Consumer extends Node,Value {
    void disconnect(String v);
    void register(String v);
    void showConversationData(String a, Value b);
}
