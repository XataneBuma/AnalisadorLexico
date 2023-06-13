package analisadorLexico.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PainelAnalises extends JPanel {

	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PainelAnalises(JFrame frame) {
		setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(this, BorderLayout.CENTER);
		setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);

	}
	

}
