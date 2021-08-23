package com.github.requestpluginsforfree.fileutil.file.yaml;

import org.bukkit.configuration.file.FileConfiguration;

public class PluginYaml {
    private FileConfiguration configuration;

    public void configuration(final FileConfiguration configuration){
        this.configuration = configuration;
    }

    public FileConfiguration configuration() {
        return configuration;
    }
}
