package top.ycshang.basedao.enmu;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-21 15:43
 **/
public enum DataSourceEnum {
    /**
     * 数据源枚举
     */
    DATASOURCE;
    private final DbConnection connection;

    DataSourceEnum() {
        connection = new DbConnection();
    }

    public DbConnection getConnection() {
        return connection;
    }

    static class DbConnection {
        private DbConnection() {

        }
    }
}