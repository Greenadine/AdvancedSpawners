package dev.greenadine.advancedspawners.exception;

/**
 * Thrown when a
 */
public class NoDefinedSpawnerLevelsException extends RuntimeException {

    public NoDefinedSpawnerLevelsException() {
        super("No configured levels found. This is necessary for upgrading spawners. Disabling plugin...");
    }
}
