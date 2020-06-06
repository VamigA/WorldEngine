/*
 * ////////////////////////////////////-
 * //#===============================//= Version: 2.0.0.1152 or later.
 * //#=-------| WorldEngine |-------=//= By Vamig Aliev (vk.com/win_vista).
 * //#===============================//= Part of VamigA_core (vk.com/vamiga).
 * ////////////////////////////////////-
 * 
 * Copyright (C) 2020 Vamig Aliev, all rights reserved.
 * Licensed under the GNU LGPL 3 or later.
 * 
 * This file is part of WorldEngine.
 * 
 * WorldEngine  is  free  software:  you can  redistribute  it  and/or  modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the  Free  Software  Foundation,  either  version  3  of  the  License,  or
 * (at your option) any later version.
 * 
 * WorldEngine   is   distributed  in  the  hope  that  it  will   be   useful,
 * but   WITHOUT   ANY  WARRANTY;  without  even  the  implied   warranty   of
 * MERCHANTABILITY   or   FITNESS   FOR   A  PARTICULAR   PURPOSE.   See   the
 * GNU Lesser General Public License for more details.
 * 
 * You  should  have received a copy of the GNU Lesser General Public  License
 * along with WorldEngine. If not, see <https://www.gnu.org/licenses/>.
 */

package ru.vamiga.worldengine.world.biome;

import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.block.BlockState;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraftforge.registries.ForgeRegistries;
import ru.vamiga.worldengine.WE_WorldRegistry;
import ru.vamiga.worldengine.util.WE_RegionBuffer;
import ru.vamiga.worldengine.world.properties.WE_IWorldProperties;

/**
 * Отвечает за распределение биомов в мире, сгенерированном WorldEngine.
 * @author VamigA
 */
public class WE_BiomeProvider extends BiomeProvider {
	/** Настройки мира. */
	public WE_IWorldProperties properties;
	
	/** Буфер биомов. Временно их хранит, так мы экономим такты процессора на расчетах. */
	public WE_RegionBuffer<WE_Biome> smart;
	
	/**
	 * Конструктор.
	 * @param w Мир Minecraft.
	 * @param p Настройки мира.
	 */
	public WE_BiomeProvider(IWorld w, WE_IWorldProperties p) {
		super(null);
		smart = new WE_RegionBuffer<WE_Biome>(2048, this::getWEBiomeAt);
		
		properties = p;
		for(int l = 0; l < properties.sizeofBiomeMapLayers(); l++)
			properties.getBiomeMapLayer(l).getReliefGenerator().setSeed((long)Math.pow((double)l * 175954.0 + (double)w.getSeed() + 35974855.0, 17.0) * 5123L);
		
		if(WE_WorldRegistry.WEBiome.forGame == null)
			if(ForgeRegistries.BIOMES.containsValue((Biome)WE_WorldRegistry.WEBiome))
				WE_WorldRegistry.WEBiome.forGame = (Biome)WE_WorldRegistry.WEBiome;
			else
				WE_WorldRegistry.WEBiome.forGame = Biomes.PLAINS;
		if(properties.getDefaultBiome().forGame == null)
			if(ForgeRegistries.BIOMES.containsValue((Biome)properties.getDefaultBiome()))
				properties.getDefaultBiome().forGame = (Biome)properties.getDefaultBiome();
			else
				properties.getDefaultBiome().forGame = WE_WorldRegistry.WEBiome.forGame;
		for(int i = 0; i < properties.sizeofBiomes(); i++)
			if(properties.getBiome(i).forGame == null)
				if(ForgeRegistries.BIOMES.containsValue((Biome)properties.getBiome(i)))
					properties.getBiome(i).forGame = (Biome)properties.getBiome(i);
				else
					properties.getBiome(i).forGame = properties.getDefaultBiome().forGame;
	}
	
	/**
	 * Ванильная функция. Выдает самой игре ее биом.
	 * @param x Координата блока X, деленная на 4.
	 * @param y Координата блока Y, деленная на 4.
	 * @param z Координата блока Z, деленная на 4.
	 * @return Биом ванильного (Biome) типа.
	 */
	@Override
	public Biome getNoiseBiome(int x, int y, int z) {
		return smart.get((long)x * 4L, (long)z * 4L).forGame;
	}
	
	/**
	 * Выдает генератору WorldEngine биом на координатах.
	 * @param x Координата блока X.
	 * @param z Координата блока Z.
	 * @return Биом типа WE_Biome.
	 */
	public WE_Biome getWEBiomeAt(long x, long z) {
		int[] noiseLayersData = new int[properties.sizeofBiomeMapLayers()];
		for(int i = 0; i < properties.sizeofBiomeMapLayers(); i++)
			noiseLayersData[i] = (int)Math.round(properties.getBiomeMapLayer(i).getReliefGenerator().genNoise2D((double)x, (double)z));
		
		for(int i = 0; i < properties.sizeofBiomes(); i++)
			if(properties.getBiome(i).properties.getLayersConditions().go(noiseLayersData))
				return properties.getBiome(i);
		
		return properties.getDefaultBiome();
	}
	
	/**
	 * Пока не используется в WorldEngine.
	 * @param structureIn Структура.
	 * @return Имеется ли структура?
	 */
	@Override
	public boolean hasStructure(Structure<?> structureIn) {
		return false;
	}
	
	/**
	 * Пока не используется в WorldEngine.
	 * @return Набор поверхностных блоков.
	 */
	@Override
	public Set<BlockState> getSurfaceBlocks() {
		return Sets.newHashSet();
	}
}