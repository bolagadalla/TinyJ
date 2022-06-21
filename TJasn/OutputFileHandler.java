package TJasn;

import java.io.*;
import java.util.Scanner;

import TJlexer.Symbols;
import TJasn.symbolTable.*;
import TJasn.virtualMachine.Instruction;


public final class OutputFileHandler {
	protected PrintWriter outFileWriter;

	  public final PrintWriter getOutFileWriter()
	  {
	    return outFileWriter;
	  }

	  protected int treeDepth = 0;

	  public final int getTreeDepth() {
	    return treeDepth;
	  }

	  public final void incTreeDepth() {
	    treeDepth++;
	  }

	  public final void decTreeDepth() {
	    for (int i = 0; i < treeDepth; i++)
	        outFileWriter.print(" ");
	    outFileWriter.println("... node has no more children");
	    treeDepth--;
	  }
	  
	  public final void printSymbol(Symbols nodeName)
	  {
	     printSymbol(nodeName, null);
	  }


	  public final void printSymbol(Symbols nodeName, Object nodeValue)
	  {
	    if (nodeName != Symbols.NONE) {
	      for (int i = 0; i < treeDepth; i++)
	        outFileWriter.print(" ");
	      outputSymbol(nodeName, nodeValue, outFileWriter);
	    }
	  }
	  
  private String idAttributes(String idName)
  {
     LocalVariableRec tLocVar
       = (LocalVariableRec) TJ.symTab.searchForLocal(idName);

     ClassVariableRec tClassVar
       = (ClassVariableRec) BlockRec.searchForStatic(idName, false);

     MethodRec tMethod
       = (MethodRec) BlockRec.searchForStatic(idName, true);

     String resultString = "";

     if (tLocVar != null || tClassVar != null || tMethod != null) {

       boolean firstNonNull = true;

       resultString = "  [";

       if (tLocVar != null) {
         if (tLocVar.type == VariableRec.INT)
           resultString += "local var (stackframe offset = " + tLocVar.offset + ")";
         else
           resultString += "local Scanner";
         firstNonNull = false;
       }

       if (tClassVar != null) {
         if (!firstNonNull)
           resultString += ",  ";

         if (tClassVar.type == VariableRec.INT)
           resultString += "static var (address = " + tClassVar.offset + ")";
         else
           resultString += "static Scanner";

         firstNonNull = false;
       }

       if (tMethod != null) {
         if (!firstNonNull)
           resultString += ",  ";

         if (tMethod.getStartAddr() == Instruction.OPERAND_NOT_YET_KNOWN)
           resultString += "method (start address not yet known)";
         else
           resultString += "method (start address = " + tMethod.getStartAddr() + ")";
       }

       resultString += "]";
     }
     else
       resultString += "  [not in symbol table]";

     return resultString;
  }

  protected final void openOutputFile (String filename) throws SourceFileErrorException
  {
    System.out.print("Enter name for output file:  ");
    if (filename != null)
      System.out.print(filename+"\n\n");
    else {
      System.out.flush();
      try(Scanner scan = new Scanner(System.in)) {
    	  filename = scan.nextLine();  
      }
      System.out.println();
    }
    try {
      outFileWriter = new PrintWriter(new FileWriter(filename));
    }
    catch (IOException e) {
        throw new SourceFileErrorException("Failed to open output file");
    }
  }
  
  public void outputSymbol(Symbols nodeName, Object nodeValue, PrintWriter out)
  {
      out.print(nodeName.symbolRepresentationForOutputFile);

      if (nodeName == Symbols.IDENT) {
            String idName = nodeValue.toString();
            nodeValue = idName + idAttributes(idName);
      }

      if (nodeValue == null)
        out.println();
      else
        out.println(": " + nodeValue);
  }


  OutputFileHandler(String filename) throws SourceFileErrorException
  {
	  openOutputFile(filename);
  }
}




