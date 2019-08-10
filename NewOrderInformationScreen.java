package Home;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.event.EventListenerList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.Box;
import javax.swing.SwingWorker;
import javax.swing.JButton;
import javax.swing.JList;

public class NewOrderInformationScreen extends JFrame{

	private JPanel contentPane;
	private JList listHuseyin;
	private JList listKorhan;
	private JList listDelivery;
	
	
	


	public JList getListHuseyin() {
		return listHuseyin;
	}

	public void setListHuseyin(JList listHuseyin) {
		this.listHuseyin = listHuseyin;
	}

	public JList getListKorhan() {
		return listKorhan;
	}

	public void setListKorhan(JList listKorhan) {
		this.listKorhan = listKorhan;
	}

	public JList getListDelivery() {
		return listDelivery;
	}

	public void setListDelivery(JList listDelivery) {
		this.listDelivery = listDelivery;
	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewOrderInformationScreen frame = new NewOrderInformationScreen();
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
	public NewOrderInformationScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 696, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblwaiter1 = new JLabel("Mustafa");
		lblwaiter1.setBounds(10, 37, 46, 14);
		contentPane.add(lblwaiter1);
		
		JLabel lblwaiter2 = new JLabel("Oktay");
		lblwaiter2.setBounds(10, 82, 46, 14);
		contentPane.add(lblwaiter2);
		
		JLabel lblwaiter3 = new JLabel("Ak\u0131n");
		lblwaiter3.setBounds(10, 130, 46, 14);
		contentPane.add(lblwaiter3);
		
		JLabel lblwaiter4 = new JLabel("Osman");
		lblwaiter4.setBounds(10, 185, 46, 14);
		contentPane.add(lblwaiter4);
		
		JLabel lblwaiter5 = new JLabel("Cagatay");
		lblwaiter5.setBounds(10, 241, 46, 14);
		contentPane.add(lblwaiter5);
		
		JLabel lblwaiter6 = new JLabel("Burcu");
		lblwaiter6.setBounds(10, 300, 46, 14);
		contentPane.add(lblwaiter6);
		
		JLabel lblwaiter7 = new JLabel("ozgur");
		lblwaiter7.setBounds(10, 348, 46, 14);
		contentPane.add(lblwaiter7);
		
		JLabel lblwaiter8 = new JLabel("gokhan");
		lblwaiter8.setBounds(10, 394, 46, 14);
		contentPane.add(lblwaiter8);
		
		JLabel lblchefkorhan = new JLabel("chefKorhan");
		lblchefkorhan.setBounds(445, 394, 64, 14);
		contentPane.add(lblchefkorhan);
		
		JLabel lblchefhuseyin = new JLabel("chefHuseyin");
		lblchefhuseyin.setBounds(330, 394, 64, 14);
		contentPane.add(lblchefhuseyin);
		
		listHuseyin = new JList();
		listHuseyin.setBounds(330, 36, 64, 259);
		contentPane.add(listHuseyin);
		
		listKorhan = new JList();
		listKorhan.setBounds(437, 36, 64, 260);
		contentPane.add(listKorhan);
		
		listDelivery = new JList();
		listDelivery.setBounds(178, 36, 64, 259);
		contentPane.add(listDelivery);
		
		JLabel lblDelivery = new JLabel("Delivery");
		lblDelivery.setBounds(183, 394, 46, 14);
		contentPane.add(lblDelivery);
	}
}
