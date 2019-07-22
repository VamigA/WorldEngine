/*
 * ////////////////////////////////////-
 * //#===============================//= Version: 2.0.0.1122 or later.
 * //#=-------| WorldEngine |-------=//= By Vamig Aliev (vk.com/win_vista).
 * //#===============================//= Part of VamigA_core (vk.com/vamiga).
 * ////////////////////////////////////-
 * 
 * Copyright (C) 2019 Vamig Aliev, all rights reserved.
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

import net.minecraft.block.state.IBlockState;
import ru.vamiga.worldengine.world.biome.WE_Biome;

/**
 * Первая стадия генерации чанков: абстрактный класс пользовательского генератора на каждый 256-блоковый слой [X, Z].
 * @author VamigA
 */
public abstract class WE_CreateChunkGen_InXZ implements WE_ICreateChunkGen_InXZ {
	/**
	 * Получает блок с координат в чанке.
	 * @param d - нынешние данные генератора.
	 * @param ly - локальная координата Y в этом чанке.
	 */
	public IBlockState getBlock(WE_GenData d, int ly) {
		return d.primer.getBlockState(d.bx, ly, d.bz);
	}
	
	/**
	 * Ставит блок в координатах в чанке.
	 * @param d - нынешние данные генератора.
	 * @param bs - блок.
	 * @param ly - локальная координата Y в этом чанке.
	 */
	public void setBlock(WE_GenData d, IBlockState bs, int ly) {
		d.primer.setBlockState(d.bx, ly, d.bz, bs);
	}
	
	/**
	 * Получает биом с координат в чанке.
	 * @param d - нынешние данные генератора.
	 */
	public WE_Biome getBiome(WE_GenData d) {
		return d.biomes[d.bx | d.bz << 4];
	}
}