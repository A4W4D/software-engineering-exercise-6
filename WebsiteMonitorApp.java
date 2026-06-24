public class WebsiteMonitorApp {

    public static void main(String[] args) {
        String url = args.length > 0 ? args[0] : "https://www.frankfurt-university.de";

        User user = new User(
                1,
                "Max",
                "max@test.de"
        );
        Website website = new Website(
                url,
                "<html><body>Version 1</body></html>"
        );
        NotificationPreference preference =
                new NotificationPreference(
                        "immediately",
                        CommunicationChannel.EMAIL
                );

        WebsiteSubscription subscription =
                new WebsiteSubscription(
                        1,
                        website,
                        preference
                );

        user.addSubscription(subscription);
        website.registerObserver(user);

        System.out.println(
                "--- Website Monitor: Observer and Strategy Pattern ---"
        );

        System.out.println("\n[Test 1] HTML comparison:");
        website.setComparisonStrategy(
                new HtmlContentComparisonStrategy()
        );
        website.checkForUpdate(
                "<html><body>Version 2</body></html>"
        );

        System.out.println("\n[Test 2] Content-size comparison:");
        website.setComparisonStrategy(
                new SizeComparisonStrategy()
        );
        website.checkForUpdate(
                "<html><body>Version X</body></html>"
        );

        System.out.println("\n[Test 3] Text comparison:");
        website.setComparisonStrategy(
                new TextContentComparisonStrategy()
        );
        website.checkForUpdate("<div>Version X</div>");

        System.out.println("\n[Test 4] Changed visible text:");
        website.checkForUpdate(
                "<div>Version 3 (new text)</div>"
        );
    }
}
