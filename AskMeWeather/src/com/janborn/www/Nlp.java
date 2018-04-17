package com.janborn.www;

import java.util.ArrayList;

public class Nlp extends GetNlp {
	private String text;
	private ArrayList<Items> i_item = new ArrayList<>();

	public class Items {
		private String item;
		private String ne;
		private String pos;
		private int byte_offset;
		// private int byte_lenght;
		private String uri;
		private String formal;
		// private String[] basic_words;
		// private Loc_details Loc_details;

		// public class Loc_details {
		// private String type;
		// private int byte_offset;
		// private int byte_length;
		// }

		public Items(int i) {

			this.item = Nlp.this.GetJSON().getJSONArray("items").getJSONObject(i).getString("item");
			this.ne = Nlp.this.GetJSON().getJSONArray("items").getJSONObject(i).getString("ne");
			this.pos = Nlp.this.GetJSON().getJSONArray("items").getJSONObject(i).getString("pos");
			this.byte_offset = Nlp.this.GetJSON().getJSONArray("items").getJSONObject(i).getInt("byte_offset");
			// this.byte_lenght =
			// Nlp.this.GetJSON().getJSONArray("items").getJSONObject(i).getInt("byte_lenght");
			this.uri = Nlp.this.GetJSON().getJSONArray("items").getJSONObject(i).getString("uri");
			this.formal = Nlp.this.GetJSON().getJSONArray("items").getJSONObject(i).getString("formal");
			// this.basic_words
			// Loc_details = loc_details;
		}

		public String getItem() {
			return item;
		}

		public String getNe() {
			return ne;
		}

		public String getPos() {
			return pos;
		}

		public int getByte_offset() {
			return byte_offset;
		}

		// public int getByte_lenght() {
		// return byte_lenght;
		// }

		public String getUri() {
			return uri;
		}

		public String getFormal() {
			return formal;
		}

		// public String[] getBasic_words() {
		// return basic_words;
		// }
		//
		// public Loc_details getLoc_details() {
		// return Loc_details;
		// }

	}

	// 获取文本的内容
	public String getText() {
		return text;
	}

	// 设置文本内容
	public void setText(String t) {
		this.text = t;
	}

	// 获取下标为i的元素
	public Items getI_ite(int i) {
		return i_item.get(i);
	}

	// 获取地名
	public String locaction() {
		String s = "";
		for (int i = 0; i < length(); i++) {
			if (i_item.get(i).getNe().equals("LOC")) {
				s = s + i_item.get(i).getItem();
			}
		}
		return s;
	}

	// 在末尾添加新的元素items
	public void setI_item(Items items) {
		this.i_item.add(items); // 必须修改
	}

	// 返回i_item的长度
	public int length() {
		// TODO Auto-generated method stub
		return i_item.size();
	}

	// 我其实是想当调用的是无参时，那传的文本就应该获取的当前位置
	public Nlp() {
		super();
	}

	// 有参构造函数，为text和i_item做初始化
	public Nlp(String t) {
		super(t);
		// TODO Auto-generated constructor stub
		text = t;
		for (int i = 0; i < GetJSON().getJSONArray("items").length(); i++) {
			i_item.add(new Items(i));
		}
	}

}
