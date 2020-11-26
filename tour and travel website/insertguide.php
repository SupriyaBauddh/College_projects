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
            Guide Id: <br>
            <input type="Text" name="H_id" placeholder="Package Id"> <br><br>
            Guide name: <br>
            <input type="Text" name="H_Name" placeholder="Package name" autofocus required> <br><br>
            Sex:<br>
            <input type="radio" name="Sex" value="m">Male</input>
       <input type="radio" name="Sex" value="f">Female</input>
       <input type="radio" name="Sex" value="o">Other</input><br><br>
            Phone-no:<br>
            <input type="number" name="Contact" minlength="10" ><br><br>
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
    $G_id=$_POST['G_id'];
    $Name=$_POST['G_name'];
    $Sex=$_POST['Sex'];
    $Contact=$_POST['Contact'];
$P_id=$_POST['P_id'];


$Connection=mysql_connect('localhost','root','');
$Selected= mysql_select_db('tour',$Connection);

	$Query="INSERT INTO guide
    VALUES('$G_id','$G_name','$Sex', '$Contact','$P_id')" ;
			


$Execute=mysql_query($Query);

if($Execute){
    echo "<h2 >Inserted </h2>";
    header('location:insertguide.php');
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