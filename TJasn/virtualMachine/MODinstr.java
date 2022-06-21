package TJasn.virtualMachine;

import static TJasn.virtualMachine.CodeInterpreter.*;

public class MODinstr extends ZeroOperandInstruction {

  void execute () throws VirtualMachineHaltException
  {
    /* Complete */
	if(EXPRSTACK[--ESP] == 0) throw new VirtualMachineHaltException("RUNTIME ERROR: You can\'t divide by 0");
	
	EXPRSTACK[ESP - 1] %= EXPRSTACK[ESP];
  }

  public MODinstr ()
  {
    super("MOD");
  }
}

