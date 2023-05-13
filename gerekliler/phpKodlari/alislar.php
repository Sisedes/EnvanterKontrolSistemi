<?php
include "baglanti.php";
$query = "SELECT * FROM alis_bilgi";
$result = mysqli_query($bag, $query);

$rows = array();
while ($row = mysqli_fetch_assoc($result)) {
    $rows[] = $row;
}
echo json_encode($rows);
mysqli_close($bag);
?>
