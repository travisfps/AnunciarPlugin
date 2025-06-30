package me.anunciar;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class AnunciarAdminCommand implements CommandExecutor {

    private AnunciarStyle plugin;

    public AnunciarAdminCommand(AnunciarStyle plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
            if (!sender.hasPermission("anunciar.admin")) {
                sender.sendMessage(ChatColor.RED + "Você não tem permissão para isso.");
                return true;
            }

            plugin.reloadConfig();
            sender.sendMessage(ChatColor.GREEN + "Configuração recarregada com sucesso!");
            return true;
        }
        sender.sendMessage(ChatColor.RED + "Uso correto: /anunciaradmin reload");
        return true;
    }
}
