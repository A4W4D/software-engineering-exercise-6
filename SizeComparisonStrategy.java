public class SizeComparisonStrategy implements WebsiteComparisonStrategy {
    @Override
    public boolean areIdentical(String oldContent, String newContent) {
        if (oldContent == null || newContent == null) {
            return false;
        }
        return oldContent.length() == newContent.length();
    }
}