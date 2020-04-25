//package imageScrambler.image_encrypt;
//
//import java.awt.image.*;
//import javax.imageio.ImageIO;
//import java.io.*;
//
//public class e1_convert
//{
//    public static void main(String[] args) throws FileNotFoundException, IOException
//    {
//        File output_file=new File("D:/pixels.txt");                   //Output Text file
//        PrintStream out=new PrintStream(new FileOutputStream(output_file));
//        System.setOut(out);
//        /*
//         * If you try this code,
//         * take image of 30 x 30 dimensions'
//         * as it takes less time to execute...'
//         */
//        BufferedImage image = readImage("D:/rainbow.jpg");               //Input Image file
//        printAllARGBDetails(image);
//    }
//     
//    public static void printAllARGBDetails(BufferedImage image)
//    {
//        int width = image.getWidth();
//        int height = image.getHeight();
//        int pix_num=1;
//        int total_pix=width*height;
//        System.out.println("--------------------------------------------");
//        System.out.println("Image Scrambler");   
//        System.out.println("Image Dimension: Height-" + height + ", Width-" + width);
//        System.out.println("Total Pixels: " + (height * width));
//        System.out.println("--------------------------------------------");
//        for (int i = 0; i < width; i++)
//        {
//            for (int j = 0; j < height; j++)
//            {
//                int pixel = image.getRGB(i, j);
//                String idata=(getARGBPixelData(pixel));
//                System.out.print("Pixel ("+i+","+j+"): ");
//                System.out.print(idata);
//                if(pix_num<total_pix)       //To delete the line that generates at end of file
//                {
//                    System.out.println("");
//                }
//                pix_num++;
//            }
//        }
//    }
// 
//    public static String getARGBPixelData(int pixel)
//    {
//        String ARGBvalue="";
//        int alpha = (pixel >> 24) & 0x000000FF;
//        int red = (pixel >> 16) & 0x000000FF;
//        int green = (pixel >>8 ) & 0x000000FF;
//        int blue = (pixel) & 0x000000FF;
//        ARGBvalue = alpha + " " + red + " " + green + " " + blue;
//        return ARGBvalue;
//    }
//     
//    public static BufferedImage readImage(String fileLocation) throws IOException
//    {
//        BufferedImage img = null;
//        img = ImageIO.read(new File(fileLocation));
//        return img;
//    }
//}