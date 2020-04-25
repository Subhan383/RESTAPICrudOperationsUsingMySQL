package org.studyeasy.showroom.services;

import java.util.List;

import org.studyeasy.showroom.DAO.ProductsDAO;
import org.studyeasy.showroom.model.ProductEntity;

public class ProductsService {
	
	ProductsDAO dao=new ProductsDAO();

	public List<ProductEntity> getProductsByBrand(int brandId) {
		List<ProductEntity> productlist=dao.getProductsByBrand(brandId);
		return productlist;
	}

	public List<ProductEntity> getProductsByBrandAndCategory(int brandId, String category) {
		List<ProductEntity> productlist=dao.getProductsByBrandAndCategory(brandId,category);
		return productlist;
	}

}
