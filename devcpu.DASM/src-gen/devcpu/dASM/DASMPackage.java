/**
 */
package devcpu.dASM;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see devcpu.dASM.DASMFactory
 * @model kind="package"
 * @generated
 */
public interface DASMPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "dASM";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://herobrinesarmy.com/";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "dASM";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  DASMPackage eINSTANCE = devcpu.dASM.impl.DASMPackageImpl.init();

  /**
   * The meta object id for the '{@link devcpu.dASM.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see devcpu.dASM.impl.ModelImpl
   * @see devcpu.dASM.impl.DASMPackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link devcpu.dASM.impl.LineDefinitionImpl <em>Line Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see devcpu.dASM.impl.LineDefinitionImpl
   * @see devcpu.dASM.impl.DASMPackageImpl#getLineDefinition()
   * @generated
   */
  int LINE_DEFINITION = 1;

  /**
   * The feature id for the '<em><b>Labels</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINE_DEFINITION__LABELS = MODEL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Content</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINE_DEFINITION__CONTENT = MODEL_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Comment</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINE_DEFINITION__COMMENT = MODEL_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Line Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINE_DEFINITION_FEATURE_COUNT = MODEL_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link devcpu.dASM.impl.LineContentImpl <em>Line Content</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see devcpu.dASM.impl.LineContentImpl
   * @see devcpu.dASM.impl.DASMPackageImpl#getLineContent()
   * @generated
   */
  int LINE_CONTENT = 2;

  /**
   * The number of structural features of the '<em>Line Content</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINE_CONTENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link devcpu.dASM.impl.DirectiveImpl <em>Directive</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see devcpu.dASM.impl.DirectiveImpl
   * @see devcpu.dASM.impl.DASMPackageImpl#getDirective()
   * @generated
   */
  int DIRECTIVE = 3;

  /**
   * The number of structural features of the '<em>Directive</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DIRECTIVE_FEATURE_COUNT = LINE_CONTENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link devcpu.dASM.impl.OriginDirectiveImpl <em>Origin Directive</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see devcpu.dASM.impl.OriginDirectiveImpl
   * @see devcpu.dASM.impl.DASMPackageImpl#getOriginDirective()
   * @generated
   */
  int ORIGIN_DIRECTIVE = 4;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORIGIN_DIRECTIVE__VALUE = DIRECTIVE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Origin Directive</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORIGIN_DIRECTIVE_FEATURE_COUNT = DIRECTIVE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link devcpu.dASM.impl.IncludeDirectiveImpl <em>Include Directive</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see devcpu.dASM.impl.IncludeDirectiveImpl
   * @see devcpu.dASM.impl.DASMPackageImpl#getIncludeDirective()
   * @generated
   */
  int INCLUDE_DIRECTIVE = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INCLUDE_DIRECTIVE__NAME = DIRECTIVE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Include Directive</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INCLUDE_DIRECTIVE_FEATURE_COUNT = DIRECTIVE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link devcpu.dASM.impl.DataLineImpl <em>Data Line</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see devcpu.dASM.impl.DataLineImpl
   * @see devcpu.dASM.impl.DASMPackageImpl#getDataLine()
   * @generated
   */
  int DATA_LINE = 6;

  /**
   * The feature id for the '<em><b>Data Elements</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_LINE__DATA_ELEMENTS = LINE_CONTENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Data Line</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_LINE_FEATURE_COUNT = LINE_CONTENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link devcpu.dASM.impl.ValueImpl <em>Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see devcpu.dASM.impl.ValueImpl
   * @see devcpu.dASM.impl.DASMPackageImpl#getValue()
   * @generated
   */
  int VALUE = 15;

  /**
   * The number of structural features of the '<em>Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link devcpu.dASM.impl.LiteralExpressionImpl <em>Literal Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see devcpu.dASM.impl.LiteralExpressionImpl
   * @see devcpu.dASM.impl.DASMPackageImpl#getLiteralExpression()
   * @generated
   */
  int LITERAL_EXPRESSION = 7;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_EXPRESSION__VALUE = VALUE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Literal Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_EXPRESSION_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link devcpu.dASM.impl.NonGroupOperandImpl <em>Non Group Operand</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see devcpu.dASM.impl.NonGroupOperandImpl
   * @see devcpu.dASM.impl.DASMPackageImpl#getNonGroupOperand()
   * @generated
   */
  int NON_GROUP_OPERAND = 8;

  /**
   * The feature id for the '<em><b>Label Name</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NON_GROUP_OPERAND__LABEL_NAME = 0;

  /**
   * The number of structural features of the '<em>Non Group Operand</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NON_GROUP_OPERAND_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link devcpu.dASM.impl.StackValueImpl <em>Stack Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see devcpu.dASM.impl.StackValueImpl
   * @see devcpu.dASM.impl.DASMPackageImpl#getStackValue()
   * @generated
   */
  int STACK_VALUE = 9;

  /**
   * The feature id for the '<em><b>Label Name</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STACK_VALUE__LABEL_NAME = NON_GROUP_OPERAND__LABEL_NAME;

  /**
   * The number of structural features of the '<em>Stack Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STACK_VALUE_FEATURE_COUNT = NON_GROUP_OPERAND_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link devcpu.dASM.impl.PickValueImpl <em>Pick Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see devcpu.dASM.impl.PickValueImpl
   * @see devcpu.dASM.impl.DASMPackageImpl#getPickValue()
   * @generated
   */
  int PICK_VALUE = 10;

  /**
   * The feature id for the '<em><b>Label Name</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PICK_VALUE__LABEL_NAME = STACK_VALUE__LABEL_NAME;

  /**
   * The feature id for the '<em><b>Pick Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PICK_VALUE__PICK_VALUE = STACK_VALUE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Pick Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PICK_VALUE_FEATURE_COUNT = STACK_VALUE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link devcpu.dASM.impl.LabelImpl <em>Label</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see devcpu.dASM.impl.LabelImpl
   * @see devcpu.dASM.impl.DASMPackageImpl#getLabel()
   * @generated
   */
  int LABEL = 11;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LABEL__NAME = 0;

  /**
   * The number of structural features of the '<em>Label</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LABEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link devcpu.dASM.impl.InstructionImpl <em>Instruction</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see devcpu.dASM.impl.InstructionImpl
   * @see devcpu.dASM.impl.DASMPackageImpl#getInstruction()
   * @generated
   */
  int INSTRUCTION = 12;

  /**
   * The feature id for the '<em><b>A</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTRUCTION__A = LINE_CONTENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Instruction</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTRUCTION_FEATURE_COUNT = LINE_CONTENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link devcpu.dASM.impl.BasicInstructionImpl <em>Basic Instruction</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see devcpu.dASM.impl.BasicInstructionImpl
   * @see devcpu.dASM.impl.DASMPackageImpl#getBasicInstruction()
   * @generated
   */
  int BASIC_INSTRUCTION = 13;

  /**
   * The feature id for the '<em><b>A</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_INSTRUCTION__A = INSTRUCTION__A;

  /**
   * The feature id for the '<em><b>Opcode</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_INSTRUCTION__OPCODE = INSTRUCTION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>B</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_INSTRUCTION__B = INSTRUCTION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Basic Instruction</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASIC_INSTRUCTION_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link devcpu.dASM.impl.SpecialInstructionImpl <em>Special Instruction</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see devcpu.dASM.impl.SpecialInstructionImpl
   * @see devcpu.dASM.impl.DASMPackageImpl#getSpecialInstruction()
   * @generated
   */
  int SPECIAL_INSTRUCTION = 14;

  /**
   * The feature id for the '<em><b>A</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIAL_INSTRUCTION__A = INSTRUCTION__A;

  /**
   * The feature id for the '<em><b>Opcode</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIAL_INSTRUCTION__OPCODE = INSTRUCTION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Special Instruction</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIAL_INSTRUCTION_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link devcpu.dASM.impl.LiteralImpl <em>Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see devcpu.dASM.impl.LiteralImpl
   * @see devcpu.dASM.impl.DASMPackageImpl#getLiteral()
   * @generated
   */
  int LITERAL = 16;

  /**
   * The feature id for the '<em><b>Label Name</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL__LABEL_NAME = NON_GROUP_OPERAND__LABEL_NAME;

  /**
   * The feature id for the '<em><b>Number</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL__NUMBER = NON_GROUP_OPERAND_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_FEATURE_COUNT = NON_GROUP_OPERAND_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link devcpu.dASM.impl.RegisterImpl <em>Register</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see devcpu.dASM.impl.RegisterImpl
   * @see devcpu.dASM.impl.DASMPackageImpl#getRegister()
   * @generated
   */
  int REGISTER = 17;

  /**
   * The feature id for the '<em><b>Label Name</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REGISTER__LABEL_NAME = NON_GROUP_OPERAND__LABEL_NAME;

  /**
   * The feature id for the '<em><b>Standard Register</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REGISTER__STANDARD_REGISTER = NON_GROUP_OPERAND_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Special Register</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REGISTER__SPECIAL_REGISTER = NON_GROUP_OPERAND_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Register</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REGISTER_FEATURE_COUNT = NON_GROUP_OPERAND_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link devcpu.dASM.impl.LiteralAddressImpl <em>Literal Address</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see devcpu.dASM.impl.LiteralAddressImpl
   * @see devcpu.dASM.impl.DASMPackageImpl#getLiteralAddress()
   * @generated
   */
  int LITERAL_ADDRESS = 18;

  /**
   * The feature id for the '<em><b>Number</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_ADDRESS__NUMBER = 0;

  /**
   * The feature id for the '<em><b>Label Name</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_ADDRESS__LABEL_NAME = 1;

  /**
   * The number of structural features of the '<em>Literal Address</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_ADDRESS_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link devcpu.dASM.impl.AddressExpressionImpl <em>Address Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see devcpu.dASM.impl.AddressExpressionImpl
   * @see devcpu.dASM.impl.DASMPackageImpl#getAddressExpression()
   * @generated
   */
  int ADDRESS_EXPRESSION = 19;

  /**
   * The number of structural features of the '<em>Address Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDRESS_EXPRESSION_FEATURE_COUNT = VALUE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link devcpu.dASM.impl.OperationImpl <em>Operation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see devcpu.dASM.impl.OperationImpl
   * @see devcpu.dASM.impl.DASMPackageImpl#getOperation()
   * @generated
   */
  int OPERATION = 20;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION__VALUE = MODEL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION__LEFT = MODEL_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION__RIGHT = MODEL_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION__OP = MODEL_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Operation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_FEATURE_COUNT = MODEL_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link devcpu.dASM.BasicOpcode <em>Basic Opcode</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see devcpu.dASM.BasicOpcode
   * @see devcpu.dASM.impl.DASMPackageImpl#getBasicOpcode()
   * @generated
   */
  int BASIC_OPCODE = 21;

  /**
   * The meta object id for the '{@link devcpu.dASM.SpecialOpcode <em>Special Opcode</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see devcpu.dASM.SpecialOpcode
   * @see devcpu.dASM.impl.DASMPackageImpl#getSpecialOpcode()
   * @generated
   */
  int SPECIAL_OPCODE = 22;

  /**
   * The meta object id for the '{@link devcpu.dASM.StandardRegister <em>Standard Register</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see devcpu.dASM.StandardRegister
   * @see devcpu.dASM.impl.DASMPackageImpl#getStandardRegister()
   * @generated
   */
  int STANDARD_REGISTER = 23;

  /**
   * The meta object id for the '{@link devcpu.dASM.SpecialRegister <em>Special Register</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see devcpu.dASM.SpecialRegister
   * @see devcpu.dASM.impl.DASMPackageImpl#getSpecialRegister()
   * @generated
   */
  int SPECIAL_REGISTER = 24;

  /**
   * The meta object id for the '{@link devcpu.dASM.Operator <em>Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see devcpu.dASM.Operator
   * @see devcpu.dASM.impl.DASMPackageImpl#getOperator()
   * @generated
   */
  int OPERATOR = 25;


  /**
   * Returns the meta object for class '{@link devcpu.dASM.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see devcpu.dASM.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for class '{@link devcpu.dASM.LineDefinition <em>Line Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Line Definition</em>'.
   * @see devcpu.dASM.LineDefinition
   * @generated
   */
  EClass getLineDefinition();

  /**
   * Returns the meta object for the containment reference list '{@link devcpu.dASM.LineDefinition#getLabels <em>Labels</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Labels</em>'.
   * @see devcpu.dASM.LineDefinition#getLabels()
   * @see #getLineDefinition()
   * @generated
   */
  EReference getLineDefinition_Labels();

  /**
   * Returns the meta object for the containment reference '{@link devcpu.dASM.LineDefinition#getContent <em>Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Content</em>'.
   * @see devcpu.dASM.LineDefinition#getContent()
   * @see #getLineDefinition()
   * @generated
   */
  EReference getLineDefinition_Content();

  /**
   * Returns the meta object for the attribute '{@link devcpu.dASM.LineDefinition#getComment <em>Comment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Comment</em>'.
   * @see devcpu.dASM.LineDefinition#getComment()
   * @see #getLineDefinition()
   * @generated
   */
  EAttribute getLineDefinition_Comment();

  /**
   * Returns the meta object for class '{@link devcpu.dASM.LineContent <em>Line Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Line Content</em>'.
   * @see devcpu.dASM.LineContent
   * @generated
   */
  EClass getLineContent();

  /**
   * Returns the meta object for class '{@link devcpu.dASM.Directive <em>Directive</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Directive</em>'.
   * @see devcpu.dASM.Directive
   * @generated
   */
  EClass getDirective();

  /**
   * Returns the meta object for class '{@link devcpu.dASM.OriginDirective <em>Origin Directive</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Origin Directive</em>'.
   * @see devcpu.dASM.OriginDirective
   * @generated
   */
  EClass getOriginDirective();

  /**
   * Returns the meta object for the attribute '{@link devcpu.dASM.OriginDirective#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see devcpu.dASM.OriginDirective#getValue()
   * @see #getOriginDirective()
   * @generated
   */
  EAttribute getOriginDirective_Value();

  /**
   * Returns the meta object for class '{@link devcpu.dASM.IncludeDirective <em>Include Directive</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Include Directive</em>'.
   * @see devcpu.dASM.IncludeDirective
   * @generated
   */
  EClass getIncludeDirective();

  /**
   * Returns the meta object for the attribute '{@link devcpu.dASM.IncludeDirective#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see devcpu.dASM.IncludeDirective#getName()
   * @see #getIncludeDirective()
   * @generated
   */
  EAttribute getIncludeDirective_Name();

  /**
   * Returns the meta object for class '{@link devcpu.dASM.DataLine <em>Data Line</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Data Line</em>'.
   * @see devcpu.dASM.DataLine
   * @generated
   */
  EClass getDataLine();

  /**
   * Returns the meta object for the attribute list '{@link devcpu.dASM.DataLine#getDataElements <em>Data Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Data Elements</em>'.
   * @see devcpu.dASM.DataLine#getDataElements()
   * @see #getDataLine()
   * @generated
   */
  EAttribute getDataLine_DataElements();

  /**
   * Returns the meta object for class '{@link devcpu.dASM.LiteralExpression <em>Literal Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Literal Expression</em>'.
   * @see devcpu.dASM.LiteralExpression
   * @generated
   */
  EClass getLiteralExpression();

  /**
   * Returns the meta object for the containment reference '{@link devcpu.dASM.LiteralExpression#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see devcpu.dASM.LiteralExpression#getValue()
   * @see #getLiteralExpression()
   * @generated
   */
  EReference getLiteralExpression_Value();

  /**
   * Returns the meta object for class '{@link devcpu.dASM.NonGroupOperand <em>Non Group Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Non Group Operand</em>'.
   * @see devcpu.dASM.NonGroupOperand
   * @generated
   */
  EClass getNonGroupOperand();

  /**
   * Returns the meta object for the reference '{@link devcpu.dASM.NonGroupOperand#getLabelName <em>Label Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Label Name</em>'.
   * @see devcpu.dASM.NonGroupOperand#getLabelName()
   * @see #getNonGroupOperand()
   * @generated
   */
  EReference getNonGroupOperand_LabelName();

  /**
   * Returns the meta object for class '{@link devcpu.dASM.StackValue <em>Stack Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Stack Value</em>'.
   * @see devcpu.dASM.StackValue
   * @generated
   */
  EClass getStackValue();

  /**
   * Returns the meta object for class '{@link devcpu.dASM.PickValue <em>Pick Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Pick Value</em>'.
   * @see devcpu.dASM.PickValue
   * @generated
   */
  EClass getPickValue();

  /**
   * Returns the meta object for the containment reference '{@link devcpu.dASM.PickValue#getPickValue <em>Pick Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Pick Value</em>'.
   * @see devcpu.dASM.PickValue#getPickValue()
   * @see #getPickValue()
   * @generated
   */
  EReference getPickValue_PickValue();

  /**
   * Returns the meta object for class '{@link devcpu.dASM.Label <em>Label</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Label</em>'.
   * @see devcpu.dASM.Label
   * @generated
   */
  EClass getLabel();

  /**
   * Returns the meta object for the attribute '{@link devcpu.dASM.Label#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see devcpu.dASM.Label#getName()
   * @see #getLabel()
   * @generated
   */
  EAttribute getLabel_Name();

  /**
   * Returns the meta object for class '{@link devcpu.dASM.Instruction <em>Instruction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Instruction</em>'.
   * @see devcpu.dASM.Instruction
   * @generated
   */
  EClass getInstruction();

  /**
   * Returns the meta object for the containment reference '{@link devcpu.dASM.Instruction#getA <em>A</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>A</em>'.
   * @see devcpu.dASM.Instruction#getA()
   * @see #getInstruction()
   * @generated
   */
  EReference getInstruction_A();

  /**
   * Returns the meta object for class '{@link devcpu.dASM.BasicInstruction <em>Basic Instruction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Basic Instruction</em>'.
   * @see devcpu.dASM.BasicInstruction
   * @generated
   */
  EClass getBasicInstruction();

  /**
   * Returns the meta object for the attribute '{@link devcpu.dASM.BasicInstruction#getOpcode <em>Opcode</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Opcode</em>'.
   * @see devcpu.dASM.BasicInstruction#getOpcode()
   * @see #getBasicInstruction()
   * @generated
   */
  EAttribute getBasicInstruction_Opcode();

  /**
   * Returns the meta object for the containment reference '{@link devcpu.dASM.BasicInstruction#getB <em>B</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>B</em>'.
   * @see devcpu.dASM.BasicInstruction#getB()
   * @see #getBasicInstruction()
   * @generated
   */
  EReference getBasicInstruction_B();

  /**
   * Returns the meta object for class '{@link devcpu.dASM.SpecialInstruction <em>Special Instruction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Special Instruction</em>'.
   * @see devcpu.dASM.SpecialInstruction
   * @generated
   */
  EClass getSpecialInstruction();

  /**
   * Returns the meta object for the attribute '{@link devcpu.dASM.SpecialInstruction#getOpcode <em>Opcode</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Opcode</em>'.
   * @see devcpu.dASM.SpecialInstruction#getOpcode()
   * @see #getSpecialInstruction()
   * @generated
   */
  EAttribute getSpecialInstruction_Opcode();

  /**
   * Returns the meta object for class '{@link devcpu.dASM.Value <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Value</em>'.
   * @see devcpu.dASM.Value
   * @generated
   */
  EClass getValue();

  /**
   * Returns the meta object for class '{@link devcpu.dASM.Literal <em>Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Literal</em>'.
   * @see devcpu.dASM.Literal
   * @generated
   */
  EClass getLiteral();

  /**
   * Returns the meta object for the attribute '{@link devcpu.dASM.Literal#getNumber <em>Number</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Number</em>'.
   * @see devcpu.dASM.Literal#getNumber()
   * @see #getLiteral()
   * @generated
   */
  EAttribute getLiteral_Number();

  /**
   * Returns the meta object for class '{@link devcpu.dASM.Register <em>Register</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Register</em>'.
   * @see devcpu.dASM.Register
   * @generated
   */
  EClass getRegister();

  /**
   * Returns the meta object for the attribute '{@link devcpu.dASM.Register#getStandardRegister <em>Standard Register</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Standard Register</em>'.
   * @see devcpu.dASM.Register#getStandardRegister()
   * @see #getRegister()
   * @generated
   */
  EAttribute getRegister_StandardRegister();

  /**
   * Returns the meta object for the attribute '{@link devcpu.dASM.Register#getSpecialRegister <em>Special Register</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Special Register</em>'.
   * @see devcpu.dASM.Register#getSpecialRegister()
   * @see #getRegister()
   * @generated
   */
  EAttribute getRegister_SpecialRegister();

  /**
   * Returns the meta object for class '{@link devcpu.dASM.LiteralAddress <em>Literal Address</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Literal Address</em>'.
   * @see devcpu.dASM.LiteralAddress
   * @generated
   */
  EClass getLiteralAddress();

  /**
   * Returns the meta object for the attribute '{@link devcpu.dASM.LiteralAddress#getNumber <em>Number</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Number</em>'.
   * @see devcpu.dASM.LiteralAddress#getNumber()
   * @see #getLiteralAddress()
   * @generated
   */
  EAttribute getLiteralAddress_Number();

  /**
   * Returns the meta object for the reference '{@link devcpu.dASM.LiteralAddress#getLabelName <em>Label Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Label Name</em>'.
   * @see devcpu.dASM.LiteralAddress#getLabelName()
   * @see #getLiteralAddress()
   * @generated
   */
  EReference getLiteralAddress_LabelName();

  /**
   * Returns the meta object for class '{@link devcpu.dASM.AddressExpression <em>Address Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Address Expression</em>'.
   * @see devcpu.dASM.AddressExpression
   * @generated
   */
  EClass getAddressExpression();

  /**
   * Returns the meta object for class '{@link devcpu.dASM.Operation <em>Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Operation</em>'.
   * @see devcpu.dASM.Operation
   * @generated
   */
  EClass getOperation();

  /**
   * Returns the meta object for the containment reference '{@link devcpu.dASM.Operation#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see devcpu.dASM.Operation#getLeft()
   * @see #getOperation()
   * @generated
   */
  EReference getOperation_Left();

  /**
   * Returns the meta object for the containment reference '{@link devcpu.dASM.Operation#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see devcpu.dASM.Operation#getRight()
   * @see #getOperation()
   * @generated
   */
  EReference getOperation_Right();

  /**
   * Returns the meta object for the attribute '{@link devcpu.dASM.Operation#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see devcpu.dASM.Operation#getOp()
   * @see #getOperation()
   * @generated
   */
  EAttribute getOperation_Op();

  /**
   * Returns the meta object for enum '{@link devcpu.dASM.BasicOpcode <em>Basic Opcode</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Basic Opcode</em>'.
   * @see devcpu.dASM.BasicOpcode
   * @generated
   */
  EEnum getBasicOpcode();

  /**
   * Returns the meta object for enum '{@link devcpu.dASM.SpecialOpcode <em>Special Opcode</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Special Opcode</em>'.
   * @see devcpu.dASM.SpecialOpcode
   * @generated
   */
  EEnum getSpecialOpcode();

  /**
   * Returns the meta object for enum '{@link devcpu.dASM.StandardRegister <em>Standard Register</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Standard Register</em>'.
   * @see devcpu.dASM.StandardRegister
   * @generated
   */
  EEnum getStandardRegister();

  /**
   * Returns the meta object for enum '{@link devcpu.dASM.SpecialRegister <em>Special Register</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Special Register</em>'.
   * @see devcpu.dASM.SpecialRegister
   * @generated
   */
  EEnum getSpecialRegister();

  /**
   * Returns the meta object for enum '{@link devcpu.dASM.Operator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Operator</em>'.
   * @see devcpu.dASM.Operator
   * @generated
   */
  EEnum getOperator();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  DASMFactory getDASMFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link devcpu.dASM.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see devcpu.dASM.impl.ModelImpl
     * @see devcpu.dASM.impl.DASMPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '{@link devcpu.dASM.impl.LineDefinitionImpl <em>Line Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see devcpu.dASM.impl.LineDefinitionImpl
     * @see devcpu.dASM.impl.DASMPackageImpl#getLineDefinition()
     * @generated
     */
    EClass LINE_DEFINITION = eINSTANCE.getLineDefinition();

    /**
     * The meta object literal for the '<em><b>Labels</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LINE_DEFINITION__LABELS = eINSTANCE.getLineDefinition_Labels();

    /**
     * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LINE_DEFINITION__CONTENT = eINSTANCE.getLineDefinition_Content();

    /**
     * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LINE_DEFINITION__COMMENT = eINSTANCE.getLineDefinition_Comment();

    /**
     * The meta object literal for the '{@link devcpu.dASM.impl.LineContentImpl <em>Line Content</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see devcpu.dASM.impl.LineContentImpl
     * @see devcpu.dASM.impl.DASMPackageImpl#getLineContent()
     * @generated
     */
    EClass LINE_CONTENT = eINSTANCE.getLineContent();

    /**
     * The meta object literal for the '{@link devcpu.dASM.impl.DirectiveImpl <em>Directive</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see devcpu.dASM.impl.DirectiveImpl
     * @see devcpu.dASM.impl.DASMPackageImpl#getDirective()
     * @generated
     */
    EClass DIRECTIVE = eINSTANCE.getDirective();

    /**
     * The meta object literal for the '{@link devcpu.dASM.impl.OriginDirectiveImpl <em>Origin Directive</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see devcpu.dASM.impl.OriginDirectiveImpl
     * @see devcpu.dASM.impl.DASMPackageImpl#getOriginDirective()
     * @generated
     */
    EClass ORIGIN_DIRECTIVE = eINSTANCE.getOriginDirective();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ORIGIN_DIRECTIVE__VALUE = eINSTANCE.getOriginDirective_Value();

    /**
     * The meta object literal for the '{@link devcpu.dASM.impl.IncludeDirectiveImpl <em>Include Directive</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see devcpu.dASM.impl.IncludeDirectiveImpl
     * @see devcpu.dASM.impl.DASMPackageImpl#getIncludeDirective()
     * @generated
     */
    EClass INCLUDE_DIRECTIVE = eINSTANCE.getIncludeDirective();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INCLUDE_DIRECTIVE__NAME = eINSTANCE.getIncludeDirective_Name();

    /**
     * The meta object literal for the '{@link devcpu.dASM.impl.DataLineImpl <em>Data Line</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see devcpu.dASM.impl.DataLineImpl
     * @see devcpu.dASM.impl.DASMPackageImpl#getDataLine()
     * @generated
     */
    EClass DATA_LINE = eINSTANCE.getDataLine();

    /**
     * The meta object literal for the '<em><b>Data Elements</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DATA_LINE__DATA_ELEMENTS = eINSTANCE.getDataLine_DataElements();

    /**
     * The meta object literal for the '{@link devcpu.dASM.impl.LiteralExpressionImpl <em>Literal Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see devcpu.dASM.impl.LiteralExpressionImpl
     * @see devcpu.dASM.impl.DASMPackageImpl#getLiteralExpression()
     * @generated
     */
    EClass LITERAL_EXPRESSION = eINSTANCE.getLiteralExpression();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LITERAL_EXPRESSION__VALUE = eINSTANCE.getLiteralExpression_Value();

    /**
     * The meta object literal for the '{@link devcpu.dASM.impl.NonGroupOperandImpl <em>Non Group Operand</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see devcpu.dASM.impl.NonGroupOperandImpl
     * @see devcpu.dASM.impl.DASMPackageImpl#getNonGroupOperand()
     * @generated
     */
    EClass NON_GROUP_OPERAND = eINSTANCE.getNonGroupOperand();

    /**
     * The meta object literal for the '<em><b>Label Name</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NON_GROUP_OPERAND__LABEL_NAME = eINSTANCE.getNonGroupOperand_LabelName();

    /**
     * The meta object literal for the '{@link devcpu.dASM.impl.StackValueImpl <em>Stack Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see devcpu.dASM.impl.StackValueImpl
     * @see devcpu.dASM.impl.DASMPackageImpl#getStackValue()
     * @generated
     */
    EClass STACK_VALUE = eINSTANCE.getStackValue();

    /**
     * The meta object literal for the '{@link devcpu.dASM.impl.PickValueImpl <em>Pick Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see devcpu.dASM.impl.PickValueImpl
     * @see devcpu.dASM.impl.DASMPackageImpl#getPickValue()
     * @generated
     */
    EClass PICK_VALUE = eINSTANCE.getPickValue();

    /**
     * The meta object literal for the '<em><b>Pick Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PICK_VALUE__PICK_VALUE = eINSTANCE.getPickValue_PickValue();

    /**
     * The meta object literal for the '{@link devcpu.dASM.impl.LabelImpl <em>Label</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see devcpu.dASM.impl.LabelImpl
     * @see devcpu.dASM.impl.DASMPackageImpl#getLabel()
     * @generated
     */
    EClass LABEL = eINSTANCE.getLabel();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LABEL__NAME = eINSTANCE.getLabel_Name();

    /**
     * The meta object literal for the '{@link devcpu.dASM.impl.InstructionImpl <em>Instruction</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see devcpu.dASM.impl.InstructionImpl
     * @see devcpu.dASM.impl.DASMPackageImpl#getInstruction()
     * @generated
     */
    EClass INSTRUCTION = eINSTANCE.getInstruction();

    /**
     * The meta object literal for the '<em><b>A</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INSTRUCTION__A = eINSTANCE.getInstruction_A();

    /**
     * The meta object literal for the '{@link devcpu.dASM.impl.BasicInstructionImpl <em>Basic Instruction</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see devcpu.dASM.impl.BasicInstructionImpl
     * @see devcpu.dASM.impl.DASMPackageImpl#getBasicInstruction()
     * @generated
     */
    EClass BASIC_INSTRUCTION = eINSTANCE.getBasicInstruction();

    /**
     * The meta object literal for the '<em><b>Opcode</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BASIC_INSTRUCTION__OPCODE = eINSTANCE.getBasicInstruction_Opcode();

    /**
     * The meta object literal for the '<em><b>B</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BASIC_INSTRUCTION__B = eINSTANCE.getBasicInstruction_B();

    /**
     * The meta object literal for the '{@link devcpu.dASM.impl.SpecialInstructionImpl <em>Special Instruction</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see devcpu.dASM.impl.SpecialInstructionImpl
     * @see devcpu.dASM.impl.DASMPackageImpl#getSpecialInstruction()
     * @generated
     */
    EClass SPECIAL_INSTRUCTION = eINSTANCE.getSpecialInstruction();

    /**
     * The meta object literal for the '<em><b>Opcode</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SPECIAL_INSTRUCTION__OPCODE = eINSTANCE.getSpecialInstruction_Opcode();

    /**
     * The meta object literal for the '{@link devcpu.dASM.impl.ValueImpl <em>Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see devcpu.dASM.impl.ValueImpl
     * @see devcpu.dASM.impl.DASMPackageImpl#getValue()
     * @generated
     */
    EClass VALUE = eINSTANCE.getValue();

    /**
     * The meta object literal for the '{@link devcpu.dASM.impl.LiteralImpl <em>Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see devcpu.dASM.impl.LiteralImpl
     * @see devcpu.dASM.impl.DASMPackageImpl#getLiteral()
     * @generated
     */
    EClass LITERAL = eINSTANCE.getLiteral();

    /**
     * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LITERAL__NUMBER = eINSTANCE.getLiteral_Number();

    /**
     * The meta object literal for the '{@link devcpu.dASM.impl.RegisterImpl <em>Register</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see devcpu.dASM.impl.RegisterImpl
     * @see devcpu.dASM.impl.DASMPackageImpl#getRegister()
     * @generated
     */
    EClass REGISTER = eINSTANCE.getRegister();

    /**
     * The meta object literal for the '<em><b>Standard Register</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REGISTER__STANDARD_REGISTER = eINSTANCE.getRegister_StandardRegister();

    /**
     * The meta object literal for the '<em><b>Special Register</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REGISTER__SPECIAL_REGISTER = eINSTANCE.getRegister_SpecialRegister();

    /**
     * The meta object literal for the '{@link devcpu.dASM.impl.LiteralAddressImpl <em>Literal Address</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see devcpu.dASM.impl.LiteralAddressImpl
     * @see devcpu.dASM.impl.DASMPackageImpl#getLiteralAddress()
     * @generated
     */
    EClass LITERAL_ADDRESS = eINSTANCE.getLiteralAddress();

    /**
     * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LITERAL_ADDRESS__NUMBER = eINSTANCE.getLiteralAddress_Number();

    /**
     * The meta object literal for the '<em><b>Label Name</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LITERAL_ADDRESS__LABEL_NAME = eINSTANCE.getLiteralAddress_LabelName();

    /**
     * The meta object literal for the '{@link devcpu.dASM.impl.AddressExpressionImpl <em>Address Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see devcpu.dASM.impl.AddressExpressionImpl
     * @see devcpu.dASM.impl.DASMPackageImpl#getAddressExpression()
     * @generated
     */
    EClass ADDRESS_EXPRESSION = eINSTANCE.getAddressExpression();

    /**
     * The meta object literal for the '{@link devcpu.dASM.impl.OperationImpl <em>Operation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see devcpu.dASM.impl.OperationImpl
     * @see devcpu.dASM.impl.DASMPackageImpl#getOperation()
     * @generated
     */
    EClass OPERATION = eINSTANCE.getOperation();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATION__LEFT = eINSTANCE.getOperation_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATION__RIGHT = eINSTANCE.getOperation_Right();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPERATION__OP = eINSTANCE.getOperation_Op();

    /**
     * The meta object literal for the '{@link devcpu.dASM.BasicOpcode <em>Basic Opcode</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see devcpu.dASM.BasicOpcode
     * @see devcpu.dASM.impl.DASMPackageImpl#getBasicOpcode()
     * @generated
     */
    EEnum BASIC_OPCODE = eINSTANCE.getBasicOpcode();

    /**
     * The meta object literal for the '{@link devcpu.dASM.SpecialOpcode <em>Special Opcode</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see devcpu.dASM.SpecialOpcode
     * @see devcpu.dASM.impl.DASMPackageImpl#getSpecialOpcode()
     * @generated
     */
    EEnum SPECIAL_OPCODE = eINSTANCE.getSpecialOpcode();

    /**
     * The meta object literal for the '{@link devcpu.dASM.StandardRegister <em>Standard Register</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see devcpu.dASM.StandardRegister
     * @see devcpu.dASM.impl.DASMPackageImpl#getStandardRegister()
     * @generated
     */
    EEnum STANDARD_REGISTER = eINSTANCE.getStandardRegister();

    /**
     * The meta object literal for the '{@link devcpu.dASM.SpecialRegister <em>Special Register</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see devcpu.dASM.SpecialRegister
     * @see devcpu.dASM.impl.DASMPackageImpl#getSpecialRegister()
     * @generated
     */
    EEnum SPECIAL_REGISTER = eINSTANCE.getSpecialRegister();

    /**
     * The meta object literal for the '{@link devcpu.dASM.Operator <em>Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see devcpu.dASM.Operator
     * @see devcpu.dASM.impl.DASMPackageImpl#getOperator()
     * @generated
     */
    EEnum OPERATOR = eINSTANCE.getOperator();

  }

} //DASMPackage
