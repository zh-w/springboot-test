package com.wz.test.SpringbootTest.mybatis.mapper;

import com.wz.test.SpringbootTest.mybatis.entity.MetricKey;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface MetricKeyMapper {

    List<MetricKey> getMetricKeyByKey(String host, String metricKey);

    Integer insertMetricKey(MetricKey metricKey);

}
