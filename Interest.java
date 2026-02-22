import org.code.theater.*;
import org.code.media.*;

public class Interest extends Scene {

  /** Instance Variables */
 private ImageFilter[][] images;
  private String[][] captions;
  
  /** Constructor */
public Interest(ImageFilter[][] images, String[][] captions) {
    this.images = images;
    this.captions = captions;
  }
  /**
   * Top-level drawScene method which will draw the whole animation
   */
    public void drawScene() {
  drawInterest();
    
  }

  // other methods...
public String[][] caption() {
  String[][] interestcaptions = {
      {"I Love Matcha", "I'm into Sonny Angels"},
      {"Top Golf is fun", "I love playing soccer"},
   };
return interestcaptions;
}


  public void drawInterest(){
    playSound("keshi.wav");
    setTextStyle(Font.SERIF, FontStyle.BOLD);
    clear("olive");
    drawImage(images[2][0], 50, 10, 300);
    pause(1);
    images[2][0].colorize(); //added colorize filter
    drawImage(images[2][0], 50, 10, 300);
    pause(1);
     setFillColor("beige");
    drawRectangle(30, 290, 335, 70);
    setTextColor("brown");
    setTextHeight(30);
    String[][] interestcaptions = caption();
    drawText(interestcaptions[0][0], 40, 335);
    pause(1);

    pause(2); 

   setTextStyle(Font.SERIF, FontStyle.BOLD);
    clear("olive");
    drawImage(images[2][1], 50, 10, 300);
    pause(1);
    images[2][0].colorize(); //added colorize filter
    drawImage(images[2][1], 50, 10, 300);
    pause(1);
     setFillColor("beige");
    drawRectangle(30, 290, 335, 70);
    setTextColor("brown");
    setTextHeight(30);
    drawText(interestcaptions[0][1], 40, 335);
    pause(1);

    setTextStyle(Font.SERIF, FontStyle.BOLD);
    clear("olive");
    drawImage(images[3][0], 50, 10, 300);
    pause(1);
    images[2][0].colorize(); //added colorize filter
    drawImage(images[3][0], 50, 10, 300);
    pause(1);
     setFillColor("beige");
    drawRectangle(30, 290, 335, 70);
    setTextColor("brown");
    setTextHeight(30);
    drawText(interestcaptions[1][0], 40, 335);
    pause(1);

    setTextStyle(Font.SERIF, FontStyle.BOLD);
    clear("olive");
    drawImage(images[3][1], 50, 10, 300);
    pause(1);
    images[2][0].greenTint(50); //added greenTint filter
    drawImage(images[3][1], 50, 10, 300);
    pause(1);
     setFillColor("beige");
    drawRectangle(30, 290, 335, 70);
    setTextColor("brown");
    setTextHeight(30);
    drawText(interestcaptions[1][1], 40, 335);
    pause(1);
  }
    
}