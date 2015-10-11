package br.senai.ti2014n1.sc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.senai.ti2014n1.sc.dominio.Medicamento;

public class MedicamentoDao extends Dao {

	private final String INSERT = "INSERT INTO medicamentos (nome, dosagem, intervalo, duracao) values (?, ?, ?, ?)";
	private final String UPDATE = "UPDATE medicamentos SET nome=?, dosagem=?, intervalo=?, duracao=? WHERE id=?";
	private final String DELETE = "DELETE FROM medicamentos WHERE id=?";
	private final String SELECT = "SELECT * FROM medicamentos";
	private final String SELECT_ID = "SELECT * FROM medicamentos WHERE id=?";

	public void salvar(Medicamento medicamento) throws Exception {
		if (medicamento.getId() == 0) {
			inserir(medicamento);
		} else {
					alterar(medicamento);
		}
	}
		
	public List<Medicamento> listarTodos(){
		List<Medicamento> medicamentos = new ArrayList<Medicamento>();
		try {
			PreparedStatement ps = getConnection().prepareStatement(SELECT);
			ResultSet rs = ps.executeQuery();
		while (rs.next()){
			Medicamento medicamento = new Medicamento();
				medicamento.setNome(rs.getString("nome"));
				medicamento.setDosagem(rs.getString("dosagem"));
				medicamento.setIntervalo(rs.getString("intervalo"));
				medicamento.setDuracao(rs.getString("duracao"));
				medicamento.setId(rs.getLong("id"));
				medicamentos.add(medicamento);				
			}			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao executar o select de medicamentos" + e);
		}
		return medicamentos;
	}
	
	

	}
