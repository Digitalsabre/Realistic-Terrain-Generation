package rtg.world.biome.realistic.enhancedbiomes;

import java.util.Random;

import rtg.config.enhancedbiomes.ConfigEB;
import rtg.util.CellNoise;
import rtg.util.OpenSimplexNoise;
import rtg.world.biome.BiomeBase;
import rtg.world.gen.surface.enhancedbiomes.SurfaceEBSnowyWastelands;
import rtg.world.gen.terrain.enhancedbiomes.TerrainEBSnowyWastelands;
import enhancedbiomes.EnhancedBiomesMod;
import enhancedbiomes.api.EBAPI;
import enhancedbiomes.blocks.EnhancedBiomesBlocks;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class RealisticBiomeEBSnowyWastelands extends RealisticBiomeEBBase
{
    public static Block[] ebDominantStoneBlock = new Block[]{
        EBAPI.ebStonify(EnhancedBiomesBlocks.stoneEB, Blocks.stone),
        EBAPI.ebStonify(EnhancedBiomesBlocks.stoneEB, Blocks.stone)
    };
    
    public static byte[] ebDominantStoneMeta = new byte[]{
        EBAPI.ebStonify(EBAPI.CHERT, (byte)0),
        EBAPI.ebStonify(EBAPI.LIMESTONE, (byte)0)
    };
    
    public static Block[] ebDominantCobblestoneBlock = new Block[]{
        EBAPI.ebStonify(EnhancedBiomesBlocks.stoneCobbleEB, Blocks.cobblestone),
        EBAPI.ebStonify(EnhancedBiomesBlocks.stoneCobbleEB, Blocks.cobblestone)
    };
    
    public static byte[] ebDominantCobblestoneMeta = new byte[]{
        EBAPI.ebStonify(EBAPI.CHERT, (byte)0),
        EBAPI.ebStonify(EBAPI.LIMESTONE, (byte)0)
    };
    
    private static Block cobbleBlock = (EnhancedBiomesMod.useNewStone == 1) ? EnhancedBiomesBlocks.stoneCobbleEB : Blocks.cobblestone;
    private static byte cobbleByte = EBAPI.ebStonify(EBAPI.SLATE, (byte)0);
    
	public RealisticBiomeEBSnowyWastelands(BiomeGenBase ebBiome)
	{
		super(
			ebBiome, BiomeBase.climatizedBiome(BiomeGenBase.river, Climate.ICE),
			new TerrainEBSnowyWastelands(),
			new SurfaceEBSnowyWastelands(
                Blocks.packed_ice, //Block top 
                (byte)0, //byte topByte
                cobbleBlock, //Block filler, 
                cobbleByte, //byte fillerByte
                Blocks.snow, //Block mixTop, 
                (byte)0, //byte mixTopByte, 
                cobbleBlock, //Block mixFill, 
                cobbleByte, //byte mixFillByte, 
                cobbleBlock, //Block cliff1, 
                cobbleByte, //byte cliff1Byte, 
                cobbleBlock, //Block cliff2, 
                cobbleByte, //byte cliff2Byte, 
                40f, //float mixWidth, 
                -0.10f, //float mixHeight, 
                20f, //float smallWidth, 
                0.7f //float smallStrength
            )
		);
		
		this.setRealisticBiomeName("EB Snowy Wastelands");
		this.biomeSize = BiomeSize.NORMAL;
		this.biomeWeight = ConfigEB.weightEBSnowyWastelands;
		this.generateVillages = ConfigEB.villageEBSnowyWastelands;
        
    }
	
    @Override
    public void rDecorate(World world, Random rand, int chunkX, int chunkY, OpenSimplexNoise simplex, CellNoise cell, float strength,
        float river)
    {
    
        /*for (int l = 0; l < 3f * strength; ++l)
        {
            int i1 = chunkX + rand.nextInt(16) + 8;
            int j1 = chunkY + rand.nextInt(16) + 8;
            int k1 = world.getHeightValue(i1, j1);
            
            if (k1 < 95 && (k1 < 64 || rand.nextInt(8) == 0))
            {
                (new WorldGenBlob(Blocks.packed_ice, (byte)0, rand.nextInt(1))).generate(world, rand, i1, k1, j1, true);
            }
        }*/
    }
}
