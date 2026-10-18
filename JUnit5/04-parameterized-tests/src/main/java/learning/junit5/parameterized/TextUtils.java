package learning.junit5.parameterized;

public class TextUtils {
    public boolean isBlank(String text) {
        return text == null || text.trim().isEmpty();
    }

    public String repeat(String text, int count) {
        return text.repeat(count);
    }
}
