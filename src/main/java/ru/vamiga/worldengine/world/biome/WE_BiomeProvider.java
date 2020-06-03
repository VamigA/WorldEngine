package ru.vamiga.worldengine.world.biome;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import ru.vamiga.worldengine.WE_WorldRegistry;

public class WE_BiomeProvider extends BiomeProvider {
	public WE_BiomeProvider() {
		super(null);
	}
	
	@Override
	public Biome getNoiseBiome(int x, int y, int z) {
		return WE_WorldRegistry.WEBiome;
	}
}