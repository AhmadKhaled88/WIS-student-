package com.example.my_uni_app;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Colleges#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Colleges extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Colleges() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Colleges.
     */
    // TODO: Rename and change types and number of parameters
    public static Colleges newInstance(String param1, String param2) {
        Colleges fragment = new Colleges();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_colleges, container, false);
    }
     CardView cardView1 ,cardView2,cardView3,cardView4,cardView5,cardView6,cardView7,cardView8,cardView9,cardView10;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cardView1 = view.findViewById(R.id.card1);
        cardView2 = view.findViewById(R.id.card2);
        cardView3 = view.findViewById(R.id.card3);
        cardView4 = view.findViewById(R.id.card4);
        cardView5 = view.findViewById(R.id.card5);
        cardView6 = view.findViewById(R.id.card6);
        cardView7 = view.findViewById(R.id.card7);
        cardView8 = view.findViewById(R.id.card8);
        cardView9 = view.findViewById(R.id.card9);
        cardView10 = view.findViewById(R.id.card10);

        cardView1.setOnClickListener(this);
        cardView2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i ;
        switch (view.getId()){
            case R.id.card1 :
                i = new Intent(view.getContext(), It.class);
                startActivity(i);
                break;
            case R.id.card2:
                i = new Intent(view.getContext(), bf.class);
                startActivity(i);
                break;

        }
    }
}