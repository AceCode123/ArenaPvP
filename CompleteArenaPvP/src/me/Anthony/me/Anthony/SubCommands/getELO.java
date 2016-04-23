package me.Anthony.me.Anthony.SubCommands;

import me.Anthony.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Created by thresher1436 on 1/31/2016.
 */
public class getELO extends SubCommand {


    @Override
    public void onCommand(Player p, String[] args) {
        p.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + "M" + ChatColor.RED + "L" + ChatColor.BLUE + "M" + ChatColor.RED + "]" + ChatColor.YELLOW + "Your ELO is currently " + Main.config.getInt(p.getUniqueId() + ".elo") + ".");
    }

    @Override
    public String name() {
        return "getELO";
    }

    @Override
    public String info() {
        return ChatColor.YELLOW + "Gets your current ELO!";
    }

    @Override
    public String[] aliases() {
        return new String[] { "elo" };
    }
}
