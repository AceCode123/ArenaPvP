package me.Anthony;

import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thresher1436 on 1/31/2016.
 */
public class npcManager {

    private int npcIDs = 0;

    public static npcManager npc;

    private List<NPC> npcs = new ArrayList<NPC>();

    public static npcManager getManager() {
        if(npc == null)
            npc = new npcManager();
        return npc;
    }

    public NPC getNPC(int id) {
        for(NPC npc : this.npcs) {
            if(npc.getId() == id) {
                return npc;
            }
        }
        return null;
    }
    public void createNPC(String name, Location l) {

    }


}
