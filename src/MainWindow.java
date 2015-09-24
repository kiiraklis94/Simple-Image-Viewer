import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Toolkit;

public class MainWindow {

	private JFrame frame1;
	public static String imageLocation = null;
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		try {
			imageLocation = args[0];
		} catch (Exception e1) {
			e1.printStackTrace();
			System.exit(0);
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainWindow() {
		initialize();
	}

	private void initialize() {
		
		BufferedImage img = null;
		
		try{
			img = ImageIO.read(new File(imageLocation));
		}catch (IOException e) {
		    e.printStackTrace();
		}
		int imgWidth = img.getWidth();
		int imgHeight = img.getWidth();
		
		frame1 = new JFrame();
		
		frame1.setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/Icon/gifLogo.png")));
		frame1.getContentPane().setBackground(Color.WHITE);
		frame1.setTitle(imageLocation);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().setLayout(new BorderLayout(0, 0));
		frame1.setBounds(200, 200, imgWidth+18, imgHeight+40);

		JLabel imgLabel = new JLabel("");
		imgLabel.setToolTipText(imageLocation);
		imgLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imgLabel.setIcon(new ImageIcon(imageLocation));
		imgLabel.setBounds(0, 0, frame1.getWidth(), frame1.getWidth());
		frame1.getContentPane().add(imgLabel);
		frame1.setLocationRelativeTo(null);
		
		
	}
}
