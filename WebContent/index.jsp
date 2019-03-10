<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="api_calls.ApiCalls" %>
<%@page import="api_calls.CityDetails"%>
<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONException"%>
<%@page import="java.io.IOException"%>

<html>
   <head>
      <title>Weather Forecast</title>
      
      <style>
        table, th, td {
                                border: 1px solid black;
                                border-collapse: collapse;
                                text-align:center;
                                padding:15px;
                          }
       body {
                    background-image: url("https://tribkcpq.files.wordpress.com/2012/11/sunsetoversound1.jpg?quality=85&strip=all");
                    background-size: 100% 100%;
                }
        a{
            color:black;
                }
      </style>
   </head>
   
   <body>
       <a href = "index.html">Back to Previous  Page</a>
       <%
            Integer cod = 0;
            ApiCalls citydata = new ApiCalls();
            CityDetails  weatherData = null;
            JSONObject jsndata = null;
            try{
                jsndata = citydata.fetchData(request.getParameter("city"));
                weatherData = new CityDetails(jsndata);
            }catch(IOException e){
                System.out.println("An IOException occurred at jsp page " + e.getMessage());
                cod = 404;
            }catch(JSONException e){
                System.out.println("An JSONException occurred at jsp page " + e.getMessage());
                cod = 404;
            }
            
       %>
      <center>
          <%
              if(cod == 404)
              {
           %>
                 <h1>Sorry :(  Weather Data for <%= request.getParameter("city")%> is not present in the Database.</h1>
          <% } else 
            
          {%>
          <h1>Here Is the Current Weather Forecasts For the City: <%= request.getParameter("city")%></h1>
          <table>
            <tr>
                <th>City Name</th>
                <th>City Id</th>
                <th>Current Temperature (Kelvin)</th>
                <th>Today Minimum Temperature (Kelvin)</th>
                <th>Today Maximum Temperature (Kelvin)</th>
                <th>Pressure (hPa)</th>
                <th>Humidity (%)</th>
                <th>Wind Speed (meter/sec)</th>
                <th>Wind Direction (Degrees) </th>
            </tr>
            <tr>
                <td><%=weatherData.getName()%></td>
                <td><%=weatherData.getId()%></td>
                <td><%=weatherData.getTemperature()%></td>
                <td><%=weatherData.getMinTemperature()%></td>
                <td><%=weatherData.getMaxTemperature()%></td>
                <td><%=weatherData.getPressure()%></td>
                <td><%=weatherData.getHumidity()%></td>
                <td><%=weatherData.getWindSpeed()%></td>
                <td><%=weatherData.getWindDirc()%></td>
            </tr>
          </table>
          <%}%>
          </center>
   </body>
</html>