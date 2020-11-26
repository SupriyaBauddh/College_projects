<?php
mysql_connect('localhost','root','');
mysql_select_db('tour');

?>

<!DOCTYPE >
<html html lang="en">
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="user.css">
        <title>Customer details</title>
        <style>
            .x{
                background-color:white;
                width="400px"
            }
            </style>
    </head>   
    <body style="background-color:lightblue;">
      <header> <h2 class="t">
            <img src="logo.jpg" heigth="90px" width="90px">
            Choose Your Dream Destination with <u>TROUVAILLE</u></h2></header>
            <main>
            <form id="fm" action=" " method="post" action="depend.php">
            <h3 style="text-align: center;"><a href=" user.php" >Delete values</a></h3>
            Hotel Id: <br>
            <input type="Text" name="H_idd" placeholder="Package Id"> <br><br>
         <!--   Package name: <br>
            <input type="Text" name="Pname" placeholder="Package name" autofocus required> <br><br>
-->
       <button type="Submit" name="Submit" value="Submit your record">SUBMIT</button>
           <input type="Reset" value="Reset"><br>
           <a href="adminlogin.php" style="text-align:center"><h2>Back</h2></a>
           <a href="logout.php" style="text-align:center"><h2>Logout</h2></a>
        </form>
        <?php
        $query="(select * from hotel  )";
        $result=mysql_query($query);

    ?>
    <table class="x"  align="center"; border="2px"  ; width="500px" ;>
        <tr>
            <td colspan="5">Hotel details</td>
            <tr>
                <td>H_id</td>
                <td>H_Name</td>
                <td>Type</td>
                <td>Address</td>
                <td>P_id</td>
                <tr>

    <?php

        while($rows=mysql_fetch_assoc($result))
        {
    ?>    
    <tr>

    <td><?php echo $rows['h_id']; ?></td>
    <td><?php echo $rows['h_name']; ?></td>
    <td><?php echo $rows['type']; ?></td>
    <td><?php echo $rows['address']; ?></td>
    <td><?php echo $rows['p_id']; ?></td>
    </tr>
        <?php
        } 
    ?>
    
    
    <br>
    </table>
    </main>
    
        <?php 
if(isset($_POST["Submit"]))
{   
    $H_idd=$_POST['H_idd'];

    



$Connection=mysql_connect('localhost','root','');
$Selected= mysql_select_db('tour',$Connection);

	$Query="DELETE FROM hotel
    WHERE h_id='$H_idd' " ;
			


$Execute=mysql_query($Query);

if($Execute){
    echo "<h2 >Deleted</h2>";
    header('location:deletehotel.php');
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