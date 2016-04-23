package me.Anthony.me.Anthony.SubCommands;

import me.Anthony.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Created by thresher1436 on 3/30/2016.
 */
public class confirm extends SubCommand {
    @Override
    public void onCommand(Player p, String[] args) {
        if(resetELO.confirm.contains(p)) {
            Main.config.set(p.getUniqueId() + ".elo", 1400);
            p.sendMessage(ChatColor.YELLOW + "Successfully reset your ELO! Good Luck!");
            resetELO.confirm.remove(p);

        } else {
            p.sendMessage(ChatColor.YELLOW + "You have nothing to confirm!");
        }
    }

    @Override
    public String name() {
        return "confirm";
    }

    @Override
    public String info() {
        return "Confirms an ELO reset!";
    }

    @Override
    public String[] aliases() {
        return new String[] { "commit", "complete" };
    }
}
