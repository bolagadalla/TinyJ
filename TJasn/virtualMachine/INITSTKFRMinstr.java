package TJasn.virtualMachine;

import static TJasn.virtualMachine.CodeInterpreter.*;
import TJasn.TJ;

public class INITSTKFRMinstr extends OneOperandInstruction {

  void execute () throws VirtualMachineHaltException
  {
     /* Complete */
	TJ.data[ASP - POINTERTAG] = FP;
	FP = ASP++;
	ASP += operand;
	
	// Making sure we are not going beyond the start of the heap.
	if(ASP - POINTERTAG > TJ.HEAP_START) throw new VirtualMachineHaltException("RUNTIME ERROR: Activation record overflowed");
	
  }

  public INITSTKFRMinstr (int locationsNeededForLocalVars)
  {
    super(locationsNeededForLocalVars, "INITSTKFRM");
  }
}

