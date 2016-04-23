package me.Anthony.me.Anthony.SubCommands;

import me.Anthony.ArenaManager;
import me.Anthony.Kits;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

/**
 * Created by thresher1436 on 2/15/2016.
 */
public class BuildUHC implements Listener {

    public static ArrayList<BlockState> blocks = new ArrayList<BlockState>();


    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        if(ArenaManager.getManager().isInGame(event.getPlayer())) {
            if(ArenaManager.getManager().getArenaPlayer(event.getPlayer()).getType().equalsIgnoreCase("BuildUHC") || ArenaManager.getManager().getArenaPlayer(event.getPlayer()).getType().equalsIgnoreCase("ExtremeBuildUHC"))  {
                if(ArenaManager.getManager().getArenaPlayer(event.getPlayer()).isStarted()) {
                    if(blocks.contains(event.getBlock().getState())) {
                        event.setCancelled(false);
                    } else {
                        event.setCancelled(true);
                        event.getPlayer().sendMessage(ChatColor.RED + "[" + ChatColor.BLUE + "M" + ChatColor.RED + "L" + ChatColor.BLUE + "M" + ChatColor.RED + "]" + ChatColor.YELLOW + "You can only break blocks that you have placed!");
                    }
                }
            }
        }
    }
    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        if(ArenaManager.getManager().isInGame(event.getPlayer())) {
            if(ArenaManager.getManager().getArenaPlayer(event.getPlayer()).getType().equalsIgnoreCase("BuildUHC") || ArenaManager.getManager().getArenaPlayer(event.getPlayer()).getType().equalsIgnoreCase("ExtremeBuildUHC")) {
                if(ArenaManager.getManager().getArenaPlayer(event.getPlayer()).isStarted()) {
                    blocks.add(event.getBlock().getState());
                    event.setCancelled(false);
                }
            }
        }
    }
    @EventHandler
    public void onChange(BlockFromToEvent e) {
        e.setCancelled(true);
    }


    public static void giveBuildUHC(Player p) {
        ItemStack helm = new ItemStack(Material.DIAMOND_HELMET);
        ItemStack chest = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemStack legs = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
        ItemStack bow = new ItemStack(Material.BOW);
        ItemStack gap = new ItemStack(Material.GOLDEN_APPLE, 6);
        ItemStack gap2 = new ItemStack(Material.GOLDEN_APPLE, 3);
        ItemStack rod = new ItemStack(Material.FISHING_ROD);
        ItemStack lava1 = new ItemStack(Material.LAVA_BUCKET);
        ItemStack lava2 = new ItemStack(Material.LAVA_BUCKET);
        ItemStack water1 = new ItemStack(Material.WATER_BUCKET);
        ItemStack water2 = new ItemStack(Material.WATER_BUCKET);
        ItemStack pick = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemStack shovel = new ItemStack(Material.DIAMOND_SPADE);
        ItemStack axe = new ItemStack(Material.DIAMOND_AXE);
        ItemStack blocks1 = new ItemStack(Material.WOOD, 64);
        ItemStack blocks2 = new ItemStack(Material.COBBLESTONE, 64);
        ItemStack arrows = new ItemStack(Material.ARROW, 64);
        helm.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        chest.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
        legs.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        boots.addEnchantment(Enchantment.PROTECTION_FALL, 2);
        sword.addEnchantment(Enchantment.DAMAGE_ALL, 3);
        bow.addEnchantment(Enchantment.ARROW_DAMAGE, 3);
        ItemMeta gap2meta = gap2.getItemMeta();
        gap2meta.setDisplayName(ChatColor.GOLD + "Golden Head");
        gap2.setItemMeta(gap2meta);
        p.getInventory().setHelmet(helm);
        p.getInventory().setChestplate(chest);
        p.getInventory().setLeggings(legs);
        p.getInventory().setBoots(boots);
        p.getInventory().addItem(sword);
        p.getInventory().addItem(bow);
        p.getInventory().addItem(rod);
        p.getInventory().addItem(lava1);
        p.getInventory().addItem(water1);
        p.getInventory().addItem(gap);
        p.getInventory().addItem(gap2);
        p.getInventory().addItem(blocks1);
        p.getInventory().addItem(blocks2);
        p.getInventory().addItem(lava2);
        p.getInventory().addItem(water2);
        p.getInventory().addItem(pick);
        p.getInventory().addItem(shovel);
        p.getInventory().addItem(axe);
        p.getInventory().addItem(arrows);
        Kits.uhc.add(p.getUniqueId());


    }

    @EventHandler
    public void Consume(PlayerItemConsumeEvent event) {
        ItemStack gap2 = new ItemStack(Material.GOLDEN_APPLE);
        ItemMeta gap2meta = gap2.getItemMeta();
        gap2meta.setDisplayName(ChatColor.GOLD + "Golden Head");
        gap2.setItemMeta(gap2meta);
        if(event.getItem().getType() == Material.GOLDEN_APPLE) {
            if(event.getItem().getItemMeta().getDisplayName().equals(gap2meta.getDisplayName())) {
                event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 2400, 1));
                event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 200, 1));
            }

        }
    }




}
