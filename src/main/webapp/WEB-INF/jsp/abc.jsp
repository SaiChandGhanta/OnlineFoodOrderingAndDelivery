<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Add Pizza Form</title>
</head>
<body>

<h2>Add a New Pizza</h2>

<form:form modelAttribute="pizza" method="post">

<table>
<tr>
    <td>Pizza Name:</td>
    <td><form:input path="name" size="30" /></td>
</tr>

<tr>
    <td>Pizza category:</td>
    <td><form:input path="category" size="30" /></td>
</tr>

<tr>
    <td>Pizza price:</td>
    <td><form:input path="price" size="30" /></td>
</tr>
<tr>
    <td>Pizza image:</td>
    <td><form:input path="image" size="30" /></td>
</tr>
<tr>
    <td>Pizza description:</td>
    <td><form:input path="description" size="30" /></td>
</tr>

<tr>
    <td colspan="2"><input type="submit" value="Create Pizza" /></td>
</tr>
</table>

</form:form>

</body>
</html>