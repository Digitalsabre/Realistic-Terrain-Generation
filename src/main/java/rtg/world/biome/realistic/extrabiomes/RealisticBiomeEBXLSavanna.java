package rtg.world.biome.realistic.extrabiomes;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import rtg.config.ConfigEBXL;
import rtg.world.biome.BiomeBase;
import rtg.world.gen.surface.extrabiomes.SurfaceEBXLAlpine;
import rtg.world.gen.terrain.extrabiomes.TerrainEBXLAlpine;
import extrabiomes.api.BiomeManager;

public class RealisticBiomeEBXLSavanna extends RealisticBiomeEBXLBase
{	
	public static BiomeGenBase ebxlBiome = BiomeManager.savanna.get();
	
	public static Block topBlock = ebxlBiome.topBlock;
	public static Block fillerBlock = ebxlBiome.fillerBlock;
	
	public RealisticBiomeEBXLSavanna()
	{
		super(
			ebxlBiome, BiomeBase.climatizedBiome(BiomeGenBase.river, Climate.OASIS),
			new TerrainEBXLAlpine(),
			new SurfaceEBXLAlpine(topBlock, fillerBlock, false, null, 0.45f)
		);
		
		this.setRealisticBiomeName("EBXL Savanna");
		this.biomeCategory = BiomeCategory.HOT;
		this.biomeWeight = ConfigEBXL.weightEBXL_savanna;
	}
}
