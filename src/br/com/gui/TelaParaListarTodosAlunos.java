package br.com.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.dao.AlunoDao;
import br.com.beans.Aluno;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Cursor;
/**
 * Classe responsável por criar a tela para listar todos os alunos
 * @author Felipe Fabri Galeote
 */
public class TelaParaListarTodosAlunos extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaParaListarTodosAlunos frame = new TelaParaListarTodosAlunos();
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
	public TelaParaListarTodosAlunos() {
		setResizable(false);
		setTitle("Consultar lista de alunos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 539, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnConsultarLista = new JButton("Consultar lista de alunos");
		btnConsultarLista.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConsultarLista.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnConsultarLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
						DefaultTableModel model = new DefaultTableModel();
						Aluno aluno = new Aluno();
						model.addColumn("Nome");
						model.addColumn("Classe");
						model.addColumn("Categoria");
						ArrayList<Aluno> listaAlunos = AlunoDao.consultarTodosAlunos();
						for(int i = 0; i<listaAlunos.size(); i++) {
							aluno = listaAlunos.get(i);
							model.addRow(new String[] {aluno.getNome(), aluno.getClasse(), aluno.getCategoria()});
						}
						table.setModel(model);
						}catch(SQLException a) {
							JOptionPane.showMessageDialog(null, "Erro na hora de consultar todos alunos");
					}
			}
			});
		btnConsultarLista.setBounds(135, 11, 251, 40);
		contentPane.add(btnConsultarLista);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 62, 533, 322);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}