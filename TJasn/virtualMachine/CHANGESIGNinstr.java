package TJasn.virtualMachine;

import static TJasn.virtualMachine.CodeInterpreter.*;

public class CHANGESIGNinstr extends ZeroOperandInstruction {

  void execute () throws VirtualMachineHaltException
  {
    /* Complete */
	int temp = EXPRSTACK[ESP - 1] * -1;
	EXPRSTACK[ESP - 1] = temp;
	if(temp >= POINTERTAG) throw new VirtualMachineHaltException("RUNTIME ERROR: Integer overflow");
  }

  public CHANGESIGNinstr ()
  {
    super("CHANGESIGN");
  }
}

