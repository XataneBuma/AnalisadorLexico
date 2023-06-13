package analisadorLexico;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AnalisadorLexico implements ActionListener {
	
	JFrame tela;
	JButton butao;
	JTextArea textIn, textOut;
	JMenuBar menu;
	
	public AnalisadorLexico() {
		textIn();
		textOut();
		butao();
		tela();
	} 
	
	public void tela() {
		tela = new JFrame();
		tela.setSize(500,600);
		tela.setLocationRelativeTo(null);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tela.add(textOut);
		
		tela.add(textIn);
		
//		tela.add(butao);
		
		
		tela.getContentPane().setBackground(Color.gray);
		
		tela.setVisible(true);
		
	}
	
	public void textIn() {
		textIn = new JTextArea(20,20);
		textIn.setBounds(0, 0, 200, 200);
		textIn.setLineWrap(true);
	}
	
	public void textOut() {
		textOut = new JTextArea();
		textOut.setBounds(5, 5, 2, 4);
		textOut.setBackground(Color.CYAN);
		textOut.setLineWrap(false);
		textOut.setEditable(true);
	   
	}
	
	
	public void butao() {
		butao = new JButton("ANALISAR");
		butao.setBackground(new Color(0,10,23));
		butao.setForeground(new Color(210,240,238));
	}

	public static void main(String[] args) {
		new AnalisadorLexico();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
