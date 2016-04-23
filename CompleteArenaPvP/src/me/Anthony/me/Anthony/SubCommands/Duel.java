package me.Anthony.me.Anthony.SubCommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by thresher1436 on 2/19/2016.
 */
public class Duel extends SubCommand {

    public static Map<Player, Player> duel = new HashMap<Player, Player>();

    @Override
    public void onCommand(Player p, String[] args) {
        if(p.hasPermission("Arena.Major")) {

            try {
               Player opponent = Bukkit.getPlayer(args[0]);
                p.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + "M" + ChatColor.RED + "L" + ChatColor.BLUE + "M" + ChatColor.RED + "]" + ChatColor.YELLOW + "Duel, Request Successfully sent!");
                opponent.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + "M" + ChatColor.RED + "L" + ChatColor.BLUE + "M" + ChatColor.RED + "]" + ChatColor.YELLOW);
            } catch(Exception e) {
                e.printStackTrace();
                p.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + "M" + ChatColor.RED + "L" + ChatColor.BLUE + "M" + ChatColor.RED + "]" + ChatColor.YELLOW + "Please enter an online Player's Name after the command!");
            }
        } else {
            p.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + "M" + ChatColor.RED + "L" + ChatColor.BLUE + "M" + ChatColor.RED + "]" + ChatColor.YELLOW + "Currently this is only A Famous Perk! If you want to unlock this and other cool features buy the Famous Rank with /buy!");
        }
    }

    @Override
    public String name() {
        return "Duel";
    }

    @Override
    public String info() {
        return "Duels a player!";
    }

    @Override
    public String[] aliases() {
        return new String[] { "challenge" };
    }
}
