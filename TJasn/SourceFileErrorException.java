package TJasn;

@SuppressWarnings("serial")
public class SourceFileErrorException extends Exception {
  public final String errorMessage;

  public SourceFileErrorException(String errMsg)
  {
    errorMessage = errMsg;
  }
}
