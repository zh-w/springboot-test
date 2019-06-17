package com.wz.test.SpringbootTest.mybatis.entity;

public class MetricKey {

    /**
     * id
     */
    private Long id;

    /**
     * 指标值对应主机ip
     */
    private String host;

    /**
     * 指标所属的key
     */
    private String metricKey;

    /**
     * 该项指标使用的算法
     */
    private String algorithm;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMetricKey() {
        return metricKey;
    }

    public void setMetricKey(String metricKey) {
        this.metricKey = metricKey;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }


    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    @Override
    public String toString() {
        return "MetricKey{" + "id=" + id + ", host='" + host + '\'' + ", metricKey='" + metricKey
                + '\'' + ", algorithm='" + algorithm + '\'' + '}';
    }

}

