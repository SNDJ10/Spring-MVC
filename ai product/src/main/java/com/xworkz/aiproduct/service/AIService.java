package com.xworkz.aiproduct.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.xworkz.aiproduct.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * AIService - This is the NEW AI layer.
 * It uses RestTemplate (just like calling any REST API) to send
 * product data to Claude AI and get intelligent responses back.
 *
 * 🔧 Set your Claude API key in the field below.
 * Get your free API key at: https://console.anthropic.com
 */
@Service
public class AIService {

    // 🔧 REPLACE with your actual Claude API key from https://console.anthropic.com
    private static final String CLAUDE_API_KEY = "YOUR_CLAUDE_API_KEY_HERE";
    private static final String CLAUDE_API_URL = "https://api.anthropic.com/v1/messages";
    private static final String MODEL = "claude-3-haiku-20240307"; // fast & affordable model

    @Autowired
    private RestTemplate restTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Feature 1: AI generates a product description automatically
     * User just enters productName + category, AI writes the description
     */
    public String generateProductDescription(String productName, String category) {
        String prompt = "Write a short, professional product description (2-3 sentences) for:\n" +
                "Product: " + productName + "\n" +
                "Category: " + category + "\n" +
                "Make it appealing for an e-commerce website. No bullet points, just paragraph text.";

        return callClaudeAPI(prompt);
    }

    /**
     * Feature 2: AI suggests a smart price based on product details
     */
    public String suggestPrice(String productName, String category, String description) {
        String prompt = "Based on the following product, suggest a fair market price range in Indian Rupees (INR).\n" +
                "Product: " + productName + "\n" +
                "Category: " + category + "\n" +
                "Description: " + description + "\n\n" +
                "Give a short answer: suggested price range and brief reason why. Keep it under 50 words.";

        return callClaudeAPI(prompt);
    }

    /**
     * Feature 3: AI analyzes all products and gives business insights
     */
    public String analyzeProducts(List<ProductDTO> products) {
        if (products == null || products.isEmpty()) {
            return "No products found in database to analyze.";
        }

        StringBuilder productList = new StringBuilder();
        for (ProductDTO p : products) {
            productList.append("- ").append(p.getProductName())
                    .append(" | Category: ").append(p.getCategory())
                    .append(" | Price: ₹").append(p.getPrice())
                    .append(" | Qty: ").append(p.getQuantity())
                    .append("\n");
        }

        String prompt = "You are a business analyst. Analyze this product inventory and give 3 short business insights:\n\n" +
                productList +
                "\nProvide insights about: pricing trends, stock levels, and category performance. " +
                "Keep total response under 150 words. Use simple language.";

        return callClaudeAPI(prompt);
    }

    /**
     * Feature 4: AI-powered chatbot - user can ask anything about their products
     */
    public String chatWithProducts(String userQuestion, List<ProductDTO> products) {
        StringBuilder productList = new StringBuilder();
        if (products != null) {
            for (ProductDTO p : products) {
                productList.append("- ID:").append(p.getId())
                        .append(" | ").append(p.getProductName())
                        .append(" | Category: ").append(p.getCategory())
                        .append(" | Price: ₹").append(p.getPrice())
                        .append(" | Qty: ").append(p.getQuantity())
                        .append("\n");
            }
        }

        String prompt = "You are a helpful product management assistant. " +
                "Here is the current product inventory:\n\n" +
                productList + "\n" +
                "User question: " + userQuestion + "\n\n" +
                "Answer helpfully and concisely based on the inventory data above.";

        return callClaudeAPI(prompt);
    }

    /**
     * Core method: Calls the Claude AI REST API using RestTemplate
     * This is like any other REST API call - set headers, send JSON body, get response
     */
    private String callClaudeAPI(String userMessage) {
        try {
            // 1. Set HTTP headers (same as Postman headers)
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("x-api-key", CLAUDE_API_KEY);
            headers.set("anthropic-version", "2023-06-01");

            // 2. Build the JSON request body
            ObjectNode requestBody = objectMapper.createObjectNode();
            requestBody.put("model", MODEL);
            requestBody.put("max_tokens", 500);

            ArrayNode messages = objectMapper.createArrayNode();
            ObjectNode message = objectMapper.createObjectNode();
            message.put("role", "user");
            message.put("content", userMessage);
            messages.add(message);
            requestBody.set("messages", messages);

            // 3. Make the HTTP POST request using RestTemplate
            HttpEntity<String> request = new HttpEntity<>(requestBody.toString(), headers);
            ResponseEntity<String> response = restTemplate.exchange(
                    CLAUDE_API_URL,
                    HttpMethod.POST,
                    request,
                    String.class
            );

            // 4. Parse the JSON response and extract the text
            JsonNode responseJson = objectMapper.readTree(response.getBody());
            return responseJson
                    .path("content")
                    .get(0)
                    .path("text")
                    .asText("No response from AI");

        } catch (Exception e) {
            e.printStackTrace();
            return "AI service error: " + e.getMessage() +
                   ". Please check your API key in AIService.java";
        }
    }
}
