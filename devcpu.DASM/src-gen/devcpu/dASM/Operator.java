/**
 */
package devcpu.dASM;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Operator</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see devcpu.dASM.DASMPackage#getOperator()
 * @model
 * @generated
 */
public enum Operator implements Enumerator
{
  /**
   * The '<em><b>ADD</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ADD_VALUE
   * @generated
   * @ordered
   */
  ADD(0, "ADD", "+"),

  /**
   * The '<em><b>SUBTRACT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SUBTRACT_VALUE
   * @generated
   * @ordered
   */
  SUBTRACT(1, "SUBTRACT", "-"),

  /**
   * The '<em><b>MULTIPLY</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MULTIPLY_VALUE
   * @generated
   * @ordered
   */
  MULTIPLY(2, "MULTIPLY", "*"),

  /**
   * The '<em><b>DIVIDE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #DIVIDE_VALUE
   * @generated
   * @ordered
   */
  DIVIDE(3, "DIVIDE", "/"),

  /**
   * The '<em><b>MODULUS</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MODULUS_VALUE
   * @generated
   * @ordered
   */
  MODULUS(4, "MODULUS", "%"),

  /**
   * The '<em><b>LEFT SHIFT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #LEFT_SHIFT_VALUE
   * @generated
   * @ordered
   */
  LEFT_SHIFT(5, "LEFT_SHIFT", "<<"),

  /**
   * The '<em><b>ARITHMETIC RIGHT SHIFT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ARITHMETIC_RIGHT_SHIFT_VALUE
   * @generated
   * @ordered
   */
  ARITHMETIC_RIGHT_SHIFT(6, "ARITHMETIC_RIGHT_SHIFT", ">>"),

  /**
   * The '<em><b>LOGICAL RIGHT SHIFT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #LOGICAL_RIGHT_SHIFT_VALUE
   * @generated
   * @ordered
   */
  LOGICAL_RIGHT_SHIFT(7, "LOGICAL_RIGHT_SHIFT", ">>>"),

  /**
   * The '<em><b>BITWISE AND</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #BITWISE_AND_VALUE
   * @generated
   * @ordered
   */
  BITWISE_AND(8, "BITWISE_AND", "&"),

  /**
   * The '<em><b>BITWISE OR</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #BITWISE_OR_VALUE
   * @generated
   * @ordered
   */
  BITWISE_OR(9, "BITWISE_OR", "|"),

  /**
   * The '<em><b>BITWISE XOR</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #BITWISE_XOR_VALUE
   * @generated
   * @ordered
   */
  BITWISE_XOR(10, "BITWISE_XOR", "^"),

  /**
   * The '<em><b>BITWISE NOT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #BITWISE_NOT_VALUE
   * @generated
   * @ordered
   */
  BITWISE_NOT(11, "BITWISE_NOT", "~"),

  /**
   * The '<em><b>LOGICAL NOT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #LOGICAL_NOT_VALUE
   * @generated
   * @ordered
   */
  LOGICAL_NOT(12, "LOGICAL_NOT", "!"),

  /**
   * The '<em><b>EQUAL</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #EQUAL_VALUE
   * @generated
   * @ordered
   */
  EQUAL(13, "EQUAL", "=="),

  /**
   * The '<em><b>NOT EQUAL</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #NOT_EQUAL_VALUE
   * @generated
   * @ordered
   */
  NOT_EQUAL(14, "NOT_EQUAL", "!="),

  /**
   * The '<em><b>GREATER</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #GREATER_VALUE
   * @generated
   * @ordered
   */
  GREATER(15, "GREATER", ">"),

  /**
   * The '<em><b>GREATER OR EQUAL</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #GREATER_OR_EQUAL_VALUE
   * @generated
   * @ordered
   */
  GREATER_OR_EQUAL(16, "GREATER_OR_EQUAL", ">="),

  /**
   * The '<em><b>LESS</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #LESS_VALUE
   * @generated
   * @ordered
   */
  LESS(17, "LESS", "<"),

  /**
   * The '<em><b>LESS OR EQUAL</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #LESS_OR_EQUAL_VALUE
   * @generated
   * @ordered
   */
  LESS_OR_EQUAL(18, "LESS_OR_EQUAL", "<="),

  /**
   * The '<em><b>LOGICAL AND</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #LOGICAL_AND_VALUE
   * @generated
   * @ordered
   */
  LOGICAL_AND(19, "LOGICAL_AND", "&&"),

  /**
   * The '<em><b>LOGICAL OR</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #LOGICAL_OR_VALUE
   * @generated
   * @ordered
   */
  LOGICAL_OR(20, "LOGICAL_OR", "||"),

  /**
   * The '<em><b>CONDITIONAL TRUE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #CONDITIONAL_TRUE_VALUE
   * @generated
   * @ordered
   */
  CONDITIONAL_TRUE(21, "CONDITIONAL_TRUE", "?"),

  /**
   * The '<em><b>CONDITIONAL FALSE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #CONDITIONAL_FALSE_VALUE
   * @generated
   * @ordered
   */
  CONDITIONAL_FALSE(22, "CONDITIONAL_FALSE", ":");

  /**
   * The '<em><b>ADD</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>ADD</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ADD
   * @model literal="+"
   * @generated
   * @ordered
   */
  public static final int ADD_VALUE = 0;

  /**
   * The '<em><b>SUBTRACT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>SUBTRACT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #SUBTRACT
   * @model literal="-"
   * @generated
   * @ordered
   */
  public static final int SUBTRACT_VALUE = 1;

  /**
   * The '<em><b>MULTIPLY</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>MULTIPLY</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #MULTIPLY
   * @model literal="*"
   * @generated
   * @ordered
   */
  public static final int MULTIPLY_VALUE = 2;

  /**
   * The '<em><b>DIVIDE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>DIVIDE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #DIVIDE
   * @model literal="/"
   * @generated
   * @ordered
   */
  public static final int DIVIDE_VALUE = 3;

  /**
   * The '<em><b>MODULUS</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>MODULUS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #MODULUS
   * @model literal="%"
   * @generated
   * @ordered
   */
  public static final int MODULUS_VALUE = 4;

  /**
   * The '<em><b>LEFT SHIFT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>LEFT SHIFT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #LEFT_SHIFT
   * @model literal="<<"
   * @generated
   * @ordered
   */
  public static final int LEFT_SHIFT_VALUE = 5;

  /**
   * The '<em><b>ARITHMETIC RIGHT SHIFT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>ARITHMETIC RIGHT SHIFT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ARITHMETIC_RIGHT_SHIFT
   * @model literal=">>"
   * @generated
   * @ordered
   */
  public static final int ARITHMETIC_RIGHT_SHIFT_VALUE = 6;

  /**
   * The '<em><b>LOGICAL RIGHT SHIFT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>LOGICAL RIGHT SHIFT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #LOGICAL_RIGHT_SHIFT
   * @model literal=">>>"
   * @generated
   * @ordered
   */
  public static final int LOGICAL_RIGHT_SHIFT_VALUE = 7;

  /**
   * The '<em><b>BITWISE AND</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>BITWISE AND</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #BITWISE_AND
   * @model literal="&"
   * @generated
   * @ordered
   */
  public static final int BITWISE_AND_VALUE = 8;

  /**
   * The '<em><b>BITWISE OR</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>BITWISE OR</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #BITWISE_OR
   * @model literal="|"
   * @generated
   * @ordered
   */
  public static final int BITWISE_OR_VALUE = 9;

  /**
   * The '<em><b>BITWISE XOR</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>BITWISE XOR</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #BITWISE_XOR
   * @model literal="^"
   * @generated
   * @ordered
   */
  public static final int BITWISE_XOR_VALUE = 10;

  /**
   * The '<em><b>BITWISE NOT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>BITWISE NOT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #BITWISE_NOT
   * @model literal="~"
   * @generated
   * @ordered
   */
  public static final int BITWISE_NOT_VALUE = 11;

  /**
   * The '<em><b>LOGICAL NOT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>LOGICAL NOT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #LOGICAL_NOT
   * @model literal="!"
   * @generated
   * @ordered
   */
  public static final int LOGICAL_NOT_VALUE = 12;

  /**
   * The '<em><b>EQUAL</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>EQUAL</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #EQUAL
   * @model literal="=="
   * @generated
   * @ordered
   */
  public static final int EQUAL_VALUE = 13;

  /**
   * The '<em><b>NOT EQUAL</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>NOT EQUAL</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #NOT_EQUAL
   * @model literal="!="
   * @generated
   * @ordered
   */
  public static final int NOT_EQUAL_VALUE = 14;

  /**
   * The '<em><b>GREATER</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>GREATER</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #GREATER
   * @model literal=">"
   * @generated
   * @ordered
   */
  public static final int GREATER_VALUE = 15;

  /**
   * The '<em><b>GREATER OR EQUAL</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>GREATER OR EQUAL</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #GREATER_OR_EQUAL
   * @model literal=">="
   * @generated
   * @ordered
   */
  public static final int GREATER_OR_EQUAL_VALUE = 16;

  /**
   * The '<em><b>LESS</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>LESS</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #LESS
   * @model literal="<"
   * @generated
   * @ordered
   */
  public static final int LESS_VALUE = 17;

  /**
   * The '<em><b>LESS OR EQUAL</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>LESS OR EQUAL</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #LESS_OR_EQUAL
   * @model literal="<="
   * @generated
   * @ordered
   */
  public static final int LESS_OR_EQUAL_VALUE = 18;

  /**
   * The '<em><b>LOGICAL AND</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>LOGICAL AND</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #LOGICAL_AND
   * @model literal="&&"
   * @generated
   * @ordered
   */
  public static final int LOGICAL_AND_VALUE = 19;

  /**
   * The '<em><b>LOGICAL OR</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>LOGICAL OR</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #LOGICAL_OR
   * @model literal="||"
   * @generated
   * @ordered
   */
  public static final int LOGICAL_OR_VALUE = 20;

  /**
   * The '<em><b>CONDITIONAL TRUE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>CONDITIONAL TRUE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #CONDITIONAL_TRUE
   * @model literal="?"
   * @generated
   * @ordered
   */
  public static final int CONDITIONAL_TRUE_VALUE = 21;

  /**
   * The '<em><b>CONDITIONAL FALSE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>CONDITIONAL FALSE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #CONDITIONAL_FALSE
   * @model literal=":"
   * @generated
   * @ordered
   */
  public static final int CONDITIONAL_FALSE_VALUE = 22;

  /**
   * An array of all the '<em><b>Operator</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final Operator[] VALUES_ARRAY =
    new Operator[]
    {
      ADD,
      SUBTRACT,
      MULTIPLY,
      DIVIDE,
      MODULUS,
      LEFT_SHIFT,
      ARITHMETIC_RIGHT_SHIFT,
      LOGICAL_RIGHT_SHIFT,
      BITWISE_AND,
      BITWISE_OR,
      BITWISE_XOR,
      BITWISE_NOT,
      LOGICAL_NOT,
      EQUAL,
      NOT_EQUAL,
      GREATER,
      GREATER_OR_EQUAL,
      LESS,
      LESS_OR_EQUAL,
      LOGICAL_AND,
      LOGICAL_OR,
      CONDITIONAL_TRUE,
      CONDITIONAL_FALSE,
    };

  /**
   * A public read-only list of all the '<em><b>Operator</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<Operator> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Operator</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Operator get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      Operator result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Operator</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Operator getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      Operator result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Operator</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static Operator get(int value)
  {
    switch (value)
    {
      case ADD_VALUE: return ADD;
      case SUBTRACT_VALUE: return SUBTRACT;
      case MULTIPLY_VALUE: return MULTIPLY;
      case DIVIDE_VALUE: return DIVIDE;
      case MODULUS_VALUE: return MODULUS;
      case LEFT_SHIFT_VALUE: return LEFT_SHIFT;
      case ARITHMETIC_RIGHT_SHIFT_VALUE: return ARITHMETIC_RIGHT_SHIFT;
      case LOGICAL_RIGHT_SHIFT_VALUE: return LOGICAL_RIGHT_SHIFT;
      case BITWISE_AND_VALUE: return BITWISE_AND;
      case BITWISE_OR_VALUE: return BITWISE_OR;
      case BITWISE_XOR_VALUE: return BITWISE_XOR;
      case BITWISE_NOT_VALUE: return BITWISE_NOT;
      case LOGICAL_NOT_VALUE: return LOGICAL_NOT;
      case EQUAL_VALUE: return EQUAL;
      case NOT_EQUAL_VALUE: return NOT_EQUAL;
      case GREATER_VALUE: return GREATER;
      case GREATER_OR_EQUAL_VALUE: return GREATER_OR_EQUAL;
      case LESS_VALUE: return LESS;
      case LESS_OR_EQUAL_VALUE: return LESS_OR_EQUAL;
      case LOGICAL_AND_VALUE: return LOGICAL_AND;
      case LOGICAL_OR_VALUE: return LOGICAL_OR;
      case CONDITIONAL_TRUE_VALUE: return CONDITIONAL_TRUE;
      case CONDITIONAL_FALSE_VALUE: return CONDITIONAL_FALSE;
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
  private Operator(int value, String name, String literal)
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
  
} //Operator
