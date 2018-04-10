/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author jermainerogers
 */
class LanguageMapper {
    public String getLanguage(String langCode) throws IOException {

		HashMap<String, String> langMap = readToHashmap();

		return langMap.get(langCode);

	}

	public HashMap<String, String> readToHashmap() throws IOException {
		HashMap<String, String> map = new HashMap<String, String>();
		BufferedReader in = new BufferedReader(new FileReader(".\\resources\\language_mapping.txt"));
		String line = "";
		
		while ((line = in.readLine()) != null) {
			String parts[] = line.split("\t");
			map.put(parts[0], parts[1]);
		}
		in.close();

		return map;

	}
}
