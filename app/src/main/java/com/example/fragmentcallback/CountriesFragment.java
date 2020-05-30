package com.example.fragmentcallback;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
    ListView listView;
    String[] countries;
    Context context;
    ArrayAdapter<String> contriesAdapter;
    FragmentActionListener fragmentActionListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       rootView=inflater.inflate(R.layout.fragment_countries,container,false);
       initUi();
       return rootView;
    }
    public void setFragmentActionListener(FragmentActionListener fragmentActionListener){
        this.fragmentActionListener=fragmentActionListener;
    }

    private void initUi() {
        context=getContext();
     listView=rootView.findViewById(R.id.listViewCountries);
     countries=getResources().getStringArray(R.array.countries);
     contriesAdapter=new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,countries);
     listView.setAdapter(contriesAdapter);
     listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

             if(fragmentActionListener!=null){
                 Bundle bundle=new Bundle();
                 bundle.putInt(FragmentActionListener.ACTION_KEY, FragmentActionListener.ACTION_VALUE_COUNTRY_SELECTED);
                 bundle.putString("countries_selected",countries[position]);
                 fragmentActionListener.onActionPerformed(bundle);
             }
         }
     });
    }
}
