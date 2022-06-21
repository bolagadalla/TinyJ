package TJasn.virtualMachine;

import static TJasn.virtualMachine.CodeInterpreter.*;

public class PUSHSTATADDRinstr extends OneOperandInstruction {

  void execute ()
  {
    /* Complete */
	EXPRSTACK[ESP++] = operand + POINTERTAG;
  }

  public PUSHSTATADDRinstr (int offset)
  {
    super(offset, "PUSHSTATADDR");
  }
}

