package analisadorLexico.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

public class PainelAux2 extends JPanel {

	private JScrollPane scrollPane;

	/**
	 * Create the panel.
	 */
	public PainelAux2(JFrame frame) {
		setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(this, BorderLayout.LINE_START);
		setLayout(new BorderLayout(0, 0));
		
		 scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		scrollPane.setBounds(20, 1, 10,500);
		scrollPane.setBackground(Color.BLUE);
		
		JPanel panel = new JPanel();
		
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(157, 150, 127));
		panel_1.setPreferredSize(new Dimension(150, 10));
		panel.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("ANALISIS STATUS");
		lblNewLabel.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 30, 39));
		panel_2.setPreferredSize(new Dimension(100, 100));
		panel.add(panel_2, BorderLayout.CENTER);
		
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
		
		JLabel lblNewLabel_8 = new JLabel("tempo");
		lblNewLabel_8.setFont(new Font("Lucida Console", Font.PLAIN, 11));
		panel_3_7.add(lblNewLabel_8);
		
		JLabel lblNewLabel_7 = new JLabel("erro\r\n");
		lblNewLabel_7.setFont(new Font("Lucida Console", Font.PLAIN, 11));
		panel_3_6.add(lblNewLabel_7);
		
		JLabel lblNewLabel_6 = new JLabel("lexema");
		lblNewLabel_6.setFont(new Font("Lucida Console", Font.PLAIN, 11));
		panel_3_5.add(lblNewLabel_6);
		
		JLabel lblNewLabel_5 = new JLabel("token\r\n");
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
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Matavele\\Downloads\\icons8-inspect-code-44.png"));
		lblNewLabel_3.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
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
		scrollPane.setViewportView(panel);

	}
}
