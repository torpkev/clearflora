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
    }
    @Override
	public void onEnable() 
    {	
    	try {
			instance = this;
			saveDefaultConfig();
			getCommand("clearfauna").setExecutor(new ClearFauna()); // Register my command
    	}
    	catch (Exception ex)
    	{
    		Alert.DebugLog("Main", "onEnable", ex.getMessage());
    	}
    }
}
