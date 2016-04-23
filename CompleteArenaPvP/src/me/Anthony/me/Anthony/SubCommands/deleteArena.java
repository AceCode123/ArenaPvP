package me.Anthony.me.Anthony.SubCommands;

import me.Anthony.ArenaManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Created by thresher1436 on 1/31/2016.
 */
public class deleteArena extends SubCommand {


    @Override
    public void onCommand(Player p, String[] args) {
        if(p.isOp()) {
            int id = 0;
            try {
                id = Integer.parseInt(args[1]);
            } catch(NumberFormatException e) {
                p.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + "M" + ChatColor.RED + "L" + ChatColor.BLUE + "M" + ChatColor.RED + "]" +ChatColor.YELLOW + "Invalid Arena Id");
            }
            if(ArenaManager.getManager().isArena(id)) {
                ArenaManager.getManager().deleteArena(id);
                p.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + "M" + ChatColor.RED + "L" + ChatColor.BLUE + "M" + ChatColor.RED + "]" + ChatColor.YELLOW + "Successfully deleted Arena " + id + ".");
            } else {
                p.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + "M" + ChatColor.RED + "L" + ChatColor.BLUE + "M" + ChatColor.RED + "]" + ChatColor.YELLOW + "Invalid Arena Id!");
            }
        }
    }

    @Override
    public String name() {
        return "deleteArena";
    }

    @Override
    public String info() {
        return ChatColor.YELLOW + "Deletes An Arena - Permission OP";
    }

    @Override
    public String[] aliases() {
        return new String[] { "deleteA" };
    }
}
