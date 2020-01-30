package br.com.edsoft.core;

import java.sql.*;
import javax.swing.JOptionPane;

public class ConexaoDB {

	public Statement stm; // responsavel pela pesquisa
	public ResultSet rs; // vai armazenar o resultado da pesquisa
	private final String driver = "org.postgresql.Driver"; // identifica��o do servi�o
	// private String caminho = "jdbc:postgresql://10.70.132.45/projetomonitoria";
//    private final String caminho = "jdbc:postgresql://nsaodt5nxtfm2/projetomonitoria";
	private String caminho = "jdbc:postgresql://localhost:5432/projetomonitoria";
	private final String usuario = "postgres";
	private final String senha = "eduhit00";
	public static Connection con;

	public Connection conexao() { // metodo de conexao
		try {
			System.setProperty("jdbc.Drivers", driver); // setar a propriedade do driver
			con = DriverManager.getConnection(caminho, usuario, senha);
			// JOptionPane.showMessageDialog(null, "Conex�o efetuada com sucesso");//
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro de conex�o:\n" + ex.getMessage());
		}
		return con;
	}

	public void executaSql(String sql) {
		try {
			stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY); // verifica��o de
																								// caracter
			rs = stm.executeQuery(sql);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao executar SQL:\n" + ex.getMessage());
		}
	}

	/*
	 * public void desconecta(){ try { // JOptionPane.showMessageDialog(null,
	 * "Desconex�o com sucesso"); con.close(); } catch (SQLException ex) {
	 * JOptionPane.showMessageDialog(null,
	 * "Erro ao fecha a Desconex�o  com banco:\n"+ex.getMessage()); } }
	 */
}
