package femr.ui.controllers;

import play.mvc.Controller;
import play.mvc.Result;
//Application controller
public class ApplicationController extends Controller {
    public static Result removeTrailingSlash(String path) {
        return movedPermanently("/" + path);
    }
}
