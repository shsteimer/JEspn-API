package org.shsteimer.espn.api.headlines;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.HashMap;

import org.junit.After;
import org.junit.Test;
import org.shsteimer.espn.api.resource.JEspnApiResouce;
import org.shsteimer.espn.api.response.JEspnApiResponse;
import org.shsteimer.espn.api.version.JEspnApiVersion;

public class JEspnHeadlinesApiTest {

	private static final String testingApiKey = "rxyta6dxpeh2tfm88sr6ctvn";

	@After
	public void doAfter() throws InterruptedException {
		Thread.currentThread().sleep(1000);
	}

	@Test
	public void BaseNewsApiCallTest() {
		try {
			JEspnApiResponse response = JEspnHeadlinesApi
					.getHeadlines(JEspnApiVersion.VERSION1, testingApiKey)
					.with(JEspnApiResouce.SPORTS)
					.using(JEspnHeadlinesApiMethod.NEWS).execute();
			assertNotNull(response);
			assertFalse(response.isError());
			assertNotNull(response.getResponse());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void ParameterizedNewsApiCallTest() {
		try {
			JEspnApiResponse response = JEspnHeadlinesApi
					.getHeadlines(JEspnApiVersion.VERSION1, testingApiKey)
					.with(JEspnApiResouce.SPORTS)
					.using(JEspnHeadlinesApiMethod.NEWS_BY_DATE,
							new HashMap<String, String>() {
								{
									put("yyyymmdd", "20120414");
								}
							}).execute();
			assertNotNull(response);
			assertFalse(response.isError());
			assertNotNull(response.getResponse());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
