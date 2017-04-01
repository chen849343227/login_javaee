package com.boot.utils;

import java.util.Date;

import com.boot.entity.UserSms;
import com.boot.entity.ali.Root;
import com.google.gson.Gson;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

public class DaYuService {

	public static boolean requestSmsCode(String phone) {
		Gson gson = new Gson();
		boolean flag = false;
		// 服务url
		String url = "http://gw.api.taobao.com/router/rest";
		// appkey
		String appkey = "23567754";
		// secret
		String secret = "d02bd556928889a88b811aa28a9ec5c7";
		// 生成随机的6位数字
		String code = RandomUtil.createRandomVcode();
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		req.setExtend("1");
		req.setSmsType("normal");
		req.setSmsFreeSignName("爱生活爱龙哥");
		req.setSmsParamString("{number:'" + code + " '}");
		req.setRecNum(phone);

		req.setSmsTemplateCode("SMS_60130168");
		AlibabaAliqinFcSmsNumSendResponse rsp = null;
		try {
			rsp = client.execute(req);
			UserSms userSms = new UserSms();
			userSms.setPhone(phone);
			userSms.setCode(code);
			userSms.setTime(new Date());
			Root root = gson.fromJson(rsp.getBody(), Root.class);
			flag = root.getAlibaba_aliqin_fc_sms_num_send_response().getResult().getSuccess();
			System.out.println(rsp.getBody());
		} catch (ApiException e) {
			e.printStackTrace();
		}
		if (flag) {
			return true;
		} else {
			return false;
		}
	}

}
