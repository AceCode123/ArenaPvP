package me.Anthony;

import me.Anthony.me.Anthony.SubCommands.BuildUHC;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.io.IOException;

/**
 * Created by thresher1436 on 1/28/2016.
 */
public class ArenaEvents implements Listener {

    @EventHandler
    public void onPlayerWaiting(PlayerMoveEvent event) {
        if(ArenaManager.getManager().waiting.contains(event.getPlayer().getUniqueId())) {
            Player p = event.getPlayer();
            Location from = event.getFrom();
            double xfrom = event.getFrom().getX();
            double yfrom = event.getFrom().getY();
            double zfrom = event.getFrom().getZ();
            double xto = event.getTo().getX();
            double yto = event.getTo().getY();
            double zto = event.getTo().getZ();
            if (!(xfrom == xto && yfrom == yto && zfrom == zto)) {
                p.teleport(from);
            }
        }
    }
    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        if (event.getEntity() instanceof Player) {
            Player p = (Player) event.getEntity();
            if (ArenaManager.getManager().isInGame(p) && ArenaManager.getManager().getArenaPlayer(p).isStarted()) {
                event.getDrops().clear();
                if (event.getEntity().getKiller() instanceof Player) {
                    Player kill = (Player) event.getEntity().getKiller();
                    if (ArenaManager.getManager().getArenaPlayer(p).getPlayers().contains(kill)) {
                        event.setDeathMessage(ChatColor.RED + "[" + ChatColor.BLUE + "M" + ChatColor.RED + "L" + ChatColor.BLUE + "M" + ChatColor.RED + "]" + ChatColor.YELLOW + p.getName() + " has bean beaten in type " + ArenaManager.getManager().getArenaPlayer(p).getType() + " by " + kill.getName() + ChatColor.GREEN + "(" + (int) kill.getHealth() / 2 + "♥" + ")" + ChatColor.YELLOW + "!");
                        Main.config.set(p.getUniqueId() + ".deaths", Main.config.getInt(p.getUniqueId() + ".deaths") + 1);
                        Main.config.set(p.getUniqueId() + ".losses", Main.config.getInt(p.getUniqueId() + ".losses") + 1);
                        Main.config.set(p.getUniqueId() + ".elo", Main.config.getInt(p.getUniqueId() + ".elo") - 10);
                        p.sendMessage(ChatColor.RED + "You have lost 10 Elo!");
                        Main.config.set(kill.getUniqueId() + ".kills", Main.config.getInt(kill.getUniqueId() + ".kills") + 1);
                        Main.config.set(kill.getUniqueId() + ".wins", Main.config.getInt(kill.getUniqueId() + ".wins") + 1);
                        Main.config.set(kill.getUniqueId() + ".elo", Main.config.getInt(kill.getUniqueId() + ".elo") + 10);
                        kill.sendMessage(ChatColor.GREEN + "You have gained 10 Elo!");
                        ArenaManager.getManager().stop(p);
                        ArenaManager.getManager().removeScoreboard(p);
                        ArenaManager.getManager().setScoreboard(p);
                        ArenaManager.getManager().removeScoreboard(kill);
                        ArenaManager.getManager().setScoreboard(kill);
                        ArenaManager.getManager().removePlayer(kill);
                        if(ArenaManager.getManager().getArenaPlayer(p).getType() == "BuildUHC") {
                            for(BlockState b : BuildUHC.blocks) {
                                b.setType(Material.AIR);
                            }
                        }
                        try {
                            Main.config.save(Main.f);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        Main.config.set(p.getUniqueId() + ".deaths", Main.config.getInt(p.getUniqueId() + ".deaths") + 1);
                        Main.config.set(p.getUniqueId() + ".losses", Main.config.getInt(p.getUniqueId() + ".losses") + 1);
                        Main.config.set(p.getUniqueId() + ".elo", Main.config.getInt(p.getUniqueId() + ".elo") - 10);
                        p.sendMessage(ChatColor.RED + "You have lost 10 Elo!");
                        if(ArenaManager.getManager().getArenaPlayer(p).getType() == "BuildUHC") {
                            for(BlockState b : BuildUHC.blocks) {
                                b.setType(Material.AIR);
                            }
                        }
                        event.setDeathMessage(ChatColor.RED + "[" + ChatColor.BLUE + "M" + ChatColor.RED + "L" + ChatColor.BLUE + "M" + ChatColor.RED + "]" + ChatColor.YELLOW + p.getName() + " has bean beaten in type " + ArenaManager.getManager().getArenaPlayer(p).getType() + "!");
                        for (Player kill2 : ArenaManager.getManager().getArenaPlayer(p).getPlayers()) {
                            ArenaManager.getManager().removePlayer(p);
                            Main.config.set(kill2.getUniqueId() + ".kills", Main.config.getInt(kill2.getUniqueId() + ".kills") + 1);
                            Main.config.set(kill2.getUniqueId() + ".wins", Main.config.getInt(kill2.getUniqueId() + ".wins") + 1);
                            Main.config.set(kill2.getUniqueId() + ".elo", Main.config.getInt(kill2.getUniqueId() + ".elo") + 10);
                            ArenaManager.getManager().stop(p);
                            ArenaManager.getManager().removeScoreboard(p);
                            ArenaManager.getManager().setScoreboard(p);
                            ArenaManager.getManager().removeScoreboard(kill2);
                            ArenaManager.getManager().setScoreboard(kill2);
                            ArenaManager.getManager().removePlayer(kill2);
                            event.setDeathMessage(ChatColor.RED + "[" + ChatColor.BLUE + "M" + ChatColor.RED + "L" + ChatColor.BLUE + "M" + ChatColor.RED + "]" + ChatColor.YELLOW + p.getName() + " has bean beaten in type " + ArenaManager.getManager().getArenaPlayer(p).getType() + " by " + kill2.getName() + ChatColor.GREEN + "(" + (int) kill.getHealth() / 2 + "♥" + ")" + ChatColor.YELLOW + "!");
                            kill2.sendMessage(ChatColor.GREEN + "You have gained 10 Elo!");
                        }

                    }
                }
            }
        }
    }
    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        if(ArenaManager.getManager().isInGame(event.getPlayer())) {
            if(ArenaManager.getManager().getArenaPlayer(event.getPlayer()).isStarted()) {
                ArenaManager.getManager().stop(event.getPlayer());
            } else {
                ArenaManager.getManager().removePlayer(event.getPlayer());
            }
        }
    }
    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        if(ArenaManager.getManager().isInGame(event.getPlayer())) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + "M" + ChatColor.RED + "L" + ChatColor.BLUE + "M" + ChatColor.RED + "]" + ChatColor.YELLOW + "You cannot place blocks here!");
        } else {
            if(event.getPlayer().isOp() == false) {
                event.setCancelled(true);
            }
        }
    }
    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        if(ArenaManager.getManager().isInGame(event.getPlayer())) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + "M" + ChatColor.RED + "L" + ChatColor.BLUE + "M" + ChatColor.RED + "]" + ChatColor.YELLOW + "You cannot break blocks here!");

        }
    }
    @EventHandler
    public void RegenEvent(EntityRegainHealthEvent event) {
        if(event.getEntity() instanceof Player) {
            Player p = (Player) event.getEntity();
            if(Kits.uhc.contains(p.getUniqueId())) {
                if (event.getRegainReason() == EntityRegainHealthEvent.RegainReason.SATIATED) {
                    event.setCancelled(true);
                }
            }
        }
    }
    @EventHandler
    public void Consume(PlayerItemConsumeEvent event) {
        if (event.getItem().getType() == Material.GOLDEN_APPLE) {
            if (event.getItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Golden Head")) {
                event.setCancelled(true);
                if (event.getItem().getAmount() == 1) {
                    event.getPlayer().getInventory().remove(event.getItem());
                    event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 200, 0));
                    event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENDERDRAGON_DEATH, 20, 20);
                    event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 1));
                }
                if (event.getItem().getAmount() >= 2) {
                    event.getPlayer().getInventory().remove(event.getItem());
                    ItemStack goldenHeads = new ItemStack(Material.GOLDEN_APPLE);
                    ItemMeta gmeta = goldenHeads.getItemMeta();
                    gmeta.setDisplayName(ChatColor.GOLD + "Golden Head");
                    goldenHeads.setItemMeta(gmeta);
                    event.getPlayer().getInventory().addItem(goldenHeads);
                    event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 200, 0));
                    event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENDERDRAGON_DEATH, 20, 20);
                    event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 1));
                }
            }
        }

    }
    @EventHandler
    public void PlayerRespawn(PlayerRespawnEvent event) {
       ArenaManager.getManager().removePlayer(event.getPlayer());
        event.getPlayer().performCommand("arenapvp leave");
    }
}
