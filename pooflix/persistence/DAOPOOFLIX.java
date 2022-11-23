package persistence;

import java.sql.Connection;
import java.util.List;

import dominio.OBJPOOFlix;

public abstract class DAOPOOFLIX {
    protected Connection connection;

    public abstract int add(OBJPOOFlix obj);
    public abstract int update(OBJPOOFlix obj);
    public abstract int remove(OBJPOOFlix obj);
    public abstract List<OBJPOOFlix> lista();
}
