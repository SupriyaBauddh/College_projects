<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="user.css">
        <title>Customer details</title>
    </head>   
    <body style="background-color:lightblue;">
      <header> <h2 class="t">
            <img src="logo.jpg" heigth="90px" width="90px">
            Choose Your Dream Destination with <u>TROUVAILLE</u></h2></header>
            <main>
        <form id="fm" action="" method="post">
            <h3 style="text-align: center;"><a href="/xampp/htdocs/tour/user.html" >Details of Dependes</a></h3>
            Name: <br>
            <input type="Text" name="D_nme" placeholder="First name" autofocus required> <br><br>
            Email:<br>
            <input type="Email" name="D_id" placeholder="Email" > <br><br>
          Gender:<br>
       <input type="radio" name="Sex" value="M">Male</input>
       <input type="radio" name="Sex" value="F">female</input>
       <input type="radio" name="Sex" value="O">Other</input><br><br>
       Age:
       <input type="Number" name="Age" placeholder="Age"><br><br>   
       <button type="Submit" name="Submit" value="Submit your record"> Next dependes</a></button>
            
       <a href="dbms.php">Home</a>
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
    
    $D_name=$_POST['D_name'];
    $D_id=$_POST['D_id'];
    $Sex=$_POST['Sex'];
    $Age=$_POST['Age'];
  


$Connection=mysql_connect('localhost','root','');
$Selected= mysql_select_db('tour',$Connection);

	$Query="INSERT INTO dependents
    VALUES('$D_name','$D_id', '$Sex', '$Age' ,"191210050@nitdelhi.ac.in")" ;
			


$Execute=mysql_query($Query);

if($Execute){
	header("location: depend.php");
}
else
{
  echo "<h2>wrong </h2>";
}
}
 ?>
    </body>
</html>
