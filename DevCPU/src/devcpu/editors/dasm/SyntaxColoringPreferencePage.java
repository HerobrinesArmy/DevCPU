package devcpu.editors.dasm;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import devcpu.Activator;

public class SyntaxColoringPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {
	ColorFieldEditor stringColorE;
	BooleanFieldEditor stringBoldE;
	ColorFieldEditor commentColorE;
	BooleanFieldEditor commentBoldE;
	ColorFieldEditor opCodeForegroundE;
	BooleanFieldEditor opCodeBoldE;
	ColorFieldEditor docColorE;
	BooleanFieldEditor docBoldE;
	private ColorFieldEditor opCodeBackgroundE;
	private BooleanFieldEditor opCodeItalicE;
	
	public SyntaxColoringPreferencePage() {
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Syntax highlighting preferences for the DCPU-16 Assembly Language editor");
	}
	
	public void createFieldEditors() {
		//TODO stuff
		opCodeForegroundE = new ColorFieldEditor("OPCODE_FOREGROUND", "OpCodes: Foreground Color", getFieldEditorParent());
		addField(opCodeForegroundE);
		opCodeBackgroundE = new ColorFieldEditor("OPCODE_BACKGROUND", "OpCodes: Background Color", getFieldEditorParent());
		addField(opCodeBackgroundE);
		opCodeBoldE = new BooleanFieldEditor("OPCODE_BOLD", "Bold", getFieldEditorParent());
		addField(opCodeBoldE);
		opCodeItalicE = new BooleanFieldEditor("OPCODE_ITALIC", "Italic", getFieldEditorParent());
		addField(opCodeItalicE);
		stringColorE = new ColorFieldEditor("STRINGCOLOR", "Strings: Color", getFieldEditorParent());
		addField(stringColorE);
		stringBoldE = new BooleanFieldEditor("STRINGBOLD", "&Bold style", getFieldEditorParent());
		addField(stringBoldE);
		docColorE = new ColorFieldEditor("DOCCOLOR", "&Documentation: Color", getFieldEditorParent());
		addField(docColorE);
		docBoldE = new BooleanFieldEditor("DOCBOLD", "Bold s&tyle", getFieldEditorParent());
		addField(docBoldE);
		commentColorE = new ColorFieldEditor("COMMENTCOLOR", "&Comments: Color", getFieldEditorParent());
		addField(commentColorE);
		commentBoldE = new BooleanFieldEditor("COMMENTBOLD", "B&old style", getFieldEditorParent());
		addField(commentBoldE);
	}
	
	public void init(IWorkbench workbench) {
	}
	
	/** 
	 * Saves the preferences to the preference store
	 */
	public boolean performOk() {
		docColorE.store();
		docBoldE.store();
		commentColorE.store();
		commentBoldE.store();
		opCodeForegroundE.store();
		opCodeBoldE.store();
		stringColorE.store();
		stringBoldE.store();
		return super.performOk();
	}
}