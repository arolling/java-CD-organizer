import java.util.HashMap;
import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";
    staticFileLocation("/public");

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("allCds", request.session().attribute("allCds"));
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      ArrayList<Cd> allCds = request.session().attribute("allCds");
      if (allCds == null) {
        allCds = new ArrayList<Cd>();
        request.session().attribute("allCds", allCds);
      }
      String newTitle = request.queryParams("cdTitle");
      Cd newCd = new Cd(newTitle);
      allCds.add(newCd);

      model.put("allCds", allCds);
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
