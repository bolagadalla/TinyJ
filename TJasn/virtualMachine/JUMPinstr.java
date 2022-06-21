package TJasn.virtualMachine;

import static TJasn.virtualMachine.CodeInterpreter.*;

public class JUMPinstr extends OneOperandInstruction {

  void execute ()
  {
    /* Complete */
	PC = operand;
  }

  public JUMPinstr (int address)
  {
    super(address, "JUMP");
  }
}

