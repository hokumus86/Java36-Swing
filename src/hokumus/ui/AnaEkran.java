package hokumus.ui;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;

import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JList;

public class AnaEkran extends JFrame {

	JComboBox cmbSayi = null;
	JButton btnTest1= null;
	JProgressBar prbar= null;
	JProgressBar prbar1= null;
	JButton btnTest = null;
	JLabel lblVersiyon;
	private javax.swing.Timer timer;
	private JTextField txtColor;
	private JTextField txtColor1;
	private File dosya;
	private JLabel lblDosya;
	private JPasswordField pswField;
	private JTextArea txtArea;

	public AnaEkran() {

		intialize();
	}
	public AnaEkran(int deger) {

		if(deger==1)
			intialize1();
		else
			intialize2();
	}

	private void intialize2() {
		setBounds(300, 350, 500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
	}
	private void intialize1() {
		setBounds(300, 350, 500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		prbar = new JProgressBar();
		prbar.setBounds(10, 52, 86, 34);
		getContentPane().add(prbar);
		
		 btnTest = new JButton("Test");
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnTest.setEnabled(false);				
				if (timer == null) {					
					timer =new Timer(50, new ActionListener() {
						 int deger=0;
						public void actionPerformed(ActionEvent e) {
							deger++;
							if(deger >100){
								timer.stop();
								timer =null;
								btnTest.setEnabled(true);
							}
							prbar.setValue(deger);
							
						}
					});
					timer.start();

				}
			}
		});
		btnTest.setBounds(106, 63, 91, 23);
		getContentPane().add(btnTest);
		
		JButton btnColor = new JButton("Renk Se\u00E7");
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color secilenRenk = JColorChooser.showDialog(AnaEkran.this, "Renk Seçim Ekraný", Color.black);
				if(secilenRenk != null){
					JOptionPane.showMessageDialog(AnaEkran.this, secilenRenk.toString() +"   renk seçildi");
					txtColor.setBackground(secilenRenk);
				}
				else {
					JOptionPane.showMessageDialog(AnaEkran.this, "Renk Seçimi yapýlmadý");
				}
			}
		});
		btnColor.setBounds(116, 113, 91, 23);
		getContentPane().add(btnColor);
		
		txtColor = new JTextField();
		txtColor.setBackground(Color.WHITE);
		txtColor.setBounds(10, 114, 86, 20);
		getContentPane().add(txtColor);
		txtColor.grabFocus();
		txtColor.setColumns(10);
		
		
		
	}
	private void intialize() {
		setBounds(500, 450, 400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JMenuBar menuAna = new JMenuBar();
		menuAna.setBounds(0, 0, 392, 21);
		getContentPane().add(menuAna);

		JMenu menuDosya = new JMenu("Dosya");
		menuAna.add(menuDosya);

		JMenuItem menuItemDAc = new JMenuItem("Dosya A\u00E7");
		menuItemDAc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menuDosya.add(menuItemDAc);

		JMenuItem menuItemKaydet = new JMenuItem("Kaydet");
		menuDosya.add(menuItemKaydet);

		JMenuItem menuItemCikis = new JMenuItem("\u00C7\u0131k\u0131\u015F");
		menuDosya.add(menuItemCikis);

		JMenu menuHakkinda = new JMenu("Hakk\u0131nda");
		menuAna.add(menuHakkinda);

		JMenuItem menuItemBilgi = new JMenuItem("Bilgi");
		menuItemBilgi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		menuHakkinda.add(menuItemBilgi);

		JMenuItem menuItemVersiyon = new JMenuItem("Versiyon");
		menuItemVersiyon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblVersiyon.setText("Versiyon : 1.2 Beta Sürümü");
			}
		});
		menuHakkinda.add(menuItemVersiyon);
		
		JMenu menuCikis2 = new JMenu("New menu");
		menuAna.add(menuCikis2);
		
		JMenuItem menuItemCikis1 = new JMenuItem("\u00C7\u0131k\u0131\u015F");
		menuItemCikis1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		menuCikis2.add(menuItemCikis1);
		
		JMenuItem menuHakinda = new JMenuItem("Hak\u0131nda");
		menuCikis2.add(menuHakinda);

		lblVersiyon = new JLabel("asd");
		lblVersiyon.setBounds(146, 147, 64, 28);
		getContentPane().add(lblVersiyon);
		lblVersiyon.setText("");

		
		
		
		txtColor1 = new JTextField();
		txtColor1.setBackground(Color.WHITE);
		txtColor1.setBounds(10, 114, 86, 20);
		getContentPane().add(txtColor1);
		txtColor1.grabFocus();
		txtColor1.setColumns(10);
		
		JButton btnColor = new JButton("Renk Se\u00E7");
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color secilenRenk = JColorChooser.showDialog(AnaEkran.this, "Renk Seçim Ekraný", Color.black);
				if(secilenRenk != null){
					JOptionPane.showMessageDialog(AnaEkran.this, secilenRenk.toString() +"   renk seçildi");
					txtColor.setBackground(secilenRenk);
				}
				else {
					JOptionPane.showMessageDialog(AnaEkran.this, "Renk Seçimi yapýlmadý");
				}
			}
		});
		btnColor.setBounds(116, 113, 91, 23);
		getContentPane().add(btnColor);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(20, 168, 86, 18);
		SpinnerListModel model = new SpinnerListModel(new String[] {"Pazartesi","Salý","Çarþamba","Perþembe",
				"Cuma","Cumartesi","Pazar" });
		spinner.setModel(model);
		getContentPane().add(spinner);
		
		
		
		
		JButton btnDosya = new JButton("Dosya Se\u00E7");
		btnDosya.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fc = new JFileChooser();
				fc.addChoosableFileFilter(new FileNameExtensionFilter("Text Dosyasý", "txt"));
				int sonuc =fc.showDialog(AnaEkran.this, "Dosya Seç");
				if(sonuc ==JFileChooser.APPROVE_OPTION ){
					dosya = fc.getSelectedFile();
					JOptionPane.showMessageDialog(AnaEkran.this, dosya.getName() +" isimli dosya Seçildi");
					lblDosya.setText(dosya.getName() + " Dosya Konumu" + dosya.getPath());
					try {
						BufferedReader in = new BufferedReader(new FileReader(dosya));
						String s = in.readLine();
						while(s!=null){
							String[] dizi =s.split("=");
							txtArea.append(dizi[0]);
							txtArea.append("      ");
							txtArea.append(dizi[1]);
							txtArea.append("\n");
							s= in.readLine();
							
						}
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				if(sonuc == JFileChooser.CANCEL_OPTION){
					JOptionPane.showMessageDialog(AnaEkran.this, "Dosya Seçilmedi ...!!!");
				}
					
			}
		});
		btnDosya.setBounds(177, 235, 91, 23);
		getContentPane().add(btnDosya);
		
		lblDosya = new JLabel("New label");
		lblDosya.setBounds(10, 336, 372, 14);
		getContentPane().add(lblDosya);
		
		pswField = new JPasswordField();
		pswField.setBounds(106, 204, 91, 20);
		getContentPane().add(pswField);
		
		 txtArea = new JTextArea();
		txtArea.setBounds(220, 29, 162, 174);
		getContentPane().add(txtArea);
		
		String[] veri = {"","Lisans","Lisans Üstü","Doktora","Docent","Profesör"};
		 cmbSayi = new JComboBox(veri);
		cmbSayi.setBounds(20, 266, 86, 22);
		cmbSayi.setSelectedIndex(1);
		getContentPane().add(cmbSayi);
		
		

	}
}
