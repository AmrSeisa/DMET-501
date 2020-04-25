import java.awt.image.BufferedImage;


public class gaussianFilter 
{
	private BufferedImage inImage;
	private BufferedImage outImage;
	private int width;
	private int height;
	private int kWidth;
	private int kHeight;
//	private Mat source;
	
	public gaussianFilter(BufferedImage inImg , BufferedImage outImge , int Kernel)
	{
		this.inImage = inImg;
		this.outImage = outImge;
		this.width = inImage.getWidth();
		this.height = inImage.getHeight();
		this.kWidth = Kernel;
		
		
	}

}
