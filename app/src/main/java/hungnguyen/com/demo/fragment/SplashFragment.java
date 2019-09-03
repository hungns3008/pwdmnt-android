package hungnguyen.com.demo.fragment;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import hungnguyen.com.demo.MainActivity;
import hungnguyen.com.demo.R;
import hungnguyen.com.demo.databinding.SplashFragmentBinding;
import hungnguyen.com.demo.di.Injectable;

import javax.inject.Inject;

public class SplashFragment extends BaseFragment implements Injectable {

  @Inject
  ViewModelProvider.Factory viewModelFactory;

  SplashFragmentBinding binding;

  private SplashViewModel mViewModel;

  public static SplashFragment newInstance() {
    return new SplashFragment();
  }

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    binding = DataBindingUtil
        .inflate(inflater, R.layout.splash_fragment, container, false, dataBindingComponent);

    return binding.getRoot();
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    mViewModel = ViewModelProviders.of(this, viewModelFactory).get(SplashViewModel.class);

    gotoMainActivity();


  }

  private void gotoMainActivity() {
    startActivity(new Intent(getActivity(), MainActivity.class));
  }

}
