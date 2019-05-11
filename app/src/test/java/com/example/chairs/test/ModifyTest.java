package com.example.chairs.test;

import com.example.chairs.ui.modify.ModifyPresenter;
import com.example.chairs.ui.modify.ModifyScreen;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import javax.inject.Inject;

import static org.mockito.Mockito.mock;

@RunWith(RobolectricTestRunner.class)
public class ModifyTest {

    @Inject
    ModifyPresenter modifyPresenter;

    private ModifyScreen modifyScreen;

    @Before
    public void setup() {
        //DaggerTestComponent injector = setTestInjector();
        //injector.inject(this);
        modifyScreen = mock(ModifyScreen.class);
        modifyPresenter.attachScreen(modifyScreen);
    }

    @Test
    public void testSearch() {

    }


    @After
    public void tearDown() {
        modifyPresenter.detachScreen();
    }

}
