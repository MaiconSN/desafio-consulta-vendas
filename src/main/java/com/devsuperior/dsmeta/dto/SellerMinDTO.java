package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.entities.Seller;

public class SellerMinDTO {

	private String sellerName;
	private Double total;
	
	public SellerMinDTO() {
	}
	
	public SellerMinDTO(String sellerName, Double total) {
		this.sellerName = sellerName;
		this.total = total;
	}

	public SellerMinDTO(Seller sellerName, Sale total) {
		this.sellerName = sellerName.getName();
		this.total = total.getAmount();
	}

	public String getSellerName() {
		return sellerName;
	}

	public Double getTotal() {
		return total;
	}

	
	
	
}
