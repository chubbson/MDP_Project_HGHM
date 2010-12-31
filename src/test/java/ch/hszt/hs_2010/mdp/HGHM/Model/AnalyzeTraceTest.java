package test.java.ch.hszt.hs_2010.mdp.HGHM.Model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.java.ch.hszt.hs_2010.mdp.HGHM.Common;
import main.java.ch.hszt.hs_2010.mdp.HGHM.Model.AnalyzeTrace;

public class AnalyzeTraceTest {
	
    @Test
    public void funcTest_getHelloName() {
    	assertEquals("10.0.2.254 testIP\\n10.0.2.254 testIP",AnalyzeTrace.Analyze(Common.DEFAULT_TRACEROUTE)); 
    }
}
