package com.home.client.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class MainPlace extends Place {

	private String placeName;

	public MainPlace(String placeName){
		this.placeName = placeName;
	}
	
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getPlaceName() {
		return placeName;
	}
	
	public static class Tokenizer implements PlaceTokenizer<MainPlace>{

		@Override
		public MainPlace getPlace(String token) {
			return new MainPlace(token);
		}

		@Override
		public String getToken(MainPlace place) {
			return place.getPlaceName();
		}
		
	}
}
