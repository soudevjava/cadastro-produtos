package soudevjava.model;

public class Produto {
	private String name;
	private String description;
	private Double price;
	private Integer quantity;

	public Produto() {

	}

	public Produto(String name, String description, Double price, Integer quantity) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Name = " + name + "\nDescription = " + description + "\nPrice = " + price + "\nQuantity = " + quantity+"\n";
	}
}
