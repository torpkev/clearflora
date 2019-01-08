package work.torp.clearfauna.commands;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import work.torp.clearfauna.Main;
import work.torp.clearfauna.alerts.Alert;
import work.torp.clearfauna.helpers.Convert;
import work.torp.clearfauna.helpers.Functions;

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
				Alert.Log("ClearFauna", "Radius : " + Integer.toString(radius) + " | Height: " + Integer.toString(height));
				Location loc = player.getLocation();
				Location loc1 = new Location(loc.getWorld(), loc.getBlockX() + radius, loc.getBlockY() + height, loc.getBlockZ() + radius);
				Location loc2 =  new Location(loc.getWorld(), loc.getBlockX() - radius, loc.getBlockY() - height, loc.getBlockZ() - radius);
				
				Alert.Log("ClearFauna", "Locations Found: " + Convert.LocationToReadableString(loc1) + " | " + Convert.LocationToReadableString(loc2));
				List<Block> lstCube = Functions.blocksFromTwoPoints(loc1, loc2);
				
				if (lstCube != null)
				{
					for (Block b : lstCube)
					{
						if (b.getType() == Material.GRASS || b.getType() == Material.TALL_GRASS)
						{
							Alert.Log("ClearFauna", "Clearing " + b.getType().name() + " at " + Convert.LocationToReadableString(b.getLocation()));
							b.setType(Material.AIR);
						}
						if (b.getType() == Material.GRASS_BLOCK)
						{
							Alert.Log("ClearFauna", "Clearing " + b.getType().name() + " at " + Convert.LocationToReadableString(b.getLocation()));
							b.setType(Material.DIRT);
						}
					}
				}
			}
		}
		
		return ret;
	}
}
