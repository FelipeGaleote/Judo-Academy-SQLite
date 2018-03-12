package br.com.dao;

import java.sql.*;
import javax.swing.JOptionPane;
/**
 * Classe responsável por administrar a conexao com o banco de dados
 * @author Felipe Fabri Galeote
 */
	public class ConnectionFactory {
		private static final String URL = "jdbc:sqlite:academia.db";
		private static final String DRIVER = "org.sqlite.JDBC";
		private static boolean hasData = true;
		private static Connection conn = null;
//Cria uma conexao com o banco de dados
		public static Connection startConnection() {
			try {
				Class.forName(DRIVER);
				conn = DriverManager.getConnection(URL);
				initialise(conn);
				return conn;
				} catch (Exception e) {
				throw new RuntimeException("Erro ao conectar", e);
			}
		}
//Verifica se o banco de dados ja existe, se não existir ele é criado.
		private static void initialise(Connection conn) throws SQLException {
			if (hasData) {
				hasData = false;
				Statement state = conn.createStatement();
				ResultSet rs = state.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='aluno'");
				if ( !rs.next()) {
					JOptionPane.showMessageDialog(null, "Criando o banco de dados!");
					Statement state2 = conn.createStatement();
					state2.execute("CREATE TABLE aluno (id integer primary key autoincrement not null ,"+
								"nome varchar(60) unique,"+"ano_nascimento int,"+
								"sexo char(1),"+"peso decimal(5,2),"+
								"classe varchar(10),"+"categoria varchar(40));");
					JOptionPane.showMessageDialog(null, "Banco de dados criado com sucesso!");
					
				}
			}
			
		}
		public static void closeConnection(Connection conn) {
			if(conn != null) {
				try {
					conn.close();
				} catch(SQLException e) {
					JOptionPane.showMessageDialog(null, "Erro ao fechar conexao 1");
				}
			}
		}
		public static void closeConnection(Connection conn, PreparedStatement pst) {
			closeConnection(conn);
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "Erro ao fechar conexao 2");
				}
			}	
		}
		public static void closeConnection(Connection conn, PreparedStatement pst, ResultSet rs) {
			closeConnection(conn,pst);
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "Erro ao fechar conexao 3");
				}
			}	
		}
			
	}
