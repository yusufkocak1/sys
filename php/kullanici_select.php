<?php
error_reporting(0);

$connection= pg_connect("host=localhost port=5432 dbname=sys user=postgres password=1");
try{
$sql = 'Select * from kullanici;';
$result=pg_query($connection,$sql);
$response = array();
while($row=pg_fetch_row($result)){
	array_push($response,array("kullanici_adi"=>$row[1],"sifre"=>$row[2],"yetki"=>$row[3]));
	
}
echo json_encode($response);

}
catch(ErrorException $e){
	echo 'connection Failed'; $e->getMessage();
}

?>