import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

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
		
//		try{
//			bImg = ImageIO.read(new File(imageLocation));
//		}catch (IOException e) {
//		    e.printStackTrace();
//		}
		
		ImageIcon icon = new ImageIcon(imageLocation);
		Image img = icon.getImage();
//		BufferedImage bImg = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);		
		
		
		frame1 = new JFrame();		
		frame1.setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/Icon/gifLogo.png")));
		frame1.getContentPane().setBackground(Color.WHITE);
		frame1.setTitle(imageLocation);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().setLayout(new BorderLayout(0, 0));
		frame1.setBounds(200, 200, img.getWidth(null), img.getHeight(null));

		JLabel imgLabel = new JLabel("");
		imgLabel.setToolTipText(imageLocation);
		imgLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imgLabel.setIcon(new ImageIcon(img));
		imgLabel.setBounds(0, 0, frame1.getWidth(), frame1.getHeight());
		frame1.getContentPane().add(imgLabel);
		frame1.setLocationRelativeTo(null);
		
		frame1.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				
				imgLabel.setBounds(0, 0, frame1.getWidth(), frame1.getHeight());
				Image newImg = img.getScaledInstance(frame1.getWidth(), frame1.getHeight(), java.awt.Image.SCALE_DEFAULT);
//				Graphics gr = bImg.createGraphics();
//				gr.drawImage(img, 0, 0, frame1.getWidth(), frame1.getHeight(), frame1);
				
				imgLabel.setIcon(new ImageIcon(newImg));
			}
		});
		
		
	}
}
