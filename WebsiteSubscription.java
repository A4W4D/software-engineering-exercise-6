public class WebsiteSubscription {
    private int subscriptionId;
    private boolean active;
    private Website website;
    private NotificationPreference preference;

    public WebsiteSubscription(int subscriptionId, Website website, NotificationPreference preference) {
        this.subscriptionId = subscriptionId;
        this.website = website;
        this.preference = preference;
        this.active = true;
    }
    public void modifyPreference(String frequency, CommunicationChannel channel) {
        this.preference.changeFrequency(frequency);
        this.preference.changeChannel(channel);
    }
    public void cancel() {
        this.active = false;
    }
    public boolean isActive() {
        return active;
    }
    public Website getWebsite() {
        return website;
    }
    public NotificationPreference getPreference() {
        return preference;
    }
}