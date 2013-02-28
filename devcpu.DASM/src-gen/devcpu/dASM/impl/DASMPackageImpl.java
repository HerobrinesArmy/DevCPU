/**
 */
package devcpu.dASM.impl;

import devcpu.dASM.AddressExpression;
import devcpu.dASM.BasicInstruction;
import devcpu.dASM.BasicOpcode;
import devcpu.dASM.DASMFactory;
import devcpu.dASM.DASMPackage;
import devcpu.dASM.DataLine;
import devcpu.dASM.Directive;
import devcpu.dASM.IncludeDirective;
import devcpu.dASM.Instruction;
import devcpu.dASM.Label;
import devcpu.dASM.LineContent;
import devcpu.dASM.LineDefinition;
import devcpu.dASM.Literal;
import devcpu.dASM.LiteralAddress;
import devcpu.dASM.LiteralExpression;
import devcpu.dASM.Model;
import devcpu.dASM.NonGroupOperand;
import devcpu.dASM.Operation;
import devcpu.dASM.Operator;
import devcpu.dASM.OriginDirective;
import devcpu.dASM.PickValue;
import devcpu.dASM.Register;
import devcpu.dASM.SpecialInstruction;
import devcpu.dASM.SpecialOpcode;
import devcpu.dASM.SpecialRegister;
import devcpu.dASM.StackValue;
import devcpu.dASM.StandardRegister;
import devcpu.dASM.Value;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DASMPackageImpl extends EPackageImpl implements DASMPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass modelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass lineDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass lineContentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass directiveEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass originDirectiveEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass includeDirectiveEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dataLineEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass literalExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nonGroupOperandEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stackValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pickValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass labelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass instructionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass basicInstructionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass specialInstructionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass valueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass literalEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass registerEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass literalAddressEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass addressExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass operationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum basicOpcodeEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum specialOpcodeEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum standardRegisterEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum specialRegisterEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum operatorEEnum = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see devcpu.dASM.DASMPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private DASMPackageImpl()
  {
    super(eNS_URI, DASMFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link DASMPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static DASMPackage init()
  {
    if (isInited) return (DASMPackage)EPackage.Registry.INSTANCE.getEPackage(DASMPackage.eNS_URI);

    // Obtain or create and register package
    DASMPackageImpl theDASMPackage = (DASMPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DASMPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DASMPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theDASMPackage.createPackageContents();

    // Initialize created meta-data
    theDASMPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theDASMPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(DASMPackage.eNS_URI, theDASMPackage);
    return theDASMPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModel()
  {
    return modelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLineDefinition()
  {
    return lineDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLineDefinition_Labels()
  {
    return (EReference)lineDefinitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLineDefinition_Content()
  {
    return (EReference)lineDefinitionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLineDefinition_Comment()
  {
    return (EAttribute)lineDefinitionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLineContent()
  {
    return lineContentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDirective()
  {
    return directiveEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOriginDirective()
  {
    return originDirectiveEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOriginDirective_Value()
  {
    return (EAttribute)originDirectiveEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIncludeDirective()
  {
    return includeDirectiveEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIncludeDirective_Name()
  {
    return (EAttribute)includeDirectiveEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDataLine()
  {
    return dataLineEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDataLine_DataElements()
  {
    return (EAttribute)dataLineEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLiteralExpression()
  {
    return literalExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLiteralExpression_Value()
  {
    return (EReference)literalExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNonGroupOperand()
  {
    return nonGroupOperandEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNonGroupOperand_LabelName()
  {
    return (EReference)nonGroupOperandEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStackValue()
  {
    return stackValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPickValue()
  {
    return pickValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPickValue_PickValue()
  {
    return (EReference)pickValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLabel()
  {
    return labelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLabel_Name()
  {
    return (EAttribute)labelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInstruction()
  {
    return instructionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInstruction_A()
  {
    return (EReference)instructionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBasicInstruction()
  {
    return basicInstructionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBasicInstruction_Opcode()
  {
    return (EAttribute)basicInstructionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBasicInstruction_B()
  {
    return (EReference)basicInstructionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSpecialInstruction()
  {
    return specialInstructionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSpecialInstruction_Opcode()
  {
    return (EAttribute)specialInstructionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getValue()
  {
    return valueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLiteral()
  {
    return literalEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLiteral_Number()
  {
    return (EAttribute)literalEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRegister()
  {
    return registerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRegister_StandardRegister()
  {
    return (EAttribute)registerEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRegister_SpecialRegister()
  {
    return (EAttribute)registerEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLiteralAddress()
  {
    return literalAddressEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLiteralAddress_Number()
  {
    return (EAttribute)literalAddressEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLiteralAddress_LabelName()
  {
    return (EReference)literalAddressEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAddressExpression()
  {
    return addressExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOperation()
  {
    return operationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOperation_Left()
  {
    return (EReference)operationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOperation_Right()
  {
    return (EReference)operationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOperation_Op()
  {
    return (EAttribute)operationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getBasicOpcode()
  {
    return basicOpcodeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getSpecialOpcode()
  {
    return specialOpcodeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getStandardRegister()
  {
    return standardRegisterEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getSpecialRegister()
  {
    return specialRegisterEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getOperator()
  {
    return operatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DASMFactory getDASMFactory()
  {
    return (DASMFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    modelEClass = createEClass(MODEL);

    lineDefinitionEClass = createEClass(LINE_DEFINITION);
    createEReference(lineDefinitionEClass, LINE_DEFINITION__LABELS);
    createEReference(lineDefinitionEClass, LINE_DEFINITION__CONTENT);
    createEAttribute(lineDefinitionEClass, LINE_DEFINITION__COMMENT);

    lineContentEClass = createEClass(LINE_CONTENT);

    directiveEClass = createEClass(DIRECTIVE);

    originDirectiveEClass = createEClass(ORIGIN_DIRECTIVE);
    createEAttribute(originDirectiveEClass, ORIGIN_DIRECTIVE__VALUE);

    includeDirectiveEClass = createEClass(INCLUDE_DIRECTIVE);
    createEAttribute(includeDirectiveEClass, INCLUDE_DIRECTIVE__NAME);

    dataLineEClass = createEClass(DATA_LINE);
    createEAttribute(dataLineEClass, DATA_LINE__DATA_ELEMENTS);

    literalExpressionEClass = createEClass(LITERAL_EXPRESSION);
    createEReference(literalExpressionEClass, LITERAL_EXPRESSION__VALUE);

    nonGroupOperandEClass = createEClass(NON_GROUP_OPERAND);
    createEReference(nonGroupOperandEClass, NON_GROUP_OPERAND__LABEL_NAME);

    stackValueEClass = createEClass(STACK_VALUE);

    pickValueEClass = createEClass(PICK_VALUE);
    createEReference(pickValueEClass, PICK_VALUE__PICK_VALUE);

    labelEClass = createEClass(LABEL);
    createEAttribute(labelEClass, LABEL__NAME);

    instructionEClass = createEClass(INSTRUCTION);
    createEReference(instructionEClass, INSTRUCTION__A);

    basicInstructionEClass = createEClass(BASIC_INSTRUCTION);
    createEAttribute(basicInstructionEClass, BASIC_INSTRUCTION__OPCODE);
    createEReference(basicInstructionEClass, BASIC_INSTRUCTION__B);

    specialInstructionEClass = createEClass(SPECIAL_INSTRUCTION);
    createEAttribute(specialInstructionEClass, SPECIAL_INSTRUCTION__OPCODE);

    valueEClass = createEClass(VALUE);

    literalEClass = createEClass(LITERAL);
    createEAttribute(literalEClass, LITERAL__NUMBER);

    registerEClass = createEClass(REGISTER);
    createEAttribute(registerEClass, REGISTER__STANDARD_REGISTER);
    createEAttribute(registerEClass, REGISTER__SPECIAL_REGISTER);

    literalAddressEClass = createEClass(LITERAL_ADDRESS);
    createEAttribute(literalAddressEClass, LITERAL_ADDRESS__NUMBER);
    createEReference(literalAddressEClass, LITERAL_ADDRESS__LABEL_NAME);

    addressExpressionEClass = createEClass(ADDRESS_EXPRESSION);

    operationEClass = createEClass(OPERATION);
    createEReference(operationEClass, OPERATION__LEFT);
    createEReference(operationEClass, OPERATION__RIGHT);
    createEAttribute(operationEClass, OPERATION__OP);

    // Create enums
    basicOpcodeEEnum = createEEnum(BASIC_OPCODE);
    specialOpcodeEEnum = createEEnum(SPECIAL_OPCODE);
    standardRegisterEEnum = createEEnum(STANDARD_REGISTER);
    specialRegisterEEnum = createEEnum(SPECIAL_REGISTER);
    operatorEEnum = createEEnum(OPERATOR);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    lineDefinitionEClass.getESuperTypes().add(this.getModel());
    directiveEClass.getESuperTypes().add(this.getLineContent());
    originDirectiveEClass.getESuperTypes().add(this.getDirective());
    includeDirectiveEClass.getESuperTypes().add(this.getDirective());
    dataLineEClass.getESuperTypes().add(this.getLineContent());
    literalExpressionEClass.getESuperTypes().add(this.getValue());
    literalExpressionEClass.getESuperTypes().add(this.getAddressExpression());
    stackValueEClass.getESuperTypes().add(this.getNonGroupOperand());
    pickValueEClass.getESuperTypes().add(this.getStackValue());
    instructionEClass.getESuperTypes().add(this.getLineContent());
    basicInstructionEClass.getESuperTypes().add(this.getInstruction());
    specialInstructionEClass.getESuperTypes().add(this.getInstruction());
    literalEClass.getESuperTypes().add(this.getNonGroupOperand());
    registerEClass.getESuperTypes().add(this.getNonGroupOperand());
    addressExpressionEClass.getESuperTypes().add(this.getValue());
    operationEClass.getESuperTypes().add(this.getModel());
    operationEClass.getESuperTypes().add(this.getLiteralExpression());

    // Initialize classes and features; add operations and parameters
    initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(lineDefinitionEClass, LineDefinition.class, "LineDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLineDefinition_Labels(), this.getLabel(), null, "labels", null, 0, -1, LineDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLineDefinition_Content(), this.getLineContent(), null, "content", null, 0, 1, LineDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLineDefinition_Comment(), ecorePackage.getEString(), "comment", null, 0, 1, LineDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(lineContentEClass, LineContent.class, "LineContent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(directiveEClass, Directive.class, "Directive", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(originDirectiveEClass, OriginDirective.class, "OriginDirective", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getOriginDirective_Value(), ecorePackage.getEString(), "value", null, 0, 1, OriginDirective.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(includeDirectiveEClass, IncludeDirective.class, "IncludeDirective", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getIncludeDirective_Name(), ecorePackage.getEString(), "name", null, 0, 1, IncludeDirective.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(dataLineEClass, DataLine.class, "DataLine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDataLine_DataElements(), ecorePackage.getEString(), "dataElements", null, 0, -1, DataLine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(literalExpressionEClass, LiteralExpression.class, "LiteralExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLiteralExpression_Value(), this.getNonGroupOperand(), null, "value", null, 0, 1, LiteralExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nonGroupOperandEClass, NonGroupOperand.class, "NonGroupOperand", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNonGroupOperand_LabelName(), this.getLabel(), null, "labelName", null, 0, 1, NonGroupOperand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(stackValueEClass, StackValue.class, "StackValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(pickValueEClass, PickValue.class, "PickValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPickValue_PickValue(), this.getLiteralExpression(), null, "pickValue", null, 0, 1, PickValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(labelEClass, Label.class, "Label", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLabel_Name(), ecorePackage.getEString(), "name", null, 0, 1, Label.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(instructionEClass, Instruction.class, "Instruction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getInstruction_A(), this.getValue(), null, "a", null, 0, 1, Instruction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(basicInstructionEClass, BasicInstruction.class, "BasicInstruction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBasicInstruction_Opcode(), this.getBasicOpcode(), "opcode", null, 0, 1, BasicInstruction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBasicInstruction_B(), this.getValue(), null, "b", null, 0, 1, BasicInstruction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(specialInstructionEClass, SpecialInstruction.class, "SpecialInstruction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSpecialInstruction_Opcode(), this.getSpecialOpcode(), "opcode", null, 0, 1, SpecialInstruction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(valueEClass, Value.class, "Value", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(literalEClass, Literal.class, "Literal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLiteral_Number(), ecorePackage.getEString(), "number", null, 0, 1, Literal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(registerEClass, Register.class, "Register", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRegister_StandardRegister(), this.getStandardRegister(), "standardRegister", null, 0, 1, Register.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRegister_SpecialRegister(), this.getSpecialRegister(), "specialRegister", null, 0, 1, Register.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(literalAddressEClass, LiteralAddress.class, "LiteralAddress", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLiteralAddress_Number(), ecorePackage.getEString(), "number", null, 0, 1, LiteralAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLiteralAddress_LabelName(), this.getLabel(), null, "labelName", null, 0, 1, LiteralAddress.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(addressExpressionEClass, AddressExpression.class, "AddressExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(operationEClass, Operation.class, "Operation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOperation_Left(), ecorePackage.getEObject(), null, "left", null, 0, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOperation_Right(), ecorePackage.getEObject(), null, "right", null, 0, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOperation_Op(), this.getOperator(), "op", null, 0, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(basicOpcodeEEnum, BasicOpcode.class, "BasicOpcode");
    addEEnumLiteral(basicOpcodeEEnum, BasicOpcode.SET);
    addEEnumLiteral(basicOpcodeEEnum, BasicOpcode.ADD);
    addEEnumLiteral(basicOpcodeEEnum, BasicOpcode.SUB);
    addEEnumLiteral(basicOpcodeEEnum, BasicOpcode.MUL);
    addEEnumLiteral(basicOpcodeEEnum, BasicOpcode.MLI);
    addEEnumLiteral(basicOpcodeEEnum, BasicOpcode.DIV);
    addEEnumLiteral(basicOpcodeEEnum, BasicOpcode.DVI);
    addEEnumLiteral(basicOpcodeEEnum, BasicOpcode.MOD);
    addEEnumLiteral(basicOpcodeEEnum, BasicOpcode.MDI);
    addEEnumLiteral(basicOpcodeEEnum, BasicOpcode.AND);
    addEEnumLiteral(basicOpcodeEEnum, BasicOpcode.BOR);
    addEEnumLiteral(basicOpcodeEEnum, BasicOpcode.XOR);
    addEEnumLiteral(basicOpcodeEEnum, BasicOpcode.SHR);
    addEEnumLiteral(basicOpcodeEEnum, BasicOpcode.ASR);
    addEEnumLiteral(basicOpcodeEEnum, BasicOpcode.SHL);
    addEEnumLiteral(basicOpcodeEEnum, BasicOpcode.IFB);
    addEEnumLiteral(basicOpcodeEEnum, BasicOpcode.IFC);
    addEEnumLiteral(basicOpcodeEEnum, BasicOpcode.IFE);
    addEEnumLiteral(basicOpcodeEEnum, BasicOpcode.IFN);
    addEEnumLiteral(basicOpcodeEEnum, BasicOpcode.IFG);
    addEEnumLiteral(basicOpcodeEEnum, BasicOpcode.IFA);
    addEEnumLiteral(basicOpcodeEEnum, BasicOpcode.IFL);
    addEEnumLiteral(basicOpcodeEEnum, BasicOpcode.IFU);
    addEEnumLiteral(basicOpcodeEEnum, BasicOpcode.ADX);
    addEEnumLiteral(basicOpcodeEEnum, BasicOpcode.SBX);
    addEEnumLiteral(basicOpcodeEEnum, BasicOpcode.STI);
    addEEnumLiteral(basicOpcodeEEnum, BasicOpcode.STD);

    initEEnum(specialOpcodeEEnum, SpecialOpcode.class, "SpecialOpcode");
    addEEnumLiteral(specialOpcodeEEnum, SpecialOpcode.JSR);
    addEEnumLiteral(specialOpcodeEEnum, SpecialOpcode.INT);
    addEEnumLiteral(specialOpcodeEEnum, SpecialOpcode.IAG);
    addEEnumLiteral(specialOpcodeEEnum, SpecialOpcode.IAS);
    addEEnumLiteral(specialOpcodeEEnum, SpecialOpcode.RFI);
    addEEnumLiteral(specialOpcodeEEnum, SpecialOpcode.IAQ);
    addEEnumLiteral(specialOpcodeEEnum, SpecialOpcode.HWN);
    addEEnumLiteral(specialOpcodeEEnum, SpecialOpcode.HWQ);
    addEEnumLiteral(specialOpcodeEEnum, SpecialOpcode.HWI);

    initEEnum(standardRegisterEEnum, StandardRegister.class, "StandardRegister");
    addEEnumLiteral(standardRegisterEEnum, StandardRegister.A);
    addEEnumLiteral(standardRegisterEEnum, StandardRegister.B);
    addEEnumLiteral(standardRegisterEEnum, StandardRegister.C);
    addEEnumLiteral(standardRegisterEEnum, StandardRegister.X);
    addEEnumLiteral(standardRegisterEEnum, StandardRegister.Y);
    addEEnumLiteral(standardRegisterEEnum, StandardRegister.Z);
    addEEnumLiteral(standardRegisterEEnum, StandardRegister.I);
    addEEnumLiteral(standardRegisterEEnum, StandardRegister.J);

    initEEnum(specialRegisterEEnum, SpecialRegister.class, "SpecialRegister");
    addEEnumLiteral(specialRegisterEEnum, SpecialRegister.SP);
    addEEnumLiteral(specialRegisterEEnum, SpecialRegister.PC);
    addEEnumLiteral(specialRegisterEEnum, SpecialRegister.EX);

    initEEnum(operatorEEnum, Operator.class, "Operator");
    addEEnumLiteral(operatorEEnum, Operator.ADD);
    addEEnumLiteral(operatorEEnum, Operator.SUBTRACT);
    addEEnumLiteral(operatorEEnum, Operator.MULTIPLY);
    addEEnumLiteral(operatorEEnum, Operator.DIVIDE);
    addEEnumLiteral(operatorEEnum, Operator.MODULUS);
    addEEnumLiteral(operatorEEnum, Operator.LEFT_SHIFT);
    addEEnumLiteral(operatorEEnum, Operator.ARITHMETIC_RIGHT_SHIFT);
    addEEnumLiteral(operatorEEnum, Operator.LOGICAL_RIGHT_SHIFT);
    addEEnumLiteral(operatorEEnum, Operator.BITWISE_AND);
    addEEnumLiteral(operatorEEnum, Operator.BITWISE_OR);
    addEEnumLiteral(operatorEEnum, Operator.BITWISE_XOR);
    addEEnumLiteral(operatorEEnum, Operator.BITWISE_NOT);
    addEEnumLiteral(operatorEEnum, Operator.LOGICAL_NOT);
    addEEnumLiteral(operatorEEnum, Operator.EQUAL);
    addEEnumLiteral(operatorEEnum, Operator.NOT_EQUAL);
    addEEnumLiteral(operatorEEnum, Operator.GREATER);
    addEEnumLiteral(operatorEEnum, Operator.GREATER_OR_EQUAL);
    addEEnumLiteral(operatorEEnum, Operator.LESS);
    addEEnumLiteral(operatorEEnum, Operator.LESS_OR_EQUAL);
    addEEnumLiteral(operatorEEnum, Operator.LOGICAL_AND);
    addEEnumLiteral(operatorEEnum, Operator.LOGICAL_OR);
    addEEnumLiteral(operatorEEnum, Operator.CONDITIONAL_TRUE);
    addEEnumLiteral(operatorEEnum, Operator.CONDITIONAL_FALSE);

    // Create resource
    createResource(eNS_URI);
  }

} //DASMPackageImpl
