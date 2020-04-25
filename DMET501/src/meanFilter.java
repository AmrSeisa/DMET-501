import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class meanFilter {
	private BufferedImage inImage;
	private BufferedImage outImage;
	private int width;
	private int height;
	private int kernelWidth;
	private int kernelHeight;
	private int div;
//	private int sum;
//	private int mean;
	   
	   public meanFilter(BufferedImage img , int KernelW , int KernelH) throws IOException
	   {
		   this.inImage = img;
		   this.width = inImage.getWidth();
		   this.height = inImage.getHeight();
		   this.kernelWidth = KernelW;
		   this.kernelHeight = KernelH;
		   this.div = kernelWidth*kernelHeight;
		   
		   
		   for (int i=0; i<height; i++)//height-1
		   {
			  for (int j=0; j<width; j++)  //width-1
			   {
				  int red =0;
				   int blue = 0;
				   int green = 0;
				   int nRed =0;
				   int nBlue = 0;
				   int nGreen = 0;
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
			               red += c.getRed();
			               green += c.getGreen();
			               blue += c.getBlue();
			               
			         }
			         

			      }
			      nRed = red/div;
			      nGreen = green/div;
			      nBlue = blue/div;
//			      System.out.println(i+"="+nRed +":" +nGreen +":" +nBlue + " K:"+ ki +":"+kj);
			      Color newColor = new Color(nRed , nGreen, nBlue);
//			      System.out.println(i+","+j+" ," + newColor.getRGB());
			      inImage.setRGB(j+(KernelW/2), i+(KernelH/2) ,newColor.getRGB());

			      
			      		      
			   }
		   }
		   File ouptut = new File("/Users/AmrAli/Desktop/DMET/MeanImg"+KernelH+".jpg");
	         ImageIO.write(inImage, "jpg", ouptut);
	   }
	   
	   
	   public static void main(String[] args) throws IOException 
	   {
		   File input = new File("butterfly_22476.png");
	        BufferedImage imge = ImageIO.read(input);
//		   new meanFilter(imge, 3, 3);
		   new meanFilter(imge, 7, 7);
		   
	   }

}
