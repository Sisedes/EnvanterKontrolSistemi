<?php
require "baglanti.php";

if(!empty($_POST['musteri_id']&&$_POST['musteri_ad']&&$_POST['telefon_no']&&$_POST['e_posta']&&$_POST['adres']&&$_POST['sehir_id'])){
    $musteri_id=$_POST['musteri_id'];
    $musteri_ad=$_POST['musteri_ad'];
    $telefon_no=$_POST['telefon_no'];
    $e_posta=$_POST['e_posta'];
    $adres=$_POST['adres'];
    $sehir_id=$_POST['sehir_id'];

    if($bag)
    {
        $sql="UPDATE musteri_bilgi set musteri_ad ='".$musteri_ad."',telefon_no='".$telefon_no."',e_posta='".$e_posta."',adres='".$adres."',sehir_id='".$sehir_id."' WHERE musteri_id = ". $musteri_id;
        if(mysqli_query($bag,$sql))
        {
            echo "Guncellendi.";
        }else echo "Guncellenemedi";
    }else echo "Veritabanina Baglanmadi";

}
?>