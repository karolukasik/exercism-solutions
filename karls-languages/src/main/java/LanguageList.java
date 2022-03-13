import java.util.ArrayList;
import java.util.List;

public class LanguageList {
    private final List<String> languages = new ArrayList<>();

    public boolean isEmpty() {
        return languages.isEmpty();
    }

    public void addLanguage(String language) {
        if (!containsLanguage(language)) {
            languages.add(language);
        }
    }

    public void removeLanguage(String language) {
        if (containsLanguage(language)) {
            languages.remove(language);
        }
    }

    public String firstLanguage() {
        if (!isEmpty()) {
            return languages.get(0);
        } else {
            return "List is empty";
        }
    }

    public int count() {
        return languages.size();
    }

    public boolean containsLanguage(String language) {
        return languages.contains(language);
    }

    public boolean isExciting() {
        if (containsLanguage("Java") || containsLanguage("Kotlin")) {
            return true;
        }
        return false;
    }
}
