package per.zdb.utils;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @Description:  代码生成器演示
 * @author: Adobe Chow
 * @date: 2018/12/18 12:52
 * @Copyright: Adobe Chow Inc. All rights reserved.
 */
public class MybatisGenerator {

    public static void main(String[] args) {
        //模块名称
        String moduleName = "/module/book";
        FastAutoGenerator.create("jdbc:mysql://172.20.190.152:3306/library_system?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai", "root", "123456")
                .globalConfig(builder -> {
                    builder.author("周多兵") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
//                            .fileOverride() // 覆盖已生成文件
                            .outputDir(System.getProperty("user.dir")+moduleName+"/src/main/java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder
                            .parent("per.zdb") // 设置父包名
//                            .moduleName("system") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, System.getProperty("user.dir")+"/src/main/resources/mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
//                    builder.addInclude("t_simple") // 设置需要生成的表名
//                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }




}
