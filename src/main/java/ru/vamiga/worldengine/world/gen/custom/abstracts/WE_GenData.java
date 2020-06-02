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

import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.WorldGenRegion;
import ru.vamiga.worldengine.world.gen.WE_ChunkGenerator;

/**
 * Класс с данными главного генератора для передачи их пользовательским генераторам первой стадии генерации чанков.
 * @author VamigA
 */
public class WE_GenData {
	/** Главный генератор чанков WorldEngine. Здесь можно получить World или Random. */
	public WE_ChunkGenerator<?> generator;
	/** Генерируемый регион мира. Здесь можно получить World или Random, а также координаты главного генерируемого чанка. */
	public WorldGenRegion region;
	/** Сам генерируемый чанк. Отсюда можно установить блок или получить его на координатах, а также узнать биомы. */
	public IChunk chunk;
	/** Данные высот слоев рельефа в этом чанке. */
	public int[][] relief;
	/** Локальные координаты блока в этом чанке (0...15; Y: 0...255). Они не всегда используются. */
	public int bx, by, bz;
	
	/**
	 * Конструктор.
	 * @param gen Главный генератор чанков WorldEngine.
	 * @param reg Генерируемый регион мира.
	 * @param ch Сам генерируемый чанк.
	 * @param rel Данные высот слоев рельефа в этом чанке.
	 * @param bxp Локальная координата X блока в этом чанке.
	 * @param byp Локальная координата Y блока в этом чанке.
	 * @param bzp Локальная координата Z блока в этом чанке.
	 */
	public WE_GenData(WE_ChunkGenerator<?> gen, WorldGenRegion reg, IChunk ch, int[][] rel, int bxp, int byp, int bzp) {
		generator = gen; region = reg; chunk = ch; relief = rel; bx = bxp; by = byp; bz = bzp;
	}
}