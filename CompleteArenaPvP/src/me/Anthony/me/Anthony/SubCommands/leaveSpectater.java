package me.Anthony.me.Anthony.SubCommands;

import me.Anthony.ArenaManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Created by thresher1436 on 1/31/2016.
 */
public class leaveSpectater extends SubCommand {


    @Override
    public void onCommand(Player p, String[] args) {
        if(p.hasPermission("Arena.Major")) {
            p.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + "M" + ChatColor.RED + "L" + ChatColor.BLUE + "M" + ChatColor.RED + "]" + ChatColor.YELLOW + "Working on it...");
            ArenaManager.getManager().leaveSpectator(p);
        } else {
            p.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + "M" + ChatColor.RED + "L" + ChatColor.BLUE + "M" + ChatColor.RED + "]" + ChatColor.YELLOW + "This is A Major Leaguer Command! To unlock this and more cool features donate Major Leaguer with /buy!");
        }
    }

    @Override
    public String name() {
        return "leaveSpectator";
    }

    @Override
    public String info() {
        return ChatColor.YELLOW + "Removes you as a Spectator!";
    }

    @Override
    public String[] aliases() {
        return new String[] { "leaveS" };
    }
}
