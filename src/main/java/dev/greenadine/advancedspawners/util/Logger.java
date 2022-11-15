package dev.greenadine.advancedspawners.util;

import dev.greenadine.advancedspawners.AdvancedSpawners;
import dev.greenadine.advancedspawners.util.config.ASConfig;

import java.util.logging.Level;

public final class Logger {

    private static final java.util.logging.Logger logger = AdvancedSpawners.getInstance().getLogger();

    private static final boolean debug = ASConfig.DEBUG;

    /* Logging */

    public static void log(final String message) {
        log(Level.INFO, message);
    }

    public static void log(final Level level, final String message) {
        logger.log(level, message);
    }

    /* Formatted logging */

    public static void logf(final String message, final Object... replacements) {
        log(String.format(message, replacements));
    }

    public static void logf(final Level level, final String message, final Object... replacements) {
        log(level, String.format(message, replacements));
    }

    /* Error logging */

    public static void error(final Throwable thrown, final String message) {
        error(Level.SEVERE, thrown, message);
    }

    public static void error(final Level level, final Throwable thrown, final String message) {
        logger.log(level, thrown, () -> message);
    }

    /* Formatted error logging */

    public static void errorf(final Throwable thrown, final String message, final Object... replacements) {
        error(thrown, String.format(message, replacements));
    }

    public static void errorf(final Level level, final Throwable thrown, final String message, final Object... replacements) {
        error(level, thrown, String.format(message, replacements));
    }

    /* Debug logging */

    public static void debug(final String message) {
        debug(Level.INFO, message);
    }

    public static void debug(final Level level, final String message) {
        log(level, "DEBUG :: " + message);
    }

    /* Formatted debug logging */

    public static void debugf(final String message, final Object... replacements) {
        debug(String.format(message, replacements));
    }

    public static void debugf(final Level level, final String message, final Object... replacements) {
        debug(level, String.format(message, replacements));
    }
}
