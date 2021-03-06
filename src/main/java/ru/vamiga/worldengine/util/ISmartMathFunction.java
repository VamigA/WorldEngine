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
 * ��� �������������� ���������. ����� ������ ��� �������� ������� ��� ��������� ��� ������.
 * @param <ValueType> ��� ��������, ������� ������ ������ �����.
 * @author VamigA
 */
@FunctionalInterface
public interface ISmartMathFunction<ValueType extends Object> {
	/**
	 * �������, ������� ���������� ���������� ��� ������-���������. � ������ ������ ��� ������� ���������� ������ ������ �� �����������.
	 * �������� �� ������ WE_RegionBuffer ��������� ������������ �� ������ � ��������� �������, ������� ������ �� �������� ��� ���������� �������������.
	 * @param x ���������� X, �� ������� ������������� ������.
	 * @param z ���������� Z, �� ������� ������������� ������.
	 * @return ������ ������ ����, ������� ��� ������ ��� �������� ������ ��� ValueType.
	 */
	ValueType g(long x, long z);
}