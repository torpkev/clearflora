package work.torp.clearfauna;

import org.bukkit.plugin.java.JavaPlugin;

import work.torp.clearfauna.Main;
import work.torp.clearfauna.alerts.Alert;
import work.torp.clearfauna.commands.ClearFauna;
public class Main extends JavaPlugin {
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
    boolean remove_water_fauna = false;
    public boolean getRemoveWaterFauna() {
    	return this.remove_water_fauna;
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
		String s_grass_to_dirt = Main.getInstance().getConfig().getString("grass_to_dirt");
		grass_to_dirt = false; // default to false
    	if (s_grass_to_dirt != null) {
    		if (s_grass_to_dirt.equalsIgnoreCase("true")) {
    			grass_to_dirt = true;
			} else if (s_grass_to_dirt.equalsIgnoreCase("true")) {
				grass_to_dirt = false;
			} else {
				Alert.Log("Main.loadConfig", "grass_to_dirt value is invalid, using default of false");
			}
    	} else {
    		Alert.Log("Main.loadConfig", "grass_to_dirt value not found, using default of false");
    	}
		String s_remove_grass = Main.getInstance().getConfig().getString("remove_grass");
		remove_grass = true; // default to true
    	if (s_remove_grass != null) {
    		if (s_remove_grass.equalsIgnoreCase("true")) {
    			remove_grass = true;
			} else if (s_remove_grass.equalsIgnoreCase("true")) {
				remove_grass = false;
			} else {
				Alert.Log("Main.loadConfig", "remove_grass value is invalid, using default of true");
			}
    	} else {
    		Alert.Log("Main.loadConfig", "remove_grass value not found, using default of true");
    	}
		String s_remove_tall_grass = Main.getInstance().getConfig().getString("remove_tall_grass");
		remove_tall_grass = true; // default to true
    	if (s_remove_tall_grass != null) {
    		if (s_remove_tall_grass.equalsIgnoreCase("true")) {
    			remove_tall_grass = true;
			} else if (s_remove_tall_grass.equalsIgnoreCase("true")) {
				remove_tall_grass = false;
			} else {
				Alert.Log("Main.loadConfig", "remove_tall_grass value is invalid, using default of true");
			}
    	} else {
    		Alert.Log("Main.loadConfig", "remove_tall_grass value not found, using default of true");
    	}
		String s_remove_flowers = Main.getInstance().getConfig().getString("remove_flowers");
		remove_flowers = true; // default to true
    	if (s_remove_flowers != null) {
    		if (s_remove_flowers.equalsIgnoreCase("true")) {
    			remove_flowers = true;
			} else if (s_remove_flowers.equalsIgnoreCase("true")) {
				remove_flowers = false;
			} else {
				Alert.Log("Main.loadConfig", "remove_flowers value is invalid, using default of true");
			}
    	} else {
    		Alert.Log("Main.loadConfig", "remove_flowers value not found, using default of true");
    	}
		String s_remove_leaves = Main.getInstance().getConfig().getString("remove_leaves");
		remove_leaves = true; // default to true
    	if (s_remove_leaves != null) {
    		if (s_remove_leaves.equalsIgnoreCase("true")) {
    			remove_leaves = true;
			} else if (s_remove_leaves.equalsIgnoreCase("true")) {
				remove_leaves = false;
			} else {
				Alert.Log("Main.loadConfig", "remove_leaves value is invalid, using default of true");
			}
    	} else {
    		Alert.Log("Main.loadConfig", "remove_leaves value not found, using default of true");
    	}
		String s_water_fauna = Main.getInstance().getConfig().getString("remove_water_fauna");
		remove_water_fauna = true; // default to true
    	if (s_water_fauna != null) {
    		if (s_water_fauna.equalsIgnoreCase("true")) {
    			remove_water_fauna = true;
			} else if (s_water_fauna.equalsIgnoreCase("true")) {
				remove_water_fauna = false;
			} else {
				Alert.Log("Main.loadConfig", "remove_water_fauna value is invalid, using default of true");
			}
    	} else {
    		Alert.Log("Main.loadConfig", "remove_water_fauna value not found, using default of true");
    	}
    }
    @Override
	public void onEnable() 
    {	
    	try {
			instance = this;
			saveDefaultConfig();
			loadConfig();
			getCommand("clearfauna").setExecutor(new ClearFauna()); // Register my command
    	}
    	catch (Exception ex)
    	{
    		Alert.DebugLog("Main", "onEnable", ex.getMessage());
    	}
    }
}
