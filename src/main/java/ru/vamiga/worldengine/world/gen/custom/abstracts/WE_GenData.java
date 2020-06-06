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

import net.minecraft.world.IWorld;
import net.minecraft.world.chunk.IChunk;
import ru.vamiga.worldengine.world.biome.WE_Biome;
import ru.vamiga.worldengine.world.gen.WE_ChunkGenerator;

/**
 * ����� � ������� �������� ���������� ��� �������� �� ���������������� ����������� ������ ������ ��������� ������.
 * @author VamigA
 */
public class WE_GenData {
	/** ������� ��������� ������ WorldEngine. */
	public WE_ChunkGenerator<?> generator;
	/** ��� ������������ ���. ����� ����� ����� World ��� Random. */
	public IWorld world;
	/** ��� ������������ ����. ������ ����� ���������� ���� ��� �������� ��� �� �����������, � ����� ������ �����. */
	public IChunk chunk;
	/** ������ ������ ����� �� WorldEngine. */
	public WE_Biome[][] biomes;
	/** ������ ����� ����� ������� � ���� �����. */
	public int[][][] relief;
	/** ��������� ���������� ����� � ���� ����� (0...15; Y: 0...255). ��� �� ������ ������������. */
	public int bx, by, bz;
	
	/**
	 * �����������.
	 * @param gen ������� ��������� ������ WorldEngine.
	 * @param wld ��� ������������ ���.
	 * @param chk ��� ������������ ����.
	 * @param bms ������ ������ ����� �� WorldEngine.
	 * @param rel ������ ����� ����� ������� � ���� �����.
	 * @param bxp ��������� ���������� X ����� � ���� �����.
	 * @param byp ��������� ���������� Y ����� � ���� �����.
	 * @param bzp ��������� ���������� Z ����� � ���� �����.
	 */
	public WE_GenData(WE_ChunkGenerator<?> gen, IWorld wld, IChunk chk, WE_Biome[][] bms, int[][][] rel, int bxp, int byp, int bzp) {
		generator = gen; world = wld; chunk = chk; biomes = bms; relief = rel; bx = bxp; by = byp; bz = bzp;
	}
}