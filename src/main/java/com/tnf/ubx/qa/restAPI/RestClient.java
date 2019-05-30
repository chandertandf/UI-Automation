package com.tnf.ubx.qa.restAPI;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {
	
	
	public void get(String url) throws ClientProtocolException, IOException {
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);
		CloseableHttpResponse httpResponse = httpClient.execute(httpget);
		int statusCode = httpResponse.getStatusLine().getStatusCode();
		String responseString = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
		
		System.out.println(" Status code : "+statusCode);
		
		JSONObject responseJSON = new JSONObject(responseString);
		System.out.println(" JSON Response : "+responseJSON);
		
		Header[] headerArray = httpResponse.getAllHeaders();
		
		HashMap<String,String> allHeader = new HashMap<String,String>();
		
		for(Header head: headerArray) {
			allHeader.put(head.getName(), head.getValue());
		}
		
		System.out.println(" All Header : "+allHeader);
	}

}
