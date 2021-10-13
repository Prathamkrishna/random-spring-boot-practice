package com.example.demo.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class resource {

    private final JdbcTemplate jdbcTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public resource(JdbcTemplate jdbcTemplate, ObjectMapper objectMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.objectMapper = objectMapper;
    }

    private int num = 0;

    public void updateDatabase() throws Exception{
        Integer i1 = jdbcTemplate.queryForObject("SELECT id FROM prat ORDER BY id DESC limit 1;", Integer.class);
        System.out.println(i1);
//        final String sql = "INSERT INTO prat (id, name) VALUES (" + num +  " , 'random');";
//        int rows = jdbcTemplate.update(sql);
//        if(rows > 0){
//            System.out.println(rows);
//            System.out.println(jdbcTemplate.queryForList("SELECT LAST(id) FROM prat"));
//        }
        num++;
    }

}
