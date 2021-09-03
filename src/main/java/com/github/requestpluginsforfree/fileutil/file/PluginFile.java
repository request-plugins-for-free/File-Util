package com.github.requestpluginsforfree.fileutil.file;

import com.github.requestpluginsforfree.fileutil.file.yaml.PluginYaml;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
public class PluginFile extends PluginYaml {
    private final Plugin plugin;
    private final File directory;
    private final File file;

    public PluginFile(final Plugin plugin, final File directory, final String name){
        this.plugin = plugin;
        this.directory = directory;
        this.file = new File(directory, name);
    }

    public File initialize(boolean directory){
        if (directory) file.mkdir();
        else if (!file.exists()) plugin.saveResource(file.getName(), false);
        return file;
    }

    @Override
    public FileConfiguration configuration() {
        if (super.configuration() == null) configuration(YamlConfiguration.loadConfiguration(file));
        return super.configuration();
    }

    public File directory() {
        return directory;
    }

    public File file() {
        return this.file;
    }
}
