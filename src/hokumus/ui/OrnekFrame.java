package hokumus.ui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrnekFrame extends JFrame {
	
	private String kullaniciAdi= "hokumus";
	private JTextField txtKullaniciAdi;
	private String sifre = "1";
	JTextField txtSifre;
	public OrnekFrame() {
		

		intialize();

	}
	
	public OrnekFrame(boolean tercih) {

		intialize();

	}

	private void intialize() {
		getContentPane().setBackground(Color.PINK);
		getContentPane().setLayout(null);
		setBounds(350, 50, 500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); /// form kapanýrken ne yapmasý gerektiðini söylüyoruz

		JLabel lblKullanciAdi = new JLabel("Kullan\u0131c\u0131 Ad\u0131");
		lblKullanciAdi.setBackground(Color.BLUE);
		lblKullanciAdi.setBounds(10, 10, 96, 20);
		getContentPane().add(lblKullanciAdi);

		JLabel lblSifre = new JLabel("Þifre");
		lblSifre.setBounds(10, 40, 96, 20);
		getContentPane().add(lblSifre);

		txtKullaniciAdi = new JTextField();
		txtKullaniciAdi.setBackground(Color.WHITE);
		txtKullaniciAdi.setBounds(120, 10, 200, 20);
		getContentPane().add(txtKullaniciAdi);

		txtSifre = new JTextField();
		txtSifre.setBackground(Color.WHITE);
		txtSifre.setBounds(120, 40, 200, 20);
		getContentPane().add(txtSifre);

		JButton btnGiris = new JButton("Giriþ");
		btnGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtKullaniciAdi.getText().equals(kullaniciAdi)&& txtSifre.getText().equals(sifre)){
					JOptionPane.showMessageDialog(OrnekFrame.this, "Giriþ Baþarýlý");
				}
				else 
					JOptionPane.showMessageDialog(OrnekFrame.this, "Hatalý Giriþ");
				
				//JOptionPane.showConfirmDialog(OrnekFrame.this, "Butona Basýldý");
			}
		});
		btnGiris.setBackground(Color.RED);
		btnGiris.setBounds(120, 86, 100, 20);
		getContentPane().add(btnGiris);

		JButton btnIptal = new JButton("Topla");
		btnIptal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sayi = Integer.parseInt(txtKullaniciAdi.getText());
				int sayi1 = Integer.parseInt(txtSifre.getText());
				int sonuc = sayi1+ sayi;
				JOptionPane.showMessageDialog(OrnekFrame.this, "iþlemin sonucu  :"+ sonuc);
				
				//System.exit(0);
			}
		});
		btnIptal.setBackground(Color.YELLOW);
		btnIptal.setBounds(239, 86, 100, 20);
		getContentPane().add(btnIptal);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(60, 201, 91, 23);
		getContentPane().add(btnNewButton);

	}
}
