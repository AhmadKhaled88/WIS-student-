package com.example.my_uni_app;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import org.jetbrains.annotations.NotNull;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Home#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class Home extends Fragment {




    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;




    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Home.
     */
    // TODO: Rename and change types and number of parameters
    public static Home newInstance(String param1, String param2) {


        Home fragment = new Home();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Home() {

        // Required empty public constructor
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
        return inflater.inflate(R.layout.fragment_home2, container, false);
    }


    SliderView sliderView;
    int[] images = {
            R.drawable.a1,
            R.drawable.a4,
            R.drawable.a5,
            R.drawable.a8,
            R.drawable.a11,
            R.drawable.a18,
            R.drawable.a19,
            R.drawable.a10
                    };



    LinearLayout bareed , maktabah ,etaaleem,gadwalderase,tasgeelthate,daleel,taqyeem,anzema
            ,khareeg,taqweem;
    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        sliderView = view.findViewById(R.id.image_slider);

        SliderAdapter sliderAdapter = new SliderAdapter(images);

        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();




bareed = view.findViewById(R.id.bareed);
bareed.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {


        gotoUrl("https://www.office.com/");




    }

    private void gotoUrl(String s) {

        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));

    }
});

maktabah = view.findViewById(R.id.maktabah);
maktabah.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        gotoUrl1("http://library.wise.edu.jo:8089/uhtbin/cgisirsi.exe/?ps=Tv8l1GKIBi/MAIN/19570003/60/502/X");


    }

    private void gotoUrl1(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));

    }
});

        etaaleem = view.findViewById(R.id.etaaleem);
        etaaleem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                gotoUrl2("https://learn.wise.edu.jo/mlms20211/");


            }

            private void gotoUrl2(String s) {
                Uri uri = Uri.parse(s);
                startActivity(new Intent(Intent.ACTION_VIEW,uri));
            }
        });
        gadwalderase = view.findViewById(R.id.gadwalderase);
        gadwalderase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl3("http://grades.wise.edu.jo:8889/reg/schedule.php");

            }

            private void gotoUrl3(String s) {
                Uri uri = Uri.parse(s);
                startActivity(new Intent(Intent.ACTION_VIEW,uri));
            }
        });

        tasgeelthate =view.findViewById(R.id.tasgeelthate);
        tasgeelthate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl4("http://grades.wise.edu.jo:8889/");

            }

            private void gotoUrl4(String s) {
                Uri uri = Uri.parse(s);
                startActivity(new Intent(Intent.ACTION_VIEW,uri));
            }
        });

        daleel=view.findViewById(R.id.daleel);
        daleel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl5("https://www.wise.edu.jo/wp-content/uploads/2021/05/%D8%AF%D9%84%D9%8A%D9%84-%D8%A7%D9%84%D8%B7%D8%A7%D9%84%D8%A8.pdf");

            }

            private void gotoUrl5(String s) {
                Uri uri = Uri.parse(s);
                startActivity(new Intent(Intent.ACTION_VIEW,uri));

            }
        });

        taqyeem=view.findViewById(R.id.taqyeem);
        taqyeem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl6("http://evaluation.wise.edu.jo:8889/login.php");


            }

            private void gotoUrl6(String s) {
                Uri uri = Uri.parse(s);
                startActivity(new Intent(Intent.ACTION_VIEW,uri));
            }
        });

        anzema=view.findViewById(R.id.anzema);
       anzema.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               gotoUrl7("https://www.wise.edu.jo/%d8%a5%d8%af%d8%a7%d8%b1%d8%a9-%d8%a7%d9%84%d8%ac%d8%a7%d9%85%d8%b9%d8%a9/%d8%a7%d9%84%d8%aa%d8%b9%d9%84%d9%8a%d9%85%d8%a7%d8%aa-%d9%88%d8%a7%d9%84%d8%a3%d9%86%d8%b8%d9%85%d8%a9/");

           }

           private void gotoUrl7(String s) {
               Uri uri = Uri.parse(s);
               startActivity(new Intent(Intent.ACTION_VIEW,uri));
           }
       });


       khareeg=view.findViewById(R.id.khareeg);
        khareeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl8("http://evaluation.wise.edu.jo:8889/gstudents/index.html");

            }

            private void gotoUrl8(String s) {
                Uri uri = Uri.parse(s);
                startActivity(new Intent(Intent.ACTION_VIEW,uri));
            }
        });

        taqweem=view.findViewById(R.id.taqweem);
        taqweem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl9("https://www.wise.edu.jo/%D8%A7%D9%84%D9%82%D8%A8%D9%88%D9%84-%D9%88-%D8%A7%D9%84%D8%AA%D8%B3%D8%AC%D9%8A%D9%84/%D8%A7%D9%84%D8%AA%D9%82%D9%88%D9%8A%D9%85-%D8%A7%D9%84%D8%AC%D8%A7%D9%85%D8%B9%D9%8A/");

            }

            private void gotoUrl9(String s) {
                Uri uri = Uri.parse(s);
                startActivity(new Intent(Intent.ACTION_VIEW,uri));
            }
        });



    }



}


