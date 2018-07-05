package mx.com.licorp.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.com.licorp.dao.RegistryRepository;
import mx.com.licorp.entity.RegistryBean;
import mx.com.licorp.utils.ResourceNotFoundException;

@Component
public class RegistryBOImpl implements RegistryBO {
	
	@Autowired
	RegistryRepository registryRepository;
	
	@Override
	public RegistryBean create(RegistryBean registry) {
		registryRepository.save(registry);
		return registry;
	}

	@Override
	public void delete(Long id) {
		RegistryBean resource = findOne(id);
		registryRepository.delete(resource);
	}

	@Override
	public Iterable<RegistryBean> findAll() {
		return registryRepository.findAll();
	}

	@Override
	public RegistryBean findOne(Long id) {
		return registryRepository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("Registry", "id", id));
	}

	
}
