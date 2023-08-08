package com.artillexstudios.axinventoryrestore.config.impl;

import com.artillexstudios.axinventoryrestore.AxInventoryRestore;
import com.artillexstudios.axinventoryrestore.config.AbstractConfig;
import dev.dejvokep.boostedyaml.YamlDocument;
import dev.dejvokep.boostedyaml.dvs.versioning.BasicVersioning;
import dev.dejvokep.boostedyaml.settings.dumper.DumperSettings;
import dev.dejvokep.boostedyaml.settings.general.GeneralSettings;
import dev.dejvokep.boostedyaml.settings.loader.LoaderSettings;
import dev.dejvokep.boostedyaml.settings.updater.UpdaterSettings;

import java.io.File;

public class Config implements AbstractConfig {
    private YamlDocument file = null;

    @Override
    public void setup() {
        try {
            file = YamlDocument.create(new File(AxInventoryRestore.getInstance().getDataFolder(), "config.yml"), AxInventoryRestore.getInstance().getResource("config.yml"), GeneralSettings.builder().setUseDefaults(false).build(), LoaderSettings.builder().setAutoUpdate(true).build(), DumperSettings.DEFAULT, UpdaterSettings.builder().setVersioning(new BasicVersioning("version")).build());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public YamlDocument getConfig() {
        return file;
    }
}
