package TJasn.virtualMachine;

import static TJasn.virtualMachine.CodeInterpreter.*;
import TJasn.TJ;

public class SAVETOADDRinstr extends ZeroOperandInstruction {

  void execute () throws VirtualMachineHaltException
  {
    /* Complete */
	
	// Get the current pointer which is 2 frames away, because ESP - 1 is the value that we will be saving, ESP - 2 is the pointer at which we will be saving.
	int tempPointer = EXPRSTACK[ESP - 2];
	// Making sure the pointer is a valid pointer
	if(tempPointer >= HMAX || tempPointer < POINTERTAG) throw new VirtualMachineHaltException("RUNTIME ERROR: Invalid pointer");
	TJ.data[tempPointer - POINTERTAG] = EXPRSTACK[ESP - 1];
	ESP -= 2;
  }

  public SAVETOADDRinstr ()
  {
    super("SAVETOADDR");
  }
}

