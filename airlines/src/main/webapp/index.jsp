

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Airlines Booking</title>

    <script>
        function validateForm() {

            let studentId = document.getElementById("studentId").value;
            let studentName = document.getElementById("studentName").value;
            let cllgName = document.getElementById("cllgName").value;
            let phone = document.getElementById("studentPhoneNumber").value;
            let email = document.getElementById("studentEmail").value;

            if (studentId.length !== 5) {
                alert("Booking ID must be exactly 5 characters");
                return false;
            }

            if (studentName === null || studentName.trim().length <= 3) {
                alert("Passenger Name must be more than 3 characters");
                return false;
            }

            if (cllgName === null || cllgName.trim().length <= 5) {
                alert("Airline Name must be more than 5 characters");
                return false;
            }

            if (phone.length !== 10 || isNaN(phone)) {
                alert("Mobile Number must be exactly 10 digits");
                return false;
            }

            if (!email.includes("@gmail.com")) {
                alert("Email must be a Gmail address (@gmail.com)");
                return false;
            }

            return true;
        }
    </script>
</head>

<body style="background-color:black;">

<div style="margin:auto;
            text-align:center;
            width:400px;
            border:2px solid black;
            padding:20px;
            border-radius:10px;
            background-color:rgb(248,248,141);">

    <h1>AIRLINES BOOKING FORM</h1>

    <form action="studentDetails" method="post" onsubmit="return validateForm()">

        <label>Booking ID:</label><br>
        <input type="text" id="studentId" name="studentId"><br><br>

        <label>Passenger Name:</label><br>
        <input type="text" id="studentName" name="studentName"><br><br>

        <label>Airline Name:</label><br>
        <input type="text" id="cllgName" name="cllgName"><br><br>

        <label>Mobile Number:</label><br>
        <input type="text" id="studentPhoneNumber" name="studentPhoneNumber"><br><br>

        <label>Email:</label><br>
        <input type="email" id="studentEmail" name="studentEmail"><br><br>

        <input type="submit" value="Book Ticket">
    </form>
</div>

</body>
</html>

