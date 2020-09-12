package classes;

import java.awt.*;
import java.io.*;
import javax.imageio.*;//для потока
import javax.swing.*;

public class RunImage {
    public static void main(String[] args) {
                ImageFrame frame = new ImageFrame(args[0]);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
    }

}
class ImageFrame extends JFrame
{
    private Image image;
    public ImageFrame(String path)
    {
        try {
        image = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();//место с ошибкой в коде
        }
        setTitle("Картинка");
        setSize((image.getWidth(null)+15),((image.getHeight(null))+10));
        ImageComponent component = new ImageComponent(path);
        add(component);
    }

}
class ImageComponent extends JComponent
{
    private Image image;
    public ImageComponent(String path)
    {

        // Получаем изображения.
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void paintComponent(Graphics g)
    {
        if(image == null) return;
        // Отображение рисунка в левом верхнем углу.
        g.drawImage(image, 0, 0, null);
    }
}
