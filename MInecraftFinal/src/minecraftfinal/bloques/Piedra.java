
package minecraftfinal.bloques;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import static minecraftfinal.bloques.Bloque.alturaImagenBloque;
import static minecraftfinal.bloques.Bloque.anchuraImagenBloque;

public class Piedra {
     public Image getImagenPiedra() {
        try {
            BufferedImage imagenPiedra = ImageIO.read(new File("bloquePiedra.jpg"));
            Image scaledImage = imagenPiedra.getScaledInstance(anchuraImagenBloque, alturaImagenBloque, Image.SCALE_SMOOTH);
            return scaledImage;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
