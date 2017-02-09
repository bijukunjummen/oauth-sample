//package org.bk.auth.config;
//
//import org.springframework.cloud.Cloud;
//import org.springframework.cloud.CloudFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//
//import javax.sql.DataSource;
//
//@Configuration
//@Profile("cloud")
//public  class CloudFoundryDatabaseConfig {
//
//    @Bean
//    public Cloud cloud() {
//        return new CloudFactory().getCloud();
//    }
//
//    @Bean
//    public DataSource dataSource() {
//        DataSource dataSource = cloud().getSingletonServiceConnector(DataSource.class, null);
//        return dataSource;
//    }
//}