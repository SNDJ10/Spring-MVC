package com.xworkz.aiproduct.controller;

import com.xworkz.aiproduct.dto.ProductDTO;
import com.xworkz.aiproduct.service.AIService;
import com.xworkz.aiproduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private AIService aiService; // NEW: inject AI service

    // ===== HOME PAGE =====
    @GetMapping("/")
    public String home() {
        return "index";
    }

    // ===== STANDARD CRUD (same as your project) =====

    @PostMapping("/register")
    public String register(ProductDTO dto, Model model) {
        model.addAttribute("message", productService.validateAndSave(dto));
        return "index";
    }

    @GetMapping("/fetchData")
    public String fetchAll(Model model) {
        List<ProductDTO> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "fetchProducts";
    }

    @GetMapping("/updateRequest")
    public String updateRequest(@RequestParam Integer id, Model model) {
        model.addAttribute("product", productService.getById(id));
        return "updateProduct";
    }

    @PostMapping("/update")
    public String update(ProductDTO dto, Model model) {
        model.addAttribute("message", productService.updateProduct(dto));
        return "index";
    }

    @GetMapping("/deleteRequest")
    public String delete(@RequestParam Integer id, Model model) {
        model.addAttribute("message", productService.deleteProduct(id));
        model.addAttribute("products", productService.getAllProducts());
        return "fetchProducts";
    }

    // ===== AI FEATURES (NEW) =====

    /**
     * AI Feature 1: Show the AI tools page
     */
    @GetMapping("/aiTools")
    public String aiToolsPage(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "aiTools";
    }

    /**
     * AI Feature 2: Generate product description using AI
     * User enters product name + category, AI writes description
     */
    @PostMapping("/ai/generateDescription")
    public String generateDescription(
            @RequestParam String productName,
            @RequestParam String category,
            Model model) {

        String aiDescription = aiService.generateProductDescription(productName, category);
        model.addAttribute("aiDescription", aiDescription);
        model.addAttribute("productName", productName);
        model.addAttribute("category", category);
        return "aiTools";
    }

    /**
     * AI Feature 3: Get AI price suggestion
     */
    @PostMapping("/ai/suggestPrice")
    public String suggestPrice(
            @RequestParam String productName,
            @RequestParam String category,
            @RequestParam(required = false, defaultValue = "") String description,
            Model model) {

        String priceSuggestion = aiService.suggestPrice(productName, category, description);
        model.addAttribute("priceSuggestion", priceSuggestion);
        model.addAttribute("productName", productName);
        return "aiTools";
    }

    /**
     * AI Feature 4: Analyze all products and get business insights
     */
    @GetMapping("/ai/analyzeInventory")
    public String analyzeInventory(Model model) {
        List<ProductDTO> products = productService.getAllProducts();
        String analysis = aiService.analyzeProducts(products);
        model.addAttribute("analysis", analysis);
        model.addAttribute("products", products);
        return "aiTools";
    }

    /**
     * AI Feature 5: Chat with your product data
     */
    @PostMapping("/ai/chat")
    public String chat(
            @RequestParam String question,
            Model model) {

        List<ProductDTO> products = productService.getAllProducts();
        String answer = aiService.chatWithProducts(question, products);
        model.addAttribute("chatQuestion", question);
        model.addAttribute("chatAnswer", answer);
        model.addAttribute("products", products);
        return "aiTools";
    }
}
