package me.Anthony.me.Anthony.SubCommands;

import me.Anthony.ArenaManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Created by thresher1436 on 1/31/2016.
 */
public class createArena extends SubCommand {
    @Override
    public void onCommand(Player p, String[] args) {
        if(p.isOp()) {
            Player p2 = Bukkit.getPlayer(args[1]);
            String type = args[2];
            ArenaManager.getManager().createArena(p.getLocation(),p2.getLocation(), type);
            p.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + "M" + ChatColor.RED + "L" + ChatColor.BLUE + "M" + ChatColor.RED + "]" + ChatColor.YELLOW + "Successfully Created Arena with Type, " + type + "!");
        } else {
         p.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + "M" + ChatColor.RED + "L" + ChatColor.BLUE + "M" + ChatColor.RED + "]" + ChatColor.YELLOW + "You are not op! Coud not execute command!");
        }
    }

    @Override
    public String name() {
        return "createArena";
    }

    @Override
    public String info() {
        return ChatColor.YELLOW + "Creates An Arena! - OP Permission";
    }

    @Override
    public String[] aliases() {
        return new String[] {"create"};
    }
}
