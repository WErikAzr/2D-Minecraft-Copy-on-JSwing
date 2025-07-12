package minecraftfinal.bloques;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Bedrock extends Bloque {

    public Bedrock() {
    }

    public Image getImagenBedrock() {
        try {
            BufferedImage imagenBedrock = ImageIO.read(new File("bloqueBedrock.png"));
            Image scaledImage = imagenBedrock.getScaledInstance(anchuraImagenBloque, alturaImagenBloque, Image.SCALE_SMOOTH);
            return scaledImage;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
