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

package ru.vamiga.worldengine.world.biome;

import net.minecraft.world.biome.Biome;

/**
 * ����� �������� ������������ ����� WorldEngine.
 * @author VamigA
 */
public class WE_Biome extends Biome {
	/** ��������� �����. */
	public WE_IBiomeProperties properties;
	
	/**
	 * ������������� ����� � ������� ����. WorldEngine ������������� ���������� ���� ��������.
	 * �������� 256 ��������, ��� � ������ ������ ���� �� ����� �������������� � ���� (��������, �� ���������������).
	 */
	public short regID;
	
	/**
	 * �����������.
	 * @param weProps - ��������� �����.
	 */
	public WE_Biome(WE_IBiomeProperties weProps) {
		super(weProps.getVanillaBiomeProperties());
		properties = weProps; regID = 256;
	}
}