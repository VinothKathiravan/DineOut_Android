package com.vinoth.dineout.Home;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vinoth.dineout.POJO.Dish;
import com.vinoth.dineout.POJO.Restaurant;
import com.vinoth.dineout.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DishFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DishFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DishFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView rstntListView;

    private OnFragmentInteractionListener mListener;

    // TODO: Rename and change types and number of parameters
    public static DishFragment newInstance() {
        DishFragment fragment = new DishFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public DishFragment() {
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
        View view = inflater.inflate(R.layout.fragment_dish, container, false);

        rstntListView = (RecyclerView) view.findViewById(R.id.dishListView);

//        RestaurantAdapter adapter = new RestaurantAdapter(getActivity().getApplicationContext(), getRestaurantList());

        DishAdapter adapter = new DishAdapter(getActivity().getApplicationContext(), getDishList());
//        rstntListView.addItemDecoration(new MarginDecoration(this));
//        rstntListView.setHasFixedSize(true);
//        rstntListView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        rstntListView.setAdapter(adapter);
        rstntListView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }
    private ArrayList<Restaurant> getRestaurantList()
    {
        ArrayList<Restaurant> lstRestaurant = new ArrayList<Restaurant>();
        for(int i=0 ; i<50 ; i++)
        {
            Restaurant rstnt = new Restaurant();
            rstnt.setDisplayArea("Location");
            rstnt.setName("Restaurant Name");
            lstRestaurant.add(rstnt);
        }
        return lstRestaurant;
    }
    private ArrayList<Dish> getDishList()
    {
        ArrayList<Dish> lstDish = new ArrayList<Dish>();
        for(int i=0 ; i<50 ; i++)
        {
            Dish dish = new Dish();
            dish.setName("Ginger Garlic Bread");
            dish.setPrice(120);
            lstDish.add(dish);
        }
        return lstDish;
    }
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
