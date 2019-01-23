package work.torp.clearflora.helpers;

import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Waterlogged;
import org.bukkit.entity.Player;

import work.torp.clearflora.Main;
import work.torp.clearflora.alerts.Alert;

public class BlockFunctions {
	public static void clearFlora(UUID uuid, int radius, int height, boolean grass_to_dirt, boolean remove_grass, boolean remove_tall_grass, boolean remove_flowers, boolean remove_leaves, boolean remove_water_flora)
	{
		Alert.DebugLog("BlockFunctions", "clearFlora", "Radius = " + Integer.toString(radius) + " Height = " + Integer.toString(height) + " Grass To Dirt = " + Boolean.toString(grass_to_dirt) + " Remove Grass = " + Boolean.toString(remove_grass) + " Remove Tall Grass = " + Boolean.toString(remove_tall_grass) + " Remove Flowers = " + Boolean.toString(remove_flowers) + " Remove Leaves = " + Boolean.toString(remove_leaves) + " Remove Water Flora = " + Boolean.toString(remove_water_flora));
		Player player = Bukkit.getPlayer(uuid);
		if (player != null)
		{
			Location loc = player.getLocation();
			Location loc1 = new Location(loc.getWorld(), loc.getBlockX() + radius, loc.getBlockY() + height, loc.getBlockZ() + radius);
			Location loc2 =  new Location(loc.getWorld(), loc.getBlockX() - radius, loc.getBlockY() - height, loc.getBlockZ() - radius);
			
			Alert.Log("ClearFlora", "Locations Found: " + Convert.LocationToReadableString(loc1) + " | " + Convert.LocationToReadableString(loc2));
			List<Block> lstCube = Functions.blocksFromTwoPoints(loc1, loc2);
			
			List<Material> lstFlowers = MaterialGrouping.Flowers();
			List<Material> lstLeaves = MaterialGrouping.Leaves();
			List<Material> lstWaterFlora = MaterialGrouping.WaterFlora();
			
			int iGrassToDirt = 0;
			int iRemoveGrass = 0;
			int iRemoveTallGrass = 0;
			int iRemoveFlowers = 0;
			int iRemoveLeaves = 0;
			int iRemoveWaterFlora = 0;
			
			if (lstCube != null)
			{
				for (Block b : lstCube)
				{
	
					if (b.getType() == Material.GRASS_BLOCK && grass_to_dirt)
					{
						Alert.Log("ClearFlora", "Clearing " + b.getType().name() + " at " + Convert.LocationToReadableString(b.getLocation()));
						b.setType(Material.DIRT);
						iGrassToDirt++;
					}
					if (b.getType() == Material.GRASS && remove_grass)
					{
						Alert.Log("ClearFlora", "Clearing " + b.getType().name() + " at " + Convert.LocationToReadableString(b.getLocation()));
						b.setType(Material.AIR);
						iRemoveGrass++;
					}
					if (b.getType() == Material.TALL_GRASS && remove_tall_grass)
					{
						Alert.Log("ClearFlora", "Clearing " + b.getType().name() + " at " + Convert.LocationToReadableString(b.getLocation()));
						b.setType(Material.AIR);
						iRemoveTallGrass++;
					}
					if (lstFlowers != null)
					{
						for (Material flower : lstFlowers)
						{
							if (flower.name().equals(b.getType().name()))
							{
								if (remove_flowers)
								{
									Alert.Log("ClearFlora", "Clearing " + b.getType().name() + " at " + Convert.LocationToReadableString(b.getLocation()));
									b.setType(Material.AIR);
									iRemoveFlowers++;
									break;
								}
							}
						}
					}
					if (lstLeaves != null)
					{
						for (Material leaf : lstLeaves)
						{
							if (leaf.name().equals(b.getType().name()))
							{
								if (remove_leaves)
								{
									Alert.Log("ClearFlora", "Clearing " + b.getType().name() + " at " + Convert.LocationToReadableString(b.getLocation()));
									b.setType(Material.AIR);
									iRemoveLeaves++;
									break;
								}
							}
						}
					}
					if (lstWaterFlora != null)
					{
						for (Material waterflora : lstWaterFlora)
						{
							if (waterflora.name().equals(b.getType().name()))
							{
								if (remove_water_flora)
								{
									Alert.Log("ClearFlora", "Clearing " + b.getType().name() + " at " + Convert.LocationToReadableString(b.getLocation()));
									BlockData bd = b.getBlockData();
									if (bd instanceof Waterlogged)
									{
										b.setType(Material.WATER);
									} else {
										b.setType(Material.AIR);
									}
									iRemoveWaterFlora++;
									break;
								}
							}
						}
					}

				}
			}
			Alert.Player("Clear Flora Complete", player, true);
			if (Main.getInstance().getViewStats())
			{
				Alert.Player("Clear Flora Stats: Grass to Dirt: " + Integer.toString(iGrassToDirt) + " blocks | Removed Grass: " + Integer.toString(iRemoveGrass) + " | Removed Tall Grass: " + Integer.toString(iRemoveTallGrass) + " | Removed Flowers: " + Integer.toString(iRemoveFlowers) + " | Removed Leaves: " + Integer.toString(iRemoveLeaves) + " | Removed Water Flora: " + Integer.toString(iRemoveWaterFlora), player, true);
			}
		}
	}
}
