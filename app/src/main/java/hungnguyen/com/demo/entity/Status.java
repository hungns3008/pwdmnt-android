package hungnguyen.com.demo.entity;

public class Status {
  boolean isSuccess;
  String error;


  public Status(boolean isSuccess, String error) {
    this.isSuccess = isSuccess;
    this.error = error;
  }

  public boolean isSuccess() {
    return isSuccess;
  }

  public void setSuccess(boolean success) {
    isSuccess = success;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }
}
