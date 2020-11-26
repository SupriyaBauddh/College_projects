<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="user.css">
        <title>Customer details</title>
        <style>
         body{
             margin:0;
         }
         #container1{
             width:100vw;
             height: 10vh;
             background-color: lightblue;
             box-sizing: border-box;
             padding: 32px;
             display: flex;
             text-align:center;
             flex-direction:row;
             justify-content: space-between;
             flex-wrap: wrap;
             align-items:stretch ;
             align-content: flex-start;
         }
         #container{
             width:100vw;
             height: 70vh;
             background-color: lightblue;
             box-sizing: border-box;
             padding: 32px;
             display: flex;
             flex-direction:row;
             justify-content: space-between;
             flex-wrap: wrap;
             align-items:stretch ;
             align-content: flex-start;
         }
         .item{
             background-color: lightcoral;
             height:40px;
             margin: 10px;
             padding: 20px;
             font-size: large;
             text-align: center;
             flex-grow: 1;
         }
         .dropbtn {
    background-color: black;
    color: white;
    padding: 16px;
    font-size: 16px;
    border: none;
}

.dropdown {
    position: relative;
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: lightgrey;
    min-width: 200px;
    z-index: 1;
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}

.dropdown-content a:hover {background-color: white;}
.dropdown:hover .dropdown-content {display: block;}
.dropdown:hover .dropbtn {background-color: grey;}


         </style>
    </head>   
    <body style="background-color:lightblue;">
      <header> <h2 class="t">
            <img src="logo.jpg" heigth="90px" width="90px">
            Choose Your Dream Destination with <u>TROUVAILLE</u></h2></header>
            <main>
       
    </main>
    
   

       
 <footer class="foot">
    <nav>    
          <a href="dbms.php">HOME</a>
          <a href="index.php">PACKAGES</a>
          <a href="about.php">ABOUT-Us/Contact-Us</a>
          <a href="offers.php">OFFERS</a>
          <a href="faq.php">FAQs</a>     
    </nav>
    </footer>
    </body>
</html>