<%@ page isELIgnored="false" %>

<h2>Product Registration</h2>

<form action="register" method="post">
    Name: <input type="text" name="productName" required><br>
    Category: <input type="text" name="category"><br>
    Price: <input type="number" name="price" required><br>
    Quantity: <input type="number" name="quantity"><br>
    Supplier Email: <input type="email" name="supplierEmail" required><br>
    <button type="submit">Register</button>
</form>

<h3>${message}</h3>

<a href="fetchData">View All Products</a>