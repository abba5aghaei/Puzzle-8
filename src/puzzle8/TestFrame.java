package puzzle8;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TestFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestFrame frame = new TestFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 555);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu_0 = new JMenu("\u0628\u0627\u0632\u06CC");
		menu_0.setBackground(Color.WHITE);
		menu_0.setFont(new Font("B Mitra", Font.PLAIN, 18));
		menuBar.add(menu_0);
		
		JMenu menu = new JMenu("\u062C\u062F\u06CC\u062F");
		menu_0.add(menu);
		
		textField = new JTextField();
		textField.setColumns(10);
		menu.add(textField);
		
		JMenuItem menuItem = new JMenuItem("\u062A\u0627\u06CC\u06CC\u062F");
		menu.add(menuItem);
		
		JMenuItem menuItem_exit = new JMenuItem("\u062E\u0631\u0648\u062C");
		menuItem_exit.setBackground(Color.WHITE);
		menuItem_exit.setFont(new Font("B Mitra", Font.PLAIN, 18));
		menu_0.add(menuItem_exit);
		
		JMenu menu_1 = new JMenu("\u0627\u0635\u0644\u0627\u062D");
		menu_1.setBackground(Color.WHITE);
		menu_1.setFont(new Font("B Mitra", Font.PLAIN, 18));
		menuBar.add(menu_1);
		
		JMenu menu_2 = new JMenu("\u0631\u0627\u0647\u0646\u0645\u0627\u06CC\u06CC");
		menu_2.setBackground(Color.WHITE);
		menu_2.setFont(new Font("B Mitra", Font.PLAIN, 18));
		menuBar.add(menu_2);
		
		JMenuItem menuItem_about = new JMenuItem("\u062F\u0631\u0628\u0627\u0631\u0647");
		menuItem_about.setBackground(Color.WHITE);
		menuItem_about.setFont(new Font("B Nazanin", menuItem_exit.getFont().getStyle(), 18));
		menu_2.add(menuItem_about);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 270, 270);
		contentPane.add(panel);
		
		JPanel panel_searchs = new JPanel();
		panel_searchs.setBackground(SystemColor.control);
		panel_searchs.setBorder(new TitledBorder(null, "\u0631\u0648\u0634 \u062C\u0633\u062A\u062C\u0648", TitledBorder.RIGHT, TitledBorder.TOP, null, Color.BLACK));
		panel_searchs.setBounds(281, 1, 261, 286);
		contentPane.add(panel_searchs);
		panel_searchs.setLayout(null);
		
		JLabel label_top = new JLabel("\u062C\u0633\u062A\u062C\u0648\u06CC \u0646\u0627\u0622\u06AF\u0627\u0647\u0627\u0646\u0647 :");
		label_top.setForeground(Color.BLACK);
		label_top.setFont(new Font("B Mitra", Font.PLAIN, 18));
		label_top.setBounds(152, 23, 99, 29);
		panel_searchs.add(label_top);
		
		JLabel label_bottom = new JLabel("\u062C\u0633\u062A\u062C\u0648\u06CC \u0622\u06AF\u0627\u0647\u0627\u0646\u0647 :");
		label_bottom.setForeground(Color.BLACK);
		label_bottom.setFont(new Font("B Mitra", Font.PLAIN, 18));
		label_bottom.setBounds(159, 155, 92, 29);
		panel_searchs.add(label_bottom);
		
		JButton button_BFS = new JButton("\u0627\u0648\u0644 \u0633\u0637\u062D");
		button_BFS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_BFS.setBackground(SystemColor.controlHighlight);
		button_BFS.setForeground(Color.BLACK);
		button_BFS.setFont(new Font("B Mitra", Font.PLAIN, 18));
		button_BFS.setBounds(76, 53, 141, 23);
		panel_searchs.add(button_BFS);
		
		JButton button_IDFS = new JButton("\u0639\u0645\u0642\u06CC \u0645\u062D\u062F\u0648\u062F \u0634\u0648\u0646\u062F\u0647");
		button_IDFS.setBackground(SystemColor.controlHighlight);
		button_IDFS.setForeground(Color.BLACK);
		button_IDFS.setFont(new Font("B Mitra", Font.PLAIN, 18));
		button_IDFS.setBounds(76, 87, 141, 23);
		panel_searchs.add(button_IDFS);
		
		JButton button_UCS = new JButton("\u0647\u0632\u06CC\u0646\u0647 \u06CC\u06A9\u0646\u0648\u0627\u062E\u062A");
		button_UCS.setBackground(SystemColor.controlHighlight);
		button_UCS.setForeground(Color.BLACK);
		button_UCS.setFont(new Font("B Mitra", Font.PLAIN, 18));
		button_UCS.setBounds(76, 121, 141, 23);
		panel_searchs.add(button_UCS);
		
		JButton button_A = new JButton("A*");
		button_A.setBackground(SystemColor.controlHighlight);
		button_A.setForeground(Color.BLACK);
		button_A.setFont(new Font("Arabic Typesetting", Font.PLAIN, 20));
		button_A.setBounds(76, 184, 141, 23);
		panel_searchs.add(button_A);
		
		JButton button_IDA = new JButton("IDA*");
		button_IDA.setBackground(SystemColor.controlHighlight);
		button_IDA.setForeground(Color.BLACK);
		button_IDA.setFont(new Font("Arabic Typesetting", Font.PLAIN, 20));
		button_IDA.setBounds(76, 215, 141, 23);
		panel_searchs.add(button_IDA);
		
		JButton button_SMA = new JButton("SMA*");
		button_SMA.setBackground(SystemColor.controlHighlight);
		button_SMA.setForeground(Color.BLACK);
		button_SMA.setFont(new Font("Arabic Typesetting", Font.PLAIN, 20));
		button_SMA.setBounds(76, 245, 141, 23);
		panel_searchs.add(button_SMA);
		
		JButton btnExit = new JButton("exit");
		btnExit.setBounds(107, -25, 23, 23);
		panel_searchs.add(btnExit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 292, 532, 192);
		contentPane.add(scrollPane);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setForeground(Color.WHITE);
		editorPane.setBackground(Color.BLACK);
		editorPane.setFont(new Font("Arabic Typesetting", Font.PLAIN, 16));
		scrollPane.setViewportView(editorPane);
	}
}
