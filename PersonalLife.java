import org.code.theater.*;
import org.code.media.*;

public class PersonalLife extends Scene {

  /** Instance Variables */
private ImageFilter[][] images;
  private String[][] captions;
  
  /** Constructor */
    public PersonalLife(ImageFilter[][] images, String[][] captions) {
    this.images = images;
    this.captions = captions;
  }

  /**
   * Top-level drawScene method which will draw the whole animation
   */
    public void drawScene() {
    drawTitleScreen();
    Culture1();
    FriendsAndFamily();
  
    
  }

  /*
   - returns the first caption in each row, if there is no caption, then it returns "no caption".
   - this ensures that there aren't any holes in my 2D array for captions
  */
   public String getFirstCaption(int row) {
    for (int c = 0; c < captions[row].length; c++) {
      if  (captions[row][c] != null && !captions[row][c].equals("")) {
          return captions[row][c]; 
      }
    } 
    return "No caption";
  }

  /*
  draws the title screen
  */
  public void drawTitleScreen(){
    pause(1);
    
    clear("purple");
    setTextStyle(Font.SERIF, FontStyle.BOLD);
    setTextHeight(50);
    setTextColor("white");
    drawText("My Personal", 60, 150);
    drawText("Narrative", 90, 250);
    
    pause(5); 
  }

  /*
  - draws the culture part of my personal narrative, accesses the corresponding images and captions needed to do so
  - adds a motion blur and color shift filter to the image from the ImageFilter class
  - clears the screen to make way for the next image and caption for this section
  */
  public void Culture1(){
    clear("purple");
    drawImage(images[0][0], 50, 50, 300);
    setTextColor("black");
    setTextHeight(40);
    drawText(captions[0][0], 30, 320);
    pause(1);
    images[0][0].colorShift(10); //added colorShift filter
    drawImage(images[0][0], 50, 50, 300);
    pause(1);


    pause(3); //pause between clearing screens

    clear("purple");
    drawImage(images[0][1], 50, 50, 300);
    pause(1);
    images[0][1].motionBlur(50, "horizontal"); //added motionBlur filter
    drawImage(images[0][1], 50, 50, 300);
    pause(1);
    setTextColor("black");
    setTextHeight(25);
    drawText(captions[0][1], 20, 335);
    pause(1);
  }

  /*
  - draws the friends and family part of my personal narrative, accesses the corresponding images and captions needed to do so
  - adds a colorizing and sepia filter to the image from the ImageFilter class
  - clears the screen to make way for the next image and caption for this section
  */
  public void FriendsAndFamily(){
    clear("red");
    drawImage(images[1][0], 50, 10, 300);
    pause(1);
    images[1][0].colorize(); //adds colorize filter
    drawImage(images[1][0], 50, 10, 300);
    pause(1);
    setTextColor("black");
    setTextHeight(30);
    drawText(captions[1][0], 40, 335);
    pause(1);

    pause(2); //pause between clearing screens

    clear("red");
    drawImage(images[1][1], 315, 10, 300, 90);
    pause(1);
    images[1][1].sharpen(); //adds sharpen filter
    drawImage(images[1][1], 315, 10, 300, 90);
    pause(1);
    setTextColor("black");
    setTextHeight(30);
    drawText(captions[1][1], 15, 335);
    pause(1);
  }
    
}