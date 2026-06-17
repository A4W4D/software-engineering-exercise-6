public class HtmlContentComparisonStrategy implements WebsiteComparisonStrategy {
    @Override
    public boolean areIdentical(String oldContent, String newContent) {
        if (oldContent == null) {
            return newContent == null;
        }

        return oldContent.equals(newContent);
    }
}