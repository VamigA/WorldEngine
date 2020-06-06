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
 * ������ ������ ��������� ������: ����������� ����� ����������������� ���������� �� ������ ����.
 * @author VamigA
 */
public abstract class WE_CreateChunkGen implements WE_ICreateChunkGen {
	/**
	 * �������� ���� � ��������� � �����.
	 * @param d �������� ������ ����������.
	 * @param lx ��������� ���������� X � ���� �����.
	 * @param ly ��������� ���������� Y � ���� �����.
	 * @param lz ��������� ���������� Z � ���� �����.
	 * @return ������ ����.
	 */
	public BlockState getBlock(WE_GenData d, int lx, int ly, int lz) {
		return d.chunk.getBlockState(new BlockPos(lx, ly, lz));
	}
	
	/**
	 * ������ ���� � ����������� � �����.
	 * @param d �������� ������ ����������.
	 * @param bs ����.
	 * @param lx ��������� ���������� X � ���� �����.
	 * @param ly ��������� ���������� Y � ���� �����.
	 * @param lz ��������� ���������� Z � ���� �����.
	 */
	public void setBlock(WE_GenData d, BlockState bs, int lx, int ly, int lz) {
		d.chunk.setBlockState(new BlockPos(lx, ly, lz), bs, false);
	}
	
	/**
	 * �������� ���� � ��������� � �����.
	 * @param d �������� ������ ����������.
	 * @param lx ��������� ���������� X � ���� �����.
	 * @param lz ��������� ���������� Z � ���� �����.
	 * @return ������ ����.
	 */
	public WE_Biome getBiome(WE_GenData d, int lx, int lz) {
		return d.biomes[lx][lz];
	}
}