package br.com.fiap.globalsolution.entity.entities;

import java.util.Date;

import br.com.fiap.globalsolution.model.LicencaModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "licencas")
@Entity(name = "LicencaEntity")
public class LicencaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "licenca_seq_ger", sequenceName = "licenca_seq", allocationSize = 1)
	private Long idLicenca;

	@Column(unique =  true)
	private Integer licencaVoo;
	private Date    dataValidade;
	private Date    dataEmissao;

	@Column(nullable = false)
	private Long idDrone;
	
	public LicencaEntity(Long idLicenca, Integer licencaVoo, Date dataValidade, Date dataEmissao, Long idDrone) {
		super();
		this.idLicenca = idLicenca;
		this.licencaVoo = licencaVoo;
		this.dataValidade = dataValidade;
		this.dataEmissao = dataEmissao;
		this.idDrone = idDrone;
	}

	public LicencaEntity() {}
	
	public LicencaEntity(LicencaModel dados) {
		this(dados.getIdLicenca(), dados.getLicencaVoo(), dados.getDataValidade(), dados.getDataEmissao(), dados.getIdDrone());
	}

	public Long getIdLicenca() {
		return idLicenca;
	}

	public void setIdLicenca(Long idLicenca) {
		this.idLicenca = idLicenca;
	}

	public Integer getLicencaVoo() {
		return licencaVoo;
	}

	public void setLicencaVoo(Integer licencaVoo) {
		this.licencaVoo = licencaVoo;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public Long getIdDrone() {
		return idDrone;
	}

	public void setIdDrone(Long idDrone) {
		this.idDrone = idDrone;
	}

	@Override
	public String toString() {
		return "LicencaEntity [idLicenca=" + idLicenca + ", licencaVoo=" + licencaVoo + ", dataValidade=" + dataValidade
				+ ", dataEmissao=" + dataEmissao + ", idDrone=" + idDrone + "]";
	}
	
}
