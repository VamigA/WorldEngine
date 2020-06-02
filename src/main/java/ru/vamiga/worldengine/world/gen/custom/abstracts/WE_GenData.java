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

import net.minecraft.world.chunk.ChunkPrimer;
import ru.vamiga.worldengine.world.biome.WE_Biome;

/**
 * Класс с данными главного генератора для передачи их пользовательским генераторам первой стадии генерации чанков.
 * Главный генератор, массив блоков будущего чанка, координаты чанка, локальные координаты блока...
 * @author VamigA
 */
public class WE_GenData {
	/** Главный генератор чанков WorldEngine. Вы можете получить классы World или Random отсюда. */
	public WE_ChunkGenerator gen;
	/** "Грунтовка" чанка. Содержит огромный массив с блоками будущего чанка. */
	public ChunkPrimer primer;
	/** Координаты чанка. */
	public long cx, cz;
	/** Массив с биомами чанка. */
	public WE_Biome[] biomes;
	/** Данные высот слоев рельефа в этом чанке. */
	public int[][] relief;
	/** Локальные координаты блока в этом чанке (0...15; Y: 0...255). Они не всегда используются. */
	public int bx, by, bz;
	
	/**
	 * Constructor.
	 * @param genp - главный генератор чанков WorldEngine.
	 * @param primerp - массив блоков будущего чанка.
	 * @param cxp - координата X этого чанка.
	 * @param czp - координата Z этого чанка.
	 * @param biomesp - массив биомов будущего чанка.
	 * @param reliefp - данные высот слоев рельефа в этом чанке.
	 * @param bxp - локальная координата X блока в этом чанке.
	 * @param byp - локальная координата Y блока в этом чанке.
	 * @param bzp - локальная координата Z блока в этом чанке.
	 */
	public WE_GenData(WE_ChunkGenerator genp, ChunkPrimer primerp, long cxp, long czp, WE_Biome[] biomesp, int[][] reliefp, int bxp, int byp, int bzp) {
		gen = genp; primer = primerp; cx = cxp; cz = czp; biomes = biomesp; relief = reliefp; bx = bxp; by = byp; bz = bzp;
	}
}