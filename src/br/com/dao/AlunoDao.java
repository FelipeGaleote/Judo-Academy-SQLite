package br.com.dao;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;

	import javax.swing.JOptionPane;

	import br.com.beans.Aluno;
	/**
	 * Classe responsável por realizar as interacoes entre a classe aluno e o banco de dados
	 * @author Felipe Fabri Galeote
	 */
	public class AlunoDao {
		static Statement statement = null;
		static Connection conn = null;
		static PreparedStatement pst = null;
		static ResultSet rs = null;
		
		public static Aluno prepararAluno(String nome) throws Exception{
				Aluno aluno = new Aluno();
				try {
				conn = ConnectionFactory.startConnection();
				String sql = "SELECT * FROM aluno WHERE nome like '" + nome + "%'";
				pst = conn.prepareStatement(sql);
				rs = pst.executeQuery();
					if(rs.next()) {
						aluno.setPeso(rs.getDouble("peso"));
						aluno.setAno(rs.getInt("ano_nascimento"));
						String nome1 = rs.getString("nome");
						aluno.setNome(nome1);
						aluno.setNomeAntigo(nome1);
						aluno.setSexo(rs.getString("sexo").charAt(0));
					}
				}
				catch (Exception a) {
					throw new Exception();}
				finally {
					ConnectionFactory.closeConnection(conn, pst, rs);
				}
				return aluno; 
		}
		
		
		public static void atualizarAluno(Aluno aluno) throws Exception {
			try {
			conn = ConnectionFactory.startConnection();
			String sql = "UPDATE aluno SET nome='" + aluno.getNome() + "',peso=" + aluno.getPeso() + ",ano_nascimento=" + aluno.getAno() + ",classe='" + aluno.getClasse() + "',categoria='"+ aluno.getCategoria() + "' WHERE nome like '"+ aluno.getNomeAntigo() + "%';" ;
			pst = conn.prepareStatement(sql);
			pst.executeUpdate();
			}
			catch (Exception a) {a.printStackTrace();
			} finally {
				ConnectionFactory.closeConnection(conn, pst);
			}

		}
		
		public static void cadastrarAluno(Aluno aluno) throws SQLException {
			try {
			conn = ConnectionFactory.startConnection();
			String classe = aluno.definirClasse(aluno.getAno());
			String categoria = aluno.definirCategoria(aluno.getClasse(), aluno.getSexo(), aluno.getPeso());
			String nome = aluno.getNome();
			int ano = aluno.getAno();
			char sexo = aluno.getSexo();
			double peso = aluno.getPeso();

			String sql = "INSERT INTO aluno(nome,ano_nascimento,sexo,peso,classe,categoria) values('" + nome + "'," + ano + ",'" + sexo + "'," + peso + ",'"+ classe + "','" + categoria +"');" ;
			pst = conn.prepareStatement(sql);
			pst.executeUpdate();
			}
			catch(Exception x) {
				JOptionPane.showMessageDialog(null, "Erro na hora de inserir(cadastrarAluno");
			}finally {
				ConnectionFactory.closeConnection(conn, pst);
			}

		}
		public static Aluno consultarAluno(Aluno aluno) throws SQLException {
			try {
			conn = ConnectionFactory.startConnection();
			String sql = "SELECT nome, ano_nascimento,peso, classe, categoria FROM aluno WHERE nome like '" + aluno.getNome() + "%'";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			if(rs.next())
			aluno.setNome(rs.getString("nome"));
			aluno.setAno(rs.getInt("ano_nascimento"));
			aluno.setPeso(rs.getDouble("peso"));
			aluno.setClasse(rs.getString("classe"));
			aluno.setCategoria(rs.getString("categoria"));}
			catch(Exception x) {
				throw new SQLException();
			}finally {
				ConnectionFactory.closeConnection(conn, pst,rs);
			}
			return aluno;
		}
		public static ArrayList<Aluno> consultarClasse(String classe) {
			ArrayList<Aluno> listaAlunos= new ArrayList<Aluno>();
			try {
			conn = ConnectionFactory.startConnection();
			String sql = "SELECT nome, classe,categoria FROM aluno WHERE classe='" + classe + "';";
			pst = conn.prepareStatement(sql);
			rs =  pst.executeQuery();
			while(rs.next()) {
				Aluno aluno = new Aluno();
				aluno.setNome(rs.getString("nome"));
				aluno.setClasse(rs.getString("classe"));
				aluno.setCategoria(rs.getString("categoria"));
				listaAlunos.add(aluno);
			}
			}
			catch(Exception x) {
				JOptionPane.showMessageDialog(null, "Erro na hora de consultar alunos por classe");
			}finally {
				ConnectionFactory.closeConnection(conn, pst,rs);
			}
			return listaAlunos;
		}
		
		public static void excluirAluno(Aluno aluno) throws SQLException{
			try {
			conn = ConnectionFactory.startConnection();
			String nome = aluno.getNome();
			String sql = "SELECT nome FROM aluno WHERE nome LIKE'"+ nome + "';";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			if(!rs.next()) {
				throw new SQLException();
			}
			ConnectionFactory.closeConnection(conn, pst,rs);
			conn = ConnectionFactory.startConnection();
			sql = "DELETE FROM aluno WHERE nome= '"+ nome +"';";
			pst = conn.prepareStatement(sql);
			pst.executeUpdate();}
			catch(SQLException a) {
				throw new SQLException("Nome invalido!");
			}finally {
				ConnectionFactory.closeConnection(conn, pst);
			}
		}
		//Esta funcao foi implementada diretamente na classe TelaListaAlunos
		public static ArrayList<Aluno> consultarTodosAlunos() throws SQLException {
			ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();
			try {
			conn = ConnectionFactory.startConnection();
			String sql = "SELECT nome, classe, categoria FROM aluno";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				Aluno aluno = new Aluno();
				aluno.setNome(rs.getString("nome"));
				aluno.setClasse(rs.getString("classe"));
				aluno.setCategoria(rs.getString("categoria"));
				listaAlunos.add(aluno);
			}
			}catch(SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro na hora de consultar todos alunos");
			}finally {
				ConnectionFactory.closeConnection(conn, pst, rs);
			}
			return listaAlunos;
			}
	}

