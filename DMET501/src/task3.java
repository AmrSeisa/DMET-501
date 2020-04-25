import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;


public class task3 {
	BufferedImage  inImage;
	int [] histogram;
	
	
	public int [] task3() throws IOException
	{
		File input = new File("grayscale.jpg");
        inImage = ImageIO.read(input);
        histogram = new int[256];
        
        for (int i = 0; i < inImage.getHeight(); i++)
		   {
			   for (int j = 0; j < inImage.getWidth(); j++)
			   {
			   int pixel = (new Color(inImage.getRGB(j, i))).getRed();
			   histogram[pixel]++;
//			   System.out.println(histogram[pixel]);
			   }
		   }
        return histogram;


	}
	public static void main(String[] args) throws IOException {
//		Arrays.toString((int[])new task3());
		task3 a = new task3();
		a.task3();
		for(int i = 0 ; i<256; i++)
			System.out.println("Color " + i + " :" + a.histogram[i]);
		
	}

}
