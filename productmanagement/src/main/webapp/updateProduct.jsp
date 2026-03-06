<%@ page isELIgnored="false" %>

<h2>Update Product</h2>

<form action="update" method="post">

    ID: <input type="number" name="id"
        value="${product.id}" readonly><br>

    Name: <input type="text" name="productName"
        value="${product.productName}" required><br>

    Category: <input type="text" name="category"
        value="${product.category}"><br>

    Price: <input type="number" name="price"
        value="${product.price}" required><br>

    Quantity: <input type="number" name="quantity"
        value="${product.quantity}"><br>

    Email: <input type="email" name="supplierEmail"
        value="${product.supplierEmail}" readonly><br>

    <button type="submit">Update</button>

</form>