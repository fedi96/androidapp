<?php
include 'config.inc.php';
	$result="false";
// Check whether username or password is set from android	
     	if(isset($_POST['user']))
	{
// Innitialize Variable
		   	$user = $_POST['user'];
		  	$pass = $_POST['pass'];
			$mail = $_POST['email'];
			$nom = $_POST['nom'];
			$role = $_POST['role'];
// Query database for row exist or not
			  $sqlm = 'SELECT * FROM users WHERE mail = :mail';
			  $stmtm = $conn->prepare($sqlm);
			  $stmtm->bindParam(':mail', $mail, PDO::PARAM_STR);
			  $sqlu = 'SELECT * FROM users WHERE user = :user';
			  $stmtu = $conn->prepare($sqlu);
			  $stmtu->bindParam(':user', $user, PDO::PARAM_STR);
			  $sqln = 'SELECT * FROM users WHERE nom = :nom';
			  $stmtn = $conn->prepare($sqln);
			  $stmtn->bindParam(':nom', $nom, PDO::PARAM_STR);
			  $stmtm->execute();
			  $stmtu->execute();
			  $stmtn->execute();
}
          if($stmtm->rowCount()){
		$result="mail";
		}
	else if($stmtu->rowCount()){
		$result="user";
		}
	else if($stmtn->rowCount()){
		$result="nom";
		}
	else{		$sql = "INSERT INTO users(nom,user,pass,mail,role) VALUES('$nom','$user','$pass','$mail','$role')";
          		$stmt = $conn->prepare($sql);
          		$stmt->execute(array($nom,$user,$pass,$mail,$role));
	  		$result="true";
	}

echo $result;	
?>
