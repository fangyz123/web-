/**
* Team Zhinengxianfeng Hebei Normal University
* FileName: Nlp.java
* �ʷ�����
*
* @author Fang Yuzhen
    * @Date    2018/4/17
* @version 1.00
*/
package com.janborn.www;

import org.json.JSONObject;

import com.baidu.aip.nlp.AipNlp;

public class GetNlp {
	// ����APPID/AK/SK
	public static final String APP_ID = "11069214";
	public static final String API_KEY = "G1SCbCcrXpwiut6lR1fK92xT";
	public static final String SECRET_KEY = "8IETLzLCZa0hr4weHBmAeuk1GGR20bz4";

	// ��ȡ���ı�
	private String text;
	// ���ı�������ת��JSONObject����
	private JSONObject jsonObject;

	// �����ı�������
	public void setText(String text) {
		this.text = text;
	}

	//����JSONObject����
	public void toJSON() {
		AipNlp client = new AipNlp(APP_ID, API_KEY, SECRET_KEY);
		jsonObject = client.lexer(text, null);
	}
	
	// ���JSONObject����
	public JSONObject GetJSON() {
		return jsonObject;
	}

	// �вι��캯���������ı����ݺͱ���JSONObject����
	public GetNlp(String t) {
		text = t;
		AipNlp client = new AipNlp(APP_ID, API_KEY, SECRET_KEY);
		jsonObject = client.lexer(text, null);
	}

	//����ʵ���뵱���õ����޲�ʱ���Ǵ����ı���Ӧ�û�ȡ�ĵ�ǰλ��
	public GetNlp() {

	}

}
