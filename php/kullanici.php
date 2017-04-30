<?php
error_reporting(0);
$kullaniciadi=$_POST["kullanici_adi"];
$sifre=$_POST["sifre"];
$yetki= $_POST["yetki"];
$connection= pg_connect("host=localhost port=5432 dbname=sys user=postgres password=1");
try{
$sql = "INSERT INTO kullanici (kullanici_adi, sifre, yetki) VALUES('".$kullaniciadi."','".$sifre."','".$yetki."');";
if(pg_query($connection,$sql))
echo 'insertion success';
}
catch(ErrorException $e){
	echo 'connection Failed'; $e->getMessage();
}

?>