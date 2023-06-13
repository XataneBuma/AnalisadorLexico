package analisadorLexico.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTable;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import analisadorLexico.Lexer;
import analisadorLexico.Token;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Rectangle;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;

public class TelaPrincipal {

	protected static final Object MAXIMIZED_BOTH = null;
	private JFrame frame;
	private DefaultTableModel tabelaModelo;
	private JTable tabela;
	private painelEditor painelXx;
	private PainelAux painelAux;
	private JTextArea areaTexto;
	private JTextArea areaLinha;
	private PainelAux2 painelAux2;
	private DefaultTableModel tabelaModelo2;
	private PainelAux3 painelAux3;
	private ImageIcon buma;
	public double tempoIn;
	public double tempoFim;
	public double tempoEstimado;
	


	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public TelaPrincipal() {
		initialize();
		
	}

	private void initialize() {
		
		buma = new ImageIcon("C:\\Users\\Matavele\\eclipse-workspace\\analisadorLexico\\icones\\icons8-source-code-44.png");
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setIconImage(buma.getImage());
		frame.setBounds(100, 100, 704, 422);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		painelAux = new PainelAux(frame);
//		painelXx = new painelEditor(frame);
		painelAux3 = new PainelAux3(frame);
		painelAux3.adicionarEspera();
		
		
		tabela = new JTable(tabelaModelo);
		areaLinha = new JTextArea();
		areaTexto = new JTextArea();
		
		
		JPanel cabecalho = new JPanel();
		cabecalho.setForeground(new Color(29, 22, 0));
		cabecalho.setBackground(new Color(0, 45, 59));
		cabecalho.setPreferredSize(new Dimension(800, 50));
		frame.getContentPane().add(cabecalho, BorderLayout.NORTH);
		cabecalho.setLayout(new BorderLayout(0, 0));
		
		JLabel iconeDev = new JLabel("");
		cabecalho.add(iconeDev, BorderLayout.WEST);
		iconeDev.setIcon(new ImageIcon("C:\\Users\\Matavele\\eclipse-workspace\\analisadorLexico\\icones\\icons8-source-code-44.png"));
		iconeDev.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel painelMinMaxClose = new JPanel();
		painelMinMaxClose.setBackground(new Color(0, 0, 64));
		painelMinMaxClose.setPreferredSize(new Dimension(150, 10));
		cabecalho.add(painelMinMaxClose, BorderLayout.EAST);
		painelMinMaxClose.setLayout(new BorderLayout(0, 0));
		
		JPanel butaoClose = new JPanel();
		butaoClose.setBackground(new Color(0, 45, 59));
		butaoClose.setPreferredSize(new Dimension(50, 10));
		painelMinMaxClose.add(butaoClose, BorderLayout.EAST);
		butaoClose.setLayout(new BorderLayout(0, 0));
		
		JLabel labelClose = new JLabel("");
		butaoClose.add(labelClose, BorderLayout.CENTER);
		labelClose.setBounds(new Rectangle(14, 0, 0, 0));
		labelClose.setBackground(new Color(0, 45, 59));
		labelClose.setIcon(new ImageIcon("C:\\Users\\Matavele\\eclipse-workspace\\analisadorLexico\\icones\\icons8-fechar-janela-24.png"));
		labelClose.setHorizontalAlignment(SwingConstants.CENTER);
		labelClose.addMouseListener(new MouseAdapter() {
			
			public void mudaCor(JPanel hover, Color rand) {
				hover.setBackground(rand);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				mudaCor(butaoClose,new Color(255,0,0));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				System.exit(0);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				mudaCor(butaoClose,new Color(0,45,59));
			}
		});
		
		JPanel botaoMinimize = new JPanel();
		botaoMinimize.setBackground(new Color(0, 45, 59));
		botaoMinimize.setPreferredSize(new Dimension(50, 10));
		painelMinMaxClose.add(botaoMinimize, BorderLayout.WEST);
		botaoMinimize.setLayout(new BorderLayout(0, 0));
		
		JPanel butaoMaximize = new JPanel();
		butaoMaximize.setBackground(new Color(0, 45, 59));
		painelMinMaxClose.add(butaoMaximize, BorderLayout.CENTER);
		butaoMaximize.setLayout(new BorderLayout(0, 0));
		
		JLabel labelMaximize = new JLabel("");
		butaoMaximize.add(labelMaximize, BorderLayout.CENTER);
		labelMaximize.setBackground(new Color(0, 45, 59));
		labelMaximize.setIcon(new ImageIcon("C:\\Users\\Matavele\\eclipse-workspace\\analisadorLexico\\icones\\icons8-maximizar-janela-30.png"));
		labelMaximize.setHorizontalAlignment(SwingConstants.CENTER);
		labelMaximize.addMouseListener(new MouseAdapter() {
			
			public void mudaCor(JPanel hover, Color rand) {
				hover.setBackground(rand);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				mudaCor(butaoMaximize,new Color(85,115,124));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				mudaCor(butaoMaximize,new Color(0,45,59));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(frame.getExtendedState() != frame.MAXIMIZED_BOTH) {
					frame.setExtendedState(frame.MAXIMIZED_BOTH);
				}
				else {
					frame.setExtendedState(frame.NORMAL);
				}
			}
		});
				
		JPanel dBoard = new JPanel();
		dBoard.setBackground(new Color(124, 255, 255));
		dBoard.setPreferredSize(new Dimension(50, 450));
		frame.getContentPane().add(dBoard, BorderLayout.WEST);
		dBoard.setLayout(new BorderLayout(0, 0));
		
		JPanel painelOpcoes = new JPanel();
		painelOpcoes.setBackground(new Color(0, 45, 59));
		painelOpcoes.setPreferredSize(new Dimension(50, 10));
		dBoard.add(painelOpcoes, BorderLayout.WEST);
		painelOpcoes.setLayout(null);
		
		JPanel separador1 = new JPanel();
		separador1.setBackground(new Color(0, 45, 59));
		separador1.setBounds(0, 0, 50, 10);
		painelOpcoes.add(separador1);
		
		JPanel painelMenu = new JPanel();
		painelMenu.setBackground(new Color(0, 15, 19));
		painelMenu.setPreferredSize(new Dimension(50, 10));
		dBoard.add(painelMenu, BorderLayout.CENTER);
		painelMenu.setLayout(null);
		
		JPanel telaFuncoes = new JPanel();
		telaFuncoes.setBackground(new Color(0, 15, 255));
		telaFuncoes.setBounds(0,0,200,36);
		telaFuncoes.setLayout(new BorderLayout(0,0));
		painelMenu.add(telaFuncoes);
		
		JLabel iconeCarregar = new JLabel();
		JLabel iconeSalvar = new JLabel();
		JLabel iconeExecutar = new JLabel();
		
		JPanel carregarExe = new JPanel();
		carregarExe.setBackground(new Color(0, 30, 39));
		carregarExe.setPreferredSize(new Dimension(63,36));
		carregarExe.add(iconeCarregar, BorderLayout.CENTER);
		iconeCarregar.setBackground(new Color(0, 45, 59));
		iconeCarregar.setIcon(new ImageIcon("C:\\Users\\Matavele\\eclipse-workspace\\analisadorLexico\\icones\\icons8-adicionar-arquivo-30.png"));
		iconeCarregar.setHorizontalAlignment(SwingConstants.CENTER);
		carregarExe.addMouseListener(new MouseAdapter() {
			public void mudaCor(JPanel hover, Color rand) {
				hover.setBackground(rand);}
			@Override
			public void mouseExited(MouseEvent e) {
				mudaCor(carregarExe,new Color(0,30,39));
			}
			@Override
			 public void mouseClicked(MouseEvent e) {
				mudaCor(carregarExe,new Color(0,45,59));
		        JFileChooser fileChooser = new JFileChooser();
		        int result = fileChooser.showOpenDialog(frame);
		        if (result == JFileChooser.APPROVE_OPTION) {
		            File selectedFile = fileChooser.getSelectedFile();
		            try {
		                BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
		                String line = null;
		                areaTexto.setText("");
		                while ((line = reader.readLine()) != null) {
		                    areaTexto.append(line + "\n");
		                }
		                reader.close();
		            } catch (IOException ex) {
		                ex.printStackTrace();
		            }
		        }
		    }
		});
		
		
		
		JPanel salvarExe = new JPanel();
		salvarExe.setBackground(new Color(0, 30, 39));
		salvarExe.setPreferredSize(new Dimension(63,36));
		salvarExe.add(iconeSalvar,BorderLayout.CENTER);
		iconeSalvar.setBackground(new Color(0, 45, 59));
		iconeSalvar.setIcon(new ImageIcon("C:\\Users\\Matavele\\eclipse-workspace\\analisadorLexico\\icones\\icons8-salvar-como-30.png"));
		iconeSalvar.setHorizontalAlignment(SwingConstants.CENTER);
		salvarExe.addMouseListener(new MouseAdapter() {
			public void mudaCor(JPanel hover, Color rand) {
				hover.setBackground(rand);}
			@Override
			public void mouseExited(MouseEvent e) {
				mudaCor(salvarExe, new Color(0,45,59));	
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				mudaCor(salvarExe, new Color(0,30,39));	
				areaTexto.setText("");
			}
		});
		
		JPanel funcaoExe = new JPanel();
		funcaoExe.setBackground(new Color(0, 30, 39));
		funcaoExe.add(iconeExecutar,BorderLayout.CENTER);
		iconeExecutar.setBackground(new Color(0, 45, 59));
		iconeExecutar.setIcon(new ImageIcon("C:\\Users\\Matavele\\eclipse-workspace\\analisadorLexico\\icones\\icons8-program-30.png"));
		iconeExecutar.setHorizontalAlignment(SwingConstants.CENTER);
		funcaoExe.addMouseListener(new MouseAdapter() {
			public void mudaCor(JPanel hover, Color rand) {
				hover.setBackground(rand);}
			@Override
			public void mouseExited(MouseEvent e) {
				mudaCor(funcaoExe,new Color(0,30,39));
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				tempoIn = System.nanoTime();
				String texto = areaTexto.getText();
				ArrayList<Token> token = Lexer.tokenize(texto);
				painelAux3.tabela(token);
				tempoFim = System.nanoTime();
				tempoEstimado = tempoFim - tempoIn;
				mudaCor(funcaoExe,new Color(0,45,59));
			}
		});
		
		telaFuncoes.add(funcaoExe,BorderLayout.CENTER);
		telaFuncoes.add(salvarExe,BorderLayout.EAST);
		telaFuncoes.add(carregarExe,BorderLayout.WEST);
		
		JPanel botaoAnalizar = new JPanel();
		botaoAnalizar.setForeground(new Color(255, 232, 225));
		botaoAnalizar.setBackground(new Color(0, 15, 19));
		botaoAnalizar.setBounds(10, 47, 190, 36);
		botaoAnalizar.setLayout(new BorderLayout(0,0));
		painelMenu.add(botaoAnalizar);
		

		JPanel botaoMenu = new JPanel();
		botaoMenu.setBackground(new Color(0, 45, 59));
		botaoMenu.setBounds(0, 11, 50, 50);
		painelOpcoes.add(botaoMenu);
		botaoMenu.setLayout(new BorderLayout(0, 0));
		botaoMenu.addMouseListener(new MouseAdapter() {
			
		});
		
		JPanel separador2 = new JPanel();
		separador2.setBackground(new Color(0, 45, 59));
		separador2.setBounds(0, 62, 50, 10);
		painelOpcoes.add(separador2);
		
		JPanel botaoDefinicao = new JPanel();
		botaoDefinicao.setBackground(new Color(0, 45, 59));
		botaoDefinicao.setBounds(0, 73, 50, 50);
		painelOpcoes.add(botaoDefinicao);
		botaoDefinicao.setLayout(new BorderLayout(0, 0));
		
		JLabel labelDefinicao = new JLabel("");
		botaoDefinicao.add(labelDefinicao, BorderLayout.CENTER);
		labelDefinicao.setBackground(new Color(0, 45, 59));
		labelDefinicao.setIcon(new ImageIcon("C:\\Users\\Matavele\\eclipse-workspace\\analisadorLexico\\icones\\icons8-engrenagem-30.png"));
		labelDefinicao.setHorizontalAlignment(SwingConstants.CENTER);
		labelDefinicao.addMouseListener(new MouseAdapter() {
			
			public void desliza(JPanel menuDesliza, boolean dboard) {
					menuDesliza.setPreferredSize(new Dimension(50,menuDesliza.getHeight()));
				
			}
			
			public void clickMenu(JPanel p1, JPanel p2, int numberBool) {
				if(numberBool == 1) {
					p1.setBackground(new Color(0,30,39));
					p2.setBackground(new Color(0,45,59));
					
				}
				else {
					p1.setBackground(new Color(0,45,59));
					p2.setBackground(new Color(0,30,39));
				}
				
			}
			
			public void mudaCor(JPanel hover, Color rand) {
				hover.setBackground(rand);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				mudaCor(separador2,new Color(85,115,124));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				mudaCor(separador2,new Color(0,45,59));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				painelAux3.adicionarEspera();
				clickMenu(botaoMenu,botaoDefinicao,0);
					
			}
		});
								
		JLabel labelMenu = new JLabel("");
		botaoMenu.add(labelMenu, BorderLayout.CENTER);
		labelMenu.setBackground(new Color(0, 45, 59));
		labelMenu.setHorizontalAlignment(SwingConstants.CENTER);
		labelMenu.setIcon(new ImageIcon("C:\\Users\\Matavele\\eclipse-workspace\\analisadorLexico\\icones\\icons8-menu-squared-30.png"));
		labelMenu.addMouseListener(new MouseAdapter() {
			private boolean a = false;
			private Object getExtendedState;
			public void clickMenu(JPanel p1, JPanel p2, int numberBool) {
				if(numberBool == 1) {
					p1.setBackground(new Color(0,30,39));
					p2.setBackground(new Color(0,45,59));
					
				}
				else {
					p1.setBackground(new Color(0,45,59));
					p2.setBackground(new Color(0,30,39));
				}
				
			}
			
			public void desliza(JPanel menuDesliza, boolean dashboard) {
				if(dashboard == false) {
					menuDesliza.setPreferredSize(new Dimension(250,menuDesliza.getHeight()));
				}
				else {
					menuDesliza.setPreferredSize(new Dimension(50,menuDesliza.getHeight()));
				}
				
			}
			
			public void mudaCor(JPanel hover, Color rand) {
				hover.setBackground(rand);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				mudaCor(separador1,new Color(85,115,124));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				mudaCor(separador1, new Color(0,45,59));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
				
				if(a == false) {
				labelMenu.setIcon(new ImageIcon("C:\\Users\\Matavele\\eclipse-workspace\\analisadorLexico\\icones\\icons8-ok-44.png"));
				desliza(dBoard,a);
				SwingUtilities.updateComponentTreeUI(frame);
				a=true;
				}
				else {
					labelMenu.setIcon(new ImageIcon("C:\\Users\\Matavele\\eclipse-workspace\\analisadorLexico\\icones\\icons8-menu-squared-30.png"));
					desliza(dBoard,a);
					SwingUtilities.updateComponentTreeUI(frame);
					a=false;
				}
				clickMenu(botaoMenu,botaoDefinicao,1);
			}
		});
		
		
		
		JPanel botaoResultado = new JPanel();
		botaoResultado.setForeground(new Color(255, 232, 225));
		botaoResultado.setBackground(new Color(0, 15, 19));
		botaoResultado.setBounds(10, 119, 190, 36);
		botaoResultado.setLayout(new BorderLayout(0,0));
		painelMenu.add(botaoResultado);
		
				
		JLabel labelResultado = new JLabel("          Resultados");
		labelResultado.setIcon(new ImageIcon("C:\\Users\\Matavele\\eclipse-workspace\\analisadorLexico\\icones\\icons8-data-30.png"));
		labelResultado.setFont(new Font("Roboto", Font.PLAIN, 11));
		labelResultado.setForeground(new Color(255, 232, 225));
		labelResultado.setHorizontalAlignment(SwingConstants.LEFT);
		botaoResultado.add(labelResultado,BorderLayout.CENTER);	
		
		JLabel labelAnalisar = new JLabel("              Editor");
		labelAnalisar.setVerticalAlignment(SwingConstants.BOTTOM);
		labelAnalisar.setIcon(new ImageIcon("C:\\Users\\Matavele\\eclipse-workspace\\analisadorLexico\\icones\\icons8-editor-30.png"));
		labelAnalisar.setFont(new Font("Roboto", Font.PLAIN, 11));
		labelAnalisar.setForeground(new Color(255, 232, 225));
		labelAnalisar.setHorizontalAlignment(SwingConstants.LEFT);
		
		botaoAnalizar.add(labelAnalisar,BorderLayout.CENTER);
		
		
		
		JPanel botaoCarregar = new JPanel();
		botaoCarregar.setForeground(new Color(255, 232, 225));
		botaoCarregar.setBackground(new Color(0, 15, 19));
		botaoCarregar.setBounds(10, 83, 190, 36);
		botaoCarregar.setLayout(new BorderLayout(0,0));
		painelMenu.add(botaoCarregar);
		botaoCarregar.addMouseListener(new MouseAdapter() {

			private boolean a = false;
			public void clickMenu(JPanel p1, JPanel p2, JPanel p3, int numberBool) {
				if(numberBool == 1) {
					p1.setBackground(new Color(0,45,59));
					p2.setBackground(new Color(0,15,19));
					p3.setBackground(new Color(0,15,19));
					
				}
				else {
					p1.setBackground(new Color(0,45,59));
					p2.setBackground(new Color(0,45,59));
					p3.setBackground(new Color(0,45,59));
				}
				
			}
			public void mudaCor(JPanel hover, Color rand) {
				hover.setBackground(rand);	
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				mudaCor(botaoCarregar,new Color(0,30,39));
//				painelXx.setVisible(false);
//				SwingUtilities.updateComponentTreeUI(frame);
//				painelAux.adicionar(tabela);
//				painelAux.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(a == false) {
				mudaCor(botaoCarregar,new Color(0,15,19));}
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				clickMenu(botaoCarregar,botaoAnalizar, botaoResultado,1 );
				
				painelAux3.adicionarTabela(tabela);
				
//				painelXx.setVisible(false);
//				
//				SwingUtilities.updateComponentTreeUI(frame);
//				painelAux.adicionar(tabela);
//				painelAux.setVisible(true);
				a = true;
					
			}
		});
		JLabel labelCarrega = new JLabel("          Ver Tabela");
		labelCarrega.setIcon(new ImageIcon("C:\\Users\\Matavele\\eclipse-workspace\\analisadorLexico\\icones\\icons8-tabela-30.png"));
		labelCarrega.setFont(new Font("Roboto", Font.PLAIN, 11));
		labelCarrega.setVerticalAlignment(SwingConstants.BOTTOM);
		labelCarrega.setForeground(new Color(255, 232, 225));
		labelCarrega.setHorizontalAlignment(SwingConstants.LEFT);
		botaoCarregar.add(labelCarrega,BorderLayout.CENTER);
		
		botaoAnalizar.addMouseListener(new MouseAdapter() {
			
			public boolean a,b;
			
			public void clickMenu(JPanel p1, JPanel p2, JPanel p3, int numberBool) {
				if(numberBool == 1) {
					p1.setBackground(new Color(0,45,59));
					p2.setBackground(new Color(0,15,19));
					p3.setBackground(new Color(0,15,19));
					
				}
				else {
					p1.setBackground(new Color(0,45,59));
					p2.setBackground(new Color(0,45,59));
					p3.setBackground(new Color(0,45,59));
				}}
			public void mudaCor(JPanel hover, Color rand) {
				hover.setBackground(rand);	
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				mudaCor(botaoAnalizar,new Color(0,30,39));
//				painelAux.setVisible(false);
				SwingUtilities.updateComponentTreeUI(frame);
//				painelXx.adicionar(areaTexto, areaLinha);
//				painelXx.setVisible(true);
//				a = true;
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(a == false) {
				mudaCor(botaoAnalizar,new Color(0,15,19));
				}
				SwingUtilities.updateComponentTreeUI(frame);
//				if(a == b) {
//					SwingUtilities.updateComponentTreeUI(frame);
//					painelXx.setVisible(true);
//					a = false;
//					b = false;
//				}else
//				{
//					SwingUtilities.updateComponentTreeUI(frame);
//					painelXx.setVisible(false);
//				}
					
						}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				painelAux3.adicionar(areaTexto, areaLinha);
				clickMenu(botaoAnalizar, botaoCarregar, botaoResultado, 1);
				a = true;
//				painelAux.setVisible(false);
//				SwingUtilities.updateComponentTreeUI(frame);
//				painelXx.adicionar(areaTexto, areaLinha);
//				painelXx.setVisible(true);
//				b = true;
				  
			}
		});
		botaoResultado.addMouseListener(new MouseAdapter() {
			
			
			private boolean a;
			public void clickMenu(JPanel p1, JPanel p2, JPanel p3, int numberBool) {
				if(numberBool == 1) {
					p1.setBackground(new Color(0,45,59));
					p2.setBackground(new Color(0,15,19));
					p3.setBackground(new Color(0,15,19));
					
				}
				else {
					p1.setBackground(new Color(0,45,59));
					p2.setBackground(new Color(0,45,59));
					p3.setBackground(new Color(0,45,59));
				}}
			public void mudaCor(JPanel hover, Color rand) {
				hover.setBackground(rand);	
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				if(a == true) {
				mudaCor(botaoResultado,new Color(0,15,19));
				SwingUtilities.updateComponentTreeUI(frame);
				}else {
					mudaCor(botaoResultado,new Color(0,45,59));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(a = false) {
				mudaCor(botaoResultado,new Color(0,45,59));
				SwingUtilities.updateComponentTreeUI(frame);
				a = true;
				}
			}
			@Override
			public void mouseClicked(MouseEvent e) {
					
					painelAux3.adicionarResultados();
					clickMenu(botaoResultado, botaoCarregar, botaoAnalizar, 1);
					SwingUtilities.updateComponentTreeUI(frame);
					a = true;
				
			}
			
		});
		
					
	}
}
