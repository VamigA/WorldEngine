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

import ru.vamiga.worldengine.util.WE_Interpolation;

/**
 * ����� ���� �������� WorldEngine. ������ ����������� ���, � �����.
 * ���������: https://en.wikipedia.org/wiki/Value_noise; https://habr.com/post/142592/ (<= �� ����� ����, � ������ ����������� ������ ���� ���).
 * @author VamigA
 */
public class WE_ValueNoise extends WE_NoiseTemplate {
	/**
	 * �����������.
	 * @param gSeed ����.
	 * @param gPersistence ��������� (����������� ��������� ��� ������ ������ ������������ ����������).
	 * @param numOfOctaves ���������� �����.
	 * @param scl_x ��������� �������� �� X ���� �����.
	 * @param scl_y ��������� �������� �� Y ���� �����.
	 * @param scl_z ��������� �������� �� Z ���� �����.
	 * @param sum ������ (����� ������ ����������� � ��������� ����������).
	 * @param interpolation ������������ ������� ����������� �������� (0 - ���; 1 - smoothstep; 2 - smootherstep).
	 */
	public WE_ValueNoise(long gSeed, double gPersistence, int numOfOctaves, double scl_x, double scl_y, double scl_z, int sum, byte interpolation) {
		super(gSeed, gPersistence, numOfOctaves, scl_x, scl_y, scl_z, sum, interpolation);
		rand.makeSmartForValues();
	}
	
	/**
	 * ������� ������� (�������). ���������� ��� ��� ���� �� ����� ����.
	 * @param x ���������� ����� X.
	 * @param z ���������� ����� Z.
	 * @return ������ ���� (���, ������, ������) �� ���� �����.
	 */
	@Override
	public double noiseOctave2D(double x, double z) {
		long squareStartX = (long)x, squareStartZ = (long)z, xs = 1L, zs = 1L; if(Math.abs(x) != x) xs = -1L; if(Math.abs(z) != z) zs = -1L;
		double pointInQuadX = Math.abs(x) - (double)Math.abs(squareStartX), pointInQuadZ = Math.abs(z) - (double)Math.abs(squareStartZ),
		
		topLeft     = rand.smartVal.get(squareStartX     , squareStartZ     ),
		topRight    = rand.smartVal.get(squareStartX + xs, squareStartZ     ),
		bottomLeft  = rand.smartVal.get(squareStartX     , squareStartZ + zs),
		bottomRight = rand.smartVal.get(squareStartX + xs, squareStartZ + zs);
		
		return WE_Interpolation.bilinearInterpolation2D(topLeft, topRight, bottomLeft, bottomRight, pointInQuadX, pointInQuadZ, iType);
	}
}