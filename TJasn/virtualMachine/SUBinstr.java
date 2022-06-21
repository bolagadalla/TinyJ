package TJasn.virtualMachine;

import static TJasn.virtualMachine.CodeInterpreter.*;

public class SUBinstr extends ZeroOperandInstruction {

  void execute () throws VirtualMachineHaltException
  {
    /* Complete */
	if(EXPRSTACK[--ESP - 1] - EXPRSTACK[ESP] > POINTERTAG) throw new VirtualMachineHaltException("RUNTIME ERROR: Integer over flow");
	EXPRSTACK[ESP - 1] -= EXPRSTACK[ESP];
	
  }

  public SUBinstr ()
  {
    super("SUB");
  }
}

