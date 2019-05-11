package com.example.chairs.test;

import com.example.chairs.ui.info.InfoPresenter;
import com.example.chairs.ui.info.InfoScreen;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import javax.inject.Inject;

import static org.mockito.Mockito.mock;

@RunWith(RobolectricTestRunner.class)
public class InfoTest {

    @Inject
    InfoPresenter infoPresenter;

    private InfoScreen infoScreen;

    @Before
    public void setup() {
        //DaggerTestComponent injector = setTestInjector();
        //injector.inject(this);
        infoScreen = mock(InfoScreen.class);
        infoPresenter.attachScreen(infoScreen);
    }

    @Test
    public void testSearch() {

    }


    @After
    public void tearDown() {
        infoPresenter.detachScreen();
    }

}
