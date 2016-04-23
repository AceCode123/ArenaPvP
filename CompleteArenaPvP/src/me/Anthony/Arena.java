package me.Anthony;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;

/**
 * Created by thresher1436 on 1/24/2016.
 */
public class Arena {

    private int id;
    private Location fighter1;
    private Location fighter2;
    private ArrayList<Player> players = new ArrayList<Player>();
    private ArrayList<Player> spectaters = new ArrayList<Player>();
    private String type;
    private boolean started = false;
    private boolean ranked;

    public Arena(int id, Location f1, Location f2, String type, boolean ranked) {
        this.id = id;
        this.fighter1 = f1;
        this.fighter2 = f2;
        this.type = type;
        this.ranked = ranked;
    }

    public int getId() {
        return id;
    }
    public Location getFighter1() {
        return fighter1;
    }
    public Location getFighter2() {
        return fighter2;
    }
    public String getType() {
        return type;
    }
    public boolean isRanked() {
        return ranked;
    }
    public boolean isStarted() {
        return started;
    }
    public ArrayList<Player> getSpectaters() {
        return spectaters;
    }
    public ArrayList<Player> getPlayers() {
        return players;
    }
    public void start() {
        this.started = true;
    }
    public void stop() {
        this.started = false;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setRanked(boolean ranked) {
        this.ranked = ranked;
    }

}
