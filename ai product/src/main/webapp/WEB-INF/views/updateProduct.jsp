<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Product</title>
    <style>
        * { box-sizing: border-box; margin: 0; padding: 0; font-family: 'Segoe UI', sans-serif; }
        body { background: #f0f4f8; }
        .navbar {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            padding: 15px 30px; display: flex; align-items: center;
            justify-content: space-between; color: white;
        }
        .navbar h1 { font-size: 22px; }
        .navbar a { color: white; text-decoration: none; margin-left: 20px; background: rgba(255,255,255,0.2); padding: 8px 16px; border-radius: 20px; font-size: 14px; }
        .container { max-width: 600px; margin: 40px auto; padding: 0 20px; }
        .card { background: white; border-radius: 12px; padding: 30px; box-shadow: 0 4px 20px rgba(0,0,0,0.1); }
        .card h2 { color: #4a5568; margin-bottom: 25px; }
        .form-group { margin-bottom: 18px; }
        .form-group label { display: block; margin-bottom: 6px; color: #4a5568; font-weight: 600; font-size: 14px; }
        .form-group input { width: 100%; padding: 10px 14px; border: 2px solid #e2e8f0; border-radius: 8px; font-size: 14px; }
        .form-group input:focus { outline: none; border-color: #667eea; }
        .btn { width: 100%; padding: 12px; background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); color: white; border: none; border-radius: 8px; font-size: 16px; cursor: pointer; font-weight: 600; }
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
    <div class="card">
        <h2>✏️ Update Product</h2>
        <form action="/update" method="post">
            <input type="hidden" name="id" value="${product.id}" />
            <div class="form-group">
                <label>Product Name</label>
                <input type="text" name="productName" value="${product.productName}" required />
            </div>
            <div class="form-group">
                <label>Category</label>
                <input type="text" name="category" value="${product.category}" required />
            </div>
            <div class="form-group">
                <label>Price (₹)</label>
                <input type="number" name="price" value="${product.price}" step="0.01" required />
            </div>
            <div class="form-group">
                <label>Quantity</label>
                <input type="number" name="quantity" value="${product.quantity}" required />
            </div>
            <div class="form-group">
                <label>Supplier Email</label>
                <input type="email" name="supplierEmail" value="${product.supplierEmail}" required />
            </div>
            <div class="form-group">
                <label>Description</label>
                <input type="text" name="description" value="${product.description}" />
            </div>
            <button type="submit" class="btn">💾 Update Product</button>
        </form>
    </div>
</div>
</body>
</html>
