package me.Anthony.me.Anthony.SubCommands;

import org.bukkit.entity.Player;

/**
 * Created by thresher1436 on 1/24/2016.
 */
public abstract class SubCommand {

    public abstract void onCommand(Player p, String[] args);

    public abstract String name();

    public abstract String info();

    public abstract String[] aliases();


}
