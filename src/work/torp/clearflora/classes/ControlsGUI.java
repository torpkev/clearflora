package work.torp.clearflora.classes;


import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;
import work.torp.clearflora.Main;
import work.torp.clearflora.Main.IGUI;
import work.torp.clearflora.alerts.Alert;

public class ControlsGUI implements IGUI{

	
	@Override
    public Inventory getInventory() {
   
        Inventory GUI = Bukkit.createInventory(this, 36, "Clear Flora");
   
        ItemStack isNA = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
		ItemMeta imNA = isNA.getItemMeta();
		imNA.setDisplayName(".");
		imNA.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		isNA.setItemMeta(imNA);

        ItemStack isCancel = new ItemStack(Material.RED_CONCRETE, 1);
		ItemMeta imCancel = isCancel.getItemMeta();
		imCancel.setDisplayName("Cancel");
		imCancel.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		isCancel.setItemMeta(imCancel);
		
        ItemStack isOK = new ItemStack(Material.GREEN_CONCRETE, 1);
		ItemMeta imOK = isOK.getItemMeta();
		imOK.setDisplayName("Clear Flora");
		imOK.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		isOK.setItemMeta(imOK);

		boolean _grass_to_dirt = Main.getInstance().getGrassToDirt();
		boolean _remove_grass = Main.getInstance().getRemoveGrass();
		boolean _remove_tall_grass = Main.getInstance().getRemoveTallGrass();
		boolean _remove_flowers = Main.getInstance().getRemoveFlowers();
		boolean _remove_leaves = Main.getInstance().getRemoveLeaves();
		boolean _remove_water_flora = Main.getInstance().getRemoveWaterFlora();
		int radius = Main.getInstance().getRadius();
		int height = Main.getInstance().getHeight();

		Alert.DebugLog("ControlsGUI", "getInventory", " Grass To Dirt = " + Boolean.toString(_grass_to_dirt) + " Remove Grass = " + Boolean.toString(_remove_grass) + " Remove Tall Grass = " + Boolean.toString(_remove_tall_grass) + " Remove Flowers = " + Boolean.toString(_remove_flowers) + " Remove Leaves = " + Boolean.toString(_remove_leaves) + " Remove Water Flora = " + Boolean.toString(_remove_water_flora));
		
		
        GUI.setItem(0, ControlsGUI.GrassToDirt(_grass_to_dirt));
        GUI.setItem(1, ControlsGUI.RemoveGrass(_remove_grass));
        GUI.setItem(2, ControlsGUI.RemoveTallGrass(_remove_tall_grass));
        GUI.setItem(3, ControlsGUI.RemoveFlowers(_remove_flowers));
        GUI.setItem(4, ControlsGUI.RemoveLeaves(_remove_leaves));
        GUI.setItem(5, ControlsGUI.RemoveWaterFlora(_remove_water_flora));
        GUI.setItem(6, isNA);
        GUI.setItem(7, isNA);
        GUI.setItem(8, isNA);

	
		
		
		if (radius == 1) {
			GUI.setItem(9, ControlsGUI.RadiusSet(1));
		} else {
			GUI.setItem(9, ControlsGUI.RadiusNotSet(1));
		}
		if (radius == 2) {
			GUI.setItem(10, ControlsGUI.RadiusSet(2));
		} else {
			GUI.setItem(10, ControlsGUI.RadiusNotSet(2));
		}
		if (radius == 3) {
			GUI.setItem(11, ControlsGUI.RadiusSet(3));
		} else {
			GUI.setItem(11, ControlsGUI.RadiusNotSet(3));
		}
		if (radius == 4) {
			GUI.setItem(12, ControlsGUI.RadiusSet(4));
		} else {
			GUI.setItem(12, ControlsGUI.RadiusNotSet(4));
		}
		if (radius == 5) {
			GUI.setItem(13, ControlsGUI.RadiusSet(5));
		} else {
			GUI.setItem(13, ControlsGUI.RadiusNotSet(5));
		}
		if (radius == 10) {
			GUI.setItem(14, ControlsGUI.RadiusSet(10));
		} else {
			GUI.setItem(14, ControlsGUI.RadiusNotSet(10));
		}
		if (radius == 15) {
			GUI.setItem(15, ControlsGUI.RadiusSet(15));
		} else {
			GUI.setItem(15, ControlsGUI.RadiusNotSet(15));
		}
		if (radius == 20) {
			GUI.setItem(16, ControlsGUI.RadiusSet(20));
		} else {
			GUI.setItem(16, ControlsGUI.RadiusNotSet(20));
		}
		if (radius == 25) {
			GUI.setItem(17, ControlsGUI.RadiusSet(25));
		} else {
			GUI.setItem(17, ControlsGUI.RadiusNotSet(25));
		}

		
		if (height == 1) {
			GUI.setItem(18, ControlsGUI.HeightSet(1));
		} else {
			GUI.setItem(18, ControlsGUI.HeightNotSet(1));
		}
		if (height == 2) {
			GUI.setItem(19, ControlsGUI.HeightSet(2));
		} else {
			GUI.setItem(19, ControlsGUI.HeightNotSet(2));
		}
		if (height == 3) {
			GUI.setItem(20, ControlsGUI.HeightSet(3));
		} else {
			GUI.setItem(20, ControlsGUI.HeightNotSet(3));
		}
		if (height == 4) {
			GUI.setItem(21, ControlsGUI.HeightSet(4));
		} else {
			GUI.setItem(21, ControlsGUI.HeightNotSet(4));
		}
		if (height == 5) {
			GUI.setItem(22, ControlsGUI.HeightSet(5));
		} else {
			GUI.setItem(22, ControlsGUI.HeightNotSet(5));
		}
		if (height == 10) {
			GUI.setItem(23, ControlsGUI.HeightSet(10));
		} else {
			GUI.setItem(23, ControlsGUI.HeightNotSet(10));
		}
		if (height == 15) {
			GUI.setItem(24, ControlsGUI.HeightSet(15));
		} else {
			GUI.setItem(24, ControlsGUI.HeightNotSet(15));
		}
		if (height == 20) {
			GUI.setItem(25, ControlsGUI.HeightSet(20));
		} else {
			GUI.setItem(25, ControlsGUI.HeightNotSet(20));
		}
		if (height == 25) {
			GUI.setItem(26, ControlsGUI.HeightSet(25));
		} else {
			GUI.setItem(26, ControlsGUI.HeightNotSet(25));
		}
        
        GUI.setItem(27, isNA);
        GUI.setItem(28, isNA);
        GUI.setItem(29, isNA);
        GUI.setItem(30, isNA);
        GUI.setItem(31, isNA);
        GUI.setItem(32, isNA);
        GUI.setItem(33, isNA);
        GUI.setItem(34, isCancel);
        GUI.setItem(35, isOK);


        return GUI;
    }

	@Override
    public void onGUIClick(Player whoClicked, int slot, ItemStack clickedItem) {
	
    }
	public static ItemStack GrassToDirt(boolean value)
	{
        ItemStack istack = new ItemStack(Material.GRASS_BLOCK, 1);
		ItemMeta imeta = istack.getItemMeta();
		imeta.setDisplayName("Grass to Dirt");
		imeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		List<String> lore = new ArrayList<String>();
		if (value)
		{
			lore.add(ChatColor.GREEN + "Grass blocks will be converted to plain dirt");
		} else {
			lore.add(ChatColor.RED + "Grass blocks will not be converted to plain dirt");
		}
		imeta.setLore(lore);
		istack.setItemMeta(imeta);
		return istack;
	}
	public static ItemStack RemoveGrass(boolean value)
	{
        ItemStack istack = new ItemStack(Material.GRASS, 1);
		ItemMeta imeta = istack.getItemMeta();
		imeta.setDisplayName("Remove Grass");
		imeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		List<String> lore = new ArrayList<String>();
		if (value)
		{
			lore.add(ChatColor.GREEN + "Grass will be removed");
		} else {
			lore.add(ChatColor.RED + "Grass will NOT be removed");
		}
		imeta.setLore(lore);
		istack.setItemMeta(imeta);
		return istack;
	}
	public static ItemStack RemoveTallGrass(boolean value)
	{
        ItemStack istack = new ItemStack(Material.TALL_GRASS, 1);
		ItemMeta imeta = istack.getItemMeta();
		imeta.setDisplayName("Remove Tall Grass");
		imeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		List<String> lore = new ArrayList<String>();
		if (value)
		{
			lore.add(ChatColor.GREEN + "Tall Grass will be removed");
		} else {
			lore.add(ChatColor.RED + "Tall Grass will NOT be removed");
		}
		imeta.setLore(lore);
		istack.setItemMeta(imeta);
		return istack;
	}
	public static ItemStack RemoveFlowers(boolean value)
	{
        ItemStack istack = new ItemStack(Material.POPPY, 1);
		ItemMeta imeta = istack.getItemMeta();
		imeta.setDisplayName("Remove Grass");
		imeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		List<String> lore = new ArrayList<String>();
		if (value)
		{
			lore.add(ChatColor.GREEN + "Flowers will be removed");
		} else {
			lore.add(ChatColor.RED + "Flowers will NOT be removed");
		}
		imeta.setLore(lore);
		istack.setItemMeta(imeta);
		return istack;
	}
	public static ItemStack RemoveLeaves(boolean value)
	{
        ItemStack istack = new ItemStack(Material.OAK_LEAVES, 1);
		ItemMeta imeta = istack.getItemMeta();
		imeta.setDisplayName("Remove Leaves");
		imeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		List<String> lore = new ArrayList<String>();
		if (value)
		{
			lore.add(ChatColor.GREEN + "Leaves will be removed");
		} else {
			lore.add(ChatColor.RED + "Leaves will NOT be removed");
		}
		imeta.setLore(lore);
		istack.setItemMeta(imeta);
		return istack;
	}
	public static ItemStack RemoveWaterFlora(boolean value)
	{
        ItemStack istack = new ItemStack(Material.SEAGRASS, 1);
		ItemMeta imeta = istack.getItemMeta();
		imeta.setDisplayName("Remove Water Flora");
		imeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		List<String> lore = new ArrayList<String>();
		if (value)
		{
			lore.add(ChatColor.GREEN + "Water flora will be removed");
		} else {
			lore.add(ChatColor.RED + "Water flora will NOT be removed");
		}
		imeta.setLore(lore);
		istack.setItemMeta(imeta);
		return istack;
	}
	public static ItemStack RadiusNotSet(int value)
	{
        ItemStack istack = new ItemStack(Material.RED_STAINED_GLASS_PANE, 1);
		ItemMeta imeta = istack.getItemMeta();
		imeta.setDisplayName("Radius - " + Integer.toString(value) + " blocks");
		imeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		List<String> lore = new ArrayList<String>();
		imeta.setLore(lore);
		istack.setItemMeta(imeta);
		return istack;
	}
	public static ItemStack RadiusSet(int value)
	{
        ItemStack istack = new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1);
		ItemMeta imeta = istack.getItemMeta();
		imeta.setDisplayName("Radius - " + Integer.toString(value) + " blocks");
		imeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Radius Set: " + Integer.toString(value));
		imeta.setLore(lore);
		istack.setItemMeta(imeta);
		return istack;
	}
	public static ItemStack HeightNotSet(int value)
	{
        ItemStack istack = new ItemStack(Material.RED_STAINED_GLASS_PANE, 1);
		ItemMeta imeta = istack.getItemMeta();
		imeta.setDisplayName("Height - " + Integer.toString(value) + " blocks");
		imeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		List<String> lore = new ArrayList<String>();
		imeta.setLore(lore);
		istack.setItemMeta(imeta);
		return istack;
	}
	public static ItemStack HeightSet(int value)
	{
        ItemStack istack = new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1);
		ItemMeta imeta = istack.getItemMeta();
		imeta.setDisplayName("Height - " + Integer.toString(value) + " blocks");
		imeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Height Set: " + Integer.toString(value));
		imeta.setLore(lore);
		istack.setItemMeta(imeta);
		return istack;
	}
}