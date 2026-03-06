<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>Product List</h2>

<table border="1">
<tr>
    <th>Name</th>
    <th>Category</th>
    <th>Price</th>
    <th>Quantity</th>
    <th>Email</th>
    <th>Update</th>
    <th>Delete</th>
</tr>

<c:forEach items="${products}" var="p">
<tr>
    <td>${p.productName}</td>
    <td>${p.category}</td>
    <td>${p.price}</td>
    <td>${p.quantity}</td>
    <td>${p.supplierEmail}</td>
    <td>
        <a href="updateRequest?id=${p.id}">Update</a>

    </td>
    <td> <a href="deleteRequest?id=${p.id}">delete</a>
    </td>
</tr>
</c:forEach>

</table>

<a href="/">Back</a>