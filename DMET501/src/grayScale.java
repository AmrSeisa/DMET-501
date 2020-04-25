import java.awt.*;
import java.awt.image.BufferedImage;

	import java.io.*;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class grayScale { 

	   BufferedImage  image;
	   int width;
	   int height;
	   
	   public grayScale() {
	   
	      try {
	         File input = new File("y0CeSA8 2.jpg");
	         image = ImageIO.read(input);
	         width = image.getWidth();
	         height = image.getHeight();
	         
	         for(int i=0; i<height; i++){
	         
	            for(int j=0; j<width; j++){
	            
	               Color c = new Color(image.getRGB(j, i));
	               int red = (int)(c.getRed() * 0.299);
	               int green = (int)(c.getGreen() * 0.587);
	               int blue = (int)(c.getBlue() *0.114);
	               Color newColor = new Color(red+green+blue,red+green+blue,red+green+blue);
	               
	               image.setRGB(j,i,newColor.getRGB());
	            }
	         }
	         
	         File ouptut = new File("/Users/AmrAli/Pictures/grayscale.jpg");
	         ImageIO.write(image, "jpg", ouptut);
	         
//	         public 
	         
//	         System.out.println("a");
	      } catch (Exception e) {}
	   }
	   public void printValues()
	   {
		   String[][] out = new String[width][height];
		   
		   System.out.println("the image width is " + width +" and the height is "  +height);
		   for (int i = 0; i < width; i++)
		   {
			   for (int j = 0; j < height; j++)
			   {
			   int pixel = image.getRGB(i, j);
			   out[i][j] = pixel+"";
//			   System.out.println(pixel);
			   
			   }
		   }
//		   System.out.println(out);
		   
		   for (int i = 0; i < width; i++)
		   {
			   for (int j = 0; j < height; j++)
			   {
//			   int pixel = image.getRGB(i, j);
//			   out[i][j]
			   System.out.print(out[i][j]);
			   
			   }
		   }
		   
	   }
	   
	   static public void main(String args[]) throws Exception 
	   {

	      new grayScale();
	   }
	
	   
	

}