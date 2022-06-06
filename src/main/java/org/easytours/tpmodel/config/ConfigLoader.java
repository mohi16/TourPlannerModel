package org.easytours.tpmodel.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.easytours.tpmodel.logging.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class ConfigLoader {

    public static <T> T load(Class<T> t, String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            throw new IOException("No Config File");
        }

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

        return mapper.readValue(file, t);
    }

    public static void save() {
        // save config
    }

}
