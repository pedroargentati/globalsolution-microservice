package br.com.fiap.globalsolution.entity.entities;

import java.util.Date;

import br.com.fiap.globalsolution.model.DroneModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

@Table(name = "drones")
@Entity(name = "DroneEntity")
public class DroneEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "drone_seq_ger", sequenceName = "drone_seq", allocationSize = 1)
	private Integer idDrone;
	private String  modelo;
	private Date    dataCompra;
	private Double  capacidadeBateria;
	
	@Column(unique =  true)
	private String numeroSerie;
	
	private Long licencaVoo;

	private Double capacidadeCarga;
	
	public DroneEntity(	Integer idDrone,
						String  modeloDrone,
						String  numeroSerie,
						Double  capacidadeBateria,
						Long    licencaVoo,
						Date    dataCompra,
						Double  capacidadeCarga ) {
		super();
		this.idDrone = idDrone;
		this.modelo = modeloDrone;
		this.dataCompra = dataCompra;
		this.numeroSerie = numeroSerie;
		this.capacidadeBateria = capacidadeBateria;
		this.capacidadeCarga = capacidadeCarga;
	}

	public DroneEntity() {}
	
	public DroneEntity(DroneModel dados) {
		this(dados.getIdDrone(), dados.getModelo(), dados.getNumeroSerie(), dados.getCapacidadeBateria(), dados.getLicencaVoo(), dados.getDataCompra(), dados.getCapacidadeCarga());
	}
	
	public void atualizarInformacoesDrone(@Valid DroneModel dados) {
		if (dados.getModelo() != null) {
			this.modelo = dados.getModelo();
		}
		if (dados.getCapacidadeBateria() != null) {
			this.capacidadeBateria = dados.getCapacidadeBateria();
		}
		if (dados.getCapacidadeCarga() != null) {
			this.capacidadeCarga = dados.getCapacidadeCarga();
		}
		if (dados.getDataCompra() != null) {
			this.dataCompra = dados.getDataCompra();
		}
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

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public Long getLicencaVoo() {
		return licencaVoo;
	}

	public void setLicencaVoo(Long licencaVoo) {
		this.licencaVoo = licencaVoo;
	}

	public Double getCapacidadeCarga() {
		return capacidadeCarga;
	}

	public void setCapacidadeCarga(Double capacidadeCarga) {
		this.capacidadeCarga = capacidadeCarga;
	}

	@Override
	public String toString() {
		return "DroneEntity [idDrone=" + idDrone + ", modelo=" + modelo + ", dataCompra=" + dataCompra
				+ ", capacidadeBateria=" + capacidadeBateria + ", numeroSerie=" + numeroSerie + ", licencaVoo="
				+ licencaVoo + ", capacidadeCarga=" + capacidadeCarga + "]";
	}
	
	
	
}
