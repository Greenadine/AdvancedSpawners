package dev.greenadine.advancedspawners.spawner;

/**
 * Represents a configured effect for {@link AdvancedSpawner}s.
 *
 * @author Kevin Zuman
 * @since 0.6
 */
public class SpawnerEffect {

    private final Type type;
    private final String value;

    public SpawnerEffect(final Type type, final String value) {
        this.type = type;
        this.value = value;
    }

    public final void play(final AdvancedSpawner spawner) {
        // TODO
    }

    public enum Type {
        NONE,
        EFFECT,
        PARTICLE
    }
}
