package br.senai.ti2014n1.sc.model;

import java.util.List;

import br.senai.ti2014n1.sc.dao.MedicamentoDao;
import br.senai.ti2014n1.sc.dominio.Medicamento;

public class MedicamentoRn {

	private MedicamentoDao dao;

	public MedicamentoRn() {
		dao = new MedicamentoDao();
	}

	public void salvar(Medicamento medicamento) throws Exception {
		if (medicamento.getNome().trim().isEmpty()) {
			throw new Exception("O nome do medicamento � obrigat�rio.");
		}
		if (medicamento.getDosagem().trim().isEmpty()) {
			throw new Exception("A dosagem do medicamento � obrigat�ria.");
		}
		if (medicamento.getIntervalo().trim().isEmpty()) {
			throw new Exception("O intervalo do medicamento � obrigat�rio.");
		}
		if (medicamento.getDuracao().trim().isEmpty()) {
			throw new Exception("A dura��o do medicamento � obrigat�ria.");
		}
		dao.salvar(medicamento);
	}

	public List<Medicamento> listar() {
		return dao.listarTodos();
	}

	
}
