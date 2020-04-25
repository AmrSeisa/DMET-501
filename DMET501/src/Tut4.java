import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Tut4 {
	  static BufferedImage  image;
	   static int width;
	   static int height;
	   
	   public static void tut5() throws IOException {
	   
	      try {
	         File input = new File("thumb_IMG_1978_1024.jpg");
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
	         Ass1(image);
	      }finally
	      {
	    	  
	      }
	      
	      

}
	   public static void Ass1(BufferedImage inImage) throws IOException
	   {
		   BufferedImage outImage = inImage;
		   BufferedImage outImage2 = inImage;
		   for(int i=0; i<height; i++)
		   {
			   for(int j=0; j<width; j++)
	          {
				   Color c = new Color(inImage.getRGB(j, i));
				   int x1 = c.getRGB();
				   int x = new Color(x1).getRed();
				   if((x-40)<=0)
					   outImage.setRGB(j, i, 0);
				   else
					   outImage.setRGB(j, i, new Color(x-40,x-40,x-40).getRGB());
				   
				   if(x<100)
				   {
					   if((x-40)<=0){
						   outImage2.setRGB(j, i, 0);
					   }else
						   outImage2.setRGB(j, i, new Color(x-40,x-40,x-40).getRGB());
				   }else
					   if(x>=100)
				   {
					   if((x+40)>=255)
						   outImage2.setRGB(j, i, new Color(255,255,255).getRGB());
					   else
						   outImage2.setRGB(j, i, new Color(x+40,x+40,x+40).getRGB());
						   
				   }
				   
				   
					   
	          }
		   }
		   File ouptut2 = new File("/Users/AmrAli/Pictures/ouptutImage.jpg");
	       ImageIO.write(outImage, "jpg", ouptut2);
	       File ouptut3 = new File("/Users/AmrAli/Pictures/ouptutImage2.jpg");
	       ImageIO.write(outImage2, "jpg", ouptut3);
	   }
	   
	   public static void main(String[] args) throws IOException {
		tut5();
	}	  
	   
	   

}