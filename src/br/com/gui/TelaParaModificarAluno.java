package br.com.gui;



import java.awt.BorderLayout;
import java.awt.EventQueue;
import br.com.dao.AlunoDao;
import br.com.beans.Aluno;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
/**
 * Classe responsável por criar a tela para atualizar aluno
 * @author Felipe Fabri Galeote
 */
public class TelaParaModificarAluno extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeConsulta;
	private JTextField txtPeso;
	private JTextField txtAno;
	private JTextField txtNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaParaModificarAluno frame = new TelaParaModificarAluno();
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
	private JTextField txtSexo;
	private JTextField txtNomeAntigo;
	public TelaParaModificarAluno() {
		setResizable(false);
		setTitle("Atualizar dados do aluno");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtSexo = new JTextField();
		
		JLabel lblNomeDoAluno = new JLabel("Nome do aluno");
		lblNomeDoAluno.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lblNomeDoAluno.setBounds(10, 21, 128, 14);
		contentPane.add(lblNomeDoAluno);
		
		txtNomeConsulta = new JTextField();
		txtNomeConsulta.setBounds(137, 20, 161, 20);
		contentPane.add(txtNomeConsulta);
		txtNomeConsulta.setColumns(10);
		
		JRadioButton rdbtnModificarPeso = new JRadioButton("Modificar peso");
		rdbtnModificarPeso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPeso.setEditable(true);
			}
		});
		rdbtnModificarPeso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnModificarPeso.setBounds(6, 65, 109, 23);
		contentPane.add(rdbtnModificarPeso);
		
		JRadioButton rdbtnModificarAnoDe = new JRadioButton("Modificar ano de nascimento");
		rdbtnModificarAnoDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtAno.setEditable(true);
			}
		});
		rdbtnModificarAnoDe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnModificarAnoDe.setBounds(117, 65, 181, 23);
		contentPane.add(rdbtnModificarAnoDe);
		
		JRadioButton rdbtnModificarNome = new JRadioButton("Modificar nome");
		rdbtnModificarNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setEditable(true);
			}
		});
		rdbtnModificarNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnModificarNome.setBounds(314, 65, 120, 23);
		contentPane.add(rdbtnModificarNome);
		
		JButton btnSalvarAlteracoes = new JButton("Salvar altera\u00E7\u00F5es");
		btnSalvarAlteracoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

				Aluno aluno = new Aluno();
				aluno.setAno(Integer.parseInt(txtAno.getText()));
				aluno.setSexo(txtSexo.getText().charAt(0));
				aluno.setPeso(Double.parseDouble(txtPeso.getText()));
				aluno.setClasse(aluno.definirClasse(aluno.getAno()));
				aluno.setCategoria(aluno.definirCategoria(aluno.getClasse(), aluno.getSexo(), aluno.getPeso()));
				aluno.setNome(txtNome.getText());
				aluno.setNomeAntigo(txtNomeAntigo.getText());
				AlunoDao.atualizarAluno(aluno);
				JOptionPane.showMessageDialog(null, "Dados do aluno atualizados");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Falha ao modificar aluno!");
				}
			}
		});
		btnSalvarAlteracoes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalvarAlteracoes.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		btnSalvarAlteracoes.setBounds(127, 180, 181, 36);
		contentPane.add(btnSalvarAlteracoes);
		
		txtPeso = new JTextField();
		txtPeso.setEditable(false);
		txtPeso.setBounds(28, 116, 66, 20);
		contentPane.add(txtPeso);
		txtPeso.setColumns(10);
		
		txtAno = new JTextField();
		txtAno.setEditable(false);
		txtAno.setBounds(171, 116, 86, 20);
		contentPane.add(txtAno);
		txtAno.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setEditable(false);
		txtNome.setBounds(315, 116, 109, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nome = txtNomeConsulta.getText();
					Aluno aluno = AlunoDao.prepararAluno(nome);
				
					double peso = aluno.getPeso();
					txtPeso.setText(String.valueOf(peso));
					int ano = aluno.getAno();
					txtAno.setText(String.valueOf(ano));
					nome = aluno.getNome();
					txtNome.setText(nome);
					txtNomeAntigo.setText(nome);
					String sexo = Character.toString(aluno.getSexo());
					txtSexo.setText(sexo);
					}
				 catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro tela atualizar:" + e1.getMessage());
				}
			}
		});
		btnSelecionar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSelecionar.setBounds(308, 19, 118, 23);
		contentPane.add(btnSelecionar);
		
		txtSexo.setVisible(false);
		txtSexo.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtSexo.setEditable(false);
		txtSexo.setBounds(28, 241, 86, 20);
		contentPane.add(txtSexo);
		txtSexo.setColumns(10);
		
		txtNomeAntigo = new JTextField();
		txtNomeAntigo.setVisible(false);
		txtNomeAntigo.setEnabled(false);
		txtNomeAntigo.setEditable(false);
		txtNomeAntigo.setBounds(171, 241, 86, 20);
		contentPane.add(txtNomeAntigo);
		txtNomeAntigo.setColumns(10);
	}
}
