package goblinClicker;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GoblinMain 
{
	JLabel counterLabel, damageLabel;
	JButton button1, button2, button3, button4;
	//index 0 = stick, 1 = dagger, 2 = longsword, 3 = Excalibur
	int[] price = {10, 100, 1000, 10000};
	int[] num = {0, 0, 0, 0};
	int goldCounter, dmg;
	boolean daggerUnlocked, longswordUnlocked, excaliburUnlocked;
	Font font1, font2;
	GoblinHandler gHandler = new GoblinHandler();
	JTextArea messageText, instructionText, shopInstructionText;
	MouseHandler mHandler = new MouseHandler();
	
	public static void main(String[] args)
	{
		new GoblinMain();
	}
	public GoblinMain()
	{
		goldCounter = 0;
		dmg = 1;
		daggerUnlocked = false;
		longswordUnlocked = false;
		excaliburUnlocked = false;
		
		createFont();
		createUI();
		damageUpdate();
	}
	public void createFont()
	{
		font1 = new Font("Times New Roman", Font.PLAIN, 32);
		font2 = new Font("Times New Roman", Font.PLAIN, 16);
	}
	public void createUI()
	{
		//--------------WINDOW--------------
		JFrame window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		
		//--------------GOBLIN PANEL--------------
		JPanel goblinPanel = new JPanel();
		goblinPanel.setBounds(100, 220, 200, 200);
		goblinPanel.setBackground(Color.black);
		window.add(goblinPanel);
		
		ImageIcon goblin = new ImageIcon(getClass().getClassLoader().getResource("output-onlinepngtools (2).png"));
		
		//--------------GOBLIN BUTTON--------------
		JButton goblinButton = new JButton();
		goblinButton.setBackground(Color.black);
		goblinButton.setFocusPainted(false);
		goblinButton.setBorder(null);
		goblinButton.setIcon(goblin);
		goblinButton.addActionListener(gHandler);
		goblinButton.setActionCommand("goblin");
		goblinPanel.add(goblinButton);
		
		//--------------COUNTER PANEL--------------
		JPanel counterPanel = new JPanel();
		counterPanel.setBounds(100, 100, 200, 100);
		counterPanel.setBackground(Color.black);
		counterPanel.setLayout(new GridLayout(2, 1));
		window.add(counterPanel);
		
		//--------------INSTRUCTION PANEL--------------
		JPanel instructionPanel = new JPanel();
		instructionPanel.setBounds(100, 450, 200, 100);
		instructionPanel.setBackground(Color.black);
		instructionPanel.setLayout(new GridLayout(1, 1));
		window.add(instructionPanel);
		
		//--------------INSTRUCTION TEXT AREA--------------
		instructionText = new JTextArea("Beat up the goblin and take his gold!");
		instructionText.setBounds(100, 450, 200, 100);
		instructionText.setForeground(Color.white);
		instructionText.setBackground(Color.black);
		instructionText.setFont(font2);
		instructionText.setLineWrap(true);
		instructionText.setWrapStyleWord(true);
		instructionText.setEditable(false);
		instructionPanel.add(instructionText);
		
		//--------------SHOP INSTRUCTION PANEL--------------
		JPanel shopInstructionPanel = new JPanel();
		shopInstructionPanel.setBounds(500, 450, 250, 150);
		shopInstructionPanel.setBackground(Color.black);
		shopInstructionPanel.setLayout(new GridLayout(1, 1));
		window.add(shopInstructionPanel);
				
		//--------------SHOP INSTRUCTION TEXT AREA--------------
		shopInstructionText = new JTextArea("Buy weapons to beat him up for more gold!");
		shopInstructionText.setBounds(500, 450, 250, 150);
		shopInstructionText.setForeground(Color.white);
		shopInstructionText.setBackground(Color.black);
		shopInstructionText.setFont(font2);
		shopInstructionText.setLineWrap(true);
		shopInstructionText.setWrapStyleWord(true);
		shopInstructionText.setEditable(false);
		shopInstructionPanel.add(shopInstructionText);
		
		//--------------COUNTER LABEL--------------
		counterLabel = new JLabel("    " + goldCounter + " Gold");
		counterLabel.setForeground(Color.white);
		counterLabel.setFont(font1);
		counterPanel.add(counterLabel);
		
		//--------------DAMAGE LABEL--------------
		damageLabel = new JLabel();
		damageLabel.setForeground(Color.white);
		damageLabel.setFont(font2);
		counterPanel.add(damageLabel);
		
		//--------------ITEM PANEL--------------
		JPanel itemPanel = new JPanel();
		itemPanel.setBounds(500, 170, 250, 250);
		itemPanel.setBackground(Color.black);
		itemPanel.setLayout(new GridLayout(4, 1));
		window.add(itemPanel);
		
		//--------------SHOP BUTTONS--------------
		button1 = new JButton("Stick");
		button1.setFont(font1);
		button1.setFocusPainted(false);
		button1.addActionListener(gHandler);
		button1.setActionCommand("Stick");
		button1.addMouseListener(mHandler);
		itemPanel.add(button1);
		
		button2 = new JButton("?");
		button2.setFont(font1);
		button2.setFocusPainted(false);
		button2.addActionListener(gHandler);
		button2.setActionCommand("Dagger");
		button2.addMouseListener(mHandler);
		itemPanel.add(button2);
		
		button3 = new JButton("?");
		button3.setFont(font1);
		button3.setFocusPainted(false);
		button3.addActionListener(gHandler);
		button3.setActionCommand("Longsword");
		button3.addMouseListener(mHandler);
		itemPanel.add(button3);
		
		button4 = new JButton("?");
		button4.setFont(font1);
		button4.setFocusPainted(false);
		button4.addActionListener(gHandler);
		button4.setActionCommand("Excalibur");
		button4.addMouseListener(mHandler);
		itemPanel.add(button4);
		
		//--------------MESSAGE PANEL--------------
		JPanel messagePanel = new JPanel();
		messagePanel.setBounds(500, 70, 250, 150);
		messagePanel.setBackground(Color.black);
		window.add(messagePanel);
		
		//--------------MESSAGE TEXT AREA--------------
		messageText = new JTextArea();
		messageText.setBounds(500, 70, 250, 150);
		messageText.setForeground(Color.white);
		messageText.setBackground(Color.black);
		messageText.setFont(font2);
		messageText.setLineWrap(true);
		messageText.setWrapStyleWord(true);
		messageText.setEditable(false);
		messagePanel.add(messageText);
		
		window.setVisible(true);
	}
	public void damageUpdate()
	{
		damageLabel.setText("      Gold per Click: " + dmg);
	}
	public void goldUpdate()
	{
		counterLabel.setText("    " + goldCounter + " Gold");
	}
	
	public class GoblinHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			String action = event.getActionCommand();
			
			if(action.equals("goblin"))
			{
				goldCounter += dmg;
				counterLabel.setText("    " + goldCounter + " Gold");
				if(daggerUnlocked == false)
				{
					if(goldCounter >= price[1])
					{
						daggerUnlocked = true;
						button2.setText("Dagger " + "(" + num[1] + ")");
					}
				}
				if(longswordUnlocked == false)
				{
					if(goldCounter >= price[2])
					{
						longswordUnlocked = true;
						button3.setText("Longsword " + "(" + num[2] + ")");
					}
				}
				if(excaliburUnlocked == false)
				{
					if(goldCounter >= price[3])
					{
						excaliburUnlocked = true;
						button4.setText("Excalibur " + "(" + num[3] + ")");
					}
				}
			}
			else if(action.equals("Stick"))
			{
				if(goldCounter >= price[0])
				{
					goldCounter = goldCounter - price[0];
					price[0] = price[0] + 5;
					goldUpdate();
					
					num[0]++;
					button1.setText("Stick " + "(" + num[0] + ")");
					messageText.setText("Stick\n[Price: " + price[0] + "]\nIncrease Gold per click by 1.");
					dmg = dmg + 1;
					damageUpdate();
				}
				else
				{
					messageText.setText("You don't have enough gold!");
				}
			}
			else if(action.equals("Dagger"))
			{
				if(goldCounter >= price[1])
				{
					goldCounter = goldCounter - price[1];
					price[1] = price[1] + 50;
					goldUpdate();
					
					num[1]++;
					button2.setText("Dagger " + "(" + num[1] + ")");
					messageText.setText("Dagger\n[Price: " + price[1] + "]\nIncrease Gold per click by 10.");
					dmg = dmg + 10;
					damageUpdate();
				}
				else
				{
					messageText.setText("You don't have enough gold!");
				}
			}
			else if(action.equals("Longsword"))
			{
				if(goldCounter >= price[2])
				{
					goldCounter = goldCounter - price[2];
					price[2] = price[2] + 500;
					goldUpdate();
					
					num[2]++;
					button3.setText("Longsword " + "(" + num[2] + ")");
					messageText.setText("Longsword\n[Price: " + price[2] + "]\nIncrease Gold per click by 10.");
					dmg = dmg + 100;
					damageUpdate();
				}
				else
				{
					messageText.setText("You don't have enough gold!");
				}
			}
			else if(action.equals("Excalibur"))
			{
				if(goldCounter >= price[3])
				{
					goldCounter = goldCounter - price[3];
					price[3] = price[3] + 5000;
					goldUpdate();
					
					num[3]++;
					button4.setText("Excalibur " + "(" + num[3] + ")");
					messageText.setText("Excalibur\n[Price: " + price[3] + "]\nIncrease Gold per click by 10.");
					dmg = dmg + 1000;
					damageUpdate();
				}
				else
				{
					messageText.setText("You don't have enough gold!");
				}
			}
		}
	}
	
	public class MouseHandler implements MouseListener
	{
		@Override
		public void mouseClicked(MouseEvent e)
		{
			
		}
		@Override
		public void mousePressed(MouseEvent e)
		{
			
		}
		@Override
		public void mouseReleased(MouseEvent e)
		{
			
		}
		@Override
		public void mouseEntered(MouseEvent e)
		{
			JButton button = (JButton)e.getSource();
			if(button == button1)
			{
				messageText.setText("Stick\n[Price: " + price[0] + "]\nIncrease Gold per click by 1.");
			}
			else if(button == button2)
			{
				if(daggerUnlocked == false)
				{
					messageText.setText("This weapon is currently locked!");
				}
				else
				{
					messageText.setText("Dagger\n[Price: " + price[1] + "]\nIncrease Gold per click by 10.");
				}
			}
			else if(button == button3)
			{
				if(longswordUnlocked == false)
				{
					messageText.setText("This weapon is currently locked!");
				}
				else
				{
					messageText.setText("Longsword\n[Price: " + price[2] + "]\nIncrease Gold per click by 100.");
				}
			}
			else if(button == button4)
			{
				if(excaliburUnlocked == false)
				{
					messageText.setText("This weapon is currently locked!");
				}
				else
				{
					messageText.setText("Excalibur\n[Price: " + price[3] + "]\nIncrease Gold per click by 1000.");
				}
			}
		}
		@Override
		public void mouseExited(MouseEvent e)
		{
			JButton button = (JButton)e.getSource();
			if(button == button1)
			{
				messageText.setText(null);
			}
			else if(button == button2)
			{
				messageText.setText(null);
			}
			else if(button == button3)
			{
				messageText.setText(null);
			}
			else if(button == button4)
			{
				messageText.setText(null);
			}
		}
	}
}
