<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
   
    <form action="/weather/zipweb"  method="post">
     <body>
        <h1>Get the Weather for the next Seven Days</h1>
        <p>Display Data as:</p>
        <input type="radio" name="type" value="XML">XML<br>
        <input type="radio" name="type" value="JSON" checked="checked">JSON<br>
        <br>
        Enter zip codes separated by ',' <input id="zips" type="text" name="zips" size="15">
    <input type="submit" value="Weather"/> <br/>
    </body>
 </form>
    
</html>
