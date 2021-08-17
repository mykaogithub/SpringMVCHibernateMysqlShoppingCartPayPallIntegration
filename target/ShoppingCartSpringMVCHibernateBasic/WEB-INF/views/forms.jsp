<html>
<head>
    <title>Invoice PDF Generator</title>
    <style type="text/css">
        .form-style-6 {
            font: 95% Arial, Helvetica, sans-serif;
            max-width: 400px;
            margin: 10px auto;
            padding: 16px;
            background: #F7F7F7;
        }
        .form-style-6 h1 {
            background: #43D1AF;
            padding: 20px 0;
            font-size: 140%;
            font-weight: 300;
            text-align: center;
            color: #fff;
            margin: -16px -16px 16px -16px;
        }
        .form-style-6 input[type="text"], .form-style-6 select {
            -webkit-transition: all 0.30s ease-in-out;
            -moz-transition: all 0.30s ease-in-out;
            -ms-transition: all 0.30s ease-in-out;
            -o-transition: all 0.30s ease-in-out;
            outline: none;
            box-sizing: border-box;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            width: 100%;
            background: #fff;
            margin-bottom: 4%;
            border: 1px solid #ccc;
            padding: 3%;
            color: #555;
            font: 95% Arial, Helvetica, sans-serif;
        }
        .form-style-6 input[type="text"]:focus, .form-style-6 select:focus {
            box-shadow: 0 0 5px #43D1AF;
            padding: 3%;
            border: 1px solid #43D1AF;
        }
        .form-style-6 input[type="submit"] {
            box-sizing: border-box;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            width: 100%;
            padding: 3%;
            background: #43D1AF;
            border-bottom: 2px solid #30C29E;
            border-top-style: none;
            border-right-style: none;
            border-left-style: none;
            color: #fff;
        }
        .form-style-6 input[type="submit"]:hover {
            background: #2EBC99;
        }
    </style>
</head>
<body>
    <div class="form-style-6">
        <h1>Invoice Generator Form</h1>
        <form method="post" action="${pageContext.request.contextPath}/invoice/generator/generate">
            <input type="text" name="orderNumber" placeholder="Order ID" required />
            <select name="lang" required>
                <option value="en">English</option>
                <option value="fr">French</option>
            </select>
            <input type="submit" value="Generate" />
        </form>
    </div>
    </body>
</html>