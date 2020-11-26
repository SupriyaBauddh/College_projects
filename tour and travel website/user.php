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
            <h3 style="text-align: center;"><a href="user.php" >Signup</a> &ensp;/&ensp;<a href="dbms.php" > Back</a></h3>
            First name: <br>
            <input type="Text" name="Fname" placeholder="First name" autofocus required> <br><br>
            Last name: <br>
            <input type="Text" name="Lname" placeholder="last name"> <br><br>
            Email:<br>
            <input type="Email" name="Email" placeholder="Email" > <br><br>
            Phone no:<br>
            <input type="Number" name="Phone" placeholder="Phone no." > <br>  <br>
            Password:<br>
            <input type="Password" name="Pass" required ><br><br>
            Confirm Password:<br>
            <input type="Password" name="C_pass" required ><br><br>
          Gender:
       <input type="radio" name="Sex" value="M">Male</input>
       <input type="radio" name="Sex" value="F">female</input>
       <input type="radio" name="Sex" value="O">Other</input><br><br>
       Age:
       <input type="Number" name="Age" placeholder="Age"><br><br>
       Package:<br>
       <select name="P_id">
           <option value="P001">The mist of Manali</option>
           <option value="P002">Goa Family Gateways</option>
           <option value="P003">Jewels of south india</option>
           <option value="P004">Essential Andaman</option>
           <option value="P005">Khasi pigrimage tour</option>
       </select><br><br>
       <button type="Submit" name="Submit" value="Submit your record">SUBMIT</button>
           <input type="Reset" value="Reset"><br>
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
    
    $Fname=$_POST['Fname'];
    $Lname=$_POST['Lname'];
    $Email=$_POST['Email'];
    $Phone=$_POST['Phone'];
    $Pass=$_POST['Pass'];
    $Sex=$_POST['Sex'];
    $Age=$_POST['Age'];
    $P_id=$_POST['P_id'];


$Connection=mysql_connect('localhost','root','');
$Selected= mysql_select_db('tour',$Connection);

	$Query="INSERT INTO customer
    VALUES('$Fname','$Lname','$Email', '$Phone','$Pass','$Sex', '$Age','$P_id')" ;
			


$Execute=mysql_query($Query);

if($Execute){
	echo "<h2>Record saved </h2>";
}
else
{
  echo "<h2>Already register </h2>";
}
}
 ?>
    </body>
</html>