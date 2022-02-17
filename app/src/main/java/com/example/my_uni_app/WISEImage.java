package com.example.my_uni_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WISEImage#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WISEImage extends Fragment {
    GridView gridView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public WISEImage() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WISEImage.
     */
    // TODO: Rename and change types and number of parameters
    public static WISEImage newInstance(String param1, String param2) {
        WISEImage fragment = new WISEImage();
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
        View v =inflater.inflate(R.layout.fragment_w_i_s_e_image,container,false);
        gridView = (GridView) v.findViewById(R.id.gridviewgallry);
        int[] numimage = {R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4,
                R.drawable.a5, R.drawable.a6, R.drawable.a7, R.drawable.a8, R.drawable.a9, R.drawable.a10,
                R.drawable.a11, R.drawable.a12, R.drawable.a13, R.drawable.a14, R.drawable.a15, R.drawable.a16,
                R.drawable.a17, R.drawable.a18, R.drawable.a19, R.drawable.a20 };
        GridAdapter gridAdapter = new GridAdapter(getContext(),numimage);
        gridView.setAdapter(gridAdapter);

        // Inflate the layout for this fragment
        return v;
    }
}