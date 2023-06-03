package br.com.fiap.globalsolution.entity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.globalsolution.entity.entities.DroneEntity;

@Repository
public interface DroneRepository extends JpaRepository<DroneEntity, Long> {
	
}
