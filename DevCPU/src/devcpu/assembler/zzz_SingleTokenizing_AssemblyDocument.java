//package devcpu.assembler;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.LinkedHashMap;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//import org.eclipse.core.resources.IFile;
//import org.eclipse.core.resources.ResourcesPlugin;
//import org.eclipse.core.runtime.CoreException;
//import org.eclipse.core.runtime.Path;
//
//import devcpu.assembler.exceptions.AbstractAssemblyException;
//import devcpu.assembler.exceptions.IncludeFileNotFoundException;
//import devcpu.assembler.exceptions.RecursiveInclusionException;
//import devcpu.lexer.Lexer;
//
//public class zzz_SingleTokenizing_AssemblyDocument {
//	private static final Pattern includePattern = Pattern.compile("\\s*[\\.#](include|import)\\b[\\s\\,]*([^;\\r\\n]*)", Pattern.CASE_INSENSITIVE);
//	private static final Pattern definePattern = Pattern.compile("\\s*[\\.#](define)\\b[\\s\\,]*(" + Lexer.REGEX_IDENTIFIER + ")\\s*([^;\\r\\n]*)", Pattern.CASE_INSENSITIVE);
//	private IFile file;
//	private Assembly assembly;
//	private zzz_SingleTokenizing_AssemblyDocument parent;
//	private ArrayList<AssemblyLine> lines = new ArrayList<AssemblyLine>();
////	private ArrayList<Directive> directives = new ArrayList<Directive>();
//	private LinkedHashMap<AssemblyLine,zzz_SingleTokenizing_AssemblyDocument> children = new LinkedHashMap<AssemblyLine, zzz_SingleTokenizing_AssemblyDocument>();
//
//	public zzz_SingleTokenizing_AssemblyDocument(IFile file, Assembly assembly, zzz_SingleTokenizing_AssemblyDocument parent) {
//		this.file = file;
//		//TODO This setup sucks. Documents should be dumb and shouldn't need a reference to the assembly. Rework this in a later release.
//		this.assembly = assembly;
//		this.parent = parent;
//	}
//
//	public void readLines() throws IOException, CoreException, AbstractAssemblyException {
//		//TODO prompt if unsync?
//		//TODO Don't tokenize until preprocess; just read in and check for includes and defines
//		BufferedReader isr = new BufferedReader(new InputStreamReader(file.getContents(true)));
//		String lineText = null;
//		int n = 0;
//		while((lineText=isr.readLine()) != null) {
//			AssemblyLine line = new AssemblyLine(this, ++n, lineText);
//			Matcher m = includePattern.matcher(lineText);
//			if (m.find() && m.start() == 0) {
//				zzz_SingleTokenizing_AssemblyDocument doc = loadInclude(line, m.group(2).replaceAll("[\"\'\\<\\>]", "").trim());
//				children.put(line,doc);
//				doc.readLines();
//			}
//			m = definePattern.matcher(lineText);
//			if (m.find() && m.start() == 0) {
//				Define define = new Define(line, m.group(2), m.group(3));
//				line.define = define;
//				assembly.defines.put(define.getKey(), define);
//			}
//			lines.add(line);
//			assembly.lines.add(line);
//		}		
//	}
//
//	public IFile getFile() {
//		return file;
//	}
//
//	public ArrayList<AssemblyLine> getLines() {
//		return lines;
//	}
//
////	public ArrayList<Directive> getDirectives() {
////		return directives;
////	}
//
//	public Assembly getAssembly() {
//		return assembly;
//	}
//	
//	public LinkedHashMap<AssemblyLine, zzz_SingleTokenizing_AssemblyDocument> getChildren() {
//		return children;
//	}
//
//	public boolean isRoot() {
//		return parent == null;
//	}
//	
//	public zzz_SingleTokenizing_AssemblyDocument getParent() {
//		return parent;
//	}
//
//	private zzz_SingleTokenizing_AssemblyDocument loadInclude(AssemblyLine line, String path) throws AbstractAssemblyException, IOException, CoreException {
//		IFile includeFile = locate(path);
//		if (includeFile == null) {
//			throw new IncludeFileNotFoundException(line, path);
//		}
//		if (checkForAncestor(includeFile)) {
//			throw new RecursiveInclusionException(line, includeFile);
//		}
//		return new zzz_SingleTokenizing_AssemblyDocument(includeFile, assembly, this);
//	}
//
//	private boolean checkForAncestor(IFile includeFile) {
//		zzz_SingleTokenizing_AssemblyDocument ancestor = this;
//		while (ancestor != null) {
//			if (ancestor.file.equals(includeFile)) {
//				return true;
//			}
//			ancestor = ancestor.getParent();
//		}
//		return false;
//	}
//
//	private IFile locate(String pathString) {
//		Path path = new Path(pathString);
//		//First, treat as path relative to current file ("../" is supported)
//    IFile located = file.getParent().getFile(path);
//    if (located.exists()) {
//    	return located;
//    }
//    //Second, treat as path relative to project root
//    located = file.getProject().getFile(path);
//    if (located.exists()) {
//    	return located;
//    }
//    //Third, treat as path relative to workspace root
//    located = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
//    if (located.exists()) {
//    	return located;
//    }
//    //TODO: Check for local filesystem paths too?
//    //TODO: Maybe even Internet URLs?
//    return null;
////    String osfile = file.getRawLocation().toOSString();
//	}
//}
