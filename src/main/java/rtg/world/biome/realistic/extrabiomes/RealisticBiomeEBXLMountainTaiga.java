package rtg.world.biome.realistic.extrabiomes;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import rtg.config.ConfigEBXL;
import rtg.world.biome.BiomeBase;
import rtg.world.gen.surface.extrabiomes.SurfaceEBXLAlpine;
import rtg.world.gen.terrain.extrabiomes.TerrainEBXLAlpine;
import extrabiomes.api.BiomeManager;

public class RealisticBiomeEBXLMountainTaiga extends RealisticBiomeEBXLBase
{	
	public static BiomeGenBase ebxlBiome = BiomeManager.mountaintaiga.get();
	
	public static Block topBlock = ebxlBiome.topBlock;
	public static Block fillerBlock = ebxlBiome.fillerBlock;
	
	public RealisticBiomeEBXLMountainTaiga()
	{
		super(
			ebxlBiome, BiomeBase.climatizedBiome(BiomeGenBase.river, Climate.ICE),
			new TerrainEBXLAlpine(),
			new SurfaceEBXLAlpine(topBlock, fillerBlock, false, null, 0.45f)
		);
		
		this.setRealisticBiomeName("EBXL Mountain Taiga");
		this.biomeCategory = BiomeCategory.SNOW;
		this.biomeWeight = ConfigEBXL.weightEBXL_mountaintaiga;
	}
}
