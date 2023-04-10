package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 将建表语句转为MD 格式的小工具
 *
 */
public class CreateTableToMarkdown {
    public static void main(String[] args) {
        String createTableSql = "CREATE TABLE `ddc_event` (\n" +
                "  `id` varchar(32) DEFAULT NULL,\n" +
                "  `type` varchar(255) DEFAULT NULL,\n" +
                "  `action` varchar(255) DEFAULT NULL,\n" +
                "  `message` varchar(255) DEFAULT NULL,\n" +
                "  `comment` varchar(255) DEFAULT NULL,\n" +
                "  `create_time` datetime DEFAULT NULL\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci";

        String mdTable = createMarkdownTable(createTableSql);
        System.out.println(mdTable);
    }

    public static String createMarkdownTable(String createTableSql) {
        StringBuilder mdBuilder = new StringBuilder();

        // 添加表格标题
        mdBuilder.append("| Field | Type | Constraints |\n");
        mdBuilder.append("| ----- | ---- | ----------- |\n");

        // 匹配字段名称、数据类型和长度
        Pattern pattern = Pattern.compile("`(.+?)`\\s+(\\w+)(?:\\((\\d+)\\))?");
        Matcher matcher = pattern.matcher(createTableSql);
        while (matcher.find()) {
            // 获取字段名称、数据类型和长度
            String fieldName = matcher.group(1);
            String fieldType = matcher.group(2);
            String fieldLength = matcher.group(3);

            // 如果有长度信息，将其添加到类型后面
            if (fieldLength != null) {
                fieldType += "(" + fieldLength + ")";
            }

            // 拼接Markdown表格行
            mdBuilder.append("| ");
            mdBuilder.append(fieldName);
            mdBuilder.append(" | ");
            mdBuilder.append(fieldType);
            mdBuilder.append(" |  |\n"); // 这里没有约束，留空

        }

        return mdBuilder.toString();
    }
}
