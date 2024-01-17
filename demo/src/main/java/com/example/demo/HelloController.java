package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
// import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties.Data;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.Map;



@RestController
public class HelloController {
    @GetMapping("/")
    public String helloWorld() {
        return "Simple SpringBoot Application!";
    }
    
    @GetMapping("/bookings")
    public String getBookings() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");
        DataSource ds = (DataSource)applicationContext.getBean("dataSource");
        JdbcTemplate jt = new JdbcTemplate(ds);
        String sql_query = "select * from pod_booking;";
        List<Map <String, Object>> bookings = jt.queryForList(sql_query);
        return "Testing Postgres JDBC";
    }
    
}
