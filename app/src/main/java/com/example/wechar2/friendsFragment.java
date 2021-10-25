package com.example.wechar2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wechar2.adapter.RecyclerViewAdapter;
import com.example.wechar2.data.item_data_bean;

import java.util.ArrayList;
import java.util.List;

import com.example.wechar2.data.item_datas_icons;
import com.example.wechar2.data.item_datas_titles;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link friendsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class friendsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private List<item_data_bean> mData;
    private View view;


    public friendsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment friendsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static friendsFragment newInstance(String param1, String param2) {
        friendsFragment fragment = new friendsFragment();
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
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_tab_friends,container,false);
        //数据准备
        initData();

        //将数据与布局绑定
        initView();

//        return inflater.inflate(R.layout.fragment_tab_friends, container, false);
        return view;
    }

    private void initView() {
        RecyclerView recyclerView = view.findViewById(R.id.fri_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getContext(),mData);

        recyclerView.setAdapter(adapter);

        recyclerView.setHasFixedSize(true);


    }

    private void initData() {
        mData = new ArrayList<>();
        //将item_datas_icons和item_datas_titles中的数据放入mData中
        for (int i = 0; i < item_datas_icons.icons.length && i < item_datas_titles.titles.length; i++){
            //分别从两个存放数据的类中获取数据
            item_data_bean itemdata = new item_data_bean();
            itemdata.icons = item_datas_icons.icons[i];
            itemdata.title = item_datas_titles.titles[i];
            //将集合添加到列表
            mData.add(itemdata);
        }
    }


}