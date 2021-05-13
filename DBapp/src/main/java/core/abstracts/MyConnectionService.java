package core.abstracts;

import java.sql.Connection;

public interface MyConnectionService {

    Connection connect() throws Exception;

}
