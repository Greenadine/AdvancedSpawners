package dev.greenadine.advancedspawners.data.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import dev.greenadine.advancedspawners.spawner.AdvancedSpawner;

import java.io.IOException;

public class AdvancedSpawnerSerializer extends StdSerializer<AdvancedSpawner> {

    protected AdvancedSpawnerSerializer() {
        super(AdvancedSpawner.class);
    }

    @Override
    public void serialize(AdvancedSpawner spawner, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();

        gen.writeObjectField("location", spawner.getLocation());
        gen.writeNumberField("level", spawner.getLevel().asInt());

        if (spawner.hasCustomMinSpawnDelay()) {
            gen.writeNumberField("minSpawnDelay", spawner.getMinSpawnDelay());
        }
        if (spawner.hasCustomMaxSpawnDelay()) {
            gen.writeNumberField("maxSpawnDelay", spawner.getMaxSpawnDelay());
        }
        if (spawner.hasCustomSpawnCount()) {
            gen.writeNumberField("spawnCount", spawner.getSpawnCount());
        }

        gen.writeEndObject();
    }
}
