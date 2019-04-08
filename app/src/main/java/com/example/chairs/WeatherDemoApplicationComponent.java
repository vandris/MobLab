package com.example.chairs;

import com.example.chairs.interactor.cities.CitiesInteractor;
import com.example.chairs.ui.info.InfoPresenter;
import com.example.chairs.ui.main.MainActivity;


//@Singleton
//@Component(modules = {UIModule.class, NetworkModule.class,
//        InteractorModule.class})
public interface WeatherDemoApplicationComponent {

    void inject(MainActivity mainActivity);

    void inject(CitiesInteractor citiesInteractor);

    void inject(InfoPresenter citiesPresenter);

}
