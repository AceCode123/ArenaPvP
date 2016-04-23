package me.Anthony;

import me.Anthony.me.Anthony.SubCommands.*;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by thresher1436 on 1/24/2016.
 */
public class CommandManager implements CommandExecutor {

    private ArrayList<SubCommand> commands = new ArrayList<SubCommand>();

    public void setup() {
        commands.add(new createArena());
        commands.add(new deleteArena());
        commands.add(new getELO());
        commands.add(new getMatchesLeft());
        commands.add(new joinArena());
        commands.add(new joinQueue());
        commands.add(new leaveSpectater());
        commands.add(new setArenaType());
        commands.add(new spectate());
        commands.add(new leaveArena());
        commands.add(new confirm());
        commands.add(new resetELO());

    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(!(sender instanceof Player)) {

            sender.sendMessage(ChatColor.YELLOW + "You are not a player!");

            return true;

        }

        Player p = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("ArenaPvP")) {

            if(args.length == 0) {

                for(SubCommand c : commands) {

                    p.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + "M" + ChatColor.RED + "L" + ChatColor.BLUE + "M" + ChatColor.RED + "]" + ChatColor.YELLOW + "/ArenaPvP " + c.name() + "");

                }

                return true;

            }

            SubCommand target = get(args[0]);

            if(target == null) {

                p.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + "M" + ChatColor.RED + "L" + ChatColor.BLUE + "M" + ChatColor.RED + "]" + ChatColor.YELLOW + "/ArenaPvP " + args[0] + "is not a runnable command!");

                return true;

            }


            ArrayList<String> a = new ArrayList<String>();

            a.addAll(Arrays.asList(args));

            a.remove(a);

            args = a.toArray(new String[a.size()]);


            try {

                target.onCommand(p, args);

            }


            catch (Exception e) {

                p.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + "M" + ChatColor.RED + "L" + ChatColor.BLUE + "M" + ChatColor.RED + "]" +ChatColor.YELLOW + "An error has ocurred while running this command! " + e.getCause());

                e.printStackTrace();

            }

        }

        return true;

    }

    private String aliases(SubCommand cmd) {

        String fin = "";


        for(String c : cmd.aliases()) {

            fin += c + " | ";

        }


        return fin.substring(0, fin.lastIndexOf("| "));

    }

    private SubCommand get(String name) {

        for(SubCommand cmd : commands) {

            if(cmd.name().equalsIgnoreCase(name)) return cmd;

            for(String alias : cmd.aliases()) if(name.equalsIgnoreCase(alias)) return cmd;

        }

        return null;

    }

}
