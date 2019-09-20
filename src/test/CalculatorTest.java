package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import main.Basket;
import main.Calculator;
import main.Fruit;

public class CalculatorTest {

	@Test
	public void AmoutTest(){
		BigDecimal total = Calculator.calculate(initBasket(), Calculator.initOffers());
		assertEquals(total.doubleValue(), 5.1);
	}
	
	@Test
	public void Amout2Test(){
		BigDecimal total = Calculator.calculate(initBasket2(), Calculator.initOffers());
		assertEquals(total.doubleValue(), 2.3);
	}

	private static Basket initBasket(){
		Basket basket = new Basket();
		basket.addItem(Fruit.APPLE, 4);
		basket.addItem(Fruit.ORANGE, 3);
		basket.addItem(Fruit.WATERMELON, 5);
		return basket;
	}

	private static Basket initBasket2(){
		Basket basket = new Basket();
		basket.addItem(Fruit.APPLE, 1);
		basket.addItem(Fruit.ORANGE, 1);
		basket.addItem(Fruit.WATERMELON, 2);
		return basket;
	}
	
}
