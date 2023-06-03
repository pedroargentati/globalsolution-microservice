package br.com.fiap.globalsolution.controllers;

import java.util.Date;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.fiap.globalsolution.entity.entities.DroneEntity;
import br.com.fiap.globalsolution.entity.entities.LicencaEntity;
import br.com.fiap.globalsolution.entity.repositories.DroneRepository;
import br.com.fiap.globalsolution.entity.repositories.LicencaRepository;
import br.com.fiap.globalsolution.infra.exception.BusinessException;
import br.com.fiap.globalsolution.infra.utils.DataUtils;
import br.com.fiap.globalsolution.model.LicencaModel;

@Controller
public class LicencaController {

	@Autowired
	private LicencaRepository licencaRepository;

	@Autowired
	private DroneRepository droneRepository;

	@GetMapping("/licencas/novo/{id}")
	public String exibirFormularioLicenca(@PathVariable("id") Long id, Model model) throws BusinessException {
		DroneEntity drone = droneRepository.getReferenceById(id);
		if (drone != null) {
			LicencaModel licenca = new LicencaModel();
			licenca.setIdDrone(Long.valueOf(drone.getIdDrone()));
			licenca.setModeloDrone(drone.getModelo());
			model.addAttribute("licenca", licenca);
		} else {
			throw new BusinessException("Não foi encontrado nenhum drone com o id: " + id);
		}
		return "licencas/cadastrolicenca";
	}

	@GetMapping("/licenca/detalhes/{id}")
	public ResponseEntity<LicencaModel> obterDetalhesLicenca(@PathVariable("id") Long id) {
	    DroneEntity drone = droneRepository.getReferenceById(id);
	    LicencaModel licencaModel = null;
	    if (drone != null) {
	        LicencaEntity licenca = licencaRepository.findByidDrone(Long.valueOf(drone.getIdDrone()));
	        if (licenca != null) {
	            licencaModel = new LicencaModel(licenca);
	            licencaModel.setModeloDrone(drone.getModelo());
	        }
	    }
	    if (licencaModel != null) {
	        return ResponseEntity.ok(licencaModel);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}


	@PostMapping("/licencas/salvar")
	public String saveLicenca(@ModelAttribute LicencaModel licenca) throws BusinessException {
		String dataValidadeStr = licenca.getDataValidadeStr();
		String dataEmissaoStr = licenca.getDataEmissaoStr();

		validateDateInput(dataValidadeStr, dataEmissaoStr);

		Date dataValidade = DataUtils.convertToDate(dataValidadeStr);
		Date dataEmissao = DataUtils.convertToDate(dataEmissaoStr);

		checkValidadeDate(dataValidade);

		licenca.setDataValidade(dataValidade);
		licenca.setDataEmissao(dataEmissao);

		licencaRepository.save(new LicencaEntity(licenca));

		return "redirect:/drones";
	}

	private void validateDateInput(String dataValidadeStr, String dataEmissaoStr) throws BusinessException {
		if (Strings.isEmpty(dataEmissaoStr) || Strings.isEmpty(dataValidadeStr)) {
			throw new BusinessException("Data de validade e/ou emissão precisam ser informadas.");
		}
	}

	private void checkValidadeDate(Date dataValidade) throws BusinessException {
		if (DataUtils.getMinDate(dataValidade).compareTo(DataUtils.getMinDate(new Date())) < 0) {
			throw new BusinessException("A data de validade tem que ser maior que a atual.");
		}
	}

}
