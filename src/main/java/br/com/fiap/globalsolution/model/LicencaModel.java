package br.com.fiap.globalsolution.model;

import java.util.Date;

import br.com.fiap.globalsolution.entity.entities.LicencaEntity;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
@Embeddable
public class LicencaModel {
	
	private Long idLicenca;
	
	@NotNull(message = "É obrigatório infomar o número da licença.")
	private Integer licencaVoo;
	
	@NotNull(message = "É obrigatório infomar a validade da licença.")
	private Date dataValidade;
	
	@NotNull(message = "É obrigatório infomar a data da emissão da licença.")
	private Date    dataEmissao;
	
	@NotNull(message = "É necessário informar o id do drone.")
	private Long idDrone;

	
	private String dataValidadeStr;
	private String dataEmissaoStr;
	private String modeloDrone;
	
	public LicencaModel() {}
	
	public LicencaModel(LicencaEntity dados) {
		this.idLicenca = dados.getIdLicenca();
		this.dataEmissao = dados.getDataEmissao();
		this.licencaVoo = dados.getLicencaVoo();
		this.dataValidade = dados.getDataValidade();
		this.idDrone = dados.getIdDrone();
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
	
	
	public String getDataEmissaoStr() {
		return dataEmissaoStr;
	}

	public void setDataEmissaoStr(String dataEmissaoStr) {
		this.dataEmissaoStr = dataEmissaoStr;
	}
	
	public String getDataValidadeStr() {
		return dataValidadeStr;
	}

	public void setDataValidadeStr(String dataValidadeStr) {
		this.dataValidadeStr = dataValidadeStr;
	}

	public String getModeloDrone() {
		return modeloDrone;
	}

	public void setModeloDrone(String modeloDrone) {
		this.modeloDrone = modeloDrone;
	}

	@Override
	public String toString() {
		return "LicencaModel [idLicenca=" + idLicenca + ", licencaVoo=" + licencaVoo + ", dataValidade=" + dataValidade
				+ ", dataEmissao=" + dataEmissao + ", idDrone=" + idDrone + ", dataValidadeStr=" + dataValidadeStr
				+ ", dataEmissaoStr=" + dataEmissaoStr + ", modeloDrone=" + modeloDrone + "]";
	}
	
}
