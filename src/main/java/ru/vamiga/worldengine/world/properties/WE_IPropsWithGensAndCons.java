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

package ru.vamiga.worldengine.world.properties;

import net.minecraftforge.fml.common.IWorldGenerator;
import ru.vamiga.worldengine.world.gen.custom.abstracts.WE_ICreateChunkGen;
import ru.vamiga.worldengine.world.gen.custom.abstracts.WE_ICreateChunkGen_InXYZ;
import ru.vamiga.worldengine.world.gen.custom.abstracts.WE_ICreateChunkGen_InXZ;

/**
 * ���������. ������ ��� �������� (���� � �����) �� �������� ����������� � � ��������� ���������.
 * @author VamigA
 */
public interface WE_IPropsWithGensAndCons {
	/**
	 * ���������� WE_ICreateChunkGen �� �������������� [i].
	 * @param i - �������������.
	 * @return WE_ICreateChunkGen - ���������.
	 */
	WE_ICreateChunkGen getCreateChunkGen(int i);
	/**
	 * ���������� ���������� ��������� � ������ �����������: WE_ICreateChunkGen.
	 * @return ������ ������.
	 */
	int sizeofCreateChunkGen();
	
	/**
	 * ���������� WE_ICreateChunkGen_InXZ �� �������������� [i].
	 * @param i - �������������.
	 * @return WE_ICreateChunkGen_InXZ - ���������.
	 */
	WE_ICreateChunkGen_InXZ getCreateChunkGenInXZ(int i);
	/**
	 * ���������� ���������� ��������� � ������ �����������: WE_ICreateChunkGen_InXZ.
	 * @return ������ ������.
	 */
	int sizeofCreateChunkGenInXZ();
	
	/**
	 * ���������� WE_ICreateChunkGen_InXYZ �� �������������� [i].
	 * @param i - �������������.
	 * @return WE_ICreateChunkGen_InXYZ - ���������.
	 */
	WE_ICreateChunkGen_InXYZ getCreateChunkGenInXYZ(int i);
	/**
	 * ���������� ���������� ��������� � ������ �����������: WE_ICreateChunkGen_InXYZ.
	 * @return ������ ������.
	 */
	int sizeofCreateChunkGenInXYZ();
	
	/**
	 * ���������� IWorldGenerator �� �������������� [i].
	 * @param i - �������������.
	 * @return IWorldGenerator - ���������.
	 */
	IWorldGenerator getDecorateChunkGen(int i);
	/**
	 * ���������� ���������� ��������� � ������ �����������: IWorldGenerator.
	 * @return ������ ������.
	 */
	int sizeofDecorateChunkGen();
	
	/**
	 * ���������� IGenReliefConditions ��� ����� ���� (��� ���� ��������).
	 * @return IGenReliefConditions - ������� ���������.
	 */
	IGenReliefConditions getLayersConditions();
	/**
	 * ���������. ���� ����� ������� ����������, ����� � ��� �� ������ ������������� �������� ��� ���� (������������ ������ ����������� "if").
	 * @author VamigA
	 */
	interface IGenReliefConditions {
		/**
		 * ��������� �������� ��� � ����������. ������� ������ �������, ������� �� ���������� ������������� ���� ��� ���� ����� ��� ����� ������� ������. ��� ��������� ����� ������ true.
		 * @param rLayersDataFromGen - ������ ������ ����� ������� ��� ����-�����. ������� ����� ������� �������� �������������� ����� ���� ������� ��� ����-�����.
		 *        � WE_WorldProperties ��� ���� ������ ������� � ����� (rLayersDataFromGen[����������_�����]) ������������ ��� �������� ������ ���������.
		 * @return ����� ������������ (true/false). ���� true, �� ��������� ����������� ���� ��� ���� ����� ���.
		 */
		boolean go(int[] rLayersDataFromGen);
	}
}