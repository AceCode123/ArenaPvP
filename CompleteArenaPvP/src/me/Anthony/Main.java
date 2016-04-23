package me.Anthony;

import me.Anthony.me.Anthony.SubCommands.BuildUHC;
import me.Anthony.me.Anthony.SubCommands.Lobby;
import net.minecraft.server.v1_8_R3.PacketDataSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerInfo;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;


/**
 * Created by thresher1436 on 1/24/2016.
 */
public class Main extends JavaPlugin{

    public static File f = new File("plugins/CompleteArenaPvP/Elo.yml");
    public static FileConfiguration config = YamlConfiguration.loadConfiguration(f);

    public void generateELO() {
        if(f == null) {
            f.mkdir();
        }
        try {
            config.save(f);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    public void onEnable() {
        System.out.println("ArenaPvP Enabled!");
        Permission pm = new Permission("Arena.Major");
        Bukkit.getPluginManager().addPermission(pm);
        Bukkit.getServer().getPluginManager().registerEvents(new ArenaEvents(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new JoinItems(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new BuildUHC(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new Lobby(), this);
        CommandManager cm = new CommandManager();
        getCommand("ArenaPvP").setExecutor(cm);
        cm.setup();
        generateELO();
    }
    public void onDisable() {
    }


    public static void sendPackets(Player p) {
        PacketPlayOutPlayerInfo packet = new PacketPlayOutPlayerInfo();

    }

}
