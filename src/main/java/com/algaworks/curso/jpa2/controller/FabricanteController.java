package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.exception.NegocioException;
import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.service.FabricanteService;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class FabricanteController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FabricanteService fabricanteService;

	private Fabricante fabricante;

	public void salvar() {
		try {
			this.fabricanteService.salvar(fabricante);
			FacesUtil.addSuccessMessage("Fabricante salvo com sucesso.");
			
			this.limpar();
		} catch (NegocioException e) {
			FacesUtil.addSuccessMessage(e.getMessage());
		}
	}

	@PostConstruct
	public void init() {
		this.limpar();
	}

	public void limpar() {
		this.fabricante = new Fabricante();
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
}
