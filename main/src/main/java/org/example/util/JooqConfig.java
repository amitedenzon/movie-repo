package org.example.util;

import org.jooq.Configuration;
import org.jooq.ConnectionProvider;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultRecordMapperProvider;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class JooqConfig {

    @Bean
    public Configuration jooqConfiguration(org.springframework.jdbc.datasource.DataSourceTransactionManager txManager) {
        return new DefaultConfiguration()
                .set(SQLDialect.POSTGRES) // Adjust SQLDialect to your database
                .set(new DefaultRecordMapperProvider())
                .set((ConnectionProvider) txManager);
    }
}
