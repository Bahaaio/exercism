public class LogLevels {

    public static String message(String logLine) {
        int messageStart = logLine.indexOf(':') + 1;
        String message = logLine.substring(messageStart);

        return message.trim();
    }

    public static String logLevel(String logLine) {
        int logLevelEnd = logLine.indexOf(']', 1);
        String level = logLine.substring(1, logLevelEnd);

        return level.toLowerCase();
    }

    public static String reformat(String logLine) {
        return message(logLine) + " (" + logLevel(logLine) + ")";
    }
}
