package net.joelinn.asana.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Joe Linn
 * 11/17/13
 */
public abstract class BaseTest {
	private static final String ASANA_API_KEY_FILE = "/asanaTestApiKey.properties"; 
	private Properties p = new Properties();	    	

	public BaseTest() {
		InputStream r = BaseTest.class.getResourceAsStream(ASANA_API_KEY_FILE);
		if (r==null) {
			throw new RuntimeException("Missing file (expected in root of packages): " + ASANA_API_KEY_FILE);
		}
    	try {
			p.load(r);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}		
	}
	
    protected String getApiKey(){
    	return p.getProperty("AsanaApiKey");
    }

	public long getAsanaWorkspaceId() {
		return 498346170860L;	//Elaine's personal
		//return 1633623637624L;	//Elaine's  digispoke.com		
		//georg's Digispoke.com workspace, which is not an org,  points to 10890224435095L;
	}

	public long getAsanaTeamId() {
		return 2526785815185L;
	}

	public long getAsanaOrganizationId() {
		return 1633623637624L;  //digispoke.com 
	}
}
