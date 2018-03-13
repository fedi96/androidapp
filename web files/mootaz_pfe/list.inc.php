<style>
th{border: 1px solid;}
</style>
<table class="table" style=" width: 100%; ">
<thead class="text-primary">
<tr>
<th >Id</th>
<th>nom</nom>
<th>pseudo</th>
<th>pass</th>
<th>role</th>
</tr>
</thead>
<tbody>
<?php
include 'config.inc.php';
$stmt = $conn;
$sql = 'SELECT * FROM users';

	foreach ($stmt->query($sql) as $row) {
	echo '<tr>';
	echo '<th>'. $row['id'] . '</th>';
	echo '<th>'. $row['nom'] . '</th>';
	echo '<th>'. $row['user'] . '</th>';
	echo '<th>'. $row['pass'] . '</th>';
	echo '<th>'. $row['role'] . '</th>';
	echo '</tr>';
    				}
    				?>
    				</tbody>
    				</table>
	
