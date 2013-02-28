/**
 */
package devcpu.dASM;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Basic Opcode</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see devcpu.dASM.DASMPackage#getBasicOpcode()
 * @model
 * @generated
 */
public enum BasicOpcode implements Enumerator
{
  /**
   * The '<em><b>SET</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SET_VALUE
   * @generated
   * @ordered
   */
  SET(0, "SET", "SET"),

  /**
   * The '<em><b>ADD</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ADD_VALUE
   * @generated
   * @ordered
   */
  ADD(1, "ADD", "ADD"),

  /**
   * The '<em><b>SUB</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SUB_VALUE
   * @generated
   * @ordered
   */
  SUB(2, "SUB", "SUB"),

  /**
   * The '<em><b>MUL</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MUL_VALUE
   * @generated
   * @ordered
   */
  MUL(3, "MUL", "MUL"),

  /**
   * The '<em><b>MLI</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MLI_VALUE
   * @generated
   * @ordered
   */
  MLI(4, "MLI", "MLI"),

  /**
   * The '<em><b>DIV</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #DIV_VALUE
   * @generated
   * @ordered
   */
  DIV(5, "DIV", "DIV"),

  /**
   * The '<em><b>DVI</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #DVI_VALUE
   * @generated
   * @ordered
   */
  DVI(6, "DVI", "DVI"),

  /**
   * The '<em><b>MOD</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MOD_VALUE
   * @generated
   * @ordered
   */
  MOD(7, "MOD", "MOD"),

  /**
   * The '<em><b>MDI</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MDI_VALUE
   * @generated
   * @ordered
   */
  MDI(8, "MDI", "MDI"),

  /**
   * The '<em><b>AND</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #AND_VALUE
   * @generated
   * @ordered
   */
  AND(9, "AND", "AND"),

  /**
   * The '<em><b>BOR</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #BOR_VALUE
   * @generated
   * @ordered
   */
  BOR(10, "BOR", "BOR"),

  /**
   * The '<em><b>XOR</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #XOR_VALUE
   * @generated
   * @ordered
   */
  XOR(11, "XOR", "XOR"),

  /**
   * The '<em><b>SHR</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SHR_VALUE
   * @generated
   * @ordered
   */
  SHR(12, "SHR", "SHR"),

  /**
   * The '<em><b>ASR</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ASR_VALUE
   * @generated
   * @ordered
   */
  ASR(13, "ASR", "ASR"),

  /**
   * The '<em><b>SHL</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SHL_VALUE
   * @generated
   * @ordered
   */
  SHL(14, "SHL", "SHL"),

  /**
   * The '<em><b>IFB</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #IFB_VALUE
   * @generated
   * @ordered
   */
  IFB(15, "IFB", "IFB"),

  /**
   * The '<em><b>IFC</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #IFC_VALUE
   * @generated
   * @ordered
   */
  IFC(16, "IFC", "IFC"),

  /**
   * The '<em><b>IFE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #IFE_VALUE
   * @generated
   * @ordered
   */
  IFE(17, "IFE", "IFE"),

  /**
   * The '<em><b>IFN</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #IFN_VALUE
   * @generated
   * @ordered
   */
  IFN(18, "IFN", "IFN"),

  /**
   * The '<em><b>IFG</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #IFG_VALUE
   * @generated
   * @ordered
   */
  IFG(19, "IFG", "IFG"),

  /**
   * The '<em><b>IFA</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #IFA_VALUE
   * @generated
   * @ordered
   */
  IFA(20, "IFA", "IFA"),

  /**
   * The '<em><b>IFL</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #IFL_VALUE
   * @generated
   * @ordered
   */
  IFL(21, "IFL", "IFL"),

  /**
   * The '<em><b>IFU</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #IFU_VALUE
   * @generated
   * @ordered
   */
  IFU(22, "IFU", "IFU"),

  /**
   * The '<em><b>ADX</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ADX_VALUE
   * @generated
   * @ordered
   */
  ADX(23, "ADX", "ADX"),

  /**
   * The '<em><b>SBX</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SBX_VALUE
   * @generated
   * @ordered
   */
  SBX(24, "SBX", "SBX"),

  /**
   * The '<em><b>STI</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #STI_VALUE
   * @generated
   * @ordered
   */
  STI(25, "STI", "STI"),

  /**
   * The '<em><b>STD</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #STD_VALUE
   * @generated
   * @ordered
   */
  STD(26, "STD", "STD");

  /**
   * The '<em><b>SET</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>SET</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #SET
   * @model
   * @generated
   * @ordered
   */
  public static final int SET_VALUE = 0;

  /**
   * The '<em><b>ADD</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>ADD</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ADD
   * @model
   * @generated
   * @ordered
   */
  public static final int ADD_VALUE = 1;

  /**
   * The '<em><b>SUB</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>SUB</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #SUB
   * @model
   * @generated
   * @ordered
   */
  public static final int SUB_VALUE = 2;

  /**
   * The '<em><b>MUL</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>MUL</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #MUL
   * @model
   * @generated
   * @ordered
   */
  public static final int MUL_VALUE = 3;

  /**
   * The '<em><b>MLI</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>MLI</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #MLI
   * @model
   * @generated
   * @ordered
   */
  public static final int MLI_VALUE = 4;

  /**
   * The '<em><b>DIV</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>DIV</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #DIV
   * @model
   * @generated
   * @ordered
   */
  public static final int DIV_VALUE = 5;

  /**
   * The '<em><b>DVI</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>DVI</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #DVI
   * @model
   * @generated
   * @ordered
   */
  public static final int DVI_VALUE = 6;

  /**
   * The '<em><b>MOD</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>MOD</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #MOD
   * @model
   * @generated
   * @ordered
   */
  public static final int MOD_VALUE = 7;

  /**
   * The '<em><b>MDI</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>MDI</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #MDI
   * @model
   * @generated
   * @ordered
   */
  public static final int MDI_VALUE = 8;

  /**
   * The '<em><b>AND</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>AND</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #AND
   * @model
   * @generated
   * @ordered
   */
  public static final int AND_VALUE = 9;

  /**
   * The '<em><b>BOR</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>BOR</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #BOR
   * @model
   * @generated
   * @ordered
   */
  public static final int BOR_VALUE = 10;

  /**
   * The '<em><b>XOR</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>XOR</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #XOR
   * @model
   * @generated
   * @ordered
   */
  public static final int XOR_VALUE = 11;

  /**
   * The '<em><b>SHR</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>SHR</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #SHR
   * @model
   * @generated
   * @ordered
   */
  public static final int SHR_VALUE = 12;

  /**
   * The '<em><b>ASR</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>ASR</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ASR
   * @model
   * @generated
   * @ordered
   */
  public static final int ASR_VALUE = 13;

  /**
   * The '<em><b>SHL</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>SHL</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #SHL
   * @model
   * @generated
   * @ordered
   */
  public static final int SHL_VALUE = 14;

  /**
   * The '<em><b>IFB</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>IFB</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #IFB
   * @model
   * @generated
   * @ordered
   */
  public static final int IFB_VALUE = 15;

  /**
   * The '<em><b>IFC</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>IFC</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #IFC
   * @model
   * @generated
   * @ordered
   */
  public static final int IFC_VALUE = 16;

  /**
   * The '<em><b>IFE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>IFE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #IFE
   * @model
   * @generated
   * @ordered
   */
  public static final int IFE_VALUE = 17;

  /**
   * The '<em><b>IFN</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>IFN</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #IFN
   * @model
   * @generated
   * @ordered
   */
  public static final int IFN_VALUE = 18;

  /**
   * The '<em><b>IFG</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>IFG</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #IFG
   * @model
   * @generated
   * @ordered
   */
  public static final int IFG_VALUE = 19;

  /**
   * The '<em><b>IFA</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>IFA</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #IFA
   * @model
   * @generated
   * @ordered
   */
  public static final int IFA_VALUE = 20;

  /**
   * The '<em><b>IFL</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>IFL</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #IFL
   * @model
   * @generated
   * @ordered
   */
  public static final int IFL_VALUE = 21;

  /**
   * The '<em><b>IFU</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>IFU</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #IFU
   * @model
   * @generated
   * @ordered
   */
  public static final int IFU_VALUE = 22;

  /**
   * The '<em><b>ADX</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>ADX</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ADX
   * @model
   * @generated
   * @ordered
   */
  public static final int ADX_VALUE = 23;

  /**
   * The '<em><b>SBX</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>SBX</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #SBX
   * @model
   * @generated
   * @ordered
   */
  public static final int SBX_VALUE = 24;

  /**
   * The '<em><b>STI</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>STI</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #STI
   * @model
   * @generated
   * @ordered
   */
  public static final int STI_VALUE = 25;

  /**
   * The '<em><b>STD</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>STD</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #STD
   * @model
   * @generated
   * @ordered
   */
  public static final int STD_VALUE = 26;

  /**
   * An array of all the '<em><b>Basic Opcode</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final BasicOpcode[] VALUES_ARRAY =
    new BasicOpcode[]
    {
      SET,
      ADD,
      SUB,
      MUL,
      MLI,
      DIV,
      DVI,
      MOD,
      MDI,
      AND,
      BOR,
      XOR,
      SHR,
      ASR,
      SHL,
      IFB,
      IFC,
      IFE,
      IFN,
      IFG,
      IFA,
      IFL,
      IFU,
      ADX,
      SBX,
      STI,
      STD,
    };

  /**
   * A public read-only list of all the '<em><b>Basic Opcode</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<BasicOpcode> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Basic Opcode</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static BasicOpcode get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      BasicOpcode result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Basic Opcode</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static BasicOpcode getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      BasicOpcode result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Basic Opcode</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static BasicOpcode get(int value)
  {
    switch (value)
    {
      case SET_VALUE: return SET;
      case ADD_VALUE: return ADD;
      case SUB_VALUE: return SUB;
      case MUL_VALUE: return MUL;
      case MLI_VALUE: return MLI;
      case DIV_VALUE: return DIV;
      case DVI_VALUE: return DVI;
      case MOD_VALUE: return MOD;
      case MDI_VALUE: return MDI;
      case AND_VALUE: return AND;
      case BOR_VALUE: return BOR;
      case XOR_VALUE: return XOR;
      case SHR_VALUE: return SHR;
      case ASR_VALUE: return ASR;
      case SHL_VALUE: return SHL;
      case IFB_VALUE: return IFB;
      case IFC_VALUE: return IFC;
      case IFE_VALUE: return IFE;
      case IFN_VALUE: return IFN;
      case IFG_VALUE: return IFG;
      case IFA_VALUE: return IFA;
      case IFL_VALUE: return IFL;
      case IFU_VALUE: return IFU;
      case ADX_VALUE: return ADX;
      case SBX_VALUE: return SBX;
      case STI_VALUE: return STI;
      case STD_VALUE: return STD;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final int value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String name;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String literal;

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private BasicOpcode(int value, String name, String literal)
  {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLiteral()
  {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    return literal;
  }
  
} //BasicOpcode
