package br.com.fiap.globalsolution.model;

public class HistoricoVooModel {

	private Long id;
	private Long idDrone;
	private double latitudeInicioVoo;
	private double longitudeInicioVoo;
	private double latitudeFinalVoo;
	private double longitudeFinaloVoo;
	private Integer altitudemedia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdDrone() {
		return idDrone;
	}

	public void setIdDrone(Long idDrone) {
		this.idDrone = idDrone;
	}

	public double getLatitudeInicioVoo() {
		return latitudeInicioVoo;
	}

	public void setLatitudeInicioVoo(double latitudeInicioVoo) {
		this.latitudeInicioVoo = latitudeInicioVoo;
	}

	public double getLongitudeInicioVoo() {
		return longitudeInicioVoo;
	}

	public void setLongitudeInicioVoo(double longitudeInicioVoo) {
		this.longitudeInicioVoo = longitudeInicioVoo;
	}

	public double getLatitudeFinalVoo() {
		return latitudeFinalVoo;
	}

	public void setLatitudeFinalVoo(double latitudeFinalVoo) {
		this.latitudeFinalVoo = latitudeFinalVoo;
	}

	public double getLongitudeFinaloVoo() {
		return longitudeFinaloVoo;
	}

	public void setLongitudeFinaloVoo(double longitudeFinaloVoo) {
		this.longitudeFinaloVoo = longitudeFinaloVoo;
	}

	public Integer getAltitudemedia() {
		return altitudemedia;
	}

	public void setAltitudemedia(Integer altitudemedia) {
		this.altitudemedia = altitudemedia;
	}

}
