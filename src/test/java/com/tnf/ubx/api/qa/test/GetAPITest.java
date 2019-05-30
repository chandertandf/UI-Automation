package com.tnf.ubx.api.qa.test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tnf.ubx.qa.base.TestBase;
import com.tnf.ubx.qa.restAPI.RestClient;

public class GetAPITest extends TestBase {
	
	RestClient restClient;
	
	
	@Test
	public void getAPITest() throws ClientProtocolException, IOException {
		restClient = new RestClient();
		restClient.get("https://reqres.in/api/users");
	}

}
