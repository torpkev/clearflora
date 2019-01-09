package work.torp.clearfauna.commands;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Waterlogged;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import work.torp.clearfauna.Main;
import work.torp.clearfauna.alerts.Alert;
import work.torp.clearfauna.helpers.Convert;
import work.torp.clearfauna.helpers.Functions;
import work.torp.clearfauna.helpers.MaterialGrouping;


public class ClearFauna implements CommandExecutor {
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		boolean ret = false;
		
		if (sender instanceof Player) { // Check if the sender is console or a player
			Player player = (Player) sender; // Cast the sender to a player			
			if (player.hasPermission("fauna.clear"))
			{
				int radius = Main.getInstance().getRadius();
				int height = Main.getInstance().getHeight();

				
				StringBuilder fullargs = new StringBuilder();
				int iargs = 0;
				if (args.length > 0) {
					for (Object o : args)
					{
						iargs++;
						fullargs.append(o.toString());
						fullargs.append(" ");
					}
					Alert.DebugLog("ClearFauna", "onCommand", "/clearfauna command run by " + sender.getName() + " with arguments: " + fullargs);
				}
				if (iargs >= 1)
				{
					if (Functions.isInteger(args[0].toString()))
					{
						radius = Convert.IntegerFromString(args[0].toString());
					}
				}
				if (iargs >= 2)
				{
					if (Functions.isInteger(args[1].toString()))
					{
						height = Convert.IntegerFromString(args[1].toString());
					}
				}
				
				if (radius > 50)
				{
					Alert.Player("ClearFauna has a maximum radius of 50, radius has been reduced to maximum", player, true);
					radius = 50;				
				}
				if (height > 20)
				{
					Alert.Player("ClearFauna has a maximum height of 20, height has been reduced to maximum", player, true);
					height = 20;				
				}
				
				Alert.Log("ClearFauna", "Radius : " + Integer.toString(radius) + " | Height: " + Integer.toString(height));
				Location loc = player.getLocation();
				Location loc1 = new Location(loc.getWorld(), loc.getBlockX() + radius, loc.getBlockY() + height, loc.getBlockZ() + radius);
				Location loc2 =  new Location(loc.getWorld(), loc.getBlockX() - radius, loc.getBlockY() - height, loc.getBlockZ() - radius);
				
				Alert.Log("ClearFauna", "Locations Found: " + Convert.LocationToReadableString(loc1) + " | " + Convert.LocationToReadableString(loc2));
				List<Block> lstCube = Functions.blocksFromTwoPoints(loc1, loc2);
				
				boolean grass_to_dirt = Main.getInstance().getGrassToDirt();
				boolean remove_grass = Main.getInstance().getRemoveGrass();
				boolean remove_tall_grass = Main.getInstance().getRemoveGrass();
				boolean remove_flowers = Main.getInstance().getRemoveFlowers();
				boolean remove_leaves = Main.getInstance().getRemoveLeaves();
				boolean remove_water_fauna = Main.getInstance().getRemoveWaterFauna();
				List<Material> lstFlowers = MaterialGrouping.Flowers();
				List<Material> lstLeaves = MaterialGrouping.Leaves();
				List<Material> lstWaterFauna = MaterialGrouping.WaterFauna();
				
				
				Alert.Log("ClearFauna", "grass_to_dirt: " + Boolean.toString(grass_to_dirt));
				Alert.Log("ClearFauna", "remove_grass: " + Boolean.toString(remove_grass));
				Alert.Log("ClearFauna", "remove_tall_grass: " + Boolean.toString(remove_tall_grass));
				Alert.Log("ClearFauna", "remove_flowers: " + Boolean.toString(remove_flowers));
				Alert.Log("ClearFauna", "remove_leaves: " + Boolean.toString(remove_leaves));
				Alert.Log("ClearFauna", "remove_water_fauna: " + Boolean.toString(remove_water_fauna));
				
				if (lstCube != null)
				{
					for (Block b : lstCube)
					{

						if (b.getType() == Material.GRASS_BLOCK && grass_to_dirt)
						{
							Alert.Log("ClearFauna", "Clearing " + b.getType().name() + " at " + Convert.LocationToReadableString(b.getLocation()));
							b.setType(Material.DIRT);
						}
						if (b.getType() == Material.GRASS && remove_grass)
						{
							Alert.Log("ClearFauna", "Clearing " + b.getType().name() + " at " + Convert.LocationToReadableString(b.getLocation()));
							b.setType(Material.AIR);
						}
						if (b.getType() == Material.TALL_GRASS && remove_tall_grass)
						{
							Alert.Log("ClearFauna", "Clearing " + b.getType().name() + " at " + Convert.LocationToReadableString(b.getLocation()));
							b.setType(Material.AIR);
						}
						if (lstFlowers != null)
						{
							for (Material flower : lstFlowers)
							{
								if (flower.name().equals(b.getType().name()))
								{
									if (remove_flowers)
									{
										Alert.Log("ClearFauna", "Clearing " + b.getType().name() + " at " + Convert.LocationToReadableString(b.getLocation()));
										b.setType(Material.AIR);
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
										Alert.Log("ClearFauna", "Clearing " + b.getType().name() + " at " + Convert.LocationToReadableString(b.getLocation()));
										b.setType(Material.AIR);
										break;
									}
								}
							}
						}
						if (lstWaterFauna != null)
						{
							for (Material waterfauna : lstWaterFauna)
							{
								if (waterfauna.name().equals(b.getType().name()))
								{
									if (remove_water_fauna)
									{
										Alert.Log("ClearFauna", "Clearing " + b.getType().name() + " at " + Convert.LocationToReadableString(b.getLocation()));
										BlockData bd = b.getBlockData();
										if (bd instanceof Waterlogged)
										{
											b.setType(Material.WATER);
										} else {
											b.setType(Material.AIR);
										}
										break;
									}
								}
							}
						}
					}
				}
			}
		}
		
		return ret;
	}
}
