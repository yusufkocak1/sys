<?php
error_reporting(0);

$connection= pg_connect("host=localhost port=5432 dbname=sys user=postgres password=1");
try{
$sql = 'Select * from personel;';
$result=pg_query($connection,$sql);
$response = array();
while($row=pg_fetch_row($result)){
	array_push($response,array("ad"=>$row[1],"soyad"=>$row[2],"telefon"=>$row[3],"adres"=>$row[3],"tck_no"=>$row[3],"maas"=>$row[3]));
	
}
echo json_encode($response);

}
catch(ErrorException $e){
	echo 'connection Failed'; $e->getMessage();
}

?>