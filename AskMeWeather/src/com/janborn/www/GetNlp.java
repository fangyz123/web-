/**
* Team Zhinengxianfeng Hebei Normal University
* FileName: Nlp.java
* 词法分析
*
* @author Fang Yuzhen
    * @Date    2018/4/17
* @version 1.00
*/
package com.janborn.www;

import org.json.JSONObject;

import com.baidu.aip.nlp.AipNlp;

public class GetNlp {
	// 设置APPID/AK/SK
	public static final String APP_ID = "11069214";
	public static final String API_KEY = "G1SCbCcrXpwiut6lR1fK92xT";
	public static final String SECRET_KEY = "8IETLzLCZa0hr4weHBmAeuk1GGR20bz4";

	// 获取的文本
	private String text;
	// 将文本的内容转成JSONObject对象
	private JSONObject jsonObject;

	// 设置文本的内容
	public void setText(String text) {
		this.text = text;
	}

	//设置JSONObject对象
	public void toJSON() {
		AipNlp client = new AipNlp(APP_ID, API_KEY, SECRET_KEY);
		jsonObject = client.lexer(text, null);
	}
	
	// 获得JSONObject对象
	public JSONObject GetJSON() {
		return jsonObject;
	}

	// 有参构造函数，设置文本内容和保存JSONObject对象
	public GetNlp(String t) {
		text = t;
		AipNlp client = new AipNlp(APP_ID, API_KEY, SECRET_KEY);
		jsonObject = client.lexer(text, null);
	}

	//我其实是想当调用的是无参时，那传的文本就应该获取的当前位置
	public GetNlp() {

	}

}
