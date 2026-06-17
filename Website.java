import java.util.ArrayList;
import java.util.List;

public class Website implements Subject {
    private final String url;
    private String lastKnownContent;
    private final List<Observer> observers;
    private WebsiteComparisonStrategy comparisonStrategy;

    public Website(String url, String lastKnownContent) {
        this.url = url;
        this.lastKnownContent = lastKnownContent;
        this.observers = new ArrayList<>();
        this.comparisonStrategy = new HtmlContentComparisonStrategy();
    }

    public void setComparisonStrategy(WebsiteComparisonStrategy comparisonStrategy) {
        if (comparisonStrategy == null) {
            throw new IllegalArgumentException("Comparison strategy must not be null.");
        }
        this.comparisonStrategy = comparisonStrategy;
    }

    @Override
    public void registerObserver(Observer observer) {
        if (observer != null && !observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(url);
        }
    }

    public void checkForUpdate(String currentContent) {
        boolean identical = comparisonStrategy.areIdentical(
                lastKnownContent,
                currentContent
        );

        if (identical) {
            System.out.println("[Website] No change detected on " + url);
            return;
        }

        lastKnownContent = currentContent;
        System.out.println("[Website] Change detected on " + url);
        notifyObservers();
    }

    public String getUrl() {
        return url;
    }
}
