package ch.hszt.hs_2010.mdp.HGHM;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ch.hszt.hs_2010.mdp.HGHM.Hello;

/**
 * @author david
 * @category Junit 
 * Junit Test class for class Hello 
 */
public class HelloTest {
	
	// local Hello member
	private Hello m_Hello;
	
	/**
	 * Setup test enviroment
	 * Initialize Hello
	 */
    @Before
    public void init() {
    	m_Hello = new Hello();
    }

    /** 
     * Clean up test enviroment
     */
    @After
    public void clear() {
    	m_Hello = null;
    }

    // BeforeClass are executed
    // before executing all tests
    // Note: this method must be static
    @BeforeClass
    public static void beforeEverything() {
    }

    // AfterClass are executed
    // after executing all tests
    // Note: this method must be static
    @AfterClass
    public static void cleanUp() {
    }
    
    /**
     * Validate getHelloName functionality 
     * excepted return should be Hello customname
     */
    @Test
    public void funcTest_getHelloName() {
        assertEquals("Hello 1234", m_Hello.getHelloName("1234"));
        assertEquals("Hello 12#sh", m_Hello.getHelloName("12#sh"));
        assertEquals("Hello Test", m_Hello.getHelloName("Test"));
        assertEquals("Hello ", m_Hello.getHelloName(""));
        assertEquals("Hello null", m_Hello.getHelloName(null));
    }
    
    /**
     * Validate getHelloWorld functionality 
     * excepted return should be HelloWorld
     */
    @Test
    public void funcTest_getHelloWorld() {
        assertEquals("Hello World", m_Hello.getHelloWorld());
    }
    
    /**
     * Validate getHelloKitty functionality 
     * excepted return should be HelloKitty
     */
    @Test
    public void funcTest_getHelloKitty() {
        assertEquals("Hello Kitty", m_Hello.getHelloKitty());
    }
}
