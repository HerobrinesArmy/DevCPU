/**
 */
package devcpu.dASM.util;

import devcpu.dASM.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see devcpu.dASM.DASMPackage
 * @generated
 */
public class DASMSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static DASMPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DASMSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = DASMPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case DASMPackage.MODEL:
      {
        Model model = (Model)theEObject;
        T result = caseModel(model);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DASMPackage.LINE_DEFINITION:
      {
        LineDefinition lineDefinition = (LineDefinition)theEObject;
        T result = caseLineDefinition(lineDefinition);
        if (result == null) result = caseModel(lineDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DASMPackage.LINE_CONTENT:
      {
        LineContent lineContent = (LineContent)theEObject;
        T result = caseLineContent(lineContent);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DASMPackage.DIRECTIVE:
      {
        Directive directive = (Directive)theEObject;
        T result = caseDirective(directive);
        if (result == null) result = caseLineContent(directive);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DASMPackage.ORIGIN_DIRECTIVE:
      {
        OriginDirective originDirective = (OriginDirective)theEObject;
        T result = caseOriginDirective(originDirective);
        if (result == null) result = caseDirective(originDirective);
        if (result == null) result = caseLineContent(originDirective);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DASMPackage.INCLUDE_DIRECTIVE:
      {
        IncludeDirective includeDirective = (IncludeDirective)theEObject;
        T result = caseIncludeDirective(includeDirective);
        if (result == null) result = caseDirective(includeDirective);
        if (result == null) result = caseLineContent(includeDirective);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DASMPackage.DATA_LINE:
      {
        DataLine dataLine = (DataLine)theEObject;
        T result = caseDataLine(dataLine);
        if (result == null) result = caseLineContent(dataLine);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DASMPackage.LITERAL_EXPRESSION:
      {
        LiteralExpression literalExpression = (LiteralExpression)theEObject;
        T result = caseLiteralExpression(literalExpression);
        if (result == null) result = caseAddressExpression(literalExpression);
        if (result == null) result = caseValue(literalExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DASMPackage.NON_GROUP_OPERAND:
      {
        NonGroupOperand nonGroupOperand = (NonGroupOperand)theEObject;
        T result = caseNonGroupOperand(nonGroupOperand);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DASMPackage.STACK_VALUE:
      {
        StackValue stackValue = (StackValue)theEObject;
        T result = caseStackValue(stackValue);
        if (result == null) result = caseNonGroupOperand(stackValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DASMPackage.PICK_VALUE:
      {
        PickValue pickValue = (PickValue)theEObject;
        T result = casePickValue(pickValue);
        if (result == null) result = caseStackValue(pickValue);
        if (result == null) result = caseNonGroupOperand(pickValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DASMPackage.LABEL:
      {
        Label label = (Label)theEObject;
        T result = caseLabel(label);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DASMPackage.INSTRUCTION:
      {
        Instruction instruction = (Instruction)theEObject;
        T result = caseInstruction(instruction);
        if (result == null) result = caseLineContent(instruction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DASMPackage.BASIC_INSTRUCTION:
      {
        BasicInstruction basicInstruction = (BasicInstruction)theEObject;
        T result = caseBasicInstruction(basicInstruction);
        if (result == null) result = caseInstruction(basicInstruction);
        if (result == null) result = caseLineContent(basicInstruction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DASMPackage.SPECIAL_INSTRUCTION:
      {
        SpecialInstruction specialInstruction = (SpecialInstruction)theEObject;
        T result = caseSpecialInstruction(specialInstruction);
        if (result == null) result = caseInstruction(specialInstruction);
        if (result == null) result = caseLineContent(specialInstruction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DASMPackage.VALUE:
      {
        Value value = (Value)theEObject;
        T result = caseValue(value);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DASMPackage.LITERAL:
      {
        Literal literal = (Literal)theEObject;
        T result = caseLiteral(literal);
        if (result == null) result = caseNonGroupOperand(literal);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DASMPackage.REGISTER:
      {
        Register register = (Register)theEObject;
        T result = caseRegister(register);
        if (result == null) result = caseNonGroupOperand(register);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DASMPackage.LITERAL_ADDRESS:
      {
        LiteralAddress literalAddress = (LiteralAddress)theEObject;
        T result = caseLiteralAddress(literalAddress);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DASMPackage.ADDRESS_EXPRESSION:
      {
        AddressExpression addressExpression = (AddressExpression)theEObject;
        T result = caseAddressExpression(addressExpression);
        if (result == null) result = caseValue(addressExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DASMPackage.OPERATION:
      {
        Operation operation = (Operation)theEObject;
        T result = caseOperation(operation);
        if (result == null) result = caseModel(operation);
        if (result == null) result = caseLiteralExpression(operation);
        if (result == null) result = caseAddressExpression(operation);
        if (result == null) result = caseValue(operation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModel(Model object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Line Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Line Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLineDefinition(LineDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Line Content</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Line Content</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLineContent(LineContent object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Directive</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Directive</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDirective(Directive object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Origin Directive</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Origin Directive</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOriginDirective(OriginDirective object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Include Directive</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Include Directive</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIncludeDirective(IncludeDirective object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Data Line</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Data Line</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDataLine(DataLine object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Literal Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Literal Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLiteralExpression(LiteralExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Non Group Operand</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Non Group Operand</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNonGroupOperand(NonGroupOperand object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Stack Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Stack Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStackValue(StackValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pick Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pick Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePickValue(PickValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Label</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Label</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLabel(Label object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Instruction</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Instruction</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInstruction(Instruction object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Basic Instruction</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Basic Instruction</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBasicInstruction(BasicInstruction object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Special Instruction</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Special Instruction</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSpecialInstruction(SpecialInstruction object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseValue(Value object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLiteral(Literal object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Register</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Register</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRegister(Register object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Literal Address</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Literal Address</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLiteralAddress(LiteralAddress object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Address Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Address Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAddressExpression(AddressExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Operation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Operation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOperation(Operation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //DASMSwitch
