<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Sign Up Page</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>

<form action="signup" method="post">

  <label for="name">Name : </label>
  <input type="text" placeholder="Enter your name" name="name" id="name"><br><br>

  <label for="surname">Surname : </label>
  <input type="text" placeholder="Enter your surname" name="surname" id="surname"><br><br>

  <label for="phoneNumber">Phone Number : </label>
  <input type="number" placeholder="Enter your phoneNumber" name="phoneNumber" id="phoneNumber"><br><br>

  <label for="email">Email : </label>
  <input type="email" placeholder="Enter your email" name="email" id="email"><br><br>

  <label for="username">Username : </label>
  <input type="text" placeholder="Enter your username" name="username" id="username"><br><br>

  <label for="password">Password : </label>
  <input type="text" placeholder="Enter your password" name="password" id="password"><br><br>

  <label for="confirmPassword">Confirm Password : </label>
  <input type="text" placeholder="Confirm your Password" name="confirmPassword" id="confirmPassword"><br><br>

  <button type="submit">Submit</button>

</form>

</body>
</html>