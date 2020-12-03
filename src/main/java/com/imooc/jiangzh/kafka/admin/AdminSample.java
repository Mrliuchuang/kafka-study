package com.imooc.jiangzh.kafka.admin;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;

import java.util.Arrays;
import java.util.Properties;
public class AdminSample {
    public final static String TOPIC_NAME="jiangzh-topic";
    public static void main(String[] args) throws Exception {
    //    AdminClient adminClient = AdminSample.adminClient();
      //  System.out.println("adminClient : "+ adminClient);
        // 创建Topic实例
        createTopic();
        // 删除Topic实例
//        delTopics();
        // 获取Topic列表
//        topicLists();
        // 描述Topic

        // 修改Config
//        alterConfig();
        // 查询Config
//        describeConfig();
        // 增加partition数量
//        incrPartitions(2);
    }
    /*
        创建Topic实例
     */
    public static void createTopic() {
        AdminClient adminClient = adminClient();
        // 副本因子
        Short rs = 1;
        NewTopic newTopic = new NewTopic(TOPIC_NAME, 1 , rs);
        CreateTopicsResult topics = adminClient.createTopics(Arrays.asList(newTopic));
        System.out.println("CreateTopicsResult : "+ topics);
    }
    /*
        设置AdminClient
     */
    public static AdminClient adminClient(){
        Properties properties = new Properties();
        properties.setProperty(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,"47.106.205.4:9092");
        AdminClient adminClient = AdminClient.create(properties);
        return adminClient;
    }
}
