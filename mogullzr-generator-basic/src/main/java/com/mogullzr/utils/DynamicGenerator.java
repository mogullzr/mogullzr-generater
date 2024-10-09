package com.mogullzr.utils;

import com.mogullzr.models.TemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;


public class DynamicGenerator {
    public static void main(String[] args) throws IOException, TemplateException {
        // new 一个 Configuration 对象，参数是版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

        // 指定模版文件的路径
        configuration.setDirectoryForTemplateLoading(new File("F:\\定制化代码生成器\\mogullzr-generater\\mogullzr-generater\\mogullzr-generator-basic\\src\\main\\resources\\template"));

        //设置模版文件使用的字符集
        configuration.setDefaultEncoding("utf-8");

        // 加载模版文件
        Template template = configuration.getTemplate("AcmTemplate.java.ftl");

        // 开始准备造需要喂的数据
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setAuthor("Mogullzr");
        templateConfig.setLoop(false);
        templateConfig.setOutputText("两数之和为：");

        // 指定需要生成的文件
        Writer out = new FileWriter("AcmTemplate.java");
        template.process(templateConfig, out);

        out.close();

    }
}
