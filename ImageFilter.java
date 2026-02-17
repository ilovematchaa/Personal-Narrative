import org.code.theater.*;
import org.code.media.*;
public class ImageFilter extends ImagePlus {

  /** Instance Variables */
  
  /** Constructor */
  public ImageFilter(String fileName) {
    super(fileName);
  }

  // Add filter methods here...
  
  /*
   * Makes the image negative to which the colors are inverted
   */
   public void makeNegative() {
   Pixel[][] pixels = getImagePixels();
      
for (int row = 0; row < pixels.length; row++) {
   for (int col = 0; col < pixels[0].length; col++) {
      Pixel currentPixel = pixels[row][col];
      currentPixel.setRed(255 - currentPixel.getRed());
      currentPixel.setGreen(255 - currentPixel.getGreen());
      currentPixel.setBlue(255 - currentPixel.getBlue());
  }
}
}
/*
   * Applies a shift in color to the image
   */
  public void colorShift(int value) {
 Pixel[][] pixels = getPixelsFromImage();

    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
        Pixel currentPixel = pixels[row][col];

        int currentRed = currentPixel.getRed();
        int currentGreen = currentPixel.getGreen();
        int currentBlue = currentPixel.getBlue();

        int newRed = currentRed + value;
        int newGreen = currentGreen + value;
        int newBlue = currentBlue + value;

        currentPixel.setRed(newRed);
        currentPixel.setGreen(newGreen);
        currentPixel.setBlue(newBlue);
      }
    }
  }
  /*
   * Applies a mirroring effect to the image
   */
   public void mirrorVertical() {
   Pixel[][] pixels = getImagePixels();
   
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[row].length / 2; col++) {
      Pixel leftPixel = pixels[row][col];
       
        int rightIndex = pixels[row].length - 1 - col;
        Pixel rightPixel = pixels[row][rightIndex];
        Color rightColor = rightPixel.getColor();
        leftPixel.setColor(rightColor);
      }
    }                                      
  }

   /*
   * Applies a motion blur to the image
   */
  public void motionBlur(int length, String direction) {
  Pixel[][] pixels = getImagePixels();  
   
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
        Pixel currentPixel = pixels[row][col];
   
        int redSum = 0;
        int greenSum = 0;
        int blueSum = 0;
        int count = 0;
   
        for (int i = 0; i < length; i++) {
          int r = row;
          int c = col;
   
          if (direction.equals("horizontal")) {
            c = col + i;
          } else if (direction.equals("vertical")) {
            r = row + i;
          }
   
          if (r < pixels.length && c < pixels[0].length) {
            Pixel neighbor = pixels[r][c];
            redSum += neighbor.getRed();
            greenSum += neighbor.getGreen();
            blueSum += neighbor.getBlue();
            count++;
          }
        }
   
        currentPixel.setRed(redSum/count);
        currentPixel.setGreen(greenSum/count);
        currentPixel.setBlue(blueSum/count);
      }
    }
  } 

   /*
   * Applies a colorize filter by converting each Pixel to grayscale and applying
   * a color to it based on its grayscale value
   */
  public void colorize() {
 Pixel[][] pixels = getPixelsFromImage();

     for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
        Pixel currentPixel = pixels[row][col];

      int currentRed = currentPixel.getRed();
      int currentGreen = currentPixel.getGreen();
      int currentBlue = currentPixel.getBlue();

      int pixelColorAverage = (currentRed + currentGreen + currentBlue) / 3;
       
       if (pixelColorAverage < 85) {
        currentPixel.setRed(255);
        currentPixel.setGreen(0);
        currentPixel.setBlue(0);
      }
      else if (pixelColorAverage < 170) {
        currentPixel.setRed(0);
        currentPixel.setGreen(255);
        currentPixel.setBlue(0);
      }
      else {
        currentPixel.setRed(0);
        currentPixel.setGreen(0);
        currentPixel.setBlue(255);
      }
      }
    }
  } 

   /*
   * Sharpens the image by calculating the difference between the color values of the current
   * and neighboring Pixel objects and adjust the color values to emphasize the edges
   */
  public void sharpen() {
  Pixel[][] pixels = getImagePixels();

    // traverse starting at (1,1), stop 1 less to not go out of bounds
    for (int row = 1; row < pixels.length - 1; row++) {
      for (int col = 1; col < pixels[0].length - 1; col++) {
        Pixel currentPixel = pixels[row][col];

        // determine the avg RGB difference between the current pixel and the pixel
        // to the topLeft (row - 1, col - 1)
        int redDiff = currentPixel.getRed() - pixels[row - 1][col - 1].getRed();
        int greenDiff = currentPixel.getGreen() - pixels[row - 1][col - 1].getGreen();
        int blueDiff = currentPixel.getBlue() - pixels[row - 1][col - 1].getBlue();
        int averageDiff = (redDiff + greenDiff + blueDiff) / 3;

        // add the avg differnce
        int newRed = currentPixel.getRed() + averageDiff;
        int newGreen = currentPixel.getGreen() + averageDiff;
        int newBlue = currentPixel.getBlue() + averageDiff;

        // force RGB to no exceed 255
        if (newRed > 255) {
          newRed = 255;
        }
        if (newGreen > 255) {
          newGreen = 255;
        }
        if (newBlue > 255) {
          newBlue = 255;
        }

        // update RBG values
        currentPixel.setRed(newRed);
        currentPixel.setGreen(newGreen);
        currentPixel.setBlue(newBlue);
      }
    }
}
  /*
  gives image a green tint, the tint becomes more green based on the inputted intensity of the color. it does this by 
  adding more to the green value of each pixel, based on the inputted intensity
  */
public void greenTint(int intensity) {
  Pixel[][] pixels = getPixelsFromImage();

  for (int r = 0; r < pixels.length; r++) {
    for (int c = 0; c < pixels[r].length; c++) {
      Pixel p = pixels[r][c];

      int newGreen = p.getGreen() + intensity;
      if (newGreen > 255){ //makes sure that it doesn't go out of bounds
        newGreen = 255; 
      }
      p.setGreen(newGreen);
    }
  }
}
}