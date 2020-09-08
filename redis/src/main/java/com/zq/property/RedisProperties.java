package com.zq.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@ConfigurationProperties(prefix = "spring.redis")
@Component
public class RedisProperties {

    private String password;
    private String timeout;
    private String database;

    public Cluster getCluster() {
        return cluster;
    }

    public void setCluster(Cluster cluster) {
        this.cluster = cluster;
    }

    public Pool getPool() {
        return pool;
    }

    public void setPool(Pool pool) {
        this.pool = pool;
    }

    private Cluster cluster;
    private  Pool pool;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTimeout() {
        return timeout;
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }



    public static class Cluster{
        private String nodes;
        private String maxRedirects;

        public String getNodes() {
            return nodes;
        }

        public void setNodes(String nodes) {
            this.nodes = nodes;
        }

        public String getMaxRedirects() {
            return maxRedirects;
        }

        public void setMaxRedirects(String maxRedirects) {
            this.maxRedirects = maxRedirects;
        }
    }


    public static class Pool{
        private String maxActive;
        private String maxIdle;
        private String minIdle;
        private String maxWait;

        public String getMaxActive() {
            return maxActive;
        }

        public void setMaxActive(String maxActive) {
            this.maxActive = maxActive;
        }

        public String getMaxIdle() {
            return maxIdle;
        }

        public void setMaxIdle(String maxIdle) {
            this.maxIdle = maxIdle;
        }

        public String getMinIdle() {
            return minIdle;
        }

        public void setMinIdle(String minIdle) {
            this.minIdle = minIdle;
        }

        public String getMaxWait() {
            return maxWait;
        }

        public void setMaxWait(String maxWait) {
            this.maxWait = maxWait;
        }

    }

}
