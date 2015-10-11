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
			throw new Exception("O nome do medicamento é obrigatório.");
		}
		if (medicamento.getDosagem().trim().isEmpty()) {
			throw new Exception("A dosagem do medicamento é obrigatória.");
		}
		if (medicamento.getIntervalo().trim().isEmpty()) {
			throw new Exception("O intervalo do medicamento é obrigatório.");
		}
		if (medicamento.getDuracao().trim().isEmpty()) {
			throw new Exception("A duração do medicamento é obrigatória.");
		}
		dao.salvar(medicamento);
	}

	public List<Medicamento> listar() {
		return dao.listarTodos();
	}

	
}
