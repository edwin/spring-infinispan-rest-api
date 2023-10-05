package com.edw.config;

import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
import org.infinispan.commons.marshall.ProtoStreamMarshaller;
import org.infinispan.configuration.cache.CacheMode;
import org.infinispan.configuration.cache.StorageType;
import org.infinispan.persistence.jdbc.common.DatabaseType;
import org.infinispan.persistence.sql.configuration.TableJdbcStoreConfigurationBuilder;
import org.infinispan.spring.starter.remote.InfinispanRemoteCacheCustomizer;
import org.infinispan.spring.starter.remote.InfinispanRemoteCacheManagerAutoConfiguration;
import org.infinispan.util.concurrent.IsolationLevel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * <pre>
 *     com.edw.config.InfinispanConfiguration
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 05 Okt 2023 10:25
 */
@Configuration
public class InfinispanConfiguration {
    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public InfinispanRemoteCacheCustomizer remoteCacheCustomizer() {
        return b -> {
            b.remoteCache("some-cache").marshaller(ProtoStreamMarshaller.class);
        };
    }
}
