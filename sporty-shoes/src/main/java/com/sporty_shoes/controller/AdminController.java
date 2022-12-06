package com.sporty_shoes.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sporty_shoes.dto.CategoryDto;
import com.sporty_shoes.dto.ProductDto;
import com.sporty_shoes.entities.Admin;
import com.sporty_shoes.entities.Category;
import com.sporty_shoes.entities.Product;
import com.sporty_shoes.entities.Purchase;
import com.sporty_shoes.entities.User;
import com.sporty_shoes.services.AdminService;
import com.sporty_shoes.services.CategoryService;
import com.sporty_shoes.services.ProductService;
import com.sporty_shoes.services.PurchaseService;
import com.sporty_shoes.services.UserService;

@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;
	@Autowired
	private UserService userService;
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private PurchaseService purchaseService;

	// add admin
	@PostMapping("/admin")
	public Admin addAdmin(@RequestBody Admin admin) {
		return this.adminService.addAdmin(admin);
	}
	
	// admin login
	@PostMapping("/admin/login")
	public String adminLogin(@RequestBody Admin admin) {
		return this.adminService.adminLogin(admin);
	}
	
	//admin change password
	@PutMapping("admin/login")
	public String adminChangePassword(@RequestBody Admin admin) {
		return this.adminService.adminChangePassword(admin);
	}

	// add user
	@PostMapping("/admin/users")
	public User addUser(@RequestBody User user) {
		return this.userService.addUser(user);
	}

	// get all user
	@GetMapping("/admin/users")
	public List<User> getAllUsers() {
		return this.userService.getAllUsers();
	}

	// get user by id
	@GetMapping("/admin/users/{userId}")
	public User getUserById(@PathVariable String userId) {
		return this.userService.getUserById(Long.parseLong(userId));
	}

	// find user by email
	@GetMapping("/admin/users/email")
	public ResponseEntity<User> findUserByEmail(@RequestParam String email) {
		return new ResponseEntity<User>(userService.findByEmail(email), HttpStatus.OK);
	}

	// find user by name
	@GetMapping("/admin/users/name")
	public ResponseEntity<List<User>> findUserByName(@RequestParam String name) {
		return new ResponseEntity<List<User>>(userService.findByName(name), HttpStatus.OK);
	}

	// add product ✔️
	@PostMapping("/admin/products")
	public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto) {
		Product product = productService.addProduct(Product.from(productDto));
		return new ResponseEntity<>(ProductDto.from(product), HttpStatus.OK);
	}

	// get all products ✔️
	@GetMapping("/admin/products")
	public ResponseEntity<List<ProductDto>> getAllProducts() {
		List<Product> products = productService.getAllProducts();
		List<ProductDto> productDto = products.stream().map(ProductDto::from).collect(Collectors.toList());
		return new ResponseEntity<>(productDto, HttpStatus.OK);
	}

	// get product by id ✔️
	@GetMapping("/admin/products/{productId}")
	public ResponseEntity<ProductDto> getProductById(@PathVariable final Long productId) {
		Product product = productService.getProductById(productId);
		return new ResponseEntity<>(ProductDto.from(product), HttpStatus.OK);
	}

	// delete product by id ✔️
	@DeleteMapping("/admin/products/{productId}")
	public ResponseEntity<ProductDto> deleteProduct(@PathVariable String productId) {
		Product product = productService.deleteProduct(Long.parseLong(productId));
		return new ResponseEntity<>(ProductDto.from(product), HttpStatus.OK);
	}

	// update product 
	@PutMapping("/admin/products/{productId}")
	public ResponseEntity<ProductDto> updateProduct(@PathVariable final Long productId, @RequestBody ProductDto productDto) {
		Product editedProduct = productService.updateProduct(productId, Product.from(productDto));
		return new ResponseEntity<>(ProductDto.from(editedProduct), HttpStatus.OK);
	}

	// add category ✔️
	@PostMapping("/admin/category")
	public ResponseEntity<CategoryDto> addCategory(@RequestBody final CategoryDto categoryDto) {
		Category category = categoryService.addCategory(Category.from(categoryDto));
		return new ResponseEntity<>(CategoryDto.from(category), HttpStatus.OK);
	}

	// get all category ✔️
	@GetMapping("/admin/category")
	public ResponseEntity<List<CategoryDto>> getCategorys() {
		List<Category> categorys = categoryService.getAllCategory();
		List<CategoryDto> categoryDto = categorys.stream().map(CategoryDto::from).collect(Collectors.toList());
		return new ResponseEntity<>(categoryDto, HttpStatus.OK);
	}

	// get category by id ✔️
	@GetMapping("/admin/category/{categoryId}")
	public ResponseEntity<CategoryDto> getCartById(@PathVariable final Long categoryId) {
		Category category = categoryService.getCategoryById(categoryId);
		return new ResponseEntity<>(CategoryDto.from(category), HttpStatus.OK);
	}

	// delete category by id ✔️
	@DeleteMapping("/admin/category/{categoryId}")
	public ResponseEntity<CategoryDto> deleteCategory(@PathVariable String categoryId) {
		Category category = categoryService.deleteCategory(Long.parseLong(categoryId));
		return new ResponseEntity<>(CategoryDto.from(category), HttpStatus.OK);
	}

	// update category ✔️
	@PutMapping("/admin/category/{categoryId}")
	public ResponseEntity<CategoryDto> updateCategory(@PathVariable final Long categoryId, @RequestBody CategoryDto categoryDto) {
		Category editedCategory = categoryService.updateCategory(categoryId, Category.from(categoryDto));
		return new ResponseEntity<>(CategoryDto.from(editedCategory), HttpStatus.OK);
	}

	// add product to category
	@PostMapping("/admin/category/{categoryId}/products/{productId}/add")
	public ResponseEntity<CategoryDto> addProductToCategory(@PathVariable final Long categoryId,
			@PathVariable final Long productId) {
		Category category = categoryService.addProductToCategory(categoryId, productId);
		return new ResponseEntity<>(CategoryDto.from(category), HttpStatus.OK);
	}

	// remove product from category
	@DeleteMapping("/admin/category/{categoryId}/products/{productId}/remove")
	public ResponseEntity<CategoryDto> removeProductFromCategory(@PathVariable final Long categoryId,
			@PathVariable final Long productId) {
		Category category = categoryService.removeProductFromCategory(categoryId, productId);
		return new ResponseEntity<>(CategoryDto.from(category), HttpStatus.OK);
	}

	// get purchase details by date
	@GetMapping("/admin/purchase/{date}")
	public ResponseEntity<List<Purchase>> findByDate(@PathVariable String date) {
		return new ResponseEntity<List<Purchase>>(purchaseService.findByDate(date), HttpStatus.OK);
	}
}
