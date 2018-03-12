<?php
include 'config.inc.php';
$result=''; 

     if(isset($_POST['id']) && isset($_POST['rep']))
     {

			
		   	$id = $_POST['id'];
		  	$rep = $_POST['rep'];
		  
// Query database for row exist or not
$sql = "UPDATE questions SET reponse = :rep WHERE id = :id";
          $stmt = $conn->prepare($sql);
      	  $stmt->bindParam(':id', $id, PDO::PARAM_STR);
          $stmt->bindParam(':rep', $rep, PDO::PARAM_STR);
          $stmt->execute();
	  $result="true";		  
  	}
else{
$result="false";
}
echo $result;	
?>
