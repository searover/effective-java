package example.io;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.tsf.v20180326.TsfClient;
import com.tencentcloudapi.tsf.v20180326.models.DescribeApplicationRequest;
import com.tencentcloudapi.tsf.v20180326.models.DescribeApplicationResponse;

/**
 * @author luxz
 * @date 2021/5/14-5:25 PM
 */
public class Main {
    public static void main(String[] args) throws TencentCloudSDKException {
        // 传入 tsf 账户中心申请的 secretId 和 secretKey，参考步骤 2
        Credential credential = new Credential("2edGbFbNT8478Qff17Jf48cdd12M7CVc", "cD85f7EQ30c494eeIae2d4471KZ0bTNA");

        // 构建 tsfClient，独立版 regionId 为固定值，不传或传入任意值即可
        TsfClient tsfClient = new TsfClient(credential, "");

        // http/https 协议，根据独立版前置机配置的协议进行配置，不设置默认为 https
        ClientProfile clientProfile = new ClientProfile();
        HttpProfile httpProfile = new HttpProfile();
        httpProfile.setProtocol(HttpProfile.REQ_HTTP);
        clientProfile.setHttpProfile(httpProfile);
        tsfClient.setClientProfile(clientProfile);

        // 请求 sdk 默认支持的 action
        DescribeApplicationRequest describeApplicationRequest = new DescribeApplicationRequest();
        describeApplicationRequest.setApplicationId("application-jqv3eny7");
        DescribeApplicationResponse describeApplicationResponse = tsfClient.DescribeApplication(describeApplicationRequest);
        System.out.println(DescribeApplicationResponse.toJsonString(describeApplicationResponse));

        // 请求独立版定制开发的 action
        String describeAllApplicationResponse = tsfClient.call("DescribeAllApplication", "{}");
        System.out.println(describeAllApplicationResponse);
    }
}
