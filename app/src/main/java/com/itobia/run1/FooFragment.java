package com.itobia.run1;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class FooFragment extends Fragment {

    String msg ;
    ClickListner listner ;
    static String EXTRA_URL = "url" ;

    public FooFragment() {
        // Required empty public constructor
    }

    static FooFragment getInstace(String msg ) {

        Bundle b = new Bundle() ;
        b.putString(EXTRA_URL , msg);
        FooFragment frag = new FooFragment() ;
        frag.setArguments(b);

        return  frag ;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =  inflater.inflate( R.layout.frag_home , container , false ) ;
        return v;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        msg =  getArguments().getString(EXTRA_URL) ;

        TextView t=  view.findViewById(R.id.txt1) ;
        t.setText("heloooooooooooo " + msg + (savedInstanceState==null?"":  savedInstanceState.get("hello")) ) ;

    }




    public interface ClickListner {
        public void onClick() ;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listner = (ClickListner) context;

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("hello" , "hello");
        super.onSaveInstanceState(outState);
    }
}
