/**
 */
package devcpu.dASM;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Standard Register</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see devcpu.dASM.DASMPackage#getStandardRegister()
 * @model
 * @generated
 */
public enum StandardRegister implements Enumerator
{
  /**
   * The '<em><b>A</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #A_VALUE
   * @generated
   * @ordered
   */
  A(0, "A", "A"),

  /**
   * The '<em><b>B</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #B_VALUE
   * @generated
   * @ordered
   */
  B(1, "B", "B"),

  /**
   * The '<em><b>C</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #C_VALUE
   * @generated
   * @ordered
   */
  C(2, "C", "C"),

  /**
   * The '<em><b>X</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #X_VALUE
   * @generated
   * @ordered
   */
  X(3, "X", "X"),

  /**
   * The '<em><b>Y</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #Y_VALUE
   * @generated
   * @ordered
   */
  Y(4, "Y", "Y"),

  /**
   * The '<em><b>Z</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #Z_VALUE
   * @generated
   * @ordered
   */
  Z(5, "Z", "Z"),

  /**
   * The '<em><b>I</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #I_VALUE
   * @generated
   * @ordered
   */
  I(6, "I", "I"),

  /**
   * The '<em><b>J</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #J_VALUE
   * @generated
   * @ordered
   */
  J(7, "J", "J");

  /**
   * The '<em><b>A</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>A</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #A
   * @model
   * @generated
   * @ordered
   */
  public static final int A_VALUE = 0;

  /**
   * The '<em><b>B</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>B</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #B
   * @model
   * @generated
   * @ordered
   */
  public static final int B_VALUE = 1;

  /**
   * The '<em><b>C</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>C</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #C
   * @model
   * @generated
   * @ordered
   */
  public static final int C_VALUE = 2;

  /**
   * The '<em><b>X</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>X</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #X
   * @model
   * @generated
   * @ordered
   */
  public static final int X_VALUE = 3;

  /**
   * The '<em><b>Y</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Y</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #Y
   * @model
   * @generated
   * @ordered
   */
  public static final int Y_VALUE = 4;

  /**
   * The '<em><b>Z</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Z</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #Z
   * @model
   * @generated
   * @ordered
   */
  public static final int Z_VALUE = 5;

  /**
   * The '<em><b>I</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>I</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #I
   * @model
   * @generated
   * @ordered
   */
  public static final int I_VALUE = 6;

  /**
   * The '<em><b>J</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>J</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #J
   * @model
   * @generated
   * @ordered
   */
  public static final int J_VALUE = 7;

  /**
   * An array of all the '<em><b>Standard Register</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final StandardRegister[] VALUES_ARRAY =
    new StandardRegister[]
    {
      A,
      B,
      C,
      X,
      Y,
      Z,
      I,
      J,
    };

  /**
   * A public read-only list of all the '<em><b>Standard Register</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<StandardRegister> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Standard Register</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static StandardRegister get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      StandardRegister result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Standard Register</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static StandardRegister getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      StandardRegister result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Standard Register</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static StandardRegister get(int value)
  {
    switch (value)
    {
      case A_VALUE: return A;
      case B_VALUE: return B;
      case C_VALUE: return C;
      case X_VALUE: return X;
      case Y_VALUE: return Y;
      case Z_VALUE: return Z;
      case I_VALUE: return I;
      case J_VALUE: return J;
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
  private StandardRegister(int value, String name, String literal)
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
  
} //StandardRegister
