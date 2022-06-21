package TJasn.virtualMachine;

public class STOPinstr extends ZeroOperandInstruction {

  void execute () throws VirtualMachineHaltException
  {
    throw new VirtualMachineHaltException("Execution ended normally");
  }

  public STOPinstr ()
  {
    super("STOP");
  }
}
