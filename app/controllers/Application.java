package controllers;

import java.io.File;

import javacodes.fileLoader;
import play.*;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
    
    public static Result upload(String filename) {
        
        String path  = "/Users/kyun/Desktop"+filename;
        
        File file = new File(path);
        
        fileLoader loader = new fileLoader();
        loader.load(file);
       
        
        
        return ok(index.render("Your data is uploaded to the database__"+filename));
    }
    
    
    /*SD1: write code 
    
    ST2:ASSUMES WE HAVE A FILE LOCALLY INSIDE FOLDER DATA/
    */

}
