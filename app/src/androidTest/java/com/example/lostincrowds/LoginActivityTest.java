/******************************************************************************
 * Copyright (c) 2019. Xiang Li From Australian National University CECS  All Rights Reserved. FileName: LoginActivityTest.java@author: jack@date: 24/05/19 11:51 AM@version: 1.0
 ******************************************************************************/

package com.example.lostincrowds;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {
    @Rule
    public ActivityTestRule<LoginActivity> activityRule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void TestLogin() {
        onView(withId(R.id.login_username)).perform(typeText("test1"),
                closeSoftKeyboard());
        onView(withId(R.id.login_pwd)).perform(typeText("test1"),
                closeSoftKeyboard());
        onView(withId(R.id.login_btn)).perform(click());
    }

    @Test
    public void TestRegister() {
        onView(withId(R.id.login_username)).perform(typeText("test1"),
                closeSoftKeyboard());
        onView(withId(R.id.login_pwd)).perform(click());
        onView(withId(R.id.login_pwd)).perform(typeText("123"),
                closeSoftKeyboard());
        onView(withId(R.id.login_register)).perform(click());
    }

    @Test
    public void TestSkip() {
        onView(withId(R.id.login_forgot)).perform(click());

    }
}