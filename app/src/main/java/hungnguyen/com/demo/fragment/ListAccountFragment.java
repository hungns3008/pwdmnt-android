package hungnguyen.com.demo.fragment;


import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import common.NavigationController;
import hungnguyen.com.demo.R;
import hungnguyen.com.demo.adapter.AccountAdapter;
import hungnguyen.com.demo.databinding.FragmentListAccountBinding;
import hungnguyen.com.demo.di.Injectable;
import hungnguyen.com.demo.entity.Account;
import hungnguyen.com.demo.entity.DividerItemDecoration;
import hungnguyen.com.demo.viewmodel.ListAccountViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListAccountFragment extends BaseFragment implements Injectable, AccountAdapter.Listener {

    @Inject
    NavigationController mNav;
    FragmentListAccountBinding binding;

    ListAccountViewModel viewModel;
    AccountAdapter adapter;

    public ListAccountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list_account, container, false, dataBindingComponent);
        adapter = new AccountAdapter(dataBindingComponent, this);
        binding.recyclerView.addItemDecoration(new DividerItemDecoration(container.getContext()));

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext(), LinearLayoutManager.VERTICAL, false));
        binding.recyclerView.setAdapter(adapter);

        binding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNav.navigateToCreateNewAccount();
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ListAccountViewModel.class);
        viewModel.getListAccounts().observe(this, listAccounts -> {
            adapter.replace(listAccounts);
        });
    }

    @Override
    public void onClick(long accountID) {
        mNav.navigateToAccountDetail(accountID);
    }
}
