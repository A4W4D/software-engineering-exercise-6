import java.util.ArrayList;
import java.util.List;

public class User implements Observer {
    private final int userId;
    private final String name;
    private final String email;
    private final List<WebsiteSubscription> subscriptions;

    public User(int userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.subscriptions = new ArrayList<>();
    }

    @Override
    public void update(String url) {
        CommunicationChannel channel = findChannelFor(url);
        Notification notification = new Notification(
                "Website content changed: " + url
        );
        notification.send(channel);
    }

    public void register() {
        System.out.println(
                "User registered: " + name + " (" + email + ")"
        );
    }

    public void addSubscription(WebsiteSubscription subscription) {
        if (subscription != null && !subscriptions.contains(subscription)) {
            subscriptions.add(subscription);
        }
    }

    private CommunicationChannel findChannelFor(String url) {
        for (WebsiteSubscription subscription : subscriptions) {
            if (subscription.isActive()
                    && subscription.getWebsite().getUrl().equals(url)) {
                return subscription.getPreference().getChannel();
            }
        }
        return CommunicationChannel.EMAIL;
    }

    public int getUserId() {
        return userId;
    }
}
