package hungnguyen.com.demo.repository;

import hungnguyen.com.demo.executor.AppExecutors;
import javax.inject.Inject;

public class SplashRepository {
  AppExecutors executors;

  @Inject
  public SplashRepository(AppExecutors executors) {
    this.executors = executors;
  }
}
