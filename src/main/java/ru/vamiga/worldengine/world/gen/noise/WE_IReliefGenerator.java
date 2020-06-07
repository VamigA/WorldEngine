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
 * ��������� ��� ����������� ������� (��� ��������, ��� ������� � ��� �����).
 * @author VamigA
 */
public interface WE_IReliefGenerator {
	/**
	 * ���������� ���� ����������.
	 * @return ����.
	 */
	long getSeed();
	
	/**
	 * ������ ���� ����������.
	 * @param seed ����� ����.
	 */
	void setSeed(long seed);
	
	/**
	 * ������ ��������� ���������� �� ���� �����.
	 * @param pers �������� Persistence ����� ���������� ���� �� ���� �����.
	 * @param sclY �������� ScaleY ����� ���������� ���� �� ���� �����.
	 * @param hght �������� Height ����� ���������� ���� �� ���� �����.
	 */
	void setBiomeProperties(double pers, double sclY, int hght);
	
	/**
	 * ������ ������ �� ���� ����� (������������� ������ ���� ������� � ���������� ��������).
	 * @param x ���������� ����� X.
	 * @param z ���������� ����� Z.
	 * @return ������ ��� ����� �����.
	 */
	double genNoise2D(double x, double z);
}