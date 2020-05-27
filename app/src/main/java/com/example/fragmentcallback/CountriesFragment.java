package com.example.fragmentcallback;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class CountriesFragment extends Fragment {

    View rootView;
    ListView listViewCountries;
    ArrayAdapter<String> countryNamesAdapter;
    Context context;
    String[] countries;
    FragmentActionListener fragmentActionListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView= inflater.inflate(R.layout.fragment_countries, container, false);
        initUI();
        return rootView;
    }
    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(getString(R.string.app_name)+"->Select Country");
    }

    public void setFragmentActionListener(FragmentActionListener fragmentActionListener){
        this.fragmentActionListener = fragmentActionListener;
    }

    private void initUI() {
        context=getContext();
        countries=getResources().getStringArray(R.array.countries);
        listViewCountries= rootView.findViewById(R.id.listViewCountries);
        countryNamesAdapter=new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,countries);
        listViewCountries.setAdapter(countryNamesAdapter);

        listViewCountries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(fragmentActionListener!=null){
                    fragmentActionListener.onCountrySelected(countries[position]);
                }
            }
        });
    }
}
