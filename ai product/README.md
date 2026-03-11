# 🤖 AI Product Assistant
### Built with: Spring MVC + JPA/Hibernate + MySQL + Claude AI API

---

## 📁 Project Structure (Same as your productmanagement project!)

```
ai-product-assistant/
├── src/main/java/com/xworkz/aiproduct/
│   ├── configuration/
│   │   ├── WebInit.java          ← Same as your project
│   │   └── WebConfiguration.java ← Same + RestTemplate bean (for AI API)
│   ├── controller/
│   │   └── ProductController.java ← CRUD + 4 AI endpoints
│   ├── service/
│   │   ├── ProductService.java
│   │   ├── ProductServiceImpl.java ← Same as your project
│   │   └── AIService.java         ← ⭐ NEW: Calls Claude AI API
│   ├── repo/
│   │   ├── ProductDAO.java
│   │   └── ProductDAOImpl.java    ← Same as your project
│   ├── entity/
│   │   └── ProductEntity.java     ← Same as your project
│   └── dto/
│       └── ProductDTO.java        ← Same as your project
│
└── src/main/webapp/WEB-INF/views/
    ├── index.jsp          ← Add product form
    ├── fetchProducts.jsp  ← View all products
    ├── updateProduct.jsp  ← Edit product
    └── aiTools.jsp        ← ⭐ NEW: 4 AI features page
```

---

## 🚀 Setup Steps

### Step 1: Get Claude API Key (FREE to start)
1. Go to https://console.anthropic.com
2. Sign up / Log in
3. Click "API Keys" → "Create Key"
4. Copy your key

### Step 2: Add API Key to Project
Open `AIService.java` and replace:
```java
private static final String CLAUDE_API_KEY = "YOUR_CLAUDE_API_KEY_HERE";
```
with your actual key:
```java
private static final String CLAUDE_API_KEY = "sk-ant-api03-...";
```

### Step 3: Setup MySQL Database
```sql
CREATE DATABASE ai_product_db;
```
Hibernate will auto-create the `ai_product_tb` table!

Update `WebConfiguration.java` with your MySQL password:
```java
ds.setPassword("your_mysql_password");
```

### Step 4: Run on Tomcat
- Import project in IntelliJ IDEA
- Add Tomcat server (same as your productmanagement project)
- Run! Visit: http://localhost:8080

---

## ✨ AI Features Explained

| Feature | How It Works |
|---|---|
| **Generate Description** | You enter product name + category → AI writes a professional description |
| **Price Suggestion** | AI analyzes product details and suggests fair INR price range |
| **Inventory Analysis** | AI reads ALL your products from DB and gives business insights |
| **Chat with Data** | Ask plain English questions about your inventory |

---

## 🔧 What's New vs Your Project

| Your Project | This AI Project |
|---|---|
| ProductController | ProductController + 4 AI endpoints |
| ProductService | ProductService + **AIService** (new!) |
| RestTemplate | **Added** (calls Claude API) |
| Jackson | **Added** (parse JSON responses) |
| 3 JSP pages | **4 JSP pages** (+ aiTools.jsp) |

### The AI magic is all in one file: `AIService.java`
- Uses `RestTemplate` (standard Spring class you already have)
- Sends HTTP POST to `https://api.anthropic.com/v1/messages`
- Parses JSON response with Jackson
- That's it! Just like calling any REST API.

---

## 💡 How the AI Call Works (Simple Explanation)

```
Your Java code → HTTP POST → Claude AI API → JSON Response → Display in JSP
     ↑                                              ↓
  (RestTemplate)                           (ObjectMapper/Jackson)
```

It's exactly like calling any other REST API! No ML knowledge needed.
