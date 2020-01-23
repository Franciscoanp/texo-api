package com.texoit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.texoit.model.Producer;

public interface ProducerRepository extends JpaRepository<Producer, Long>{

	@Query(value = "SELECT DISTINCT(name) FROM PRODUCER", nativeQuery = true)
	public List<IProducerProjection> findAllProducer();
}
