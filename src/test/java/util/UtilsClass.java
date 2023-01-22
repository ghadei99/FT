package util;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UtilsClass {
	public static List returnListFromJSON(String response) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		List resList = null;
		try {
			resList = mapper.readValue(response, List.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return resList;
	}

	public static void main(String[] args){
		try {
			List arr = returnListFromJSON(
					"[{\"id\":3105,\"name\":\"Gajaadhar Bandopadhyay\",\"email\":\"bandopadhyay_gajaadhar@block.com\",\"gender\":\"male\",\"status\":\"active\"},{\"id\":3101,\"name\":\"Chandi Dubashi\",\"email\":\"dubashi_chandi@lindgren.biz\",\"gender\":\"male\",\"status\":\"inactive\"},{\"id\":3099,\"name\":\"Sameer Nair\",\"email\":\"nair_sameer@farrell-welch.co\",\"gender\":\"male\",\"status\":\"inactive\"},{\"id\":3097,\"name\":\"Shresthi Rana\",\"email\":\"rana_shresthi@crona.name\",\"gender\":\"male\",\"status\":\"active\"},{\"id\":3096,\"name\":\"Fr. Manisha Khanna\",\"email\":\"khanna_fr_manisha@terry-davis.org\",\"gender\":\"male\",\"status\":\"inactive\"},{\"id\":3095,\"name\":\"Nikita Marar IV\",\"email\":\"nikita_marar_iv@bayer.biz\",\"gender\":\"male\",\"status\":\"inactive\"},{\"id\":3094,\"name\":\"Sanjay Rana\",\"email\":\"sanjay_rana@hane.io\",\"gender\":\"male\",\"status\":\"active\"},{\"id\":3092,\"name\":\"Tejas Guha\",\"email\":\"tejas_guha@jakubowski-kuhlman.name\",\"gender\":\"male\",\"status\":\"active\"},{\"id\":3091,\"name\":\"Anish Naik\",\"email\":\"naik_anish@rath-lowe.co\",\"gender\":\"female\",\"status\":\"active\"},{\"id\":3090,\"name\":\"Jaimini Singh\",\"email\":\"jaimini_singh@hauck-cummerata.org\",\"gender\":\"male\",\"status\":\"active\"}]");
			for (Object object : arr) {
				Map<String, String> map = (LinkedHashMap<String, String>) object;
				String name = map.get("name");
				System.out.println(name);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private String returnStringFromObject(Object object) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(object);
	}
}
