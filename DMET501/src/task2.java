import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

//task 1 & 2 use the same image
public class task2 {
	BufferedImage  inImage;
	BufferedImage  outImage;
	
	public task2() throws IOException
	{
		File input = new File("grayscale.jpg");
        inImage = ImageIO.read(input);
        outImage = new BufferedImage(inImage.getWidth(), inImage.getHeight(), BufferedImage.TYPE_INT_RGB );
        
        for (int i = 0; i < inImage.getHeight(); i++)
		   {
			   for (int j = 0; j < inImage.getWidth(); j++)
			   {
			   int pixel = (new Color(inImage.getRGB(j, i))).getRed();
			   if(pixel <32)
				   outImage.setRGB(j, i,new Color(0,0,0).getRGB() );
			   else if (pixel <64)
				   outImage.setRGB(j, i, new Color(32,32,32).getRGB());
			   else if (pixel <96)
				   outImage.setRGB(j, i, new Color(64,64,64).getRGB());
				   else if (pixel <128)
					   outImage.setRGB(j, i,new Color(96,96,96).getRGB());
				   else
					   if(pixel<160)
						   outImage.setRGB(j, i, new Color(128,128,128).getRGB());
					   else
						   if(pixel<192)
							   outImage.setRGB(j, i, new Color(160,160,160).getRGB());
						   else if(pixel<224)
							   outImage.setRGB(j, i, new Color(192,192,192).getRGB());
						   else if (pixel<256)
							   outImage.setRGB(j, i, new Color(224,224,224).getRGB());			   
			   }
		   }
        File ouptut = new File("/Users/AmrAli/Desktop/DMET/task2 output.jpg");
        ImageIO.write(outImage, "jpg", ouptut);

	}
	public static void main(String[] args) throws IOException {
		new task2();
	}

}
