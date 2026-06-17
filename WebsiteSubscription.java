public class WebsiteSubscription {
    private final int subscriptionId;
    private boolean active;
    private final Website website;
    private final NotificationPreference preference;

    public WebsiteSubscription(
            int subscriptionId,
            Website website,
            NotificationPreference preference
    ) {
        this.subscriptionId = subscriptionId;
        this.website = website;
        this.preference = preference;
        this.active = true;
    }

    public void modifyPreference(
            String frequency,
            CommunicationChannel channel
    ) {
        preference.changeFrequency(frequency);
        preference.changeChannel(channel);
    }

    public void cancel() {
        active = false;
    }

    public boolean isActive() {
        return active;
    }

    public int getSubscriptionId() {
        return subscriptionId;
    }

    public Website getWebsite() {
        return website;
    }

    public NotificationPreference getPreference() {
        return preference;
    }
}
