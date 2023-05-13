<?php
require "baglanti.php";
if(!empty($_POST['depo_id'])&&$_POST['isim']&&$_POST['sehir_id']){
$depo_id=$_POST['depo_id'];
$isim=$_POST['isim'];
$sehir_id=$_POST['sehir_id'];
if($bag){
$sql="INSERT INTO depo_bilgi(depo_id,isim,sehir_id)VALUES('".$depo_id."','".$isim."','".$sehir_id."')";
if(mysqli_query($bag,$sql)){
    echo "Basarili";
}
else echo "Veri Eklenemedi";
}
else echo "Veritabanina Baglanilamadi!!!";
}

?>