package br.com.fiap.globalsolution.entity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.globalsolution.entity.entities.LicencaEntity;

public interface LicencaRepository extends JpaRepository<LicencaEntity, Long> {

	LicencaEntity findByidDrone(Long idDrone);
	
}
