package dev.greenadine.advancedspawners.util.config.model;

public class ConfigInteger extends ConfigSetting<Integer> {

    public ConfigInteger(final String path, final int def) {
        super(path, def);
    }

    @Override
    protected Integer getImpl() {
        return config.getInt(path);
    }

    @Override
    public boolean isValueValid() {
        return config.isInt(path);
    }
}
