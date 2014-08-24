package controllers;

import java.io.File;

import play.*;
import play.mvc.*;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
    
    public static Result upload() {
        MultipartFormData body = request().body().asMultipartFormData();
        FilePart file = body.getFile("testdata");
        
        if (file != null) {
        	String fileName = file.getFilename();
        	String contentType = file.getContentType();
        	File file1 = file.getFile();
        	return ok(fileName + "Uploaded");
        } else {
        	flash("error", "Missing file");
        	return redirect(routes.Application.index());
        }

    }
        
        
//        return ok(index.render("Your data is uploaded to the database__"+filename));

    
   
    /*SD1: write code 
    
    ST2:ASSUMES WE HAVE A FILE LOCALLY INSIDE FOLDER DATA/
    */

}
