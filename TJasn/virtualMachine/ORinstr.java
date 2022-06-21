package TJasn.virtualMachine;

import static TJasn.virtualMachine.CodeInterpreter.*;

public class ORinstr extends ZeroOperandInstruction {

  void execute ()
  {
    /* Complete */
	EXPRSTACK[--ESP - 1] = (EXPRSTACK[ESP] == 1 || EXPRSTACK[ESP - 1] == 1 ? 1 : 0);
  }

  public ORinstr ()
  {
    super("OR");
  }
}

