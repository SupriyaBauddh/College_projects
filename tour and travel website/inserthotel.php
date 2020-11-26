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
            Hotel Id: <br>
            <input type="Text" name="H_id" placeholder="Package Id"> <br><br>
            Hotel name: <br>
            <input type="Text" name="H_Name" placeholder="Package name" autofocus required> <br><br>
            Type:<br>
            <input type="radio" name="Type" value="Ac">AC</input>
       <input type="radio" name="Type" value="Non Ac">NON AC</input><br><br>
            Address:<br>
            <input type="text" name="Address" ><br><br>
            Package Id:<br>
            <input type="text" name="P_id" ><br><br>
       <button type="Submit" name="Submit" value="Submit your record">SUBMIT</button>
           <input type="Reset" value="Reset"><br>
           <a href="adminlogin.php" style="text-align:center"><h2>Back</h2></a>
           <a href="logout.php" style="text-align:center"><h2>Logout</h2></a>
        </form>
    </main>
    
        <?php 
if(isset($_POST["Submit"]))
{   
    $H_id=$_POST['H_id'];
    $H_Name=$_POST['H_Name'];
    $Type=$_POST['Type'];
    $Address=$_POST['Address'];
    $P_id=$_POST['P_id'];


$Connection=mysql_connect('localhost','root','');
$Selected= mysql_select_db('tour',$Connection);

	$Query="INSERT INTO hotel
    VALUES('$H_id','$H_Name','$Type', '$Address','$P_id')" ;
			


$Execute=mysql_query($Query);

if($Execute){
    echo "<h2>Inserted data </h2>";
    header('location:inserthotel.php');
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