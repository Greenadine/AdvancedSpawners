package nl.greenadine.advancedspawners.data.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import nl.greenadine.advancedspawners.spawner.AdvancedSpawner;

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

        gen.writeEndObject();
    }
}
