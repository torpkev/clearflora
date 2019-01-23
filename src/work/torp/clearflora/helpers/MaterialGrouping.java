package work.torp.clearflora.helpers;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;

public class MaterialGrouping {
	public static List<Material> Flowers()
	{
		List<Material> lstRet = new ArrayList<Material>();
		lstRet.add(Material.ALLIUM);
		lstRet.add(Material.BLUE_ORCHID);
		lstRet.add(Material.DANDELION);
		lstRet.add(Material.FERN);
		lstRet.add(Material.LARGE_FERN);
		lstRet.add(Material.LILAC);
		lstRet.add(Material.OXEYE_DAISY);
		lstRet.add(Material.ORANGE_TULIP);
		lstRet.add(Material.PEONY);
		lstRet.add(Material.PINK_TULIP);
		lstRet.add(Material.POPPY);
		lstRet.add(Material.RED_TULIP);
		lstRet.add(Material.ROSE_BUSH);
		lstRet.add(Material.SUNFLOWER);
		lstRet.add(Material.VINE);
		lstRet.add(Material.WHITE_TULIP);
		return lstRet;	
	}
	public static List<Material> Leaves()
	{
		List<Material> lstRet = new ArrayList<Material>();
		lstRet.add(Material.ACACIA_LEAVES);
		lstRet.add(Material.BIRCH_LEAVES);
		lstRet.add(Material.DARK_OAK_LEAVES);
		lstRet.add(Material.JUNGLE_LEAVES);
		lstRet.add(Material.OAK_LEAVES);
		lstRet.add(Material.SPRUCE_LEAVES);
		return lstRet;	
	}
	public static List<Material> WaterFlora()
	{
		List<Material> lstRet = new ArrayList<Material>();
		lstRet.add(Material.LILY_PAD);
		lstRet.add(Material.KELP_PLANT);
		lstRet.add(Material.SEAGRASS);
		lstRet.add(Material.TALL_SEAGRASS);
		lstRet.add(Material.SEA_LANTERN);
		return lstRet;	
	}
}
