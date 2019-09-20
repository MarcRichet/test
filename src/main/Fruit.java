package main;

public enum Fruit {
	ORANGE (0.5),
	APPLE (0.2),
	WATERMELON (0.8);

	private double price = 0;

	Fruit(double price){
		this.price = price;
	}

	public double getPrice() {
		return price;
	}
}
