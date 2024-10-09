import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreeMarkerTest {
    @Test
    public void test() throws IOException, TemplateException {
        // new 一个 Configuration 对象，参数是版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

        // 指定模版文件的路径
        configuration.setDirectoryForTemplateLoading(new File("src/main/resources/template"));

        //设置模版文件使用的字符集
        configuration.setDefaultEncoding("utf-8");

        // 加载模版文件
        Template template = configuration.getTemplate("test.html.ftl");

        // 开始准备造需要喂的数据
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("currentYear", 2024);

        List<Map<String, Object>> Items = new ArrayList<>();
        Map<String, Object> item1 = new HashMap<>();
        item1.put("地址", "https://www.rzcode.top");
        item1.put("用户名", "Mogullzr");

        Map<String, Object> item2 = new HashMap<>();
        item2.put("地址", "https://github.com/mogullzr");
        item2.put("用户名", "Mogullzr");

        Map<String, Object> item3 = new HashMap<>();
        item3.put("地址", "https://www.byteoj.com");
        item3.put("用户名", "Mogullzr");

        Items.add(item1);
        Items.add(item2);
        Items.add(item3);

        dataModel.put("Items", Items);

        // 指定需要生成的文件
        Writer out = new FileWriter("test.html");
        template.process(dataModel, out);

        out.close();
    }
}
