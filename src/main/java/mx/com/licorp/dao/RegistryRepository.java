package mx.com.licorp.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.licorp.entity.RegistryBean;

@Repository
public interface RegistryRepository extends JpaRepository<RegistryBean, Long> {
	
}
