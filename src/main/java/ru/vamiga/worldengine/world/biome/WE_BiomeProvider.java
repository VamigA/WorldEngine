package ru.vamiga.worldengine.world.biome;

import java.util.Set;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.provider.BiomeProvider;
//TODO Костыли!
public class WE_BiomeProvider extends BiomeProvider {
	public WE_BiomeProvider(Set<Biome> biomesIn) {
		super(biomesIn);
	}
	
	@Override
	public Biome getNoiseBiome(int x, int y, int z) {
		return Biomes.BEACH;
	}
}