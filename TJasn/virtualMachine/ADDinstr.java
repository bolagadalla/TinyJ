package TJasn.virtualMachine;

import static TJasn.virtualMachine.CodeInterpreter.*;

public class ADDinstr extends ZeroOperandInstruction {

  void execute () throws VirtualMachineHaltException
  {
    /* Complete */
    int temp = EXPRSTACK[--ESP - 1] + EXPRSTACK[ESP];
    EXPRSTACK[ESP - 1] = temp;
    // Checks to see if the integer is larger then our POINTERTAG
    if (temp >= POINTERTAG) {
      throw new VirtualMachineHaltException("RUNTIME ERROR: Integer overflow");
    }
  }

  public ADDinstr ()
  {
    super("ADD");
  }
}

