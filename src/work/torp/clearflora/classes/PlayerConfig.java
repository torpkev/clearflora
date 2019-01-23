package work.torp.clearflora.classes;

import java.util.UUID;

import work.torp.clearflora.Main;

public class PlayerConfig {
	private UUID uuid;
	private boolean grass_to_dirt;
	private boolean remove_grass;
	private boolean remove_tall_grass;
	private boolean remove_flowers;
	private boolean remove_leaves;
	private boolean remove_water_flora;
	private int radius;
	private int height;
	
	public UUID getUUID()
	{
		return this.uuid;
	}
	public void setUUID(UUID uuid)
	{
		this.uuid = uuid;
	}
	public boolean getGrassToDirt()
	{
		return this.grass_to_dirt;
	}
	public void setGrassToDirt(boolean grass_to_dirt)
	{
		this.grass_to_dirt = grass_to_dirt;
	}
	public boolean getRemoveGrass()
	{
		return this.remove_grass;
	}
	public void setRemoveGrass(boolean remove_grass)
	{
		this.remove_grass = remove_grass;
	}
	public boolean getRemoveTallGrass()
	{
		return this.remove_tall_grass;
	}
	public void setRemoveTallGrass(boolean remove_tall_grass)
	{
		this.remove_tall_grass = remove_tall_grass;
	}
	public boolean getRemoveFlowers()
	{
		return this.remove_flowers;
	}
	public void setRemoveFlowers(boolean remove_flowers)
	{
		this.remove_flowers = remove_flowers;
	}
	public boolean getRemoveLeaves()
	{
		return this.remove_leaves;
	}
	public void setRemoveLeaves(boolean remove_leaves)
	{
		this.remove_leaves = remove_leaves;
	}
	public boolean getRemoveWaterFlora()
	{
		return this.remove_water_flora;
	}
	public void setRemoveWaterFlora(boolean remove_water_flora)
	{
		this.remove_water_flora = remove_water_flora;
	}
	public int getRadius()
	{
		return this.radius;
	}
	public void setRadius(int radius)
	{
		this.radius = radius;
	}
	public int getHeight()
	{
		return this.height;
	}
	public void setHeight(int height)
	{
		this.height = height;
	}
	public void init(UUID uuid)
	{
		this.grass_to_dirt = Main.getInstance().getGrassToDirt();
		this.remove_grass = Main.getInstance().getRemoveGrass();
		this.remove_tall_grass = Main.getInstance().getRemoveTallGrass();
		this.remove_flowers = Main.getInstance().getRemoveFlowers();
		this.remove_leaves = Main.getInstance().getRemoveLeaves();
		this.remove_water_flora = Main.getInstance().getRemoveWaterFlora();
		int r = Main.getInstance().getRadius();
		if (r == 1 || r == 2 || r == 3 || r == 4 || r == 5 || r == 10 || r == 15 || r == 20 || r == 25)
		{
			this.radius = r;
		} else {
			this.radius = 0;
		}
		int h = Main.getInstance().getHeight();
		if (h == 1 || h == 2 || h == 3 || h == 4 || h == 5 || h == 10 || h == 15 || h == 20 || h == 25)
		{
			this.height = r;
		} else {
			this.height = 0;
		}
	}
}
