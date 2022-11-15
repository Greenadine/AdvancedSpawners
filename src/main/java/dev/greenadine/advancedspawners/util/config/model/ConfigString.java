package dev.greenadine.advancedspawners.util.config.model;

public class ConfigString extends ConfigSetting<String> {

    public ConfigString(final String path, final String def) {
        super(path, def);
    }

    @Override
    protected String getImpl() {
        return config.getString(path);
    }

    @Override
    public boolean isValueValid() {
        return config.isString(path);
    }
}
