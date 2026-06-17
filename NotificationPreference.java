public class NotificationPreference {
    private String frequency;
    private CommunicationChannel channel;

    public NotificationPreference(String frequency, CommunicationChannel channel) {
        this.frequency = frequency;
        this.channel = channel;
    }
    public void changeFrequency(String frequency) {
        this.frequency = frequency;
    }
    public void changeChannel(CommunicationChannel channel) {
        this.channel = channel;
    }
    public CommunicationChannel getChannel() {
        return channel;
    }
}