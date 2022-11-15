package dev.greenadine.advancedspawners.api;

import dev.greenadine.advancedspawners.AdvancedSpawners;
import dev.greenadine.advancedspawners.util.Logger;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.URL;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

public interface AdvancedSpawnersAPI {

    /**
     * Gets the current API version number.
     *
     * @return The current API version.
     */
    static @NotNull String getVersion() {
        try {
            Class clazz = AdvancedSpawners.class;
            String className = clazz.getSimpleName() + ".class";
            String classPath = clazz.getResource(className).toString();
            if (!classPath.startsWith("jar")) {
                // Class not from JAR
                return "unknown";
            }
            String manifestPath = classPath.substring(0, classPath.lastIndexOf("!") + 1) +
                    "/META-INF/MANIFEST.MF";
            Manifest manifest = new Manifest(new URL(manifestPath).openStream());
            Attributes attr = manifest.getMainAttributes();
            return attr.getValue("Api-Version");
        } catch (IOException ex) {
            Logger.error(ex, "Failed to retrieve API version.");
            return "unknown";
        }
    }


}
