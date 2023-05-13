<?php
require "baglanti.php";
if(!empty($_POST['musteri_id']&&$_POST['urun_id']&&$_POST['alis_sekli'])&&$_POST['urun_adet']){
$musteri_id=$_POST['musteri_id'];
$urun_id=$_POST['urun_id'];
$alis_sekli=$_POST['alis_sekli'];
$urun_adet=$_POST['urun_adet'];
if($bag){
$sql="INSERT INTO satis_bilgi(musteri_id,urun_id,alis_sekli,urun_adet)VALUES('".$musteri_id."','".$urun_id."','".$alis_sekli."','".$urun_adet."')";
if(mysqli_query($bag,$sql)){
    echo "Basarili";
}
else echo "Veri Eklenemedi";
}
else echo "Veritabanina Baglanilamadi!!!";
}

?>