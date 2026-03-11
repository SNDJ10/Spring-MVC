<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Products - AI Product Assistant</title>
    <style>
        * { box-sizing: border-box; margin: 0; padding: 0; font-family: 'Segoe UI', sans-serif; }
        body { background: #f0f4f8; }

        .navbar {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            padding: 15px 30px; display: flex; align-items: center;
            justify-content: space-between; color: white;
            box-shadow: 0 2px 10px rgba(0,0,0,0.2);
        }
        .navbar h1 { font-size: 22px; }
        .navbar a {
            color: white; text-decoration: none; margin-left: 20px;
            background: rgba(255,255,255,0.2); padding: 8px 16px;
            border-radius: 20px; font-size: 14px;
        }
        .navbar a:hover { background: rgba(255,255,255,0.4); }

        .container { max-width: 1100px; margin: 40px auto; padding: 0 20px; }
        h2 { color: #4a5568; margin-bottom: 20px; }

        .message { padding: 12px 16px; border-radius: 8px; background: #c6f6d5; color: #276749; font-weight: 600; margin-bottom: 15px; }

        table { width: 100%; border-collapse: collapse; background: white; border-radius: 12px; overflow: hidden; box-shadow: 0 4px 20px rgba(0,0,0,0.1); }
        th { background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); color: white; padding: 14px 16px; text-align: left; font-size: 14px; }
        td { padding: 12px 16px; border-bottom: 1px solid #e2e8f0; font-size: 14px; color: #4a5568; }
        tr:hover { background: #f7fafc; }

        .btn-edit { background: #4299e1; color: white; padding: 6px 14px; border-radius: 6px; text-decoration: none; font-size: 13px; }
        .btn-delete { background: #fc8181; color: white; padding: 6px 14px; border-radius: 6px; text-decoration: none; font-size: 13px; margin-left: 6px; }
        .btn-edit:hover { background: #3182ce; }
        .btn-delete:hover { background: #e53e3e; }

        .empty { text-align: center; padding: 40px; color: #a0aec0; }
        .badge {
            display: inline-block; padding: 3px 10px; border-radius: 12px;
            font-size: 12px; font-weight: 600;
            background: #ebf8ff; color: #2b6cb0;
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
    <h2>📦 All Products</h2>

    <c:if test="${not empty message}">
        <div class="message">${message}</div>
    </c:if>

    <c:choose>
        <c:when test="${empty products}">
            <div class="empty">
                <p style="font-size: 48px;">📭</p>
                <p style="font-size: 18px; margin-top: 10px;">No products yet. <a href="/">Add one!</a></p>
            </div>
        </c:when>
        <c:otherwise>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Product Name</th>
                    <th>Category</th>
                    <th>Price (₹)</th>
                    <th>Quantity</th>
                    <th>Supplier Email</th>
                    <th>Actions</th>
                </tr>
                <c:forEach var="p" items="${products}">
                    <tr>
                        <td>${p.id}</td>
                        <td><strong>${p.productName}</strong></td>
                        <td><span class="badge">${p.category}</span></td>
                        <td>₹${p.price}</td>
                        <td>${p.quantity}</td>
                        <td>${p.supplierEmail}</td>
                        <td>
                            <a href="/updateRequest?id=${p.id}" class="btn-edit">✏️ Edit</a>
                            <a href="/deleteRequest?id=${p.id}" class="btn-delete"
                               onclick="return confirm('Delete this product?')">🗑️ Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
