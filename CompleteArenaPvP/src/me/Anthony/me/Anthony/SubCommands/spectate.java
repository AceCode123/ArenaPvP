package me.Anthony.me.Anthony.SubCommands;

import me.Anthony.ArenaManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Created by thresher1436 on 1/31/2016.
 */
public class spectate extends SubCommand {

    @Override
    public void onCommand(Player p, String[] args) {
        if(p.hasPermission("Arena.Major")) {
            if(args.length < 1) {
                p.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + "M" + ChatColor.RED + "L" + ChatColor.BLUE + "M" + ChatColor.RED + "]" + ChatColor.YELLOW + "Improper Usage! Use /spectate player");
                return;
            }
            Player toSpec = Bukkit.getPlayer(args[1]);
            p.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + "M" + ChatColor.RED + "L" + ChatColor.BLUE + "M" + ChatColor.RED + "]" + ChatColor.YELLOW + "Working on it!");
            if(toSpec.isOnline()) {
                if (ArenaManager.getManager().isInGame(toSpec)) {
                    ArenaManager.getManager().addSpectator(p, toSpec);
                } else {
                    p.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + "M" + ChatColor.RED + "L" + ChatColor.BLUE + "M" + ChatColor.RED + "]" + ChatColor.YELLOW + "This player is currently not in a Game!");
                }
            } else {
                p.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + "M" + ChatColor.RED + "L" + ChatColor.BLUE + "M" + ChatColor.RED + "]" + ChatColor.YELLOW + "Could not locate the Player!");
            }
        } else {
            p.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + "M" + ChatColor.RED + "L" + ChatColor.BLUE + "M" + ChatColor.RED + "]" + ChatColor.YELLOW + "Currently this is only A Famous Perk! If you want to unlock this and other cool features buy the Famous Rank with /buy!");
        }
    }

    @Override
    public String name() {
        return "Spectate";
    }

    @Override
    public String info() {
        return ChatColor.YELLOW + "Spectates An Arena - Famous Permission!";
    }

    @Override
    public String[] aliases() {
        return new String[] { "spec" };
    }
}
