package cs1220.lab4;

public class Items {

	String name,image;
	int price,quantity,id;
	public Items(String name, String image, int price, int quantity,int id) {
		super();
		this.name = name;
		this.image = image;
		this.price = price;
		this.quantity = quantity;
		this.id=id;
	}
	public String getName() {
		return name;
	}
	public String getImage() {
		return image;
	}
	public int getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
	public int getId() {
		return id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
