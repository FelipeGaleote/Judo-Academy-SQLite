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

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import java.awt.Scrollbar;
import java.awt.SystemColor;
import java.awt.ScrollPane;
/**
 * Classe responsável por criar a tela para consultar alunos por suas classes
 * @author Felipe Fabri Galeote
 */
public class TelaParaConsultarAlunosPorClasse extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaParaConsultarAlunosPorClasse frame = new TelaParaConsultarAlunosPorClasse();
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
	public TelaParaConsultarAlunosPorClasse() {
		setTitle("Tela de consulta por classes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 581, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboClasse = new JComboBox();
		comboClasse.setModel(new DefaultComboBoxModel(new String[] {"SUB 9", "SUB 11", "SUB 15", "SUB 18", "ADULTO"}));
		comboClasse.setBounds(312, 45, 67, 20);
		contentPane.add(comboClasse);
		
		JLabel lblNewLabel = new JLabel("Selecione a classe que deseja buscar");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lblNewLabel.setBounds(20, 39, 293, 29);
		contentPane.add(lblNewLabel);
		
		JButton btnListaAlunos = new JButton("Listar alunos");
		btnListaAlunos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnListaAlunos.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		btnListaAlunos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				DefaultTableModel model = new DefaultTableModel();
				model.addColumn("Nome");
				model.addColumn("Classe");
				model.addColumn("Categoria");
				String classe = (String) comboClasse.getSelectedItem();
				Aluno aluno = new Aluno();
				ArrayList<Aluno> listaAlunos = AlunoDao.consultarClasse(classe);
				for (int i = 0; i<listaAlunos.size(); i++) {
					aluno = listaAlunos.get(i);
					model.addRow(new String[] {aluno.getNome(), aluno.getClasse(), aluno.getCategoria()});
				}
				table.setModel(model);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,"Erro em TelaConsultaClasses: " + e.getMessage());
			}
		}
	});
		btnListaAlunos.setBounds(398, 40, 157, 26);
		contentPane.add(btnListaAlunos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 102, 545, 269);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBounds(20, 90, 535, 281);
		table.setBackground(SystemColor.control);
		table.setBounds(10, 59, 516, 161);
		scrollPane.setViewportView(table);
	}
}
