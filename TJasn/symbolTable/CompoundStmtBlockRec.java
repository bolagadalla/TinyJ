package TJasn.symbolTable;

import TJasn.ParserAndTranslator;

public class CompoundStmtBlockRec extends BlockRec {
  public final MethodBlockRec methodBlock
    =  ParserAndTranslator.getLevel() == 2  ?  (MethodBlockRec) this
     : ((CompoundStmtBlockRec) enclosingBlock).methodBlock;
}
