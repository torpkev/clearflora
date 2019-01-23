package work.torp.clearflora.helpers;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import work.torp.clearflora.Main;
import work.torp.clearflora.alerts.Alert;

public class PlayerFunctions {
	public static void returnItemsFromGUI(Player player)
	{
		HashMap<UUID, ItemStack[]> hmInv = Main.PlayerInventory;
		if (hmInv != null)
		{
			Alert.DebugLog("PlayerFunctions", "returnItemsFromGUI", "Getting player inventory back from hashmap");
			ItemStack[] inv = hmInv.get(player.getUniqueId());
			if (inv != null)
			{
				int j = 0;
				for (ItemStack i : inv)
				{
					if (i != null)
					{
						//Alert.Log("GUI Restore: ", "Setting " + i.toString() + " to position " + Integer.toString(j));
						player.getInventory().setItem(j, i);
					} else {
						//Alert.Log("GUI Restore: ", "ItemStack is null - Setting AIR to position " + Integer.toString(j));
						player.getInventory().setItem(j, new ItemStack(Material.AIR, 1));
					}
					j++;
				}
				player.updateInventory();
			    Main.PlayerInventory.remove(player.getUniqueId());
			} else {
				Alert.DebugLog("PlayerFunctions", "returnItemsFromGUI", "No such entry in hashmap");
			}
		}
	}
}
