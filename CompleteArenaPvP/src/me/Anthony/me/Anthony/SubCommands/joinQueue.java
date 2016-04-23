package me.Anthony.me.Anthony.SubCommands;

import me.Anthony.ArenaManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Created by thresher1436 on 1/31/2016.
 */
public class joinQueue extends SubCommand {

    @Override
    public void onCommand(Player p, String[] args) {
        String type = args[1].toString();
        p.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + "M" + ChatColor.RED + "L" + ChatColor.BLUE + "M" + ChatColor.RED + "]" + ChatColor.YELLOW + "Working on it...");
        ArenaManager.getManager().joinQueue(p, type);
    }

    @Override
    public String name() {
        return "joinQueue";
    }

    @Override
    public String info() {
        return ChatColor.YELLOW + "Joins An Arena Queue!";
    }

    @Override
    public String[] aliases() {
        return new String[] { "queue" };
    }
}
