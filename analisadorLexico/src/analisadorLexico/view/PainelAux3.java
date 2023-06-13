package analisadorLexico.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import analisadorLexico.Lexer;
import analisadorLexico.Token;

import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PainelAux3 extends JPanel{

	private Container layeredPane;
	private JPanel painelTabela;
	private JPanel painelResultados;
	private JPanel painelEditor;
	private painelEditor peditor;
	private JScrollPane scrollPane, scrollPane_tabela, scrollPane_resultados;
	private DefaultTableModel tabelaModelo;
	private PainelAux2 painelAux2;
	private Lexer lexer;
	private JPanel painelGif;
	private TelaPrincipal telaPrincipal;
	

	/**
	 * Create the panel.
	 */

	public PainelAux3(JFrame frame) {
		
		tabelaModelo = new DefaultTableModel(new String[] {"Tipo", "Token", "Linha"},4 );
		setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(this, BorderLayout.CENTER);
		setLayout(new BorderLayout(0, 0));
		
		this.lexer= new Lexer();
		
		this.layeredPane = new JLayeredPane();
		
		add(layeredPane, BorderLayout.CENTER);
		
		painelResultados = new JPanel();
		
		painelTabela = new JPanel();
		painelGif = new JPanel();
		painelGif.setLayout(new BorderLayout(0,0));
		
		JLabel iconGif = new JLabel();
//		iconGif.setIcon(new ImageIcon("C:\\Users\\Matavele\\eclipse-workspace\\analisadorLexico\\src\\dlle.png"));
		painelGif.add(iconGif,BorderLayout.CENTER);
		
		
	
		painelEditor = new JPanel();
		painelEditor.setLayout(new BorderLayout(0, 0));
		
//		JLabel lblNewLabel = new JLabel("Editor");
//		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
//		painelEditor.add(lblNewLabel);
		 
		painelTabela.setLayout(new BorderLayout(0, 0));
		
		scrollPane_tabela = new JScrollPane();
		painelResultados.add(scrollPane_tabela, BorderLayout.CENTER);
		
		scrollPane = new JScrollPane();
		painelTabela.add(scrollPane, BorderLayout.CENTER);
		
		painelResultados.setLayout(new BorderLayout(0, 0));
		layeredPane.setLayout(new CardLayout(0, 0));
		
		layeredPane.add(painelTabela, "name_244064902328600");
		layeredPane.add(painelResultados, "name_244064929257400");
		layeredPane.add(painelEditor, "name_244064956112900");
		layeredPane.add(painelGif,"name_3242423221231242314");
		

	}


	public void adicionar(JTextArea areaTexto,JTextArea areaLinha) {
		
		areaTexto.setLineWrap(true);
		areaTexto.setTabSize(3);
	
		areaLinha.setBackground(new Color(170, 185, 189));
		areaLinha.setEditable(false);
	
		areaTexto.getDocument().addDocumentListener(new DocumentListener() {

		@Override
		public void insertUpdate(DocumentEvent e) {
			atualizarLinhas();
			
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			atualizarLinhas();
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			atualizarLinhas();
			
		}
		private void atualizarLinhas() {
            int totalLines = areaTexto.getLineCount();
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= totalLines; i++) {
                sb.append(i).append("\n");
            }
            areaLinha.setText(sb.toString());
            areaTexto.setCaretColor(Color.BLACK);
	}});
	scrollPane.setViewportView(areaTexto);
	scrollPane.setRowHeaderView(areaLinha);
	
	layeredPane.removeAll();
	layeredPane.add(painelTabela);
	layeredPane.repaint();
	layeredPane.revalidate();
}

	public void tabela(ArrayList<Token> tokens) {
		tabelaModelo.setRowCount(0);
		for (Token token : tokens) {
			tabelaModelo.addRow(new String[] {token.getSymbol().toString(), token.getLexeme(), Integer.toString(token.getLineNumber())});
		}
	}
	
	public void adicionarTabela(JTable table) {
		
		table = new JTable(tabelaModelo) {/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

		public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
			Component returnComp = super.prepareRenderer(renderer, row, column);
			Color alternateColor = new Color(0,15,19);
			Color whiteColor = new Color(0,30,39);
			if (!returnComp.getBackground().equals(getSelectionBackground())) {
				Color bg = (row % 2 == 0 ? alternateColor : whiteColor);
				returnComp.setBackground(bg);
				bg = null;
				
			}
			return  returnComp;
		}};
//		table.setModel(new DefaultTableModel(new Object[][] {},new String[] {"no. Linha", "Token", "erro"}) {
//				private static final long serialVersionUID = 1L;
//				boolean[] columnEditables = new boolean[] {true, true, true};
//				public boolean isCellEditable(int row, int column) {
//					return columnEditables[column];
//				}
//				
//			});
			
			table.getColumnModel().getColumn(2).setResizable(false);		
			table.setFillsViewportHeight(true);
			
		
			scrollPane_tabela.setViewportView(table);
			
			scrollPane_tabela.setMinimumSize(getMinimumSize());
			
			table.setBackground(new Color(0,30,39));
			table.setForeground(new Color(170,185,189));
			
			
			
			layeredPane.removeAll();
			layeredPane.add(scrollPane_tabela);
			layeredPane.repaint();
			layeredPane.revalidate();
		
	}
	
	public void adicionarResultados() {
		layeredPane.removeAll();
		layeredPane.add(painelEditor);
		layeredPane.repaint();
		layeredPane.revalidate();
		
		painelEditor.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(157, 150, 127));
		panel_1.setPreferredSize(new Dimension(150, 10));
		painelEditor.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("ANALISIS STATUS");
		lblNewLabel.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 30, 39));
		panel_2.setPreferredSize(new Dimension(100, 100));
		painelEditor.add(panel_2, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 45, 59));
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(new Color(0, 45, 59));
		
		JPanel panel_3_2 = new JPanel();
		panel_3_2.setBackground(new Color(0, 45, 59));
		
		JPanel panel_3_3 = new JPanel();
		panel_3_3.setBackground(new Color(0, 45, 59));
		
		JPanel panel_3_4 = new JPanel();
		
		JPanel panel_3_5 = new JPanel();
		
		JPanel panel_3_6 = new JPanel();
		
		JPanel panel_3_7 = new JPanel();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(panel_3_4, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(panel_3_1, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(panel_3_5, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(panel_3_2, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(panel_3_6, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(panel_3_3, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(panel_3_7, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(106, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_3_4, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_3_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_3_5, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_3_2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_3_6, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_3_7, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_3_3, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(170, Short.MAX_VALUE))
		);
		
		telaPrincipal = new TelaPrincipal();
		JLabel lblNewLabel_8 = new JLabel(""+telaPrincipal.tempoEstimado);
		lblNewLabel_8.setFont(new Font("Lucida Console", Font.PLAIN, 11));
		panel_3_7.add(lblNewLabel_8);
		
		JLabel lblNewLabel_7 = new JLabel(""+lexer.totalErros);
		lblNewLabel_7.setFont(new Font("Lucida Console", Font.PLAIN, 11));
		panel_3_6.add(lblNewLabel_7);
		
		JLabel lblNewLabel_6 = new JLabel(""+Lexer.totalChars);
		lblNewLabel_6.setFont(new Font("Lucida Console", Font.PLAIN, 11));
		panel_3_5.add(lblNewLabel_6);
		
		JLabel lblNewLabel_5 = new JLabel(""+lexer.totalTokens);
		lblNewLabel_5.setFont(new Font("Lucida Console", Font.PLAIN, 11));
		panel_3_4.add(lblNewLabel_5);
		panel_3_3.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("Tempo de Execução");
		lblNewLabel_4.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(new Color(189, 201, 204));
		panel_3_3.add(lblNewLabel_4, BorderLayout.CENTER);
		panel_3_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("Erros");
		lblNewLabel_3.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(new Color(189, 201, 204));
		panel_3_2.add(lblNewLabel_3, BorderLayout.CENTER);
		panel_3_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("Total Lexemas");
		lblNewLabel_2.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(189, 201, 204));
		panel_3_1.add(lblNewLabel_2, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Total Tokens");
		lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(189, 201, 204));
		panel_3.add(lblNewLabel_1, BorderLayout.CENTER);
		panel_2.setLayout(gl_panel_2);
		
		
		
		
		
	}
	
	public void adicionarEspera() {
		layeredPane.removeAll();
		layeredPane.add(painelGif);
		layeredPane.repaint();
		layeredPane.revalidate();
			
	}
	
	
		

}
