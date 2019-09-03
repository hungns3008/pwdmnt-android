package hungnguyen.com.demo.binding;

import android.databinding.BindingAdapter;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;

import javax.inject.Inject;

public class FragmentBindingAdapter {

  final Fragment fragment;

  @Inject
  public FragmentBindingAdapter(Fragment fragment) {
    this.fragment =fragment;
  }

  @BindingAdapter("visibleGone")
  public void visibleGone(View v, boolean isVisible) {
    v.setVisibility(isVisible ? View.VISIBLE : View.GONE);
  }
}
