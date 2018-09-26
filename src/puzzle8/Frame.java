package puzzle8;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Frame extends JFrame  {
	
	private int[][] initial = { { 1, 2, 3 }, { 8, 0, 4 }, { 7, 6, 5 } };
	private int[][] goal = { { 1, 2, 3 }, { 8, 0, 4 }, { 7, 6, 5 } };
	public static int[][] map = { { 1, 2, 3 }, { 8, 0, 4 }, { 7, 6, 5 } };
	public static Panel panel;
	private static JEditorPane console;
	private Puzzle puzzle = new Puzzle();
	private int blankX = 1, blankY = 1;
	private Font digital, appFont;
	
	public Frame() {
		try {
			panel = new Panel();
			panel.setBounds(5, 10, 270, 270);
			setBounds(330, 50, 568, 555);
			setBackground(SystemColor.control);
			setLayout(null);
			add(panel);
			setTitle("معمای-8");
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			Image icon = ImageIO.read(Frame.class.getResource("icon.png"));
			setIconImage(icon);
			Random random = new Random();
			try {
				digital = Font.createFont(Font.TRUETYPE_FONT, Frame.class.getResourceAsStream("digital-7.ttf"));
				appFont = Font.createFont(Font.TRUETYPE_FONT, Frame.class.getResourceAsStream("BMitra.ttf"));
				digital = digital.deriveFont(60f);
				appFont = appFont.deriveFont(18f);
			}
			catch (FontFormatException e) {
				e.printStackTrace();
			}
			
			JMenuBar menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			
			JMenu menu_game = new JMenu("بازی");
			menu_game.setBackground(Color.WHITE);
			menu_game.setFont(appFont);
			menuBar.add(menu_game);
			
			JMenu menu_new = new JMenu("جدید");
			menu_new.setBackground(Color.WHITE);
			menu_new.setFont(appFont);
			menu_game.add(menu_new);
			
			JTextField input = new JTextField();
			input.setText("812043765");
			input.setColumns(10);
			menu_new.add(input);
			
			JMenuItem menuItem_ok = new JMenuItem("تایید");
			menuItem_ok.setBackground(Color.WHITE);
			menuItem_ok.setFont(appFont);
			menuItem_ok.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					if(input.getText().length() == 9)
						initialize(input.getText());
				}
			});
			menu_new.add(menuItem_ok);
			
			JMenuItem menuItem_thread = new JMenuItem("نخ های فعال");
			menuItem_thread.setBackground(Color.WHITE);
			menuItem_thread.setFont(appFont);
			menuItem_thread.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					print("تعداد نخ های در حال اجرا:"+Thread.activeCount()+"\n");
				}
			});
			menu_game.add(menuItem_thread);
			
			JMenuItem menuItem_exit = new JMenuItem("خروج");
			menuItem_exit.setBackground(Color.WHITE);
			menuItem_exit.setFont(appFont);
			menuItem_exit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					System.exit(0);
				}
			});
			menu_game.add(menuItem_exit);
			
			JMenu menu_edit = new JMenu("ابزار");
			menu_edit.setBackground(Color.WHITE);
			menu_edit.setFont(appFont);
			menuBar.add(menu_edit);
			
			JMenuItem menuItem_random = new JMenuItem("حالت تصادفی");
			menuItem_random.setBackground(Color.WHITE);
			menuItem_random.setFont(appFont);
			menuItem_random.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					ArrayList<Integer> duplicates = new ArrayList<Integer>();
					while(true) {
					for (int i = 0; i < 3; i++)
						for (int j = 0; j < 3; j++) {
							while(true) {
								int rnd = random.nextInt(9);
								if(duplicates.contains(rnd))
									continue;
								else {
									initial[i][j] = rnd;
									duplicates.add(rnd);
									break;
								}
							}
						}
					if(puzzle.isSolvable(initial))
						break;
					else 
						duplicates.clear();
					}
					map = initial;
					panel.repaint();
				}
			});
			menu_edit.add(menuItem_random);
			
			JMenu menu_help = new JMenu("راهنمایی");
			menu_help.setBackground(Color.WHITE);
			menu_help.setFont(appFont);
			menuBar.add(menu_help);
			
			JMenuItem menuItem_about = new JMenuItem("درباره");
			menuItem_about.setBackground(Color.WHITE);
			menuItem_about.setFont(appFont);
			menuItem_about.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					JOptionPane.showMessageDialog(null, "Programmer:\nsayyid abbas aghaei\namir reza asadi", "درباره", JOptionPane.PLAIN_MESSAGE);
				}
			});
			menu_help.add(menuItem_about);
			
			JPanel panel_searchs = new JPanel();
			panel_searchs.setBackground(SystemColor.control);
			panel_searchs.setBorder(new TitledBorder(new LineBorder(Color.gray,1,true), "روش جستجو", TitledBorder.RIGHT, TitledBorder.TOP, appFont, Color.BLACK));
			panel_searchs.setBounds(281, 1, 261, 286);
			panel_searchs.setLayout(null);
			add(panel_searchs);
			
			JLabel label_top = new JLabel("جستجوی ناآگاهانه :");
			label_top.setForeground(Color.BLACK);
			label_top.setFont(appFont);
			label_top.setBounds(152, 23, 99, 29);
			panel_searchs.add(label_top);
			
			JLabel label_bottom = new JLabel("جستجوی آگاهانه :");
			label_bottom.setForeground(Color.BLACK);
			label_bottom.setFont(appFont);
			label_bottom.setBounds(159, 155, 92, 29);
			panel_searchs.add(label_bottom);
			
			JButton button_BFS = new JButton("اول سطح");
			button_BFS.setBackground(SystemColor.controlHighlight);
			button_BFS.setForeground(Color.BLACK);
			button_BFS.setFont(appFont);
			button_BFS.setBounds(76, 53, 141, 23);
			button_BFS.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					print(":جستجوی اول سطح"+"\n");
					Thread bfs = new Thread(new Runnable() {
						public void run() {
							puzzle.solve_BFS(initial, goal, blankX, blankY);
						}});
					bfs.start();
				}
			});
			panel_searchs.add(button_BFS);
			
			JButton button_IDFS = new JButton("عمقی محدود شونده");
			button_IDFS.setBackground(SystemColor.controlHighlight);
			button_IDFS.setForeground(Color.BLACK);
			button_IDFS.setFont(appFont);
			button_IDFS.setBounds(76, 87, 141, 23);
			button_IDFS.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					print(":جستجوی عمقی محدود شونده"+"\n");
					Thread idfs = new Thread(new Runnable() {
						public void run() {
							puzzle.solve_IDFS(initial, goal, blankX, blankY);
						}});
					idfs.start();
				}
			});
			panel_searchs.add(button_IDFS);
			
			JButton button_UCS = new JButton("هزینه یکنواخت");
			button_UCS.setBackground(SystemColor.controlHighlight);
			button_UCS.setForeground(Color.BLACK);
			button_UCS.setFont(appFont);
			button_UCS.setBounds(76, 121, 141, 23);
			button_UCS.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					print(":جستجوی هزینه یکنواخت"+"\n");
					Thread ucs = new Thread(new Runnable() {
						public void run() {
							puzzle.solve_UCS(initial, goal, blankX, blankY);
						}});
					ucs.start();
				}
			});
			panel_searchs.add(button_UCS);
			
			JButton button_A = new JButton("A*");
			button_A.setBackground(SystemColor.controlHighlight);
			button_A.setForeground(Color.BLACK);
			button_A.setBounds(76, 184, 141, 23);
			button_A.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					print(":A* جستجوی"+"\n");
					Thread aStar = new Thread(new Runnable() {
						public void run() {
							puzzle.solve_AStar(initial, goal, blankX, blankY);
						}});
					aStar.start();
				}
			});
			panel_searchs.add(button_A);
			
			JButton button_IDA = new JButton("IDA*");
			button_IDA.setBackground(SystemColor.controlHighlight);
			button_IDA.setForeground(Color.BLACK);
			button_IDA.setBounds(76, 215, 141, 23);
			button_IDA.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					print(":IDA* جستجوی"+"\n");
					Thread ida = new Thread(new Runnable() {
						public void run() {
							puzzle.solve_IDA(initial, goal, blankX, blankY);
						}});
					ida.start();
				}
			});
			panel_searchs.add(button_IDA);
			
			JButton button_SMA = new JButton("اولین بهترین حریصانه");
			button_SMA.setBackground(SystemColor.controlHighlight);
			button_SMA.setForeground(Color.BLACK);
			button_SMA.setFont(appFont);
			button_SMA.setBounds(76, 245, 141, 23);
			button_SMA.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					print(":first greedy جستجوی"+"\n");
					Thread sma = new Thread(new Runnable() {
						public void run() {
							puzzle.solve_firstGreedy(initial, goal, blankX, blankY);
						}});
					sma.start();
				}
			});
			panel_searchs.add(button_SMA);
			
			JButton btnExit = new JButton("exit");
			btnExit.setBounds(107, -25, 23, 23);
			panel_searchs.add(btnExit);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 292, 532, 192);
			add(scrollPane);
			
			console = new JEditorPane();
			console.setForeground(Color.WHITE);
			console.setBackground(Color.BLACK);
			scrollPane.setViewportView(console);
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void print(String msg) {
		console.setText(console.getText()+msg);
	}
	
	private void initialize(String input) {
		input = input.replace(" ", "");
		for (int i = 0, k = 0; i < 3; i++)
			for (int j = 0; j < 3; j++, k++)
				initial[i][j] = Integer.parseInt(input.charAt(k) + "");
		
		map = initial;
		panel.repaint();
		
		for (int i = 0; i < 3; i++)
				for (int j = 0; j < 3; j++)
					if (initial[i][j] == 0) {
						blankX = i;
						blankY = j;
					}	
		if(!puzzle.isSolvable(initial))
			JOptionPane.showMessageDialog(this, "این حالت قابل حل نیست!", "هشدار", JOptionPane.WARNING_MESSAGE);
	}
	
	class Panel extends JPanel {
		
		private Color border, inside, text;
		
		public Panel() {
			inside = new Color(8, 0, 0);
			text = new Color(110, 5, 5);
			border = Color.WHITE;
		}
		
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.setFont(digital);
			for(int i=0;i<3;i++)
				for(int j=0;j<3;j++) {
					g.setColor(inside);
					g.fillRect(j*90, i*90, 90, 90);
					g.setColor(border);
					g.drawRect(j*90, i*90, 90, 90);
					g.setColor(text);
					if(map[i][j] != 0)
						g.drawString(map[i][j]+"", j*90+30, i*90+65);
				}
		}
	}
}
