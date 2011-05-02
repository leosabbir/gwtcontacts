package com.home.client.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class SettingsPlace extends Place {

	private String placeName;
	
	public SettingsPlace( String placename){
		this.placeName = placename;
	}
	
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getPlaceName() {
		return placeName;
	}
	
	public static class Tokenizer implements PlaceTokenizer<SettingsPlace>{

		@Override
		public SettingsPlace getPlace(String token) {
			return new SettingsPlace(token);
		}

		@Override
		public String getToken(SettingsPlace place) {
			return place.getPlaceName();
		}
		
	}

	
}
