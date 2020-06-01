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

package ru.vamiga.worldengine.world.gen.noise;

import ru.vamiga.worldengine.util.WE_RegionBuffer;

/**
 * �������� �� ��������������� ��������� ������ ����. �� ���� ������ � ������� ���������� WorldEngine ��� ������.
 * ���������� ������� ����� � ��������� �� -1.0 �� 1.0 �� ��������� ���� ��������� X � Z, � ����� "������".
 * ��� ���������� ������� ������ �������� ������ ������ ��������� ���� �� - ��� ����� �����.
 * @author VamigA
 */
public class WE_WhiteNoise {
	/** ���� - �����, �� ��������� �������� � ������� �������. */
	public long seed;
	
	public WE_RegionBuffer<Double> smart;
	
	/**
	 * �����������.
	 * @param genSeed ����.
	 */
	public WE_WhiteNoise(long genSeed) {
		seed = (long)Math.pow(genSeed, 11L) * 171L + 51484313L;
		smart = new WE_RegionBuffer<Double>(4, this::gen2D);
	}
	
	/**
	 * ������� ������� - ������������ � ������� ���������� ��������������� ����� �� ��������� ������� ������.
	 * @param x ���������� X ���� Long.
	 * @param z ���������� Z ���� Long.
	 * @return ��������������� ����� ���� Double � ��������� �� -1.0 �� 1.0.
	 */
	public double gen2D(long x, long z) {
		long n = seed + x * 4L + z * 341L; n = (n << 13L) ^ n;
	    return 1.0 - (double)((n * (n * n * 15731L + 789221L) + 1376312589L) & 2147483647L) / 1073741824.0;
	}
	
	
}