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

package ru.vamiga.worldengine.world.properties;

import ru.vamiga.worldengine.world.biome.WE_Biome;
import ru.vamiga.worldengine.world.gen.noise.WE_IReliefGenerator;

/**
 * ���������. ����� � ����������������� ����������� ����, ��������� ������ ��.
 * @author VamigA
 */
public interface WE_IWorldProperties extends WE_IPropsWithGensAndCons {
	/**
	 * ���������� WE_Biome �� �������������� [i].
	 * @param i �������������.
	 * @return WE_Biome - ����.
	 */
	WE_Biome getBiome(int i);
	/**
	 * ���������� WE_Biome �� ��������� (���� ������� � ���� ����� �� �������� ��� ������-���� �����, �� ����� ��������������� ���� �� ���������).
	 * @return WE_Biome - ����.
	 */
	WE_Biome getDefaultBiome();
	/**
	 * ���������� ���������� ��������� � ������ ������: WE_Biome.
	 * @return ������ ������.
	 */
	int sizeofBiomes();
	
	/**
	 * ���������� IGenReliefLayer �� �������������� [i].
	 * @param i �������������.
	 * @return IGenReliefLayer - ����.
	 */
	IGenReliefLayer getReliefLayer(int i);
	/**
	 * ���������� ���������� ��������� � ������ �����: IGenReliefLayer.
	 * @return ������ ������.
	 */
	int sizeofReliefLayers();
	/**
	 * ���������. ����� ������ �� ��������� ����� ����.
	 * ��� ������� ����� ���������� ������ ����. ��, ��������, �� ������� ������� 2 ���� (������� � ������ ������).
	 * @author VamigA
	 */
	interface IGenReliefLayer {
		/**
		 * ������� ����� ���������� ���� (���������� ���).
		 * @return WE_IReliefGenerator - ���������.
		 */
		WE_IReliefGenerator getReliefGenerator();
		
		/**
		 * ������ ��������������, � ������� ���������� ������������ ������� ����� ������� (� ������).
		 * @return Integer[0] - ������ �� X; Integer[1] - ������ �� Z.
		 */
		int[] getInterQuadSize();
		/**
		 * ������������ ������� ����������� �������� (0 - ���; 1 - smoothstep; 2 - smootherstep).
		 * @return ��� Byte.
		 */
		byte getInterType();
		/**
		 * ���������� �� ������ �� ���������� ����� ����� �� ������ ����� ������� �������? ������ ���������� "interWithAnotherBiome".
		 * (!) ������������ �����������, ������ ���� ��������� ����� � ����, � �������� ��� ����� ���������� ����.
		 * @return ��� Boolean.
		 */
		boolean getInterDoIfVoid();
	}
	
	/**
	 * ���������� IGenBiomeMapLayer �� �������������� [i].
	 * @param i �������������.
	 * @return IGenBiomeMapLayer - ����.
	 */
	IGenBiomeMapLayer getBiomeMapLayer(int i);
	/**
	 * ���������� ���������� ��������� � ������ �����: IGenBiomeMapLayer.
	 * @return ������ ������.
	 */
	int sizeofBiomeMapLayers();
	/**
	 * ���������. ����� ������ �� ����� ������� ����� ����. ��������� Minecraft ���������� ��� ������������� ������ ����������� ����� - GenLayer.
	 * ���, ��������, ����� ������������ ������ GenBiomeMapLayer ��� ������/�����������, ������ - ��� �����������, ������ - ��� ID �����, ��������� - ��� ���.
	 * @author VamigA
	 */
	interface IGenBiomeMapLayer {
		/**
		 * ������� ����� ���� ������� ����� (���������� ���).
		 * @return WE_IReliefGenerator - ���������.
		 */
		WE_IReliefGenerator getReliefGenerator();
	}
}