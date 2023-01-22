package com.exaze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLConnectionExample {
	public static int statusCode;
	public static String response;

	public static int sendingRequest(String method, String url) throws IOException {
		switch (method) {
		case "GET":
			return sendGET(url);
		case "POST":
			return sendPOST(url);
		default:
			break;
		}
		return 0;
	}

	private static int sendGET(String url) throws IOException {
		StringBuffer res = new StringBuffer();
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				res.append(inputLine);
			}
			in.close();
		} else {
			System.out.println("GET request did not work.");
		}
		response = res.toString();
		return responseCode;
	}

	private static int sendPOST(String url) throws IOException {
		StringBuffer res = new StringBuffer();
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setDoOutput(true);
		int responseCode = con.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				res.append(inputLine);
			}
			in.close();
		} else {
			System.out.println("POST request did not work.");
		}

		response = res.toString();
		return responseCode;
	}

}