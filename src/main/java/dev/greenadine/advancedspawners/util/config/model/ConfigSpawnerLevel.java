package dev.greenadine.advancedspawners.util.config.model;

import com.google.common.base.Preconditions;
import dev.greenadine.advancedspawners.exception.InvalidSpawnerLevelException;
import dev.greenadine.advancedspawners.spawner.SpawnerLevel;
import org.bukkit.Effect;
import org.bukkit.Particle;

public class ConfigSpawnerLevel extends ConfigSetting<SpawnerLevel> {

    private int level;

    private ConfigSpawnerLevel(final String path, final SpawnerLevel def) {
        super(path, def);
    }

    public ConfigSpawnerLevel(final int level, final SpawnerLevel def) {
        this("levels." + level, def);

        this.level = level;
    }

    @Override
    @SuppressWarnings("ConstantConditions")
    protected SpawnerLevel getImpl() {
        final int cost = config.getInt(path + ".cost");
        final int minSpawnDelay = config.getInt(path + ".minSpawnDelay");
        final int maxSpawnDelay = config.getInt(path + ".maxSpawnDelay");
        final int spawnCount = config.getInt(path + ".spawnCount");
        final String[] arr = config.getString(path + ".effect").split(";");

        final SpawnerLevelBuilder builder = new SpawnerLevelBuilder(level, cost, minSpawnDelay, maxSpawnDelay, spawnCount);

        try {
            if (arr[0].equalsIgnoreCase("effect")) {
                builder.setEffect(Effect.valueOf(arr[1]));
            }
            else if (arr[0].equalsIgnoreCase("particle")) {
                builder.setParticle(Particle.valueOf(arr[1]));
            }
        } catch (IllegalArgumentException ex) {
            throw new InvalidSpawnerLevelException(level);
        }

        return builder.build();
    }

    @Override
    @SuppressWarnings("ConstantConditions")
    public boolean isValueValid() {
        if (!config.isConfigurationSection(path)
                || !config.isInt(path + ".cost")
                || !config.isInt(path + ".minSpawnDelay")
                || !config.isInt(path + ".maxSpawnDelay")
                || !config.isString(path + ".effect")
                || config.getString(path + ".effect").split(";").length != 2) {
            return false;
        }

        final String[] arr = config.getString(path + ".effect").split(";");

        if (arr[0].equalsIgnoreCase("effect")) {
            try {
                Effect.valueOf(arr[1]);
            } catch (IllegalArgumentException ex) {
                return false;
            }
        }
        else if (arr[0].equals("particle")) {
            try {
                Particle.valueOf(arr[1]);
            } catch (IllegalArgumentException ex) {
                return false;
            }
        }
        else {
            return false;
        }

        return true;
    }

    private static class SpawnerLevelBuilder {

        private final int level;
        private final int cost;
        private final int minSpawnDelay;
        private final int maxSpawnDelay;
        private final int spawnCount;
        private Effect effect;
        private Particle particle;

        private SpawnerLevelBuilder(final int level, final int cost, final int minSpawnDelay, final int maxSpawnDelay, final int spawnCount) {
            this.level = level;
            this.cost = cost;
            this.minSpawnDelay = minSpawnDelay;
            this.maxSpawnDelay = maxSpawnDelay;
            this.spawnCount = spawnCount;
        }

        private void setEffect(final Effect effect) {
            this.effect = effect;
        }

        private void setParticle(final Particle particle) {
            this.particle = particle;
        }

        private SpawnerLevel build() {
            Preconditions.checkState(effect != null || particle != null, "No effect or particle defined.");

            if (effect != null) {
                return new SpawnerLevel(level, cost, minSpawnDelay, maxSpawnDelay, spawnCount, effect);
            } else {
                return new SpawnerLevel(level, cost, minSpawnDelay, maxSpawnDelay, spawnCount, particle);
            }
        }
    }
}
