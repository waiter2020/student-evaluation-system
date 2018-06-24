package UPCmvc.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by lylllcc on 2017/5/14.
 */
@Component
public class AppConfig {

    @Value("${auth.appid}")
    public String appid;

    @Value("${auth.appkey}")
    public String appkey;
}
