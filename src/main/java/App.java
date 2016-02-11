import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

import org.apache.commons.lang.StringUtils;

public class App {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/main.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/results", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/results.vtl");

      String userString = request.queryParams("userString");
      String userFind = request.queryParams("userFind");
      String userReplace = request.queryParams("userReplace");
      String changedString = findAndReplace(userString, userFind, userReplace);

      model.put("userString", userString);
      model.put("changedString", changedString);

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

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
