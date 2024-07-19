
<body>

<h1>Spring Boot and MySQL Filter and Sort API</h1>

<h2>Objective</h2>
<p>A Spring Boot application that interacts with a MySQL database to provide an API that filters and sorts product records based on specified parameters.</p>

<h2>Setup</h2>
<ol>
    <li>Clone the repository</li>
    <li>Set up your MySQL database and update the application.properties file with your database connection details</li>
    <li>Build and run the application</li>
</ol>

<h3>Clone the Repository</h3>
<pre><code>git clone &lt;repository-url&gt;</code></pre>

<h3>Set Up MySQL Database</h3>
<p>Create a database in MySQL and update the <code>application.properties</code> file with your database connection details:</p>
<pre><code>spring.datasource.url=jdbc:mysql://localhost:3306/yourdatabase
spring.datasource.username=yourusername
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update</code></pre>

<h3>Build and Run the Application</h3>
<pre><code>cd &lt;project-directory&gt;
mvn clean install
mvn spring-boot:run</code></pre>

<h2>API Endpoints</h2>

<h3>Post /products</h3>
<h3>GET /products</h3>
<p>Fetch products with optional filtering and sorting.</p>

<h4>Query Parameters</h4>
<ul>
    <li><code>category</code> (optional): Filter by category.</li>
    <li><code>minPrice</code> (optional): Filter by minimum price.</li>
    <li><code>maxPrice</code> (optional): Filter by maximum price.</li>
    <li><code>inStock</code> (optional): Filter by stock availability.</li>
    <li><code>sortField</code> (optional): The field to sort by (one of <code>price</code>, <code>rating</code>, <code>createdAt</code>). Default is <code>createdAt</code>.</li>
    <li><code>sortOrder</code> (optional): The sort order (<code>asc</code> or <code>desc</code>). Default is <code>asc</code>.</li>
</ul>

<h4>Server Port = 8811</h4>
<h4>Example Request</h4>
<pre><code>GET /products?category=electronics&minPrice=100&maxPrice=1000&inStock=true&sortField=price&sortOrder=asc</code></pre>

<h4>Example Response</h4>
<pre><code>[
  {
    "id": 1,
    "name": "Smartphone",
    "category": "electronics",
    "price": 299.99,
    "inStock": true,
    "rating": 4.5,
    "createdAt": "2023-01-15T12:00:00Z"
  },
  {
    "id": 2,
    "name": "Laptop",
    "category": "electronics",
    "price": 899.99,
    "inStock": true,
    "rating": 4.7,
    "createdAt": "2023-03-20T08:30:00Z"
  }
]</code></pre>

<h3>POST /products</h3>
<p>Create a new product.</p>

<h4>Request Body</h4>
<pre><code>{
  "name": "Smartphone",
  "category": "electronics",
  "price": 299.99,
  "inStock": true,
  "rating": 4.5
}</code></pre>

<h4>Example Response</h4>
<pre><code>{
  "id": 1,
  "name": "Smartphone",
  "category": "electronics",
  "price": 299.99,
  "inStock": true,
  "rating": 4.5,
  "createdAt": "2023-01-15T12:00:00Z"
}</code></pre>

<h2>Project Structure</h2>
<ul>
    <li><code>src/main/java/com/example/productapi/</code>: Main application package</li>
    <ul>
        <li><code>controller/</code>: REST controllers</li>
        <li><code>model/</code>: JPA entity models</li>
        <li><code>repository/</code>: Spring Data JPA repositories</li>
        <li><code>service/</code>: Service layer</li>
    </ul>

</ul>
</body>
</html>
