package com.github.requestpluginsforfree.fileutil.file;

import com.github.requestpluginsforfree.fileutil.file.yaml.PluginYaml;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class PluginFile extends PluginYaml {
    private final File directory;
    private final File file;

    public PluginFile(final File directory, final String name){
        this.directory = directory;
        this.file = new File(directory, name);
    }

    public File initialize(boolean directory){
        if (directory) file.mkdir();
        else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    @Override
    public FileConfiguration configuration() {
        if (super.configuration() == null) configuration(YamlConfiguration.loadConfiguration(file));
        return super.configuration();
    }

    private File directory() {
        return directory;
    }

    private File file() {
        return file;
    }
}
