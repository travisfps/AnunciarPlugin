package me.anunciar;

import org.bukkit.plugin.java.JavaPlugin;

public class AnunciarStyle extends JavaPlugin {

    private static AnunciarStyle instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        getCommand("anunciar").setExecutor(new AnunciarCommand());
        getCommand("anunciaradmin").setExecutor(new AnunciarAdminCommand(this));
    }

    public static AnunciarStyle getInstance() {
        return instance;
    }
}
