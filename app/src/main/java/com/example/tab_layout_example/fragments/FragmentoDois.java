package com.example.tab_layout_example.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tabbarteste.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentoDois.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentoDois#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentoDois extends Fragment {

    public FragmentoDois() {
    }

    public static FragmentoDois newInstance() {
        FragmentoDois fragment = new FragmentoDois();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fragmento_dois, container, false);
    }
}
