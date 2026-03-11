<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>AI Product Assistant</title>
    <style>
        * { box-sizing: border-box; margin: 0; padding: 0; font-family: 'Segoe UI', sans-serif; }
        body { background: #f0f4f8; }

        .navbar {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            padding: 15px 30px;
            display: flex;
            align-items: center;
            justify-content: space-between;
            color: white;
            box-shadow: 0 2px 10px rgba(0,0,0,0.2);
        }
        .navbar h1 { font-size: 22px; }
        .navbar a {
            color: white; text-decoration: none; margin-left: 20px;
            background: rgba(255,255,255,0.2); padding: 8px 16px;
            border-radius: 20px; font-size: 14px; transition: 0.3s;
        }
        .navbar a:hover { background: rgba(255,255,255,0.4); }

        .container { max-width: 700px; margin: 40px auto; padding: 0 20px; }

        .card {
            background: white; border-radius: 12px;
            padding: 30px; box-shadow: 0 4px 20px rgba(0,0,0,0.1);
        }
        .card h2 { color: #4a5568; margin-bottom: 25px; font-size: 20px; }

        .form-group { margin-bottom: 18px; }
        .form-group label { display: block; margin-bottom: 6px; color: #4a5568; font-weight: 600; font-size: 14px; }
        .form-group input, .form-group select {
            width: 100%; padding: 10px 14px; border: 2px solid #e2e8f0;
            border-radius: 8px; font-size: 14px; transition: 0.3s;
        }
        .form-group input:focus, .form-group select:focus {
            outline: none; border-color: #667eea;
        }

        .row { display: flex; gap: 15px; }
        .row .form-group { flex: 1; }

        .btn {
            width: 100%; padding: 12px; background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white; border: none; border-radius: 8px; font-size: 16px;
            cursor: pointer; transition: 0.3s; font-weight: 600;
        }
        .btn:hover { opacity: 0.9; transform: translateY(-1px); }

        .message {
            margin-top: 15px; padding: 12px 16px; border-radius: 8px;
            background: #c6f6d5; color: #276749; font-weight: 600;
        }

        .ai-banner {
            background: linear-gradient(135deg, #f093fb 0%, #f5576c 100%);
            border-radius: 12px; padding: 20px 30px; margin-bottom: 25px;
            color: white; text-align: center;
        }
        .ai-banner h3 { font-size: 18px; margin-bottom: 6px; }
        .ai-banner p { font-size: 14px; opacity: 0.9; }
        .ai-banner a {
            display: inline-block; margin-top: 12px; background: white;
            color: #f5576c; padding: 8px 20px; border-radius: 20px;
            text-decoration: none; font-weight: 700; font-size: 14px;
        }
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
    <!-- AI Banner -->
    <div class="ai-banner">
        <h3>✨ Powered by Claude AI</h3>
        <p>Auto-generate descriptions, get price suggestions, analyze inventory & chat with your data!</p>
        <a href="/aiTools">Try AI Tools →</a>
    </div>

    <!-- Product Registration Form -->
    <div class="card">
        <h2>📦 Register New Product</h2>
        <form action="/register" method="post">
            <div class="form-group">
                <label>Product Name</label>
                <input type="text" name="productName" placeholder="e.g. Wireless Headphones" required />
            </div>
            <div class="row">
                <div class="form-group">
                    <label>Category</label>
                    <select name="category">
                        <option value="Electronics">Electronics</option>
                        <option value="Clothing">Clothing</option>
                        <option value="Food">Food</option>
                        <option value="Books">Books</option>
                        <option value="Sports">Sports</option>
                        <option value="Home">Home & Kitchen</option>
                        <option value="Other">Other</option>
                    </select>
                </div>
                <div class="form-group">
                    <label>Price (₹)</label>
                    <input type="number" name="price" placeholder="0.00" step="0.01" required />
                </div>
            </div>
            <div class="row">
                <div class="form-group">
                    <label>Quantity</label>
                    <input type="number" name="quantity" placeholder="0" required />
                </div>
                <div class="form-group">
                    <label>Supplier Email</label>
                    <input type="email" name="supplierEmail" placeholder="supplier@email.com" required />
                </div>
            </div>
            <div class="form-group">
                <label>Description (optional - or use AI to generate!)</label>
                <input type="text" name="description" placeholder="Product description..." />
            </div>
            <button type="submit" class="btn">💾 Save Product</button>
        </form>

        <%-- Display success/error message (same as your project) --%>
        <% if (request.getAttribute("message") != null) { %>
            <div class="message">${message}</div>
        <% } %>
    </div>
</div>
</body>
</html>
