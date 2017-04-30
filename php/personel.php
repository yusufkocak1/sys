<?php
error_reporting(0);
$ad=$_POST["ad"];
$soyad=$_POST["soyad"];
$telefon= $_POST["telefon"];
$adres= $_POST["adres"];
$tck_no= $_POST["tck_no"];
$maas = $_POST["maas"];
$connection= pg_connect("host=localhost port=5432 dbname=sys user=postgres password=1");
try{
$sql = "INSERT INTO personel (ad, soyad, telefon, adres, tck_no, maas) VALUES('".$ad."','".$soyad."','".$telefon."','".$adres."','".$tck_no."','".$maas."');";
if(pg_query($connection,$sql))
echo 'insertion success';
}
catch(ErrorException $e){
	echo 'connection Failed'; $e->getMessage();
}

?>