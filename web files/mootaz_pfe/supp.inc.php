<script src="jquery-1.11.1.min.js"></script>
<script>
var cors_api_url = '';
  function doCORSRequest(options, printResult) {
    var x = new XMLHttpRequest();
    x.open(options.method, cors_api_url + options.url);
    x.onload = x.onerror = function() {
      printResult(x.responseText);
    };
    x.send(options.data);
  }
</script>
<style>
th{border: 1px solid;}
</style>
<table class="tab" style=" width: 100%; ">
<thead class="text-primary">
<tr>
<th >Id</th>
<th>nom</nom>
<th>pseudo</th>
<th>pass</th>
<th>role</th>
<th>Supprimer</th>
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
	echo '<th><button onclick="doCORSRequest({method: '."'GET',url: 'del.inc.php?id=".$row['id'] ."',}, function printResult(result) {document.getElementById('tab')".'.innerHTML = result;});">Supprimer</button></th>';
	echo '</tr>';
    				}
    				?>
    				</tbody>
    				</table>
	
