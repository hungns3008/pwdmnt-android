package hungnguyen.com.demo.fragment;

import android.arch.lifecycle.ViewModelProvider;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import hungnguyen.com.demo.R;
import hungnguyen.com.demo.binding.FragmentDataBindingComponent;
import hungnguyen.com.demo.di.Injectable;
import hungnguyen.com.demo.databinding.FragmentRecycleBinding;

import javax.inject.Inject;

public class BaseFragment extends Fragment implements Injectable {
  @Inject
  public ViewModelProvider.Factory viewModelFactory;

  android.databinding.DataBindingComponent dataBindingComponent = new FragmentDataBindingComponent(this);

  public BaseFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    TextView textView = new TextView(getActivity());
    return textView;
  }

  protected FragmentRecycleBinding createDataBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
    FragmentRecycleBinding dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_recycle,
        container, false, dataBindingComponent);
    return dataBinding;
  }

}

