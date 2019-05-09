package com.example.chairs.test;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.chairs.R;
import com.example.chairs.ui.main.MainActivity;
import com.example.chairs.utils.EspressoUtils;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainTest {

    public static final String CITY = "Szeged";

    public MainTest() {
        //super(MainActivity.class);
    }

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp(){
        //setTestInjector();
    }

    @Test
    public void testNavigateToInfoActivity(){
        onView(withId(com.example.chairs.R.id.searchEditText)).perform(typeText("Szeged"), closeSoftKeyboard());
        onView(withText("Szeged")).perform(click());
        onView(withId(R.id.searchButton)).perform(click());
        EspressoUtils.matchToolbarTitle("Az általad választott település");
    }
    @Test
    public void testNavigateToModifyActivity(){
        onView(withId(R.id.fab)).perform(click());
        EspressoUtils.matchToolbarTitle("Új elem felvétele, szerkesztése");
    }
}
