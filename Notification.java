import java.util.Date;

public class Notification {
    private final String message;
    private final Date createdAt;

    public Notification(String message) {
        this.message = message;
        this.createdAt = new Date();
    }

    public void send(CommunicationChannel channel) {
        System.out.println(
                "[" + createdAt + "] Sent via " + channel + ": " + message
        );
    }
}
