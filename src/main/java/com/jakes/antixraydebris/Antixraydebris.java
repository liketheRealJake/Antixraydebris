package com.jakes.antixraydebris;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class Antixraydebris extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new EventsListener(), this);
    }

    @Override
    public void onDisable() {

    }

    public static ArrayList<Block> getTouchingDebris(Block block) {
        ArrayList<Block> touching = new ArrayList<>();
        int x = block.getX();
        int y = block.getY();
        int z = block.getZ();
        try {
            if (block.getWorld().getBlockAt(x-1, y, z).getType().equals(Material.ANCIENT_DEBRIS)) {
                touching.add(block.getWorld().getBlockAt(x-1, y, z));
            }
            if (block.getWorld().getBlockAt(x+1, y, z).getType().equals(Material.ANCIENT_DEBRIS)) {
                touching.add(block.getWorld().getBlockAt(x+1, y, z));
            }
            if (block.getWorld().getBlockAt(x, y-1, z).getType().equals(Material.ANCIENT_DEBRIS)) {
                touching.add(block.getWorld().getBlockAt(x, y-1, z));
            }
            if (block.getWorld().getBlockAt(x, y+1, z).getType().equals(Material.ANCIENT_DEBRIS)) {
                touching.add(block.getWorld().getBlockAt(x, y+1, z));
            }
            if (block.getWorld().getBlockAt(x, y, z-1).getType().equals(Material.ANCIENT_DEBRIS)) {
                touching.add(block.getWorld().getBlockAt(x, y, z-1));
            }
            if (block.getWorld().getBlockAt(x, y, z+1).getType().equals(Material.ANCIENT_DEBRIS)) {
                touching.add(block.getWorld().getBlockAt(x, y, z+1));
            }
        } catch (NullPointerException ignored) {}
        return touching;
    }

    public static boolean isTouchingAir(Block block) {
        int x = block.getX();
        int y = block.getY();
        int z = block.getZ();
        try {
            if (block.getWorld().getBlockAt(x-1, y, z).getType().equals(Material.AIR)) {
                return true;
            }
            if (block.getWorld().getBlockAt(x+1, y, z).getType().equals(Material.AIR)) {
                return true;
            }
            if (block.getWorld().getBlockAt(x, y-1, z).getType().equals(Material.AIR)) {
                return true;
            }
            if (block.getWorld().getBlockAt(x, y+1, z).getType().equals(Material.AIR)) {
                return true;
            }
            if (block.getWorld().getBlockAt(x, y, z-1).getType().equals(Material.AIR)) {
                return true;
            }
            if (block.getWorld().getBlockAt(x, y, z+1).getType().equals(Material.AIR)) {
                return true;
            }
        } catch (NullPointerException ignored) {}
        return false;
    }
}
