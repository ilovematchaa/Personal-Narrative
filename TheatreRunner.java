import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
  public static void main(String[] args) {

 // Create any 2D arrays & variables to be passed as parameters to constructor
     ImageFilter[][] images = {
      //culture
      { new ImageFilter("Flag.jpg"), new ImageFilter("altar.jpg") },
      //friends and family
      { new ImageFilter("Cruise.png"), new ImageFilter("Halloween.png") },
      //interests 
      { new ImageFilter("matcha.jpg"), new ImageFilter("sonnyangel.jpg") },
      { new ImageFilter("TopGolf.png"), new ImageFilter("images-(1).jpg") },
    };

     //2D array used for captions that match the images in the other 2D array
    String[][] captions = {
      {"I am filipino & viet", "Alter: Pay respects to ancestors"},
      {"My family and I on a cruise", "My friends and I on halloween"},
      {null, null},
      {null, null},
    };
    // Instantiate Scene subclass objects
    PersonalLife p = new PersonalLife(images, captions);
    Interest i = new Interest(images, captions);

    // Call drawScene methods in each subclass
    p.drawScene();
    i.drawScene();
    
    // Play scenes in Theater, in order of arguments
    Theater.playScenes(p, i);   
    
  }
}