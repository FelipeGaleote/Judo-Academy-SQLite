package br.com.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.dao.AlunoDao;
import br.com.beans.Aluno;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
/**
 * Classe responsável por criar a tela para excluir um aluno
 * @author Felipe Fabri Galeote
 */
public class TelaParaExcluirAluno extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaParaExcluirAluno frame = new TelaParaExcluirAluno();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public TelaParaExcluirAluno() {
		setResizable(false);
		setTitle("Deletar aluno");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeDoAluno = new JLabel("Nome completo do aluno");
		lblNomeDoAluno.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNomeDoAluno.setBounds(118, 44, 220, 25);
		contentPane.add(lblNomeDoAluno);
		
		txtNome = new JTextField();
		txtNome.setBounds(136, 93, 159, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JButton btnDeletarAluno = new JButton("Deletar aluno");
		btnDeletarAluno.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDeletarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Aluno aluno = new Aluno();
				aluno.setNome(txtNome.getText());
				AlunoDao.excluirAluno(aluno);
				JOptionPane.showMessageDialog(null, "Aluno excluido com sucesso!");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Falha ao excluir aluno");
				}
			}
		});
		btnDeletarAluno.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		btnDeletarAluno.setBounds(136, 142, 159, 41);
		contentPane.add(btnDeletarAluno);
	}

}
