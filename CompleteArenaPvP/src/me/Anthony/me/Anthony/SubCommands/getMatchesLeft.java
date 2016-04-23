package me.Anthony.me.Anthony.SubCommands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Created by thresher1436 on 1/31/2016.
 */
public class getMatchesLeft extends SubCommand {
    @Override
    public void onCommand(Player p, String[] args) {

    }

    @Override
    public String name() {
        return "getMatchesLeft";
    }

    @Override
    public String info() {
        return ChatColor.YELLOW + "Gets the Amount of Matches you have left!";
    }

    @Override
    public String[] aliases() {
        return new String[] { "Matches" };
    }
}
