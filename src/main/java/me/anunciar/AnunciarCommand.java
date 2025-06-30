package me.anunciar;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.ChatComponentText;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.configuration.file.FileConfiguration;

public class AnunciarCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        FileConfiguration config = AnunciarStyle.getInstance().getConfig();

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Mensagem-Apenas-Jogador", "&cApenas jogadores podem usar esse comando.")));
            return true;
        }

        Player player = (Player) sender;

        String perm = config.getString("Permissao", "anunciar.usar");
        if (!player.hasPermission(perm)) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Mensagem-Sem-Permissao", "&cVocê não tem permissão para usar esse comando.")));
            return true;
        }

        if (args.length == 0) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Comando-Incorreto", "&cUso incorreto, use /anunciar <mensagem>")));
            return true;
        }

        String msg = String.join(" ", args);
        String chatMsg = config.getString("Chat", "&eAnúncio:\n%alerta%").replace("%alerta%", msg);
        String title = config.getString("Title", "&e&lAviso");
        String subtitle = config.getString("SubTitle", "&eNovo anúncio!");

        for (Player p : Bukkit.getOnlinePlayers()) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', chatMsg));
            sendTitle(p,
                    ChatColor.translateAlternateColorCodes('&', title),
                    ChatColor.translateAlternateColorCodes('&', subtitle),
                    10, 40, 10
            );
        }

        return true;
    }

    private void sendTitle(Player player, String title, String subtitle, int fadeIn, int stay, int fadeOut) {
        CraftPlayer craftPlayer = (CraftPlayer) player;

        IChatBaseComponent titleComp = new ChatComponentText(title);
        IChatBaseComponent subtitleComp = new ChatComponentText(subtitle);

        PacketPlayOutTitle titlePacket = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, titleComp, fadeIn, stay, fadeOut);
        PacketPlayOutTitle subtitlePacket = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, subtitleComp, fadeIn, stay, fadeOut);

        craftPlayer.getHandle().playerConnection.sendPacket(titlePacket);
        craftPlayer.getHandle().playerConnection.sendPacket(subtitlePacket);
    }
}
