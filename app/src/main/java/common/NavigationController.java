package common;

import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import hungnguyen.com.demo.MainActivity;
import hungnguyen.com.demo.R;

import java.util.Stack;
import java.util.UUID;
import javax.inject.Inject;

import hungnguyen.com.demo.fragment.CreateNewAccountFragment;
import hungnguyen.com.demo.fragment.DetailFragment;
import hungnguyen.com.demo.fragment.ListAccountFragment;
import widget.CenteredToolbar;

public class NavigationController {
  private final FragmentManager fragmentManager;
  private final MainActivity mActivity;
  private final int containerId;

  @Inject
  public NavigationController(MainActivity mainActivity) {
    this.fragmentManager = mainActivity.getSupportFragmentManager();
    this.mActivity = mainActivity;
    this.containerId = R.id.container;
  }

  public void addFragment(Fragment fragment) {
    addFragment(fragment, mActivity.getCurrentBackStack());
  }

  private void addFragment(Fragment fragment, Stack<String> backStack) {
    String tag = UUID.randomUUID().toString();
    fragmentManager.beginTransaction()
        .add(containerId, fragment, tag)
        .commitAllowingStateLoss();
    backStack.push(tag);
  }

  public void showTitle(String title) {
    CenteredToolbar centeredToolbar = mActivity.findViewById(R.id.toolbar);
    centeredToolbar.setVisibility(View.VISIBLE);

    mActivity.findViewById(R.id.search_bar).setVisibility(View.GONE);

    centeredToolbar.showTitle(title);
  }

  public boolean backPress() {
    Stack<String> backStack = mActivity.getCurrentBackStack();

    if (backStack.isEmpty()) {
      return true;
    }

    String tag = backStack.pop();
    Fragment fragment = fragmentManager.findFragmentByTag(tag);

    if (fragment instanceof ListAccountFragment) {
      backStack.push(tag);
      return true;
    }

    if (backStack.isEmpty()) {
      return true;
    }

    fragmentManager.beginTransaction().remove(fragment).commitAllowingStateLoss();
    showFragment(backStack);

    tag = backStack.peek();
    fragment = fragmentManager.findFragmentByTag(tag);

    managementToolbar(fragment);

    return true;
  }
  public void setupDefaultToolbar() {
    Toolbar toolbar = mActivity.findViewById(R.id.toolbar);
    mActivity.setSupportActionBar(toolbar);
    AppBarLayout.LayoutParams params = (AppBarLayout.LayoutParams) toolbar.getLayoutParams();
    params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED);
    toolbar.setLayoutParams(params);
  }

  private void showFragment(Stack<String> backStack) {
    if (backStack.isEmpty()) {
      return;
    }
    String tag = backStack.peek();
    Fragment fragment = fragmentManager.findFragmentByTag(tag);
    fragmentManager.beginTransaction()
        .attach(fragment)
        .commitAllowingStateLoss();
  }

  public void managementToolbar(Fragment fragment) {
    Fragment fragmentTop = mActivity.getTopFragment();
    if (fragment != fragmentTop) {
      return;
    }
    if (fragment instanceof ITitle){
      showTitleToolbar(((ITitle) fragment).getTitle());
    }
  }

  public void navigateToCreateNewAccount() {
    CreateNewAccountFragment fragment = new CreateNewAccountFragment();
    addFragment(fragment);
  }

  public void navigateToAccountDetail(long accountID) {
    DetailFragment fragment = DetailFragment.instance(accountID);
    addFragment(fragment);
  }

  private void  showTitleToolbar(String title) {
    showTitle(title);
  }
}
