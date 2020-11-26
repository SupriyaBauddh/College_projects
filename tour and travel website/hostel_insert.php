<!DOCTYPE>
<html>
	<head>
		<title>Hostel Insert</title>
		<link href="css/bootstrap-4.4.1.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" href="css/visitor_style.css">
	</head>
	<style media="screen">
	</style>
	<body>
		<button type="button" class="btn btn-dark btn-lg" onclick="window.location.href='admin_login.php'" >Home</button>
<div>
	<br><br>	
	<form class="" action="" method="post">
		<fieldset>
			<span class="FieldInfo">Hostel id</span>
			<br>
			<input type="text" name="Hostel_id" value="">
			<br>
			<span class="FieldInfo">No of rooms</span>
			<br>
			<input type="text" name="No_of_rooms" value="">
			<br>
			<span class="FieldInfo">No of Students</span>
			<br>
			<input type="text" name="No_of_students" value="">
			<br>
			<span class="FieldInfo">Location</span>
			<br>
			<input type="text" name="Location" value="">
			<br>
			<span class="FieldInfo">Hostel Name</span>
			<br>
			<input type="text" name="Hostel_Name" value="">
			<br>
			<span class="FieldInfo">Rooms Vacant</span>
			<br>
			<input type="" name="Rooms_Vacant" value="">
			<br>
			<button type="Submit" name="Submit" value="Submit your record">SUBMIT</button>
		</fieldset>
	</form>
</div>
<?php 
if(isset($_POST["Submit"]))
{
	$Hostel_id =$_POST["Hostel_id"];
		$No_of_rooms =$_POST["No_of_rooms"];
		$No_of_students =$_POST["No_of_students"];
		$Location =$_POST["Location"];
		$Hostel_Name=$_POST["Hostel_Name"];
		$Rooms_Vacant=$_POST["Rooms_Vacant"];

$Connection=mysql_connect('localhost','root','');
$Selected= mysql_select_db('dbms',$Connection);

	$Query="INSERT INTO hostel
			VALUE('$Hostel_id','$No_of_rooms','$No_of_students','$Location','$Hostel_Name','$Rooms_Vacant')" ;

$Execute=mysql_query($Query);

if($Execute){
	echo "<h2>Record saved </h2>";
}
}
 ?>
	</body>
</html>