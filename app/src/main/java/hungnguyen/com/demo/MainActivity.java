package hungnguyen.com.demo;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;

import hungnguyen.com.demo.activity.BaseActivity;
import common.NavigationController;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import hungnguyen.com.demo.fragment.ListAccountFragment;

import java.util.Stack;
import javax.inject.Inject;

public class MainActivity extends BaseActivity implements HasSupportFragmentInjector {

  @Inject
  NavigationController mNavigationController;

  private Stack<String> mBackStacks = new Stack<>();

  public static final String BUNDLE_TAB_BACK_STACK = "tab_back_stacks";
  public static final String BUNDLE_TAB_POSITION = "tab_position";

  public static final int DEFAULT_TAB_POSITION = 0;

  @Inject
  DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    if (savedInstanceState == null) {

      mNavigationController.setupDefaultToolbar();
      // Setup the default tool bar
//      mNavigationController.setupDefaultToolbar();s
    } else {
      mBackStacks = (Stack<String>) savedInstanceState
          .getSerializable(BUNDLE_TAB_BACK_STACK);
    }
    mNavigationController.addFragment(new ListAccountFragment());
  }

  @Override
  public AndroidInjector<Fragment> supportFragmentInjector() {
    return dispatchingAndroidInjector;
  }

  @Nullable
  public Fragment getTopFragment() {
    Stack<String> backStack = mBackStacks;
    if (backStack.isEmpty()) {
      return null;
    }
    String tag = backStack.peek();
    FragmentManager fragmentManager = getSupportFragmentManager();
    return fragmentManager.findFragmentByTag(tag);
  }

  public void setmBackStacks(
      Stack<String> mBackStacks) {
    this.mBackStacks = mBackStacks;
  }

  @Override
  public void onBackPressed() {
    if (!mNavigationController.backPress()) {
      super.onBackPressed();
    }
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putSerializable(BUNDLE_TAB_BACK_STACK, mBackStacks);
  }

  @Override
  protected void onRestoreInstanceState(Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);

//    int saved = savedInstanceState.getInt(BUNDLE_TAB_POSITION, DEFAULT_TAB_POSITION);
//    Tab tab = mTabLayout.getTabAt(saved);
//    if (tab != null) {
//      tab.select();
//    }
  }

  public Stack<String> getCurrentBackStack() {
    return mBackStacks;
  }
}
