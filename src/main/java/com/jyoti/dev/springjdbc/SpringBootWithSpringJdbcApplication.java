package com.jyoti.dev.springjdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWithSpringJdbcApplication{
	/*@Autowired
    DataSource dataSource;

    @Autowired
    ApiRepository apiRepository;*/

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithSpringJdbcApplication.class, args);
	}
	/*@Override
	public void run(String... args) throws Exception {

        System.out.println("DATASOURCE = " + dataSource);

        /// Get dbcp2 datasource settings
        // BasicDataSource newds = (BasicDataSource) dataSource;
        // System.out.println("BasicDataSource = " + newds.getInitialSize());

        System.out.println("Display all customers...");
        List<ApiModel> list = apiRepository.findAll();
        list.forEach(x -> System.out.println(x));

        System.out.println("Done!");

        exit(0);
    }*/
}
