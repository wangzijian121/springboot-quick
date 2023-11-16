import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    private static final String DRIVER_NAME = "com.aliyun.odps.jdbc.OdpsDriver";
    private static String accessId = System.getenv("ALIBABA_CLOUD_ACCESS_KEY_ID");
    private static String accessKey = System.getenv("ALIBABA_CLOUD_ACCESS_KEY_SECRET");
    public static void main(String[] args) throws SQLException {
        try {
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户
        // 此处以把AccessKey 和 AccessKeySecret 保存在环境变量为例说明。您也可以根据业务需要，保存到配置文件里
        // 强烈建议不要把 AccessKey 和 AccessKeySecret 保存到代码里，会存在密钥泄漏风险

        Connection conn = DriverManager.getConnection(
                "jdbc:odps:<maxcompute_endpoint>?project=<maxcompute_project>",
                "accessId", "accessKey");
        // create a table
        Statement stmt = conn.createStatement();
        final String tableName = "jdbc_test";
        stmt.execute("DROP TABLE IF EXISTS " + tableName);
        stmt.execute("CREATE TABLE " + tableName + " (key BIGINT, value STRING)");

        // get meta data
        DatabaseMetaData metaData = conn.getMetaData();
        System.out.println("product = " + metaData.getDatabaseProductName());
        System.out.println("jdbc version = "
                + metaData.getDriverMajorVersion() + ", "
                + metaData.getDriverMinorVersion());
        ResultSet tables = metaData.getTables(null, null, tableName, null);
        while (tables.next()) {
            String name = tables.getString("TABLE_NAME");
            System.out.println("inspecting table: " + name);
            ResultSet columns = metaData.getColumns(null, null, name, null);
            while (columns.next()) {
                System.out.println(
                        columns.getString("COLUMN_NAME") + "\t" +
                                columns.getString("TYPE_NAME") + "(" +
                                columns.getInt("DATA_TYPE") + ")");
            }
            columns.close();
        }
        tables.close();
        stmt.close();
        conn.close();
    }
}