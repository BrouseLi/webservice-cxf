package com.angshi.mimicwebpolicy.Entity;

import java.util.ArrayList;
import java.util.List;

public class Util {
	public static List<Item> init(List<String>list,List<String>list1) {
		List<Item>li=new ArrayList<Item>();
		for(int i=0;i<list.size();i++) {
			Item item =new Item(list.get(i),list1.get(i));
			li.add(item);
		}
		return li;
	}


}
