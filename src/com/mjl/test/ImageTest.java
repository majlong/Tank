package com.mjl.test;



import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Auther: mjl
 * @Date: 2020/6/22 - 21:45
 * @Description: com.mjl.test
 * @version: 1.0
 */
public class ImageTest {

    @Test
    public  void Test(){
        try {
            //BufferedImage read = ImageIO.read(new File("/src/0.gif"));
            //Assert.assertNotNull(new Object());
            BufferedImage read = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("/images/bulletD.gif"));
            Assert.assertNotNull(read);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
