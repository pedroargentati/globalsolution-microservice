package br.com.fiap.globalsolution.model;

import java.util.Date;

import br.com.fiap.globalsolution.entity.entities.DroneEntity;
import jakarta.validation.constraints.NotNull;

public class DroneModel {

	private Integer idDrone;
	
	@NotNull(message = "É obrigatório informar o modelo do Drone.")
	private String  modelo;
	
	@NotNull(message = "É obrigatório informar o número de série do Drone.")
	private String numeroSerie;
	
	private Date dataCompra;
	private String dataCompraStr;
	
	@NotNull(message = "É obrigatório informar a capacidade de bateria do Drone.")
	private Double capacidadeBateria;

	private LicencaModel licencaVooOb;
	private Long licencaVoo;
	
	private Long idLicenca;
	
	@NotNull(message = "É obrigatório informar a capacidade de carga do Drone.")
	private Double capacidadeCarga;
	
	public DroneModel() {}
	
	public DroneModel(DroneEntity dados) {
		this.idDrone = dados.getIdDrone();
		this.modelo = dados.getModelo();
		this.numeroSerie = dados.getNumeroSerie();
		this.dataCompra = dados.getDataCompra();
		this.capacidadeBateria = dados.getCapacidadeBateria();
		this.licencaVoo = dados.getLicencaVoo();
		this.capacidadeCarga = dados.getCapacidadeCarga();
	}

	public Integer getIdDrone() {
		return idDrone;
	}

	public void setIdDrone(Integer idDrone) {
		this.idDrone = idDrone;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public Double getCapacidadeBateria() {
		return capacidadeBateria;
	}

	public void setCapacidadeBateria(Double capacidadeBateria) {
		this.capacidadeBateria = capacidadeBateria;
	}

	public LicencaModel getLicencaVooOb() {
		return licencaVooOb;
	}

	public void setLicencaVooOb(LicencaModel licencaVooOb) {
		this.licencaVooOb = licencaVooOb;
	}

	public Long getLicencaVoo() {
		return licencaVoo;
	}

	public void setLicencaVoo(Long licencaVoo) {
		this.licencaVoo = licencaVoo;
	}

	public Long getIdLicenca() {
		return idLicenca;
	}

	public void setIdLicenca(Long idLicenca) {
		this.idLicenca = idLicenca;
	}

	public Double getCapacidadeCarga() {
		return capacidadeCarga;
	}

	public void setCapacidadeCarga(Double capacidadeCarga) {
		this.capacidadeCarga = capacidadeCarga;
	}

	public String getDataCompraStr() {
		return dataCompraStr;
	}

	public void setDataCompraStr(String dataCompraStr) {
		this.dataCompraStr = dataCompraStr;
	}

	@Override
	public String toString() {
		return "DroneModel [idDrone=" + idDrone + ", modelo=" + modelo + ", numeroSerie=" + numeroSerie
				+ ", dataCompra=" + dataCompra + ", dataCompraStr=" + dataCompraStr + ", capacidadeBateria="
				+ capacidadeBateria + ", licencaVooOb=" + licencaVooOb + ", licencaVoo=" + licencaVoo + ", idLicenca="
				+ idLicenca + ", capacidadeCarga=" + capacidadeCarga + "]";
	}

	

}
