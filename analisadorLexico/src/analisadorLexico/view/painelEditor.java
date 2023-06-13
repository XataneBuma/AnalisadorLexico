package analisadorLexico.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class painelEditor extends JPanel {

	private JScrollPane scrollPane;

	/**
	 * Create the panel.
	 */
	public painelEditor(JFrame frame) {
		setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(this, BorderLayout.WEST);
		setLayout(new BorderLayout(0, 0));
		
		 scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		scrollPane.setBounds(20, 1, 10,500);
		scrollPane.setBackground(Color.BLUE);

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
	}

}
