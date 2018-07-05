package mx.com.licorp.licorp;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import mx.com.licorp.dao.RegistryRepository;
import mx.com.licorp.entity.RegistryBean;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LicorpApplicationTests {
	
	@Mock
	private RegistryRepository repositoryMock;
	
	@Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void save() {
		
		RegistryBean mockedBean = mock(RegistryBean.class);
		when(mockedBean.getName()).thenReturn("first");
		
		assertNotNull(mockedBean);
		
		when(repositoryMock.save(any(RegistryBean.class))).thenReturn(mockedBean);
	}

}
