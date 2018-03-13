<?php
include 'config.inc.php';
	$result="false";

     	if(isset($_POST['id']))
	{

		   	$user = $_POST['user'];
			$id = $_POST['id'];
		  	$pass = $_POST['pass'];
			$mail = $_POST['email'];
			$nom = $_POST['nom'];
			$role = $_POST['role'];

			  $sqlm = 'SELECT * FROM users WHERE mail = :mail AND id != '.$id;
			  $stmtm = $conn->prepare($sqlm);
			  $stmtm->bindParam(':mail', $mail, PDO::PARAM_STR);
			  $sqlu = 'SELECT * FROM users WHERE user = :user AND id != '.$id;
			  $stmtu = $conn->prepare($sqlu);
			  $stmtu->bindParam(':user', $user, PDO::PARAM_STR);
			  $sqln = 'SELECT * FROM users WHERE nom = :nom AND id != '.$id;
			  $stmtn = $conn->prepare($sqln);
			  $stmtn->bindParam(':nom', $nom, PDO::PARAM_STR);
			  $stmtm->execute();
			  $stmtu->execute();
			  $stmtn->execute();
	
    if($stmtm->rowCount()){
		$result="mail";
		}
else if($stmtu->rowCount()){
		$result="user";
		}
	else if($stmtn->rowCount()){
		$result="nom";
		}
	else{		
$sql = "UPDATE users SET nom=:nom,user=:user,pass=:pass,mail=:mail,role=:role WHERE id=:id";
$stmt = $conn->prepare($sql);
$stmt->bindParam(':nom', $nom, PDO::PARAM_STR);
$stmt->bindParam(':role', $role, PDO::PARAM_STR);
$stmt->bindParam(':id', $id, PDO::PARAM_STR);
$stmt->bindParam(':user', $user, PDO::PARAM_STR);
$stmt->bindParam(':pass', $pass, PDO::PARAM_STR);
$stmt->bindParam(':mail', $mail, PDO::PARAM_STR);
$stmt->execute();
$result="true";
	}	}

echo $result;	
?>
