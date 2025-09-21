package kr.co.spring_boot_project_1.mvc.controller;

import kr.co.spring_boot_project_1.mvc.model.Product;
import kr.co.spring_boot_project_1.mvc.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {
    /*
     * [의존성 주입(Spring 4.3+)]
     * 1. 생성자가 하나만 있는 경우 @Autowired 생략 가능
     * 2. 둘 이상인 경우 @Autowired 명시 필요
     * 3. Lombok의 @RequiredArgsConstructor를 사용하면 생성자 코드 안 써도 됨
     *
     * [@RequestMapping]
     * 1. 기본적으로 GET 메서드로 처리
     * 2. method 속성을 통해 메서드 명시 가능
     *
     * [HTTP 메서드 전용 애노테이션]
     * 1. 경로와 메서드는 필수로 요구되므로,
     *    @GET, @POST, ... 등 HTTP 메서드 별 전용 애노테이션을 보통 사용함
     *
     * [파라미터 자동 인스턴스 생성]
     * 1. 스프링이 요청 파라미터를 보고 해당 객체를 만들어 줌
     * 2. 필드 이름과 요청 파라미터 이름이 일치해야 자동 매핑됨
     */
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // @RequestMapping("/products")
    @GetMapping("/products")
    public String viewProducts(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);

        return "products.html";
    }

    /*
        @RequestMapping(
            path = "/products",
            method = RequestMethod.POST
        )
    */
    @PostMapping("/products/v1")
    public String addProductV1(
        @RequestParam String name,
        @RequestParam double price,
        Model model
    ) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        productService.addProduct(product);

        List<Product> products = productService.findAll();
        model.addAttribute("products", products);

        return "products.html";
    }

    @PostMapping("/products/v2")
    public String addProductV2(
            Product product,
            Model model
    ) {
        productService.addProduct(product);

        List<Product> products = productService.findAll();
        model.addAttribute("products", products);

        return "products.html";
    }
}
