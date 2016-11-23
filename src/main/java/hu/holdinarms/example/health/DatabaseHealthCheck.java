package hu.holdinarms.example.health;

import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;

import com.codahale.metrics.health.HealthCheck;

public class DatabaseHealthCheck extends HealthCheck {

  private final DBI dbi;
  private final String validationQuery;

  public DatabaseHealthCheck(DBI dbi, String validationQuery) {
    this.dbi = dbi;
    this.validationQuery = validationQuery;
  }

  @Override
  protected Result check() {

    try {
      final Handle handle = dbi.open();

      handle.execute(validationQuery);

      handle.close();
    } catch (Exception e) {
      return Result.unhealthy("Database is not running!");
    }

    return Result.healthy();
  }
}
