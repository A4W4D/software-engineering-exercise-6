public interface WebsiteComparisonStrategy {
    boolean areIdentical(String oldContent, String newContent);
}