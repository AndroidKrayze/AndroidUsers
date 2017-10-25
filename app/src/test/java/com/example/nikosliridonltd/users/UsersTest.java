package com.example.nikosliridonltd.users;

import com.example.nikosliridonltd.users.Adapters.Adapter;
import com.example.nikosliridonltd.users.Models.User;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;


@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class UsersTest {
    private MainActivity activity;
    private Adapter adapter;

    @Before
    public void setup() {
        activity = Robolectric.buildActivity(MainActivity.class).create().start().visible().get();
    }

    @Before
    public void setUpList() throws Exception {
        List<User> list = new ArrayList<User>();
        list.add(new User());
        list.add(new User());
        list.add(new User());

        adapter = new Adapter(activity, list);
    }

    @Test
    public void verifyListContent() {
        assertEquals(3, adapter.getCount());
        assertNotNull(adapter.getItem(0));
        assertNotNull(adapter.getItem(1));
        assertNotNull(adapter.getItem(2));
    }

    @Test
    public void checkActivityNotNull() throws Exception {
        assertNotNull(activity);
    }
}
