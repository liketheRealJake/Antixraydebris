package com.jakes.antixraydebris;

import io.papermc.paper.event.packet.PlayerChunkLoadEvent;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPhysicsEvent;

public class EventsListener implements Listener {

    @EventHandler
    public void onChunkLoad(PlayerChunkLoadEvent event) {
        if (event.getChunk().getWorld().getName().equals("world_nether")) {
            if (event.getChunk().getChunkSnapshot().contains(Material.ANCIENT_DEBRIS.createBlockData())) {

                Chunk chunk = event.getChunk();
                Player player = event.getPlayer();

                for (int x = 0; x < 16; x++) {
                    for (int z = 0; z < 16; z++) {
                        for (int y = 7; y < 120; y++) {
                            if (chunk.getBlock(x, y, z).getType() == Material.ANCIENT_DEBRIS) {
                                if (!Antixraydebris.isTouchingAir(chunk.getBlock(x, y, z))) {
                                    Block block = chunk.getBlock(x, y, z);
                                    player.sendBlockChange(block.getLocation(), Material.NETHERRACK.createBlockData());
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onPhysicsUpdateEvent(BlockPhysicsEvent event) {
        try {
            if(event.getBlock().getWorld().getName().equals("world_nether")) {
                if(event.getBlock().getType().equals(Material.ANCIENT_DEBRIS)) {
                    event.getBlock().getState().update();
                }
                for(Block b : Antixraydebris.getTouchingDebris(event.getBlock())) {
                    b.getState().update();
                }
            }
        }catch (NullPointerException ignored) {
        }
    }
}
