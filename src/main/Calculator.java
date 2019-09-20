package main;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Calculator {

		public static void main(String args[]){
			Basket basket = new Basket();
			List<Offer> offers = initOffers();
			try {
				for (int i = 0; i < args.length; i = i + 2) {
					basket.addItem(Fruit.valueOf(args[i]), Integer.parseInt(args[i + 1]));
				}
				System.out.println(calculate(basket, offers));
			} catch (Exception e){
				man();
			}
		}

		/**
		 * @param basket : basket to calculate
		 * @param offers : list of all existing offers
		 * @return : price of the basket
		 */
		public static BigDecimal calculate(Basket basket, List<Offer> offers){
			BigDecimal total = sumBasket(basket);
			total = rebate(basket, offers, total);
			return total;
		}

		/**
		 * @param basket : basket to sum
		 * @return : price of the basket without offers
		 */
		private static BigDecimal sumBasket(Basket basket){
			Map<Fruit,Integer> content = basket.getContent();
			Set<Fruit> fruits = content.keySet();
			return fruits.stream().map(k ->  new BigDecimal (k.getPrice()*content.get(k))).reduce(BigDecimal.ZERO, (x,y)->x.add(y));
		}

		
		/**
		 * @param basket : basket to calculate
		 * @param offers : list of all existing offers
		 * @param total : price before offers
		 * @return : price with offers
		 */
		private static BigDecimal rebate(Basket basket, List<Offer> offers, BigDecimal total){
			for (Offer offer : offers){
				boolean apply = true;
				while(apply){
					apply = basket.offerRemove(offer);
					if(apply){
						total = total.subtract(offer.getRebate());
					}
				}
			}
			return total.setScale(2, RoundingMode.HALF_EVEN);
		}

		private static void man(){
			System.out.println("usage: [<FRUIT> <quantity>]");
		}

		public static List<Offer> initOffers(){
			List<Offer> offers = new ArrayList<>();
			List<Fruit> buy1 = new ArrayList<>();
			buy1.add(Fruit.APPLE);
			buy1.add(Fruit.APPLE);
			List<Fruit> free1 = new ArrayList<>();
			free1.add(Fruit.APPLE);
			Offer offer1 = new Offer(buy1, free1);
			offers.add(offer1);

			List<Fruit> buy2 = new ArrayList<>();
			buy2.add(Fruit.WATERMELON);
			buy2.add(Fruit.WATERMELON);
			buy2.add(Fruit.WATERMELON);
			List<Fruit> free2 = new ArrayList<>();
			free2.add(Fruit.WATERMELON);
			Offer offer2 = new Offer(buy2, free2);
			offers.add(offer2);

			return offers;
		}

}
