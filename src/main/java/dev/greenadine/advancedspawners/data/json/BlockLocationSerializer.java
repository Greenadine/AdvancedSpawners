package dev.greenadine.advancedspawners.data.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.bukkit.Location;

import java.io.IOException;

public class BlockLocationSerializer extends StdSerializer<Location> {

    protected BlockLocationSerializer() {
        super(Location.class);
    }

    @Override
    public void serialize(Location location, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();

        gen.writeStringField("world", location.getWorld().getName());
        gen.writeNumberField("x", location.getBlockX());
        gen.writeNumberField("y", location.getBlockY());
        gen.writeNumberField("z", location.getBlockZ());

        gen.writeEndObject();
    }
}
