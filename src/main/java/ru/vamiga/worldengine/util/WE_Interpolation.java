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

package ru.vamiga.worldengine.util;

/**
 * ����� ������������. �������� �������������� ������� ��� ���������� ������������.
 * @author VamigA
 */
public class WE_Interpolation {
	/** ��������� ��� ����������. */
	public static final byte
		I_VALUEFUNC_NONE         = 0,
		I_VALUEFUNC_SMOOTHSTEP   = 1,
		I_VALUEFUNC_SMOOTHERSTEP = 2;
	
	/**
	 * ������� Smoothstep. ������ �� ������� ����������� � �������� ������, ���������� �� ������ (0.0 � 1.0).
	 * ���������: https://en.wikipedia.org/wiki/Smoothstep.
	 * @param n ��������� �������� � 0.0 �� 1.0.
	 * @return ��������� ����������.
	 */
	public static double smoothstep(double n) {
		return n * n * (3.0 - 2.0 * n);
	}
	
	/**
	 * ������� Smootherstep. ������ �� ������� ����������� � �������� ������, ���������� �� ������ (0.0 � 1.0). �����, ��� Smoothstep.
	 * ���������: https://en.wikipedia.org/wiki/Smoothstep (����� �������� � ��� Smootherstep).
	 * @param n ��������� �������� � 0.0 �� 1.0.
	 * @return ��������� ����������.
	 */
	public static double smootherstep(double n) {
		return n * n * n * (n * (n * 6.0 - 15.0) + 10.0);
	}
	
	/**
	 * ��������, ��� ���������� �������� [n] ����� ������������� �� ���������� [i].
	 * @param n ��������� �������� � 0.0 �� 1.0.
	 * @param i ������������ ������� (0 - ���; 1 - smoothstep; 2 - smootherstep).
	 * @return ��������� ����������.
	 */
	public static double autoSmooth(double n, byte i) {
		switch(i) {
		case I_VALUEFUNC_SMOOTHERSTEP:          return smootherstep(n);
		case I_VALUEFUNC_SMOOTHSTEP  :          return smoothstep  (n);
		case I_VALUEFUNC_NONE        : default: return              n ;
		}
	}
	
	/**
	 * ��������������� �������������� ������� - ����������, �������� ������������ (���� ������): ����������� ������� ��� ���������� ��������.
	 * ���������: https://en.wikipedia.org/wiki/Linear_interpolation.
	 * @param a �������� A.
	 * @param b �������� B.
	 * @param n ��������� �������� � 0.0 �� 1.0 (�� A � B).
	 * @return ��������� ����������.
	 */
	public static double lerp(double a, double b, double n) {
		return a + (b - a) * n;
	}
	
	/**
	 * ���������� ������������ - ������� �������! ��������� �� ��� ����������� �������� ������ ������ ��������.
	 * ���������: https://en.wikipedia.org/wiki/Bilinear_interpolation.
	 * @param value_tl �������� ����� ������� �������.
	 * @param value_tr �������� ������ ������� �������.
	 * @param value_bl �������� ����� ������ �������.
	 * @param value_br �������� ������ ������ �������.
	 * @param pInQuadX ���������� X ������ ����� (�����, ��� �� ����� ��������) � �������� (� 0.0 �� 1.0).
	 * @param pInQuadZ ���������� Z ������ ����� (�����, ��� �� ����� ��������) � �������� (� 0.0 �� 1.0).
	 * @param i ������������ ������� ����������� �������� (0 - ���; 1 - smoothstep; 2 - smootherstep).
	 * @return ��������� ����������.
	 */
	public static double bilinearInterpolation2D(double value_tl, double value_tr, double value_bl, double value_br, double pInQuadX, double pInQuadZ, byte i) {
		return lerp(lerp(value_tl, value_tr, autoSmooth(pInQuadX, i)), lerp(value_bl, value_br, autoSmooth(pInQuadX, i)), autoSmooth(pInQuadZ, i));
	}
}