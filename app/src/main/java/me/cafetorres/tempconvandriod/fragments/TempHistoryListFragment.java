package me.cafetorres.tempconvandriod.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.cafetorres.tempconvandriod.R;
import me.cafetorres.tempconvandriod.adapters.OnItemClickListener;
import me.cafetorres.tempconvandriod.adapters.TempAdapter;
import me.cafetorres.tempconvandriod.models.Temperature;

/**
 * Created by Carlos on 10/11/2016.
 */

public class TempHistoryListFragment extends Fragment implements TempHistoryListFragmentListener,OnItemClickListener {
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    TempAdapter adapter;
    public TempHistoryListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.frame_temp_history_list, container, false);
        ButterKnife.bind(this, view);
        initAdapter();
        initRecyclerView();
        return view;

    }

    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }

    private void initAdapter() {
        if(adapter == null) {
            adapter = new TempAdapter(getActivity().getApplicationContext(), this);
        }
    }

    @Override
    public void onItemClick(Temperature temperature) {
        Intent intent = new Intent(getActivity(), Temperature.class);
        intent.putExtra("Temperature", temperature.getTempOut());
        intent.putExtra("Date", temperature.getDateFormated());

        startActivity(intent);
    }

    @Override
    public void addToList(Temperature temperatute) {
        adapter.add(temperatute);
    }

    @Override
    public void clearList() {
        adapter.clear();
    }
}
