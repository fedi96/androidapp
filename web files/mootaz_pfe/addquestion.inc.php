<?php
include 'config.inc.php';
$result=''; 
// Check whether username or password is set from android	
     if(isset($_POST['user']))
     {
// Innitialize Variable
			
		   	$user = $_POST['user'];
		  	$question = $_POST['question'];
		  
// Query database for row exist or not
$sql = "INSERT INTO questions(question,user) VALUES('$question','$user')";
          $stmt = $conn->prepare($sql);
          $stmt->execute(array($question,$user));
	  $result="true";		  
  	}
else{
$result="false";
}
echo $result;	
?>
