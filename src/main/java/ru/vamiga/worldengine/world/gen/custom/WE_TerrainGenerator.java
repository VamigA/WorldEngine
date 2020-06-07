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

package ru.vamiga.worldengine.world.gen.custom;

import net.minecraft.block.Blocks;
import ru.vamiga.worldengine.world.biome.WE_BiomeProvider;
import ru.vamiga.worldengine.world.gen.custom.abstracts.WE_CreateChunkGen_InXZ;
import ru.vamiga.worldengine.world.gen.custom.abstracts.WE_GenData;
import ru.vamiga.worldengine.world.gen.noise.WE_PerlinNoise;

/**
 * Основной стандартный пользовательский генератор WorldEngine: генератор ландшафта!
 * Создает карты высоты (GenReliefLayer), а затем устанавливает каменные блоки с водой на основе этих данных карт.
 * @author VamigA
 */
public class WE_TerrainGenerator extends WE_CreateChunkGen_InXZ {
	/**
	 * Функция генерации.
	 * @param d Нынешние данные генератора.
	 */
	@Override
	public void generate(WE_GenData d) {
		if(getBiome(d) == ((WE_BiomeProvider)d.generator.getBiomeProvider()).properties.getBiome(0)) {
			((WE_PerlinNoise)((WE_BiomeProvider)d.generator.getBiomeProvider()).properties.getReliefLayer(0).getReliefGenerator()).persistence = 0.5;
			((WE_PerlinNoise)((WE_BiomeProvider)d.generator.getBiomeProvider()).properties.getReliefLayer(0).getReliefGenerator()).scaleY = 32;
			((WE_PerlinNoise)((WE_BiomeProvider)d.generator.getBiomeProvider()).properties.getReliefLayer(0).getReliefGenerator()).height = 96;
		} else if(getBiome(d) == ((WE_BiomeProvider)d.generator.getBiomeProvider()).properties.getBiome(1)) {
			((WE_PerlinNoise)((WE_BiomeProvider)d.generator.getBiomeProvider()).properties.getReliefLayer(0).getReliefGenerator()).persistence = 0.7;
			((WE_PerlinNoise)((WE_BiomeProvider)d.generator.getBiomeProvider()).properties.getReliefLayer(0).getReliefGenerator()).scaleY = 20;
			((WE_PerlinNoise)((WE_BiomeProvider)d.generator.getBiomeProvider()).properties.getReliefLayer(0).getReliefGenerator()).height = 64;
		}
		int h = (int)((WE_PerlinNoise)((WE_BiomeProvider)d.generator.getBiomeProvider()).properties.getReliefLayer(0).getReliefGenerator()).genNoise2D(d.chunk.getPos().getXStart() + d.bx, d.chunk.getPos().getZStart() + d.bz);
		for(int i = 0; i < h; i++)
			setBlock(d, Blocks.STONE.getDefaultState(), i);
	}
}