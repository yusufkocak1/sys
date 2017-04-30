
<?php
error_reporting(0);

$connection= pg_connect("host=localhost port=5432 dbname=sys user=postgres password=1");
try{
$sql = 'Select * from siparis;';
$result=pg_query($connection,$sql);
$response = array();
while($row=pg_fetch_row($result)){
	array_push($response,array("personel_id"=>$row[1],"siparis_zamani"=>$row[2],"miktar"=>$row[3],"durum"=>$row[3],"fiyat"=>$row[3],"aciklama"=>$row[3]));
	
}
echo json_encode($response);

}
catch(ErrorException $e){
	echo 'connection Failed'; $e->getMessage();
}

?>