<?php
require "baglanti.php";
if(!empty($_POST['urun_id']&&$_POST['isim']&&$_POST['fiyat']&&$_POST['stok_bilgi']&&$_POST['depo_id'])){
$urun_id=$_POST['urun_id'];
$isim=$_POST['isim'];
$fiyat=$_POST['fiyat'];
$stok_bilgi=$_POST['stok_bilgi'];
$depo_id=$_POST['depo_id'];
if($bag){
$sql="INSERT INTO urun_bilgi(urun_id,isim,fiyat,stok_bilgi,depo_id)VALUES('".$urun_id."','".$isim."','".$fiyat."','".$stok_bilgi."','".$depo_id."')";
if(mysqli_query($bag,$sql)){
    echo "Basarili";
}
else echo "Veri Eklenemedi";
}
else echo "Veritabanina Baglanilamadi!!!";
}

?>