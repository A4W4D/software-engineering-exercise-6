import java.util.ArrayList;
import java.util.List;

public class Website implements Subject {
    private String url;
    private String lastKnownContent;
    private List<Observer> observers;
    private WebsiteComparisonStrategy comparisonStrategy;

    public Website(String url, String lastKnownContent) {
        this.url = url;
        this.lastKnownContent = lastKnownContent;
        this.observers = new ArrayList<>();
        this.comparisonStrategy = new HtmlContentComparisonStrategy();
    }

    public void setComparisonStrategy(WebsiteComparisonStrategy strategy) {
        this.comparisonStrategy = strategy;
    }

    @Override
    public void registerObserver(Observer o) {
        if (o != null && !observers.contains(o)) {
            observers.add(o);
        }
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this.url);
        }
    }

    public void checkForUpdate(String newContent) {
        if (!comparisonStrategy.areIdentical(this.lastKnownContent, newContent)) {
            this.lastKnownContent = newContent;
            System.out.println("[Website] Änderung auf " + url + " detektiert!");
            this.notifyObservers();
        } else {
            System.out.println("[Website] Keine Änderung auf " + url);
        }
    }

    public String getUrl() {
        return url;
    }
}