package br.com.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.dao.AlunoDao;
import br.com.beans.Aluno;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
/**
 * Classe responsável por criar a tela para consultar um aluno
 * @author Felipe Fabri Galeote
 */
public class TelaParaConsultarAlunoPorNome extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaParaConsultarAlunoPorNome frame = new TelaParaConsultarAlunoPorNome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JTable table;
	/**
	 * Create the frame.
	 */
	public TelaParaConsultarAlunoPorNome() {
		setMinimumSize(new Dimension(600, 200));
		setResizable(false);
		setOpacity(1);
		setTitle("Consultar aluno");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 577, 259);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeDoAluno = new JLabel("Nome do aluno");
		lblNomeDoAluno.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lblNomeDoAluno.setBounds(25, 16, 126, 14);
		contentPane.add(lblNomeDoAluno);
		
		txtNome = new JTextField();
		txtNome.setBounds(161, 15, 131, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JButton btnConsultar = new JButton("Consultar aluno");
		btnConsultar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Aluno aluno = new Aluno();
					aluno.setNome(txtNome.getText());
					aluno = AlunoDao.consultarAluno(aluno);
					DefaultTableModel model = new DefaultTableModel();
					model.addColumn("Nome");
					model.addColumn("Peso");
					model.addColumn("Ano de nascimento");
					model.addColumn("Classe");
					model.addColumn("Categoria");
					model.addRow(new String[] { "  " + aluno.getNome(),  "     " + String.valueOf(aluno.getPeso()),"     " + String.valueOf(aluno.getAno()), "  " + aluno.getClasse(), "  " + aluno.getCategoria() });
					table.setModel(model);
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Nenhum aluno com esse nome foi encontrado!");
				}
			}
		});
		btnConsultar.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		btnConsultar.setBounds(326, 12, 174, 23);
		contentPane.add(btnConsultar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 62, 574, 158);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(SystemColor.control);
		table.setBounds(10, 59, 516, 161);
		scrollPane.setViewportView(table);
	}
}
