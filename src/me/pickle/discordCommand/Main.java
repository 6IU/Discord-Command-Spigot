package me.pickle.discordCommand;

import org.bukkit.plugin.java.JavaPlugin;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class Main extends JavaPlugin{
	@Override
	public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this);
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "\n\nDiscord command has been Enabled\n\n");
	}
	
	public void onDisable() {
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "\nDiscord command has been disabled!\n");
	}
	
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("discord") && sender instanceof Player) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("discordlink")));
        }
        return true;
    }
}
