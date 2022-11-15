package dev.greenadine.advancedspawners.util.config.model;

public class ConfigDouble extends ConfigSetting<Double> {

    public ConfigDouble(final String path, final double def) {
        super(path, def);
    }

    @Override
    protected Double getImpl() {
        return config.getDouble(path);
    }

    @Override
    public boolean isValueValid() {
        return config.isDouble(path);
    }
}
