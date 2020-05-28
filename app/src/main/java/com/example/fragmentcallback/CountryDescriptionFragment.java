package com.example.fragmentcallback;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class CountryDescriptionFragment extends Fragment {

    private static final String COMMON_TAG="CombinedLifeCycle";
    private static final String FRAGMENT_NAME=CountryDescriptionFragment.class.getSimpleName();
    private static final String TAG=COMMON_TAG;
    View rootView;
    TextView textViewCountryDescription;
    String countryName;
    String countryDescription;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView= inflater.inflate(R.layout.fragment_country_description, container, false);
        initUI();
        return rootView;
    }

    private void initUI() {
        textViewCountryDescription = (TextView)rootView.findViewById(R.id.textViewCountryDescription);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle=getArguments();
        countryName=bundle.getString(FragmentActionListener.KEY_SELECTED_COUNTRY,"India");
        countryDescription=getString(getStringId(countryName));
    }

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(countryName);
        textViewCountryDescription.setText(countryDescription);
    }

    private int getStringId(String countryName) {

        if(countryName.equals("India")){
            return R.string.India;
        }else if(countryName.equals("USA")){
            return R.string.USA;
        }else if(countryName.equals("Pakistan")){
            return R.string.Pakistan;
        }else if(countryName.equals("Bangladesh")){
            return R.string.Bangladesh;
        }else if(countryName.equals("Egypt")){
            return R.string.Egypt;
        }else if(countryName.equals("Indonesia")){
            return R.string.Indonesia;
        }else if(countryName.equals("UK")){
            return R.string.UK;
        }else if(countryName.equals("Germany")){
            return R.string.Germany;
        }else {
            return R.string.India;
        }
    }
    public String toString(){
        return this.getClass().getSimpleName();
    }
}
