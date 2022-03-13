public class LogLevels {

    public static String message(String logLine) {
        String[] parts = logLine.split(":", 2);
        String message = parts[1].trim();
        return message;
    }

    public static String logLevel(String logLine) {
        String[] parts = logLine.split(":", 2);
        if (parts[0].contains("ERROR")) {
            return "error";
        } else if (parts[0].contains("WARNING")) {
            return "warning";
        } else if (parts[0].contains("INFO")) {
            return "info";
        } else {
            return "bad line";
        }
    }

    public static String reformat(String logLine) {
        return message(logLine) + " (" + logLevel(logLine) + ")";
    }
}
