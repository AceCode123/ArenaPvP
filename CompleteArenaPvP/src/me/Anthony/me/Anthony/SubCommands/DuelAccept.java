package me.Anthony.me.Anthony.SubCommands;

import org.bukkit.entity.Player;

/**
 * Created by thresher1436 on 2/19/2016.
 */
public class DuelAccept extends SubCommand {
    @Override
    public void onCommand(Player p, String[] args) {

    }

    @Override
    public String name() {
        return "DuelAccept";
    }

    @Override
    public String info() {
        return "Accepts a pending duel request!";
    }

    @Override
    public String[] aliases() {
        return new String[] { "accept" };
    }
}
