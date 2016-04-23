package me.Anthony.me.Anthony.SubCommands;

import me.Anthony.ArenaManager;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

/**
 * Created by thresher1436 on 2/19/2016.
 */
public class Lobby implements Listener {

    @EventHandler
    public void onHit(EntityDamageByEntityEvent event) {
        if(event.getEntity() instanceof Player) {
            if(event.getDamager() instanceof Player) {
                Player p = (Player) event.getEntity();
                if(!(ArenaManager.getManager().isInGame(p))) {
                    event.setCancelled(true);
                }
            }
        }
    }



    @EventHandler
    public void Hunger(FoodLevelChangeEvent event) {
        if(event.getEntity() instanceof Player) {
            Player p = (Player) event.getEntity();
            if(!(ArenaManager.getManager().isInGame(p))) {
                event.setCancelled(true);
            }
        }
    }

}
