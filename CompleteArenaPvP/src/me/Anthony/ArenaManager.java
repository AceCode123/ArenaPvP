package me.Anthony;

import me.Anthony.me.Anthony.SubCommands.BuildUHC;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by thresher1436 on 1/24/2016.
 */
public class ArenaManager {

    public static ArenaManager am;

    private Map<UUID, ItemStack[]> contents = new HashMap<UUID, ItemStack[]>();
    private Map<UUID, ItemStack[]> armorContents = new HashMap<UUID, ItemStack[]>();
    private Map<UUID, Location> location = new HashMap<UUID, Location>();
    public static List<UUID> waiting = new ArrayList<UUID>();

    private ArrayList<Arena> arenas = new ArrayList<Arena>();
    private int arenaIds = 0;

    public static ArenaManager getManager() {
        if(am == null)
            am = new ArenaManager();
        return am;
    }

    public Arena getArena(int id) {
        for(Arena a : arenas) {
            if(a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    public boolean isArena(int id) {
        for(Arena a : arenas) {
            if(a.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public Arena getArenaPlayer(Player p) {
        for(Arena a : arenas) {
            if(a.getPlayers().contains(p)) {
                return a;
            }
        }
        return null;
    }

    public void createArena(Location l, Location l2, String type) {
        arenaIds++;
        Arena a = new Arena(arenaIds, l, l2, type, true);
        arenas.add(a);
        System.out.println(ChatColor.RED + "[" + ChatColor.BLUE + "M" + ChatColor.RED + "L" + ChatColor.BLUE + "M" + ChatColor.RED + "]" + "Successfully created Arena with Id: " + arenaIds + ".");
    }
    public void deleteArena(int id) {
        for(Arena a : arenas) {
            if(a.getId() == id) {
                if(a.isStarted() == false) {
                    arenas.remove(a);
                } else {
                    return;
                }
            }
        }
    }

    public boolean isInGame(Player p) {
        for(Arena a : arenas) {
            if(a.getPlayers().contains(p))
                return true;
        }
        return false;
    }
    public boolean isSpectating(Player p) {
        for(Arena a : arenas) {
            if(a.getSpectaters().contains(p))
                return true;
        }
        return false;
    }

    public void addPlayer(int id, Player p) {
        for(Arena a  : arenas) {
            if(a.getId() == id) {
                if(a.isStarted()) {
                    p.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + "M" + ChatColor.RED + "L" + ChatColor.BLUE + "M" + ChatColor.RED + "]" + ChatColor.YELLOW + "Sorry this Arena is already in progress!");
                    return;
                }
                if(isInGame(p)) {
                    p.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + "M" + ChatColor.RED + "L" + ChatColor.BLUE + "M" + ChatColor.RED + "]" + ChatColor.RED + "You are already in a game!");
                    return;
                }
                if(isSpectating(p)) {
                    p.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + "M" + ChatColor.RED + "L" + ChatColor.BLUE + "M" + ChatColor.RED + "]" + ChatColor.RED + "Please leave Spectater mode to join!");
                    return;
                }
                contents.put(p.getUniqueId(), p.getInventory().getContents());
                armorContents.put(p.getUniqueId(),p.getInventory().getArmorContents());
                location.put(p.getUniqueId(),p.getLocation());
                p.getInventory().clear();
                p.getInventory().setArmorContents(null);
                p.setHealth(20);
                waiting.add(p.getUniqueId());
                a.getPlayers().add(p);
                startJoin(a.getId());
                if(a.getPlayers().size() == 1) {
                    p.teleport(a.getFighter1());
                } else {
                    p.teleport(a.getFighter2());
                }

                if(a.getType().equalsIgnoreCase("SG")) {
                    Kits.giveSG(p);

                }
                if(a.getType().equalsIgnoreCase("Iron")) {
                    Kits.giveIron(p);

                }
                if(a.getType().equalsIgnoreCase("Gold")) {
                    Kits.giveGold(p);

                }
                if(a.getType().equalsIgnoreCase("Diamond")) {
                    Kits.giveDiamond(p);
                }
                if(a.getType().equalsIgnoreCase("Archer")) {
                    Kits.giveArcher(p);
                }
                if(a.getType().equalsIgnoreCase("Combo")) {
                    Kits.giveCombo(p);
                }
                if(a.getType().equalsIgnoreCase("NoDebuff")) {
                    Kits.giveNoDebuff(p);
                }
                if(a.getType().equalsIgnoreCase("OG")) {
                    Kits.giveOG(p);
                }
                if(a.getType().equalsIgnoreCase("Fisticuffs")) {
                    Kits.giveFisticuffs(p);
                }
                if(a.getType().equalsIgnoreCase("Viking")) {
                    Kits.giveViking(p);
                }
                if(a.getType().equalsIgnoreCase("UHC")) {
                    Kits.giveUHC(p);
                }
                if(a.getType().equalsIgnoreCase("AdvancedUHC")) {
                    Kits.giveAdvancedUHC(p);
                }
                if(a.getType().equalsIgnoreCase("Tank")) {
                    Kits.giveTank(p);
                }
                if(a.getType().equalsIgnoreCase("Gapple")) {
                    Kits.giveGapple(p);
                }
                if(a.getType().equalsIgnoreCase("AbilityPvP")) {
                    Kits.giveAbility(p);
                }
                if(a.getType().equalsIgnoreCase("Strafe")) {
                    Kits.giveStrafe(p);
                }
                if(a.getType().equalsIgnoreCase("Soup")) {
                    Kits.giveSoup(p);
                }
                if(a.getType().equalsIgnoreCase("BuildUHC")) {
                    BuildUHC.giveBuildUHC(p);
                    p.setGameMode(GameMode.SURVIVAL);
                }
            }
        }
    }

    public void addSpectator(Player p, Player toSpectate) {
        if(isInGame(p) == false) {
            for (Arena a : arenas) {
                if (a.getPlayers().contains(toSpectate)) {
                    if (a.isStarted()) {
                        contents.put(p.getUniqueId(), p.getInventory().getContents());
                        armorContents.put(p.getUniqueId(), p.getInventory().getArmorContents());
                        location.put(p.getUniqueId(), p.getLocation());

                        p.getInventory().clear();
                        p.getInventory().setArmorContents(null);
                        p.teleport(a.getFighter1());
                        p.setGameMode(GameMode.CREATIVE);
                        p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 1800000, 2));
                        p.setCanPickupItems(false);
                        a.getSpectaters().add(p);
                    }
                }
            }
        }
    }
    public void leaveSpectator(Player p) {
        for(Arena a : arenas) {
            if(a.getSpectaters().contains(p)) {
                a.getSpectaters().remove(p);
                p.setGameMode(GameMode.ADVENTURE);
                p.setCanPickupItems(true);
                p.removePotionEffect(PotionEffectType.INVISIBILITY);
                p.getInventory().setContents(contents.get(p.getUniqueId()));
                p.getInventory().setArmorContents(armorContents.get(p.getUniqueId()));
                p.teleport(location.get(p.getUniqueId()));
                p.getInventory().clear();
                ItemStack vs = new ItemStack(Material.NAME_TAG);
                ItemMeta vsmeta = vs.getItemMeta();
                vsmeta.setDisplayName(ChatColor.BLUE + "1v1 Queue " + ChatColor.GRAY + "(Right Click)");
                vs.setItemMeta(vsmeta);
                ItemStack shop = new ItemStack(Material.ENDER_CHEST);
                ItemMeta smeta = shop.getItemMeta();
                smeta.setDisplayName(ChatColor.YELLOW + "Store " + ChatColor.GRAY + "(Right Click)");
                shop.setItemMeta(smeta);
                ItemStack matchesLeft = new ItemStack(Material.GOLD_INGOT);
                ItemMeta matchesLeftMeta = matchesLeft.getItemMeta();
                matchesLeftMeta.setDisplayName(ChatColor.YELLOW + "Matches Left" + ChatColor.GRAY + " (Right Click)");
                p.getInventory().setItem(3, vs);
                p.getInventory().setItem(4, shop);
                p.getInventory().setItem(8, matchesLeft);
                p.setGameMode(GameMode.ADVENTURE);
            } else {
                p.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + "M" + ChatColor.RED + "L" + ChatColor.BLUE + "M" + ChatColor.RED + "]" + "You are not spectating an Arena!");
            }
        }
    }

    public void removePlayer(Player p) {
                p.getInventory().clear();
                p.getInventory().setArmorContents(null);
                p.setFireTicks(0);
                p.setMaxHealth(20);
                p.setHealth(20);

                p.getInventory().setContents(contents.get(p.getUniqueId()));
                p.getInventory().setArmorContents(armorContents.get(p.getUniqueId()));
                p.teleport(location.get(p.getUniqueId()));
        p.getInventory().clear();
        ItemStack vs = new ItemStack(Material.NAME_TAG);
        ItemMeta vsmeta = vs.getItemMeta();
        vsmeta.setDisplayName(ChatColor.BLUE + "1v1 Queue " + ChatColor.GRAY + "(Right Click)");
        vs.setItemMeta(vsmeta);
        ItemStack shop = new ItemStack(Material.ENDER_CHEST);
        ItemMeta smeta = shop.getItemMeta();
        smeta.setDisplayName(ChatColor.YELLOW + "Shop " + ChatColor.GRAY + "(Right Click)");
        shop.setItemMeta(smeta);
        ItemStack matchesLeft = new ItemStack(Material.GOLD_INGOT);
        ItemMeta matchesLeftMeta = matchesLeft.getItemMeta();
        matchesLeftMeta.setDisplayName(ChatColor.YELLOW + "Matches Left" + ChatColor.GRAY + " (Right Click)");
        p.getInventory().setItem(3, vs);
        p.getInventory().setItem(4, shop);
        p.getInventory().setItem(8, matchesLeft);
        p.setGameMode(GameMode.ADVENTURE);
                for(Arena a : arenas) {
                        a.getPlayers().remove(p);
                }
                if (waiting.contains(p.getUniqueId())) {
                    waiting.remove(p.getUniqueId());
                }
                if(Kits.uhc.contains(p.getUniqueId())) {
                    Kits.uhc.remove(p.getUniqueId());
                }
    }
    public void stop(Player p) {
        for(Arena a : arenas) {
            if(a.getPlayers().contains(p)) {
                if(a.isStarted()) {
                    a.stop();
                    removePlayer(p);
                    for(Player specs : a.getSpectaters()) {
                        leaveSpectator(specs);
                    }
                }
            }
        }
    }
    public void joinQueue(Player p, String type) {
        for(Arena a : arenas) {
            if(a.getType().equalsIgnoreCase(type)) {
                if (a.isStarted() == false) {
                    addPlayer(a.getId(), p);
                    p.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + "M" + ChatColor.RED + "L" + ChatColor.BLUE + "M" + ChatColor.RED + "]" + ChatColor.YELLOW + "Sending you to Arena " + a.getId() + " in type " + a.getType() + ".");
                } else {
                    p.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + "M" + ChatColor.RED + "L" + ChatColor.BLUE + "M" + ChatColor.RED + "]" + ChatColor.YELLOW + "No Arenas for this type are available at this time! Please try another type or again in a few minutes.");
                }
            }
        }
    }

    public void setScoreboard(Player p) {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Objective obj = board.registerNewObjective("test", "dummy");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.setDisplayName(ChatColor.BOLD + "" + ChatColor.RED + "[" + ChatColor.BOLD + "" + ChatColor.BLUE + "M" + ChatColor.BOLD + "" + ChatColor.RED + "L" + ChatColor.BOLD + "" + ChatColor.BLUE + "M" + ChatColor.BOLD + "" + ChatColor.RED + "]");
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("dd,mm,yy");
        format.format(date);
        Score score = obj.getScore(ChatColor.YELLOW + date.toString());
        score.setScore(9);
        if(p.hasPermission("Arena.Major")) {
            Score score2 = obj.getScore(ChatColor.BOLD + "" + ChatColor.BLUE + "RANK: " + ChatColor.GREEN + "Famous");
            score2.setScore(8);
        }   else {
            Score score2 = obj.getScore(ChatColor.BOLD + "" + ChatColor.BLUE + "RANK: " + ChatColor.GRAY + "Default");
            score2.setScore(8);
        }
        Score score3 = obj.getScore(ChatColor.BOLD + "" + ChatColor.GREEN + "ELO: " + Main.config.getInt(p.getUniqueId() + ".elo"));
        score3.setScore(7);
        Score score4 = obj.getScore(ChatColor.BOLD + "" + ChatColor.GREEN + "KILLS: " + Main.config.getInt(p.getUniqueId() + ".kills"));
        score4.setScore(6);
        Score score5 = obj.getScore(ChatColor.BOLD + "" + ChatColor.GREEN + "DEATHS: " + Main.config.getInt(p.getUniqueId() + ".deaths"));
        score5.setScore(5);
        Score score6 = obj.getScore(ChatColor.BOLD + "" + ChatColor.GREEN + "WINS: " + Main.config.getInt(p.getUniqueId() + ".wins"));
        score6.setScore(4);
        Score score7 = obj.getScore(ChatColor.BOLD + "" + ChatColor.GREEN + "LOSSES: " + Main.config.getInt(p.getUniqueId() + ".losses"));
        score7.setScore(3);
        Score score8 = obj.getScore(ChatColor.BOLD + "" + ChatColor.YELLOW + "");
        score8.setScore(2);
        Score score9 = obj.getScore(ChatColor.BOLD + "" + ChatColor.YELLOW + "MLMShop.buycraft.net");
        score9.setScore(1);
        p.setScoreboard(board);
    }
    public void removeScoreboard(Player p) {
        p.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
    }

    public void startJoin(int id) {
        for(Arena a : arenas) {
            if(a.getId() == id) {
                if(a.getPlayers().size() == 2) {
                    for(Player p : a.getPlayers()) {
                        waiting.remove(p.getUniqueId());
                        p.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + "M" + ChatColor.RED + "L" + ChatColor.BLUE + "M" + ChatColor.RED + "]" + ChatColor.YELLOW + "Your Game Has Started! FIGHT!");
                        a.start();
                    }
                } else {
                    if(a.getPlayers().size() == 1) {
                        for(Player p : a.getPlayers()) {
                            p.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + "M" + ChatColor.RED + "L" + ChatColor.BLUE + "M" + ChatColor.RED + "]" + ChatColor.YELLOW + "One more player needs to join for your game to start!");
                        }
                    }
                }
            }
        }
    }
    public void Duel(Player p, Player p2, String type) {
        for(Arena a : arenas) {
            if(a.getType() == type) {
                if(a.isStarted() == false) {
                    if (a.getPlayers().size() == 0) {
                        addPlayer(a.getId(), p);
                        addPlayer(a.getId(), p2);
                    } else {
                        p.sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + "M" + ChatColor.RED + "L" + ChatColor.BLUE + "M" + ChatColor.RED + "]" + ChatColor.RED + "No arenas are currently open! Please try again in a few minutes!");
                    }
                }
            }
        }
    }

}
