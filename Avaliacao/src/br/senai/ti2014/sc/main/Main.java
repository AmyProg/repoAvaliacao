package br.senai.ti2014.sc.main;

import br.senai.ti2014n1.sc.dao.Dao;
import br.senai.ti2014n1.sc.dominio.Medicamento;
import br.senai.ti2014n1.sc.model.MedicamentoRn;

public class Main {

	public static MedicamentoRn medicamentoRn;

	public static void main(String[] args) {
		medicamentoRn = new MedicamentoRn();
	}

	private static void excluir() {
		try {
			medicamentoRn.excluir(3L);
			System.out.println("Excluido");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public static void editar() {
		Medicamento medicamento = medicamentoRn.buscarPorId(1L);
		medicamento.setNome(medicamento.getNome().concat(" A."));
		try {
			medicamentoRn.salvar(medicamento);
			System.out.println("Salvo");
		} catch (Exception e) {
			System.out.println("Erro ao salvar: " + e.getMessage());
			e.printStackTrace();
		}
	}

	private static void buscarPorId() {
		mostrar(medicamentoRn.buscarPorId(2L));
	}

	private static void listarTodos() {
		for (Medicamento medicamento : medicamentoRn.listar()) {
			mostrar(medicamento);
		}
	}

	private static void mostrar(Medicamento medicamento) {
		System.out.println("Nome: " + medicamento.getNome());
		System.out.println("Endereço: " + medicamento.getDosagem());
		System.out.println("Profissao:" + medicamento.getIntervalo());
		System.out.println("Cidade:" + medicamento.getDuracao());
		System.out.println("------------------------------");
	}

	private static void inserir() {
		Medicamento medicamento = new Medicamento();
		medicamento.setNome("Maria");
		medicamento.setDosagem("Rua da ....");
		medicamento.setIntervalo("Desempregado");
		medicamento.setDuracao("Florianópolis");
		try {
			medicamentoRn.salvar(medicamento);
			System.out.println("Salvo");
		} catch (Exception e) {
			System.out.println("Erro ao salvar: " + e.getMessage());
			e.printStackTrace();
		}
	}

	private static void conectar() {
		Dao dao = new Dao() {
		};
		dao.getConnection();

	}
}
