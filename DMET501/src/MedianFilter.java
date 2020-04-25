import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;


public class MedianFilter 
{
	private BufferedImage inImage;
	private BufferedImage outImage;
	private int width;
	private int height;
	private int kernelWidth;
	private int kernelHeight;
	private int median;
	
	
	public MedianFilter(BufferedImage imge , int KernelH, int KernelW) throws IOException
	{
		 this.inImage = imge;
		   this.width = inImage.getWidth();
		   this.height = inImage.getHeight();
		   this.kernelWidth = KernelW;
		   this.kernelHeight = KernelH;
		   if((kernelWidth*KernelH)%2 == 0)
			   this.median = 0;
		   else
			   this.median = ((kernelWidth*KernelH)-1)/2;
		   int counter = 0;
		   
		   for (int i=0; i<height; i++)//height-1
		   {
			  for (int j=0; j<width; j++)  //width-1
			   {
				  int[] rMedian = new int [kernelWidth*kernelHeight];
			      int[] gMedian = new int [kernelWidth*kernelHeight];
			      int[] bMedian = new int [kernelWidth*kernelHeight];
			      
				   if(j+KernelW >= width || i+(KernelH) >= height)
		        		 break;
			      for (int ki = 0; ki<KernelH; ki++)
			      {
			    	  if(i+KernelH >= height)
			        		 break;
			         for(int kj = 0; kj<KernelW; kj++)
			         {
			        	 if(j+KernelW >= width || i+(KernelH) >= height)
			        		 break;
			               Color c = new Color(inImage.getRGB(j+kj, i+ki));
			              rMedian[counter] = c.getRed();
			              gMedian[counter] = c.getGreen();
			              bMedian[counter] = c.getBlue();
			              counter++;
			         }
			      }
			      counter = 0;
			      Arrays.sort(rMedian);
			      Arrays.sort(gMedian);
			      Arrays.sort(bMedian);
			      
			      Color newColor = new Color(rMedian[median], gMedian[median] , bMedian[median]);
			      inImage.setRGB(j+(KernelW/2), i+(KernelH/2) ,newColor.getRGB());
			     

			   }
	
		   }
		   File ouptut = new File("/Users/AmrAli/Desktop/DMET/MedianImg"+KernelH+".jpg");
	         ImageIO.write(inImage, "jpg", ouptut);
	}
	public static void main(String[] args) throws IOException {
		File input = new File("butterfly_22476.png");
        BufferedImage im = ImageIO.read(input);
       
        new MedianFilter(im, 3, 3);
//        new MedianFilter(im, 7, 7);
        
	}
}
