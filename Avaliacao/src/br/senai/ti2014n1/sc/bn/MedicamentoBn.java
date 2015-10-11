package br.senai.ti2014n1.sc.bn;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.senai.ti2014n1.sc.dominio.Medicamento;
import br.senai.ti2014n1.sc.model.MedicamentoRn;

@ManagedBean
public class MedicamentoBn {

	private List<Medicamento> medicamentos;
	private Medicamento medicamento;
	private MedicamentoRn rn;

	@PostConstruct
	public void init() {
		rn = new MedicamentoRn();
		medicamento = new Medicamento();
	}

	public List<Medicamento> getMedicamentos() {
		if (medicamentos == null) {
			medicamentos = rn.listar();
		}
		return medicamentos;
	}

	public void setMedicamentos(List<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public String salvar() {
		try {
			rn.salvar(medicamento);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		return "listMedicamentos";
	}

	
}
