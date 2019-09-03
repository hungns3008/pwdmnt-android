package hungnguyen.com.demo.fragment;


import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import common.NavigationController;
import hungnguyen.com.demo.R;
import hungnguyen.com.demo.databinding.FragmentCreateNewAccountBinding;
import hungnguyen.com.demo.di.Injectable;
import hungnguyen.com.demo.utils.AlertUtils;
import hungnguyen.com.demo.viewmodel.CreateNewAccountViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateNewAccountFragment extends BaseFragment implements Injectable {

    @Inject
    NavigationController mNav;

    FragmentCreateNewAccountBinding binding;
    CreateNewAccountViewModel viewModel;
    public CreateNewAccountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_create_new_account, container, false, dataBindingComponent);
        binding.btnAddAcount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = binding.edtTitle.getText().toString();
                String username = binding.edtUsername.getText().toString();
                String password = binding.edtPassword.getText().toString();

                viewModel.createNewAccount(title, username, password);
//                viewModel.createNewUser(title, username, password);
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(CreateNewAccountViewModel.class);
        viewModel.getLiveDataStatus().observe(this, status -> {
            if (status.isSuccess()) {
                mNav.backPress();
            } else {
                AlertUtils.getInstance().showAlertGotIt(getContext(), "Error", status.getError());
            }
        });
    }
}
