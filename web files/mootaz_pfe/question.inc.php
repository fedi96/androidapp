
<?php
include 'config.inc.php';
$stmt = $conn;
$sql = 'SELECT * FROM questions';
$a="pas de reponse";
	foreach ($stmt->query($sql) as $row) {
	echo '<p><h3><u>Question N '. $row['id'] . ' :</u></h3>';
	echo '<b><i>'. $row['question'] . ' ?<i></b>';
	echo '<h3><u>Reponse :</u></h3>';
if($row['reponse']){
	echo '<b>'. $row['reponse'] . '</b>';
}else{
	echo '<b>'. $a . '</b>';
}
	echo '<h3>Par '. $row['user'] . '</h3>';
	echo '<p><hr >';
    				}
    				?>
    				</tbody>
    				</table>
	
