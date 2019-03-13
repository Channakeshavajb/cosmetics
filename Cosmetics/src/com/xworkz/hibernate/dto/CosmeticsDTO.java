package com.xworkz.hibernate.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "cosmetics_details")
@NamedQuery(name="simpleFetch",query="select c from CosmeticsDTO c where c.brand=:cbrand")
public class CosmeticsDTO implements Serializable{
	@Id
	@GenericGenerator(name = "cosmetics",strategy="increment")
	@GeneratedValue(generator = "cosmetics")
	@Column(name="c_id")
	private int id;
 	@Column(name = "c_barnd")
	private String brand;
 	@Column(name = "c_price")
	private int price;
 	@Column(name = "c_quantity")
 	private int quantity;
 	@Column(name = "c_mfd_date")
	private String mfd_date;
 	@Column(name = "c_exp_date")
	private String exp_date;
	
	public CosmeticsDTO() {
		// TODO Auto-generated constructor stub
	System.out.println("CosmeticsDTO created...............");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getMfd_date() {
		return mfd_date;
	}

	public void setMfd_date(String mfd_date) {
		this.mfd_date = mfd_date;
	}

	public String getExp_date() {
		return exp_date;
	}

	public void setExp_date(String exp_date) {
		this.exp_date = exp_date;
	}

	@Override
	public String toString() {
		return "CosmeticsDTO [id=" + id + ", brand=" + brand + ", price=" + price + ", quantity=" + quantity +", mfd_date=" + mfd_date
				+ ", exp_date=" + exp_date + "]";
	}
	
	
}
