package me.Anthony.me.Anthony.SubCommands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;

/**
 * Created by thresher1436 on 3/30/2016.
 */
public class resetELO extends SubCommand {

    public static ArrayList<Player> confirm = new ArrayList<Player>();

    @Override
    public void onCommand(Player p, String[] args) {
        if(p.hasPermission("Arena.Major")) {
            confirm.add(p);
            p.sendMessage(ChatColor.GREEN + "Are you sure about this? Type '/arenapvp confirm' to confirm this decision!");
        } else {
            p.sendMessage(ChatColor.RED + "You are not high enough rank to perform this command!");
        }
    }

    @Override
    public String name() {
        return "ResetELO";
    }

    @Override
    public String info() {
        return "Resets a player's ELO.";
    }

    @Override
    public String[] aliases() {
        return new String[] { "reset" };
    }
}
