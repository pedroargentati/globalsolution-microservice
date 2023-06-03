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
//import br.com.fiap.globalsolution.entity.repositories.HistoricoVooRepository;
//import br.com.fiap.globalsolution.model.HistoricoVooModel;
//import jakarta.transaction.Transactional;
//import jakarta.validation.Valid;
//
//@RestController
//@RequestMapping("/historico/voo")
//public class HistoricoVooController {
//
//	@Autowired
//	private HistoricoVooRepository histRepository;
//
//	@GetMapping
//	public ResponseEntity<List<HistoricoVooModel>> obterListaHistoricoVoo() {
//		var historico = histRepository.findAll();
//		return ResponseEntity.ok(historico);
//	}
//	
//	@GetMapping("/{id}")
//	public ResponseEntity<HistoricoVooModel> obterHistoricoVooPorChave(@PathVariable Long id) {
//		var historico = histRepository.getReferenceById(id);
//		return ResponseEntity.ok(historico);
//	}
//
//	@PostMapping
//	@Transactional
//	public ResponseEntity<HistoricoVooModel> inserirHistoricoVoo(@RequestBody @Valid HistoricoVooModel historicoVooModel) {
//		var historico = histRepository.save(historicoVooModel);
//		return ResponseEntity.ok(historico);
//	}
//	
//}
