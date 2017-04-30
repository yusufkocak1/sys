<?php
error_reporting(0);
$hesap=$_POST["hesap"];
$sipariskod= $_POST["sipariskod"];
$connection= pg_connect("host=localhost port=5432 dbname=sys user=postgres password=1");
try{
$sql = "INSERT INTO masa (hesap, sipariskod) VALUES('".$hesap."','".$sipariskod."',);";
if(pg_query($connection,$sql))
echo 'insertion success';
}
catch(ErrorException $e){
	echo 'connection Failed'; $e->getMessage();
}

?>
