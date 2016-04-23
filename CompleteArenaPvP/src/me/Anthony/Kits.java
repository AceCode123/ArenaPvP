package me.Anthony;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.*;

/**
 * Created by thresher1436 on 1/30/2016.
 */
public class Kits {

    public static List<UUID> uhc = new ArrayList<UUID>();

    public static void giveIron(Player p) {
        ItemStack helm = new ItemStack(Material.IRON_HELMET);
        ItemStack chest = new ItemStack(Material.IRON_CHESTPLATE);
        ItemStack legs = new ItemStack(Material.IRON_LEGGINGS);
        ItemStack boots = new ItemStack(Material.IRON_BOOTS);
        ItemStack sword = new ItemStack(Material.IRON_SWORD);
        ItemStack bow = new ItemStack(Material.BOW);
        ItemStack steak = new ItemStack(Material.COOKED_BEEF, 64);
        ItemStack arrows = new ItemStack(Material.ARROW, 32);
        ItemStack rod = new ItemStack(Material.FISHING_ROD);

        p.getInventory().setHelmet(helm);
        p.getInventory().setChestplate(chest);
        p.getInventory().setLeggings(legs);
        p.getInventory().setBoots(boots);
        p.getInventory().addItem(sword);
        p.getInventory().addItem(bow);
        p.getInventory().addItem(rod);
        p.getInventory().addItem(steak);
        p.getInventory().addItem(arrows);
    }
    public static void giveGold(Player p) {
        ItemStack helm = new ItemStack(Material.GOLD_HELMET);
        ItemStack chest = new ItemStack(Material.GOLD_CHESTPLATE);
        ItemStack legs = new ItemStack(Material.GOLD_LEGGINGS);
        ItemStack boots = new ItemStack(Material.GOLD_BOOTS);
        ItemStack sword = new ItemStack(Material.GOLD_SWORD);
        sword.addEnchantment(Enchantment.DAMAGE_ALL, 2);
        ItemStack bow = new ItemStack(Material.BOW);
        ItemStack steak = new ItemStack(Material.COOKED_BEEF, 64);
        ItemStack arrows = new ItemStack(Material.ARROW, 32);
        ItemStack rod = new ItemStack(Material.FISHING_ROD);

        p.getInventory().setHelmet(helm);
        p.getInventory().setChestplate(chest);
        p.getInventory().setLeggings(legs);
        p.getInventory().setBoots(boots);
        p.getInventory().addItem(sword);
        p.getInventory().addItem(bow);
        p.getInventory().addItem(rod);
        p.getInventory().addItem(steak);
        p.getInventory().addItem(arrows);
    }
    public static void giveDiamond(Player p) {
        ItemStack helm = new ItemStack(Material.DIAMOND_HELMET);
        ItemStack chest = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemStack legs = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
        ItemStack bow = new ItemStack(Material.BOW);
        ItemStack steak = new ItemStack(Material.COOKED_BEEF, 64);
        ItemStack arrows = new ItemStack(Material.ARROW, 32);
        ItemStack rod = new ItemStack(Material.FISHING_ROD);

        p.getInventory().setHelmet(helm);
        p.getInventory().setChestplate(chest);
        p.getInventory().setLeggings(legs);
        p.getInventory().setBoots(boots);
        p.getInventory().addItem(sword);
        p.getInventory().addItem(bow);
        p.getInventory().addItem(rod);
        p.getInventory().addItem(steak);
        p.getInventory().addItem(arrows);
    }
    public static void giveArcher(Player p) {
        ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
        ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE);
        ItemStack legs = new ItemStack(Material.LEATHER_LEGGINGS);
        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
        ItemStack bow = new ItemStack(Material.BOW);
        bow.addEnchantment(Enchantment.ARROW_DAMAGE, 2);
        bow.addEnchantment(Enchantment.ARROW_INFINITE, 1);
        ItemStack steak = new ItemStack(Material.COOKED_BEEF, 64);
        ItemStack arrows = new ItemStack(Material.ARROW, 1);
        ItemStack rod = new ItemStack(Material.FISHING_ROD);
        p.getInventory().setHelmet(helm);
        p.getInventory().setChestplate(chest);
        p.getInventory().setLeggings(legs);
        p.getInventory().setBoots(boots);
        p.getInventory().addItem(bow);
        p.getInventory().addItem(rod);
        p.getInventory().addItem(steak);
        p.getInventory().addItem(arrows);
        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 180000, 1));
    }
    public static void giveCombo(Player p) {
        ItemStack helm = new ItemStack(Material.DIAMOND_HELMET);
        helm.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
        ItemStack chest = new ItemStack(Material.DIAMOND_CHESTPLATE);
        chest.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
        ItemStack legs = new ItemStack(Material.DIAMOND_LEGGINGS);
        legs.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
        ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
        boots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
        ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
        sword.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
        sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
        ItemStack rod = new ItemStack(Material.FISHING_ROD);
        rod.addUnsafeEnchantment(Enchantment.KNOCKBACK, 5);
        ItemStack gaps = new ItemStack(Material.GOLDEN_APPLE, 64, (short) 1);
        ItemStack carrots = new ItemStack(Material.GOLDEN_CARROT, 64);
        ItemStack bow = new ItemStack(Material.BOW);
        bow.addEnchantment(Enchantment.ARROW_DAMAGE, 5);
        bow.addEnchantment(Enchantment.ARROW_KNOCKBACK, 2);
        bow.addEnchantment(Enchantment.ARROW_FIRE, 1);
        ItemStack arrows = new ItemStack(Material.ARROW, 64);
        p.getInventory().setHelmet(helm);
        p.getInventory().setChestplate(chest);
        p.getInventory().setLeggings(legs);
        p.getInventory().setBoots(boots);
        p.getInventory().addItem(sword);
        p.getInventory().addItem(bow);
        p.getInventory().addItem(rod);
        p.getInventory().addItem(gaps);
        p.getInventory().addItem(carrots);
        p.getInventory().addItem(arrows);
    }
    public static void giveFisticuffs(Player p) {
        p.getInventory().addItem(new ItemStack(Material.STICK));

    }
    public static void giveViking(Player p) {
        ItemStack helm = new ItemStack(Material.GOLD_HELMET);
        ItemStack chest = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
        p.getInventory().setHelmet(helm);
        p.getInventory().setChestplate(chest);
        p.getInventory().setBoots(boots);
        ItemStack axe = new ItemStack(Material.IRON_AXE);
        ItemStack bow = new ItemStack(Material.BOW);
        ItemStack rod = new ItemStack(Material.FISHING_ROD);
        ItemStack pie = new ItemStack(Material.PUMPKIN_PIE, 16);
        ItemStack arrows = new ItemStack(Material.ARROW, 5);
        p.getInventory().addItem(axe);
        p.getInventory().addItem(bow);
        p.getInventory().addItem(rod);
        p.getInventory().addItem(pie);
        p.getInventory().addItem(arrows);
    }
    public static void giveUHC(Player p) {
        ItemStack helm = new ItemStack(Material.IRON_HELMET);
        p.getInventory().setHelmet(helm);
        ItemStack chest = new ItemStack(Material.IRON_CHESTPLATE);
        p.getInventory().setChestplate(chest);
        ItemStack legs = new ItemStack(Material.IRON_LEGGINGS);
        p.getInventory().setLeggings(legs);
        ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
        p.getInventory().setBoots(boots);
        helm.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        chest.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
        legs.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        boots.addEnchantment(Enchantment.PROTECTION_FALL, 2);
        ItemStack sword = new ItemStack(Material.IRON_SWORD);
        sword.addEnchantment(Enchantment.DAMAGE_ALL, 2);
        ItemStack bow = new ItemStack(Material.BOW);
        bow.addEnchantment(Enchantment.ARROW_DAMAGE, 2);
        ItemStack rod = new ItemStack(Material.FISHING_ROD);
        ItemStack arrows = new ItemStack(Material.ARROW, 48);
        ItemStack steak = new ItemStack(Material.COOKED_BEEF, 32);
        ItemStack gaps = new ItemStack(Material.GOLDEN_APPLE, 2);
        p.getInventory().addItem(sword);
        p.getInventory().addItem(bow);
        p.getInventory().addItem(rod);
        p.getInventory().addItem(gaps);
        p.getInventory().addItem(steak);
        p.getInventory().addItem(arrows);
        uhc.add(p.getUniqueId());
    }
    public static void giveAdvancedUHC(Player p) {
        ItemStack helm = new ItemStack(Material.DIAMOND_HELMET);
        ItemStack chest = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemStack legs = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
        helm.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        chest.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 3);
        legs.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        boots.addEnchantment(Enchantment.PROTECTION_FALL, 2);
        ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
        sword.addEnchantment(Enchantment.DAMAGE_ALL, 2);
        ItemStack bow = new ItemStack(Material.BOW);
        bow.addEnchantment(Enchantment.ARROW_DAMAGE, 4);
        ItemStack rod = new ItemStack(Material.FISHING_ROD);
        ItemStack arrows = new ItemStack(Material.ARROW, 64);
        ItemStack steak = new ItemStack(Material.COOKED_BEEF, 32);
        ItemStack gaps = new ItemStack(Material.GOLDEN_APPLE, 4);
        ItemStack goldenHeads = new ItemStack(Material.GOLDEN_APPLE, 2);
        ItemMeta gmeta = goldenHeads.getItemMeta();
        gmeta.setDisplayName(ChatColor.GOLD + "Golden Head");
        goldenHeads.setItemMeta(gmeta);
        p.getInventory().addItem(sword);
        p.getInventory().addItem(bow);
        p.getInventory().addItem(rod);
        p.getInventory().addItem(goldenHeads);
        p.getInventory().addItem(gaps);
        p.getInventory().addItem(steak);
        p.getInventory().addItem(arrows);
        p.getInventory().setHelmet(helm);
        p.getInventory().setChestplate(chest);
        p.getInventory().setLeggings(legs);
        p.getInventory().setBoots(boots);
        uhc.add(p.getUniqueId());

    }
    public static void giveTank(Player p) {
        ItemStack helm = new ItemStack(Material.DIAMOND_HELMET);
        helm.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
        ItemStack chest = new ItemStack(Material.IRON_CHESTPLATE);
        chest.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
        ItemStack legs = new ItemStack(Material.DIAMOND_LEGGINGS);
        legs.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
        ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
        boots.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
        ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
        sword.addEnchantment(Enchantment.DAMAGE_ALL, 4);
        ItemStack bow = new ItemStack(Material.BOW);
        bow.addEnchantment(Enchantment.ARROW_DAMAGE, 5);
        ItemStack rod = new ItemStack(Material.FISHING_ROD);
        ItemStack steak = new ItemStack(Material.COOKED_BEEF, 64);
        p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 18000000, 1));
        p.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 20, 5));
        p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 18000000, 0));
        p.getInventory().setHelmet(helm);
        p.getInventory().setChestplate(chest);
        p.getInventory().setLeggings(legs);
        p.getInventory().setBoots(boots);
        p.getInventory().addItem(sword);
        p.getInventory().addItem(bow);
        p.getInventory().addItem(rod);
        p.getInventory().addItem(steak);
        ItemStack arrows = new ItemStack(Material.ARROW, 64);
        p.getInventory().addItem(arrows);
    }
    public static void giveGapple(Player p) {
        ItemStack helm = new ItemStack(Material.DIAMOND_HELMET);
        helm.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
        ItemStack chest = new ItemStack(Material.DIAMOND_CHESTPLATE);
        chest.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
        ItemStack legs = new ItemStack(Material.DIAMOND_LEGGINGS);
        legs.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
        ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
        boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
        ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
        sword.addEnchantment(Enchantment.FIRE_ASPECT, 2);
        sword.addEnchantment(Enchantment.DAMAGE_ALL, 5);
        ItemStack rod = new ItemStack(Material.FISHING_ROD);
        ItemStack gaps = new ItemStack(Material.GOLDEN_APPLE, 64, (short) 1);
        ItemStack bow = new ItemStack(Material.BOW);
        ItemStack strength = new ItemStack(Material.POTION, 2, (short) 8233);
        ItemStack speed = new ItemStack(Material.POTION, 2, (short) 8266);
        bow.addEnchantment(Enchantment.ARROW_DAMAGE, 5);
        bow.addEnchantment(Enchantment.ARROW_KNOCKBACK, 2);
        bow.addEnchantment(Enchantment.ARROW_FIRE, 1);
        ItemStack arrows = new ItemStack(Material.ARROW, 64);
        p.getInventory().setHelmet(helm);
        p.getInventory().setChestplate(chest);
        p.getInventory().setLeggings(legs);
        p.getInventory().setBoots(boots);
        p.getInventory().addItem(sword);
        p.getInventory().addItem(bow);
        p.getInventory().addItem(rod);
        p.getInventory().addItem(gaps);
        p.getInventory().addItem(strength);
        p.getInventory().addItem(speed);
    }
    public static void giveAbility(Player p) {
        ItemStack helm = new ItemStack(Material.DIAMOND_HELMET);
        helm.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
        ItemStack chest = new ItemStack(Material.DIAMOND_CHESTPLATE);
        chest.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
        ItemStack legs = new ItemStack(Material.DIAMOND_LEGGINGS);
        legs.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
        ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
        boots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
        ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
        sword.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
        sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
        ItemStack rod = new ItemStack(Material.FISHING_ROD);
        rod.addUnsafeEnchantment(Enchantment.KNOCKBACK, 5);
        ItemStack gaps = new ItemStack(Material.GOLDEN_APPLE, 64, (short) 1);
        ItemStack carrots = new ItemStack(Material.GOLDEN_CARROT, 64);
        ItemStack bow = new ItemStack(Material.BOW);
        bow.addEnchantment(Enchantment.ARROW_DAMAGE, 5);
        bow.addEnchantment(Enchantment.ARROW_KNOCKBACK, 2);
        bow.addEnchantment(Enchantment.ARROW_FIRE, 1);
        ItemStack arrows = new ItemStack(Material.ARROW, 64);
        p.getInventory().setHelmet(helm);
        p.getInventory().setChestplate(chest);
        p.getInventory().setLeggings(legs);
        p.getInventory().setBoots(boots);
        p.getInventory().addItem(sword);
        p.getInventory().addItem(bow);
        p.getInventory().addItem(rod);
        p.getInventory().addItem(gaps);
        p.getInventory().addItem(carrots);
        p.getInventory().addItem(arrows);
    }
    public static void giveStrafe(Player p) {
        ItemStack helm = new ItemStack(Material.DIAMOND_HELMET);
        ItemStack chest = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemStack legs = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemStack boots = new ItemStack(Material.IRON_BOOTS);
        ItemStack sword = new ItemStack(Material.IRON_SWORD);
        ItemStack rod = new ItemStack(Material.FISHING_ROD);
        ItemStack speed = new ItemStack(Material.POTION, 1, (short) 16482);
        p.getInventory().setHelmet(helm);
        p.getInventory().setChestplate(chest);
        p.getInventory().setLeggings(legs);
        p.getInventory().setBoots(boots);
        p.getInventory().addItem(sword);
        p.getInventory().addItem(rod);
        p.getInventory().addItem(speed);
        p.getInventory().addItem(speed);
        p.getInventory().addItem(speed);

    }
    public static void giveSoup(Player p) {
        ItemStack helm = new ItemStack(Material.IRON_HELMET);
        ItemStack chest = new ItemStack(Material.IRON_CHESTPLATE);
        ItemStack legs = new ItemStack(Material.IRON_LEGGINGS);
        ItemStack boots = new ItemStack(Material.IRON_BOOTS);
        ItemStack sword = new ItemStack(Material.IRON_SWORD);
        ItemStack rod = new ItemStack(Material.FISHING_ROD);
        p.getInventory().setHelmet(helm);
        p.getInventory().setChestplate(chest);
        p.getInventory().setLeggings(legs);
        p.getInventory().setBoots(boots);
        p.getInventory().addItem(sword);
        p.getInventory().addItem(rod);
        for(int i = 0; i < 11; i++) {
            p.getInventory().addItem(new ItemStack(Material.MUSHROOM_SOUP));
        }
    }
    public static void giveSG(Player p) {
        ItemStack helm = new ItemStack(Material.GOLD_HELMET);
        ItemStack chest = new ItemStack(Material.IRON_CHESTPLATE);
        ItemStack legs = new ItemStack(Material.CHAINMAIL_LEGGINGS);
        ItemStack boots = new ItemStack(Material.IRON_BOOTS);
        ItemStack sword = new ItemStack(Material.STONE_SWORD);
        ItemStack bow = new ItemStack(Material.BOW);
        ItemStack rod = new ItemStack(Material.FISHING_ROD);
        ItemStack carrot = new ItemStack(Material.CARROT, 2);
        ItemStack pie = new ItemStack(Material.PUMPKIN_PIE);
        ItemStack gcarrot = new ItemStack(Material.CARROT);
        ItemStack gap = new ItemStack(Material.GOLDEN_APPLE);
        ItemStack arrows = new ItemStack(Material.ARROW, 8);
        p.getInventory().setHelmet(helm);
        p.getInventory().setChestplate(chest);
        p.getInventory().setLeggings(legs);
        p.getInventory().setBoots(boots);
        p.getInventory().addItem(sword);
        p.getInventory().addItem(bow);
        p.getInventory().addItem(rod);
        p.getInventory().addItem(gap);
        p.getInventory().addItem(carrot);
        p.getInventory().addItem(pie);
        p.getInventory().addItem(gcarrot);
        p.getInventory().addItem(arrows);
    }
    public static void giveOG(Player p) {
        ItemStack helm = new ItemStack(Material.DIAMOND_HELMET);
        ItemStack chest = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemStack legs = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
        helm.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
        chest.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 3);
        legs.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
        boots.addEnchantment(Enchantment.PROTECTION_FALL, 3);
        ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
        sword.addEnchantment(Enchantment.DAMAGE_ALL, 3);
        sword.addEnchantment(Enchantment.FIRE_ASPECT, 2);
        ItemStack bow = new ItemStack(Material.BOW);
        bow.addEnchantment(Enchantment.ARROW_DAMAGE, 4);
        bow.addEnchantment(Enchantment.ARROW_INFINITE, 1);
        ItemStack gaps = new ItemStack(Material.GOLDEN_APPLE, 32);
        ItemStack rod = new ItemStack(Material.FISHING_ROD);
        ItemStack carrots = new ItemStack(Material.GOLDEN_CARROT, 64);
        ItemStack health = new ItemStack(Material.POTION, 1, (short) 8197);
        ItemStack speed = new ItemStack(Material.POTION, 1, (short) 8290);
        ItemStack strength = new ItemStack(Material.POTION, 1, (short) 8265);
        ItemStack fire = new ItemStack(Material.POTION, 1, (short) 8291);
        ItemStack PosionPotion = new ItemStack(Material.POTION, 1, (short) 16452);
        ItemStack slow = new ItemStack(Material.POTION, 1, (short) 16458);
        ItemStack weak = new ItemStack(Material.POTION, 1, (short) 16456);

        p.getInventory().setHelmet(helm);
        p.getInventory().setChestplate(chest);
        p.getInventory().setLeggings(legs);
        p.getInventory().setBoots(boots);
        
        p.getInventory().setItem(0, sword);
        p.getInventory().setItem(1, bow);
        p.getInventory().setItem(2, rod);
        p.getInventory().setItem(3, gaps);
        p.getInventory().setItem(4, carrots);
        p.getInventory().setItem(5, strength);
        p.getInventory().setItem(6, speed);
        p.getInventory().setItem(7, fire);
        p.getInventory().setItem(8, health);
        p.getInventory().setItem(23, strength);
        p.getInventory().setItem(32, strength);
        p.getInventory().setItem(24, speed);
        p.getInventory().setItem(33, speed);
        p.getInventory().setItem(25, fire);
        p.getInventory().setItem(34, fire);
        p.getInventory().setItem(26,health);
        p.getInventory().setItem(35, health);
        p.getInventory().setItem(15, PosionPotion);
        p.getInventory().setItem(16, slow);
        p.getInventory().setItem(17, weak);

        for(int i = 0; i < 16; i++) {
            p.getInventory().addItem(health);
        }
    }
    public static void giveNoDebuff(Player p) {
        ItemStack helm = new ItemStack(Material.DIAMOND_HELMET);
        ItemStack chest = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemStack legs = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
        helm.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
        chest.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 3);
        legs.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
        boots.addEnchantment(Enchantment.PROTECTION_FALL, 3);
        ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
        sword.addEnchantment(Enchantment.DAMAGE_ALL, 3);
        sword.addEnchantment(Enchantment.FIRE_ASPECT, 2);
        ItemStack bow = new ItemStack(Material.BOW);
        bow.addEnchantment(Enchantment.ARROW_DAMAGE, 4);
        bow.addEnchantment(Enchantment.ARROW_INFINITE, 1);
        ItemStack gaps = new ItemStack(Material.GOLDEN_APPLE, 32);
        ItemStack rod = new ItemStack(Material.FISHING_ROD);
        ItemStack carrots = new ItemStack(Material.GOLDEN_CARROT, 64);
        ItemStack health = new ItemStack(Material.POTION, 1, (short) 8197);
        ItemStack speed = new ItemStack(Material.POTION, 1, (short) 8290);
        ItemStack strength = new ItemStack(Material.POTION, 1, (short) 8265);
        ItemStack fire = new ItemStack(Material.POTION, 1, (short) 8291);

        p.getInventory().setHelmet(helm);
        p.getInventory().setChestplate(chest);
        p.getInventory().setLeggings(legs);
        p.getInventory().setBoots(boots);

        p.getInventory().setItem(0, sword);
        p.getInventory().setItem(1, bow);
        p.getInventory().setItem(2, rod);
        p.getInventory().setItem(3, gaps);
        p.getInventory().setItem(4, carrots);
        p.getInventory().setItem(5, strength);
        p.getInventory().setItem(6, speed);
        p.getInventory().setItem(7, fire);
        p.getInventory().setItem(8, health);
        p.getInventory().setItem(23, strength);
        p.getInventory().setItem(32, strength);
        p.getInventory().setItem(24, speed);
        p.getInventory().setItem(33, speed);
        p.getInventory().setItem(25, fire);
        p.getInventory().setItem(34, fire);
        p.getInventory().setItem(26,health);
        p.getInventory().setItem(35, health);
        p.getInventory().setItem(15, health);
        p.getInventory().setItem(16, health);
        p.getInventory().setItem(17, health);

        for(int i = 0; i < 16; i++) {
            p.getInventory().addItem(health);
        }
    }
}
