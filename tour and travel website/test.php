<?php
mysql_connect('localhost','root','');
mysql_select_db('tour');

?>



<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
        $query="(select * from package )";
        $result=mysql_query($query);

    ?>
    <table align="center" border="2px" >
        <tr>
            <td colspan="4">Package details</td>
            <tr>
                <td>P_id</td>
                <td>P_Name</td>
                <td>Amount</td>
                <td>Offer_id</td>
                <tr>

    <?php

        while($rows=mysql_fetch_assoc($result))
        {
    ?>    
    <tr>

    <td><?php echo $rows['p_id']; ?></td>
    <td><?php echo $rows['p_name']; ?></td>
    <td><?php echo $rows['amount']; ?></td>
    <td><?php echo $rows['offer_id']; ?></td></tr>s
        <?php
        } 
    ?>
</body>
</html>