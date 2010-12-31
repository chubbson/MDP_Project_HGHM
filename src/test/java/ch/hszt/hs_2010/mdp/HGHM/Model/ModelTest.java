package test.java.ch.hszt.hs_2010.mdp.HGHM.Model;

import static org.junit.Assert.assertEquals;

import main.java.ch.hszt.hs_2010.mdp.HGHM.Model.Model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ModelTest {

	private Model m_model;
	
	@Before
    public void init() {
    	m_model = new Model();
    }

    @After
    public void clear() {
    	m_model = null;
    }
    
    @Test
    public void funcTest_getHelloName() {
    	m_model.setHostIp("127.0.0.1");
    	assertEquals("127.0.0.1", m_model.getHostIp());
    }
}
