package dev.greenadine.advancedspawners.exception;

import dev.greenadine.advancedspawners.spawner.SpawnerLevel;

/**
 * Thrown when there's an invalidly defined {@link SpawnerLevel} in the plugin's configuration.
 * <p>
 * This exception should never occur during normal operations, and should in all cases be reported.
 *
 * @author Kevin Zuman
 * @since 0.6
 */
public class InvalidSpawnerLevelException extends RuntimeException {

    public InvalidSpawnerLevelException(final int level) {
        super(String.format("Invalid defined spawner level '%d' in config. This exception should never occur. Please create a ticket at http://bit.ly/AdvancedSpawners.", level));
    }
}
