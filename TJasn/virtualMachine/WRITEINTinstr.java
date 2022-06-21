package TJasn.virtualMachine;

import static TJasn.virtualMachine.CodeInterpreter.*;

public class WRITEINTinstr extends ZeroOperandInstruction {

  void execute ()
  {
    /* Complete */
	System.out.print(EXPRSTACK[--ESP]);
  }

  public WRITEINTinstr ()
  {
    super("WRITEINT");
  }
}

