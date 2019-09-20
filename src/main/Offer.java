package main;

import java.math.BigDecimal;
import java.util.List;

public class Offer {
	List<Fruit> buy;
	List<Fruit> free;

	/**
	 * @param buy : list of items concerned by the offer
	 * @param free : list of free items in the previous one
	 */
	public Offer(List<Fruit> buy, List<Fruit> free){
		this.buy = buy;
		this.free = free;
	}

	/**
	 * @return amount of the rebate for the offer
	 */
	public BigDecimal getRebate(){
		return free.stream().map(k ->  new BigDecimal(k.getPrice())).reduce(BigDecimal.ZERO, (x,y)->x.add(y));
	}

	/**
	 * @return buy list
	 */
	public List<Fruit> getBuy() {
		return buy;
	}
}
