package hungnguyen.com.demo.utils;

import hungnguyen.com.demo.entity.Status;

public class Utils {
  public static Status validateString(String s) {

    Status result = new Status(false, null);

    if ((s.length() < 5) || (s.length() > 12)) {
      result.setError("String must be between 5 and 12 characters in length");

      return result;
    }
    boolean isHaveCharacter = false;
    boolean isHaveNumber = false;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (((c >= 'a') && (c <= 'z')) || ((c >= 'A') && (c <= 'Z'))) {
        isHaveCharacter = true;
      } else if ((c >= '0') && (c <='9')) {
        isHaveNumber = true;
      } else {
        result.setError("String must consist of a mixture of letters and numerical digits only");

        return result;
      }

      if ( i > 0) {
        int diff = Math.abs(s.charAt(i) - s.charAt(i - 1));
        if (diff == 1) {
          result.setError("String must not contain any sequence of characters immediately followed by the same sequence");

          return result;
        }
      }
    }

    if (!(isHaveCharacter && isHaveNumber)) {
      result.setError(" String must consist of a mixture of letters and numerical digits only, with at least one of each");

      return result;
    }

    result.setSuccess(true);

    return result;
  }
}
