<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Personal information</title>
</head>
<body>

<h2>You are registred</h2>
<p>FirstName: ${person.firstName}</p>
<p>LastName: ${person.lastName}</p>
<p>email: ${person.email}</p>
<p>Notification is: <%= request.getParameter("notify")%></p>
<%=request.getParameter("gender")%>

</body>
</html>