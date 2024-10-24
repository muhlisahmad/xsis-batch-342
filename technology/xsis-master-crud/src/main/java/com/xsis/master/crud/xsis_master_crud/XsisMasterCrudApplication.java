package com.xsis.master.crud.xsis_master_crud;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.xsis.master.crud.xsis_master_crud.dtos.responses.CategoryResponseDto;
import com.xsis.master.crud.xsis_master_crud.dtos.responses.ProductResponseDto;
import com.xsis.master.crud.xsis_master_crud.repositories.CategoryRepository;
import com.xsis.master.crud.xsis_master_crud.repositories.ProductRepository;
import com.xsis.master.crud.xsis_master_crud.repositories.VariantRepository;

@SpringBootApplication
public class XsisMasterCrudApplication {

	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	VariantRepository variantRepository;

	public static void main(String[] args) {
		SpringApplication.run(XsisMasterCrudApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			seedCategories();
			seedProducts();
			seedVariants();
		};
	}

	private void seedCategories() {
		categoryRepository.insertCategory("Electronics", "electronics");
		categoryRepository.insertCategory("Furniture", "furniture");
		categoryRepository.insertCategory("Clothing", "clothing");
		categoryRepository.insertCategory("Beauty Products", "beauty-products");
		categoryRepository.insertCategory("Sports", "sports");
	}

	private void seedProducts() {
		Object[] electronicsResult = categoryRepository.findBySlug("electronics");
		Object[] furnitureResult = categoryRepository.findBySlug("furniture");
		Object[] clothingResult = categoryRepository.findBySlug("clothing");
		Object[] beautyProductsResult = categoryRepository.findBySlug("beauty-products");
		Object[] sportsResult = categoryRepository.findBySlug("sports");

		CategoryResponseDto electronics = new CategoryResponseDto(
			(String) ((Object[]) electronicsResult[0])[0],
			(String) ((Object[]) electronicsResult[0])[1]
		);
		CategoryResponseDto furniture = new CategoryResponseDto(
			(String) ((Object[]) furnitureResult[0])[0],
			(String) ((Object[]) furnitureResult[0])[1]
		);
		CategoryResponseDto clothing = new CategoryResponseDto(
			(String) ((Object[]) clothingResult[0])[0],
			(String) ((Object[]) clothingResult[0])[1]
		);
		CategoryResponseDto beautyProducts = new CategoryResponseDto(
			(String) ((Object[]) beautyProductsResult[0])[0],
			(String) ((Object[]) beautyProductsResult[0])[1]
		);
		CategoryResponseDto sports = new CategoryResponseDto(
			(String) ((Object[]) sportsResult[0])[0],
			(String) ((Object[]) sportsResult[0])[1]
		);

		productRepository.insertProduct("Smartphone", "smartphone", electronics.getSlug());
		productRepository.insertProduct("Dining Table", "dining-table", furniture.getSlug());
		productRepository.insertProduct("T-Shirt", "t-shirt", clothing.getSlug());
		productRepository.insertProduct("Jeans", "jeans", clothing.getSlug());
		productRepository.insertProduct("Face Cream", "face-cream", beautyProducts.getSlug());
		productRepository.insertProduct("Basketball", "basketball", sports.getSlug());
	}

	private void seedVariants() {
		Object[] smartphoneResult = productRepository.findBySlug("smartphone");
		Object[] diningTableResult = productRepository.findBySlug("dining-table");
		Object[] tShirtResult = productRepository.findBySlug("t-shirt");
		Object[] jeansResult = productRepository.findBySlug("jeans");
		Object[] faceCreamResult = productRepository.findBySlug("face-cream");
		Object[] basketballResult = productRepository.findBySlug("basketball");

		System.out.println(Arrays.toString(smartphoneResult));

		ProductResponseDto smartphone = new ProductResponseDto(
			(String) ((Object[]) smartphoneResult[0])[0],
			(String) ((Object[]) smartphoneResult[0])[1],
			(String) ((Object[]) smartphoneResult[0])[2]
		);
		ProductResponseDto diningTable = new ProductResponseDto(
			(String) ((Object[]) diningTableResult[0])[0],
			(String) ((Object[]) diningTableResult[0])[1],
			(String) ((Object[]) diningTableResult[0])[2]
		);
		ProductResponseDto tShirt = new ProductResponseDto(
			(String) ((Object[]) tShirtResult[0])[0],
			(String) ((Object[]) tShirtResult[0])[1],
			(String) ((Object[]) tShirtResult[0])[2]
		);
		ProductResponseDto jeans = new ProductResponseDto(
			(String) ((Object[]) jeansResult[0])[0],
			(String) ((Object[]) jeansResult[0])[1],
			(String) ((Object[]) jeansResult[0])[2]
		);
		ProductResponseDto faceCream = new ProductResponseDto(
			(String) ((Object[]) faceCreamResult[0])[0],
			(String) ((Object[]) faceCreamResult[0])[1],
			(String) ((Object[]) faceCreamResult[0])[2]
		);
		ProductResponseDto basketball = new ProductResponseDto(
			(String) ((Object[]) basketballResult[0])[0],
			(String) ((Object[]) basketballResult[0])[1],
			(String) ((Object[]) basketballResult[0])[2]
		);

		variantRepository.insertVariant(
			"iPhone 16", 
			"iphone-16", 
			smartphone.getSlug(), 
			"iPhone baru keluar cuy", 
			16_499_000L, 
			150L
		);
		
		variantRepository.insertVariant(
			"Google Pixel 9 Pro", 
			"google-pixel-9-pro", 
			smartphone.getSlug(), 
			"Hape gak ramah IMEI", 
			23_499_000L, 
			150L
		);

		variantRepository.insertVariant(
			"IKEA Dining Table - Wooden", 
			"ikea-dining-table-wooden", 
			diningTable.getSlug(), 
			"bukan untuk rakjel", 
			1_200_000L, 
			50L
		);

		variantRepository.insertVariant(
			"Infoma Dining Table - Wooden", 
			"informa-dining-table-wooden", 
			diningTable.getSlug(), 
			"ini juga bukan untuk rakjel", 
			1_000_000L, 
			75L
		);

		variantRepository.insertVariant(
			"Olimpic Dining Table - Wooden", 
			"olimpic-dining-table-wooden", 
			diningTable.getSlug(), 
			"ini baru buat rakjel", 
			200_000L, 
			15L
		);

		variantRepository.insertVariant(
			"Uniqlo - UT Jujutsu Kaisen", 
			"uniqlo-ut-jujutsu-kaisen", 
			tShirt.getSlug(), 
			"WIBU!!!", 
			200_000L, 
			100L
		);

		variantRepository.insertVariant(
			"H&M - Relaxed Fit Flannel Shirt", 
			"h&m-relaxed-fit-flannel-shirt", 
			tShirt.getSlug(), 
			"skin default mahasiswa npc", 
			200_000L, 
			100L
		);

		variantRepository.insertVariant(
			"Jeans - blue jean", 
			"jeans-blue-jeans", 
			jeans.getSlug(), 
			"jeans ucok", 
			200_000L, 
			100L
		);

		variantRepository.insertVariant(
			"SKINTIFIC - MSH Niacinamide Brightening Moisturizer", 
			"skintific-msh-niacinamide-brightening-moisturizer", 
			faceCream.getSlug(), 
			"skincare skintific", 
			500_000L, 
			50L
		);

		variantRepository.insertVariant(
			"whitelab - Mug Barrier Moisturizer", 
			"whitelab-mug-barrier-moisturizer", 
			faceCream.getSlug(), 
			"skincare whitelab", 
			500_000L, 
			50L
		);

		variantRepository.insertVariant(
			"Standard Orange Basketball", 
			"standard-orange-basketball", 
			basketball.getSlug(), 
			"standard basketball", 
			500_000L, 
			50L
		);

		variantRepository.insertVariant(
			"Airless Basketball", 
			"airless-basketball", 
			basketball.getSlug(), 
			"3D-Printed Airless Basketball", 
			1_000_000L, 
			50L
		);
	}
}
