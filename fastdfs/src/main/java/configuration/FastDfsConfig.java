package configuration;

import org.csource.fastdfs.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetSocketAddress;

@Configuration
public class FastDfsConfig {

    @Value("${fastdfs.tracker-server}")
    private String trackerServer;

    @Value("${fastdfs.port}")
    private String port;


    @Bean
    public boolean initFastdfs(){
        try {
            // ClientGlobal.init("D:\\fdfs_client.conf");
              /*
         * 也可以使用代码设置配置
         // 连接超时的时限
        ClientGlobal.setG_connect_timeout(2);
        // 网络超时的时限，单位为秒
        ClientGlobal.setG_network_timeout(30);
        ClientGlobal.setG_anti_steal_token(false);
        // 字符集
        ClientGlobal.setG_charset("UTF-8");
        ClientGlobal.setG_secret_key(null);//秘钥
        // HTTP访问服务的端口号
        ClientGlobal.setG_tracker_http_port(8088);
         */
            // Tracker服务器列表
            InetSocketAddress[] tracker_servers = new InetSocketAddress[1];
            tracker_servers[0] = new InetSocketAddress(trackerServer,Integer.parseInt(port));
            ClientGlobal.setG_tracker_group(new TrackerGroup(tracker_servers));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return  true;
    }
}
