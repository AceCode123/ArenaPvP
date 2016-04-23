package me.Anthony;

import org.bukkit.Location;
import org.bukkit.entity.HumanEntity;

/**
 * Created by thresher1436 on 1/31/2016.
 */
public class NPC {

    private HumanEntity entity;
    private String name;
    private int id;
    public NPC(HumanEntity entity, String name, int id, Location l) {
        this.entity = entity;
        this.name = name;
        this.entity.getName().equals(name);
        this.id = id;
    }
    public HumanEntity getEntity() {
        return entity;
    }
    public String getName() {
        return name;
    }
    public int getId() { return id; }


}
