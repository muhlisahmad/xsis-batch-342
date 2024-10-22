package com.xsis.master.crud.xsis_master_crud;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.xsis.master.crud.xsis_master_crud.entities.Category;
import com.xsis.master.crud.xsis_master_crud.entities.Product;
import com.xsis.master.crud.xsis_master_crud.entities.Variant;
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
		Category electronics = new Category();
		electronics.setSlug("electronics");
		electronics.setName("Electronics");

		Category furniture = new Category();
		furniture.setSlug("furniture");
		furniture.setName("Furniture");

		Category clothing = new Category();
		clothing.setSlug("clothing");
		clothing.setName("Clothing");

		Category beautyProducts = new Category();
		beautyProducts.setSlug("beauty-products");
		beautyProducts.setName("Beauty Products");

		Category sports = new Category();
		sports.setSlug("sports");
		sports.setName("Sports");

		categoryRepository.saveAll(Arrays.asList(electronics, furniture, clothing, beautyProducts, sports));
	}

	private void seedProducts() {
		Category electronics = categoryRepository.findBySlug("electronics");
		Category furniture = categoryRepository.findBySlug("furniture");
		Category clothing = categoryRepository.findBySlug("clothing");
		Category beautyProducts = categoryRepository.findBySlug("beauty-products");
		Category sports = categoryRepository.findBySlug("sports");

		Product smartphone = new Product();
		smartphone.setSlug("smartphone");
		smartphone.setName("Smartphone");
		smartphone.setCategory(electronics);

		Product diningTable = new Product();
		diningTable.setSlug("dining-table");
		diningTable.setName("Dining Table");
		diningTable.setCategory(furniture);

		Product tShirt = new Product();
		tShirt.setSlug("t-shirt");
		tShirt.setName("T-Shirt");
		tShirt.setCategory(clothing);

		Product jeans = new Product();
		jeans.setSlug("jeans");
		jeans.setName("Jeans");
		jeans.setCategory(clothing);

		Product faceCream = new Product();
		faceCream.setSlug("face-cream");
		faceCream.setName("Face Cream");
		faceCream.setCategory(beautyProducts);

		Product basketball = new Product();
		basketball.setSlug("basketball");
		basketball.setName("Basketball");
		basketball.setCategory(sports);

		productRepository.saveAll(Arrays.asList(smartphone, diningTable, tShirt, jeans, faceCream, basketball));
	}

	private void seedVariants() {
		Product smartphone = productRepository.findBySlug("smartphone");
		Product diningTable = productRepository.findBySlug("dining-table");
		Product tShirt = productRepository.findBySlug("t-shirt");
		Product jeans = productRepository.findBySlug("jeans");
		Product faceCream = productRepository.findBySlug("face-cream");
		Product basketball = productRepository.findBySlug("basketball");

		Variant iPhoneCuy = new Variant();
		iPhoneCuy.setSlug("iphone-16");
		iPhoneCuy.setName("iPhone 16");
		iPhoneCuy.setDescription("iPhone baru keluar cuy");
		iPhoneCuy.setPrice(16_499_000L);
		iPhoneCuy.setStock(150L);
		iPhoneCuy.setProduct(smartphone);
		
		Variant googlePixel = new Variant();
		googlePixel.setSlug("google-pixel-9-pro");
		googlePixel.setName("Google Pixel 9 Pro");
		googlePixel.setDescription("Hape gak ramah IMEI");
		googlePixel.setPrice(23_499_000L);
		googlePixel.setStock(150L);
		googlePixel.setProduct(smartphone);

		Variant ikeaTable = new Variant();
		ikeaTable.setSlug("ikea-dining-table");
		ikeaTable.setName("IKEA Dining Table - Wooden");
		ikeaTable.setDescription("bukan untuk rakjel");
		ikeaTable.setPrice(1_200_000L);
		ikeaTable.setStock(50L);
		ikeaTable.setProduct(diningTable);

		Variant informaTable = new Variant();
		informaTable.setSlug("informa-dining-table");
		informaTable.setName("Informa Dining Table - Wooden");
		informaTable.setDescription("ini juga bukan untuk rakjel");
		informaTable.setPrice(1_000_000L);
		informaTable.setStock(50L);
		informaTable.setProduct(diningTable);

		Variant olimpicTable = new Variant();
		olimpicTable.setSlug("olimpic-dining-table");
		olimpicTable.setName("Olimpic Dining Table - Wooden");
		olimpicTable.setDescription("ini baru buat rakjel");
		olimpicTable.setPrice(200_000L);
		olimpicTable.setStock(50L);
		olimpicTable.setProduct(diningTable);

		Variant uniqlo = new Variant();
		uniqlo.setSlug("uniqlo-ut-jujutsu-kaisen");
		uniqlo.setName("Uniqlo - UT Jujutsu Kaisen");
		uniqlo.setDescription("WIBU!!!");
		uniqlo.setPrice(200_000L);
		uniqlo.setStock(50L);
		uniqlo.setProduct(tShirt);

		Variant hnm = new Variant();
		hnm.setSlug("hnm-relaxed-fit-flannel-shirt");
		hnm.setName("H&M - Relaxed Fit Flannel Shirt");
		hnm.setDescription("skin default mahasiswa npc");
		hnm.setPrice(200_000L);
		hnm.setStock(50L);
		hnm.setProduct(tShirt);

		Variant blueJeans = new Variant();
		blueJeans.setSlug("blue-jeans");
		blueJeans.setName("Jeans - blue jean");
		blueJeans.setDescription("jeans ucok");
		blueJeans.setPrice(200_000L);
		blueJeans.setStock(50L);
		blueJeans.setProduct(jeans);

		Variant skintific = new Variant();
		skintific.setSlug("skintific-msh-niacinamide-brightening-moisturizer");
		skintific.setName("SKINTIFIC - MSH Niacinamide Brightening Moisturizer");
		skintific.setDescription("skincare skintific");
		skintific.setPrice(500_000L);
		skintific.setStock(50L);
		skintific.setProduct(faceCream);

		Variant whitelab = new Variant();
		whitelab.setSlug("whitelab-mug-barrier-moisturizer");
		whitelab.setName("whitelab - Mug Barrier Moisturizer");
		whitelab.setDescription("skincare whitelab");
		whitelab.setPrice(500_000L);
		whitelab.setStock(50L);
		whitelab.setProduct(faceCream);

		Variant standardBasketball = new Variant();
		standardBasketball.setSlug("standard-basketball");
		standardBasketball.setName("Orange Basketball");
		standardBasketball.setDescription("standard basketball");
		standardBasketball.setPrice(500_000L);
		standardBasketball.setStock(50L);
		standardBasketball.setProduct(basketball);

		Variant airlessBasketball = new Variant();
		airlessBasketball.setSlug("airless-basketball");
		airlessBasketball.setName("Airless Basketball");
		airlessBasketball.setDescription("3D-Printed Airless Basketball");
		airlessBasketball.setPrice(1_000_000L);
		airlessBasketball.setStock(50L);
		airlessBasketball.setProduct(basketball);

		variantRepository.saveAll(Arrays.asList(iPhoneCuy, olimpicTable, googlePixel, ikeaTable, informaTable, airlessBasketball, blueJeans, hnm, uniqlo, skintific, standardBasketball, whitelab));
	}
}
