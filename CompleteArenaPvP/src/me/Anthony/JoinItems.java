package me.Anthony;

import com.mysql.jdbc.PreparedStatement;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.IOException;

/**
 * Created by thresher1436 on 1/30/2016.
 */
public class JoinItems implements Listener {

    public org.bukkit.inventory.Inventory queue;

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (event.getPlayer().hasPlayedBefore() == false) {
            Bukkit.broadcastMessage(ChatColor.RED + "[" + ChatColor.BLUE + "M" + ChatColor.RED + "L" + ChatColor.BLUE + "M" + ChatColor.RED + "]" + ChatColor.YELLOW + "Welcome " + event.getPlayer().getName() + " to MLM!");
            event.getPlayer().sendMessage(ChatColor.YELLOW + "MLM stands for Major League Minecraft.");
            event.getPlayer().sendMessage(ChatColor.YELLOW + "MLM is a Dedicated Minecraft PvP Server which main goal is to have Fun and be as Hardcore as possible while doing it!");
            event.getPlayer().sendMessage(ChatColor.YELLOW + "On the behalf of the MLM team we hope you enjoy this server very much and have fun! Visit our shop at MLMshop.buycraft.net for more info!");
            event.getPlayer().sendMessage(ChatColor.YELLOW + "Now Start By Clicking on the 1v1 Queue in your Inventory!");
            ItemStack vs = new ItemStack(Material.NAME_TAG);
            ItemMeta vsmeta = vs.getItemMeta();
            vsmeta.setDisplayName(ChatColor.BLUE + "1v1 Queue " + ChatColor.GRAY + "(Right Click)");
            vs.setItemMeta(vsmeta);
            Player p = (Player) event.getPlayer();
            ItemStack shop = new ItemStack(Material.ENDER_CHEST);
            ItemMeta smeta = shop.getItemMeta();
            smeta.setDisplayName(ChatColor.YELLOW + "Store " + ChatColor.GRAY + "(Right Click)");
            shop.setItemMeta(smeta);
            ItemStack matchesLeft = new ItemStack(Material.GOLD_INGOT);
            ItemMeta matchesLeftMeta = matchesLeft.getItemMeta();
            matchesLeftMeta.setDisplayName(ChatColor.YELLOW + "Matches Left" + ChatColor.GRAY + " (Right Click)");
            p.getInventory().setItem(3, vs);
            p.getInventory().setItem(4, shop);
            p.setGameMode(GameMode.ADVENTURE);
            if(Main.config.getString(event.getPlayer().getName()) == null) {
                try {
                    Main.config.set(event.getPlayer().getUniqueId() + ".kills", 0);
                    Main.config.set(event.getPlayer().getUniqueId() + ".deaths", 0);
                    Main.config.set(event.getPlayer().getUniqueId() + ".elo", 1400);
                    Main.config.set(event.getPlayer().getUniqueId() + ".wins", 0);
                    Main.config.set(event.getPlayer().getUniqueId() + ".losses", 0);
                    Main.config.set(event.getPlayer().getUniqueId() + ".name", event.getPlayer().getName());
                    if(event.getPlayer().hasPermission("Arena.Major")) {
                        Main.config.set(event.getPlayer().getUniqueId() + ".IsDonor", true);
                    } else {
                        Main.config.set(event.getPlayer().getUniqueId() + ".IsDonor", false);
                    }
                    Main.config.save(Main.f);
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
}       ItemStack vs = new ItemStack(Material.NAME_TAG);
        ItemMeta vsmeta = vs.getItemMeta();
        vsmeta.setDisplayName(ChatColor.BLUE + "1v1 Queue " + ChatColor.GRAY + "(Right Click)");
        vs.setItemMeta(vsmeta);
        Player p = (Player) event.getPlayer();
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
        event.setJoinMessage(ChatColor.RED + "[" + ChatColor.BLUE + "M" + ChatColor.RED + "L" + ChatColor.BLUE + "M" + ChatColor.YELLOW + " Join" + ChatColor.RED + "]" + ChatColor.YELLOW + p.getDisplayName() + " has joined!");
        ArenaManager.getManager().setScoreboard(event.getPlayer());
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        ItemStack i = new ItemStack(Material.NAME_TAG);
        if(event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if(event.getMaterial() != Material.NAME_TAG) return;
            queue = Bukkit.createInventory(null, 27, ChatColor.RED + "[" + ChatColor.BLUE + "M" + ChatColor.RED + "L" + ChatColor.BLUE + "M" + ChatColor.RED + "]" + ChatColor.YELLOW + " Arena Types:");
            ItemStack sg = new ItemStack(Material.FISHING_ROD);
            ItemMeta sgMeta = sg.getItemMeta();
            sgMeta.setDisplayName(ChatColor.YELLOW + "SG");
            sg.setItemMeta(sgMeta);
            queue.setItem(0, sg);

            ItemStack Iron = new ItemStack(Material.IRON_INGOT);
            ItemMeta ironMeta = Iron.getItemMeta();
            ironMeta.setDisplayName(ChatColor.YELLOW + "Iron");
            Iron.setItemMeta(ironMeta);
            queue.setItem(1, Iron);

            ItemStack gold = new ItemStack(Material.GOLD_INGOT);
            ItemMeta goldMeta = gold.getItemMeta();
            goldMeta.setDisplayName(ChatColor.YELLOW + "Gold");
            gold.setItemMeta(goldMeta);
            queue.setItem(2, gold);

            ItemStack diamond = new ItemStack(Material.DIAMOND);
            ItemMeta dmeta = diamond.getItemMeta();
            dmeta.setDisplayName(ChatColor.YELLOW + "Diamond");
            diamond.setItemMeta(dmeta);
            queue.setItem(3, diamond);

            ItemStack archer = new ItemStack(Material.BOW);
            ItemMeta ameta = archer.getItemMeta();
            ameta.setDisplayName(ChatColor.YELLOW + "Archer");
            archer.setItemMeta(ameta);
            queue.setItem(4, archer);

            ItemStack Combo = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta Cmeta = Combo.getItemMeta();
            Cmeta.setDisplayName(ChatColor.YELLOW + "Combo");
            Combo.setItemMeta(Cmeta);
            queue.setItem(5, Combo);

            ItemStack NoDebuff = new ItemStack(Material.POTION, 1, (short) 16420);
            ItemMeta NoMeta = NoDebuff.getItemMeta();
            NoMeta.setDisplayName(ChatColor.YELLOW + "NoDebuff");
            NoDebuff.setItemMeta(NoMeta);
            queue.setItem(6, NoDebuff);

            ItemStack OG = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta OGmeta = OG.getItemMeta();
            OGmeta.setDisplayName(ChatColor.YELLOW + "OG");
            OG.setItemMeta(OGmeta);
            queue.setItem(7, OG);

            ItemStack FistiCuffs = new ItemStack(Material.STICK);
            ItemMeta fistMeta = FistiCuffs.getItemMeta();
            fistMeta.setDisplayName(ChatColor.YELLOW + "FistiCuffs");
            FistiCuffs.setItemMeta(fistMeta);
            queue.setItem(8, FistiCuffs);

            ItemStack Viking = new ItemStack(Material.IRON_AXE);
            ItemMeta Vmeta = Viking.getItemMeta();
            Vmeta.setDisplayName(ChatColor.YELLOW + "Viking");
            Viking.setItemMeta(Vmeta);
            queue.setItem(9, Viking);

            ItemStack UHC = new ItemStack(Material.GOLDEN_APPLE);
            ItemMeta uMeta = UHC.getItemMeta();
            uMeta.setDisplayName(ChatColor.YELLOW + "UHC");
            UHC.setItemMeta(uMeta);
            queue.setItem(10, UHC);
            ItemStack AdvUHC = new ItemStack(Material.GOLDEN_APPLE, 1, (short) 1);
            ItemMeta AdvMeta = AdvUHC.getItemMeta();
            AdvMeta.setDisplayName(ChatColor.YELLOW + "Advanced UHC");
            AdvUHC.setItemMeta(AdvMeta);
            queue.setItem(11, AdvUHC);

            ItemStack Tank = new ItemStack(Material.DIAMOND_CHESTPLATE);
            ItemMeta tMeta = Tank.getItemMeta();
            tMeta.setDisplayName(ChatColor.YELLOW + "Tank");
            Tank.setItemMeta(tMeta);
            queue.setItem(12, Tank);

            ItemStack Gapple = new ItemStack(Material.GOLDEN_APPLE, 1, (short) 1);
            ItemMeta Gmeta = Gapple.getItemMeta();
            Gmeta.setDisplayName(ChatColor.YELLOW + "Gapple");
            Gapple.setItemMeta(Gmeta);
            queue.setItem(13, Gapple);

            ItemStack Ability = new ItemStack(Material.BLAZE_ROD);
            ItemMeta Ameta = Ability.getItemMeta();
            Ameta.setDisplayName(ChatColor.YELLOW + "Ability");
            Ability.setItemMeta(Ameta);
            queue.setItem(14, Ability);

            ItemStack strafe = new ItemStack(Material.POTION, 1, (short) 8266);
            ItemMeta sMeta = strafe.getItemMeta();
            sMeta.setDisplayName(ChatColor.YELLOW + "Strafe");
            strafe.setItemMeta(sMeta);
            queue.setItem(15, strafe);

            ItemStack soup = new ItemStack(Material.MUSHROOM_SOUP);
            ItemMeta soupMeta = soup.getItemMeta();
            soupMeta.setDisplayName(ChatColor.YELLOW + "Soup");
            soup.setItemMeta(soupMeta);
            queue.setItem(16, soup);

            ItemStack build = new ItemStack(Material.LAVA_BUCKET);
            ItemMeta buildMeta = build.getItemMeta();
            buildMeta.setDisplayName(ChatColor.YELLOW + "BuildUHC");
            build.setItemMeta(buildMeta);
            queue.setItem(17, build);

            event.getPlayer().openInventory(queue);

        }
        ItemStack report = new ItemStack(Material.BARRIER);
        ItemMeta rmeta = report.getItemMeta();
        rmeta.setDisplayName(ChatColor.RED + "Reporter " + ChatColor.GRAY + "(Right Click)");
        report.setItemMeta(rmeta);
    }
    @EventHandler
    public void Interact2(PlayerInteractEvent e) {
        if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if(e.getMaterial() != Material.ENDER_CHEST) return;
                e.getPlayer().sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + "M" + ChatColor.RED + "L" + ChatColor.BLUE + "M" + ChatColor.RED + "]" + ChatColor.YELLOW + "CLICK THIS ------> MLMShop.buycraft.net");
                e.getPlayer().sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + "M" + ChatColor.RED + "L" + ChatColor.BLUE + "M" + ChatColor.RED + "]" + ChatColor.YELLOW + "Visit our awesome shop for Ranks, Additional Matches and more!!");
                e.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getInventory().equals(queue)) {
            ItemStack sg = new ItemStack(Material.FISHING_ROD);
            ItemMeta sgMeta = sg.getItemMeta();
            sgMeta.setDisplayName(ChatColor.YELLOW + "SG");
            sg.setItemMeta(sgMeta);

            ItemStack Iron = new ItemStack(Material.IRON_INGOT);
            ItemMeta ironMeta = Iron.getItemMeta();
            ironMeta.setDisplayName(ChatColor.YELLOW + "Iron");
            Iron.setItemMeta(ironMeta);

            ItemStack gold = new ItemStack(Material.GOLD_INGOT);
            ItemMeta goldMeta = gold.getItemMeta();
            goldMeta.setDisplayName(ChatColor.YELLOW + "Gold");
            gold.setItemMeta(goldMeta);

            ItemStack diamond = new ItemStack(Material.DIAMOND);
            ItemMeta dmeta = diamond.getItemMeta();
            dmeta.setDisplayName(ChatColor.YELLOW + "Diamond");
            diamond.setItemMeta(dmeta);

            ItemStack archer = new ItemStack(Material.BOW);
            ItemMeta ameta = archer.getItemMeta();
            ameta.setDisplayName(ChatColor.YELLOW + "Archer");
            archer.setItemMeta(ameta);

            ItemStack Combo = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta Cmeta = Combo.getItemMeta();
            Cmeta.setDisplayName(ChatColor.YELLOW + "Combo");
            Combo.setItemMeta(Cmeta);

            ItemStack NoDebuff = new ItemStack(Material.POTION, 1, (short) 16420);
            ItemMeta NoMeta = NoDebuff.getItemMeta();
            NoMeta.setDisplayName(ChatColor.YELLOW + "NoDebuff");
            NoDebuff.setItemMeta(NoMeta);

            ItemStack OG = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta OGmeta = OG.getItemMeta();
            OGmeta.setDisplayName(ChatColor.YELLOW + "OG");
            OG.setItemMeta(OGmeta);

            ItemStack FistiCuffs = new ItemStack(Material.STICK);
            ItemMeta fistMeta = FistiCuffs.getItemMeta();
            fistMeta.setDisplayName(ChatColor.YELLOW + "FistiCuffs");
            FistiCuffs.setItemMeta(fistMeta);

            ItemStack Viking = new ItemStack(Material.IRON_AXE);
            ItemMeta Vmeta = Viking.getItemMeta();
            Vmeta.setDisplayName(ChatColor.YELLOW + "Viking");
            Viking.setItemMeta(Vmeta);

            ItemStack UHC = new ItemStack(Material.GOLDEN_APPLE);
            ItemMeta uMeta = UHC.getItemMeta();
            uMeta.setDisplayName(ChatColor.YELLOW + "UHC");
            UHC.setItemMeta(uMeta);

            ItemStack AdvUHC = new ItemStack(Material.GOLDEN_APPLE, 1, (short) 1);
            ItemMeta AdvMeta = AdvUHC.getItemMeta();
            AdvMeta.setDisplayName(ChatColor.YELLOW + "Advanced UHC");
            AdvUHC.setItemMeta(AdvMeta);

            ItemStack Tank = new ItemStack(Material.DIAMOND_CHESTPLATE);
            ItemMeta tMeta = Tank.getItemMeta();
            tMeta.setDisplayName(ChatColor.YELLOW + "Tank");
            Tank.setItemMeta(tMeta);

            ItemStack Gapple = new ItemStack(Material.GOLDEN_APPLE, 1, (short) 1);
            ItemMeta Gmeta = Gapple.getItemMeta();
            Gmeta.setDisplayName(ChatColor.YELLOW + "Gapple");
            Gapple.setItemMeta(Gmeta);

            ItemStack Ability = new ItemStack(Material.BLAZE_ROD);
            ItemMeta Ameta = Ability.getItemMeta();
            Ameta.setDisplayName(ChatColor.YELLOW + "Ability");
            Ability.setItemMeta(Ameta);

            ItemStack strafe = new ItemStack(Material.POTION, 1, (short) 8266);
            ItemMeta sMeta = strafe.getItemMeta();
            sMeta.setDisplayName(ChatColor.YELLOW + "Strafe");
            strafe.setItemMeta(sMeta);

            ItemStack soup = new ItemStack(Material.MUSHROOM_SOUP);
            ItemMeta soupMeta = soup.getItemMeta();
            soupMeta.setDisplayName(ChatColor.YELLOW + "Soup");
            soup.setItemMeta(soupMeta);

            ItemStack build = new ItemStack(Material.LAVA_BUCKET);
            ItemMeta buildMeta = build.getItemMeta();
            buildMeta.setDisplayName(ChatColor.YELLOW + "BuildUHC");
            build.setItemMeta(buildMeta);

                System.out.println("Queue clicked!");
                event.setCancelled(true);
                if(event.getCurrentItem().equals(build)) {
                    ArenaManager.getManager().joinQueue((Player) event.getWhoClicked(), "BuildUHC");
                    event.setCancelled(true);
                    event.getWhoClicked().closeInventory();
                }
                if (event.getCurrentItem().equals(sg)) {
                    ArenaManager.getManager().joinQueue((Player) event.getWhoClicked(), "SG");
                    event.setCancelled(true);
                    event.getWhoClicked().closeInventory();
                }
                if (event.getCurrentItem().equals(Iron)) {
                    ArenaManager.getManager().joinQueue((Player) event.getWhoClicked(), "Iron");
                    event.setCancelled(true);
                    event.getWhoClicked().closeInventory();
                }
                if (event.getCurrentItem().equals(gold)) {
                    ArenaManager.getManager().joinQueue((Player) event.getWhoClicked(), "Gold");
                    event.setCancelled(true);
                    event.getWhoClicked().closeInventory();
                }
                if (event.getCurrentItem().equals(diamond)) {
                    ArenaManager.getManager().joinQueue((Player) event.getWhoClicked(), "Diamond");
                    event.setCancelled(true);
                    event.getWhoClicked().closeInventory();
                }
                if (event.getCurrentItem().equals(archer)) {
                    ArenaManager.getManager().joinQueue((Player) event.getWhoClicked(), "Archer");
                    event.setCancelled(true);
                    event.getWhoClicked().closeInventory();
                }
                if (event.getCurrentItem().equals(Combo)) {
                    ArenaManager.getManager().joinQueue((Player) event.getWhoClicked(), "Combo");
                    event.setCancelled(true);
                    event.getWhoClicked().closeInventory();
                }
                if (event.getCurrentItem().equals(NoDebuff)) {
                    ArenaManager.getManager().joinQueue((Player) event.getWhoClicked(), "NoDebuff");
                    event.setCancelled(true);
                    event.getWhoClicked().closeInventory();
                }
                if (event.getCurrentItem().equals(OG)) {
                    ArenaManager.getManager().joinQueue((Player) event.getWhoClicked(), "OG");
                    event.setCancelled(true);
                    event.getWhoClicked().closeInventory();
                }
                if (event.getCurrentItem().equals(FistiCuffs)) {
                    ArenaManager.getManager().joinQueue((Player) event.getWhoClicked(), "FistiCuffs");
                    event.setCancelled(true);
                    event.getWhoClicked().closeInventory();
                }
                if (event.getCurrentItem().equals(Viking)) {
                    ArenaManager.getManager().joinQueue((Player) event.getWhoClicked(), "Viking");
                    event.setCancelled(true);
                    event.getWhoClicked().closeInventory();
                }
                if (event.getCurrentItem().equals(UHC)) {
                    ArenaManager.getManager().joinQueue((Player) event.getWhoClicked(), "UHC");
                    event.setCancelled(true);
                    event.getWhoClicked().closeInventory();
                }
                if (event.getCurrentItem().equals(AdvUHC)) {
                    ArenaManager.getManager().joinQueue((Player) event.getWhoClicked(), "AdvancedUHC");
                    event.setCancelled(true);
                    event.getWhoClicked().closeInventory();
                }
                if (event.getCurrentItem().equals(Tank)) {
                    ArenaManager.getManager().joinQueue((Player) event.getWhoClicked(), "Tank");
                    event.setCancelled(true);
                    event.getWhoClicked().closeInventory();
                }
                if (event.getCurrentItem().equals(Gapple)) {
                    ArenaManager.getManager().joinQueue((Player) event.getWhoClicked(), "Gapple");
                    event.setCancelled(true);
                    event.getWhoClicked().closeInventory();
                }
                if (event.getCurrentItem().equals(Ability)) {
                   event.getWhoClicked().sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + "M" + ChatColor.RED + "L" + ChatColor.BLUE + "M" + ChatColor.RED + "]" + ChatColor.YELLOW + "Sorry, this Gamemode is still in progress!");
                    event.setCancelled(true);
                    event.getWhoClicked().closeInventory();
                }
                if (event.getCurrentItem().equals(strafe)) {
                    ArenaManager.getManager().joinQueue((Player) event.getWhoClicked(), "Strafe");
                    event.setCancelled(true);
                    event.getWhoClicked().closeInventory();
                }
                if (event.getCurrentItem().equals(soup)) {
                    ArenaManager.getManager().joinQueue((Player) event.getWhoClicked(), "Soup");
                    event.setCancelled(true);
                    event.getWhoClicked().closeInventory();
                }
            }
        }

    @EventHandler
    public void onInteract3(PlayerInteractEvent e) {
        if(e.getMaterial() == Material.MUSHROOM_SOUP) {
            e.getPlayer().getInventory().remove(e.getItem());
            e.getPlayer().setHealth(e.getPlayer().getHealth() + 3);
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onPlayerJoin(PlayerLoginEvent e) {
        if(e.getResult() == PlayerLoginEvent.Result.KICK_FULL) {
            if(e.getPlayer().hasPermission("Arena.Major")) {
                e.allow();
            } else {
                e.disallow(PlayerLoginEvent.Result.KICK_FULL, "Currently the server is full and it is set to Donors only mode. Donate the Famous Rank @ MLMshop.buycraft.net to join!");
            }
        }
    }
    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        if(event.getPlayer().hasPermission("Arena.Major") && event.getPlayer().isOp() == false) {
            event.getPlayer().setDisplayName(ChatColor.RED + "[" + ChatColor.BLUE + "Famous" + ChatColor.RED + "]" + ChatColor.BLUE + event.getPlayer().getName());
            event.getPlayer().setPlayerListName(ChatColor.RED + "[" + ChatColor.BLUE + "Famous" + ChatColor.RED + "]" + ChatColor.BLUE + event.getPlayer().getName());
            event.setMessage(ChatColor.YELLOW + event.getMessage().toString());
        } else if(event.getPlayer().isOp()) {
            event.getPlayer().setPlayerListName(ChatColor.DARK_GREEN + "[" + ChatColor.YELLOW + "Staff" + ChatColor.DARK_GREEN + "]" + ChatColor.YELLOW + event.getPlayer().getName());
            event.setMessage(ChatColor.AQUA + event.getMessage().toString());
            event.getPlayer().setDisplayName(ChatColor.DARK_GREEN + "[" + ChatColor.YELLOW + "Staff" + ChatColor.DARK_GREEN + "]" + ChatColor.YELLOW + event.getPlayer().getName());
        } else if(event.getPlayer().hasPermission("Arena.Major") == false) {
            event.setMessage(ChatColor.GRAY + event.getMessage());
            event.getPlayer().setDisplayName(ChatColor.GRAY + event.getPlayer().getName());
            event.getPlayer().setPlayerListName(ChatColor.GRAY + event.getPlayer().getName());

        }
    }
}
