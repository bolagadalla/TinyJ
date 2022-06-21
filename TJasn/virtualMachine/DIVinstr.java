package TJasn.virtualMachine;

import static TJasn.virtualMachine.CodeInterpreter.*;

public class DIVinstr extends ZeroOperandInstruction {

  void execute () throws VirtualMachineHaltException
  {
    /* Complete */
	if(EXPRSTACK[--ESP] == 0) throw new VirtualMachineHaltException("RUNTIME ERROR: You can\'t divide by zero");
	EXPRSTACK[ESP - 1] /= EXPRSTACK[ESP];
  }

  public DIVinstr ()
  {
    super("DIV");
  }
}
