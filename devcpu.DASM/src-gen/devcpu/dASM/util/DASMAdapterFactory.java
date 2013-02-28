/**
 */
package devcpu.dASM.util;

import devcpu.dASM.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see devcpu.dASM.DASMPackage
 * @generated
 */
public class DASMAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static DASMPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DASMAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = DASMPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DASMSwitch<Adapter> modelSwitch =
    new DASMSwitch<Adapter>()
    {
      @Override
      public Adapter caseModel(Model object)
      {
        return createModelAdapter();
      }
      @Override
      public Adapter caseLineDefinition(LineDefinition object)
      {
        return createLineDefinitionAdapter();
      }
      @Override
      public Adapter caseLineContent(LineContent object)
      {
        return createLineContentAdapter();
      }
      @Override
      public Adapter caseDirective(Directive object)
      {
        return createDirectiveAdapter();
      }
      @Override
      public Adapter caseOriginDirective(OriginDirective object)
      {
        return createOriginDirectiveAdapter();
      }
      @Override
      public Adapter caseIncludeDirective(IncludeDirective object)
      {
        return createIncludeDirectiveAdapter();
      }
      @Override
      public Adapter caseDataLine(DataLine object)
      {
        return createDataLineAdapter();
      }
      @Override
      public Adapter caseLiteralExpression(LiteralExpression object)
      {
        return createLiteralExpressionAdapter();
      }
      @Override
      public Adapter caseNonGroupOperand(NonGroupOperand object)
      {
        return createNonGroupOperandAdapter();
      }
      @Override
      public Adapter caseStackValue(StackValue object)
      {
        return createStackValueAdapter();
      }
      @Override
      public Adapter casePickValue(PickValue object)
      {
        return createPickValueAdapter();
      }
      @Override
      public Adapter caseLabel(Label object)
      {
        return createLabelAdapter();
      }
      @Override
      public Adapter caseInstruction(Instruction object)
      {
        return createInstructionAdapter();
      }
      @Override
      public Adapter caseBasicInstruction(BasicInstruction object)
      {
        return createBasicInstructionAdapter();
      }
      @Override
      public Adapter caseSpecialInstruction(SpecialInstruction object)
      {
        return createSpecialInstructionAdapter();
      }
      @Override
      public Adapter caseValue(Value object)
      {
        return createValueAdapter();
      }
      @Override
      public Adapter caseLiteral(Literal object)
      {
        return createLiteralAdapter();
      }
      @Override
      public Adapter caseRegister(Register object)
      {
        return createRegisterAdapter();
      }
      @Override
      public Adapter caseLiteralAddress(LiteralAddress object)
      {
        return createLiteralAddressAdapter();
      }
      @Override
      public Adapter caseAddressExpression(AddressExpression object)
      {
        return createAddressExpressionAdapter();
      }
      @Override
      public Adapter caseOperation(Operation object)
      {
        return createOperationAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link devcpu.dASM.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see devcpu.dASM.Model
   * @generated
   */
  public Adapter createModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link devcpu.dASM.LineDefinition <em>Line Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see devcpu.dASM.LineDefinition
   * @generated
   */
  public Adapter createLineDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link devcpu.dASM.LineContent <em>Line Content</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see devcpu.dASM.LineContent
   * @generated
   */
  public Adapter createLineContentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link devcpu.dASM.Directive <em>Directive</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see devcpu.dASM.Directive
   * @generated
   */
  public Adapter createDirectiveAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link devcpu.dASM.OriginDirective <em>Origin Directive</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see devcpu.dASM.OriginDirective
   * @generated
   */
  public Adapter createOriginDirectiveAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link devcpu.dASM.IncludeDirective <em>Include Directive</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see devcpu.dASM.IncludeDirective
   * @generated
   */
  public Adapter createIncludeDirectiveAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link devcpu.dASM.DataLine <em>Data Line</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see devcpu.dASM.DataLine
   * @generated
   */
  public Adapter createDataLineAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link devcpu.dASM.LiteralExpression <em>Literal Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see devcpu.dASM.LiteralExpression
   * @generated
   */
  public Adapter createLiteralExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link devcpu.dASM.NonGroupOperand <em>Non Group Operand</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see devcpu.dASM.NonGroupOperand
   * @generated
   */
  public Adapter createNonGroupOperandAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link devcpu.dASM.StackValue <em>Stack Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see devcpu.dASM.StackValue
   * @generated
   */
  public Adapter createStackValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link devcpu.dASM.PickValue <em>Pick Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see devcpu.dASM.PickValue
   * @generated
   */
  public Adapter createPickValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link devcpu.dASM.Label <em>Label</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see devcpu.dASM.Label
   * @generated
   */
  public Adapter createLabelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link devcpu.dASM.Instruction <em>Instruction</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see devcpu.dASM.Instruction
   * @generated
   */
  public Adapter createInstructionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link devcpu.dASM.BasicInstruction <em>Basic Instruction</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see devcpu.dASM.BasicInstruction
   * @generated
   */
  public Adapter createBasicInstructionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link devcpu.dASM.SpecialInstruction <em>Special Instruction</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see devcpu.dASM.SpecialInstruction
   * @generated
   */
  public Adapter createSpecialInstructionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link devcpu.dASM.Value <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see devcpu.dASM.Value
   * @generated
   */
  public Adapter createValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link devcpu.dASM.Literal <em>Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see devcpu.dASM.Literal
   * @generated
   */
  public Adapter createLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link devcpu.dASM.Register <em>Register</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see devcpu.dASM.Register
   * @generated
   */
  public Adapter createRegisterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link devcpu.dASM.LiteralAddress <em>Literal Address</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see devcpu.dASM.LiteralAddress
   * @generated
   */
  public Adapter createLiteralAddressAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link devcpu.dASM.AddressExpression <em>Address Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see devcpu.dASM.AddressExpression
   * @generated
   */
  public Adapter createAddressExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link devcpu.dASM.Operation <em>Operation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see devcpu.dASM.Operation
   * @generated
   */
  public Adapter createOperationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //DASMAdapterFactory
