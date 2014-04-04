package com.MinotaurGames.localization;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Localization {
	public static String language;
	public static HashMap<String, String[]> english = new HashMap<String, String[]>();
	public static void init(String language){
		System.out.println("Language set to " + language);
		Localization.language = language;
		if(language.equals("English")){
			File file = new File(new File("").getAbsolutePath().concat("/assets/localizations/english.lang"));
			if(!file.canRead()){
				System.out.println("File not found");
				return;
			}
			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(file));
			} catch (FileNotFoundException e) {
				//TODO Add exception
			}
			String line;
			try {
				while((line=br.readLine()) != null){
					String[] data = line.split(" ");
					String[] data2 = {data[1], data[2], data[3]};
					english.put(data[0], data2);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static String localize(String stringToLocalize, int capitalization) throws LocalizionNotInitializedException, LocalizationNotPresentException{
		if(language != null){
			if(language=="English"){
				String localizedString = english.get(stringToLocalize)[capitalization];
				return localizedString;
			}
			throw new LocalizationNotPresentException();
		}
		throw new LocalizionNotInitializedException();
	}
}