package TJasn.virtualMachine;

import static TJasn.virtualMachine.CodeInterpreter.*;
import TJasn.TJ;

public class LOADFROMADDRinstr extends ZeroOperandInstruction {

  void execute () throws VirtualMachineHaltException
  {
	/* Complete */
	int tempPointer = EXPRSTACK[ESP - 1];
	
	// We are making sure that the pointer is not beyond the heap max and its below the Pointer tag
	// since all addresses will have Pointer tag added to them when you do PUSHSTATADDR -> 4 + POINTERTAG (Per slide Instruction Execution)
	if (tempPointer >= HMAX || tempPointer < POINTERTAG) throw new VirtualMachineHaltException("RUNTIME ERROR: Invalid pointer");
	
	EXPRSTACK[ESP - 1] = TJ.data[tempPointer - POINTERTAG];
  }

  public LOADFROMADDRinstr ()
  {
    super("LOADFROMADDR");
  }
}

