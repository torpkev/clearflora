package work.torp.clearfauna.helpers;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;

public class Functions {
    public static List<Location> getHollowCube(Location corner1, Location corner2) {
        List<Location> result = new ArrayList<Location>();
        World world = corner1.getWorld();
        double minX = Math.min(corner1.getX(), corner2.getX()) - 1;
        double minY = Math.min(corner1.getY(), corner2.getY()) - 1;
        double minZ = Math.min(corner1.getZ(), corner2.getZ()) - 1;
        double maxX = Math.max(corner1.getX(), corner2.getX()) + 1;
        double maxY = Math.max(corner1.getY(), corner2.getY()) + 1;
        double maxZ = Math.max(corner1.getZ(), corner2.getZ()) + 1;
       
        for (double x = minX; x <= maxX; x++) {
            for (double y = minY; y <= maxY; y++) {
                for (double z = minZ; z <= maxZ; z++) {
                    int components = 0;
                    if (x == minX || x == maxX) components++;
                    if (y == minY || y == maxY) components++;
                    if (z == minZ || z == maxZ) components++;
                    if (components >= 2) {
                        result.add(new Location(world, x, y, z));
                    }
                }
            }
        }
       
        return result;
    }
    public static List<Block> blocksFromTwoPoints(Location corner1, Location corner2)
    {
        List<Block> blocks = new ArrayList<Block>();
 
        World world = corner1.getWorld();
        double minX = Math.min(corner1.getX(), corner2.getX()) - 1;
        double minY = Math.min(corner1.getY(), corner2.getY()) - 1;
        double minZ = Math.min(corner1.getZ(), corner2.getZ()) - 1;
        double maxX = Math.max(corner1.getX(), corner2.getX()) + 1;
        double maxY = Math.max(corner1.getY(), corner2.getY()) + 1;
        double maxZ = Math.max(corner1.getZ(), corner2.getZ()) + 1;
       
        for (double x = minX; x <= maxX; x++) {
            for (double y = minY; y <= maxY; y++) {
                for (double z = minZ; z <= maxZ; z++) {
                	
                	Block b = new Location(world, x, y, z).getBlock();
                	blocks.add(b);
                }
            }
        }
       
       
        return blocks;
    }
    public static boolean isInteger(String s) {
        return isInteger(s,10);
    }

    public static boolean isInteger(String s, int radix) {
        if(s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),radix) < 0) return false;
        }
        return true;
    }
}
