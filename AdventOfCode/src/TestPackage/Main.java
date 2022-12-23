package TestPackage;
import java.awt.Desktop;
import java.net.URI;

public class Main {
    public static void main(String[] args) {
        try {
            Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
