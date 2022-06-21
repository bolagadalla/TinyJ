package TJasn.virtualMachine;

import static TJasn.virtualMachine.CodeInterpreter.*;

public class MULinstr extends ZeroOperandInstruction {

  void execute () throws VirtualMachineHaltException
  {
    /* Complete */
	if(EXPRSTACK[--ESP] * EXPRSTACK[ESP - 1] >= POINTERTAG) throw new VirtualMachineHaltException("RUNTIME ERROR: Integer is overflowed the stack");
	
	EXPRSTACK[ESP - 1] *= EXPRSTACK[ESP];
  }

  public MULinstr ()
  {
    super("MUL");
  }
}

