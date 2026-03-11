<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>AI Tools - Product Assistant</title>
    <style>
        * { box-sizing: border-box; margin: 0; padding: 0; font-family: 'Segoe UI', sans-serif; }
        body { background: #f0f4f8; }

        .navbar {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            padding: 15px 30px; display: flex; align-items: center;
            justify-content: space-between; color: white; box-shadow: 0 2px 10px rgba(0,0,0,0.2);
        }
        .navbar h1 { font-size: 22px; }
        .navbar a { color: white; text-decoration: none; margin-left: 20px; background: rgba(255,255,255,0.2); padding: 8px 16px; border-radius: 20px; font-size: 14px; }
        .navbar a:hover { background: rgba(255,255,255,0.4); }

        .container { max-width: 900px; margin: 30px auto; padding: 0 20px; }

        .page-title { text-align: center; margin-bottom: 30px; }
        .page-title h2 { font-size: 28px; color: #4a5568; }
        .page-title p { color: #718096; margin-top: 6px; }

        .grid { display: grid; grid-template-columns: 1fr 1fr; gap: 20px; }

        .card {
            background: white; border-radius: 12px;
            padding: 24px; box-shadow: 0 4px 20px rgba(0,0,0,0.08);
            border-top: 4px solid transparent;
        }
        .card.purple { border-top-color: #9f7aea; }
        .card.pink   { border-top-color: #f687b3; }
        .card.blue   { border-top-color: #63b3ed; }
        .card.green  { border-top-color: #68d391; }
        .card.full-width { grid-column: 1 / -1; }

        .card h3 { font-size: 16px; color: #4a5568; margin-bottom: 16px; }
        .card .icon { font-size: 28px; margin-bottom: 10px; }

        .form-group { margin-bottom: 12px; }
        .form-group label { display: block; margin-bottom: 5px; font-size: 13px; color: #4a5568; font-weight: 600; }
        .form-group input, .form-group select, .form-group textarea {
            width: 100%; padding: 9px 12px; border: 2px solid #e2e8f0;
            border-radius: 8px; font-size: 13px; transition: 0.3s;
        }
        .form-group input:focus, .form-group select:focus, .form-group textarea:focus {
            outline: none; border-color: #9f7aea;
        }

        .btn {
            padding: 10px 20px; border: none; border-radius: 8px;
            font-size: 14px; cursor: pointer; font-weight: 600; transition: 0.3s;
        }
        .btn-purple { background: #9f7aea; color: white; }
        .btn-pink   { background: #f687b3; color: white; }
        .btn-blue   { background: #63b3ed; color: white; }
        .btn-green  { background: #48bb78; color: white; }
        .btn:hover  { opacity: 0.85; transform: translateY(-1px); }
        .btn-full   { width: 100%; }

        .ai-response {
            margin-top: 14px; padding: 14px; background: #f7fafc;
            border-radius: 8px; border-left: 4px solid #9f7aea;
            font-size: 14px; color: #2d3748; line-height: 1.6;
        }

        .chat-box { display: flex; gap: 10px; }
        .chat-box input { flex: 1; }

        .chat-q { background: #ebf8ff; border-left: 4px solid #63b3ed; padding: 12px; border-radius: 8px; margin-top: 10px; font-size: 14px; }
        .chat-a { background: #f0fff4; border-left: 4px solid #68d391; padding: 12px; border-radius: 8px; margin-top: 8px; font-size: 14px; line-height: 1.6; }

        .analyze-btn-wrap { text-align: center; margin-bottom: 16px; }
        .tip { font-size: 12px; color: #a0aec0; margin-top: 8px; }

        .loading { display: none; color: #9f7aea; font-size: 14px; margin-top: 8px; }
    </style>
</head>
<body>
<div class="navbar">
    <h1>🤖 AI Product Assistant</h1>
    <div>
        <a href="/">➕ Add Product</a>
        <a href="/fetchData">📦 All Products</a>
        <a href="/aiTools">✨ AI Tools</a>
    </div>
</div>

<div class="container">
    <div class="page-title">
        <h2>✨ AI-Powered Features</h2>
        <p>Claude AI helps you manage products smarter</p>
    </div>

    <div class="grid">

        <!-- AI TOOL 1: Generate Description -->
        <div class="card purple">
            <div class="icon">📝</div>
            <h3>Generate Product Description</h3>
            <form action="/ai/generateDescription" method="post">
                <div class="form-group">
                    <label>Product Name</label>
                    <input type="text" name="productName" placeholder="e.g. Wireless Headphones"
                           value="${productName}" required />
                </div>
                <div class="form-group">
                    <label>Category</label>
                    <select name="category">
                        <option>Electronics</option>
                        <option>Clothing</option>
                        <option>Food</option>
                        <option>Books</option>
                        <option>Sports</option>
                        <option>Home</option>
                        <option>Other</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-purple btn-full">🤖 Generate with AI</button>
            </form>
            <p class="tip">AI will write a professional product description for you!</p>
            <c:if test="${not empty aiDescription}">
                <div class="ai-response">
                    <strong>✨ AI Generated Description:</strong><br/><br/>
                    ${aiDescription}
                </div>
            </c:if>
        </div>

        <!-- AI TOOL 2: Price Suggestion -->
        <div class="card pink">
            <div class="icon">💰</div>
            <h3>AI Price Suggestion</h3>
            <form action="/ai/suggestPrice" method="post">
                <div class="form-group">
                    <label>Product Name</label>
                    <input type="text" name="productName" placeholder="e.g. Running Shoes"
                           value="${productName}" required />
                </div>
                <div class="form-group">
                    <label>Category</label>
                    <select name="category">
                        <option>Electronics</option>
                        <option>Clothing</option>
                        <option>Food</option>
                        <option>Books</option>
                        <option>Sports</option>
                        <option>Home</option>
                        <option>Other</option>
                    </select>
                </div>
                <div class="form-group">
                    <label>Description (optional)</label>
                    <input type="text" name="description" placeholder="Brief description..." />
                </div>
                <button type="submit" class="btn btn-pink btn-full">💡 Suggest Price</button>
            </form>
            <p class="tip">AI analyzes the market and suggests a fair price range in INR!</p>
            <c:if test="${not empty priceSuggestion}">
                <div class="ai-response">
                    <strong>💰 AI Price Suggestion for ${productName}:</strong><br/><br/>
                    ${priceSuggestion}
                </div>
            </c:if>
        </div>

        <!-- AI TOOL 3: Inventory Analysis -->
        <div class="card blue">
            <div class="icon">📊</div>
            <h3>Inventory Business Analysis</h3>
            <p style="font-size:14px; color:#718096; margin-bottom:14px;">
                AI reads all your products from the database and gives you smart business insights
                about pricing, stock levels, and category performance.
            </p>
            <div class="analyze-btn-wrap">
                <a href="/ai/analyzeInventory" class="btn btn-blue">📊 Analyze My Inventory</a>
            </div>
            <c:if test="${not empty analysis}">
                <div class="ai-response">
                    <strong>📊 AI Business Insights:</strong><br/><br/>
                    ${analysis}
                </div>
            </c:if>
        </div>

        <!-- AI TOOL 4: Chat with Products -->
        <div class="card green">
            <div class="icon">💬</div>
            <h3>Chat with Your Product Data</h3>
            <p style="font-size:13px; color:#718096; margin-bottom:12px;">
                Ask anything about your inventory in plain English!
            </p>
            <form action="/ai/chat" method="post">
                <div class="form-group chat-box">
                    <input type="text" name="question"
                           placeholder="e.g. Which product has lowest stock?"
                           value="${chatQuestion}" required />
                    <button type="submit" class="btn btn-green">Ask</button>
                </div>
            </form>
            <p class="tip">Try: "What is my most expensive product?" or "How many electronics do I have?"</p>
            <c:if test="${not empty chatQuestion}">
                <div class="chat-q">❓ <strong>You:</strong> ${chatQuestion}</div>
            </c:if>
            <c:if test="${not empty chatAnswer}">
                <div class="chat-a">🤖 <strong>AI:</strong> ${chatAnswer}</div>
            </c:if>
        </div>

    </div>
</div>
</body>
</html>
