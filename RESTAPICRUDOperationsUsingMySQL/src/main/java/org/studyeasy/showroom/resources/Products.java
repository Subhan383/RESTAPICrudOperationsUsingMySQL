package org.studyeasy.showroom.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.studyeasy.showroom.model.ProductEntity;
import org.studyeasy.showroom.services.ProductsService;

@Path("/showroom/brands")
public class Products {

	ProductsService productsService = new ProductsService();

	@GET
	@Path("/{brandId}/products")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProductEntity> getProductsByBrand(@PathParam("brandId") int brandId,
			@QueryParam("category") String category,@QueryParam("start") int start,@QueryParam("end") int end) {
		List<ProductEntity> productlist;
		if (category != null) {
			productlist = productsService.getProductsByBrandAndCategory(brandId, category);

		} else {
			productlist = productsService.getProductsByBrand(brandId);

		}
		if(end>0) {
			productlist=productlist.subList(start, end);
		}

		return productlist;

	}

}
