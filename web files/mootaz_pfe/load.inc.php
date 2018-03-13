<?php
include 'config.inc.php';
	$result="false";

     	if(isset($_POST['id'])){
		   	  $id = $_POST['id'];
			  $sqlm = 'SELECT * FROM users WHERE id = '.$id;
			  $stmtm = $conn->prepare($sqlm);
			  $stmtm->execute();
if($stmtm->rowCount()){
$stmt = $conn;
$sql = 'SELECT * FROM users WHERE id = '.$id;

foreach ($stmt->query($sql) as $row) {
$result = $row['nom'].'-'.$row['user'].'-'.$row['mail'].'-'.$row['pass'].'-'.$row['role'];
		}

}
       
}
echo $result;	
?>
