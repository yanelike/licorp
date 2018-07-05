package mx.com.licorp.business;

import mx.com.licorp.entity.RegistryBean;

public interface RegistryBO {
	
	public RegistryBean create(RegistryBean registry);
	
	public void delete(Long id);
	
	public Iterable<RegistryBean> findAll();
	
	 public RegistryBean findOne(Long id);
}
