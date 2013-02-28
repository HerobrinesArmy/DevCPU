/**
 */
package devcpu.dASM.impl;

import devcpu.dASM.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DASMFactoryImpl extends EFactoryImpl implements DASMFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static DASMFactory init()
  {
    try
    {
      DASMFactory theDASMFactory = (DASMFactory)EPackage.Registry.INSTANCE.getEFactory(DASMPackage.eNS_URI);
      if (theDASMFactory != null)
      {
        return theDASMFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new DASMFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DASMFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case DASMPackage.MODEL: return createModel();
      case DASMPackage.LINE_DEFINITION: return createLineDefinition();
      case DASMPackage.LINE_CONTENT: return createLineContent();
      case DASMPackage.DIRECTIVE: return createDirective();
      case DASMPackage.ORIGIN_DIRECTIVE: return createOriginDirective();
      case DASMPackage.INCLUDE_DIRECTIVE: return createIncludeDirective();
      case DASMPackage.DATA_LINE: return createDataLine();
      case DASMPackage.LITERAL_EXPRESSION: return createLiteralExpression();
      case DASMPackage.NON_GROUP_OPERAND: return createNonGroupOperand();
      case DASMPackage.STACK_VALUE: return createStackValue();
      case DASMPackage.PICK_VALUE: return createPickValue();
      case DASMPackage.LABEL: return createLabel();
      case DASMPackage.INSTRUCTION: return createInstruction();
      case DASMPackage.BASIC_INSTRUCTION: return createBasicInstruction();
      case DASMPackage.SPECIAL_INSTRUCTION: return createSpecialInstruction();
      case DASMPackage.VALUE: return createValue();
      case DASMPackage.LITERAL: return createLiteral();
      case DASMPackage.REGISTER: return createRegister();
      case DASMPackage.LITERAL_ADDRESS: return createLiteralAddress();
      case DASMPackage.ADDRESS_EXPRESSION: return createAddressExpression();
      case DASMPackage.OPERATION: return createOperation();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case DASMPackage.BASIC_OPCODE:
        return createBasicOpcodeFromString(eDataType, initialValue);
      case DASMPackage.SPECIAL_OPCODE:
        return createSpecialOpcodeFromString(eDataType, initialValue);
      case DASMPackage.STANDARD_REGISTER:
        return createStandardRegisterFromString(eDataType, initialValue);
      case DASMPackage.SPECIAL_REGISTER:
        return createSpecialRegisterFromString(eDataType, initialValue);
      case DASMPackage.OPERATOR:
        return createOperatorFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case DASMPackage.BASIC_OPCODE:
        return convertBasicOpcodeToString(eDataType, instanceValue);
      case DASMPackage.SPECIAL_OPCODE:
        return convertSpecialOpcodeToString(eDataType, instanceValue);
      case DASMPackage.STANDARD_REGISTER:
        return convertStandardRegisterToString(eDataType, instanceValue);
      case DASMPackage.SPECIAL_REGISTER:
        return convertSpecialRegisterToString(eDataType, instanceValue);
      case DASMPackage.OPERATOR:
        return convertOperatorToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Model createModel()
  {
    ModelImpl model = new ModelImpl();
    return model;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LineDefinition createLineDefinition()
  {
    LineDefinitionImpl lineDefinition = new LineDefinitionImpl();
    return lineDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LineContent createLineContent()
  {
    LineContentImpl lineContent = new LineContentImpl();
    return lineContent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Directive createDirective()
  {
    DirectiveImpl directive = new DirectiveImpl();
    return directive;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OriginDirective createOriginDirective()
  {
    OriginDirectiveImpl originDirective = new OriginDirectiveImpl();
    return originDirective;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IncludeDirective createIncludeDirective()
  {
    IncludeDirectiveImpl includeDirective = new IncludeDirectiveImpl();
    return includeDirective;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataLine createDataLine()
  {
    DataLineImpl dataLine = new DataLineImpl();
    return dataLine;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LiteralExpression createLiteralExpression()
  {
    LiteralExpressionImpl literalExpression = new LiteralExpressionImpl();
    return literalExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NonGroupOperand createNonGroupOperand()
  {
    NonGroupOperandImpl nonGroupOperand = new NonGroupOperandImpl();
    return nonGroupOperand;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StackValue createStackValue()
  {
    StackValueImpl stackValue = new StackValueImpl();
    return stackValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PickValue createPickValue()
  {
    PickValueImpl pickValue = new PickValueImpl();
    return pickValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Label createLabel()
  {
    LabelImpl label = new LabelImpl();
    return label;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Instruction createInstruction()
  {
    InstructionImpl instruction = new InstructionImpl();
    return instruction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BasicInstruction createBasicInstruction()
  {
    BasicInstructionImpl basicInstruction = new BasicInstructionImpl();
    return basicInstruction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SpecialInstruction createSpecialInstruction()
  {
    SpecialInstructionImpl specialInstruction = new SpecialInstructionImpl();
    return specialInstruction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Value createValue()
  {
    ValueImpl value = new ValueImpl();
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Literal createLiteral()
  {
    LiteralImpl literal = new LiteralImpl();
    return literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Register createRegister()
  {
    RegisterImpl register = new RegisterImpl();
    return register;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LiteralAddress createLiteralAddress()
  {
    LiteralAddressImpl literalAddress = new LiteralAddressImpl();
    return literalAddress;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AddressExpression createAddressExpression()
  {
    AddressExpressionImpl addressExpression = new AddressExpressionImpl();
    return addressExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Operation createOperation()
  {
    OperationImpl operation = new OperationImpl();
    return operation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BasicOpcode createBasicOpcodeFromString(EDataType eDataType, String initialValue)
  {
    BasicOpcode result = BasicOpcode.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertBasicOpcodeToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SpecialOpcode createSpecialOpcodeFromString(EDataType eDataType, String initialValue)
  {
    SpecialOpcode result = SpecialOpcode.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertSpecialOpcodeToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StandardRegister createStandardRegisterFromString(EDataType eDataType, String initialValue)
  {
    StandardRegister result = StandardRegister.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertStandardRegisterToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SpecialRegister createSpecialRegisterFromString(EDataType eDataType, String initialValue)
  {
    SpecialRegister result = SpecialRegister.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertSpecialRegisterToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Operator createOperatorFromString(EDataType eDataType, String initialValue)
  {
    Operator result = Operator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DASMPackage getDASMPackage()
  {
    return (DASMPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static DASMPackage getPackage()
  {
    return DASMPackage.eINSTANCE;
  }

} //DASMFactoryImpl
