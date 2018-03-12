package br.com.beans;
/**
 * Classe responsável por  representar um aluno e definir sua classe e categoria
 * @author Felipe Fabri Galeote
 */
public class Aluno {
	private String classe;
	private String categoria;
	private String nome;
	private int ano;
	private char sexo;
	private double peso;
	private String nomeAntigo;
	
	public String getNomeAntigo() {
		return nomeAntigo;
	}

	public void setNomeAntigo(String nomeAntigo) {
		this.nomeAntigo = nomeAntigo;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public Aluno(){
		
	}
	/** 
	 * Metodo que define a 'classe' do aluno, tambem a retorna como uma string. 
	 * @param ano ano de nascimento
	 * @return classe
	 */
	public String definirClasse(int ano) {
			if(ano<=2000) {
				classe = "ADULTO";
			} else if(ano<=2003) {
				classe = "SUB 18";
			} else if(ano<=2005) {
				classe = "SUB 15";
			} else if(ano<=2007) {
				classe = "SUB 13";
			} else if(ano<=2009) {
				classe = "SUB 11";
			} else if(ano<=2011) {
				classe = "SUB 9";
			} 
			this.setClasse(classe);
			return classe;
	}
	/**
	 * Metodo que define a categoria do aluno, tambem a retorna como uma string.
	 * @param classe classe que o aluno foi classificado
	 * @param sexo sexo do aluno
	 * @param peso peso atual do aluno
	 * @return categoria
	 */
	public String definirCategoria(String classe, char sexo, double peso) {
		if(sexo == 'M') {
			if(classe.equals("SUB 9")) {
				if(peso<=23) {
					categoria = "S.LIGEIRO";
				} else if(peso<=26) {
					categoria = "LIGEIRO";
				} else if(peso<=29) {
					categoria = "M.LEVE";
				} else if(peso<=32) {
					categoria = "LEVE";
				} else if(peso<=36) {
					categoria = "M.MÉDIO";
				} else if(peso<=40) {
					categoria = "MÉDIO";
				} else if(peso<=45) {
					categoria = "M.PESADO";
				} else if(peso<=50) {
					categoria = "PESADO";
				} else {
					categoria = "S.PESADO";
				}
			} else if(classe.equals("SUB 11")){
				if(peso<=28) {
					categoria = "S.LIGEIRO";
				} else if(peso<=30) {
					categoria = "LIGEIRO";
				} else if(peso<=33) {
					categoria = "M.LEVE";
				} else if(peso<=36) {
					categoria = "LEVE";
				} else if(peso<=40) {
					categoria = "M.MÉDIO";
				} else if(peso<=45) {
					categoria = "MÉDIO";
				} else if(peso<=50) {
					categoria = "M.PESADO";
				} else if(peso<=55) {
					categoria = "PESADO";
				} else if(peso<=60){
					categoria = "S.PESADO";
				} else {
					categoria = "E.PESADO";
				}
			} else if(classe.equals("SUB 13")){
				if(peso<=28) {
					categoria = "S.LIGEIRO";
				} else if(peso<=31) {
					categoria = "LIGEIRO";
				} else if(peso<=34) {
					categoria = "M.LEVE";
				} else if(peso<=38) {
					categoria = "LEVE";
				} else if(peso<=42) {
					categoria = "M.MÉDIO";
				} else if(peso<=47) {
					categoria = "MÉDIO";
				} else if(peso<=52) {
					categoria = "M.PESADO";
				} else {
					categoria = "PESADO";
				}
			} else if(classe.equals("SUB 15")){
				if(peso<=36) {
					categoria = "S.LIGEIRO";
				} else if(peso<=40) {
					categoria = "LIGEIRO";
				} else if(peso<=44) {
					categoria = "M.LEVE";
				} else if(peso<=48) {
					categoria = "LEVE";
				} else if(peso<=53) {
					categoria = "M.MÉDIO";
				} else if(peso<=58) {
					categoria = "MÉDIO";
				} else if(peso<=64) {
					categoria = "M.PESADO";
				} else {
					categoria = "PESADO";
				}
			} else if(classe.equals("SUB 18")){
				if(peso<=50) {
					categoria = "S.LIGEIRO";
				} else if(peso<=55) {
					categoria = "LIGEIRO";
				} else if(peso<=60) {
					categoria = "M.LEVE";
				} else if(peso<=66) {
					categoria = "LEVE";
				} else if(peso<=73) {
					categoria = "M.MÉDIO";
				} else if(peso<=81) {
					categoria = "MÉDIO";
				} else if(peso<=90) {
					categoria = "M.PESADO";
				} else {
					categoria = "PESADO";
				}
			} else if(classe.equals("ADULTO")){
				if(peso<=55) {
					categoria = "S.LIGEIRO";
				} else if(peso<=60) {
					categoria = "LIGEIRO";
				} else if(peso<=66) {
					categoria = "M.LEVE";
				} else if(peso<=73) {
					categoria = "LEVE";
				} else if(peso<=81) {
					categoria = "M.MÉDIO";
				} else if(peso<=90) {
					categoria = "MÉDIO";
				} else if(peso<=100) {
					categoria = "M.PESADO";
				} else {
					categoria = "PESADO";
				}
			}
		} else if (sexo == 'F') {
			if(classe.equals("SUB 9")){
				if(peso<=23) {
					categoria = "S.LIGEIRO";
				} else if(peso<=26) {
					categoria = "LIGEIRO";
				} else if(peso<=29) {
					categoria = "M.LEVE";
				} else if(peso<=32) {
					categoria = "LEVE";
				} else if(peso<=36) {
					categoria = "M.MÉDIO";
				} else if(peso<=40) {
					categoria = "MÉDIO";
				} else if(peso<=45) {
					categoria = "M.PESADO";
				} else if(peso<=50) {
					categoria = "PESADO";
				} else{
					categoria = "S.PESADO";
				} 
			} else if(classe.equals("SUB 11")){
				if(peso<=28) {
					categoria = "S.LIGEIRO";
				} else if(peso<=30) {
					categoria = "LIGEIRO";
				} else if(peso<=33) {
					categoria = "M.LEVE";
				} else if(peso<=36) {
					categoria = "LEVE";
				} else if(peso<=40) {
					categoria = "M.MÉDIO";
				} else if(peso<=45) {
					categoria = "MÉDIO";
				} else if(peso<=50) {
					categoria = "M.PESADO";
				} else if(peso<=55) {
					categoria = "PESADO";
				} else{
					categoria = "S.PESADO";
				}
			}else if(classe.equals("SUB 13")){
				if(peso<=28) {
					categoria = "S.LIGEIRO";
				} else if(peso<=31) {
					categoria = "LIGEIRO";
				} else if(peso<=34) {
					categoria = "M.LEVE";
				} else if(peso<=38) {
					categoria = "LEVE";
				} else if(peso<=42) {
					categoria = "M.MÉDIO";
				} else if(peso<=47) {
					categoria = "MÉDIO";
				} else if(peso<=52) {
					categoria = "M.PESADO";
				} else {
					categoria = "PESADO";
				} 	
			} else if(classe.equals("SUB 15")){
				if(peso<=36) {
					categoria = "S.LIGEIRO";
				} else if(peso<=40) {
					categoria = "LIGEIRO";
				} else if(peso<=44) {
					categoria = "M.LEVE";
				} else if(peso<=48) {
					categoria = "LEVE";
				} else if(peso<=53) {
					categoria = "M.MÉDIO";
				} else if(peso<=58) {
					categoria = "MÉDIO";
				} else if(peso<=64) {
					categoria = "M.PESADO";
				} else {
					categoria = "PESADO";
				} 	
			} else if(classe.equals("SUB 18")){
				if(peso<=40) {
					categoria = "S.LIGEIRO";
				} else if(peso<=44) {
					categoria = "LIGEIRO";
				} else if(peso<=48) {
					categoria = "M.LEVE";
				} else if(peso<=52) {
					categoria = "LEVE";
				} else if(peso<=57) {
					categoria = "M.MÉDIO";
				} else if(peso<=63) {
					categoria = "MÉDIO";
				} else if(peso<=70) {
					categoria = "M.PESADO";
				} else {
					categoria = "PESADO";
				} 	
			} else if(classe.equals("ADULTO")){
				if(peso<=44) {
					categoria = "S.LIGEIRO";
				} else if(peso<=48) {
					categoria = "LIGEIRO";
				} else if(peso<=52) {
					categoria = "M.LEVE";
				} else if(peso<=57) {
					categoria = "LEVE";
				} else if(peso<=63) {
					categoria = "M.MÉDIO";
				} else if(peso<=70) {
					categoria = "MÉDIO";
				} else if(peso<=78) {
					categoria = "M.PESADO";
				} else {
					categoria = "PESADO";
				} 	
			}
		}
		this.setCategoria(categoria);
		return categoria;
	}
	
}