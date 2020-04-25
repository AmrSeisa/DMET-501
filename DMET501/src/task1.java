import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;

// task 1 & 2 use the same image 
public class task1 {
	BufferedImage  image;
	
	public task1() throws IOException
	{
		BufferedWriter br = new BufferedWriter(new FileWriter(new File("/Users/AmrAli/Desktop/DMET/task1.text")));
        File input = new File("grayscale.jpg");
        image = ImageIO.read(input);
        
//        System.out.println("the image width is " + image.getWidth() +" and the height is "  +image.getHeight());
		   for (int i = 0; i < image.getHeight(); i++)
		   {
			   for (int j = 0; j < image.getWidth(); j++)
			   {
			   int pixel = (new Color(image.getRGB(j, i))).getRed();
			   br.write(" "+pixel+" ");
//			   System.out.println(pixel);
			   
			   }br.write("\n");
		   }

	}
	public static void main(String[] args) throws IOException {
		new task1();
	}

}