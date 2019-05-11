package com.example.chairs.test;

import com.example.chairs.ui.main.MainPresenter;
import com.example.chairs.ui.main.MainScreen;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import javax.inject.Inject;

import static org.mockito.Mockito.mock;

@RunWith(RobolectricTestRunner.class)
public class MainTest {

    @Inject
    MainPresenter mainPresenter;

    private MainScreen mainScreen;

    @Before
    public void setup() {
        //DaggerTestComponent injector = setTestInjector();
        //injector.inject(this);
        mainScreen = mock(MainScreen.class);
        mainPresenter.attachScreen(mainScreen);
    }

    @Test
    public void testSearch() {

    }


    @After
    public void tearDown() {
        mainPresenter.detachScreen();
    }

}
