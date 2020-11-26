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
            <form id="fm" action=" " method="post" action="depend.php">
            <h3 style="text-align: center;"><a href=" user.php" >Insert values</a></h3>
            Package Id: <br>
            <input type="Text" name="P_id" placeholder="Package Id"> <br><br>
            Package name: <br>
            <input type="Text" name="P_Name" placeholder="Package name" autofocus required> <br><br>
            Amount:<br>
            <input type="Number" name="Amount" placeholder="Phone no." > <br>  <br>
            Offer Id:<br>
            <input type="text" name="Offer" ><br><br>
            
       <button type="Submit" name="Submit" value="Submit your record">SUBMIT</button>
           <input type="Reset" value="Reset"><br>
        </form>
    </main>
    
        <?php 
if(isset($_POST["Submit"]))
{
    
    $P_id=$_POST['P_id'];
    $P_name=$_POST['P_name'];
    $Amount=$_POST['Amount'];
    $Offer=$_POST['Offer'];



$Connection=mysql_connect('localhost','root','');
$Selected= mysql_select_db('tour',$Connection);

	$Query="INSERT INTO package
    VALUES('$P_id','$P_name','$Amount', '$Offer')" ;
			


$Execute=mysql_query($Query);

if($Execute){
	echo "<h2 >Inserted </h2>";
}
else
{
  echo "<h2>wrong </h2>";
}
}
 ?>
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