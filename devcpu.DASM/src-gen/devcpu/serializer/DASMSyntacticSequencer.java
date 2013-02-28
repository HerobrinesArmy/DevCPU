package devcpu.serializer;

import com.google.inject.Inject;
import devcpu.services.DASMGrammarAccess;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class DASMSyntacticSequencer extends AbstractSyntacticSequencer {

	protected DASMGrammarAccess grammarAccess;
	protected AbstractElementAlias match_AddressExpression_LeftSquareBracketKeyword_0_q;
	protected AbstractElementAlias match_BasicInstruction_CommaKeyword_2_q;
	protected AbstractElementAlias match_DataLine_CommaKeyword_1_0_a;
	protected AbstractElementAlias match_DataLine_CommaKeyword_1_2_a;
	protected AbstractElementAlias match_DataLine_DATKeyword_0_0_or_DatKeyword_0_1;
	protected AbstractElementAlias match_IncludeDirective_ImportKeyword_0_2_or_ImportKeyword_0_3_or_IncludeKeyword_0_0_or_IncludeKeyword_0_1;
	protected AbstractElementAlias match_OriginDirective_AlignKeyword_0_2_or_AlignKeyword_0_3_or_OriginKeyword_0_0_or_OriginKeyword_0_1;
	protected AbstractElementAlias match_StackValue_POPKeyword_0_or_PUSHKeyword_1;
	protected AbstractElementAlias match_TerminalExpression_LeftParenthesisKeyword_0_0_a;
	protected AbstractElementAlias match_TerminalExpression_LeftParenthesisKeyword_0_0_p;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (DASMGrammarAccess) access;
		match_AddressExpression_LeftSquareBracketKeyword_0_q = new TokenAlias(false, true, grammarAccess.getAddressExpressionAccess().getLeftSquareBracketKeyword_0());
		match_BasicInstruction_CommaKeyword_2_q = new TokenAlias(false, true, grammarAccess.getBasicInstructionAccess().getCommaKeyword_2());
		match_DataLine_CommaKeyword_1_0_a = new TokenAlias(true, true, grammarAccess.getDataLineAccess().getCommaKeyword_1_0());
		match_DataLine_CommaKeyword_1_2_a = new TokenAlias(true, true, grammarAccess.getDataLineAccess().getCommaKeyword_1_2());
		match_DataLine_DATKeyword_0_0_or_DatKeyword_0_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getDataLineAccess().getDATKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getDataLineAccess().getDatKeyword_0_1()));
		match_IncludeDirective_ImportKeyword_0_2_or_ImportKeyword_0_3_or_IncludeKeyword_0_0_or_IncludeKeyword_0_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getIncludeDirectiveAccess().getImportKeyword_0_2()), new TokenAlias(false, false, grammarAccess.getIncludeDirectiveAccess().getImportKeyword_0_3()), new TokenAlias(false, false, grammarAccess.getIncludeDirectiveAccess().getIncludeKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getIncludeDirectiveAccess().getIncludeKeyword_0_1()));
		match_OriginDirective_AlignKeyword_0_2_or_AlignKeyword_0_3_or_OriginKeyword_0_0_or_OriginKeyword_0_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getOriginDirectiveAccess().getAlignKeyword_0_2()), new TokenAlias(false, false, grammarAccess.getOriginDirectiveAccess().getAlignKeyword_0_3()), new TokenAlias(false, false, grammarAccess.getOriginDirectiveAccess().getOriginKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getOriginDirectiveAccess().getOriginKeyword_0_1()));
		match_StackValue_POPKeyword_0_or_PUSHKeyword_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getStackValueAccess().getPOPKeyword_0()), new TokenAlias(false, false, grammarAccess.getStackValueAccess().getPUSHKeyword_1()));
		match_TerminalExpression_LeftParenthesisKeyword_0_0_a = new TokenAlias(true, true, grammarAccess.getTerminalExpressionAccess().getLeftParenthesisKeyword_0_0());
		match_TerminalExpression_LeftParenthesisKeyword_0_0_p = new TokenAlias(true, false, grammarAccess.getTerminalExpressionAccess().getLeftParenthesisKeyword_0_0());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if(ruleCall.getRule() == grammarAccess.getNLRule())
			return getNLToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * terminal NL : (' '|'\t')* ('\r'? '\n');
	 */
	protected String getNLToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "\n";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_AddressExpression_LeftSquareBracketKeyword_0_q.equals(syntax))
				emit_AddressExpression_LeftSquareBracketKeyword_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_BasicInstruction_CommaKeyword_2_q.equals(syntax))
				emit_BasicInstruction_CommaKeyword_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DataLine_CommaKeyword_1_0_a.equals(syntax))
				emit_DataLine_CommaKeyword_1_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DataLine_CommaKeyword_1_2_a.equals(syntax))
				emit_DataLine_CommaKeyword_1_2_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DataLine_DATKeyword_0_0_or_DatKeyword_0_1.equals(syntax))
				emit_DataLine_DATKeyword_0_0_or_DatKeyword_0_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_IncludeDirective_ImportKeyword_0_2_or_ImportKeyword_0_3_or_IncludeKeyword_0_0_or_IncludeKeyword_0_1.equals(syntax))
				emit_IncludeDirective_ImportKeyword_0_2_or_ImportKeyword_0_3_or_IncludeKeyword_0_0_or_IncludeKeyword_0_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_OriginDirective_AlignKeyword_0_2_or_AlignKeyword_0_3_or_OriginKeyword_0_0_or_OriginKeyword_0_1.equals(syntax))
				emit_OriginDirective_AlignKeyword_0_2_or_AlignKeyword_0_3_or_OriginKeyword_0_0_or_OriginKeyword_0_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_StackValue_POPKeyword_0_or_PUSHKeyword_1.equals(syntax))
				emit_StackValue_POPKeyword_0_or_PUSHKeyword_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_TerminalExpression_LeftParenthesisKeyword_0_0_a.equals(syntax))
				emit_TerminalExpression_LeftParenthesisKeyword_0_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_TerminalExpression_LeftParenthesisKeyword_0_0_p.equals(syntax))
				emit_TerminalExpression_LeftParenthesisKeyword_0_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     '['?
	 */
	protected void emit_AddressExpression_LeftSquareBracketKeyword_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ','?
	 */
	protected void emit_BasicInstruction_CommaKeyword_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ','*
	 */
	protected void emit_DataLine_CommaKeyword_1_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ','*
	 */
	protected void emit_DataLine_CommaKeyword_1_2_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'DAT' | '.dat'
	 */
	protected void emit_DataLine_DATKeyword_0_0_or_DatKeyword_0_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '.import' | '#include' | '.include' | '#import'
	 */
	protected void emit_IncludeDirective_ImportKeyword_0_2_or_ImportKeyword_0_3_or_IncludeKeyword_0_0_or_IncludeKeyword_0_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '.align' | '.origin' | '#origin' | '#align'
	 */
	protected void emit_OriginDirective_AlignKeyword_0_2_or_AlignKeyword_0_3_or_OriginKeyword_0_0_or_OriginKeyword_0_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'PUSH' | 'POP'
	 */
	protected void emit_StackValue_POPKeyword_0_or_PUSHKeyword_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('*
	 */
	protected void emit_TerminalExpression_LeftParenthesisKeyword_0_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('+
	 */
	protected void emit_TerminalExpression_LeftParenthesisKeyword_0_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
