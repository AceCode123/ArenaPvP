package me.Anthony.me.Anthony.SubCommands;

import me.Anthony.ArenaManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Created by thresher1436 on 1/31/2016.
 */
public class joinArena extends SubCommand {
    @Override
    public void onCommand(Player p, String[] args) {
        int id = 0;
        try {
           id = Integer.parseInt(args[1]);
        } catch(NumberFormatException e) {
            p.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + "M" + ChatColor.RED + "L" + ChatColor.BLUE + "M" + ChatColor.RED + "]" + ChatColor.YELLOW + "Arena not found!");
            return;
        }
        ArenaManager.getManager().addPlayer(id, p);
    }

    @Override
    public String name() {
        return "joinArena";
    }

    @Override
    public String info() {
        return ChatColor.YELLOW + "Joins An Arena!";
    }

    @Override
    public String[] aliases() {
        return new String[] { "join" };
    }
}
