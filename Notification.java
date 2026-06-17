package uploaded;

import java.util.Date;

public class Notification {
    private String message;
    private Date createdAt;

    public Notification(String message) {
        this.message = message;
        this.createdAt = new Date();
    }
    public void createMessage() {
    }
    public void send(CommunicationChannel channel) {
        System.out.println("[" + createdAt + "] Gesendet via " + channel + ": " + message);
    }
}