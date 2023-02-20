import javax.swing.*;
class Main {
    public static void main(String[] args) {
        MainPage apk = new MainPage();
    }
}
public class MainPage extends JFrame {
    public MainPage(){
        initialize();
    }

    public void initialize() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
