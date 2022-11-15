package dev.greenadine.advancedspawners.data.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import dev.greenadine.advancedspawners.util.Logger;
import dev.greenadine.advancedspawners.util.Util;
import dev.greenadine.advancedspawners.spawner.AdvancedSpawner;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;

import java.io.IOException;
import java.util.logging.Level;

public class AdvancedSpawnerDeserializer extends StdDeserializer<AdvancedSpawner> {

    protected AdvancedSpawnerDeserializer() {
        super(AdvancedSpawner.class);
    }

    @Override
    public AdvancedSpawner deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        ObjectMapper mapper = (ObjectMapper) p.getCodec();
        JsonNode node = mapper.readTree(p);

        final Location location = mapper.readValue(node.get("location").traverse(), Location.class);
        final Block block = location.getWorld().getBlockAt(location);

        if (!(block.getState() instanceof CreatureSpawner)) {
            // TODO log invalid block state
            // TODO delete spawner save file/entry
            Logger.logf(Level.WARNING, "Block at location '%s' is not a mob spawner (anymore), marked for deletion.", Util.blockLocationToString(location));
            return null; // TODO maybe throw exception instead ??? no fuckin clue
        }

        Integer minSpawnDelay = null;
        Integer maxSpawnDelay = null;
        Integer spawnCount = null;

        if (node.has("minSpawnDelay")) {
            minSpawnDelay = node.get("minSpawnDelay").intValue();
        }
        if (node.has("maxSpawnDelay")) {
            maxSpawnDelay = node.get("maxSpawnDelay").intValue();
        }
        if (node.has("spawnCount")) {
            spawnCount = node.get("spawnCount").intValue();
        }

        final int level = node.get("level").intValue();

        return new AdvancedSpawner(block, level, minSpawnDelay, maxSpawnDelay, spawnCount);
    }
}
