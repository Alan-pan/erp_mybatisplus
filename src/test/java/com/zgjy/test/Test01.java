package com.zgjy.test;

import org.junit.Test;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class Test01 {
	@Test
	public void testGenerator() {
		// 全局配置
		GlobalConfig config = new GlobalConfig();
		config.setActiveRecord(true) // 是否支持AR模式
				.setAuthor("yupan") // 作者
				.setOutputDir("D:\\IDEAWorkSpace\\erp\\src\\main\\java")// 生成路径
				.setFileOverride(true)// 第二次生成是否文件覆盖
				.setServiceName("%sService") // 设置生成的service接口名:是否为I开头接口,使用后非I开始
				.setIdType(IdType.AUTO)	// 主键策略
				.setBaseResultMap(true)
				.setBaseColumnList(true)
				; 
		// 数据源配置
		DataSourceConfig dsConfig = new DataSourceConfig();
		dsConfig.setDbType(DbType.MYSQL)
				.setUrl("jdbc:mysql://localhost:3306/erp")
				.setDriverName("com.mysql.jdbc.Driver")
				.setUsername("root")
				.setPassword("root")
				;
		//配置的表
		String[] tables=new String[]{"t_dept","t_emp","t_emp_role","t_goods",
						"t_goods_category","t_inventory","t_menu","t_order",
				"t_orderdetail","t_role","t_role_menu","t_store","t_storedetail","t_storeoper","t_supplier"};
		// 策略配置
		StrategyConfig stConfig = new StrategyConfig();
		stConfig.setCapitalMode(true) // 全局大写命名
				.setDbColumnUnderline(true) // 表名 字段名 是否使用_
				.setNaming(NamingStrategy.underline_to_camel) // 下划线转驼峰命名
				.setTablePrefix("t_") // 表前缀
				.setInclude(tables); // 生成的表
		// 包名策略
		PackageConfig pkConfig = new PackageConfig();
		pkConfig.setParent("com.zgjy.erp")//父包
				.setController("controller")//控制器
				.setEntity("bean")//实体类
				.setService("service")//服务层
				.setXml("mapper")//由于有.setBaseResultMap(true).setBaseColumnList(true); 则需要指定mapper包
				;
				
		AutoGenerator ag = new AutoGenerator().setGlobalConfig(config).setDataSource(dsConfig).setStrategy(stConfig)
				.setPackageInfo(pkConfig);
		ag.execute();
	}
}
