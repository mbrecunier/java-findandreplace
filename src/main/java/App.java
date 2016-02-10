import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

import org.apache.commons.lang.StringUtils;

public class App {
  public static void main(String[] args) {
  }

  public static String findAndReplace(String userString, String userFind, String userReplace) {
    String stringArray [];
    String changedString = "";

    stringArray = userString.split(" ");

    for (Integer i = 0; i < stringArray.length; i++) {
      if (stringArray[i].equals(userFind)) {
        stringArray[i] = stringArray[i].replace(userFind, userReplace);
      }
    }

    changedString = StringUtils.join(stringArray, " ");
    return changedString;

    // String changedString = userString.replaceAll("(?i)"+userFind, userReplace);
  }

}
