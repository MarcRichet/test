package main;

import java.util.HashMap;
import java.util.Map;

public class Basket {
	private Map<Fruit,Integer> content = new HashMap<>();

	/**
	 * @param fruit : kind of fruit add in basket
	 * @param number : quantity of the previous fruit
	 */
	public void addItem (Fruit fruit, Integer number){
		if(content.containsKey(fruit)){
			content.replace(fruit,number+content.get(fruit));
		} else{
			content.put(fruit,number);
		}
	}

	/**
	 * @param offer : offer to use on the basket
	 * @return : true if the offer can be applied
	 */
	public boolean offerRemove (Offer offer){
		boolean isApplied = true;
		for(Fruit fruit : offer.getBuy()){
			if(content.get(fruit)>0) {
				content.replace(fruit, content.get(fruit)-1);
			} else {
				isApplied = false;
				break;
			}
		}
		return isApplied;
	}

	/**
	 * @return : content of the basket
	 */
	public Map<Fruit,Integer> getContent(){
		return content;
	}
}
