<?php
error_reporting(0);
$urun_adi=$_POST["urun_adi"];
$fiyat=$_POST["fiyat"];
$kategori= $_POST["kategori"];
$connection= pg_connect("host=localhost port=5432 dbname=sys user=postgres password=1");
try{
$sql = "INSERT INTO urunler (urun_adi, fiyat, kategori) VALUES('".$urun_adi."','".$fiyat."','".$kategori."');";
if(pg_query($connection,$sql))
echo 'insertion success';
}
catch(ErrorException $e){
	echo 'connection Failed'; $e->getMessage();
}

?>