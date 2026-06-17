public class SizeComparisonStrategy implements WebsiteComparisonStrategy {

    @Override
    public boolean areIdentical(String oldContent, String newContent) {
        if (oldContent == null || newContent == null) {
            return oldContent == newContent;
        }
        return oldContent.length() == newContent.length();
    }
}
