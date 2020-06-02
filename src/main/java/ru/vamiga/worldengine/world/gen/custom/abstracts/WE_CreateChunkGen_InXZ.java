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

package ru.vamiga.worldengine.world.gen.custom.abstracts;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import ru.vamiga.worldengine.world.biome.WE_Biome;

/**
 * Первая стадия генерации чанков: абстрактный класс пользовательского генератора на каждый 256-блоковый слой [X, Z].
 * @author VamigA
 */
public abstract class WE_CreateChunkGen_InXZ implements WE_ICreateChunkGen_InXZ {
	/**
	 * Получает блок с координат в чанке.
	 * @param d Нынешние данные генератора.
	 * @param ly Локальная координата Y в этом чанке.
	 * @return Нужный блок.
	 */
	public BlockState getBlock(WE_GenData d, int ly) {
		return d.chunk.getBlockState(new BlockPos(d.bx, ly, d.bz));
	}
	
	/**
	 * Ставит блок в координатах в чанке.
	 * @param d Нынешние данные генератора.
	 * @param bs Блок.
	 * @param ly Локальная координата Y в этом чанке.
	 */
	public void setBlock(WE_GenData d, BlockState bs, int ly) {
		d.chunk.setBlockState(new BlockPos(d.bx, ly, d.bz), bs, false);
	}
	
	/**
	 * Получает биом с координат в чанке.
	 * @param d Нынешние данные генератора.
	 * @return Нужный биом.
	 */
	public WE_Biome getBiome(WE_GenData d) {
		return (WE_Biome)d.chunk.getBiomes().getNoiseBiome(d.bx, 0, d.bz);
	}
}