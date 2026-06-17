public class TextContentComparisonStrategy implements WebsiteComparisonStrategy {

    @Override
    public boolean areIdentical(String oldContent, String newContent) {
        if (oldContent == null || newContent == null) {
            return oldContent == newContent;
        }

        String oldText = extractText(oldContent);
        String newText = extractText(newContent);

        return oldText.equals(newText);
    }

    private String extractText(String htmlContent) {
        return htmlContent
                .replaceAll("<[^>]*>", " ")
                .replaceAll("\\s+", " ")
                .trim();
    }
}
