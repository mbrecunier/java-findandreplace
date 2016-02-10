import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
  }

  public static String findAndReplace(String userString, String userFind, String userReplace) {
    String changedString = userString.replaceAll(userFind, userReplace);
    return changedString;
  }

}
