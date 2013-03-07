/*
* generated by Xtext
*/
package devcpu.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import devcpu.services.DASMGrammarAccess;

public class DASMParser extends AbstractContentAssistParser {
	
	@Inject
	private DASMGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected devcpu.ui.contentassist.antlr.internal.InternalDASMParser createParser() {
		devcpu.ui.contentassist.antlr.internal.InternalDASMParser result = new devcpu.ui.contentassist.antlr.internal.InternalDASMParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getLineContentAccess().getAlternatives(), "rule__LineContent__Alternatives");
					put(grammarAccess.getDirectiveAccess().getAlternatives(), "rule__Directive__Alternatives");
					put(grammarAccess.getOriginDirectiveAccess().getAlternatives_0(), "rule__OriginDirective__Alternatives_0");
					put(grammarAccess.getIncludeDirectiveAccess().getAlternatives_0(), "rule__IncludeDirective__Alternatives_0");
					put(grammarAccess.getDataLineAccess().getAlternatives_0(), "rule__DataLine__Alternatives_0");
					put(grammarAccess.getDataElementAccess().getAlternatives(), "rule__DataElement__Alternatives");
					put(grammarAccess.getTerminalExpressionAccess().getAlternatives(), "rule__TerminalExpression__Alternatives");
					put(grammarAccess.getNonGroupOperandAccess().getAlternatives(), "rule__NonGroupOperand__Alternatives");
					put(grammarAccess.getStackValueAccess().getAlternatives(), "rule__StackValue__Alternatives");
					put(grammarAccess.getInstructionAccess().getAlternatives(), "rule__Instruction__Alternatives");
					put(grammarAccess.getValueAccess().getAlternatives(), "rule__Value__Alternatives");
					put(grammarAccess.getRegisterAccess().getAlternatives(), "rule__Register__Alternatives");
					put(grammarAccess.getLiteralAddressAccess().getAlternatives_1(), "rule__LiteralAddress__Alternatives_1");
					put(grammarAccess.getNumberAccess().getAlternatives(), "rule__Number__Alternatives");
					put(grammarAccess.getBasicOpcodeAccess().getAlternatives(), "rule__BasicOpcode__Alternatives");
					put(grammarAccess.getSpecialOpcodeAccess().getAlternatives(), "rule__SpecialOpcode__Alternatives");
					put(grammarAccess.getStandardRegisterAccess().getAlternatives(), "rule__StandardRegister__Alternatives");
					put(grammarAccess.getSpecialRegisterAccess().getAlternatives(), "rule__SpecialRegister__Alternatives");
					put(grammarAccess.getOperatorAccess().getAlternatives(), "rule__Operator__Alternatives");
					put(grammarAccess.getModelAccess().getGroup(), "rule__Model__Group__0");
					put(grammarAccess.getModelAccess().getGroup_1(), "rule__Model__Group_1__0");
					put(grammarAccess.getLineDefinitionAccess().getGroup(), "rule__LineDefinition__Group__0");
					put(grammarAccess.getOriginDirectiveAccess().getGroup(), "rule__OriginDirective__Group__0");
					put(grammarAccess.getIncludeDirectiveAccess().getGroup(), "rule__IncludeDirective__Group__0");
					put(grammarAccess.getDataLineAccess().getGroup(), "rule__DataLine__Group__0");
					put(grammarAccess.getDataLineAccess().getGroup_1(), "rule__DataLine__Group_1__0");
					put(grammarAccess.getLiteralExpressionAccess().getGroup(), "rule__LiteralExpression__Group__0");
					put(grammarAccess.getLiteralExpressionAccess().getGroup_1(), "rule__LiteralExpression__Group_1__0");
					put(grammarAccess.getTerminalExpressionAccess().getGroup_0(), "rule__TerminalExpression__Group_0__0");
					put(grammarAccess.getPickValueAccess().getGroup(), "rule__PickValue__Group__0");
					put(grammarAccess.getLabelAccess().getGroup(), "rule__Label__Group__0");
					put(grammarAccess.getBasicInstructionAccess().getGroup(), "rule__BasicInstruction__Group__0");
					put(grammarAccess.getSpecialInstructionAccess().getGroup(), "rule__SpecialInstruction__Group__0");
					put(grammarAccess.getLiteralAddressAccess().getGroup(), "rule__LiteralAddress__Group__0");
					put(grammarAccess.getAddressExpressionAccess().getGroup(), "rule__AddressExpression__Group__0");
					put(grammarAccess.getModelAccess().getRightAssignment_1_2(), "rule__Model__RightAssignment_1_2");
					put(grammarAccess.getLineDefinitionAccess().getLabelsAssignment_0(), "rule__LineDefinition__LabelsAssignment_0");
					put(grammarAccess.getLineDefinitionAccess().getContentAssignment_1(), "rule__LineDefinition__ContentAssignment_1");
					put(grammarAccess.getLineDefinitionAccess().getCommentAssignment_2(), "rule__LineDefinition__CommentAssignment_2");
					put(grammarAccess.getOriginDirectiveAccess().getValueAssignment_1(), "rule__OriginDirective__ValueAssignment_1");
					put(grammarAccess.getIncludeDirectiveAccess().getNameAssignment_1(), "rule__IncludeDirective__NameAssignment_1");
					put(grammarAccess.getDataLineAccess().getDataElementsAssignment_1_1(), "rule__DataLine__DataElementsAssignment_1_1");
					put(grammarAccess.getLiteralExpressionAccess().getOpAssignment_1_1(), "rule__LiteralExpression__OpAssignment_1_1");
					put(grammarAccess.getLiteralExpressionAccess().getRightAssignment_1_2(), "rule__LiteralExpression__RightAssignment_1_2");
					put(grammarAccess.getTerminalExpressionAccess().getValueAssignment_1(), "rule__TerminalExpression__ValueAssignment_1");
					put(grammarAccess.getNonGroupOperandAccess().getLabelNameAssignment_2(), "rule__NonGroupOperand__LabelNameAssignment_2");
					put(grammarAccess.getPickValueAccess().getPickValueAssignment_1(), "rule__PickValue__PickValueAssignment_1");
					put(grammarAccess.getLabelAccess().getNameAssignment_1(), "rule__Label__NameAssignment_1");
					put(grammarAccess.getBasicInstructionAccess().getOpcodeAssignment_0(), "rule__BasicInstruction__OpcodeAssignment_0");
					put(grammarAccess.getBasicInstructionAccess().getBAssignment_1(), "rule__BasicInstruction__BAssignment_1");
					put(grammarAccess.getBasicInstructionAccess().getAAssignment_3(), "rule__BasicInstruction__AAssignment_3");
					put(grammarAccess.getSpecialInstructionAccess().getOpcodeAssignment_0(), "rule__SpecialInstruction__OpcodeAssignment_0");
					put(grammarAccess.getSpecialInstructionAccess().getAAssignment_1(), "rule__SpecialInstruction__AAssignment_1");
					put(grammarAccess.getLiteralAccess().getNumberAssignment(), "rule__Literal__NumberAssignment");
					put(grammarAccess.getRegisterAccess().getStandardRegisterAssignment_0(), "rule__Register__StandardRegisterAssignment_0");
					put(grammarAccess.getRegisterAccess().getSpecialRegisterAssignment_1(), "rule__Register__SpecialRegisterAssignment_1");
					put(grammarAccess.getLiteralAddressAccess().getNumberAssignment_1_0(), "rule__LiteralAddress__NumberAssignment_1_0");
					put(grammarAccess.getLiteralAddressAccess().getLabelNameAssignment_1_1(), "rule__LiteralAddress__LabelNameAssignment_1_1");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			devcpu.ui.contentassist.antlr.internal.InternalDASMParser typedParser = (devcpu.ui.contentassist.antlr.internal.InternalDASMParser) parser;
			typedParser.entryRuleModel();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS" };
	}
	
	public DASMGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(DASMGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}