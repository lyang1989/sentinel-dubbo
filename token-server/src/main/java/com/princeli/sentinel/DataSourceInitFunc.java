package com.princeli.sentinel;

import com.alibaba.csp.sentinel.cluster.flow.rule.ClusterFlowRuleManager;
import com.alibaba.csp.sentinel.datasource.ReadableDataSource;
import com.alibaba.csp.sentinel.datasource.nacos.NacosDataSource;
import com.alibaba.csp.sentinel.init.InitFunc;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.List;

/**
 * @author : princeli
 * @version 1.0
 * @className DataSourceInitFunc
 * @date 2019-10-27 14:49
 * @description: TODO
 */
public class DataSourceInitFunc implements InitFunc {


    private final String remoteAddress = "127.0.0.1"; //nacos配置中心服务
    private final String groupId = "SENTINEL_GROUP";
    private final String FLOW_POSTFIX = "-flow-rules";  //dataid


    /**
     * 从nacos获取限流规则
     * @throws Exception
     */
    @Override
    public void init() throws Exception {
        ClusterFlowRuleManager.setPropertySupplier(namespace ->{
            ReadableDataSource<String, List<FlowRule>> rds =
                    new NacosDataSource<List<FlowRule>>(remoteAddress,groupId,namespace+FLOW_POSTFIX,
                            source -> JSON.parseObject(source,new TypeReference<List<FlowRule>>(){}));
            return rds.getProperty();
        });
    }
}
