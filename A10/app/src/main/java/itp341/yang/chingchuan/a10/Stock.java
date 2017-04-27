package itp341.yang.chingchuan.a10;

import java.io.Serializable;

/**
 * Created by Jin Yang on 4/5/2017.
 */

public class Stock implements Serializable{
    String productName, price, color, brand;
    int _id, _stock;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int get_stock() {
        return _stock;
    }

    public void sellStock() {
        _stock--;
    }

    public void sellAll(){
        _stock = 0;
    }

    public void buyStock(){
        _stock++;
    }

    public void set_stock(int _stock) {
        this._stock = _stock;
    }

    public Stock(String productName, String price, String color, String brand, int _id, int _stock) {

        this.productName = productName;
        this.price = price;
        this.color = color;
        this.brand = brand;
        this._id = _id;
        this._stock = _stock;
    }
}
