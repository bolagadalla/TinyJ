package TJasn.virtualMachine;

public class WRITELNOPinstr extends ZeroOperandInstruction {

  void execute ()
  {
    /* Complete */
	System.out.println();
  }

  public WRITELNOPinstr ()
  {
    super("WRITELNOP");
  }
}
