<?php
include_once('login1.php');
mysql_connect('localhost','root','');
mysql_select_db('tour');


?>

<!DOCTYPE >
<html html lang="en">
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="user.css">
        <title>About us</title>
        <style>
            .x{
                background-color:white;
                
            }
            main{
  height: 630px;
  background-color: rgb(250, 226, 189);
  min-width: fit-content;
}

            </style>
    </head>
    
    <body style="background-color:lightblue;">

        <header>
           
                <img src="logo.jpg" heigth="90px" width="90px">
                Choose Your Dream Destination with <u>TROUVAILLE</u></header>
                <main  >
                    <h2 style="text-align: center; color:maroon; font-size: 50px;">Details</h2>
                    <a href="logout.php" style="text-align:center"><h2>Logout</h2></a>

                    <?php
                   
                  
        $query="(select * from package as p , customer as c where c.email='191210050@nitdelhi.ac.in' and c.p_id=p.p_id )";
        $result=mysql_query($query);

    ?>
    <table class="x"  align="center"; border="2px">
        <tr>
        
            <tr>
                <td>Package_id</td>
                <td>Package_Name</td>
                <td>Amount</td>
              
                <tr>

                <?php

while($rows=mysql_fetch_assoc($result))
{
?>    
<tr>

<td><?php echo $rows['p_id']; ?></td>
<td><?php echo $rows['p_name']; ?></td>
<td><?php echo $rows['amount']; ?></td>
</tr>
<?php
} 
?>
    

    </table>
    </main>
    <!--<footer class="foot">
    <nav>    
          <a href="dbms.php">HOME</a>
          <a href="index.php">PACKAGES</a>
          <a href="about.php">ABOUT-Us/Contact-Us</a>
          <a href="offers.php">OFFERS</a>
          <a href="faq.php">FAQs</a>     
    </nav>
    </footer>-->
     <!--<td><?php echo $rows['nights']; ?></td>
    <td><?php echo $rows['h.h_name']; ?></td>
    <td><?php echo $rows['h.type']; ?></td>
    <td><?php echo $rows['h.address']; ?></td>
    <td><?php echo $rows['t.t_name']; ?></td>
    <td><?php echo $rows['t.to1']; ?></td>
    <td><?php echo $rows['t.from1']; ?></td>
    <td><?php echo $rows['g.g_name']; ?></td>-->
     <!--  <td>No-of-Nights</td>
     <td>Hotel-name</td>
                <td>Hotel_type</td>
                <td>Address</td>
                <td>Train Name</td>
                <td>To</td>
                <td>From</td>
                <td>Guide-name</td>-->
    </body>
</html>
