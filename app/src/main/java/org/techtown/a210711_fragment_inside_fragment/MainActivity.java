package org.techtown.a210711_fragment_inside_fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

// https://stackoverflow.com/questions/6672066/fragment-inside-fragment

public class MainActivity extends AppCompatActivity implements ParentFragment.OnFragmentInteractionListener, ChildFragment.OnFragmentInteractionListener {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Begin the Transaction
        getSupportFragmentManager().beginTransaction().replace(R.id.parent_fragment_container, new ParentFragment() ).commit();
    }


    @Override
    public void messageFromParentFragment(Uri uri) {
        Log.e(TAG, "received communication from parent fragment");
    }

    @Override
    public void messageFromChildFragment(Uri uri) {
        Log.i(TAG, "received communication from child fragment");
    }

}