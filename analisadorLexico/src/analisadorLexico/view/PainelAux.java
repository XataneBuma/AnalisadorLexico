package analisadorLexico.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import analisadorLexico.Token;

import javax.swing.UIManager;

public class PainelAux extends JPanel {

	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel tabelaModelo;
	public JTable tabela;

	/**
	 * Create the panel.
	 */
	public PainelAux(JFrame frame) {
			setBackground(new Color(255, 255, 255));
			frame.getContentPane().add(this, BorderLayout.EAST);
			
			setLayout(new BorderLayout(0, 0));
			
			scrollPane = new JScrollPane();
			scrollPane.setViewportBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));
			add(scrollPane, BorderLayout.CENTER);		
	}
	public void tabela(ArrayList<Token> tokens) {
		tabelaModelo.setRowCount(0);
		for (Token token : tokens) {
			tabelaModelo.addRow(new String[] {token.getSymbol().toString(), token.getLexeme(), Integer.toString(token.getLineNumber())});
		}
	}
	
	public void adicionarTabela(JTable table) {
		tabelaModelo = new DefaultTableModel(new String[] {"Tipo", "Token", "Linha"},0 );
		table = new JTable(tabelaModelo) {public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
			Component returnComp = super.prepareRenderer(renderer, row, column);
			Color alternateColor = new Color(10,16,23);
			Color whiteColor = Color.WHITE;
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
			scrollPane.setViewportView(table);
			scrollPane.setMinimumSize(getMinimumSize());
		
	}
	
	
	

}
