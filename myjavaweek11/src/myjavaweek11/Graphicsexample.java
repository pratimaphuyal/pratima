package myjavaweek11;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Timer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class Graphicsexample extends JFrame implements ActionListener {

	
	static JMenuBar bar;
	static JMenu jmenu;
	static JMenu menu;
	static JMenu mn;
	static JMenu mnu;
	static JMenuItem itm1 ,itm2,itm3, itm4, itm5, itm6;
	JPanel jpanel;
	JPanel sidepanel,sidepanel1,sidepanel2,sidepanel3,sidepanel4,sidepanel5;
	JPanel bottompanel;
  JButton button[][]=new JButton[13][16];
  int players=2;
  JButton btnrun;
  JButton btnreset;
  JButton btnact;
  JLabel lblspeed;
  JLabel lbltimer,cln, cln1,score1,score2,teamlabel;//JLabel for sidepanel1
  JTextField txthrs,txtmins,txtsecs,txtscoreL,txtscoreR;//JTextField for sidepanel1
  JLabel joption, jsquare,jdirection;//JLabel for sidepanel2
  JTextField toption,tsquare,tdirection;//JTextField for sidepanel2
  JButton btntopright,btnleft,btntopleft,btnright,btncenter,btnbottomright,btnbottomleft,btnup, btndown;//JButton for sidepanel3
  JButton compassbtn;//for sidepanel4
  JButton duoplayer,squadplayer,multiplayer,exitbtn;//JButton for sidepanel5
 
  //timer
  boolean begun=false;
  private int ticks =0;
  private Timer timer;
  private Timer timerMove;
  private DecimalFormat decimalFormat= new  DecimalFormat("0");
  private int txtscoreL1=0,txtscoreR1=0;
  
  JSlider speedslider;
  boolean run=false;
  
  ImageIcon iconwhite=new ImageIcon ("myimages/white32x32.png");
  ImageIcon iconrun=new ImageIcon("myimages/run.png");
  ImageIcon iconact=new ImageIcon("myimages/step.png");
  ImageIcon iconreset=new ImageIcon("myimages/reset.png");
  ImageIcon iconpause=new ImageIcon("myimages/pause.png");
  ImageIcon iconbrick=new ImageIcon("myimages/bricks2.jpg");
  ImageIcon iconbaby1=new ImageIcon("myimages/baby1.png");
  ImageIcon iconbaby2=new ImageIcon("myimages/baby2.png");
  ImageIcon iconball=new ImageIcon("myimages/ball.png");
ImageIcon iconcompass=new ImageIcon("myimages/east.jpg");
	public static void main(String[] args) {
	Graphicsexample frame= new Graphicsexample();
	bar=new JMenuBar();
	jmenu=new JMenu("Scenario");
	menu =new JMenu("Edit");
	mn=new JMenu("Controls");
	mnu=new JMenu("Help");
	itm1=new JMenuItem("New Stride Scenario");
	itm2=new JMenuItem("New Java Scenario");
	itm3=new JMenuItem("Open");
	frame.setSize(825,585);
	frame.setLayout(new FlowLayout());
	frame.setResizable(false);
	
	frame.setJMenuBar(bar);
	bar.add(jmenu);
	bar.add(menu);
	bar.add(mn);
	bar.add(mnu);
	jmenu.add(itm1);
	jmenu.add(itm2);
	jmenu.add(itm3);
	frame.createGUI();
	frame.setVisible(true);
	
	}
	public void createGUI() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window= getContentPane();
		window.setLayout(null);;
		setTitle("CBabyBallBounce-Baby Ball Bounce Application");
		jpanel();
		sidepanel();
		bottompanel();
	}
		public void jpanel() {
			Container window=getContentPane();
		jpanel=new JPanel();
		jpanel.setBounds(30,20, 550, 400);
		jpanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,Color.BLACK));
		jpanel.setLayout(new GridLayout(13, 16));
		jpanel.setBackground(Color.WHITE);
	window.add(jpanel);
		
		for(int a=0; a<13; a++) {
			for(int b=0; b<16; b++) {
				  button[a][b]=new JButton();
				  button[a][b].setBorderPainted(false);
				  button[a][b].setMargin(new Insets(0,0,0,0));
				button[a][b].setBackground(Color.WHITE);
				jpanel.add(button[a][b]);
				
			
				 if(button[a][b]==button[6][3]) {
					button[a][b].setIcon(iconbaby1);
				 }
				 else if(button[a][b]==button[6][4]) {
					button[a][b].setIcon(iconball);
				}
				 else if (b %16 ==7 || b %16 ==8)
					{
						button[a][b].setIcon(iconbrick);
					}
				 else if(button[a][b]==button[6][12]) {
					 button[a][b].setIcon(iconbaby2);
				 }
			}
			
		}
		
		}	
		public void sidepanel() {
			Container window=getContentPane();
		sidepanel=new JPanel();
		sidepanel.setBounds(600, 0, 200, 460);
		sidepanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		sidepanel.setBackground(Color.WHITE);
		window.add(sidepanel);
		sidepanel1();
		sidepanel2();
		sidepanel3();
		sidepanel4();
		sidepanel5();
		}
		public void sidepanel1() {
			sidepanel1=new JPanel();
			sidepanel1.setPreferredSize(new Dimension(190,100));
			sidepanel1.setBackground(Color.WHITE);
			sidepanel.add(sidepanel1);
			sidepanel1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));

			
		lbltimer=new JLabel("             DIGITAL TIMER             ");
		sidepanel1.add(lbltimer);
		
		
		txthrs=new JTextField("00", 2);
		setDefaults(txthrs);
		sidepanel1.add(txthrs);
		txthrs.setBackground(Color.BLACK);
		txthrs.setForeground(Color.WHITE);
		
		cln=new JLabel(" : ");
		sidepanel1.add(cln);
		
		txtmins =new JTextField("00", 2 );
		setDefaults(txtmins);
		sidepanel1.add(txtmins);
		txtmins.setBackground(Color.BLACK);
		txtmins.setForeground(Color.WHITE);
	
		
		cln1=new JLabel(" : ");
		sidepanel1.add(cln1);
		
		txtsecs =new JTextField("00", 2);
		setDefaults(txtsecs);
		sidepanel1.add(txtsecs);
		txtsecs.setBackground(Color.BLACK);
		txtsecs.setForeground(Color.WHITE);
		
		score1=new JLabel("                         SCORE                        ");
		sidepanel1.add(score1);
		
		txtscoreL=new JTextField(decimalFormat.format(txtscoreL1),2);
		setDefaults(txtscoreL);
		sidepanel1.add(txtscoreL);
		txtscoreL.setBackground(Color.BLACK);
		txtscoreL.setForeground(Color.WHITE);
		teamlabel=new JLabel("<L:R>");
		sidepanel1.add(teamlabel);
		
		txtscoreR=new JTextField(decimalFormat.format(txtscoreR1),2);
		setDefaults(txtscoreR);
		sidepanel1.add(txtscoreR);
		txtscoreR.setBackground(Color.BLACK);
		txtscoreR.setForeground(Color.WHITE);
		}
		
     public void sidepanel2() {
			sidepanel2=new JPanel();
			sidepanel2.setLayout(new GridLayout(3,2));
			sidepanel2.setPreferredSize(new Dimension(190,80));
			sidepanel2.setBackground(Color.WHITE);
			sidepanel.add(sidepanel2);
			sidepanel2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
			
			joption=new JLabel("       Option:     ");
			sidepanel2.add(joption);
			
			toption=new JTextField("2Player");
			setDefaults(toption);
			sidepanel2.add(toption);
			
			jsquare =new JLabel("       Square:      ");
			sidepanel2.add(jsquare);
			
			tsquare=new JTextField("101");
			setDefaults(tsquare);
			sidepanel2.add(tsquare);
			
			jdirection=new JLabel("      Direction:    ");
			sidepanel2.add(jdirection);
			
			tdirection=new JTextField("SE");
			setDefaults(tdirection);
			sidepanel2.add(tdirection);
			
		}
		public void sidepanel3() {
			sidepanel3=new JPanel();
			sidepanel3.setLayout(new GridLayout(3,3));
			sidepanel3.setPreferredSize(new Dimension(190,80));
			sidepanel.add(sidepanel3);
			sidepanel3.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
			
			
			btntopright =new JButton();
			sidepanel3.add(btntopright);
			btntopright.addActionListener(this);
			btntopright.setFocusable(false);
			btntopright.setBackground(Color.LIGHT_GRAY);
			
			btnup=new JButton("^");
			sidepanel3.add(btnup);
			btnup.addActionListener(this);
			btnup.setFocusable(false);
			btnup.setBackground(Color.WHITE);
			
			btntopleft=new JButton();
			sidepanel3.add(btntopleft);
			btntopleft.addActionListener(this);
			btntopleft.setFocusable(false);
			btntopleft.setBackground(Color.LIGHT_GRAY);
			
			
			btnleft=new JButton("<");
			sidepanel3.add(btnleft);
			btnleft.addActionListener(this);
			btnleft.setFocusable(false);
			btnleft.setBackground(Color.WHITE);
			
			btncenter=new JButton(iconball);
			sidepanel3.add(btncenter);
			btncenter.addActionListener(this);
			btncenter.setFocusable(false);
			btncenter.setBackground(Color.WHITE);
			
			btnright=new JButton(">");
			sidepanel3.add(btnright);
			btnright.addActionListener(this);
			btnright.setFocusable(false);
			btnright.setBackground(Color.WHITE);
			
			btnbottomright=new JButton();
			sidepanel3.add(btnbottomright);
			btnbottomright.addActionListener(this);
			btnbottomright.setFocusable(false);
			btnbottomright.setBackground(Color.LIGHT_GRAY);
			
			btndown=new JButton("v");
			sidepanel3.add(btndown);
			btndown.addActionListener(this);
			btndown.setFocusable(false);
			btndown.setBackground(Color.WHITE);
			
			btnbottomleft=new JButton();
			sidepanel3.add(btnbottomleft);
			btnbottomleft.addActionListener(this);
			btnbottomleft.setFocusable(false);
			btnbottomleft.setBackground(Color.LIGHT_GRAY);
			
			
		}
		public void sidepanel4() {
			sidepanel4=new JPanel();
			sidepanel4.setPreferredSize(new Dimension(190,100));
			sidepanel.add(sidepanel4);
			sidepanel4.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
			
			compassbtn=new JButton(iconcompass);
			sidepanel4.add(compassbtn);
			compassbtn.setFocusable(false);
			compassbtn.setBackground(Color.WHITE);
		
		}
		public void sidepanel5() {
			sidepanel5=new JPanel();
			sidepanel5.setLayout(new GridLayout(2,2));
			sidepanel5.setPreferredSize(new Dimension(190,70));
			sidepanel.add(sidepanel5);
			 
			duoplayer=new JButton("2player");
			sidepanel5.add(duoplayer);
			duoplayer.addActionListener(this);
			duoplayer.setFocusable(false);
			duoplayer.setBackground(Color.WHITE);
			
			 
			squadplayer=new JButton("4player");
			sidepanel5.add(squadplayer);
			squadplayer.addActionListener(this);
			squadplayer.setFocusable(false);
			squadplayer.setBackground(Color.WHITE);
			
			 
			multiplayer=new JButton("multiplayer");
			sidepanel5.add(multiplayer);
			multiplayer.addActionListener(this);
			multiplayer.setFocusable(false);
			multiplayer.setBackground(Color.WHITE);
			
			 
			exitbtn=new JButton("Exit");
			sidepanel5.add(exitbtn);
			exitbtn.addActionListener(this);
			exitbtn.setBackground(Color.WHITE);
			
			
		}
		
			
		
		
			
		
		private void setDefaults(JTextField textfield) {
			// TODO Auto-generated method stub
			
		}
		public void bottompanel() {
		Container window=getContentPane();
		  bottompanel=new JPanel();
		  bottompanel.setBounds(30, 465, 825 ,125);
		  bottompanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
		  bottompanel.setBackground(Color.WHITE);
		  window.add(bottompanel);  
		  btnrun=new JButton("Run",iconrun);
		  bottompanel.add(btnrun);
		  btnrun.addActionListener(this);
		  btnrun.setFocusable(false);
		  btnact=new JButton("Act", iconact);
		  bottompanel.add(btnact);
		  btnact.addActionListener(this);
		  btnact.setFocusable(false);
		  btnreset=new JButton("Reset", iconreset);
		  bottompanel.add(btnreset);
		  btnreset.addActionListener(this);
		  btnreset.setFocusable(false);
		  lblspeed=new JLabel("Speed");
		  bottompanel.add(lblspeed);
		  speedslider=new JSlider();
		  bottompanel.add(speedslider);
		 
		  }
		
		public void btnrun() {
			if(run) {
				btnrun.setIcon(iconrun);
				btnrun.setText("Run");
				timer.cancel();
				timerMove.cancel();
				run=false;
				btnact.setEnabled(true);
				begun=false;
				
			}
			else {
				btnrun.setIcon(iconpause);
				btnrun.setText("Pause");
				timer=new Timer();
			
			}
			
				
			
		}
		
		
		

	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		
	}
}
	
		
	
	
	


