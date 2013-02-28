/**
 */
package devcpu.dASM;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see devcpu.dASM.DASMPackage
 * @generated
 */
public interface DASMFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  DASMFactory eINSTANCE = devcpu.dASM.impl.DASMFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  Model createModel();

  /**
   * Returns a new object of class '<em>Line Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Line Definition</em>'.
   * @generated
   */
  LineDefinition createLineDefinition();

  /**
   * Returns a new object of class '<em>Line Content</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Line Content</em>'.
   * @generated
   */
  LineContent createLineContent();

  /**
   * Returns a new object of class '<em>Directive</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Directive</em>'.
   * @generated
   */
  Directive createDirective();

  /**
   * Returns a new object of class '<em>Origin Directive</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Origin Directive</em>'.
   * @generated
   */
  OriginDirective createOriginDirective();

  /**
   * Returns a new object of class '<em>Include Directive</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Include Directive</em>'.
   * @generated
   */
  IncludeDirective createIncludeDirective();

  /**
   * Returns a new object of class '<em>Data Line</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Data Line</em>'.
   * @generated
   */
  DataLine createDataLine();

  /**
   * Returns a new object of class '<em>Literal Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Literal Expression</em>'.
   * @generated
   */
  LiteralExpression createLiteralExpression();

  /**
   * Returns a new object of class '<em>Non Group Operand</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Non Group Operand</em>'.
   * @generated
   */
  NonGroupOperand createNonGroupOperand();

  /**
   * Returns a new object of class '<em>Stack Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Stack Value</em>'.
   * @generated
   */
  StackValue createStackValue();

  /**
   * Returns a new object of class '<em>Pick Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pick Value</em>'.
   * @generated
   */
  PickValue createPickValue();

  /**
   * Returns a new object of class '<em>Label</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Label</em>'.
   * @generated
   */
  Label createLabel();

  /**
   * Returns a new object of class '<em>Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Instruction</em>'.
   * @generated
   */
  Instruction createInstruction();

  /**
   * Returns a new object of class '<em>Basic Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Basic Instruction</em>'.
   * @generated
   */
  BasicInstruction createBasicInstruction();

  /**
   * Returns a new object of class '<em>Special Instruction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Special Instruction</em>'.
   * @generated
   */
  SpecialInstruction createSpecialInstruction();

  /**
   * Returns a new object of class '<em>Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Value</em>'.
   * @generated
   */
  Value createValue();

  /**
   * Returns a new object of class '<em>Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Literal</em>'.
   * @generated
   */
  Literal createLiteral();

  /**
   * Returns a new object of class '<em>Register</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Register</em>'.
   * @generated
   */
  Register createRegister();

  /**
   * Returns a new object of class '<em>Literal Address</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Literal Address</em>'.
   * @generated
   */
  LiteralAddress createLiteralAddress();

  /**
   * Returns a new object of class '<em>Address Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Address Expression</em>'.
   * @generated
   */
  AddressExpression createAddressExpression();

  /**
   * Returns a new object of class '<em>Operation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Operation</em>'.
   * @generated
   */
  Operation createOperation();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  DASMPackage getDASMPackage();

} //DASMFactory
