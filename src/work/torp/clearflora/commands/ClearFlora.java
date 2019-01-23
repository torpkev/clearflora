package work.torp.clearflora.commands;
//
//import java.util.List;
//
//import org.bukkit.Location;
//import org.bukkit.Material;
//import org.bukkit.block.Block;
//import org.bukkit.block.data.BlockData;
//import org.bukkit.block.data.Waterlogged;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import work.torp.clearflora.Main;
import work.torp.clearflora.alerts.Alert;
import work.torp.clearflora.classes.ControlsGUI;
import work.torp.clearflora.helpers.BlockFunctions;
import work.torp.clearflora.helpers.Convert;
import work.torp.clearflora.helpers.Functions;


public class ClearFlora implements CommandExecutor {
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		boolean ret = false;
		
		if (sender instanceof Player) { // Check if the sender is console or a player
			Player player = (Player) sender; // Cast the sender to a player			
			if (player.hasPermission("flora.clear"))
			{
				StringBuilder fullargs = new StringBuilder();
				int iargs = 0;
				if (args.length > 0) {
					for (Object o : args)
					{
						iargs++;
						fullargs.append(o.toString());
						fullargs.append(" ");
					}
					Alert.DebugLog("ClearFlora", "onCommand", "/clearflora command run by " + sender.getName() + " with arguments: " + fullargs);
				}
				
				if (iargs == 0) {
					ControlsGUI gui = new ControlsGUI();
					player.openInventory(gui.getInventory()); // display the GUI
				} else {
					

					boolean grass_to_dirt = Main.getInstance().getGrassToDirt();
					boolean remove_grass = Main.getInstance().getRemoveGrass();
					boolean remove_tall_grass = Main.getInstance().getRemoveGrass();
					boolean remove_flowers = Main.getInstance().getRemoveFlowers();
					boolean remove_leaves = Main.getInstance().getRemoveLeaves();
					boolean remove_water_flora = Main.getInstance().getRemoveWaterFlora();
					int radius = Main.getInstance().getRadius();
					int height = Main.getInstance().getHeight();

					if (iargs >= 1)
					{
						if (args[0].toString().equalsIgnoreCase("help"))
						{
							Alert.Player("Usage: /clearflora " + ChatColor.AQUA + 
									"<radius " + ChatColor.GRAY + "(#)" + ChatColor.AQUA + "> " + 
									"<height " + ChatColor.GRAY + "(#)" + ChatColor.AQUA + "> " + 
									"<grass_to_dirt " + ChatColor.GRAY + "(true/false)" + ChatColor.AQUA + "> " +
									"<remove_grass " + ChatColor.GRAY + "(true/false)" + ChatColor.AQUA + "> " +
									"<remove_tall_grass " + ChatColor.GRAY + "(true/false)" + ChatColor.AQUA + "> " +
									"<remove_flowers " + ChatColor.GRAY + "(true/false)" + ChatColor.AQUA + "> " +
									"<remove_leaves " + ChatColor.GRAY + "(true/false)" + ChatColor.AQUA + "> " +
									"<remove_water_flora " + ChatColor.GRAY + "(true/false)" + ChatColor.AQUA + "> ", 
									player, true);
							Alert.Player("Example: /clearflora 15 5 true true false true true", player, true);
							Alert.Player("The optional arguments allow you to specify radius, height and what should be cleared.  If you do not include them (or provide an invalid value type), the defaults will be used", player, true);
							return true;
						}
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
					if (iargs >= 3)
					{
						if (Functions.isBoolean(args[2].toString()))
						{
							grass_to_dirt = Convert.BooleanFromString(args[2].toString());
						}
					}
					if (iargs >= 4)
					{
						if (Functions.isBoolean(args[3].toString()))
						{
							remove_grass = Convert.BooleanFromString(args[3].toString());
						}
					}
					if (iargs >= 5)
					{
						if (Functions.isBoolean(args[4].toString()))
						{
							remove_tall_grass = Convert.BooleanFromString(args[4].toString());
						}
					}
					if (iargs >= 6)
					{
						if (Functions.isBoolean(args[5].toString()))
						{
							remove_flowers = Convert.BooleanFromString(args[5].toString());
						}
					}
					if (iargs >= 7)
					{
						if (Functions.isBoolean(args[6].toString()))
						{
							remove_leaves = Convert.BooleanFromString(args[6].toString());
						}
					}
					if (iargs >= 8)
					{
						if (Functions.isBoolean(args[7].toString()))
						{
							remove_water_flora = Convert.BooleanFromString(args[7].toString());
						}
					}
					
					if (radius > 100)
					{
						Alert.Player("ClearFlora has a maximum radius of 100, radius has been reduced to maximum", player, true);
						radius = 100;				
					}
					if (height > 40)
					{
						Alert.Player("ClearFlora has a maximum height of 40, height has been reduced to maximum", player, true);
						height = 40;				
					}
					
					BlockFunctions.clearFlora(player.getUniqueId(), radius, height, grass_to_dirt, remove_grass, remove_tall_grass, remove_flowers, remove_leaves, remove_water_flora);
				}				
			} else {
				Alert.Player("You do not have permission to use ClearFlora", player, true);
			}
		} else {
			Alert.Sender("This command must be called by a player", sender, true);
		}
		
		return ret;
	}
}
