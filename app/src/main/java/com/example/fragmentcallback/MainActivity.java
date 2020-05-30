package com.example.fragmentcallback;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentActionListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addCountriesFragment();
    }

    private void addCountriesFragment() {

        FragmentManager fragmentManager=getSupportFragmentManager();
        CountriesFragment countriesFragment=new CountriesFragment();
        countriesFragment.setFragmentActionListener(this);
        fragmentManager.beginTransaction()
           .add(R.id.fragmentContainer,countriesFragment).commit();
    }

    @Override
    public void onActionPerformed(Bundle bundle) {
        int action=bundle.getInt(FragmentActionListener.ACTION_KEY);
         switch(action){
             case FragmentActionListener.ACTION_VALUE_COUNTRY_SELECTED:
                 countryDescription(bundle);
                 break;
         }

    }

    private void countryDescription(Bundle bundle) {

      CountryDescriptionFragment countryDescriptionFragment=new CountryDescriptionFragment();
      countryDescriptionFragment.setArguments(bundle);
      FragmentManager fragmentManager=getSupportFragmentManager();
      fragmentManager.beginTransaction().replace(R.id.fragmentContainer,countryDescriptionFragment)
              .addToBackStack(null).commit();

    }
}

