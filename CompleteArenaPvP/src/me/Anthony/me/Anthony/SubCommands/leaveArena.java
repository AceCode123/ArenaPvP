package me.Anthony.me.Anthony.SubCommands;

import me.Anthony.ArenaManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Created by thresher1436 on 1/31/2016.
 */
public class leaveArena extends SubCommand {

    @Override
    public void onCommand(Player p, String[] args) {
        p.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + "M" + ChatColor.RED + "L" + ChatColor.BLUE + "M" + ChatColor.RED + "]" + ChatColor.YELLOW + "Working on it...");
        ArenaManager.getManager().removePlayer(p);
    }

    @Override
    public String name() {
        return "leaveArena";
    }

    @Override
    public String info() {
        return ChatColor.YELLOW + "Leaves the Current Arena you are In!";
    }

    @Override
    public String[] aliases() {
        return new String[] { "leave" };
    }
}
