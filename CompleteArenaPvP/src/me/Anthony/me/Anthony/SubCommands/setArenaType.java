package me.Anthony.me.Anthony.SubCommands;

import me.Anthony.ArenaManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Created by thresher1436 on 1/31/2016.
 */
public class setArenaType extends SubCommand {

    @Override
    public void onCommand(Player p, String[] args) {
        if(p.isOp()) {
            if(args.length < 2) {
                p.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + "M" + ChatColor.RED + "L" + ChatColor.BLUE + "M" + ChatColor.RED + "]" + ChatColor.YELLOW + "Improper Usage! Please use /setArenaType id");
                return;
            }
            int id = 0;
            try {
                id = Integer.parseInt(args[1]);
            } catch(NumberFormatException e) {
                p.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + "M" + ChatColor.RED + "L" + ChatColor.BLUE + "M" + ChatColor.RED + "]" + ChatColor.YELLOW + "Arena not found!");
                return;
            }
            String type = args[2];
            p.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + "M" + ChatColor.RED + "L" + ChatColor.BLUE + "M" + ChatColor.RED + "]" + ChatColor.YELLOW + "Working on it...");
            ArenaManager.getManager().getArena(id).setType(type);
            p.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + "M" + ChatColor.RED + "L" + ChatColor.BLUE + "M" + ChatColor.RED + "]" + ChatColor.YELLOW + "Successfully Changed!");

        }
    }

    @Override
    public String name() {
       return "setArenaType";
    }

    @Override
    public String info() {
        return ChatColor.YELLOW + "Sets an Arena's Type - OP Permission";
    }

    @Override
    public String[] aliases() {
        return new String[] { "setArena" };
    }
}
