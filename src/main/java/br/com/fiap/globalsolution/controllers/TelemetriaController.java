//package br.com.fiap.globalsolution.controllers;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import br.com.fiap.globalsolution.entity.repositories.TelemetriaRepository;
//import br.com.fiap.globalsolution.model.TelemetriaModel;
//import jakarta.validation.Valid;
//
//@RestController
//@RequestMapping("/telemetria")
//public class TelemetriaController {
//
//	@Autowired
//	private TelemetriaRepository telemetriaRepository;
//	
//	@GetMapping
//	public ResponseEntity<List<TelemetriaModel>> obterListaTelemetria() {
//		var telemetriaList = telemetriaRepository.findAll();
//		return ResponseEntity.ok(telemetriaList);
//	}
//	
//	@GetMapping("/{id}")
//	public ResponseEntity<TelemetriaModel> obterTelemetriaPorChave(@PathVariable Long id) {
//		var telemetria = telemetriaRepository.getReferenceById(id);
//		return ResponseEntity.ok(telemetria);
//	}
//	
//	@PostMapping
//	public ResponseEntity<TelemetriaModel> inserirTelemetria(@RequestBody @Valid TelemetriaModel telemetriaModel) {
//		var telemetria = telemetriaRepository.save(telemetriaModel);
//		return ResponseEntity.ok(telemetria);
//	}
//	
//}
