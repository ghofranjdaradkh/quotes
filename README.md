# quotes

 # Lab 8 :

A client program communicates with a server via a URL follows this sequence of steps:
 ## Create a URL object
<pre>
URL url = new URL ("example.json");
 </pre>
## Obtain a URLConnection object from the URL
<pre>
invoke the openConnection method to get the HttpURLConnection object.
    URLConnection connection = url.openConnection();
>>If the protocol is http://, you can cast the returned object to an HttpURLConnection object:

HttpURLConnection connection = (HttpURLConnection) url.openConnection();
</pre>
## Set the Request Method
<pre>
sets the method for the URL request, which is one of HTTP methods GET, POST, HEAD, OPTIONS, PUT, DELETE and TRACE. The default method is GET.

connection.setRequestMethod("GET");
</pre>
 ## Get an input stream and read data
<pre>
Reading the response of the request can be done by parsing the InputStream of the HttpUrlConnection instance.

BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
String responseLine ;
StringBuilder response  = new StringBuilder();
while ((responseLine  = reader.readLine()) != null) {
response .append(responseLine);
}
 </pre>


## Close the connection
<pre>
To close the connection, invoke the close() method on either the InputStream or OutputStream object.

                   reader.close();

close the connection, we can use the disconnect() method:

con.disconnect();
</pre>

## GSON :
<pre>
library in java used to convert java object to Json representation.

when I want use this Library >>add this dependency to dependences in build Gradle

<pre>
"Implementation group: 'com.google.code.gson', name: 'gson', version: '2.7' " 
</pre>

Converting Java Object to JSON:

To convert a Java object to its JSON representation, you use the toJson() method provided by Gson. This process is commonly referred to as serialization. 
the toJson() method takes a Java object and converts it into a JSON string.



Parsing JSON Data:

Gson can indeed parse JSON data and create a corresponding Java object from it. This process is commonly referred to as deserialization. The method used for deserialization in Gson is fromJson(). 
It takes a JSON string and a class type, then converts the JSON into a Java object of the specified type.


in this lab we created class Quotes
 implement function randomRecentQuote to commuincate with URL and read the data and parse the data .
</pre>

output :
![Capture.PNG](pictures%2FCapture.PNG)

![outputlab8.PNG](pictures%2Foutputlab8.PNG)

![TESTCASSES8.PNG](pictures%2FTESTCASSES8.PNG)