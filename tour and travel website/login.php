<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="user.css">
        <title>Login</title>

    </head>
    
    <body style="background-color:lightblue;">
        <header>
           
                <img src="logo.jpg" heigth="90px" width="90px">
                Choose Your Dream Destination with <u>TROUVAILLE</u></header>
                <main>
        <form action="" method="post" id="fm1">
            <h2 style="text-align: center;"><a href="login.php" >Admin Login</a></h2>
            
           Admin Id <br>
            <input type="text" name="A_id" placeholder="Admin Id" > <br><br>
            Password:<br>
            <input type="Password" name="A_pass" required ><br><br>
         
           <input  type ="submit" name="Submit" value="Login">
           <input type="reset" value="reset"><br>
           <a href="dbms.php" style="text-align:center"><h3>HOME</h3></a>
        </form>
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
    <?php
if(isset($_POST["Submit"]))
{

    $A_id=$_POST['A_id'];
    $A_pass=$_POST['A_pass'];

    mysql_connect('localhost','root','');
    mysql_select_db('tour');
    $Count="(select a_id from admin where a_id='$A_id' and a_pass='$A_pass')";
    $Execute=mysql_query($Count);

    $Result=mysql_fetch_assoc($Execute);


    if($Result)
    {
        header("location: adminlogin.php");
    }
    else
    {
        echo "data not found";
    }
}
?>
    </body>
</html>