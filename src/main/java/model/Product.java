/*
  this model is for Products
 */
package model;

public class Product {
    private int id;
    private String name;
    private String category;
    private double price;
    private int quantity;

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getCategory() {
        return this.category;
    }

     public double getPrice() {
        return this.price;
    }

     public int getQuantity() {
        return this.quantity;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

	public String toString(){
		return this.name;
	}

}
