package TJasn.virtualMachine;

import static TJasn.virtualMachine.CodeInterpreter.*;
import TJasn.TJ;

public class PASSPARAMinstr extends ZeroOperandInstruction {

  void execute () throws VirtualMachineHaltException
  {
	/* Complete */
	TJ.data[ASP++ - POINTERTAG] = EXPRSTACK[--ESP];
	if(ASP - POINTERTAG > TJ.HEAP_START) throw new VirtualMachineHaltException("RUNTIME ERROR: Activation record overflow");
  }

  public PASSPARAMinstr ()
  {
    super("PASSPARAM");
  }
}

