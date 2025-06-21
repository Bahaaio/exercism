public class LogLine {
    private final String logLine;

    public LogLine(String logLine) {
        this.logLine = logLine;
    }

    public LogLevel getLogLevel() {
        String logLevelString = logLine.substring(1, logLine.indexOf("]"));
        return LogLevel.fromString(logLevelString);
    }

    public String getOutputForShortLog() {
        return getLogLevel().getCode() + ":" + logLine.substring(logLine.indexOf(":") + 2);
    }
}
