package org.monkey.springbootdemo.common.component;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;


/**
 * MyUserDetailServiceTest
 *
 * @author cc
 * @since 2024/10/19 14:40
 */
public class MyUserDetailServiceTest {

    public static void main(String[] args) {
        String sourceFile = "E:\\tmp\\idea-plugin\\source_json.txt";
        List<String> lines = FileUtil.readLines(new File(sourceFile), StandardCharsets.UTF_8);
        if (lines.size() != 3) {
            System.out.println("源文件内容不正确");
            return;
        }
        String className = lines.get(0);
        String packageName = lines.get(1);
        String json = lines.get(2);

        ObjectNode jsonNode = null;
        ObjectMapper mapper = new ObjectMapper();

        try {
            jsonNode = (ObjectNode) mapper.readTree(json);
        } catch (IOException e) {
            System.out.println("原始JSON格式不正确");
            e.printStackTrace();
            return;
        }
        if (jsonNode == null) {
            System.out.println("原始JSON为空");
            return;
        }
        try {
            String javaCode = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
            String filePath = "./" + className + ".java"; // 生成的文件路径

            // 生成Java类文件
            File javaFile = new File(filePath);
            javaFile.getParentFile().mkdirs();
            javaFile.createNewFile();

            // 写入Java类代码
            FileWriter fileWriter = new FileWriter(javaFile);
            fileWriter.write("public class " + className + " {\n");
            fileWriter.write(javaCode.replace(":", " ").replace("\"", ""));
            fileWriter.write("\n}");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Entity class generated successfully.");

    }
}