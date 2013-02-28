package devcpu.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import devcpu.dASM.BasicInstruction;
import devcpu.dASM.DASMPackage;
import devcpu.dASM.DataLine;
import devcpu.dASM.IncludeDirective;
import devcpu.dASM.Label;
import devcpu.dASM.LineDefinition;
import devcpu.dASM.Literal;
import devcpu.dASM.LiteralAddress;
import devcpu.dASM.LiteralExpression;
import devcpu.dASM.NonGroupOperand;
import devcpu.dASM.Operation;
import devcpu.dASM.OriginDirective;
import devcpu.dASM.PickValue;
import devcpu.dASM.Register;
import devcpu.dASM.SpecialInstruction;
import devcpu.services.DASMGrammarAccess;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class DASMSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private DASMGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == DASMPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case DASMPackage.BASIC_INSTRUCTION:
				if(context == grammarAccess.getBasicInstructionRule() ||
				   context == grammarAccess.getInstructionRule() ||
				   context == grammarAccess.getLineContentRule()) {
					sequence_BasicInstruction(context, (BasicInstruction) semanticObject); 
					return; 
				}
				else break;
			case DASMPackage.DATA_LINE:
				if(context == grammarAccess.getDataLineRule() ||
				   context == grammarAccess.getLineContentRule()) {
					sequence_DataLine(context, (DataLine) semanticObject); 
					return; 
				}
				else break;
			case DASMPackage.INCLUDE_DIRECTIVE:
				if(context == grammarAccess.getDirectiveRule() ||
				   context == grammarAccess.getIncludeDirectiveRule() ||
				   context == grammarAccess.getLineContentRule()) {
					sequence_IncludeDirective(context, (IncludeDirective) semanticObject); 
					return; 
				}
				else break;
			case DASMPackage.LABEL:
				if(context == grammarAccess.getLabelRule()) {
					sequence_Label(context, (Label) semanticObject); 
					return; 
				}
				else break;
			case DASMPackage.LINE_DEFINITION:
				if(context == grammarAccess.getLineDefinitionRule() ||
				   context == grammarAccess.getModelRule() ||
				   context == grammarAccess.getModelAccess().getOperationLeftAction_1_0()) {
					sequence_LineDefinition(context, (LineDefinition) semanticObject); 
					return; 
				}
				else break;
			case DASMPackage.LITERAL:
				if(context == grammarAccess.getLiteralRule() ||
				   context == grammarAccess.getNonGroupOperandRule()) {
					sequence_Literal(context, (Literal) semanticObject); 
					return; 
				}
				else break;
			case DASMPackage.LITERAL_ADDRESS:
				if(context == grammarAccess.getLiteralAddressRule()) {
					sequence_LiteralAddress(context, (LiteralAddress) semanticObject); 
					return; 
				}
				else break;
			case DASMPackage.LITERAL_EXPRESSION:
				if(context == grammarAccess.getAddressExpressionRule() ||
				   context == grammarAccess.getLiteralExpressionRule() ||
				   context == grammarAccess.getLiteralExpressionAccess().getOperationLeftAction_1_0() ||
				   context == grammarAccess.getTerminalExpressionRule() ||
				   context == grammarAccess.getValueRule()) {
					sequence_TerminalExpression(context, (LiteralExpression) semanticObject); 
					return; 
				}
				else break;
			case DASMPackage.NON_GROUP_OPERAND:
				if(context == grammarAccess.getNonGroupOperandRule()) {
					sequence_NonGroupOperand(context, (NonGroupOperand) semanticObject); 
					return; 
				}
				else break;
			case DASMPackage.OPERATION:
				if(context == grammarAccess.getAddressExpressionRule() ||
				   context == grammarAccess.getLiteralExpressionRule() ||
				   context == grammarAccess.getLiteralExpressionAccess().getOperationLeftAction_1_0() ||
				   context == grammarAccess.getTerminalExpressionRule() ||
				   context == grammarAccess.getValueRule()) {
					sequence_LiteralExpression(context, (Operation) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getModelRule()) {
					sequence_Model(context, (Operation) semanticObject); 
					return; 
				}
				else break;
			case DASMPackage.ORIGIN_DIRECTIVE:
				if(context == grammarAccess.getDirectiveRule() ||
				   context == grammarAccess.getLineContentRule() ||
				   context == grammarAccess.getOriginDirectiveRule()) {
					sequence_OriginDirective(context, (OriginDirective) semanticObject); 
					return; 
				}
				else break;
			case DASMPackage.PICK_VALUE:
				if(context == grammarAccess.getNonGroupOperandRule() ||
				   context == grammarAccess.getPickValueRule() ||
				   context == grammarAccess.getStackValueRule()) {
					sequence_PickValue(context, (PickValue) semanticObject); 
					return; 
				}
				else break;
			case DASMPackage.REGISTER:
				if(context == grammarAccess.getNonGroupOperandRule() ||
				   context == grammarAccess.getRegisterRule()) {
					sequence_Register(context, (Register) semanticObject); 
					return; 
				}
				else break;
			case DASMPackage.SPECIAL_INSTRUCTION:
				if(context == grammarAccess.getInstructionRule() ||
				   context == grammarAccess.getLineContentRule() ||
				   context == grammarAccess.getSpecialInstructionRule()) {
					sequence_SpecialInstruction(context, (SpecialInstruction) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (opcode=BasicOpcode b=Value a=Value)
	 */
	protected void sequence_BasicInstruction(EObject context, BasicInstruction semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DASMPackage.Literals.INSTRUCTION__A) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DASMPackage.Literals.INSTRUCTION__A));
			if(transientValues.isValueTransient(semanticObject, DASMPackage.Literals.BASIC_INSTRUCTION__OPCODE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DASMPackage.Literals.BASIC_INSTRUCTION__OPCODE));
			if(transientValues.isValueTransient(semanticObject, DASMPackage.Literals.BASIC_INSTRUCTION__B) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DASMPackage.Literals.BASIC_INSTRUCTION__B));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getBasicInstructionAccess().getOpcodeBasicOpcodeEnumRuleCall_0_0(), semanticObject.getOpcode());
		feeder.accept(grammarAccess.getBasicInstructionAccess().getBValueParserRuleCall_1_0(), semanticObject.getB());
		feeder.accept(grammarAccess.getBasicInstructionAccess().getAValueParserRuleCall_3_0(), semanticObject.getA());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     dataElements+=DataElement+
	 */
	protected void sequence_DataLine(EObject context, DataLine semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=STRING
	 */
	protected void sequence_IncludeDirective(EObject context, IncludeDirective semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DASMPackage.Literals.INCLUDE_DIRECTIVE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DASMPackage.Literals.INCLUDE_DIRECTIVE__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getIncludeDirectiveAccess().getNameSTRINGTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_Label(EObject context, Label semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DASMPackage.Literals.LABEL__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DASMPackage.Literals.LABEL__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getLabelAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (labels+=Label* content=LineContent? comment=SL_COMMENT?)
	 */
	protected void sequence_LineDefinition(EObject context, LineDefinition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (number=Number | labelName=[Label|ID])
	 */
	protected void sequence_LiteralAddress(EObject context, LiteralAddress semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=LiteralExpression_Operation_1_0 op=Operator right=LiteralExpression)
	 */
	protected void sequence_LiteralExpression(EObject context, Operation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     number=Number
	 */
	protected void sequence_Literal(EObject context, Literal semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (left=Model_Operation_1_0 right=Model)
	 */
	protected void sequence_Model(EObject context, Operation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     labelName=[Label|ID]
	 */
	protected void sequence_NonGroupOperand(EObject context, NonGroupOperand semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DASMPackage.Literals.NON_GROUP_OPERAND__LABEL_NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DASMPackage.Literals.NON_GROUP_OPERAND__LABEL_NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getNonGroupOperandAccess().getLabelNameLabelIDTerminalRuleCall_2_0_1(), semanticObject.getLabelName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     value=Number
	 */
	protected void sequence_OriginDirective(EObject context, OriginDirective semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DASMPackage.Literals.ORIGIN_DIRECTIVE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DASMPackage.Literals.ORIGIN_DIRECTIVE__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getOriginDirectiveAccess().getValueNumberParserRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     pickValue=LiteralExpression
	 */
	protected void sequence_PickValue(EObject context, PickValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (standardRegister=StandardRegister | specialRegister=SpecialRegister)
	 */
	protected void sequence_Register(EObject context, Register semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (opcode=SpecialOpcode a=Value)
	 */
	protected void sequence_SpecialInstruction(EObject context, SpecialInstruction semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DASMPackage.Literals.INSTRUCTION__A) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DASMPackage.Literals.INSTRUCTION__A));
			if(transientValues.isValueTransient(semanticObject, DASMPackage.Literals.SPECIAL_INSTRUCTION__OPCODE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DASMPackage.Literals.SPECIAL_INSTRUCTION__OPCODE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSpecialInstructionAccess().getOpcodeSpecialOpcodeEnumRuleCall_0_0(), semanticObject.getOpcode());
		feeder.accept(grammarAccess.getSpecialInstructionAccess().getAValueParserRuleCall_1_0(), semanticObject.getA());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     value=NonGroupOperand
	 */
	protected void sequence_TerminalExpression(EObject context, LiteralExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DASMPackage.Literals.LITERAL_EXPRESSION__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DASMPackage.Literals.LITERAL_EXPRESSION__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getTerminalExpressionAccess().getValueNonGroupOperandParserRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
}
