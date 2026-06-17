public class TextContentComparisonStrategy implements WebsiteComparisonStrategy {
    @Override
    public boolean areIdentical(String oldContent, String newContent) {
        if (oldContent == null || newContent == null) {
            return false;
        }

        String oldText = oldContent.replaceAll("<[^>]*>", "").replaceAll("\\s+", " ").trim();
        String newText = newContent.replaceAll("<[^>]*>", "").replaceAll("\\s+", " ").trim();

        return oldText.equals(newText);
    }
}