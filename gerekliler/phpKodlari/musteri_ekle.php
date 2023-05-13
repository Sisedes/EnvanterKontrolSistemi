<?php
require "baglanti.php";
if(!empty($_POST['musteri_ad']&&$_POST['telefon_no']&&$_POST['e_posta']&&$_POST['adres']&&$_POST['sehir_id'])){
//$musteri_id=$_POST['musteri_id'];
$musteri_ad=$_POST['musteri_ad'];
$telefon_no=$_POST['telefon_no'];
$e_posta=$_POST['e_posta'];
$adres=$_POST['adres'];
$sehir_id=$_POST['sehir_id'];
if($bag){
$sql="INSERT INTO musteri_bilgi(musteri_ad,telefon_no,e_posta,adres, sehir_id)VALUES('".$musteri_ad."','".$telefon_no."','".$e_posta."','".$adres."','".$sehir_id."')";
if(mysqli_query($bag,$sql)){
    echo "Basarili";
}
else echo "Veri Eklenemedi";
}
else echo "Veritabanina Baglanilamadi!!!";
}

?>