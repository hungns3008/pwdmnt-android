package hungnguyen.com.demo.fragment;


import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hungnguyen.com.demo.R;
import hungnguyen.com.demo.databinding.FragmentDetailBinding;
import hungnguyen.com.demo.di.Injectable;
import hungnguyen.com.demo.viewmodel.DetailViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends BaseFragment implements Injectable {

    FragmentDetailBinding binding;
    DetailViewModel viewModel;
    long accountID;
    private static final String ACCOUNT_ID = "ACCOUNT_ID";


    public static DetailFragment instance(long accountID) {
        DetailFragment fragment = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putLong(ACCOUNT_ID, accountID);

        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Bundle bundle = getArguments();
        long accountID = bundle.getLong(ACCOUNT_ID);

        this.accountID = accountID;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false, dataBindingComponent);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(DetailViewModel.class);

        viewModel.getAccount(accountID).observe(this, account -> {
            binding.setItem(account);
        });
    }
}
