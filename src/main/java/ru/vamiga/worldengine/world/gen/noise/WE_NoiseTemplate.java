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

/**
 * ��� ������ ��� ������� �������, �����: WE_PerlinNoise ��� WE_ValueNoise.
 * @author VamigA
 */
public abstract class WE_NoiseTemplate implements WE_IReliefGenerator {
	/** Persistence - ����������� ��������� ��� ������ ������ ������������ ����������. Scale(X...Y...Z) - ��������� �������� ���� �����. */
	public double persistence, scaleX, scaleY, scaleZ;
	/** Octaves - ���������� �����. Height - ����� ������ ����������� � ��������� ����������. */
	public int octaves, height;
	/** ������������ ������� ����������� �������� (0 - ���; 1 - smoothstep; 2 - smootherstep). */
	public byte iType;
	
	/** ��������������� ���������. */
	public WE_WhiteNoise rand;
	
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
	public WE_NoiseTemplate(long gSeed, double gPersistence, int numOfOctaves, double scl_x, double scl_y, double scl_z, int sum, byte interpolation) {
		persistence = gPersistence; octaves = numOfOctaves; scaleX = scl_x; scaleY = scl_y; scaleZ = scl_z; height = sum; iType = interpolation;
		rand = new WE_WhiteNoise(gSeed);
	}
	
	/**
	 * ���������� ���� ����������.
	 * @return ����.
	 */
	@Override
	public long getSeed() {
		return rand.seed;
	}
	
	/**
	 * ������ ���� ����������.
	 * @param seed ����� ����.
	 */
	@Override
	public void setSeed(long seed) {
		rand.seed = seed;
	}
	
	/**
	 * ������ ��������� ���������� �� ���� �����.
	 * @param pers �������� Persistence ����� ���������� ���� �� ���� �����.
	 * @param sclY �������� ScaleY ����� ���������� ���� �� ���� �����.
	 * @param hght �������� Height ����� ���������� ���� �� ���� �����.
	 */
	@Override
	public void setBiomeProperties(double pers, double sclY, int hght) {
		persistence = pers; scaleY = sclY; height = hght;
	}
	
	/**
	 * ������ ������ �� ���� ����� (������������� ������ ���� ������� � ���������� ��������).
	 * @param x ���������� ����� X.
	 * @param z ���������� ����� Z.
	 * @return ������ ��� ����� �����.
	 */
	@Override
	public double genNoise2D(double x, double z) {
		double result = 0.0, amplitudeMultiplier = 1.0, nowX = x, nowZ = z;
		for(int i = 0; i < octaves; i++) {
			result += noiseOctave2D(nowX / scaleX, nowZ / scaleZ) * amplitudeMultiplier;
			amplitudeMultiplier *= persistence;
			nowX *= 2.0; nowZ *= 2.0;
		}
		return (double)height + result * scaleY;
	}
	
	/**
	 * ������� ������� (�������). ���������� ��� ��� ���� �� ����� ����.
	 * @param x ���������� ����� X.
	 * @param z ���������� ����� Z.
	 * @return ������ ���� (���, ������, ������) �� ���� �����.
	 */
	public abstract double noiseOctave2D(double x, double z);
}