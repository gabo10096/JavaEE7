package org.certificatic.ejb;

import javax.ejb.Local;

@Local
public interface HelloBean {
    String getMessageFor(String caller);
}
