<?php
error_reporting(0);

$personel_id=$_POST["personel_id"];
$siparis_zamani=$_POST["siparis_zamani"];
$miktar= $_POST["miktar"];
$fiyat= $_POST["fiyat"];
$durum= $_POST["durum"];
$aciklama = $_POST["aciklama"];

$connection= pg_connect("host=localhost port=5432 dbname=sys user=postgres password=1");
try{
$sql = "INSERT INTO siparis (personel_id, siparis_zamani, miktar, fiyat, durum, aciklama) VALUES('".$personel_id."','".$siparis_zamani."','".$miktar."','".$fiyat."','".$durum."','".$aciklama."');";
if(pg_query($connection,$sql))
echo 'insertion success';
}
catch(ErrorException $e){
	echo 'connection Failed'; $e->getMessage();
}

?>