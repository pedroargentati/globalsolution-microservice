package br.com.fiap.globalsolution.model;

import java.util.Date;

public class TelemetriaModel {

	private Long id;
	private long idDrone;
	private double latitude;
	private double longitude;
	private double velocidade;
	private double direcao;
	private Date daraHora;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getIdDrone() {
		return idDrone;
	}

	public void setIdDrone(long idDrone) {
		this.idDrone = idDrone;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(double velocidade) {
		this.velocidade = velocidade;
	}

	public double getDirecao() {
		return direcao;
	}

	public void setDirecao(double direcao) {
		this.direcao = direcao;
	}

	public Date getDaraHora() {
		return daraHora;
	}

	public void setDaraHora(Date daraHora) {
		this.daraHora = daraHora;
	}

}
