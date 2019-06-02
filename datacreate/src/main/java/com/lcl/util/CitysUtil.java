package com.lcl.util;

import java.util.HashMap;
import java.util.Random;

import com.lcl.bo.Citys;

public class CitysUtil {
	/**
	 * 石家庄、沈阳、哈尔滨、杭州、福州、济南、广州、武汉、成都、
	 * 昆明、兰州、台北、南宁、银川、太原、长春、南京、合肥、南昌、
	 * 郑州、长沙、海口、贵阳、西安、西宁、呼和浩特、拉萨、乌鲁木齐
	 */
	private static HashMap<Integer,String> citys = new HashMap<>();
		static {
			citys.put(0,"乌鲁木齐");
			citys.put(1,"石家庄");
			citys.put(2,"沈阳");
			citys.put(3,"哈尔滨");
			citys.put(4,"杭州");
			citys.put(5,"福州");
			citys.put(6,"济南");
			citys.put(7,"广州");
			citys.put(8,"武汉");
			citys.put(9,"成都");
			citys.put(10,"昆明");
			citys.put(11,"兰州");
			citys.put(12,"台北");
			citys.put(13,"南宁");
			citys.put(14,"银川");
			citys.put(15,"太原");
			citys.put(16,"长春");
			citys.put(17,"南京");
			citys.put(18,"合肥");
			citys.put(19,"南昌");
			citys.put(20,"郑州");
			citys.put(21,"长沙");
			citys.put(22,"海口");
			citys.put(23,"贵阳");
			citys.put(24,"西安");
			citys.put(25,"西宁");
			citys.put(26,"呼和浩特");
			citys.put(27,"拉萨");
			
		}
		/**
		 * 随机获取出发和到达城市
		 * @return
		 */
		public static Citys getCitysRandom() {
			Citys c = new Citys();
			String city1 = citys.get(new Random().nextInt(28));
			String city2 = citys.get(new Random().nextInt(28));
			if(city1.equals(city2)) {
				getCitysRandom();
			}
			c.setFromCity(city1);
			c.setArriveCity(city2);
			return c;
		}
}
