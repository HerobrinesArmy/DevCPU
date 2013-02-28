/**
 */
package devcpu.dASM;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Special Opcode</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see devcpu.dASM.DASMPackage#getSpecialOpcode()
 * @model
 * @generated
 */
public enum SpecialOpcode implements Enumerator
{
  /**
   * The '<em><b>JSR</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #JSR_VALUE
   * @generated
   * @ordered
   */
  JSR(0, "JSR", "JSR"),

  /**
   * The '<em><b>INT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #INT_VALUE
   * @generated
   * @ordered
   */
  INT(1, "INT", "INT"),

  /**
   * The '<em><b>IAG</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #IAG_VALUE
   * @generated
   * @ordered
   */
  IAG(2, "IAG", "IAG"),

  /**
   * The '<em><b>IAS</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #IAS_VALUE
   * @generated
   * @ordered
   */
  IAS(3, "IAS", "IAS"),

  /**
   * The '<em><b>RFI</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #RFI_VALUE
   * @generated
   * @ordered
   */
  RFI(4, "RFI", "RFI"),

  /**
   * The '<em><b>IAQ</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #IAQ_VALUE
   * @generated
   * @ordered
   */
  IAQ(5, "IAQ", "IAQ"),

  /**
   * The '<em><b>HWN</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #HWN_VALUE
   * @generated
   * @ordered
   */
  HWN(6, "HWN", "HWN"),

  /**
   * The '<em><b>HWQ</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #HWQ_VALUE
   * @generated
   * @ordered
   */
  HWQ(7, "HWQ", "HWQ"),

  /**
   * The '<em><b>HWI</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #HWI_VALUE
   * @generated
   * @ordered
   */
  HWI(8, "HWI", "HWI");

  /**
   * The '<em><b>JSR</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>JSR</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #JSR
   * @model
   * @generated
   * @ordered
   */
  public static final int JSR_VALUE = 0;

  /**
   * The '<em><b>INT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>INT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #INT
   * @model
   * @generated
   * @ordered
   */
  public static final int INT_VALUE = 1;

  /**
   * The '<em><b>IAG</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>IAG</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #IAG
   * @model
   * @generated
   * @ordered
   */
  public static final int IAG_VALUE = 2;

  /**
   * The '<em><b>IAS</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>IAS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #IAS
   * @model
   * @generated
   * @ordered
   */
  public static final int IAS_VALUE = 3;

  /**
   * The '<em><b>RFI</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>RFI</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #RFI
   * @model
   * @generated
   * @ordered
   */
  public static final int RFI_VALUE = 4;

  /**
   * The '<em><b>IAQ</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>IAQ</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #IAQ
   * @model
   * @generated
   * @ordered
   */
  public static final int IAQ_VALUE = 5;

  /**
   * The '<em><b>HWN</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>HWN</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #HWN
   * @model
   * @generated
   * @ordered
   */
  public static final int HWN_VALUE = 6;

  /**
   * The '<em><b>HWQ</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>HWQ</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #HWQ
   * @model
   * @generated
   * @ordered
   */
  public static final int HWQ_VALUE = 7;

  /**
   * The '<em><b>HWI</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>HWI</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #HWI
   * @model
   * @generated
   * @ordered
   */
  public static final int HWI_VALUE = 8;

  /**
   * An array of all the '<em><b>Special Opcode</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final SpecialOpcode[] VALUES_ARRAY =
    new SpecialOpcode[]
    {
      JSR,
      INT,
      IAG,
      IAS,
      RFI,
      IAQ,
      HWN,
      HWQ,
      HWI,
    };

  /**
   * A public read-only list of all the '<em><b>Special Opcode</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<SpecialOpcode> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Special Opcode</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static SpecialOpcode get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      SpecialOpcode result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Special Opcode</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static SpecialOpcode getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      SpecialOpcode result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Special Opcode</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static SpecialOpcode get(int value)
  {
    switch (value)
    {
      case JSR_VALUE: return JSR;
      case INT_VALUE: return INT;
      case IAG_VALUE: return IAG;
      case IAS_VALUE: return IAS;
      case RFI_VALUE: return RFI;
      case IAQ_VALUE: return IAQ;
      case HWN_VALUE: return HWN;
      case HWQ_VALUE: return HWQ;
      case HWI_VALUE: return HWI;
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
  private SpecialOpcode(int value, String name, String literal)
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
  
} //SpecialOpcode
