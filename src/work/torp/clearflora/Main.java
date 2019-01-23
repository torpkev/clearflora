package work.torp.clearflora;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;

import org.bukkit.entity.Player;
import org.bukkit.inventory.InventoryHolder;

import org.bukkit.inventory.ItemStack;

import org.bukkit.plugin.java.JavaPlugin;

import work.torp.clearflora.Main;
import work.torp.clearflora.alerts.Alert;
import work.torp.clearflora.classes.PlayerConfig;
import work.torp.clearflora.commands.ClearFlora;
import work.torp.clearflora.events.InventoryEvents;

public class Main extends JavaPlugin {
	
	public interface IGUI extends InventoryHolder{
	    public void onGUIClick(Player whoClicked, int slot, ItemStack clickedItem);
	}
	
	// Hashmaps
	public static HashMap<UUID, ItemStack[]> PlayerInventory = new HashMap<UUID, ItemStack[]>();
	public static HashMap<UUID, PlayerConfig> PlayerConfiguration = new HashMap<UUID, PlayerConfig>();
	
	// Main
	private static Main instance;
    public static Main getInstance() {
		return instance;
	}
    // DebugFile
	private boolean debugfile = false;
    public boolean getDebugFile() {
        return this.debugfile;
    }
    public void setDebugFile(boolean debugfile) {
    	this.debugfile = debugfile;
    }
    
    public void loadEventListeners() {
		Alert.VerboseLog("Main", "Starting Event Listeners");	
		try {	
			Bukkit.getPluginManager().registerEvents(new InventoryEvents(), this);
		} catch (Exception ex) {
			Alert.Log("Load Event Listeners", "Unexpected Error - " + ex.getMessage());  
		}
    }

    // Config
    int radius = 10;
    public int getRadius() {
    	return this.radius;
    }
    int height = 3;
    public int getHeight() {
    	return this.height;
    }
    boolean grass_to_dirt = false;
    public boolean getGrassToDirt() {
    	return this.grass_to_dirt;
    }
    boolean remove_grass = false;
    public boolean getRemoveGrass() {
    	return this.remove_grass;
    }
    boolean remove_tall_grass = false;
    public boolean getRemoveTallGrass() {
    	return this.remove_tall_grass;
    }
    boolean remove_flowers = false;
    public boolean getRemoveFlowers() {
    	return this.remove_flowers;
    }
    boolean remove_leaves = false;
    public boolean getRemoveLeaves() {
    	return this.remove_leaves;
    }
    boolean remove_water_flora = false;
    public boolean getRemoveWaterFlora() {
    	return this.remove_water_flora;
    }
    boolean view_stats = false;
    public boolean getViewStats() {
    	return this.view_stats;
    }
    public void loadConfig()
    {
    	String sRadius = Main.getInstance().getConfig().getString("radius");
    	if (sRadius != null) {
    		Alert.VerboseLog("Get Configuration", "radius found: " + sRadius);
    		int iSRSecs = radius;
    		try{
    			iSRSecs = Integer.parseInt(sRadius);
    			radius = iSRSecs;
    		} 
    		catch (NumberFormatException ex) {
    			Alert.Log("Get Configuration", "radius invalid, must be a number. Using default");	
    		}
    	} else {
    		Alert.Log("Get Configuration", "radius not found. Using default");
    	}
    	String sHeight = Main.getInstance().getConfig().getString("height"); 
    	if (sHeight != null) {
    		Alert.VerboseLog("Get Configuration", "height found: " + sHeight);
    		int iHeight = height;
    		try{
    			iHeight = Integer.parseInt(sHeight);
    			height = iHeight;
    		} 
    		catch (NumberFormatException ex) {
    			Alert.Log("Get Configuration", "height invalid, must be a number. Using default");	
    		}
    	} else {
    		Alert.Log("Get Configuration", "radius not found. Using default");
    	}


    	try
    	{
    		grass_to_dirt = Main.getInstance().getConfig().getBoolean("grass_to_dirt");
    	}
    	catch (Exception ex)
    	{
    		grass_to_dirt = true; // default
    		Alert.Log("Main.loadConfig", "grass_to_dirt value is invalid, using default of true");
    		Alert.DebugLog("Main", "loadConfig", "grass_to_dirt value is invalid, using default of true. Error: " + ex.getMessage());
    	}
    	try
    	{
    		remove_grass = Main.getInstance().getConfig().getBoolean("remove_grass");
    	}
    	catch (Exception ex)
    	{
    		remove_grass = true; // default
    		Alert.Log("Main.loadConfig", "remove_grass value is invalid, using default of true");
    		Alert.DebugLog("Main", "loadConfig", "remove_grass value is invalid, using default of true. Error: " + ex.getMessage());
    	}
    	try
    	{
    		remove_tall_grass = Main.getInstance().getConfig().getBoolean("remove_tall_grass");
    	}
    	catch (Exception ex)
    	{
    		remove_tall_grass = true; // default
    		Alert.Log("Main.loadConfig", "remove_tall_grass value is invalid, using default of true");
    		Alert.DebugLog("Main", "loadConfig", "remove_tall_grass value is invalid, using default of true. Error: " + ex.getMessage());
    	}
    	try
    	{
    		remove_flowers = Main.getInstance().getConfig().getBoolean("remove_flowers");
    	}
    	catch (Exception ex)
    	{
    		remove_flowers = true; // default
    		Alert.Log("Main.loadConfig", "remove_flowers value is invalid, using default of true");
    		Alert.DebugLog("Main", "loadConfig", "remove_flowers value is invalid, using default of true. Error: " + ex.getMessage());
    	}
    	try
    	{
    		remove_leaves = Main.getInstance().getConfig().getBoolean("remove_leaves");
    	}
    	catch (Exception ex)
    	{
    		remove_leaves = true; // default
    		Alert.Log("Main.loadConfig", "remove_leaves value is invalid, using default of true");
    		Alert.DebugLog("Main", "loadConfig", "remove_leaves value is invalid, using default of true. Error: " + ex.getMessage());
    	}
    	try
    	{
    		remove_water_flora = Main.getInstance().getConfig().getBoolean("remove_water_flora");
    	}
    	catch (Exception ex)
    	{
    		remove_water_flora = true; // default
    		Alert.Log("Main.loadConfig", "remove_water_flora value is invalid, using default of true");
    		Alert.DebugLog("Main", "loadConfig", "remove_water_flora value is invalid, using default of true. Error: " + ex.getMessage());
    	}
    	try
    	{
    		view_stats = Main.getInstance().getConfig().getBoolean("view_stats");
    	}
    	catch (Exception ex)
    	{
    		view_stats = false; // default
    		Alert.Log("Main.loadConfig", "view_stats value is invalid, using default of false");
    		Alert.DebugLog("Main", "loadConfig", "view_stats value is invalid, using default of true. Error: " + ex.getMessage());
    	}
    }
    @Override
	public void onEnable() 
    {	
    	try {
			instance = this;
			saveDefaultConfig();
			loadConfig();
			loadEventListeners();
			getCommand("clearflora").setExecutor(new ClearFlora()); // Register my command
    	}
    	catch (Exception ex)
    	{
    		Alert.DebugLog("Main", "onEnable", ex.getMessage());
    	}
    }
}
