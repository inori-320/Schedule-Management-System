package DAO;

import utils.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author lty
 */
public class BasicDAO<T> {
    private QueryRunner queryRunner = new QueryRunner();
    private Connection connection = null;

    public int dml(String sql, Object... params){
        int affections = 0;
        connection = JDBCUtil.getConnection();
        try {
            affections = queryRunner.update(connection, sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.close(connection, null, null);
        }
        return affections;
    }
    public List<T> queryMulti(String sql, Class<T> cls, Object... params){
        List<T> list;
        connection = JDBCUtil.getConnection();
        try {
            list = queryRunner.query(connection, sql, new BeanListHandler<>(cls), params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.close(connection, null, null);
        }
        return list;
    }

    public T querySingle(String sql, Class<T> cls, Object... params){
        T obj;
        connection = JDBCUtil.getConnection();
        try {
            obj = queryRunner.query(connection, sql, new BeanHandler<>(cls), params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.close(connection, null, null);
        }
        return obj;
    }

    public Object queryScalar(String sql, Object... params){
        Object obj;
        connection = JDBCUtil.getConnection();
        try {
            obj = queryRunner.query(sql, new ScalarHandler<>(),params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.close(connection, null, null);
        }
        return obj;
    }
}
