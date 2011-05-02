package com.home.client.mvp;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;
import com.home.client.places.MainPlace;
import com.home.client.places.SettingsPlace;

@WithTokenizers({MainPlace.Tokenizer.class, SettingsPlace.Tokenizer.class})
public interface ContactsPlaceHistoryMapper extends PlaceHistoryMapper {

}
