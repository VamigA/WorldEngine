package ru.vamiga.worldengine.world.gen;

import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.block.Blocks;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.Heightmap.Type;
import net.minecraft.world.gen.WorldGenRegion;
import ru.vamiga.worldengine.world.biome.WE_BiomeProvider;
import ru.vamiga.worldengine.world.gen.noise.WE_PerlinNoise;
import ru.vamiga.worldengine.world.gen.noise.WE_ValueNoise;
import ru.vamiga.worldengine.world.gen.noise.WE_WhiteNoise;
//TODO Костыли!
public class WE_ChunkGenerator<C extends GenerationSettings> extends ChunkGenerator<C> {
	public WE_ValueNoise n;
	
	public WE_ChunkGenerator(IWorld myWorld) {

		super(myWorld, new WE_BiomeProvider(Biome.BIOMES), (C) new GenerationSettings());
		n = new WE_ValueNoise(myWorld.getSeed(), 0.5, 6, 400, 10, 400, 64, (byte)2);
	}

	@Override
	public void generateSurface(WorldGenRegion p_225551_1_, IChunk p_225551_2_) {
		ChunkPos chunkpos = p_225551_2_.getPos();
		int i = chunkpos.x;
		int j = chunkpos.z;
		SharedSeedRandom sharedseedrandom = new SharedSeedRandom();
		sharedseedrandom.setBaseChunkSeed(i, j);
		ChunkPos chunkpos1 = p_225551_2_.getPos();
		int k = chunkpos1.getXStart();
		int l = chunkpos1.getZStart();
		double d0 = 0.0625D;
		BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();
		
		for (int i1 = 0; i1 < 16; ++i1) {
			for (int j1 = 0; j1 < 16; ++j1) {
				double h = n.genNoise2D(chunkpos.x * 16 + i1, chunkpos.z * 16 + j1);
				for(int y = 0; y <= h; y++)
					p_225551_2_.setBlockState(blockpos$mutable.setPos(i1, y, j1), Blocks.STONE.getDefaultState(), false);
			}
		}
	}

	@Override
	public int getGroundHeight() {
		return 0;
	}

	@Override
	public void makeBase(IWorld worldIn, IChunk chunkIn) {

	}

	@Override
	public int func_222529_a(int p_222529_1_, int p_222529_2_, Type heightmapType) {
		return 0;
	}
	
	@Override
	public void decorate(WorldGenRegion region) {}
}