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
 * ��� ����� ������������ ���������� ������ WorldEngine.
 * ����� ����� ��� ���������� �������� � ������������� ��������� ����������, ������� �������� ������������� �����.
 * @param <ValueType> ��� ��������, ������� ������ ������ �����.
 * @author VamigA
 */
public class WE_RegionBuffer<ValueType extends Object> {
	/** 4 ����������, � ������� �������� 4 ����������. ��������� - � �������� ������ SubRegion. */
	public SubRegion sr00, sr10, sr01, sr11;
	/** ����������� ������ ��� ����������� ��������� �������, �� �������� �������� ������, � size - ������ ���������� (�� 4 � �������). */
	public long currentX, currentZ, currentX0, currentZ0, currentX1, currentZ1, size;
	
	/** �������, ������� ���������� ��� ���������� ������ � ������ ������ ��� ������ �� ����. */
	public ISmartMathFunction<ValueType> f;
	
	/**
	 * �����������.
	 * @param allSize ������ ����� �������, ��� �������� �� ������� �� 4 � ������������ � ������ ��� ������ ����������.
	 * @param methode �������, ������� ���������� ��� ���������� ������ � ������ ������ ��� ������ �� ����.
	 */
	public WE_RegionBuffer(int allSize, ISmartMathFunction<ValueType> methode) {
		size = (long)allSize / 4L;
		sr00 = new SubRegion(); sr10 = new SubRegion();
		sr01 = new SubRegion(); sr11 = new SubRegion();
		
		currentX = 0; currentZ = 0;
		recalc�oords(true, true);
		
		f = methode;
	}
	
	/**
	 * ������� "�����" ������� ������, � ������� � ����� ���������� �� �������.
	 * ��� � ������� ������ ������ � ���� ������� ������� �������� ������, ��������� ���� ������ ��� �� ���������� � ������� ��.
	 * ��� �������������, ���� ������������� ������ �� ��������� �������, ��� � ���������� ��� ������ ����������� �� ��� ��������������.
	 * @param x ���������� X, �� ������� ������������� ������.
	 * @param z ���������� Z, �� ������� ������������� ������.
	 * @return ������ ������ ����, ������� ��� ������ ��� �������� ������ ��� ValueType.
	 */
	public ValueType get(long x, long z) {
		if(x > currentX0 && z > currentZ0 && x <= currentX1 && z <= currentZ1) {
			int inSubReg_X = (int)((x - 1L) % size), inSubReg_Z = (int)((z - 1L) % size);
			if(inSubReg_X < 0) inSubReg_X += (int)size; if(inSubReg_Z < 0) inSubReg_Z += (int)size;
			if(x <= currentX) {
				if(z <= currentZ)
					return sr00.returnData(inSubReg_X, inSubReg_Z, x, z);
				else
					return sr01.returnData(inSubReg_X, inSubReg_Z, x, z);
			} else
				if(z <= currentZ)
					return sr10.returnData(inSubReg_X, inSubReg_Z, x, z);
				else
					return sr11.returnData(inSubReg_X, inSubReg_Z, x, z);
		} else {
			long checkX1 = currentX0 - size, checkX2 = currentX0 + size / 2L, checkX3 = currentX1 - size / 2L, checkX4 = currentX1 + size,
				checkZ1  = currentZ0 - size, checkZ2 = currentZ0 + size / 2L, checkZ3 = currentZ1 - size / 2L, checkZ4 = currentZ1 + size;
			if       (x > checkX1 && z > checkZ1 && x <= checkX2 && z <= checkZ2) {
				sr11 = sr00; sr00 = new SubRegion(); sr01 = new SubRegion(); sr10 = new SubRegion();
				currentX = currentX0; currentZ = currentZ0; recalc�oords(true , true );
			} else if(x > checkX1 && z > checkZ3 && x <= checkX2 && z <= checkZ4) {
				sr10 = sr01; sr01 = new SubRegion(); sr00 = new SubRegion(); sr11 = new SubRegion();
				currentX = currentX0; currentZ = currentZ1; recalc�oords(true , true );
			} else if(x > checkX3 && z > checkZ1 && x <= checkX4 && z <= checkZ2) {
				sr01 = sr10; sr10 = new SubRegion(); sr00 = new SubRegion(); sr11 = new SubRegion();
				currentX = currentX1; currentZ = currentZ0; recalc�oords(true , true );
			} else if(x > checkX3 && z > checkZ3 && x <= checkX4 && z <= checkZ4) {
				sr00 = sr11; sr11 = new SubRegion(); sr01 = new SubRegion(); sr10 = new SubRegion();
				currentX = currentX1; currentZ = currentZ1; recalc�oords(true , true );
			} else if(x > checkX2 && z > checkZ1 && x <= checkX3 && z <= checkZ2) {
				sr01 = sr00; sr11 = sr10           ; sr00 = new SubRegion(); sr10 = new SubRegion();
				currentZ = currentZ0;                       recalc�oords(false, true );
			} else if(x > checkX2 && z > checkZ3 && x <= checkX3 && z <= checkZ4) {
				sr00 = sr01; sr10 = sr11           ; sr01 = new SubRegion(); sr11 = new SubRegion();
				currentZ = currentZ1;                       recalc�oords(false, true );
			} else if(x > checkX1 && z > checkZ2 && x <= checkX2 && z <= checkZ3) {
				sr10 = sr00; sr11 = sr01           ; sr00 = new SubRegion(); sr01 = new SubRegion();
				currentX = currentX0;                       recalc�oords(true , false);
			} else if(x > checkX3 && z > checkZ2 && x <= checkX4 && z <= checkZ3) {
				sr00 = sr10; sr01 = sr11           ; sr10 = new SubRegion(); sr11 = new SubRegion();
				currentX = currentX1;                       recalc�oords(true , false);
			} else {
				sr00 = new SubRegion(); sr10 = new SubRegion(); sr01 = new SubRegion(); sr11 = new SubRegion();
				
				long preX1, preZ1, preX2, preZ2, interX, interZ;
				if(x > 0) preX1 = (long)((x - 1L) / size) * size; else preX1 = (long)(x / size) * size - size;
				if(z > 0) preZ1 = (long)((z - 1L) / size) * size; else preZ1 = (long)(z / size) * size - size;
				preX2 = preX1 + size; preZ2 = preZ1 + size; interX = preX1 + size / 2L; interZ = preZ1 + size / 2L;
				if       (x > preX1  && z > preZ1  && x <= interX && z <= interZ) {
					currentX = preX1; currentZ = preZ1;
				} else if(x > preX1  && z > interZ && x <= interX && z <= preZ2 ) {
					currentX = preX1; currentZ = preZ2;
				} else if(x > interX && z > preZ1  && x <= preX2  && z <= interZ) {
					currentX = preX2; currentZ = preZ1;
				} else if(x > interX && z > interZ && x <= preX2  && z <= preZ2 ) {
					currentX = preX2; currentZ = preZ2;
				}
				recalc�oords(true, true);
			}
			
			return get(x, z);
		}
	}
	
	/**
	 * ��������������� ��������� ���������� ��� ��������� ������� ��������� �������.
	 * @param doX ������������� �� ��������� ���������� X?
	 * @param doZ ������������� �� ��������� ���������� Z?
	 */
	public void recalc�oords(boolean doX, boolean doZ) {
		if(doX) { currentX0 = currentX - size; currentX1 = currentX + size; }
		if(doZ) { currentZ0 = currentZ - size; currentZ1 = currentZ + size; }
	}
	
	/**
	 * ����� �������� �� �������� "������" ���������� �������: ��� ������� �������� - ������ - ������� ��� �� 4 ����������.
	 * ��� ��������� ��� �������� � ���������� ������� ��������� �� 25-50% ���������� � ����������� � ����� �������.
	 * � ������ ���� ��������� ���� ������ �� ����������� �������, ������ ����� ��������� ��������� ������ ����� ������.
	 * @author VamigA
	 */
	public class SubRegion {
		/** ������ ����������, � ������� � �������� ������ ������. � ���� �������� � ���� ���������. */
		public Object [][] array  ;
		/** �� ������ ����� ������ ������ �� �������� � �������, �������� �� ���� ������. ���� ������ � ���� �� ���� ������. */
		public boolean[][] isValue;
		
		/** �����������. �������������� �������. */
		public SubRegion() {
			array   = new Object [(int)size][(int)size];
			isValue = new boolean[(int)size][(int)size];
		}
		
		/**
		 * ���������, ���� �� ������ � ������ ������ � ������ ��. ���� ��� ������ - ���������� �� ���� � ���������� �� � ������.
		 * @param inSubReg_X ���������� X ������ ����������, �� ���� ������ ������� ����������.
		 * @param inSubReg_Z ���������� Z ������ ����������, �� ���� ������ ������� ����������.
		 * @param x ����� ���������� X. ����� ��� ��������� �� ������� �� ���� ���������� ��� �� ����������.
		 * @param z ����� ���������� Z. ����� ��� ��������� �� ������� �� ���� ���������� ��� �� ����������.
		 * @return ������ ������ ����, ������� ��� ������ ��� �������� ������ ��� ValueType.
		 */
		@SuppressWarnings("unchecked")
		public ValueType returnData(int inSubReg_X, int inSubReg_Z, long x, long z) {
			if(!isValue[inSubReg_X][inSubReg_Z]) {
				isValue[inSubReg_X][inSubReg_Z] = true     ;
				array  [inSubReg_X][inSubReg_Z] = f.g(x, z);
			}
			return (ValueType)array[inSubReg_X][inSubReg_Z];
		}
	}
}