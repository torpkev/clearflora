package work.torp.clearflora.events;


import java.util.HashMap;

import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.ItemStack;

import net.md_5.bungee.api.ChatColor;
import work.torp.clearflora.Main;
import work.torp.clearflora.Main.IGUI;
import work.torp.clearflora.alerts.Alert;
import work.torp.clearflora.classes.ControlsGUI;
import work.torp.clearflora.classes.PlayerConfig;
import work.torp.clearflora.helpers.BlockFunctions;


public class InventoryEvents implements Listener {
	@EventHandler
    public void onInventoryClick(InventoryClickEvent e) {  
        if(e.getInventory().getHolder() instanceof IGUI) // check if the inventory opened is our storage GUI
        { 
        	Player player = null; // create the Player object
        	if (e.getWhoClicked() instanceof Player) // check to make sure the HumanEntity that clicked it is a player (should always be so)
        	{
        		player = (Player) e.getWhoClicked(); // cast the HumanEntity to Player
        		//Alert.Player("Item clicked - " + Integer.toString(e.getRawSlot()), player, true);
        		
        		boolean _grass_to_dirt = Main.getInstance().getGrassToDirt();
	    		boolean _remove_grass = Main.getInstance().getRemoveGrass();
	    		boolean _remove_tall_grass = Main.getInstance().getRemoveTallGrass();
	    		boolean _remove_flowers = Main.getInstance().getRemoveFlowers();
	    		boolean _remove_leaves = Main.getInstance().getRemoveLeaves();
	    		boolean _remove_water_flora = Main.getInstance().getRemoveWaterFlora();
	    		
	    		PlayerConfig newpc = new PlayerConfig();
	    		
	    		newpc.init(player.getUniqueId());
	    		if (Main.PlayerConfiguration.containsKey(player.getUniqueId()))
	    		{
	    			PlayerConfig pc = Main.PlayerConfiguration.get(player.getUniqueId());
	    			newpc = pc;
	    			if (pc != null)
	    			{
	    				_grass_to_dirt = pc.getGrassToDirt();
	    				_remove_grass = pc.getRemoveGrass();
	    				_remove_tall_grass = pc.getRemoveTallGrass();
	    				_remove_flowers = pc.getRemoveFlowers();
	    				_remove_leaves = pc.getRemoveLeaves();
	    				_remove_water_flora = pc.getRemoveWaterFlora();
	    			}
	    		} else {
	    			Alert.DebugLog("InventoryEvents", "onInventoryClick", "No such hashmap - using defaults");
	    		}

        		switch (e.getRawSlot())
        		{
	        		case 0:
	        			if (!_grass_to_dirt)
	    				{
	    					Alert.Player("Grass will be converted to plain dirt", player, true);
	    					ItemStack istack = ControlsGUI.GrassToDirt(true);
	    					e.getInventory().setItem(0, istack);
	    					newpc.setGrassToDirt(true);
	    				} else {
	    					Alert.Player("Grass will not be converted to plain dirt", player, true);
	    					ItemStack istack = ControlsGUI.GrassToDirt(false);
	    					e.getInventory().setItem(0, istack);
	    					newpc.setGrassToDirt(false);
	    				}
	        			Main.PlayerConfiguration.put(player.getUniqueId(), newpc);
	        			break;
	        		case 1:
	        			if (!_remove_grass)
	    				{
	    					Alert.Player("Grass will be removed", player, true);
	    					ItemStack istack = ControlsGUI.RemoveGrass(true);
	    					e.getInventory().setItem(1, istack);
	    					newpc.setRemoveGrass(true);
	    				} else {
	    					Alert.Player("Grass will not be removed", player, true);
	    					ItemStack istack = ControlsGUI.RemoveGrass(false);
	    					e.getInventory().setItem(1, istack);
	    					newpc.setRemoveGrass(false);
	    				}
	        			Main.PlayerConfiguration.put(player.getUniqueId(), newpc);
	        			break;	    
	        		case 2:
	        			if (!_remove_tall_grass)
	    				{
	    					Alert.Player("Tall Grass will be removed", player, true);
	    					ItemStack istack = ControlsGUI.RemoveTallGrass(true);
	    					e.getInventory().setItem(2, istack);
	    					newpc.setRemoveTallGrass(true);
	    				} else {
	    					Alert.Player("Tall Grass will not be removed", player, true);
	    					ItemStack istack = ControlsGUI.RemoveTallGrass(false);
	    					e.getInventory().setItem(2, istack);
	    					newpc.setRemoveTallGrass(false);
	    				}
	        			Main.PlayerConfiguration.put(player.getUniqueId(), newpc);
	        			break;		  
	        		case 3:
	        			if (!_remove_flowers)
	    				{
	    					Alert.Player("Flowers will be removed", player, true);
	    					ItemStack istack = ControlsGUI.RemoveFlowers(true);
	    					e.getInventory().setItem(3, istack);
	    					newpc.setRemoveFlowers(true);
	    				} else {
	    					Alert.Player("Flowers will not be removed", player, true);
	    					ItemStack istack = ControlsGUI.RemoveFlowers(false);
	    					e.getInventory().setItem(3, istack);
	    					newpc.setRemoveFlowers(false);
	    				}
	        			Main.PlayerConfiguration.put(player.getUniqueId(), newpc);
	        		case 4:
	        			if (!_remove_leaves)
	    				{
	    					Alert.Player("Leaves will be removed", player, true);
	    					ItemStack istack = ControlsGUI.RemoveLeaves(true);
	    					e.getInventory().setItem(4, istack);
	    					newpc.setRemoveLeaves(true);
	    				} else {
	    					Alert.Player("Leaves will not be removed", player, true);
	    					ItemStack istack = ControlsGUI.RemoveLeaves(false);
	    					e.getInventory().setItem(4, istack);
	    					newpc.setRemoveLeaves(false);
	    				}	   
	        			Main.PlayerConfiguration.put(player.getUniqueId(), newpc);
	        			break;	  
	        		case 5:
	        			if (!_remove_water_flora)
	    				{
	    					Alert.Player("Water Flora will be removed", player, true);
	    					ItemStack istack = ControlsGUI.RemoveWaterFlora(true);
	    					e.getInventory().setItem(5, istack);
	    					newpc.setRemoveWaterFlora(true);
	    				} else {
	    					Alert.Player("Leaves will not be removed", player, true);
	    					ItemStack istack = ControlsGUI.RemoveWaterFlora(false);
	    					e.getInventory().setItem(5, istack);
	    					newpc.setRemoveWaterFlora(false);
	    				}	  
	        			Main.PlayerConfiguration.put(player.getUniqueId(), newpc);
	        			break;	
	        		case 9:
	        			e.getInventory().setItem(9, ControlsGUI.RadiusSet(1));
	        			e.getInventory().setItem(10, ControlsGUI.RadiusNotSet(2));
	        			e.getInventory().setItem(11, ControlsGUI.RadiusNotSet(3));
	        			e.getInventory().setItem(12, ControlsGUI.RadiusNotSet(4));
	        			e.getInventory().setItem(13, ControlsGUI.RadiusNotSet(5));
	        			e.getInventory().setItem(14, ControlsGUI.RadiusNotSet(10));
	        			e.getInventory().setItem(15, ControlsGUI.RadiusNotSet(15));
	        			e.getInventory().setItem(16, ControlsGUI.RadiusNotSet(20));
	        			e.getInventory().setItem(17, ControlsGUI.RadiusNotSet(25));
	        			newpc.setRadius(1);
	        			Main.PlayerConfiguration.put(player.getUniqueId(), newpc);
	        			break;
	        		case 10:
	        			e.getInventory().setItem(9, ControlsGUI.RadiusNotSet(1));
	        			e.getInventory().setItem(10, ControlsGUI.RadiusSet(2));
	        			e.getInventory().setItem(11, ControlsGUI.RadiusNotSet(3));
	        			e.getInventory().setItem(12, ControlsGUI.RadiusNotSet(4));
	        			e.getInventory().setItem(13, ControlsGUI.RadiusNotSet(5));
	        			e.getInventory().setItem(14, ControlsGUI.RadiusNotSet(10));
	        			e.getInventory().setItem(15, ControlsGUI.RadiusNotSet(15));
	        			e.getInventory().setItem(16, ControlsGUI.RadiusNotSet(20));
	        			e.getInventory().setItem(17, ControlsGUI.RadiusNotSet(25));
	        			newpc.setRadius(2);
	        			Main.PlayerConfiguration.put(player.getUniqueId(), newpc);
	        			break;
	        		case 11:
	        			e.getInventory().setItem(9, ControlsGUI.RadiusNotSet(1));
	        			e.getInventory().setItem(10, ControlsGUI.RadiusNotSet(2));
	        			e.getInventory().setItem(11, ControlsGUI.RadiusSet(3));
	        			e.getInventory().setItem(12, ControlsGUI.RadiusNotSet(4));
	        			e.getInventory().setItem(13, ControlsGUI.RadiusNotSet(5));
	        			e.getInventory().setItem(14, ControlsGUI.RadiusNotSet(10));
	        			e.getInventory().setItem(15, ControlsGUI.RadiusNotSet(15));
	        			e.getInventory().setItem(16, ControlsGUI.RadiusNotSet(20));
	        			e.getInventory().setItem(17, ControlsGUI.RadiusNotSet(25));
	        			newpc.setRadius(3);
	        			Main.PlayerConfiguration.put(player.getUniqueId(), newpc);
	        			break;
	        		case 12:
	        			e.getInventory().setItem(9, ControlsGUI.RadiusNotSet(1));
	        			e.getInventory().setItem(10, ControlsGUI.RadiusNotSet(2));
	        			e.getInventory().setItem(11, ControlsGUI.RadiusNotSet(3));
	        			e.getInventory().setItem(12, ControlsGUI.RadiusSet(4));
	        			e.getInventory().setItem(13, ControlsGUI.RadiusNotSet(5));
	        			e.getInventory().setItem(14, ControlsGUI.RadiusNotSet(10));
	        			e.getInventory().setItem(15, ControlsGUI.RadiusNotSet(15));
	        			e.getInventory().setItem(16, ControlsGUI.RadiusNotSet(20));
	        			e.getInventory().setItem(17, ControlsGUI.RadiusNotSet(25));
	        			newpc.setRadius(4);
	        			Main.PlayerConfiguration.put(player.getUniqueId(), newpc);
	        			break;
	        		case 13:
	        			e.getInventory().setItem(9, ControlsGUI.RadiusNotSet(1));
	        			e.getInventory().setItem(10, ControlsGUI.RadiusNotSet(2));
	        			e.getInventory().setItem(11, ControlsGUI.RadiusNotSet(3));
	        			e.getInventory().setItem(12, ControlsGUI.RadiusNotSet(4));
	        			e.getInventory().setItem(13, ControlsGUI.RadiusSet(5));
	        			e.getInventory().setItem(14, ControlsGUI.RadiusNotSet(10));
	        			e.getInventory().setItem(15, ControlsGUI.RadiusNotSet(15));
	        			e.getInventory().setItem(16, ControlsGUI.RadiusNotSet(20));
	        			e.getInventory().setItem(17, ControlsGUI.RadiusNotSet(25));
	        			newpc.setRadius(5);
	        			Main.PlayerConfiguration.put(player.getUniqueId(), newpc);
	        			break;
	        		case 14:
	        			e.getInventory().setItem(9, ControlsGUI.RadiusNotSet(1));
	        			e.getInventory().setItem(10, ControlsGUI.RadiusNotSet(2));
	        			e.getInventory().setItem(11, ControlsGUI.RadiusNotSet(3));
	        			e.getInventory().setItem(12, ControlsGUI.RadiusNotSet(4));
	        			e.getInventory().setItem(13, ControlsGUI.RadiusNotSet(5));
	        			e.getInventory().setItem(14, ControlsGUI.RadiusSet(10));
	        			e.getInventory().setItem(15, ControlsGUI.RadiusNotSet(15));
	        			e.getInventory().setItem(16, ControlsGUI.RadiusNotSet(20));
	        			e.getInventory().setItem(17, ControlsGUI.RadiusNotSet(25));
	        			newpc.setRadius(10);
	        			Main.PlayerConfiguration.put(player.getUniqueId(), newpc);
	        			break;
	        		case 15:
	        			e.getInventory().setItem(9, ControlsGUI.RadiusNotSet(1));
	        			e.getInventory().setItem(10, ControlsGUI.RadiusNotSet(2));
	        			e.getInventory().setItem(11, ControlsGUI.RadiusNotSet(3));
	        			e.getInventory().setItem(12, ControlsGUI.RadiusNotSet(4));
	        			e.getInventory().setItem(13, ControlsGUI.RadiusNotSet(5));
	        			e.getInventory().setItem(14, ControlsGUI.RadiusNotSet(10));
	        			e.getInventory().setItem(15, ControlsGUI.RadiusSet(15));
	        			e.getInventory().setItem(16, ControlsGUI.RadiusNotSet(20));
	        			e.getInventory().setItem(17, ControlsGUI.RadiusNotSet(25));
	        			newpc.setRadius(15);
	        			Main.PlayerConfiguration.put(player.getUniqueId(), newpc);
	        			break;
	        		case 16:
	        			e.getInventory().setItem(9, ControlsGUI.RadiusNotSet(1));
	        			e.getInventory().setItem(10, ControlsGUI.RadiusNotSet(2));
	        			e.getInventory().setItem(11, ControlsGUI.RadiusNotSet(3));
	        			e.getInventory().setItem(12, ControlsGUI.RadiusNotSet(4));
	        			e.getInventory().setItem(13, ControlsGUI.RadiusNotSet(5));
	        			e.getInventory().setItem(14, ControlsGUI.RadiusNotSet(10));
	        			e.getInventory().setItem(15, ControlsGUI.RadiusNotSet(15));
	        			e.getInventory().setItem(16, ControlsGUI.RadiusSet(20));
	        			e.getInventory().setItem(17, ControlsGUI.RadiusNotSet(25));
	        			newpc.setRadius(20);
	        			Main.PlayerConfiguration.put(player.getUniqueId(), newpc);
	        			break;
	        		case 17:
	        			e.getInventory().setItem(9, ControlsGUI.RadiusNotSet(1));
	        			e.getInventory().setItem(10, ControlsGUI.RadiusNotSet(2));
	        			e.getInventory().setItem(11, ControlsGUI.RadiusNotSet(3));
	        			e.getInventory().setItem(12, ControlsGUI.RadiusNotSet(4));
	        			e.getInventory().setItem(13, ControlsGUI.RadiusNotSet(5));
	        			e.getInventory().setItem(14, ControlsGUI.RadiusNotSet(10));
	        			e.getInventory().setItem(15, ControlsGUI.RadiusNotSet(15));
	        			e.getInventory().setItem(16, ControlsGUI.RadiusNotSet(20));
	        			e.getInventory().setItem(17, ControlsGUI.RadiusSet(25));
	        			newpc.setRadius(25);
	        			Main.PlayerConfiguration.put(player.getUniqueId(), newpc);
	        			break;
	        		case 18:
	        			e.getInventory().setItem(18, ControlsGUI.HeightSet(1));
	        			e.getInventory().setItem(19, ControlsGUI.HeightNotSet(2));
	        			e.getInventory().setItem(20, ControlsGUI.HeightNotSet(3));
	        			e.getInventory().setItem(21, ControlsGUI.HeightNotSet(4));
	        			e.getInventory().setItem(22, ControlsGUI.HeightNotSet(5));
	        			e.getInventory().setItem(23, ControlsGUI.HeightNotSet(10));
	        			e.getInventory().setItem(24, ControlsGUI.HeightNotSet(15));
	        			e.getInventory().setItem(25, ControlsGUI.HeightNotSet(20));
	        			e.getInventory().setItem(26, ControlsGUI.HeightNotSet(25));
	        			newpc.setHeight(1);
	        			Main.PlayerConfiguration.put(player.getUniqueId(), newpc);
	        			break;
	        		case 19:
	        			e.getInventory().setItem(18, ControlsGUI.HeightNotSet(1));
	        			e.getInventory().setItem(19, ControlsGUI.HeightSet(2));
	        			e.getInventory().setItem(20, ControlsGUI.HeightNotSet(3));
	        			e.getInventory().setItem(21, ControlsGUI.HeightNotSet(4));
	        			e.getInventory().setItem(22, ControlsGUI.HeightNotSet(5));
	        			e.getInventory().setItem(23, ControlsGUI.HeightNotSet(10));
	        			e.getInventory().setItem(24, ControlsGUI.HeightNotSet(15));
	        			e.getInventory().setItem(25, ControlsGUI.HeightNotSet(20));
	        			e.getInventory().setItem(26, ControlsGUI.HeightNotSet(25));
	        			newpc.setHeight(2);
	        			Main.PlayerConfiguration.put(player.getUniqueId(), newpc);
	        			break;
	        		case 20:
	        			e.getInventory().setItem(18, ControlsGUI.HeightNotSet(1));
	        			e.getInventory().setItem(19, ControlsGUI.HeightNotSet(2));
	        			e.getInventory().setItem(20, ControlsGUI.HeightSet(3));
	        			e.getInventory().setItem(21, ControlsGUI.HeightNotSet(4));
	        			e.getInventory().setItem(22, ControlsGUI.HeightNotSet(5));
	        			e.getInventory().setItem(23, ControlsGUI.HeightNotSet(10));
	        			e.getInventory().setItem(24, ControlsGUI.HeightNotSet(15));
	        			e.getInventory().setItem(25, ControlsGUI.HeightNotSet(20));
	        			e.getInventory().setItem(26, ControlsGUI.HeightNotSet(25));
	        			newpc.setHeight(3);
	        			Main.PlayerConfiguration.put(player.getUniqueId(), newpc);
	        			break;
	        		case 21:
	        			e.getInventory().setItem(18, ControlsGUI.HeightNotSet(1));
	        			e.getInventory().setItem(19, ControlsGUI.HeightNotSet(2));
	        			e.getInventory().setItem(20, ControlsGUI.HeightNotSet(3));
	        			e.getInventory().setItem(21, ControlsGUI.HeightSet(4));
	        			e.getInventory().setItem(22, ControlsGUI.HeightNotSet(5));
	        			e.getInventory().setItem(23, ControlsGUI.HeightNotSet(10));
	        			e.getInventory().setItem(24, ControlsGUI.HeightNotSet(15));
	        			e.getInventory().setItem(25, ControlsGUI.HeightNotSet(20));
	        			e.getInventory().setItem(26, ControlsGUI.HeightNotSet(25));
	        			newpc.setHeight(4);
	        			Main.PlayerConfiguration.put(player.getUniqueId(), newpc);
	        			break;
	        		case 22:
	        			e.getInventory().setItem(18, ControlsGUI.HeightNotSet(1));
	        			e.getInventory().setItem(19, ControlsGUI.HeightNotSet(2));
	        			e.getInventory().setItem(20, ControlsGUI.HeightNotSet(3));
	        			e.getInventory().setItem(21, ControlsGUI.HeightNotSet(4));
	        			e.getInventory().setItem(22, ControlsGUI.HeightSet(5));
	        			e.getInventory().setItem(23, ControlsGUI.HeightNotSet(10));
	        			e.getInventory().setItem(24, ControlsGUI.HeightNotSet(15));
	        			e.getInventory().setItem(25, ControlsGUI.HeightNotSet(20));
	        			e.getInventory().setItem(26, ControlsGUI.HeightNotSet(25));
	        			newpc.setHeight(5);
	        			Main.PlayerConfiguration.put(player.getUniqueId(), newpc);
	        			break;
	        		case 23:
	        			e.getInventory().setItem(18, ControlsGUI.HeightNotSet(1));
	        			e.getInventory().setItem(19, ControlsGUI.HeightNotSet(2));
	        			e.getInventory().setItem(20, ControlsGUI.HeightNotSet(3));
	        			e.getInventory().setItem(21, ControlsGUI.HeightNotSet(4));
	        			e.getInventory().setItem(22, ControlsGUI.HeightNotSet(5));
	        			e.getInventory().setItem(23, ControlsGUI.HeightSet(19));
	        			e.getInventory().setItem(24, ControlsGUI.HeightNotSet(15));
	        			e.getInventory().setItem(25, ControlsGUI.HeightNotSet(20));
	        			e.getInventory().setItem(26, ControlsGUI.HeightNotSet(25));
	        			newpc.setHeight(10);
	        			Main.PlayerConfiguration.put(player.getUniqueId(), newpc);
	        			break;
	        		case 24:
	        			e.getInventory().setItem(18, ControlsGUI.HeightNotSet(1));
	        			e.getInventory().setItem(19, ControlsGUI.HeightNotSet(2));
	        			e.getInventory().setItem(20, ControlsGUI.HeightNotSet(3));
	        			e.getInventory().setItem(21, ControlsGUI.HeightNotSet(4));
	        			e.getInventory().setItem(22, ControlsGUI.HeightNotSet(5));
	        			e.getInventory().setItem(23, ControlsGUI.HeightNotSet(10));
	        			e.getInventory().setItem(24, ControlsGUI.HeightSet(24));
	        			e.getInventory().setItem(25, ControlsGUI.HeightNotSet(20));
	        			e.getInventory().setItem(26, ControlsGUI.HeightNotSet(25));
	        			newpc.setHeight(15);
	        			Main.PlayerConfiguration.put(player.getUniqueId(), newpc);
	        			break;
	        		case 25:
	        			e.getInventory().setItem(18, ControlsGUI.HeightNotSet(1));
	        			e.getInventory().setItem(19, ControlsGUI.HeightNotSet(2));
	        			e.getInventory().setItem(20, ControlsGUI.HeightNotSet(3));
	        			e.getInventory().setItem(21, ControlsGUI.HeightNotSet(4));
	        			e.getInventory().setItem(22, ControlsGUI.HeightNotSet(5));
	        			e.getInventory().setItem(23, ControlsGUI.HeightNotSet(10));
	        			e.getInventory().setItem(24, ControlsGUI.HeightNotSet(15));
	        			e.getInventory().setItem(25, ControlsGUI.HeightSet(20));
	        			e.getInventory().setItem(26, ControlsGUI.HeightNotSet(25));
	        			newpc.setHeight(20);
	        			Main.PlayerConfiguration.put(player.getUniqueId(), newpc);
	        			break;
	        		case 26:
	        			e.getInventory().setItem(18, ControlsGUI.HeightNotSet(1));
	        			e.getInventory().setItem(19, ControlsGUI.HeightNotSet(2));
	        			e.getInventory().setItem(20, ControlsGUI.HeightNotSet(3));
	        			e.getInventory().setItem(21, ControlsGUI.HeightNotSet(4));
	        			e.getInventory().setItem(22, ControlsGUI.HeightNotSet(5));
	        			e.getInventory().setItem(23, ControlsGUI.HeightNotSet(10));
	        			e.getInventory().setItem(24, ControlsGUI.HeightNotSet(15));
	        			e.getInventory().setItem(25, ControlsGUI.HeightNotSet(20));
	        			e.getInventory().setItem(26, ControlsGUI.HeightSet(25));
	        			newpc.setHeight(25);
	        			Main.PlayerConfiguration.put(player.getUniqueId(), newpc);
	        			break;	
	        		case 34:
	        			e.getWhoClicked().closeInventory();
	        			break;
	        		case 35:
	        			BlockFunctions.clearFlora(player.getUniqueId(), newpc.getRadius(), newpc.getHeight(), newpc.getGrassToDirt(), newpc.getRemoveGrass(), newpc.getRemoveTallGrass(), newpc.getRemoveFlowers(), newpc.getRemoveLeaves(), newpc.getRemoveWaterFlora());
	        			break;
        			default:
        				IGUI gui = (IGUI) e.getInventory().getHolder(); // get the InventoryHolder
        				
        				gui.onGUIClick((Player)e.getWhoClicked(), e.getRawSlot(), e.getCurrentItem()); // send the info to the GUI class
        				break;
        		}


        		e.setCancelled(true);
        		
        	}  
        }      
    }
	@EventHandler
	public void onInventoryOpen(InventoryOpenEvent e)
	{
		if (ChatColor.stripColor(e.getInventory().getName()).equals(ChatColor.stripColor("Clear Flora"))) // check if the inventory being closed is our Jukebox Storage
		{
			Alert.DebugLog("InventoryEvents", "onInventoryOpen", "Clear Flora Opened");
			Player player = null; // create the Player object
	    	if (e.getPlayer() instanceof Player) // check to make sure the HumanEntity that clicked it is a player (should always be so)
	    	{
	    		player = (Player) e.getPlayer();
	    		
	    		boolean _grass_to_dirt = Main.getInstance().getGrassToDirt();
	    		boolean _remove_grass = Main.getInstance().getRemoveGrass();
	    		boolean _remove_tall_grass = Main.getInstance().getRemoveTallGrass();
	    		boolean _remove_flowers = Main.getInstance().getRemoveFlowers();
	    		boolean _remove_leaves = Main.getInstance().getRemoveLeaves();
	    		boolean _remove_water_flora = Main.getInstance().getRemoveWaterFlora();
	    		
	    		if (Main.PlayerConfiguration.containsKey(player.getUniqueId()))
	    		{
	    			PlayerConfig pc = Main.PlayerConfiguration.get(player.getUniqueId());

	    			if (pc != null)
	    			{
	    				Alert.DebugLog("InventoryEvents", "onInventoryOpen", "Config found");
	    				
	    				_grass_to_dirt = pc.getGrassToDirt();
	    				_remove_grass = pc.getRemoveGrass();
	    				_remove_tall_grass = pc.getRemoveTallGrass();
	    				_remove_flowers = pc.getRemoveFlowers();
	    				_remove_leaves = pc.getRemoveLeaves();
	    				_remove_water_flora = pc.getRemoveWaterFlora();
	    				
	    				Alert.Log("", Boolean.toString(_remove_water_flora));

    					ItemStack istack0 = ControlsGUI.GrassToDirt(_grass_to_dirt);
    					e.getInventory().setItem(0, istack0);
    					
    					ItemStack istack1 = ControlsGUI.RemoveGrass(_remove_grass);
    					e.getInventory().setItem(1, istack1);
    					
						ItemStack istack2 = ControlsGUI.RemoveTallGrass(_remove_tall_grass);
    					e.getInventory().setItem(2, istack2);
    					
						ItemStack istack3 = ControlsGUI.RemoveFlowers(_remove_flowers);
    					e.getInventory().setItem(3, istack3);
						
    					ItemStack istack4 = ControlsGUI.RemoveLeaves(_remove_leaves);
    					e.getInventory().setItem(4, istack4);
    					
    					ItemStack istack5 = ControlsGUI.RemoveWaterFlora(_remove_water_flora);
    					e.getInventory().setItem(5, istack5);
    					
    					Alert.Log("", Integer.toString(pc.getRadius()));
    					switch (pc.getRadius())
    					{
    						case 1:
    							e.getInventory().setItem(9, ControlsGUI.RadiusSet(1));
    		        			e.getInventory().setItem(10, ControlsGUI.RadiusNotSet(2));
    		        			e.getInventory().setItem(11, ControlsGUI.RadiusNotSet(3));
    		        			e.getInventory().setItem(12, ControlsGUI.RadiusNotSet(4));
    		        			e.getInventory().setItem(13, ControlsGUI.RadiusNotSet(5));
    		        			e.getInventory().setItem(14, ControlsGUI.RadiusNotSet(10));
    		        			e.getInventory().setItem(15, ControlsGUI.RadiusNotSet(15));
    		        			e.getInventory().setItem(16, ControlsGUI.RadiusNotSet(20));
    		        			e.getInventory().setItem(17, ControlsGUI.RadiusNotSet(25));
    							break;
    						case 2:
    		        			e.getInventory().setItem(9, ControlsGUI.RadiusNotSet(1));
    		        			e.getInventory().setItem(10, ControlsGUI.RadiusSet(2));
    		        			e.getInventory().setItem(11, ControlsGUI.RadiusNotSet(3));
    		        			e.getInventory().setItem(12, ControlsGUI.RadiusNotSet(4));
    		        			e.getInventory().setItem(13, ControlsGUI.RadiusNotSet(5));
    		        			e.getInventory().setItem(14, ControlsGUI.RadiusNotSet(10));
    		        			e.getInventory().setItem(15, ControlsGUI.RadiusNotSet(15));
    		        			e.getInventory().setItem(16, ControlsGUI.RadiusNotSet(20));
    		        			e.getInventory().setItem(17, ControlsGUI.RadiusNotSet(25));
    		        			break;
    		        		case 3:
    		        			e.getInventory().setItem(9, ControlsGUI.RadiusNotSet(1));
    		        			e.getInventory().setItem(10, ControlsGUI.RadiusNotSet(2));
    		        			e.getInventory().setItem(11, ControlsGUI.RadiusSet(3));
    		        			e.getInventory().setItem(12, ControlsGUI.RadiusNotSet(4));
    		        			e.getInventory().setItem(13, ControlsGUI.RadiusNotSet(5));
    		        			e.getInventory().setItem(14, ControlsGUI.RadiusNotSet(10));
    		        			e.getInventory().setItem(15, ControlsGUI.RadiusNotSet(15));
    		        			e.getInventory().setItem(16, ControlsGUI.RadiusNotSet(20));
    		        			e.getInventory().setItem(17, ControlsGUI.RadiusNotSet(25));
    		        			break;
    		        		case 4:
    		        			e.getInventory().setItem(9, ControlsGUI.RadiusNotSet(1));
    		        			e.getInventory().setItem(10, ControlsGUI.RadiusNotSet(2));
    		        			e.getInventory().setItem(11, ControlsGUI.RadiusNotSet(3));
    		        			e.getInventory().setItem(12, ControlsGUI.RadiusSet(4));
    		        			e.getInventory().setItem(13, ControlsGUI.RadiusNotSet(5));
    		        			e.getInventory().setItem(14, ControlsGUI.RadiusNotSet(10));
    		        			e.getInventory().setItem(15, ControlsGUI.RadiusNotSet(15));
    		        			e.getInventory().setItem(16, ControlsGUI.RadiusNotSet(20));
    		        			e.getInventory().setItem(17, ControlsGUI.RadiusNotSet(25));
    		        			break;
    		        		case 5:
    		        			e.getInventory().setItem(9, ControlsGUI.RadiusNotSet(1));
    		        			e.getInventory().setItem(10, ControlsGUI.RadiusNotSet(2));
    		        			e.getInventory().setItem(11, ControlsGUI.RadiusNotSet(3));
    		        			e.getInventory().setItem(12, ControlsGUI.RadiusNotSet(4));
    		        			e.getInventory().setItem(13, ControlsGUI.RadiusSet(5));
    		        			e.getInventory().setItem(14, ControlsGUI.RadiusNotSet(10));
    		        			e.getInventory().setItem(15, ControlsGUI.RadiusNotSet(15));
    		        			e.getInventory().setItem(16, ControlsGUI.RadiusNotSet(20));
    		        			e.getInventory().setItem(17, ControlsGUI.RadiusNotSet(25));
    		        			break;
    		        		case 10:
    		        			e.getInventory().setItem(9, ControlsGUI.RadiusNotSet(1));
    		        			e.getInventory().setItem(10, ControlsGUI.RadiusNotSet(2));
    		        			e.getInventory().setItem(11, ControlsGUI.RadiusNotSet(3));
    		        			e.getInventory().setItem(12, ControlsGUI.RadiusNotSet(4));
    		        			e.getInventory().setItem(13, ControlsGUI.RadiusNotSet(5));
    		        			e.getInventory().setItem(14, ControlsGUI.RadiusSet(10));
    		        			e.getInventory().setItem(15, ControlsGUI.RadiusNotSet(15));
    		        			e.getInventory().setItem(16, ControlsGUI.RadiusNotSet(20));
    		        			e.getInventory().setItem(17, ControlsGUI.RadiusNotSet(25));
    		        			break;
    		        		case 15:
    		        			e.getInventory().setItem(9, ControlsGUI.RadiusNotSet(1));
    		        			e.getInventory().setItem(10, ControlsGUI.RadiusNotSet(2));
    		        			e.getInventory().setItem(11, ControlsGUI.RadiusNotSet(3));
    		        			e.getInventory().setItem(12, ControlsGUI.RadiusNotSet(4));
    		        			e.getInventory().setItem(13, ControlsGUI.RadiusNotSet(5));
    		        			e.getInventory().setItem(14, ControlsGUI.RadiusNotSet(10));
    		        			e.getInventory().setItem(15, ControlsGUI.RadiusSet(15));
    		        			e.getInventory().setItem(16, ControlsGUI.RadiusNotSet(20));
    		        			e.getInventory().setItem(17, ControlsGUI.RadiusNotSet(25));
    		        			break;
    		        		case 20:
    		        			e.getInventory().setItem(9, ControlsGUI.RadiusNotSet(1));
    		        			e.getInventory().setItem(10, ControlsGUI.RadiusNotSet(2));
    		        			e.getInventory().setItem(11, ControlsGUI.RadiusNotSet(3));
    		        			e.getInventory().setItem(12, ControlsGUI.RadiusNotSet(4));
    		        			e.getInventory().setItem(13, ControlsGUI.RadiusNotSet(5));
    		        			e.getInventory().setItem(14, ControlsGUI.RadiusNotSet(10));
    		        			e.getInventory().setItem(15, ControlsGUI.RadiusNotSet(15));
    		        			e.getInventory().setItem(16, ControlsGUI.RadiusSet(20));
    		        			e.getInventory().setItem(17, ControlsGUI.RadiusNotSet(25));
    		        			break;
    		        		case 25:
    		        			e.getInventory().setItem(9, ControlsGUI.RadiusNotSet(1));
    		        			e.getInventory().setItem(10, ControlsGUI.RadiusNotSet(2));
    		        			e.getInventory().setItem(11, ControlsGUI.RadiusNotSet(3));
    		        			e.getInventory().setItem(12, ControlsGUI.RadiusNotSet(4));
    		        			e.getInventory().setItem(13, ControlsGUI.RadiusNotSet(5));
    		        			e.getInventory().setItem(14, ControlsGUI.RadiusNotSet(10));
    		        			e.getInventory().setItem(15, ControlsGUI.RadiusNotSet(15));
    		        			e.getInventory().setItem(16, ControlsGUI.RadiusNotSet(20));
    		        			e.getInventory().setItem(17, ControlsGUI.RadiusSet(25));
    		        			break;   							
    						default:
    							break;
    					}
    					
    					switch (pc.getHeight())
    					{
			        		case 1:
			        			e.getInventory().setItem(18, ControlsGUI.HeightSet(1));
			        			e.getInventory().setItem(19, ControlsGUI.HeightNotSet(2));
			        			e.getInventory().setItem(20, ControlsGUI.HeightNotSet(3));
			        			e.getInventory().setItem(21, ControlsGUI.HeightNotSet(4));
			        			e.getInventory().setItem(22, ControlsGUI.HeightNotSet(5));
			        			e.getInventory().setItem(23, ControlsGUI.HeightNotSet(10));
			        			e.getInventory().setItem(24, ControlsGUI.HeightNotSet(15));
			        			e.getInventory().setItem(25, ControlsGUI.HeightNotSet(20));
			        			e.getInventory().setItem(26, ControlsGUI.HeightNotSet(25));
			        			break;
			        		case 2:
			        			e.getInventory().setItem(18, ControlsGUI.HeightNotSet(1));
			        			e.getInventory().setItem(19, ControlsGUI.HeightSet(2));
			        			e.getInventory().setItem(20, ControlsGUI.HeightNotSet(3));
			        			e.getInventory().setItem(21, ControlsGUI.HeightNotSet(4));
			        			e.getInventory().setItem(22, ControlsGUI.HeightNotSet(5));
			        			e.getInventory().setItem(23, ControlsGUI.HeightNotSet(10));
			        			e.getInventory().setItem(24, ControlsGUI.HeightNotSet(15));
			        			e.getInventory().setItem(25, ControlsGUI.HeightNotSet(20));
			        			e.getInventory().setItem(26, ControlsGUI.HeightNotSet(25));
			        			break;
			        		case 3:
			        			e.getInventory().setItem(18, ControlsGUI.HeightNotSet(1));
			        			e.getInventory().setItem(19, ControlsGUI.HeightNotSet(2));
			        			e.getInventory().setItem(20, ControlsGUI.HeightSet(3));
			        			e.getInventory().setItem(21, ControlsGUI.HeightNotSet(4));
			        			e.getInventory().setItem(22, ControlsGUI.HeightNotSet(5));
			        			e.getInventory().setItem(23, ControlsGUI.HeightNotSet(10));
			        			e.getInventory().setItem(24, ControlsGUI.HeightNotSet(15));
			        			e.getInventory().setItem(25, ControlsGUI.HeightNotSet(20));
			        			e.getInventory().setItem(26, ControlsGUI.HeightNotSet(25));
			        			break;
			        		case 4:
			        			e.getInventory().setItem(18, ControlsGUI.HeightNotSet(1));
			        			e.getInventory().setItem(19, ControlsGUI.HeightNotSet(2));
			        			e.getInventory().setItem(20, ControlsGUI.HeightNotSet(3));
			        			e.getInventory().setItem(21, ControlsGUI.HeightSet(4));
			        			e.getInventory().setItem(22, ControlsGUI.HeightNotSet(5));
			        			e.getInventory().setItem(23, ControlsGUI.HeightNotSet(10));
			        			e.getInventory().setItem(24, ControlsGUI.HeightNotSet(15));
			        			e.getInventory().setItem(25, ControlsGUI.HeightNotSet(20));
			        			e.getInventory().setItem(26, ControlsGUI.HeightNotSet(25));
			        			break;
			        		case 5:
			        			e.getInventory().setItem(18, ControlsGUI.HeightNotSet(1));
			        			e.getInventory().setItem(19, ControlsGUI.HeightNotSet(2));
			        			e.getInventory().setItem(20, ControlsGUI.HeightNotSet(3));
			        			e.getInventory().setItem(21, ControlsGUI.HeightNotSet(4));
			        			e.getInventory().setItem(22, ControlsGUI.HeightSet(5));
			        			e.getInventory().setItem(23, ControlsGUI.HeightNotSet(10));
			        			e.getInventory().setItem(24, ControlsGUI.HeightNotSet(15));
			        			e.getInventory().setItem(25, ControlsGUI.HeightNotSet(20));
			        			e.getInventory().setItem(26, ControlsGUI.HeightNotSet(25));
			        			break;
			        		case 10:
			        			e.getInventory().setItem(18, ControlsGUI.HeightNotSet(1));
			        			e.getInventory().setItem(19, ControlsGUI.HeightNotSet(2));
			        			e.getInventory().setItem(20, ControlsGUI.HeightNotSet(3));
			        			e.getInventory().setItem(21, ControlsGUI.HeightNotSet(4));
			        			e.getInventory().setItem(22, ControlsGUI.HeightNotSet(5));
			        			e.getInventory().setItem(23, ControlsGUI.HeightSet(19));
			        			e.getInventory().setItem(24, ControlsGUI.HeightNotSet(15));
			        			e.getInventory().setItem(25, ControlsGUI.HeightNotSet(20));
			        			e.getInventory().setItem(26, ControlsGUI.HeightNotSet(25));
			        			break;
			        		case 15:
			        			e.getInventory().setItem(18, ControlsGUI.HeightNotSet(1));
			        			e.getInventory().setItem(19, ControlsGUI.HeightNotSet(2));
			        			e.getInventory().setItem(20, ControlsGUI.HeightNotSet(3));
			        			e.getInventory().setItem(21, ControlsGUI.HeightNotSet(4));
			        			e.getInventory().setItem(22, ControlsGUI.HeightNotSet(5));
			        			e.getInventory().setItem(23, ControlsGUI.HeightNotSet(10));
			        			e.getInventory().setItem(24, ControlsGUI.HeightSet(24));
			        			e.getInventory().setItem(25, ControlsGUI.HeightNotSet(20));
			        			e.getInventory().setItem(26, ControlsGUI.HeightNotSet(25));
			        			break;
			        		case 20:
			        			e.getInventory().setItem(18, ControlsGUI.HeightNotSet(1));
			        			e.getInventory().setItem(19, ControlsGUI.HeightNotSet(2));
			        			e.getInventory().setItem(20, ControlsGUI.HeightNotSet(3));
			        			e.getInventory().setItem(21, ControlsGUI.HeightNotSet(4));
			        			e.getInventory().setItem(22, ControlsGUI.HeightNotSet(5));
			        			e.getInventory().setItem(23, ControlsGUI.HeightNotSet(10));
			        			e.getInventory().setItem(24, ControlsGUI.HeightNotSet(15));
			        			e.getInventory().setItem(25, ControlsGUI.HeightSet(20));
			        			e.getInventory().setItem(26, ControlsGUI.HeightNotSet(25));
			        			break;
			        		case 25:
			        			e.getInventory().setItem(18, ControlsGUI.HeightNotSet(1));
			        			e.getInventory().setItem(19, ControlsGUI.HeightNotSet(2));
			        			e.getInventory().setItem(20, ControlsGUI.HeightNotSet(3));
			        			e.getInventory().setItem(21, ControlsGUI.HeightNotSet(4));
			        			e.getInventory().setItem(22, ControlsGUI.HeightNotSet(5));
			        			e.getInventory().setItem(23, ControlsGUI.HeightNotSet(10));
			        			e.getInventory().setItem(24, ControlsGUI.HeightNotSet(15));
			        			e.getInventory().setItem(25, ControlsGUI.HeightNotSet(20));
			        			e.getInventory().setItem(26, ControlsGUI.HeightSet(25)); 
			        			break;
		        			default:
		        				break;
    					}
	    			}
	    		} else {
	    			Alert.DebugLog("InventoryEvents", "onInventoryClick", "No such hashmap - using defaults");
	    		}
	    		
	    		
	    	}
		}
	}
	@EventHandler
	public void onInventoryClose(InventoryCloseEvent e)
	{
		if (ChatColor.stripColor(e.getInventory().getName()).equals(ChatColor.stripColor("Clear Flora"))) // check if the inventory being closed is our Jukebox Storage
		{
			Player player = null; // create the Player object
	    	if (e.getPlayer() instanceof Player) // check to make sure the HumanEntity that clicked it is a player (should always be so)
	    	{
	    		player = (Player) e.getPlayer();
	    	}
			HashMap<UUID, ItemStack[]> hmInv = Main.PlayerInventory;
			if (hmInv != null)
			{
				Alert.Log("InventoryTest", "Getting player inventory back from hashmap");
				ItemStack[] inv = hmInv.get(e.getPlayer().getUniqueId());
				if (inv != null)
				{
					int j = 0;
					for (ItemStack i : inv)
					{
						if (i != null)
						{
							//Alert.Log("GUI Restore: ", "Setting " + i.toString() + " to position " + Integer.toString(j));
							e.getPlayer().getInventory().setItem(j, i);
						} else {
							//Alert.Log("GUI Restore: ", "ItemStack is null - Setting AIR to position " + Integer.toString(j));
							e.getPlayer().getInventory().setItem(j, new ItemStack(Material.AIR, 1));
						}
						j++;
					}
					if (player != null)
					{
						player.updateInventory();
					}
				    Main.PlayerInventory.remove(e.getPlayer().getUniqueId());
				} else {
					Alert.Log("InventoryTest", "No such entry in hashmap");
				}
			}
		}
	}
}
