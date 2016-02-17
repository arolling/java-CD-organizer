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
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String newPerson = request.queryParams("cdArtist");
      String newTitle = request.queryParams("cdTitle");
      Cd newCd = new Cd(newTitle);
      boolean duplicateArtist = false;
      for (Artist singer : Artist.all()) {
        if (newPerson.equals(singer.getName())){
          singer.addTitle(newCd);
          duplicateArtist = true;
        }
      }
      if (duplicateArtist == false) {
        Artist newArtist = new Artist(newPerson);
        newArtist.addTitle(newCd);
      }

      model.put("allArtists", Artist.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
