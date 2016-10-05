package org.irenical.tubey;

import java.util.Optional;

import javax.activation.DataSource;

/**
 * A tube to some BLOB backend
 *
 */
public interface Tube {

  /**
   * Retrieves a BLOB from this backend. If requested BLOB does not exist, it's
   * up to the backend's implementation to either throw an exception or return
   * an empty {@link java.util.Optional}
   * 
   * @param id
   *          the BLOB identifier
   * @return an optional {@link javax.activation.DataSource} to the requested
   *         BLOB
   * @throws ERROR
   *           some backend specific error
   */
  <ERROR extends Exception> Optional<DataSource> get(String id) throws ERROR;

  /**
   * Stores given data into this backend
   * 
   * @param id
   *          the BLOB identifier
   * @param data
   *          the BLOB contents
   * @return a {@link javax.activation.DataSource} capable of reporting the BLOB
   *         size
   * @throws ERROR
   *           some backend specific error
   */
  <ERROR extends Exception> FiniteDataSource put(String id, DataSource data) throws ERROR;

  /**
   * Removes the BLOB from this backend
   * 
   * @param id
   *          the BLOB identifier
   * @return whether the delete was successful
   * @throws ERROR
   *           some backend specific error
   */
  <ERROR extends Exception> boolean delete(String id) throws ERROR;

}
