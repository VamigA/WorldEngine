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

package ru.vamiga.worldengine.world.gen;

import net.minecraft.world.IWorld;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.Heightmap.Type;
import net.minecraft.world.gen.WorldGenRegion;
import ru.vamiga.worldengine.world.biome.WE_Biome;
import ru.vamiga.worldengine.world.biome.WE_BiomeProvider;
import ru.vamiga.worldengine.world.gen.custom.abstracts.WE_GenData;
import ru.vamiga.worldengine.world.properties.WE_IWorldProperties;

/**
 * Главный генератор WorldEngine. Активирует другие, более мелкие, генераторы.
 * @param <C> Настройки генератора. Не используются в WorldEngine.
 * @author VamigA
 */
public class WE_ChunkGenerator<C extends GenerationSettings> extends ChunkGenerator<C> {
	/**
	 * Конструктор.
	 * @param w Мир Minecraft.
	 * @param p Настройки мира.
	 */
	public WE_ChunkGenerator(IWorld w, WE_IWorldProperties p) {
		super(w, new WE_BiomeProvider(w, p), null);
	}
	
	/**
	 * Первая стадия генерации чанков. Генерирует основной ландшафт.
	 * @param w Мир Minecraft.
	 * @param c Чанк Minecraft.
	 */
	@Override
	public void makeBase(IWorld w, IChunk c) {
		WE_BiomeProvider p = (WE_BiomeProvider)getBiomeProvider(); WE_Biome[][] biomes = new WE_Biome[16][16];
		long cx = (long)c.getPos().getXStart(), cz = (long)c.getPos().getZStart();
		for(int x = 0; x < 16; x++)
			for(int z = 0; z < 16; z++)
				biomes[x][z] = p.smart.get(cx | (long)x, cz | (long)z);
		int[][][] rData = new int[16][16][p.properties.sizeofReliefLayers() + 1];
		
		for(int i = 0; i < p.properties.sizeofCreateChunkGen(); i++)
			p.properties.getCreateChunkGen(i).generate(new WE_GenData(this, w, c, biomes, rData, 0, 0, 0));
		WE_Biome r = biomes[w.getRandom().nextInt(16)][w.getRandom().nextInt(16)];
		for(int i = 0; i < r.properties.sizeofCreateChunkGen(); i++)
			r.properties.getCreateChunkGen(i).generate(new WE_GenData(this, w, c, biomes, rData, 0, 0, 0));
		for(int x = 0; x < 16; x++)
			for(int z = 0; z < 16; z++) {
				for(int i = 0; i < p           .properties.sizeofCreateChunkGenInXZ(); i++)
					p           .properties.getCreateChunkGenInXZ(i).generate(new WE_GenData(this, w, c, biomes, rData, x, 0, z));
				for(int i = 0; i < biomes[x][z].properties.sizeofCreateChunkGenInXZ(); i++)
					biomes[x][z].properties.getCreateChunkGenInXZ(i).generate(new WE_GenData(this, w, c, biomes, rData, x, 0, z));
				for(int y = 0; y < 256; y++) {
					for(int i = 0; i < p           .properties.sizeofCreateChunkGenInXYZ(); i++)
						p           .properties.getCreateChunkGenInXYZ(i).generate(new WE_GenData(this, w, c, biomes, rData, x, y, z));
					for(int i = 0; i < biomes[x][z].properties.sizeofCreateChunkGenInXYZ(); i++)
						biomes[x][z].properties.getCreateChunkGenInXYZ(i).generate(new WE_GenData(this, w, c, biomes, rData, x, y, z));
				}
			}
	}
	
	/**
	 * Не нужен в WorldEngine. У нас другая система.
	 * @param w Мир Minecraft.
	 * @param c Чанк Minecraft.
	 */
	@Override
	public void generateSurface(WorldGenRegion w, IChunk c) { }
	
	/**
	 * Пока не используется в WorldEngine.
	 * @return Высота поверхности.
	 */
	@Override
	public int getGroundHeight() {
		return 64;
	}
	
	/**
	 * Пока не используется в WorldEngine.
	 * @param x Координата X.
	 * @param z Координата Z.
	 * @param heightmapType Тип карты высот.
	 * @return Число.
	 */
	@Override
	public int func_222529_a(int x, int z, Type heightmapType) {
		return 0;
	}
}