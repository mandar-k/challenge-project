package com.robotics.inc.inventory.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@Configuration
@EnableCouchbaseRepositories(basePackages = {"com.robotics.inc.inventory"})
@ConfigurationProperties(prefix = "couchbase.cluster")
@Slf4j
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {


    @Value("${couchbase.cluster.ip}")
    private String ip;

    @Value("${couchbase.cluster.bucket.name}")
    private String bucketName;

    @Value("${couchbase.cluster.user.name}")
    private String userName;

    @Value("${couchbase.cluster.bucket.password}")
    private String password;


    @Override
    public String getConnectionString() {
        return "couchbase://" + this.ip;
    }

    @Override
    public String getUserName() {
        return this.userName;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getBucketName() {
        return this.bucketName;
    }
}
