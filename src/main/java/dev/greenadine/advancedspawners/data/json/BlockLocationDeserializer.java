package dev.greenadine.advancedspawners.data.json;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.bukkit.Location;

import java.io.IOException;

public class BlockLocationDeserializer extends StdDeserializer<Location> {

    protected BlockLocationDeserializer() {
        super(Location.class);
    }

    @Override
    public Location deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        return null;
    }
}
