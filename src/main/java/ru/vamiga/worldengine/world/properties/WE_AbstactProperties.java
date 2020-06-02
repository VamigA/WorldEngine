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

import java.util.ArrayList;

import net.minecraft.world.gen.feature.Feature;
import ru.vamiga.worldengine.WorldEngine;
import ru.vamiga.worldengine.world.gen.custom.abstracts.WE_ICreateChunkGen;
import ru.vamiga.worldengine.world.gen.custom.abstracts.WE_ICreateChunkGen_InXYZ;
import ru.vamiga.worldengine.world.gen.custom.abstracts.WE_ICreateChunkGen_InXZ;

/**
 * �����-����� ��� ������� WE_WorldProperties � WE_BiomeProperties. �������� ����������� ��� ��� ����� ������������ ������� - GenReliefConditions.
 * 1) GenReliefConditions � WE_WorldProperties ������� ����������, ����� � ��� �� ������ ������������� �������� �� ������ ����� �������.
 * 2) GenReliefConditions � WE_BiomeProperties ������� ����������, ����� � ��� �� ������ ������������� ���� �� ������ ����� ����-�����.
 * @author VamigA
 */
public abstract class WE_AbstactProperties implements WE_IPropsWithGensAndCons {
	/** ���������� � ������� GenReliefConditions. ����� ������� ����������, ����� � ��� �� ������ ������������� ���� ����� ��� ����. */
	public GenReliefConditions genConditions;
	
	/** ������ ������ ��������� ������: ���������� �� ������ ����. */
	public ArrayList<WE_ICreateChunkGen      > createChunkGen_List      ;
	/** ������ ������ ��������� ������: ���������� �� ������ 256-�������� ���� [X, Z]. */
	public ArrayList<WE_ICreateChunkGen_InXZ > createChunkGen_InXZ_List ;
	/** ������ ������ ��������� ������: ���������� �� ������ ���� [X, Y, Z]. */
	public ArrayList<WE_ICreateChunkGen_InXYZ> createChunkGen_InXYZ_List;
	/** ������ ������ ��������� ������: ����������� ���������� Minecraft Forge. */
	public ArrayList<Feature<?>              > decorateChunkGen_List    ;
	
	/** �������������� ��������� ����������� �����������. */
	public int lastCCG, lastCCGXZ, lastCCGXYZ, lastDCG;
	
	/** �����������. */
	public WE_AbstactProperties() {
		genConditions = new GenReliefConditions();
		
		createChunkGen_List       = new ArrayList<WE_ICreateChunkGen      >();
		createChunkGen_InXZ_List  = new ArrayList<WE_ICreateChunkGen_InXZ >();
		createChunkGen_InXYZ_List = new ArrayList<WE_ICreateChunkGen_InXYZ>();
		decorateChunkGen_List     = new ArrayList<Feature<?>              >();
	}
	
	/**
	 * ��������� ��������� � ������.
	 * @param g ���������.
	 * @return ������������� ���������� � ������.
	 */
	public int addCCG(WE_ICreateChunkGen g) {
		createChunkGen_List.add(g);
		return lastCCG = createChunkGen_List.size() - 1;
	}
	/**
	 * ���������� ��������� ����������� � ������ ���������.
	 * @return ���������.
	 */
	public WE_ICreateChunkGen getLastCCG() {
		return createChunkGen_List.get(lastCCG);
	}
	/** ������� ������ �����������. */
	public void clearCCG() {
		createChunkGen_List.clear();
	}
	
	/**
	 * ��������� ��������� � ������.
	 * @param g ���������.
	 * @return ������������� ���������� � ������.
	 */
	public int addCCGXZ(WE_ICreateChunkGen_InXZ g) {
		createChunkGen_InXZ_List.add(g);
		return lastCCGXZ = createChunkGen_InXZ_List.size() - 1;
	}
	/**
	 * ���������� ��������� ����������� � ������ ���������.
	 * @return ���������.
	 */
	public WE_ICreateChunkGen_InXZ getLastCCGXZ() {
		return createChunkGen_InXZ_List.get(lastCCGXZ);
	}
	/** ������� ������ �����������. */
	public void clearCCGXZ() {
		createChunkGen_InXZ_List.clear();
	}
	
	/**
	 * ��������� ��������� � ������.
	 * @param g ���������.
	 * @return ������������� ���������� � ������.
	 */
	public int addCCGXYZ(WE_ICreateChunkGen_InXYZ g) {
		createChunkGen_InXYZ_List.add(g);
		return lastCCGXYZ = createChunkGen_InXYZ_List.size() - 1;
	}
	/**
	 * ���������� ��������� ����������� � ������ ���������.
	 * @return ���������.
	 */
	public WE_ICreateChunkGen_InXYZ getLastCCGXYZ() {
		return createChunkGen_InXYZ_List.get(lastCCGXYZ);
	}
	/** ������� ������ �����������. */
	public void clearCCGXYZ() {
		createChunkGen_InXYZ_List.clear();
	}
	
	/**
	 * ��������� ��������� � ������.
	 * @param g ���������.
	 * @return ������������� ���������� � ������.
	 */
	public int addDCG(Feature<?> g) {
		decorateChunkGen_List.add(g);
		return lastDCG = decorateChunkGen_List.size() - 1;
	}
	/**
	 * ���������� ��������� ����������� � ������ ���������.
	 * @return ���������.
	 */
	public Feature<?> getLastDCG() {
		return decorateChunkGen_List.get(lastDCG);
	}
	/** ������� ������ �����������. */
	public void clearDCG() {
		decorateChunkGen_List.clear();
	}
	
	/**
	 * ���� ����� ������� ����������, ����� � ��� �� ������ ������������� ���� ����� ��� ����. GenReliefConditions = ������������ ������ ����������� "if".
	 * @author VamigA
	 */
	public class GenReliefConditions implements IGenReliefConditions {
		/** ������ � ������������ ���������. */
		public ArrayList<PrimitiveCondition> conditions;
		/** �������� ����� ������������ ��������� (0: [&&]; 1: [||]). */
		public ArrayList<Byte              >    actions;
		/** ��������� ��� ����������. */
		public static final byte
			RC_ACTION_AND = 0,
			RC_ACTION_OR  = 1;
		
		/** ������������� ���������� ������������ �������. */
		public int lastCon;
		
		/** �����������. */
		public GenReliefConditions() {
			conditions = new ArrayList<PrimitiveCondition>(); actions = new ArrayList<Byte>();
		}
		
		/**
		 * ��������� ����������� �������.
		 * @param action �������� ����� ����� ��������������� �������������.
		 * @return ������������� � ������.
		 */
		public int addCon(byte action) {
			conditions.add(new PrimitiveCondition(action));
			return lastCon = conditions.size() - 1;
		}
		/**
		 * ���������� ��������� ����������� � ������ �������.
		 * @return ����������� �������.
		 */
		public PrimitiveCondition getLast() {
			return conditions.get(lastCon);
		}
		/** ������� ������ �������. */
		public void clearCon() {
			conditions.clear();
		}
		
		/**
		 * ��������� ��������. ���������� �������� ������ ���� ([���������� �������] - 1).
		 * @param a ��������.
		 */
		public void addAct(byte a) {
			if(actions.size() > conditions.size() - 2) {
				WorldEngine.log("[ERROR] GenReliefConditions.addAct(byte a): quantity of the actions must be ([conditions quantity] - 1).");
				throw new IllegalArgumentException("GenReliefConditions.addAct(byte a): quantity of the actions must be ([conditions quantity] - 1).");
			}else
				actions.add(a);
		}
		/** ������� ������ ��������. */
		public void clearAct() {
			actions.clear();
		}
		
		/**
		 * ��������� ��� ����������� �������. ���������� ������� �������! �������:
		 * (((conditions[0] *actions[0]* conditions[1]) *actions[1]* conditions[2]) *actions[2]* conditions[3]) *actions[3]* conditions[4]...
		 * ��� �� ������, ��� ������� �� ��������� ����������� ��������� ���������� ��������.
		 * @param rLayersDataFromGen ������ ������ ����� ������� ��� ����-����� � ���������� ��� ������ MathConstruction. ������� ����� ������� �������� �������������� ������ ����� ������� ��� ����-�����.
		 *        � WE_WorldProperties ��� ���� ������ ������� � ����� (rLayersDataFromGen[����������_�����]) ������������ ��� �������� ������ ���������.
		 * @return ��������� �������� �������.
		 */
		@Override
		public boolean go(int[] rLayersDataFromGen) {
			boolean res = conditions.get(0).go(rLayersDataFromGen);
			for(int i = 0; i < actions.size(); i++)
				switch(actions.get(i)) {
				case 0: res &= conditions.get(i + 1).go(rLayersDataFromGen); break;
				case 1: res |= conditions.get(i + 1).go(rLayersDataFromGen);
				}
			return res;
		}
		
		/**
		 * ����� ��� ������������ ����������� �������, ������� *MathConstruction* [��������] *MathConstruction*.
		 * @author VamigA
		 */
		public class PrimitiveCondition {
			/** ������ � 2 ���������� - ��������������� ������������� ��� ���������. */
			public MathConstruction[] twoMathConstructions;
			/** ������������ �������� ����� 2 ��������������� ������������� (0: [<]; 1: [<=]; 2: [==]; 3: [!=]; 4: [>=]; 5: [>]). */
			public byte actionBetweenThem;
			/** ��������� ��� ����������. */
			public static final byte
				PC_ACTION_LESS      = 0,
				PC_ACTION_LESSEQUAL = 1,
				PC_ACTION_EQUAL     = 2,
				PC_ACTION_NOTEQUAL  = 3,
				PC_ACTION_MOREEQUAL = 4,
				PC_ACTION_MORE      = 5;
			
			/**
			 * �����������.
			 * @param action �������� ����� 2 ��������������� �������������.
			 */
			public PrimitiveCondition(byte action) {
				twoMathConstructions = new MathConstruction[2];
				twoMathConstructions[0] = new MathConstruction(); actionBetweenThem = action; twoMathConstructions[1] = new MathConstruction();
			}
			
			/**
			 * ������ ����� MathConstruction.
			 * @return �������� twoMathConstructions[0].
			 */
			public MathConstruction getFirstMath() {
				return twoMathConstructions[0];
			}
			/**
			 * ������ ����� MathConstruction.
			 * @return �������� twoMathConstructions[1].
			 */
			public MathConstruction getSecondMath() {
				return twoMathConstructions[1];
			}
			
			/**
			 * ��������� ����������� �������.
			 * @param rLayersDataFromGen ������ ������ ����� ������� ��� ����-����� � ���������� ��� ������ MathConstruction. ������� ����� ������� �������� �������������� ������ ����� ������� ��� ����-�����.
			 *        � WE_WorldProperties ��� ���� ������ ������� � ����� (rLayersDataFromGen[����������_�����]) ������������ ��� �������� ������ ���������.
			 * @return ��������� �������.
			 */
			public boolean go(int[] rLayersDataFromGen) {
				switch(actionBetweenThem) {
				case 0: return twoMathConstructions[0].go(rLayersDataFromGen) <  twoMathConstructions[1].go(rLayersDataFromGen);
				case 1: return twoMathConstructions[0].go(rLayersDataFromGen) <= twoMathConstructions[1].go(rLayersDataFromGen);
				case 2: return twoMathConstructions[0].go(rLayersDataFromGen) == twoMathConstructions[1].go(rLayersDataFromGen);
				case 3: return twoMathConstructions[0].go(rLayersDataFromGen) != twoMathConstructions[1].go(rLayersDataFromGen);
				case 4: return twoMathConstructions[0].go(rLayersDataFromGen) >= twoMathConstructions[1].go(rLayersDataFromGen);
				case 5: return twoMathConstructions[0].go(rLayersDataFromGen) >  twoMathConstructions[1].go(rLayersDataFromGen);
				default: return false;
				}
			}
			
			/**
			 * ����� ��� ������������ �������������� �����������. ��� ����������� �����������.
			 * @author VamigA
			 */
			public class MathConstruction {
				/** ����� ��� ��������. ��� ����� ����� ����� ��� ����� ReliefLayerData (������ ������ ����� ����������� ������ ������ ����� ������� ��� ����-����� �� [X, Y]). */
				public ArrayList<Object> numbers;
				/** �������� ����� ������� (0: [*]; 1: [/]; 2: [%]; 3: [+]; 4: [-]; 5: [<<]; 6: [>>]; 7: [&]; 8: [^]; 9: [|]). �� ���������� ������ ���� ([���������� �����] - 1). */
				public ArrayList<Byte  > actions;
				/** ��������� ��� ����������. */
				public static final byte
					MC_ACTION_MULTIPLY   = 0,
					MC_ACTION_DIVIDE     = 1,
					MC_ACTION_DIVIDEMOD  = 2,
					MC_ACTION_ADD        = 3,
					MC_ACTION_SUBTRACT   = 4,
					MC_ACTION_SHIFTLEFT  = 5,
					MC_ACTION_SHIFTRIGHT = 6,
					MC_ACTION_BITAND     = 7,
					MC_ACTION_BITXOR     = 8,
					MC_ACTION_BITOR      = 9;
				
				/** �����������. */
				public MathConstruction() {
					numbers = new ArrayList<Object>(); actions = new ArrayList<Byte>();
				}
				
				/**
				 * ��������� �����.
				 * @param n �����.
				 * @param isIdForData �������� �� ��� ����� ��������������� ���� ������� ��� ����-�����?
				 */
				public void addNum(int n, boolean isIdForData) {
					if(isIdForData)
						numbers.add(new ReliefLayerData(n));
					else
						numbers.add(                    n );
				}
				/** ������� ������ �����. */
				public void clearNum() {
					numbers.clear();
				}
				
				/**
				 * ��������� ��������. ���������� �������� ������ ���� ([���������� �����] - 1).
				 * @param a ��������.
				 */
				public void addAct(byte a) {
					if(actions.size() > numbers.size() - 2) {
						WorldEngine.log("[ERROR] MathConstruction.addAct(byte a): quantity of the actions must be ([numbers quantity] - 1).");
						throw new IllegalArgumentException("MathConstruction.addAct(byte a): quantity of the actions must be ([numbers quantity] - 1).");
					}else
						actions.add(a);
				}
				/** ������� ������ ��������. */
				public void clearAct() {
					actions.clear();
				}
				
				/**
				 * ���������� ����� �������� � ������� "�����". ����� ����� ������� ������ ������ ReliefLayerData � ���.
				 * @param i ������ "�����" � �������.
				 * @param rLayersDataFromGen ������ ������ ����� ������� ��� ����-����� � ����������. ������� ����� ������� �������� �������������� ������ ����� ������� ��� ����-�����.
				 *        � WE_WorldProperties ��� ���� ������ ������� � ����� (rLayersDataFromGen[����������_�����]) ������������ ��� �������� ������ ���������.
				 * @return ������ �����.
				 */
				public int getNumber(int i, int[] rLayersDataFromGen) {
					if(numbers.get(i).getClass() == ReliefLayerData.class)
						return rLayersDataFromGen[((ReliefLayerData)numbers.get(i)).layerID];
					else
						return (int)numbers.get(i);
				}
				
				/**
				 * ��������� ��� �������������� �������� � ������� � ���� �������������� �����������. �������:
				 * (((numbers[0] *actions[0]* numbers[1]) *actions[1]* numbers[2]) *actions[2]* numbers[3]) *actions[3]* numbers[4]...
				 * ��� �� ������, ��� ������� �� ��������� ����������� ��������� �������������� ��������.
				 * @param rLayersDataFromGen ������ ������ ����� ������� ��� ����-����� � ����������. ������� ����� ������� �������� �������������� ������ ����� ������� ��� ����-�����.
				 *        � WE_WorldProperties ��� ���� ������ ������� � ����� (rLayersDataFromGen[����������_�����]) ������������ ��� �������� ������ ���������.
				 * @return ��������� �������������� ��������.
				 */
				public int go(int[] rLayersDataFromGen) {
					int res = getNumber(0, rLayersDataFromGen);
					for(int i = 0; i < actions.size(); i++)
						switch(actions.get(i)) {
						case 0: res  *= getNumber(i + 1, rLayersDataFromGen); break;
						case 1: res  /= getNumber(i + 1, rLayersDataFromGen); break;
						case 2: res  %= getNumber(i + 1, rLayersDataFromGen); break;
						case 3: res  += getNumber(i + 1, rLayersDataFromGen); break;
						case 4: res  -= getNumber(i + 1, rLayersDataFromGen); break;
						case 5: res <<= getNumber(i + 1, rLayersDataFromGen); break;
						case 6: res >>= getNumber(i + 1, rLayersDataFromGen); break;
						case 7: res  &= getNumber(i + 1, rLayersDataFromGen); break;
						case 8: res  ^= getNumber(i + 1, rLayersDataFromGen); break;
						case 9: res  |= getNumber(i + 1, rLayersDataFromGen);
						}
					return res;
				}
				
				/**
				 * ��� ��������� �����, ������� ������� MathConstruction, ��� numbers[i] � ��� - ��� ������ ������ ������ ���� ������� ��� ����-�����.
				 * � WE_WorldProperties ��� ���� ������ ������� � ����� ������������ ��� �������� ������ ���������.
				 * @author VamigA
				 */
				public class ReliefLayerData {
					/**
					 * ����������� ������������� ���� ������� ��� ����-����� � ����������, � ������� "reliefLayers" ��� "bMapLayers".
					 * � WE_WorldProperties ��� ���� ������ ������� � ����� (layerID = ���������� �����) ������������ ��� �������� ������ ���������.
					 */
					public int layerID;
					
					/**
					 * �����������.
					 * @param id ����������� ������������� ���� ������� ��� ����-�����. ��� ����� ���� ������ ������ ���� �����.
					 *        � WE_WorldProperties ��� ���� ������ ������� � ����� (id = ���������� �����) ������������ ��� �������� ������ ���������.
					 */
					public ReliefLayerData(int id) {
						layerID = id;
					}
				}
			}
		}
	}
	
	/**
	 * ���������� WE_ICreateChunkGen �� �������������� [i].
	 * @param i �������������.
	 * @return WE_ICreateChunkGen - ���������.
	 */
	@Override
	public WE_ICreateChunkGen getCreateChunkGen(int i) {
		return createChunkGen_List.get(i);
	}
	/**
	 * ���������� ���������� ��������� � ������ �����������: WE_ICreateChunkGen.
	 * @return ������ ������.
	 */
	@Override
	public int sizeofCreateChunkGen() {
		return createChunkGen_List.size();
	}
	
	/**
	 * ���������� WE_ICreateChunkGen_InXZ �� �������������� [i].
	 * @param i �������������.
	 * @return WE_ICreateChunkGen_InXZ - ���������.
	 */
	@Override
	public WE_ICreateChunkGen_InXZ getCreateChunkGenInXZ(int i) {
		return createChunkGen_InXZ_List.get(i);
	}
	/**
	 * ���������� ���������� ��������� � ������ �����������: WE_ICreateChunkGen_InXZ.
	 * @return ������ ������.
	 */
	@Override
	public int sizeofCreateChunkGenInXZ() {
		return createChunkGen_InXZ_List.size();
	}
	
	/**
	 * ���������� WE_ICreateChunkGen_InXYZ �� �������������� [i].
	 * @param i �������������.
	 * @return WE_ICreateChunkGen_InXYZ - ���������.
	 */
	@Override
	public WE_ICreateChunkGen_InXYZ getCreateChunkGenInXYZ(int i) {
		return createChunkGen_InXYZ_List.get(i);
	}
	/**
	 * ���������� ���������� ��������� � ������ �����������: WE_ICreateChunkGen_InXYZ.
	 * @return ������ ������.
	 */
	@Override
	public int sizeofCreateChunkGenInXYZ() {
		return createChunkGen_InXYZ_List.size();
	}
	
	/**
	 * ���������� Feature<?> �� �������������� [i].
	 * @param i �������������.
	 * @return Feature<?> - ���������.
	 */
	@Override
	public Feature<?> getDecorateChunkGen(int i) {
		return decorateChunkGen_List.get(i);
	}
	/**
	 * ���������� ���������� ��������� � ������ �����������: Feature<?>.
	 * @return ������ ������.
	 */
	@Override
	public int sizeofDecorateChunkGen() {
		return decorateChunkGen_List.size();
	}
	
	/**
	 * ���������� IGenReliefConditions ��� ����� ���� (��� ���� ����������).
	 * @return IGenReliefConditions - ������� ���������.
	 */
	@Override
	public IGenReliefConditions getLayersConditions() {
		return genConditions;
	}
}