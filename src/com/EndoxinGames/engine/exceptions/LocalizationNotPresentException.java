package com.EndoxinGames.engine.exceptions;

public class LocalizationNotPresentException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public LocalizationNotPresentException(){
		super("There is no localization present for this language");
	}
	
}
