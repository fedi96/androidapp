<?php

     include 'config.inc.php';
	 
	 // Check whether username or password is set from android	
     if(isset($_POST['user']) && isset($_POST['pass']))
     {
		  // Innitialize Variable
		  $result='';
	   	  $user = $_POST['user'];
          	  $pass = $_POST['pass'];
		  $role = $_POST['role'];
		  
		  // Query database for row exist or not
          $sql = 'SELECT * FROM users WHERE  mail = :user AND pass = :pass AND role = :role';
          $stmt = $conn->prepare($sql);
          $stmt->bindParam(':user', $user, PDO::PARAM_STR);
          $stmt->bindParam(':pass', $pass, PDO::PARAM_STR);
          $stmt->bindParam(':role', $role, PDO::PARAM_STR);
          $stmt->execute();
          if($stmt->rowCount())
          {
			$result="true";	
          }  
          elseif(!$stmt->rowCount())
          {
			$result="false";
          }
		  
		  // send result back to android
   		  echo $result;
  	}
	
?>
