package br.com.fiap.globalsolution.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.globalsolution.entity.entities.DroneEntity;
import br.com.fiap.globalsolution.entity.repositories.DroneRepository;
import br.com.fiap.globalsolution.entity.repositories.LicencaRepository;
import br.com.fiap.globalsolution.infra.exception.BusinessException;
import br.com.fiap.globalsolution.infra.utils.DataUtils;
import br.com.fiap.globalsolution.model.DroneModel;

@Controller
public class DroneController {

	@Autowired
	private DroneRepository droneRepository;

	@Autowired
	private LicencaRepository licencaRepository;

	@RequestMapping("drones")
	public ModelAndView listarDrones() {
		List<DroneEntity> drones = droneRepository.findAll();
		this.incrementLicenca(drones);
		return new ModelAndView("drones/list", "drones", drones);
	}

	// @PreAuthorize("hasRole('DRONE-ADMIN')")
	@GetMapping("/drones/novo")
	public String exibirFormularioCadastro(Model model) {
		model.addAttribute("drone", new DroneModel());
		return "drones/cadastro";
	}

	// @PreAuthorize("hasRole('DRONE-ADMIN')")
	@PostMapping("/drones/salvar")
	public String saveDrone(@ModelAttribute DroneModel drone) throws BusinessException {
		String dataCompraStr = drone.getDataCompraStr();
		if (dataCompraStr != null && DataUtils.isValidDate(dataCompraStr)) {
			Date dataCompra = DataUtils.convertToDate(dataCompraStr);
			if (DataUtils.getMinDate(dataCompra).compareTo(DataUtils.getMinDate(new Date())) < 0) {
				throw new BusinessException("Informe uma data superior à atual.");
			}
			drone.setDataCompra(dataCompra);
		}
		droneRepository.save(new DroneEntity(drone));

		return "redirect:/drones";
	}

	@GetMapping("/drones/alterar")
	public String exibirFormularioEdicao(Model model) {
		model.addAttribute("drone", new DroneModel());
		return "drones/alterar";
	}

	@GetMapping("/drones/editar/{id}")
	public String exibirFormularioEdicao(@PathVariable("id") Long id, Model model) {
		DroneEntity droneEntity = droneRepository.getReferenceById(id);
		if (droneEntity != null) {
			DroneModel droneModel = new DroneModel(droneEntity);
			model.addAttribute("drone", droneModel);
		} else {
			// Lógica para lidar com o drone não encontrado
		}
		return "drones/alterar";
	}

	@PutMapping("/drones/editar")
	@Transactional
	public String updateDrone(@ModelAttribute DroneModel drone) throws BusinessException {
		var droneEntity = droneRepository.getReferenceById(Long.valueOf(drone.getIdDrone()));
		if (droneEntity != null) {
			Date dataCompra = DataUtils.convertToDate(drone.getDataCompraStr());
			drone.setDataCompra(dataCompra);
			droneEntity.atualizarInformacoesDrone(drone);
		} else {
			throw new BusinessException("Drone não encontrado em nossa base de dados.");
		}
		return "redirect:/drones";
	}

	private List<DroneEntity> incrementLicenca(List<DroneEntity> drones) {
		if (drones != null && !drones.isEmpty()) {
			drones.forEach(drone -> {
				var licenca = licencaRepository.findByidDrone(Long.valueOf(drone.getIdDrone()));
				if (licenca != null) {
					drone.setLicencaVoo(Long.valueOf(licenca.getLicencaVoo()));
				}
			});
		}
		return drones;
	}

}
