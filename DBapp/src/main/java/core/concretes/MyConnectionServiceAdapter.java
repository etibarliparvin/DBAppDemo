package core.concretes;

import core.abstracts.MyConnectionService;
import externals.MyConnection;

import java.sql.Connection;

public class MyConnectionServiceAdapter implements MyConnectionService {
    @Override
    public Connection connect() throws Exception {
        MyConnection myConnection = new MyConnection();
        return myConnection.connect();
    }
}
