<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Simple Calculator</title>
</head>
<body>
    <h2>Calculator</h2>
    <form method="post">
        <input type="number" name="num1" required>
        <select name="operator">
            <option value="+">+</option>
            <option value="-">-</option>
            <option value="*">*</option>
            <option value="/">/</option>
        </select>
        <input type="number" name="num2" required>
        <button type="submit">Calculate</button>
    </form>

    <%
        String n1 = request.getParameter("num1");
        String n2 = request.getParameter("num2");
        String op = request.getParameter("operator");

        if (n1 != null && n2 != null && op != null) {
            double num1 = Double.parseDouble(n1);
            double num2 = Double.parseDouble(n2);
            double result = 0;

            switch (op) {
                case "+": result = num1 + num2; break;
                case "-": result = num1 - num2; break;
                case "*": result = num1 * num2; break;
                case "/": 
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        out.println("<p style='color:red;'>Cannot divide by zero!</p>");
                    }
                    break;
            }
            out.println("<h3>Result: " + result + "</h3>");
        }
    %>
</body>
</html>
