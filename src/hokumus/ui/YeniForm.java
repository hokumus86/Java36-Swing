package hokumus.ui;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SpinnerListModel;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class YeniForm extends JFrame {

	JProgressBar prbarTest = null;
	JButton btnTikla = null;
	JComboBox comboBox = null;
	private JTextField txtColor;
	File dosya = null;
	JTextArea textArea = null;

	public YeniForm() {
		// TODO Auto-generated constructor stub
		initialize();
	}

	private void initialize() {
		getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 482, 30);
		getContentPane().add(menuBar);

		JMenu manuDosya = new JMenu("Dosya");
		menuBar.add(manuDosya);

		JMenuItem menuItemYeniKayit = new JMenuItem("Yeni Kay\u0131t");
		menuItemYeniKayit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AnaEkran temp = new AnaEkran();
				temp.setVisible(true);
				YeniForm.this.setVisible(false);
			}
		});
		manuDosya.add(menuItemYeniKayit);

		JMenuItem menuItemKaydet = new JMenuItem("Kaydet");
		manuDosya.add(menuItemKaydet);

		JMenu menuHakkinda = new JMenu("Hakk\u0131nda");
		menuBar.add(menuHakkinda);

		JMenuItem mnýtmSdfsdf = new JMenuItem("sdfsdf");
		menuHakkinda.add(mnýtmSdfsdf);

		prbarTest = new JProgressBar();
		prbarTest.setBounds(10, 42, 200, 30);
		getContentPane().add(prbarTest);

		btnTikla = new JButton("T\u0131kla");
		btnTikla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread t = new Thread() {
					public void run() {
						for (int i = 0; i <= 100; i++) {
							prbarTest.setValue(i);

							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
							}
						}
					}
				};
				t.start();
			}
		});
		btnTikla.setBounds(298, 41, 91, 23);
		getContentPane().add(btnTikla);

		txtColor = new JTextField();
		txtColor.setBounds(10, 125, 200, 20);
		getContentPane().add(txtColor);
		txtColor.setColumns(10);

		JButton btnColorChose = new JButton("Renk Se\u00E7");
		btnColorChose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color secilenRenk = JColorChooser.showDialog(YeniForm.this,
						"Renk Seçim Paleti", Color.black);
				if (secilenRenk == null) {
					JOptionPane.showMessageDialog(YeniForm.this,
							"Seçim Yapýlmadý");
				} else {
					JOptionPane.showMessageDialog(
							YeniForm.this,
							"Seçim Yapýldý Seçilen Renk : "
									+ secilenRenk.toString());
					txtColor.setBackground(secilenRenk);
				}
			}
		});
		btnColorChose.setBounds(298, 124, 91, 23);
		getContentPane().add(btnColorChose);
		
		JSpinner spinner = new JSpinner();
		SpinnerListModel model = new SpinnerListModel(new String [] {"hüseyin ", "Gizem", "Doðukan", "Tuðçe"});
		spinner.setModel(model);
		spinner.setBounds(30, 201, 120, 23);
		getContentPane().add(spinner);
		
		
		String[] cmbVeri = {"","Lisans", "ilk öðretim", "lise", "okuma yazma bilmeyen"};
		comboBox = new JComboBox(cmbVeri);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				JOptionPane.showMessageDialog(YeniForm.this, comboBox.getSelectedItem().toString());
			}
		});
		comboBox.setBounds(30, 167, 130, 23);
		getContentPane().add(comboBox);
		
		JButton btnFileChoose = new JButton("Dosya Se\u00E7");
		btnFileChoose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc= new JFileChooser();
				fc.addChoosableFileFilter(new FileNameExtensionFilter("Text Dosyasý", "txt"));
				int secim =fc.showDialog(YeniForm.this, "Dosya Seç");
				fc.setDialogTitle("Dosya Seçme Formu");
				if(secim == JFileChooser.APPROVE_OPTION){
					dosya =fc.getSelectedFile();
					JOptionPane.showMessageDialog(YeniForm.this, "Dosya Seçildi Seçilen : "+ dosya.getName());
					try {
						BufferedReader in = new BufferedReader(new FileReader(dosya));
						String okunan = in.readLine();
						while(okunan !=null){
							String [] s =okunan.split("=");
							textArea.append(s[1]);
							textArea.append("\n");
							okunan = in.readLine();
						}
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnFileChoose.setBounds(30, 249, 91, 23);
		getContentPane().add(btnFileChoose);
		
		 textArea = new JTextArea();
		textArea.setBounds(282, 167, 200, 195);
		getContentPane().add(textArea);
		setBounds(350, 50, 500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // / form kapanýrken ne
														// yapmasý gerektiðini
														// söylüyoruz

	}
}
