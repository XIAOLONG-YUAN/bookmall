package com.yuan.bookmall.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

import java.io.File;

/**
 * <p>
 * 测试生成代码
 * </p>
 *
 * @author YXL
 *
 */
public class GeneratorServiceEntity {

    private  static final String URL = "jdbc:mysql://47.101.221.57:10050/IONBase?useUnicode=true&characterEncoding=utf8&useSSL=false";

    private  static final String USER_NAME = "root";

    private static final String PASS_WORD = "1qaz@WSX";

    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";

    @Test
    public void generateCode() {
        String path = new File(System.getProperty("user.dir")).getParent()+"\\yuan-activity-plan";
        String packageName = "com.yuan.bookmall";
        String moduleName = "scTest";
        String[] tableNames = {"SC_TEST"};   //表名[]，需要修改
        boolean serviceNameStartWithI = false;//user -> UserService, 设置成true: user -> IUserService
        generateByTables(serviceNameStartWithI, packageName,moduleName,path,tableNames);
    }

    private void generateByTables(boolean serviceNameStartWithI, String packageName, String moduleName,String path, String... tableNames){
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 选择 freemarker 引擎，默认 Veloctiy
        // mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        // 全局配置
        GlobalConfig config = new GlobalConfig();
        String currentPath = System.getProperty("user.dir");
        String outPutDir = path == null ? currentPath : path;
        config.setOutputDir(outPutDir+"\\src\\main\\java")
            .setFileOverride(false)  //TODO 是否覆盖已有文件
            .setOpen(false)         //是否打开输出目录
            .setActiveRecord(false) // 不需要ActiveRecord特性的请改为false
            .setEnableCache(false)  // XML 二级缓存
            .setBaseResultMap(true) // XML ResultMap
            .setBaseColumnList(true)// XML columList
             .setSwagger2(true)
            .setAuthor("yxl");
        if (!serviceNameStartWithI) {
            // 自定义文件命名，注意 %s 会自动填充表实体属性！
            // config.setMapperName("%sDao");
            // config.setXmlName("%sDao");
            // config.setServiceName("%sService");
            // config.setServiceImplName("%sServiceDiy");
            // config.setControllerName("%sAction");
            config.setServiceName("%sService");
        }
        mpg.setGlobalConfig(config);

        //数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        //更改数据库的时候要更改这个
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(URL)
                .setUsername(USER_NAME)
                .setPassword(PASS_WORD)
                .setDriverName(DRIVER_NAME);
        mpg.setDataSource(dataSourceConfig);



        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true)  // strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
                .setEntityLombokModel(true)  //是否为lombok模型
                .setRestControllerStyle(true)
                .setNaming(NamingStrategy.underline_to_camel)// 表名生成策略
                //.setEntityTableFieldAnnotationEnable(true)
                .setLogicDeleteFieldName("SC_DELFLAG")
                .setInclude(tableNames);//修改替换成你需要的表名，多个表名传数组
        mpg.setStrategy(strategyConfig);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(packageName)
            //.setModuleName(moduleName)
            .setController("controller."+moduleName)
                .setService("service."+moduleName)
                .setServiceImpl("service."+moduleName+".impl")
                .setMapper("mapper."+moduleName)
                .setXml("mapper."+moduleName+".mappers")
                .setEntity("pojo."+moduleName);
        mpg.setPackageInfo(pc);

        mpg.execute();
    }
}
