package TJasn.virtualMachine;

@SuppressWarnings("serial")
public class VirtualMachineHaltException extends Exception{
  public final String errorMessage;
  
  public VirtualMachineHaltException(String errMsg)
  {
    errorMessage = errMsg;
  }
}
