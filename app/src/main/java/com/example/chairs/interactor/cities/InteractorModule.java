package com.example.chairs.interactor.cities;


import com.example.chairs.interactor.cities.event.CitiesInteractor;

//@Module
public class InteractorModule {

    //@Provides
    public CitiesInteractor provideArtistsInteractor() {
        return new CitiesInteractor();
    }

}
