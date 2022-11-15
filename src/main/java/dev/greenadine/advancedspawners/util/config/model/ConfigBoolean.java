package dev.greenadine.advancedspawners.util.config.model;

public class ConfigBoolean extends ConfigSetting<Boolean> {

    public ConfigBoolean(final String path, final boolean def) {
        super(path, def);
    }

    @Override
    protected Boolean getImpl() {
        return config.getBoolean(path);
    }

    @Override
    public boolean isValueValid() {
        return config.isBoolean(path);
    }
}
