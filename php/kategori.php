
<?php
error_reporting(0);
$kat_aciklama=$_POST["kat_aciklama"];

$connection= pg_connect("host=localhost port=5432 dbname=sys user=postgres password=1");
try{
$sql = "INSERT INTO kategori (kat_aciklama) VALUES('".$kat_aciklama."');";
if(pg_query($connection,$sql))
echo 'insertion success';
}
catch(ErrorException $e){
	echo 'connection Failed'; $e->getMessage();
}

?>