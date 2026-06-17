package uploaded;

public class WebsiteMonitorApp {
    public static void main(String[] args) {
        User user = new User(1, "Max Mustermann", "max@test.de");
        Website website = new Website("https://www.frankfurt-university.de", "<html><body>Version 1</body></html>");

        website.registerObserver(user);

        System.out.println("--- Starte Website-Überwachung mit Strategy Pattern (Exercise 6) ---");

        System.out.println("\n[Test 1] Nutze HTML-Content-Vergleich:");
        website.setComparisonStrategy(new HtmlContentComparisonStrategy());
        website.checkForUpdate("<html><body>Version 2</body></html>");

        System.out.println("\n[Test 2] Wechsel auf Größen-Vergleich (Content Size):");
        website.setComparisonStrategy(new SizeComparisonStrategy());
        website.checkForUpdate("<html><body>Version X</body></html>");

        System.out.println("\n[Test 3] Wechsel auf reinen Text-Vergleich (ohne HTML-Tags):");
        website.setComparisonStrategy(new TextContentComparisonStrategy());
        website.checkForUpdate("<div>Version X</div>");

        System.out.println("\n[Test 4] Text ändert sich tatsächlich im Text-Vergleich:");
        website.checkForUpdate("<div>Version 3 (Neuer Text!)</div>");
    }
}