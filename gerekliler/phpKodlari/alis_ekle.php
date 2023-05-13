<?php
require "baglanti.php";
if(!empty($_POST['satici_id']&&$_POST['urun_id']&&$_POST['urun_adet'])){
//$alis_id=$_POST['alis_id'];
$satici_id=$_POST['satici_id'];
$urun_id=$_POST['urun_id'];
$urun_adet=$_POST['urun_adet'];
if($bag){
$sql="INSERT INTO alis_bilgi(satici_id,urun_id,urun_adet)VALUES('".$satici_id."','".$urun_id."','".$urun_adet."')";
if(mysqli_query($bag,$sql)){
    echo "Basarili";
}
else echo "Veri Eklenemedi";
}
else echo "Veritabanina Baglanilamadi!!!";
}

?>