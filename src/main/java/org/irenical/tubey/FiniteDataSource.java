package org.irenical.tubey;

import javax.activation.DataSource;

public interface FiniteDataSource extends DataSource {
  
  /**
   * Retrieves the size of the stream
   * @return the number of bytes
   */
  Long getLength();

}
